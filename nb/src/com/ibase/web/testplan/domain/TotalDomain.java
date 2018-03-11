package com.ibase.web.testplan.domain;

import java.util.List;

public class TotalDomain {
	private long testplanId; // 测试计划表id
	private long userId; // 用户编号
	private String testEngineer; // 测试工程师
	private String testEngineerPhone;// 测试工程师电话
	private String planCreator; // 计划创建人
	private String planCreatorPhone;// 创建人电话
	private String planCreateTime; // 计划创建时间
	private String planReviser; // 计划修改人
	private String planReviseTime; // 修改时间
	private String state; // 当前计划的状态
	private String testStartTime; // 测试开始时间
	private String testEndTime; // 测试结束时间
	private long stationId; // 基站id
	private List<Long> stationPropertyId;//基站属性id
	private List<String> stationPropertyValue;//基站属性值
	private long cellId; // 小区id
	private List<String> category; // 类别（包含其他，也就是指指标）
	private List<Long> id; // 指标/小区属性id
	private List<String> value; // 指标/小区属性的值
	private List<Long> categoryId; //类别id
	private List<Long> indexId; // 指标id
	private List<Long> collocationId; // 配置id
	private List<String> collocationValue; // 配置值

	
	
}
