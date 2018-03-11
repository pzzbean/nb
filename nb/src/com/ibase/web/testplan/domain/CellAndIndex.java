package com.ibase.web.testplan.domain;

import java.util.List;

public class CellAndIndex {
	private long cellAndIndexId; // 小区和指针中间表id
	private long cellId; // 小区id
	private long id; // 指标/小区属性id
	private long testplanId; // 测试计划id
	private String value; // 指标/小区属性的值
	private long categoryId; //类别id
	private List<IndexAndCollocation> indexAndCollocations;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTestplanId() {
		return testplanId;
	}
	public void setTestplanId(long testplanId) {
		this.testplanId = testplanId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public List<IndexAndCollocation> getIndexAndCollocations() {
		return indexAndCollocations;
	}
	public void setIndexAndCollocations(List<IndexAndCollocation> indexAndCollocations) {
		this.indexAndCollocations = indexAndCollocations;
	}
	@Override
	public String toString() {
		return "CellAndIndex [cellAndIndexId=" + cellAndIndexId + ", cellId=" + cellId + ", id=" + id + ", testplanId="
				+ testplanId + ", value=" + value + ", categoryId=" + categoryId + ", indexAndCollocations="
				+ indexAndCollocations + "]";
	}

}
