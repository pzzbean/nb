package com.ibase.web.localworkparam.domain;

import java.util.List;

import com.ibase.core.base.BaseDomain;

public class Index extends BaseDomain {
	private long indexId;
	private String indexName;
	private List<CellAndIndex> cellAndIndexs;
	public long getIndexId() {
		return indexId;
	}
	public void setIndexId(long indexId) {
		this.indexId = indexId;
	}
	public String getIndexName() {
		return indexName;
	}
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	public List<CellAndIndex> getCellAndIndexs() {
		return cellAndIndexs;
	}
	public void setCellAndIndexs(List<CellAndIndex> cellAndIndexs) {
		this.cellAndIndexs = cellAndIndexs;
	}
	@Override
	public String toString() {
		return "Index [indexId=" + indexId + ", indexName=" + indexName + ", cellAndIndexs=" + cellAndIndexs + "]";
	}
	
}
