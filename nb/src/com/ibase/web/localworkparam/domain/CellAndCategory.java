package com.ibase.web.localworkparam.domain;

import com.ibase.core.base.BaseDomain;

public class CellAndCategory extends BaseDomain {

	private long cellAndCategoryId;	//小区和类别中间表id
	private long cellId;			//小区id
	private long categoryId;		//类别id
	private long testplanId;			//测试计划id
	public long getCellAndCategoryId() {
		return cellAndCategoryId;
	}
	public void setCellAndCategoryId(long cellAndCategoryId) {
		this.cellAndCategoryId = cellAndCategoryId;
	}
	public long getCellId() {
		return cellId;
	}
	public void setCellId(long cellId) {
		this.cellId = cellId;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public long getTestplanId() {
		return testplanId;
	}
	public void setTestplanId(long testplanId) {
		this.testplanId = testplanId;
	}
	@Override
	public String toString() {
		return "CellAndCategory [cellAndCategoryId=" + cellAndCategoryId + ", cellId=" + cellId + ", categoryId="
				+ categoryId + ", testplanId=" + testplanId + "]";
	}
	
}
