package com.ibase.web.localworkparam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibase.web.localworkparam.domain.Index;
import com.ibase.web.localworkparam.domain.queryAllDao.QueryIndex;
import com.ibase.web.localworkparam.mapper.IndexMapper;
import com.ibase.web.localworkparam.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService {
	
	@Autowired
	IndexMapper indexMapper;

	@Override
	public List<Index> queryIndexes(Index index) {
		
		int currentPage = index.getPage().getCurrentPage();
		int pageSize = index.getPage().getPageSize();
		index.getPage().setTotalRows((int)countIndex());
		
		System.out.println(index.getPage().getTotalRows());
		System.out.println("小区表总条目count："+countIndex());
		
		index.getPage().setStartNum((currentPage - 1) * pageSize);
		index.getPage().setEndIndex(pageSize);
		List<Index> indexes = indexMapper.queryIndexes(index);
		return indexes;
	}

	@Override
	public Integer countIndex() {
		return indexMapper.countIndex();
	}

	@Override
	public List<Index> selectIndex(Index index) {
		return indexMapper.selectIndex(index);
	}

	@Override
	public boolean insertIndex(Index index) {
		
		return indexMapper.insertIndex(index)>0;
	}

	@Override
	public boolean updateIndex(Index index) {
		
		return indexMapper.updateIndex(index)>0;
	}

	@Override
	public boolean deleteIndex(Integer indexId) {
		// TODO Auto-generated method stub
		return indexMapper.deleteIndex(indexId)>0;
	}
	@Override
	public List<Index> queryIndexesByCellId(long cellId) {
		return indexMapper.queryIndexesByCellId(cellId);
	}

	@Override
	public List<QueryIndex> queryIndexeByCellId(long cellId) {
		return indexMapper.queryIndexeByCellId(cellId);
	}
	
}
