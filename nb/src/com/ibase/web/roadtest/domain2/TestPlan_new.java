package com.ibase.web.roadtest.domain2;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class TestPlan_new {
	 /*计划ID*/private int planId;
	  /*测试地址*/private String testAddress;
	  /*测试人*/private String testUser;
	  /*测试时间*/private String testDate;
	  /*测试基站*/private List<Station_new> baseStationList;
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getTestAddress() {
		return testAddress;
	}
	public void setTestAddress(String testAddress) {
		this.testAddress = testAddress;
	}
	public String getTestUser() {
		return testUser;
	}
	public void setTestUser(String testUser) {
		this.testUser = testUser;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	public List<Station_new> getBaseStationList() {
		return baseStationList;
	}
	public void setBaseStationList(List<Station_new> baseStationList) {
		this.baseStationList = baseStationList;
	}
	public TestPlan_new(int planId, String testAddress, String testUser, String testDate,
			List<Station_new> baseStationList) {
		super();
		this.planId = planId;
		this.testAddress = testAddress;
		this.testUser = testUser;
		this.testDate = testDate;
		this.baseStationList = baseStationList;
	}
	public TestPlan_new() {
		super();
	}
	@Override
	public String toString() {
		return "TestPlan_new [planId=" + planId + ", testAddress=" + testAddress + ", testUser=" + testUser
				+ ", testDate=" + testDate + ", baseStationList=" + baseStationList + "]";
	}

	
}
