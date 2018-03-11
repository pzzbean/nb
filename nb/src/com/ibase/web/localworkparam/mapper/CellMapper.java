package com.ibase.web.localworkparam.mapper;

import java.util.List;

import com.ibase.web.localworkparam.domain.Cell;

public interface CellMapper {
	// 查询所有小区信息
	List<Cell> queryCells(Cell cell);

	// 记录条数
	Integer countCells();

	// 新增小区数据
	long addCell(Cell cell);

	// 改变小区表中的stationid（当station删除时，小区表中stationid置为0）
	int updateStationId(long stationId);

	// 删除小区
	int deleteCell(long cellId);

	// 删除小区类别中间表的数据(当cell删除时，中间表中相关的数据也删除)
	int deleteCellAndCategory(long cellId);
	
	// 修改小区
	int updateCell(Cell cell);

	List<Cell> queryCellsByStationId(long stationId);
}
