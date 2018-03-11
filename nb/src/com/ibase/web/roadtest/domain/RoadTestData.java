package com.ibase.web.roadtest.domain;

import java.util.List;

public class RoadTestData {

	private String userId;
	private String station_No;
	private String communityName;
	private List<RoadTest2> rtlist;
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
	public List<RoadTest2> getRtlist() {
		return rtlist;
	}
	public void setRtlist(List<RoadTest2> rtlist) {
		this.rtlist = rtlist;
	}
	public RoadTestData(String userId, String station_No, String communityName, List<RoadTest2> rtlist) {
		super();
		this.userId = userId;
		this.station_No = station_No;
		this.communityName = communityName;
		this.rtlist = rtlist;
	}
	public RoadTestData() {
		super();
	}
	@Override
	public String toString() {
		return "RoadTestData [userId=" + userId + ", station_No=" + station_No + ", communityName=" + communityName
				+ ", rtlist=" + rtlist + "]";
	}
	
	
}
