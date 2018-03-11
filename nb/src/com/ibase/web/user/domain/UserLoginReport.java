package com.ibase.web.user.domain;

import com.ibase.core.base.BaseDomain;

public class UserLoginReport extends BaseDomain {
	private long id;
	private String time;
	private String name;
	private String tel;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "UserLoginReport [id=" + id + ", time=" + time + ", name=" + name + ", tel=" + tel + "]";
	}
	
	
}
