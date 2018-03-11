package com.ibase.web.localworkparam.domain;

import com.ibase.core.base.BaseDomain;

public class StationProperty extends BaseDomain {

	private long stationPropertyId; // 基站属性id
	private String stationPropertyName; // 基站属性名

	public long getStationPropertyId() {
		return stationPropertyId;
	}

	public void setStationPropertyId(long stationPropertyId) {
		this.stationPropertyId = stationPropertyId;
	}

	public String getStationPropertyName() {
		return stationPropertyName;
	}

	public void setStationPropertyName(String stationPropertyName) {
		this.stationPropertyName = stationPropertyName;
	}

	@Override
	public String toString() {
		return "StationProperty [stationPropertyId=" + stationPropertyId + ", stationPropertyName="
				+ stationPropertyName + "]";
	}

}
