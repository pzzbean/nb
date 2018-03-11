package com.ibase.web.testplan.domain;

import java.util.List;

public class StationAndStationProperty {
	private long stationId;
	private long StationPropertyId;

	public long getStationId() {
		return stationId;
	}

	public void setStationId(long stationId) {
		this.stationId = stationId;
	}

	public long getStationPropertyId() {
		return StationPropertyId;
	}

	public void setStationPropertyId(long stationPropertyId) {
		StationPropertyId = stationPropertyId;
	}

	@Override
	public String toString() {
		return "StationAndStationProperty [stationId=" + stationId + ", StationPropertyId=" + StationPropertyId + "]";
	}

}
