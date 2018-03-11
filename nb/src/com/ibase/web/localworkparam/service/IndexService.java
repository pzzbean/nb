package com.ibase.web.localworkparam.service;

import java.util.List;

import com.ibase.web.localworkparam.domain.Index;
import com.ibase.web.localworkparam.domain.queryAllDao.QueryIndex;

public interface IndexService {
	// 查询所有指标
	List<Index> queryIndexes(Index index);

	// 模糊查询
	List<Index> selectIndex(Index index);

	// 记录条数
	Integer countIndex();

	// 添加指标
	boolean insertIndex(Index index);

	// 修改指标
	boolean updateIndex(Index index);

	boolean deleteIndex(Integer indexId);

	// 根据小区id查询对应的所有指标
	List<Index> queryIndexesByCellId(long cellId);
	
	List<QueryIndex> queryIndexeByCellId(long cellId);
}
