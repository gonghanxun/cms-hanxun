package com.gonghanxun.cms.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gonghanxun.cms.dao.ArticleRep;
import com.gonghanxun.cms.entity.Article;
import com.gonghanxun.cms.entity.Category;
import com.gonghanxun.cms.entity.Channel;
import com.gonghanxun.cms.entity.Slide;
import com.gonghanxun.cms.service.ArticleService;
import com.gonghanxun.cms.utils.HLUtils;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author hanxun
 *
 */
@Controller
public class IndexController {
	
	@Autowired
	ArticleService articleService;
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws InterruptedException 
	 */
	
	@Autowired
	RedisTemplate redisTemplate;
	
	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;
	
	//注入es仓库
	@Autowired
	ArticleRep articleRep;
	
	
	//es搜索的方法
		@GetMapping("index")
		public String search(String key,Model model,HttpServletRequest request,@RequestParam(defaultValue="1") int page) {
			Thread  t1 =  new Thread() {
				public void run() {
			// 获取所有的栏目
			List<Channel> channels = articleService.getChannels();
			request.setAttribute("channels", channels);
				};
			};
			t1.start();
			
			//获取热点文章
			//reids作为缓冲优化热点文章
			Thread  t2 =  new Thread() {
				public void run() {
			// 获取热门文章
			PageInfo<Article> articlePage= articleService.hotList(page);
			request.setAttribute("articlePage", articlePage);
				};
			};
			t2.start();
			
			Thread  t3 =  new Thread() {
				public void run() {
			// 获取最新文章
			//0.redis作为缓存来优化最新文章
			//1.先从reids中查询有没有最新文章
					List<Article> redisArticle = redisTemplate.opsForList().range("new_articles", 0, -1);
					
					if(redisArticle==null||redisArticle.size()==0) {
						//2.判断redis中查询的是否为空（有没有最新文章）
						//3.如果为空
						//4.就从mysql中查询最新文章，就放入redis，并返回前台
						List<Article> lastArticles = articleService.lastList();
						System.out.println("从mysql中查询了最新文章。。。");
						redisTemplate.opsForList().leftPushAll("new_articles", lastArticles.toArray());
						redisTemplate.expire("new_articles", 5, TimeUnit.MINUTES);
						//返回前台
						request.setAttribute("lastArticles", lastArticles);
					}else {
						//5.如果不为空，直接返回前台
						System.out.println("从redis中查询了最新文章。。。");
						request.setAttribute("lastArticles", redisArticle);
					}
				};
			};
			t3.start();
			//利用es的仓库来查询(无高亮)
			/*List<Article> list = articleRep.findByTitle(key);
			PageInfo<Article> pageInfo=new PageInfo<>(list);
			model.addAttribute("articlePage", pageInfo);*/
			//利用es实现高亮HighLight
			PageInfo<Article> pageInfo = (PageInfo<Article>) HLUtils.findByHighLight(elasticsearchTemplate, Article.class, page, 2, new String[] {"title"}, "id", key);
			model.addAttribute("articlePage", pageInfo);
			model.addAttribute("key", key);
			return "index";
		}
	
	
	@RequestMapping(value= {"index","/"})
	public String index(HttpServletRequest request,@RequestParam(defaultValue="1") int page) throws InterruptedException {
		
		Thread  t1 =  new Thread() {
			public void run() {
		// 获取所有的栏目
		List<Channel> channels = articleService.getChannels();
		request.setAttribute("channels", channels);
			};
		};
		
		Thread  t2 =  new Thread() {
			public void run() {
		// 获取热门文章
		PageInfo<Article> articlePage= articleService.hotList(page);
		request.setAttribute("articlePage", articlePage);
			};
		};
		
		Thread  t3 =  new Thread() {
			public void run() {
				// 获取最新文章
				//0.redis作为缓存来优化最新文章
				//1.先从reids中查询有没有最新文章
				List<Article> redisArticle = redisTemplate.opsForList().range("new_articles", 0, -1);
				
				if(redisArticle==null||redisArticle.size()==0) {
					//2.判断redis中查询的是否为空（有没有最新文章）
					//3.如果为空
					//4.就从mysql中查询最新文章，就放入redis，并返回前台
					List<Article> lastArticles = articleService.lastList();
					System.out.println("从mysql中查询了最新文章。。。");
					redisTemplate.opsForList().leftPushAll("new_articles", lastArticles.toArray());
					redisTemplate.expire("new_articles", 5, TimeUnit.MINUTES);
					//返回前台
					request.setAttribute("lastArticles", lastArticles);
				}else {
					//5.如果不为空，直接返回前台
					System.out.println("从redis中查询了最新文章。。。");
					request.setAttribute("lastArticles", redisArticle);
				}
			};
		};
		
		Thread  t4 =  new Thread() {
			public void run() {
		// 轮播图
		List<Slide> slides = articleService.getSlides();
		request.setAttribute("slides", slides);
		
			};
		};
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		
		return "index";
		
	}
	
	/**
	 * 
	 * @param request  请求
	 * @param channleId  栏目的id
	 * @param catId 分类的id
	 * @param page 页码
	 * @return
	 * @throws InterruptedException 
	 */
	@RequestMapping("channel")
	public String channel(HttpServletRequest request,
			int channelId,
			@RequestParam(defaultValue="0") int catId,
			@RequestParam(defaultValue="1")  int page) throws InterruptedException {
		
		Thread  t1 =  new Thread() {
			public void run() {
		// 获取所有的栏目
		List<Channel> channels = articleService.getChannels();
		request.setAttribute("channels", channels);
			};
		};
		
		Thread  t2 =  new Thread() {
			public void run() {
		// 当前栏目下  当前分类下的文章
		PageInfo<Article> articlePage= articleService.getArticles(channelId,catId, page);
		request.setAttribute("articlePage", articlePage);
			};
		};
		
		Thread  t3 =  new Thread() {
			public void run() {
		// 获取最新文章
		List<Article> lastArticles = articleService.lastList();
		request.setAttribute("lastArticles", lastArticles);
			};
		};
		
		Thread  t4 =  new Thread() {
			public void run() {
		// 轮播图
		List<Slide> slides = articleService.getSlides();
		request.setAttribute("slides", slides);
		
			};
		};
		
		// 获取当前栏目下的所有的分类 catId
		Thread  t5 =  new Thread() {
			public void run() {
		// 
		List<Category> categoris= articleService.getCategoriesByChannelId(channelId);
		request.setAttribute("categoris", categoris);
		System.err.println("categoris is " + categoris);
			};
		};
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		
		// 参数回传
		request.setAttribute("catId", catId);
		request.setAttribute("channelId", channelId);
		
		return "channel";
	}
}
