package com.ibase.web.roadtest.domain;

public class CellParameterCheck {

	private int userId;// 用户编号
	private String testDate;//测试时间
	private String station_No;//基站编号
	private String communityName;//小区名
	private String cellId;//小区编号
	private String pci;
	private String frequency;//频点
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getStation_No() {
		return station_No;
	}
	public void setStation_No(String station_No) {
		this.station_No = station_No;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getCellId() {
		return cellId;
	}
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}
	public String getPci() {
		return pci;
	}
	public void setPci(String pci) {
		this.pci = pci;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	@Override
	public String toString() {
		return "CellParameterCheck [userId=" + userId + ", testDate=" + testDate + ", station_No=" + station_No
				+ ", communityName=" + communityName + ", cellId=" + cellId + ", pci=" + pci + ", frequency="
				+ frequency + "]";
	}
	public CellParameterCheck(int userId, String testDate, String station_No, String communityName, String cellId,
			String pci, String frequency) {
		super();
		this.userId = userId;
		this.testDate = testDate;
		this.station_No = station_No;
		this.communityName = communityName;
		this.cellId = cellId;
		this.pci = pci;
		this.frequency = frequency;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	public CellParameterCheck() {
		super();
	}
	
	

}
