package com.ibase.web.localworkparam.domain;

import java.util.List;

import com.ibase.core.base.BaseDomain;

public class IndexAndCollocation extends BaseDomain {

	private long indexAndCollocationId; // 指标配置中间表id
	private long indexId; // 指标表id
	private long collocationId; // 配置表id
	private String collocationName; // 配置名
	private String collocationValue; // 配置值
	public long getIndexAndCollocationId() {
		return indexAndCollocationId;
	}
	public void setIndexAndCollocationId(long indexAndCollocationId) {
		this.indexAndCollocationId = indexAndCollocationId;
	}
	public long getIndexId() {
		return indexId;
	}
	public void setIndexId(long indexId) {
		this.indexId = indexId;
	}
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
	public String getCollocationValue() {
		return collocationValue;
	}
	public void setCollocationValue(String collocationValue) {
		this.collocationValue = collocationValue;
	}

}
