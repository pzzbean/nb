package com.ibase.web.log.domain;

public class LogCXDomain {

	private String testDate;//测试日期
	private String station_No;//基站编号
	private String ci;//小区id
	
	
	public LogCXDomain() {
		super();
	}
	public LogCXDomain(String testDate, String station_No, String ci) {
		super();
		this.testDate = testDate;
		this.station_No = station_No;
		this.ci = ci;
	}
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
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	@Override
	public String toString() {
		return "LogCXDomain [testDate=" + testDate + ", station_No=" + station_No + ", ci=" + ci + "]";
	}
	
}
