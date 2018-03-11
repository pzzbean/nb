package com.ibase.web.roadtest.domain;

/**
 *  保存日志文件
 * @author Administrator
 *
 */
public class SaveLogFile {
	private Integer id;
	private String userId;
	private String planId;
	private String stationNo;
	private String testDate;
	private String logfileName;
	private String logfileUrl;
	
	
	
	public SaveLogFile() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SaveLogFile(Integer id, String userId, String planId, String stationNo, String testDate, String logfileName,
			String logfileUrl) {
		super();
		this.id = id;
		this.userId = userId;
		this.planId = planId;
		this.stationNo = stationNo;
		this.testDate = testDate;
		this.logfileName = logfileName;
		this.logfileUrl = logfileUrl;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPlanId() {
		return planId;
	}


	public void setPlanId(String planId) {
		this.planId = planId;
	}


	public String getStationNo() {
		return stationNo;
	}


	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}


	public String getTestDate() {
		return testDate;
	}


	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}


	public String getLogfileName() {
		return logfileName;
	}


	public void setLogfileName(String logfileName) {
		this.logfileName = logfileName;
	}


	public String getLogfileUrl() {
		return logfileUrl;
	}


	public void setLogfileUrl(String logfileUrl) {
		this.logfileUrl = logfileUrl;
	}


	@Override
	public String toString() {
		return "SaveLogFile [id=" + id + ", userId=" + userId + ", planId=" + planId + ", stationNo=" + stationNo
				+ ", testDate=" + testDate + ", logfileName=" + logfileName + ", logfileUrl=" + logfileUrl + "]";
	}
	
}
