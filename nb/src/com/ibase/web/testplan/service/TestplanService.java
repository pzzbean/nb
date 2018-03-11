package com.ibase.web.testplan.service;

import java.util.List;
import java.util.Map;

import com.ibase.web.localworkparam.domain.Station;
import com.ibase.web.localworkparam.domain.StationProperty;
import com.ibase.web.testplan.domain.SelectStationInfo;
import com.ibase.web.testplan.domain.Testplan;


public interface TestplanService {

	// 查询所有测试计划
	List<Testplan> queryTestplans();

	// 根据测试计划id查询测试计划
	Testplan queryTestplanByTestplanId(long testplanId);

	/*// 增加测试计划
	int addTestplan(Testplan testplan);*/

	// 删除测试计划
	int deleteTestplan(long testplanId);
	
	//根据stationid查出基站，基站属性，小区，类别，属性，指标，配置
	List<Map<String, List<? extends Object>>> queryAll(List<Long> stationIds,StationProperty stationProperty);
	
	public List<SelectStationInfo> queryAll1(List<Long> stationIds, StationProperty stationProperty);

	//根据用户id查询测试计划
	Testplan queryTestplanByUserId(long userId);
	
	

}
