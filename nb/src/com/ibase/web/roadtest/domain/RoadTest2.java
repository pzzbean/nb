package com.ibase.web.roadtest.domain;

import com.ibase.core.base.BaseDomain;


public class RoadTest2  {
	
	private String cellId;//小区编号
	private String roadTestDate;//测试时间
	private String longitude;
	private String latitude;
	
	private String PCI;
	private String RSRP;
	private String SINR;
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
	public RoadTest2(String cellId, String roadTestDate, String longitude, String latitude, String pCI, String rSRP,
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
	public RoadTest2() {
		super();
	}
	
	
}
