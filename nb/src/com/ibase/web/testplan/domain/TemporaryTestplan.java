package com.ibase.web.testplan.domain;

import java.util.List;

public class TemporaryTestplan {
	private String userId;
	private long temporaryTestplanId;
	private String testEngineer;
	private String testEngineerPhone;
	private String planCreator;
	private String planCreatorPhone;
	private String planCreateTime;
	private String planReviser;
	private String planReviseTime;
	private String state;
	private String testStartTime;
	private String testEndTime;
	private String stationNo;
	private List<String> stationNoList;
	
	public List<String> getStationNoList() {
		return stationNoList;
	}
	public void setStationNoList(List<String> stationNoList) {
		this.stationNoList = stationNoList;
	}
	public long getTemporaryTestplanId() {
		return temporaryTestplanId;
	}
	public void setTemporaryTestplanId(long temporaryTestplanId) {
		this.temporaryTestplanId = temporaryTestplanId;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public String getStationNo() {
		return stationNo;
	}
	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "TemporaryTestplan [userId=" + userId + ", temporaryTestplanId=" + temporaryTestplanId
				+ ", testEngineer=" + testEngineer + ", testEngineerPhone=" + testEngineerPhone + ", planCreator="
				+ planCreator + ", planCreatorPhone=" + planCreatorPhone + ", planCreateTime=" + planCreateTime
				+ ", planReviser=" + planReviser + ", planReviseTime=" + planReviseTime + ", state=" + state
				+ ", testStartTime=" + testStartTime + ", testEndTime=" + testEndTime + ", stationNo=" + stationNo
				+ "]";
	}
	
	
	
}
