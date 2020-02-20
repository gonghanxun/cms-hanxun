package com.gonghanxun.cms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gonghanxun.cms.entity.Domain;
import com.gonghanxun.cms.service.DomainService;
import com.gonghanxun.cms.utils.StringUtils;
@Controller
public class DomainController {
	
	
	@Autowired
	DomainService service;
	
	@RequestMapping("list")
	public String ifDomain(HttpServletRequest request,
			@ModelAttribute("Domain") @Valid Domain domain,Model model,
			MultipartFile file,BindingResult result,@RequestParam(defaultValue="1") int pageNum) {
		
		if(!StringUtils.isHttpUrl(domain.getUrl())) {
			result.rejectValue("srcUrl", "", "不是合法的url地址");
		}
		if(result.hasErrors()) {
			return "article/domain";
		}
		PageHelper.startPage(pageNum, 5);
		List<Domain> list = service.list();
		PageInfo<Domain> info = new PageInfo<>(list);
		model.addAttribute("list", list);
		model.addAttribute("info", info);
		
		return "user/comment/list";
	}
	
}
