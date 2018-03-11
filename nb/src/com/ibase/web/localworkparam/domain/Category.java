package com.ibase.web.localworkparam.domain;

import java.util.List;

import com.ibase.core.base.BaseDomain;

public class Category extends BaseDomain {

	private long categoryId; // 类别id
	private String categoryName; // 类别名称
	private List<CellProperty> cellProperties;

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<CellProperty> getCellProperties() {
		return cellProperties;
	}

	public void setCellProperties(List<CellProperty> cellProperties) {
		this.cellProperties = cellProperties;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", cellProperties="
				+ cellProperties + "]";
	}

	
}
