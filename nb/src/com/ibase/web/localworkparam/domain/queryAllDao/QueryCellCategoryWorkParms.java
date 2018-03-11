package com.ibase.web.localworkparam.domain.queryAllDao;

import java.util.List;

public class QueryCellCategoryWorkParms {
	private long cellId;
	private List<QueryCategory> listQueryCategory;
	
	
	public QueryCellCategoryWorkParms() {
		super();
	}


	public QueryCellCategoryWorkParms(long cellId, List<QueryCategory> listQueryCategory) {
		super();
		this.cellId = cellId;
		this.listQueryCategory = listQueryCategory;
	}


	public long getCellId() {
		return cellId;
	}


	public void setCellId(long cellId) {
		this.cellId = cellId;
	}


	public List<QueryCategory> getListQueryCategory() {
		return listQueryCategory;
	}


	public void setListQueryCategory(List<QueryCategory> listQueryCategory) {
		this.listQueryCategory = listQueryCategory;
	}


	@Override
	public String toString() {
		return "QueryCellCategoryWorkParms [cellId=" + cellId + ", listQueryCategory=" + listQueryCategory + "]";
	}
	
}
