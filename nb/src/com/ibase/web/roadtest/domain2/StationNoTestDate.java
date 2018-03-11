package com.ibase.web.roadtest.domain2;

import com.ibase.core.base.BaseDomain;

public class StationNoTestDate extends BaseDomain{
	private String testDate;
	private String station_No;
	private String testUserName;
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	public String getStation_No() {
		return station_No;
	}
	public void setStation_No(String station_No) {
		this.station_No = station_No;
	}
	public String getTestUserName() {
		return testUserName;
	}
	public void setTestUserName(String testUserName) {
		this.testUserName = testUserName;
	}
	public StationNoTestDate(String testDate, String station_No, String testUserName) {
		super();
		this.testDate = testDate;
		this.station_No = station_No;
		this.testUserName = testUserName;
	}
	public StationNoTestDate() {
		super();
	}
	@Override
	public String toString() {
		return "StationNoTestDate [testDate=" + testDate + ", station_No=" + station_No + ", testUserName="
				+ testUserName + "]";
	}
	
}
