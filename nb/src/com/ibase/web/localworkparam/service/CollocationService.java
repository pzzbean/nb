package com.ibase.web.localworkparam.service;

import java.util.List;

import com.ibase.web.localworkparam.domain.Collocation;

public interface CollocationService {
	
	//查询所有配置
	List<Collocation> queryCollocations(Collocation collocation);
	//记录条数
	Integer countCollocations();
	//删除
	boolean deleteCollocationById(Integer collocationId);
	//添加
	boolean insertCollocation(Collocation collocation);
	//修改
	boolean updateCollocation(Collocation collocation);

}
