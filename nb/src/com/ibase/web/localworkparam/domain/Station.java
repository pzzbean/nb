package com.ibase.web.localworkparam.domain;

import com.ibase.core.base.BaseDomain;

public class Station extends BaseDomain {

	private long stationId; // 基站id
	private String stationName;//基站名
	private String stationHeight; // 站高
	private String stationLongitude; // 基站经度
	private String stationLatitude; // 基站纬度
	private String stationWorkModel; // 工作模式
	private String stationPosition; // 基站位置（市id）
	private String TAC;
	private String NodeBID;
	
	public long getStationId() {
		return stationId;
	}

	public void setStationId(long stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStationHeight() {
		return stationHeight;
	}

	public void setStationHeight(String stationHeight) {
		this.stationHeight = stationHeight;
	}

	public String getStationLongitude() {
		return stationLongitude;
	}

	public void setStationLongitude(String stationLongitude) {
		this.stationLongitude = stationLongitude;
	}

	public String getStationLatitude() {
		return stationLatitude;
	}

	public void setStationLatitude(String stationLatitude) {
		this.stationLatitude = stationLatitude;
	}

	public String getStationWorkModel() {
		return stationWorkModel;
	}

	public void setStationWorkModel(String stationWorkModel) {
		this.stationWorkModel = stationWorkModel;
	}

	public String getStationPosition() {
		return stationPosition;
	}

	public void setStationPosition(String stationPosition) {
		this.stationPosition = stationPosition;
	}
	

	public String getTAC() {
		return TAC;
	}

	public void setTAC(String tAC) {
		TAC = tAC;
	}

	public String getNodeBID() {
		return NodeBID;
	}

	public void setNodeBID(String nodeBID) {
		NodeBID = nodeBID;
	}

	@Override
	public String toString() {
		return "Station [stationId=" + stationId + ", stationName=" + stationName + ", stationHeight=" + stationHeight
				+ ", stationLongitude=" + stationLongitude + ", stationLatitude=" + stationLatitude
				+ ", stationWorkModel=" + stationWorkModel + ", stationPosition=" + stationPosition + ", TAC=" + TAC
				+ ", NodeBID=" + NodeBID + "]";
	}

	
	

}
