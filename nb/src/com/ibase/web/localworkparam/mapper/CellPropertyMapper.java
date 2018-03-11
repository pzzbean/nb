package com.ibase.web.localworkparam.mapper;

import java.util.List;

import com.ibase.web.localworkparam.domain.CellProperty;
import com.ibase.web.localworkparam.domain.queryAllDao.QueryCellCategoryWorkParms;

public interface CellPropertyMapper {

	// 查询所有小区属性
	List<CellProperty> queryCellProperties(CellProperty cellProperty);

	// 记录条数
	Integer countCellProperties();

	// 增加小区属性
	long addCellProperty(CellProperty cellProperty);

	// 根据小区id查类别和小区属性
	List<CellProperty> queryCellPropertiesByCellId(long cellId);

	// 删除小区属性
	int deleteCellProperty(long cellPropertyId);
	
	// 修改小区属性
	int updateCellProperty(CellProperty cellProperty);
	
	List<QueryCellCategoryWorkParms> queryAllStationCellInfoByCellId(long cellId);

}
