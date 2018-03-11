package com.ibase.web.testplan.domain;

import java.util.List;

import com.ibase.core.base.BaseDomain;

public class PlanAndStation {
	private long planAndStationId; // 测试计划与基站中间表id
	private long testplanId; // 测试计划id
	private long stationId; // 基站id
	private long stationPropertyId;//基站属性id
	private String stationPropertyValue;//基站属性值
	private List<StationAndCell> stationAndCells;
	public long getPlanAndStationId() {
		return planAndStationId;
	}
	public void setPlanAndStationId(long planAndStationId) {
		this.planAndStationId = planAndStationId;
	}
	public long getTestplanId() {
		return testplanId;
	}
	public void setTestplanId(long testplanId) {
		this.testplanId = testplanId;
	}
	public long getStationId() {
		return stationId;
	}
	public void setStationId(long stationId) {
		this.stationId = stationId;
	}
	public long getStationPropertyId() {
		return stationPropertyId;
	}
	public void setStationPropertyId(long stationPropertyId) {
		this.stationPropertyId = stationPropertyId;
	}
	public String getStationPropertyValue() {
		return stationPropertyValue;
	}
	public void setStationPropertyValue(String stationPropertyValue) {
		this.stationPropertyValue = stationPropertyValue;
	}
	public List<StationAndCell> getStationAndCells() {
		return stationAndCells;
	}
	public void setStationAndCells(List<StationAndCell> stationAndCells) {
		this.stationAndCells = stationAndCells;
	}
	@Override
	public String toString() {
		return "PlanAndStation [planAndStationId=" + planAndStationId + ", testplanId=" + testplanId + ", stationId="
				+ stationId + ", stationPropertyId=" + stationPropertyId + ", stationPropertyValue="
				+ stationPropertyValue + ", stationAndCells=" + stationAndCells + "]";
	}

}
