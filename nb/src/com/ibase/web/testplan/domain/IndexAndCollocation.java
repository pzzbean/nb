package com.ibase.web.testplan.domain;

public class IndexAndCollocation {
	private long indexAndCollocationId; // 指标配置中间表id
	private long indexId; // 指标id
	private long collocationId; // 配置id
	private long testplanId; // 测试计划id
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

	public long getTestplanId() {
		return testplanId;
	}

	public void setTestplanId(long testplanId) {
		this.testplanId = testplanId;
	}

	public String getCollocationValue() {
		return collocationValue;
	}

	public void setCollocationValue(String collocationValue) {
		this.collocationValue = collocationValue;
	}

	@Override
	public String toString() {
		return "IndexAndCollocation [indexAndCollocationId=" + indexAndCollocationId + ", indexId=" + indexId
				+ ", collocationId=" + collocationId + ", testplanId=" + testplanId + ", collocationValue="
				+ collocationValue + "]";
	}

}
