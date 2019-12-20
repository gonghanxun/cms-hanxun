package com.gonghanxun.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gonghanxun.cms.entity.User;

@Controller
@RequestMapping("demo")
public class DemoController {
	
	@RequestMapping("toggle")
	public String toggle() {
		return "demo/toggle";
	}

	
	//处理登录  , produces = "application/json; charset=utf-8"
    @RequestMapping(value="login")
    public @ResponseBody ResponseData login(HttpServletRequest request, @RequestParam( "email") String email,
            @RequestParam("password") String password) {
        
        
        ResponseData responseData = ResponseData.ok();
        //先到数据库验证
       
       // if(null != loginId) {
       
		if(password.equals(email)) {
            //User user = new User();
			User user = new User();
            //给用户jwt加密生成token
            String token = JWT.sign(user, 60L* 1000L* 30L);
            //封装成对象返回给客户端
            responseData.putDataValue("loginId", user.getId());
            responseData.putDataValue("token", token);
            responseData.putDataValue("user", user);
        }
        else{
            responseData =  ResponseData.customerError();
        }   
        return responseData;
    }
    
}
