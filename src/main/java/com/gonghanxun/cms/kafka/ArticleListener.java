package com.gonghanxun.cms.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.MessageListener;

import com.alibaba.fastjson.JSON;
import com.gonghanxun.cms.entity.Article;
import com.gonghanxun.cms.service.ArticleService;

//当我启动cms，自动启动监听
public class ArticleListener implements MessageListener<String, String> {
	@Autowired
	ArticleService articleService;
	//这个方法，就是舰艇消息的方法
	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		//接受稍息
		String jsonString = data.value();
		System.out.println("收到了消息！！！！！！！");
		//把json类型给的串，装成article对象
		Article article = JSON.parseObject(jsonString,Article.class);
		article.setChannelId(1);
		
		
		
		//保存到mysql的数据库中
		articleService.add(article);
	}
	
}
