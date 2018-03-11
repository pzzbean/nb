package com.ibase.web.localworkparam.domain.queryAllDao;

import java.util.List;

public class QueryCategory {
	private long categoryId; // 类别id
	private String categoryName; // 类别名称
	private List <QueryWorkParm> listQueryWorkParm;//根据类别id查出来的工程参数
	
	
	public QueryCategory() {
		super();
	}

	public QueryCategory(long categoryId, String categoryName, List<QueryWorkParm> listQueryWorkParm) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.listQueryWorkParm = listQueryWorkParm;
	}

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

	public List<QueryWorkParm> getListQueryWorkParm() {
		return listQueryWorkParm;
	}

	public void setListQueryWorkParm(List<QueryWorkParm> listQueryWorkParm) {
		this.listQueryWorkParm = listQueryWorkParm;
	}

	@Override
	public String toString() {
		return "QueryCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", listQueryWorkParm="
				+ listQueryWorkParm + "]";
	}
	
}
