package com.gonghanxun.cms.dao;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.gonghanxun.cms.entity.User;

/**
 * 
 * @author hanxun
 *
 */
public interface UserMapper {

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	@Select(" SELECT id,username,password FROM cms_user "
			+ " WHERE username = #{value} limit 1")
	User findUserByName(String username);

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@Insert("INSERT INTO cms_user(username,password,locked,create_time,score,role)"
			+ " VALUES(#{username},#{password},0,now(),0,0)")
	int add(@Valid User user);

	/**
	 *根据用户名和密码查询用户 登录操作 
	 * @param user
	 * @return
	 */
	@Select("SELECT id,username,password,nickname,birthday,"
			+ "gender,locked,create_time createTime,update_time updateTime,url,"
			+ "role FROM cms_user WHERE username=#{username}  AND password = #{password} "
			+ " LIMIT 1")
	User findByPwd(User user);
	

}
