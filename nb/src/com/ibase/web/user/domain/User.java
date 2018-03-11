package com.ibase.web.user.domain;

import com.ibase.core.base.BaseDomain;

public class User extends BaseDomain {
	private long userId;
	private String user_code;
	private String paw;
	private String name;
	private String user_phone;
	private String status;// 1:管理员，2:测试人员
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getPaw() {
		return paw;
	}
	public void setPaw(String paw) {
		this.paw = paw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", user_code=" + user_code + ", paw=" + paw + ", name=" + name
				+ ", user_phone=" + user_phone + ", status=" + status + "]";
	}

}
