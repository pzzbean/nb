package com.ibase.web.localworkparam.domain;

import java.util.List;

import com.ibase.core.base.BaseDomain;

public class CellProperty extends BaseDomain {

	private long cellPropertyId; // 小区属性表id
	private String cellPropertyName; // 小区属性名
	private long categoryId; // 属性的类别id
	private List<CellAndCategory> cellAndCategories;

	
	public CellProperty() {
	}
	public long getCellPropertyId() {
		return cellPropertyId;
	}

	public void setCellPropertyId(long cellPropertyId) {
		this.cellPropertyId = cellPropertyId;
	}

	public String getCellPropertyName() {
		return cellPropertyName;
	}

	public void setCellPropertyName(String cellPropertyName) {
		this.cellPropertyName = cellPropertyName;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public List<CellAndCategory> getCellAndCategories() {
		return cellAndCategories;
	}

	public void setCellAndCategories(List<CellAndCategory> cellAndCategories) {
		this.cellAndCategories = cellAndCategories;
	}

	@Override
	public String toString() {
		return "CellProperty [cellPropertyId=" + cellPropertyId + ", cellPropertyName=" + cellPropertyName
				+ ", categoryId=" + categoryId + ", cellAndCategories=" + cellAndCategories + "]";
	}

}
