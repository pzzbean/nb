package com.ibase.web.roadtest.domain;

import org.springframework.stereotype.Repository;

@Repository 
public class RoadTestTotal {

	private String userId;
	private String station_No;
	private String communityName;
	private String cellId;//小区编号
	private String roadTestDate;//测试时间
	private String longitude;
	private String latitude;
	
	private String PCI;
	private String RSRP;
	private String SINR;
	
	public RoadTestTotal(String cellId, String roadTestDate, String longitude, String latitude, String pCI, String rSRP,
			String sINR) {
		super();
		this.cellId = cellId;
		this.roadTestDate = roadTestDate;
		this.longitude = longitude;
		this.latitude = latitude;
		PCI = pCI;
		RSRP = rSRP;
		SINR = sINR;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
	public String getRoadTestDate() {
		return roadTestDate;
	}
	public void setRoadTestDate(String roadTestDate) {
		this.roadTestDate = roadTestDate;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getPCI() {
		return PCI;
	}
	public void setPCI(String pCI) {
		PCI = pCI;
	}
	public String getRSRP() {
		return RSRP;
	}
	public void setRSRP(String rSRP) {
		RSRP = rSRP;
	}
	public String getSINR() {
		return SINR;
	}
	public void setSINR(String sINR) {
		SINR = sINR;
	}
	public RoadTestTotal(String userId, String station_No, String communityName, String cellId, String roadTestDate,
			String longitude, String latitude, String pCI, String rSRP, String sINR) {
		super();
		this.userId = userId;
		this.station_No = station_No;
		this.communityName = communityName;
		this.cellId = cellId;
		this.roadTestDate = roadTestDate;
		this.longitude = longitude;
		this.latitude = latitude;
		PCI = pCI;
		RSRP = rSRP;
		SINR = sINR;
	}
	public RoadTestTotal() {
		super();
	}
	@Override
	public String toString() {
		return "RoadTestTotal [userId=" + userId + ", station_No=" + station_No + ", communityName=" + communityName
				+ ", cellId=" + cellId + ", roadTestDate=" + roadTestDate + ", longitude=" + longitude + ", latitude="
				+ latitude + ", PCI=" + PCI + ", RSRP=" + RSRP + ", SINR=" + SINR + "]";
	}
	
	
	
}
