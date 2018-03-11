package com.ibase.web.plane.domain;

import com.ibase.core.base.BaseDomain;

public class Plane extends BaseDomain {
	private long plan_id;
	private long user_id;
	private String plan_test_engineer;
	private String plan_te_phone;
	private String plan_back_engineer;
	private String plan_be_phone;
	private String plane_test_content;
	private String plane_test_time;
	private String plane_create_time;
	private long plane_creator;
	private String plane_update_time;
	private long plane_Modifier;
	
	public long getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(long plan_id) {
		this.plan_id = plan_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getPlan_test_engineer() {
		return plan_test_engineer;
	}
	public void setPlan_test_engineer(String plan_test_engineer) {
		this.plan_test_engineer = plan_test_engineer;
	}
	public String getPlan_te_phone() {
		return plan_te_phone;
	}
	public void setPlan_te_phone(String plan_te_phone) {
		this.plan_te_phone = plan_te_phone;
	}
	public String getPlan_back_engineer() {
		return plan_back_engineer;
	}
	public void setPlan_back_engineer(String plan_back_engineer) {
		this.plan_back_engineer = plan_back_engineer;
	}
	public String getPlan_be_phone() {
		return plan_be_phone;
	}
	public void setPlan_be_phone(String plan_be_phone) {
		this.plan_be_phone = plan_be_phone;
	}
	public String getPlane_test_content() {
		return plane_test_content;
	}
	public void setPlane_test_content(String plane_test_content) {
		this.plane_test_content = plane_test_content;
	}
	public String getPlane_test_time() {
		return plane_test_time;
	}
	public void setPlane_test_time(String plane_test_time) {
		this.plane_test_time = plane_test_time;
	}
	public String getPlane_create_time() {
		return plane_create_time;
	}
	public void setPlane_create_time(String plane_create_time) {
		this.plane_create_time = plane_create_time;
	}
	public long getPlane_creator() {
		return plane_creator;
	}
	public void setPlane_creator(long plane_creator) {
		this.plane_creator = plane_creator;
	}
	public String getPlane_update_time() {
		return plane_update_time;
	}
	public void setPlane_update_time(String plane_update_time) {
		this.plane_update_time = plane_update_time;
	}
	public long getPlane_Modifier() {
		return plane_Modifier;
	}
	public void setPlane_Modifier(long plane_Modifier) {
		this.plane_Modifier = plane_Modifier;
	}

}
