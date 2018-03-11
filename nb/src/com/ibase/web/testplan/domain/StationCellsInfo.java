package com.ibase.web.testplan.domain;

import java.util.List;

import com.ibase.web.localworkparam.domain.CellProperty;
import com.ibase.web.localworkparam.domain.queryAllDao.QueryCellCategoryWorkParms;
import com.ibase.web.localworkparam.domain.queryAllDao.QueryIndex;

public class StationCellsInfo {

	private Long CellId;
	private String CellName;
	private List<QueryCellCategoryWorkParms> listQueryCellCategoryWorkParms;
	private List<QueryIndex> listQueryIndexes;
	public StationCellsInfo(Long cellId, String cellName,
			List<QueryCellCategoryWorkParms> listQueryCellCategoryWorkParms, List<QueryIndex> listQueryIndexes) {
		super();
		CellId = cellId;
		CellName = cellName;
		this.listQueryCellCategoryWorkParms = listQueryCellCategoryWorkParms;
		this.listQueryIndexes = listQueryIndexes;
	}
	public StationCellsInfo() {
		super();
	}
	public Long getCellId() {
		return CellId;
	}
	public void setCellId(Long cellId) {
		CellId = cellId;
	}
	public String getCellName() {
		return CellName;
	}
	public void setCellName(String cellName) {
		CellName = cellName;
	}
	public List<QueryCellCategoryWorkParms> getListQueryCellCategoryWorkParms() {
		return listQueryCellCategoryWorkParms;
	}
	public void setListQueryCellCategoryWorkParms(List<QueryCellCategoryWorkParms> listQueryCellCategoryWorkParms) {
		this.listQueryCellCategoryWorkParms = listQueryCellCategoryWorkParms;
	}
	public List<QueryIndex> getListQueryIndexes() {
		return listQueryIndexes;
	}
	public void setListQueryIndexes(List<QueryIndex> listQueryIndexes) {
		this.listQueryIndexes = listQueryIndexes;
	}
	@Override
	public String toString() {
		return "StationCellsInfo [CellId=" + CellId + ", CellName=" + CellName + ", listQueryCellCategoryWorkParms="
				+ listQueryCellCategoryWorkParms + ", listQueryIndexes=" + listQueryIndexes + "]";
	}
	
}
