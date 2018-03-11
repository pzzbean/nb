package com.ibase.web.localworkparam.domain.queryAllDao;

public class QueryIndex {
	private long cellId;
	private long indexId;
	private String indexName;
	public QueryIndex(long cellId, long indexId, String indexName) {
		super();
		this.cellId = cellId;
		this.indexId = indexId;
		this.indexName = indexName;
	}
	public QueryIndex() {
		super();
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
	public String getIndexName() {
		return indexName;
	}
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	@Override
	public String toString() {
		return "QueryIndex [cellId=" + cellId + ", indexId=" + indexId + ", indexName=" + indexName + "]";
	}
	
}
