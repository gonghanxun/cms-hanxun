package com.gonghanxun.cms.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gonghanxun.cms.common.CmsUtils;
import com.gonghanxun.cms.dao.UserMapper;
import com.gonghanxun.cms.entity.User;
import com.gonghanxun.cms.service.UserService;

/**
 * 
 * @author hanxun
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper userMapper;

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.findUserByName(username);
	}

	@Override
	public int register(@Valid User user) {
		// TODO Auto-generated method stub
		// 计算密文
		String encryPwd = CmsUtils.encry(user.getPassword(),user.getUsername());
		
		user.setPassword(encryPwd);
		return userMapper.add(user);
	}

	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		user.setPassword(CmsUtils.encry(user.getPassword(), user.getUsername() ));
		User loginUser  = userMapper.findByPwd(user);
		return loginUser;
	}

}
