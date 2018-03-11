package com.ibase.web.localworkparam.domain.queryAllDao;

public class QueryWorkParm {
	private long cellPropertyId; // 小区属性表id
	private String cellPropertyName; // 小区属性名
	public QueryWorkParm() {
		super();
	}
	public QueryWorkParm(long cellPropertyId, String cellPropertyName) {
		super();
		this.cellPropertyId = cellPropertyId;
		this.cellPropertyName = cellPropertyName;
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
	@Override
	public String toString() {
		return "QueryWorkParm [cellPropertyId=" + cellPropertyId + ", cellPropertyName=" + cellPropertyName + "]";
	}
}
