package com.ibase.web.testplan.domain;

import java.util.List;

import com.ibase.web.localworkparam.domain.StationProperty;

public class SelectStationInfo {
	private long stationId;
	private String stationName;
	private List<StationProperty> listStationProperty;//基站属性
	private List<StationCellsInfo> listStationCellsInfo;//基站下小区属性
	public SelectStationInfo() {
		super();
	}
	public SelectStationInfo(long stationId, String stationName, List<StationProperty> listStationProperty,
			List<StationCellsInfo> listStationCellsInfo) {
		super();
		this.stationId = stationId;
		this.stationName = stationName;
		this.listStationProperty = listStationProperty;
		this.listStationCellsInfo = listStationCellsInfo;
	}
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
	public List<StationProperty> getListStationProperty() {
		return listStationProperty;
	}
	public void setListStationProperty(List<StationProperty> listStationProperty) {
		this.listStationProperty = listStationProperty;
	}
	public List<StationCellsInfo> getListStationCellsInfo() {
		return listStationCellsInfo;
	}
	public void setListStationCellsInfo(List<StationCellsInfo> listStationCellsInfo) {
		this.listStationCellsInfo = listStationCellsInfo;
	}
	@Override
	public String toString() {
		return "SelectStationInfo [stationId=" + stationId + ", stationName=" + stationName + ", listStationProperty="
				+ listStationProperty + ", listStationCellsInfo=" + listStationCellsInfo + "]";
	}
	
}
