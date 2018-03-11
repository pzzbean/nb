package com.ibase.web.testplan.service;

import java.util.List;

import com.ibase.web.roadtest.domain2.Station_new;
import com.ibase.web.testplan.domain.TemporaryTestplan;

public interface TemporaryTestplanService {
	
	//查询所有测试计划
	List<TemporaryTestplan> queryTemporaryTestplans();
	
	//模糊查询，根据测试人员姓名、测试人电话、测试基站、测试时间查询
	List<TemporaryTestplan> queryTemporaryTestplansByCondition(TemporaryTestplan temporaryTestplan);
	
	//增加
	int insertTemporaryTestPlans(TemporaryTestplan temporaryTestplan);
		
	//删
	int delTemporaryTestPlans(long temporaryTestplanId);
	
	//改
	int updTemporaryTestPlans(TemporaryTestplan temporaryTestplan,long temporaryTestplanId);
	//查询基站号
	List<Station_new> selectAllStation(String userId ,String testStartTime);

}
