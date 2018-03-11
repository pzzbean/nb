package com.ibase.web.localworkparam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibase.web.localworkparam.domain.Collocation;
import com.ibase.web.localworkparam.mapper.CollocationMapper;
import com.ibase.web.localworkparam.service.CollocationService;

@Service
public class CollocationServiceImpl implements CollocationService {
	
	@Autowired
	CollocationMapper collocationMapper;
	
	@Override
	public List<Collocation> queryCollocations(Collocation collocation) {
		
		int currentPage = collocation.getPage().getCurrentPage();
		int pageSize = collocation.getPage().getPageSize();
		collocation.getPage().setTotalRows(countCollocations());
		collocation.getPage().setStartNum((currentPage - 1) * pageSize);
		collocation.getPage().setEndIndex(pageSize);
		List<Collocation> collocations = collocationMapper.queryCollocations(collocation);
		return collocations;
	}

	@Override
	public Integer countCollocations() {
		return collocationMapper.countCollocations();
	}

	@Override
	public boolean deleteCollocationById(Integer collocationId) {
		
		
		return collocationMapper.deleteCollocationById(collocationId)>0;
	}

	@Override
	public boolean insertCollocation(Collocation collocation) {
		// TODO Auto-generated method stub
		return collocationMapper.insertCollocation(collocation)>0;
	}

	@Override
	public boolean updateCollocation(Collocation collocation) {
		// TODO Auto-generated method stub
		return collocationMapper.updateCollocation(collocation)>0;
	}
	
	

}
