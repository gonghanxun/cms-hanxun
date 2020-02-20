package com.gonghanxun;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gonghanxun.cms.dao.ArticleMapper;
import com.gonghanxun.cms.dao.ArticleRep;
import com.gonghanxun.cms.entity.Article;
import com.gonghanxun.cms.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class ImportMysql2ES {

	@Autowired
	ArticleMapper articleMapper;
	@Autowired
	ArticleRep articleRep;
	@Test
	public void importMusql2es() {
		//1.从mysql中查询出已经审核通过的文章
		List<Article> findAllArticlesWithStatus = articleMapper.findAllArticlesWithStatus(1);
		//2.查询出来的文章保存到es索引库
		articleRep.saveAll(findAllArticlesWithStatus);
		
	}
	
}
