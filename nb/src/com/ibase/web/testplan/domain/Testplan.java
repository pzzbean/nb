package com.ibase.web.testplan.domain;

import java.util.List;

public class Testplan {
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
	private List<PlanAndStation> planAndStations;

	public long getTestplanId() {
		return testplanId;
	}

	public void setTestplanId(long testplanId) {
		this.testplanId = testplanId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getTestEngineer() {
		return testEngineer;
	}

	public void setTestEngineer(String testEngineer) {
		this.testEngineer = testEngineer;
	}

	public String getTestEngineerPhone() {
		return testEngineerPhone;
	}

	public void setTestEngineerPhone(String testEngineerPhone) {
		this.testEngineerPhone = testEngineerPhone;
	}

	public String getPlanCreator() {
		return planCreator;
	}

	public void setPlanCreator(String planCreator) {
		this.planCreator = planCreator;
	}

	public String getPlanCreatorPhone() {
		return planCreatorPhone;
	}

	public void setPlanCreatorPhone(String planCreatorPhone) {
		this.planCreatorPhone = planCreatorPhone;
	}

	public String getPlanCreateTime() {
		return planCreateTime;
	}

	public void setPlanCreateTime(String planCreateTime) {
		this.planCreateTime = planCreateTime;
	}

	public String getPlanReviser() {
		return planReviser;
	}

	public void setPlanReviser(String planReviser) {
		this.planReviser = planReviser;
	}

	public String getPlanReviseTime() {
		return planReviseTime;
	}

	public void setPlanReviseTime(String planReviseTime) {
		this.planReviseTime = planReviseTime;
	}

	public String getStatus() {
		return state;
	}

	public void setStatus(String status) {
		this.state = status;
	}

	public String getTestStartTime() {
		return testStartTime;
	}

	public void setTestStartTime(String testStartTime) {
		this.testStartTime = testStartTime;
	}

	public String getTestEndTime() {
		return testEndTime;
	}

	public void setTestEndTime(String testEndTime) {
		this.testEndTime = testEndTime;
	}

	public List<PlanAndStation> getPlanAndStations() {
		return planAndStations;
	}

	public void setPlanAndStations(List<PlanAndStation> planAndStations) {
		this.planAndStations = planAndStations;
	}

	@Override
	public String toString() {
		return "Testplan [testplanId=" + testplanId + ", userId=" + userId + ", testEngineer=" + testEngineer
				+ ", testEngineerPhone=" + testEngineerPhone + ", planCreator=" + planCreator + ", planCreatorPhone="
				+ planCreatorPhone + ", planCreateTime=" + planCreateTime + ", planReviser=" + planReviser
				+ ", planReviseTime=" + planReviseTime + ", status=" + state + ", testStartTime=" + testStartTime
				+ ", testEndTime=" + testEndTime + ",  planAndStations=" + planAndStations + "]";
	}

}