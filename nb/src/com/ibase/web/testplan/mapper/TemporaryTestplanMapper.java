package com.ibase.web.testplan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ibase.web.roadtest.domain.TemporayWorkparamDomain2;
import com.ibase.web.roadtest.domain2.Station_new;
import com.ibase.web.testplan.domain.TemporaryTestplan;

public interface TemporaryTestplanMapper {

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
	List<TemporaryTestplan> selectAllStation1(TemporaryTestplan temporaryTestplan);
	
	//根据基站号查询所有小区
	List<String> selectTestPlanNewStationnew2(String getmBaseStationNumber);
	
	//根据小区查询对应信息
	TemporayWorkparamDomain2 selectTestPlanNewStationnew3(String currCellName);

	List<TemporayWorkparamDomain2> selectByStationNo(String stationNo);
	
	
}
