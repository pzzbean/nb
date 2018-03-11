package com.ibase.web.localworkparam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibase.web.localworkparam.domain.CellProperty;
import com.ibase.web.localworkparam.domain.queryAllDao.QueryCellCategoryWorkParms;
import com.ibase.web.localworkparam.mapper.CellPropertyMapper;
import com.ibase.web.localworkparam.service.CellPropertyService;

@Service
public class CellPropertyServiceImpl implements CellPropertyService {

	@Autowired
	CellPropertyMapper cellpropertymapper;

	@Override
	public List<CellProperty> queryCellProperties(CellProperty cellProperty) {

		int currentPage = cellProperty.getPage().getCurrentPage();
		int pageSize = cellProperty.getPage().getPageSize();
		cellProperty.getPage().setTotalRows(countCellProperties());
		cellProperty.getPage().setStartNum((currentPage - 1) * pageSize);
		cellProperty.getPage().setEndIndex(pageSize);

		List<CellProperty> cellProperties = cellpropertymapper.queryCellProperties(cellProperty);
		return cellProperties;
	}

	@Override
	public Integer countCellProperties() {
		return cellpropertymapper.countCellProperties();
	}

	@Override
	public long addCellProperty(CellProperty cellProperty) {
		return cellpropertymapper.addCellProperty(cellProperty);
	}

	@Override
	public List<CellProperty> queryCellPropertiesByCellId(long cellId) {
		List<CellProperty> cellProperties = cellpropertymapper.queryCellPropertiesByCellId(cellId);
		return cellProperties;
	}

	@Override
	public int deleteCellProperty(long cellPropertyId) {
		return cellpropertymapper.deleteCellProperty(cellPropertyId);
	}

	@Override
	public int updateCellProperty(CellProperty cellProperty) {
		return cellpropertymapper.updateCellProperty(cellProperty);
	}

	@Override
	public List<QueryCellCategoryWorkParms> queryAllStationCellInfoByCellId(long cellId) {
		return cellpropertymapper.queryAllStationCellInfoByCellId(cellId);
	}

}
