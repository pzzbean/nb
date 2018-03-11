package com.ibase.web.testplan.mapper;

import java.util.List;

import com.ibase.web.localworkparam.domain.Station;
import com.ibase.web.testplan.domain.Testplan;

public interface TestplanMapper {

	// 查询所有测试计划
	List<Testplan> queryTestplans();

	// 根据测试计划id查询测试计划
	Testplan queryTestplanByTestplanId(long testplanId);

	/*
	 * // 增加测试计划表 int addTestplan(Testplan testplan);
	 * 
	 * // 在除测试计划表以外的表里添加数据 int addOther(Testplan testplan);
	 */

	// 删除测试计划
	int deleteTestplan(long testplanId);

	// 根据用户id查询测试计划
	Testplan queryTestplanByUserId(long userId);

}
