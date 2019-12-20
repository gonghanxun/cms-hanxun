package com.gonghanxun.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.gonghanxun.cms.common.CmsContant;
import com.gonghanxun.cms.entity.User;

/**
 * 拦截器 判断用户是否已经登录  
 * @author hanxun
 *
 */
public class CmsInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// TODO Auto-generated method stub
		User loginUser = (User)request.getSession().getAttribute(CmsContant.USER_KEY);
		if(loginUser == null)
		{
			//request.s
			response.sendRedirect("/user/login");
			//request.getRequestDispatcher("/user/login").forward(request, response);
			return false;
		}
		
		//放行 
		return true;
		
		
	}
	
}
