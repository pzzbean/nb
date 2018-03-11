package com.ibase.web.roadtest.domain;

import java.util.List;

public class RoadTestData2 {

	private String userId;
	private String station_No;
	private String communityName;
	private String rtlist;
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
	
	
	public RoadTestData2() {
		super();
	}
	public String getRtlist() {
		return rtlist;
	}
	public void setRtlist(String rtlist) {
		this.rtlist = rtlist;
	}
	public RoadTestData2(String userId, String station_No, String communityName, String rtlist) {
		super();
		this.userId = userId;
		this.station_No = station_No;
		this.communityName = communityName;
		this.rtlist = rtlist;
	}
	@Override
	public String toString() {
		return "RoadTestData2 [userId=" + userId + ", station_No=" + station_No + ", communityName=" + communityName
				+ ", rtlist=" + rtlist + "]";
	}
	
	
	
}
