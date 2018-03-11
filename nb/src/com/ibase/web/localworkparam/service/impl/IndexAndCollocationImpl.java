package com.ibase.web.localworkparam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibase.web.localworkparam.domain.Collocation;
import com.ibase.web.localworkparam.domain.IndexAndCollocation;
import com.ibase.web.localworkparam.mapper.IndexAndCollocationMapper;
import com.ibase.web.localworkparam.service.IndexAndCollocationService;

@Service
public class IndexAndCollocationImpl implements IndexAndCollocationService {
	@Autowired
	IndexAndCollocationMapper indexAndCollocationMapper;

	@Override
	public List<Collocation> queryCollocationsById(Integer indexId) {
		
		return indexAndCollocationMapper.queryCollocationsById(indexId);
	}

	@Override
	public int insertIndexAndCollocation(IndexAndCollocation indexAndCollocation) {
		int value = indexAndCollocationMapper.insertIndexAndCollocation(indexAndCollocation);
				System.out.println(value);
		return value ;
	}

	@Override
	public List<Collocation> queryNoCollocationsById(Integer indexId) {
		
		return indexAndCollocationMapper.queryNoCollocationsById(indexId);
	}

	@Override
	public boolean deleteIndexAndCollocation(IndexAndCollocation indexAndCollocation) {
	
		return indexAndCollocationMapper.deleteIndexAndCollocation(indexAndCollocation)>0;
	}

	@Override
	public boolean updateIndexAndCollocation(IndexAndCollocation indexAndCollocation) {
		
		return indexAndCollocationMapper.updateIndexAndCollocation(indexAndCollocation)>0;
	}
}
