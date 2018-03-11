package com.ibase.web.localworkparam.mapper;

import java.util.List;

import com.ibase.web.localworkparam.domain.Collocation;

public interface CollocationMapper {

	// 查询所有配置
	List<Collocation> queryCollocations(Collocation collocation);
	//记录条数
	Integer countCollocations();
	//删除
	long deleteCollocationById(Integer collocationId);
	//添加
	long insertCollocation(Collocation collocation);
	//修改
	long updateCollocation(Collocation collocation);
}
