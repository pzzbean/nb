package com.ibase.web.localworkparam.domain;

import com.ibase.core.base.BaseDomain;

public class CellAndIndex extends BaseDomain {
	
	private long cellAndIndexId;//小区和指针中间表id
	private long cellId;		//小区id
	private long indexId;		//指针id
	private long testplanId;	//测试计划id
	
	public long getCellAndIndexId() {
		return cellAndIndexId;
	}
	public void setCellAndIndexId(long cellAndIndexId) {
		this.cellAndIndexId = cellAndIndexId;
	}
	public long getCellId() {
		return cellId;
	}
	public void setCellId(long cellId) {
		this.cellId = cellId;
	}
	public long getIndexId() {
		return indexId;
	}
	public void setIndexId(long indexId) {
		this.indexId = indexId;
	}
	public long getTestplanId() {
		return testplanId;
	}
	public void setTestplanId(long testplanId) {
		this.testplanId = testplanId;
	}
	
	@Override
	public String toString() {
		return "CellAndIndex [cellAndIndexId=" + cellAndIndexId + ", cellId=" + cellId + ", indexId=" + indexId
				+ ", testplanId=" + testplanId + "]";
	}
}