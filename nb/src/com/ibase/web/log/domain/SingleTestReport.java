package com.ibase.web.log.domain;

import com.ibase.core.base.BaseDomain;

public class SingleTestReport extends BaseDomain {
	private String user_id;
	private String plane_id;
	private String station_no;
	private String plan_test_engineer;
	private String plane_test_time;
	private String plane_create_time;
	public String getPlane_create_time() {
		return plane_create_time;
	}
	public void setPlane_create_time(String plane_create_time) {
		this.plane_create_time = plane_create_time;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPlane_id() {
		return plane_id;
	}
	public void setPlane_id(String plane_id) {
		this.plane_id = plane_id;
	}
	public String getStation_no() {
		return station_no;
	}
	public void setStation_no(String station_no) {
		this.station_no = station_no;
	}
	public String getPlan_test_engineer() {
		return plan_test_engineer;
	}
	public void setPlan_test_engineer(String plan_test_engineer) {
		this.plan_test_engineer = plan_test_engineer;
	}
	public String getPlane_test_time() {
		return plane_test_time;
	}
	public void setPlane_test_time(String plane_test_time) {
		this.plane_test_time = plane_test_time;
	}
	
	
	
}
