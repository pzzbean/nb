package com.ibase.web.roadtest.domain;

public class LonLat {
	private String rt_station_longitude;
	private String  rt_station_latitude;
	public LonLat() {
		super();
	}
	public LonLat(String rt_station_longitude, String rt_station_latitude) {
		super();
		this.rt_station_longitude = rt_station_longitude;
		this.rt_station_latitude = rt_station_latitude;
	}
	public String getRt_station_longitude() {
		return rt_station_longitude;
	}
	public void setRt_station_longitude(String rt_station_longitude) {
		this.rt_station_longitude = rt_station_longitude;
	}
	public String getRt_station_latitude() {
		return rt_station_latitude;
	}
	public void setRt_station_latitude(String rt_station_latitude) {
		this.rt_station_latitude = rt_station_latitude;
	}
	@Override
	public String toString() {
		return "LonLat [rt_station_longitude=" + rt_station_longitude + ", rt_station_latitude=" + rt_station_latitude
				+ "]";
	}
	
	
}
