package com.ibase.web.localworkparam.domain;

import com.ibase.core.base.BaseDomain;

public class Collocation extends BaseDomain {

	private long collocationId; // 配置表id
	private String collocationName;// 配置名
	
	public long getCollocationId() {
		return collocationId;
	}
	public void setCollocationId(long collocationId) {
		this.collocationId = collocationId;
	}
	public String getCollocationName() {
		return collocationName;
	}
	public void setCollocationName(String collocationName) {
		this.collocationName = collocationName;
	}
	
	
	
}
