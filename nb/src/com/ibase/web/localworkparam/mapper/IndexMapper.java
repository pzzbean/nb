package com.ibase.web.localworkparam.mapper;

import java.util.List;

import com.ibase.web.localworkparam.domain.Index;
import com.ibase.web.localworkparam.domain.queryAllDao.QueryIndex;

public interface IndexMapper {
	// 查询所有指标
	List<Index> queryIndexes(Index index);
	
	// 模糊查询
	List<Index> selectIndex(Index index);
	
	// 记录条数
	Integer countIndex();
	//插入指标
	long insertIndex(Index index);
	//修改指标
	long updateIndex(Index index);

	long deleteIndex(Integer indexId);

	List<Index> queryIndexesByCellId(long cellId);

	List<QueryIndex> queryIndexeByCellId(long cellId);
}
