package com.ibase.web.testplan.domain;

import java.util.List;

import com.ibase.core.base.BaseDomain;

public class StationAndCell {
	private long stationAndCellId; // 基站和小区中间表id
	private long stationId; // 基站id
	private long cellId; // 小区id
	private long testplanId; // 测试计划id
	private String category; // 类别（包含其他，也就是指指标）
	private List<CellAndIndex> cellAndIndexs;

	public long getStationAndCellId() {
		return stationAndCellId;
	}

	public void setStationAndCellId(long stationAndCellId) {
		this.stationAndCellId = stationAndCellId;
	}

	public long getStationId() {
		return stationId;
	}

	public void setStationId(long stationId) {
		this.stationId = stationId;
	}

	public long getCellId() {
		return cellId;
	}

	public void setCellId(long cellId) {
		this.cellId = cellId;
	}

	public long getTestplanId() {
		return testplanId;
	}

	public void setTestplanId(long testplanId) {
		this.testplanId = testplanId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<CellAndIndex> getCellAndIndexs() {
		return cellAndIndexs;
	}

	public void setCellAndIndexs(List<CellAndIndex> cellAndIndexs) {
		this.cellAndIndexs = cellAndIndexs;
	}

	@Override
	public String toString() {
		return "StationAndCell [stationAndCellId=" + stationAndCellId + ", stationId=" + stationId + ", cellId="
				+ cellId + ", testplanId=" + testplanId + ", category=" + category + ", cellAndIndexs=" + cellAndIndexs
				+ "]";
	}

}
