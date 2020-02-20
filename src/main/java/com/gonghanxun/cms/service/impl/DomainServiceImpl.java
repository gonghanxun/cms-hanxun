package com.gonghanxun.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gonghanxun.cms.dao.DomainMapper;
import com.gonghanxun.cms.entity.Domain;
import com.gonghanxun.cms.service.DomainService;
@Service
public class DomainServiceImpl implements DomainService {
	@Autowired
	DomainMapper mapper;

	@Override
	public List<Domain> list() {
		// TODO Auto-generated method stub
		return mapper.list();
	}
}
