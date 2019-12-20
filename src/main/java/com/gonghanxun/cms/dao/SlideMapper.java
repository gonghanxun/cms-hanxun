package com.gonghanxun.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.gonghanxun.cms.entity.Slide;

/**
 * 轮播图管理
 * @author hanxun
 *
 */
public interface SlideMapper {

	@Select("SELECT id,title,picture,url FROM cms_slide ORDER BY id ")
	List<Slide> list();

}
