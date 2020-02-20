package com.gonghanxun.cms.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.gonghanxun.cms.entity.Article;

public interface ArticleRep extends ElasticsearchCrudRepository<Article, Integer> {
	//根据标题查询
	List<Article> findByTitle(String key);
}
