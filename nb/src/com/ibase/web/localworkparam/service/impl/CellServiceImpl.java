package com.ibase.web.localworkparam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibase.web.localworkparam.domain.Cell;
import com.ibase.web.localworkparam.domain.CellAndCategory;
import com.ibase.web.localworkparam.mapper.CellMapper;
import com.ibase.web.localworkparam.service.CellService;

@Service
public class CellServiceImpl implements CellService {

	@Autowired
	CellMapper cellMapper;

	@Override
	public List<Cell> queryCells(Cell cell) {

		int currentPage = cell.getPage().getCurrentPage();
		int pageSize = cell.getPage().getPageSize();
		cell.getPage().setTotalRows((int) countCells());
		cell.getPage().setStartNum((currentPage - 1) * pageSize);
		cell.getPage().setEndIndex(pageSize);

		List<Cell> cells = cellMapper.queryCells(cell);
		return cells;
	}

	@Override
	public Integer countCells() {
		return cellMapper.countCells();
	}

	@Override
	public long addCell(Cell cell) {
		return cellMapper.addCell(cell);
	}

	@Override
	public int updateStationId(long stationId) {
		return cellMapper.updateStationId(stationId);
	}

	@Override
	public int deleteCell(long cellId) {
		int m = 0;
		int m1 = cellMapper.deleteCell(cellId);
		int m2 = cellMapper.deleteCellAndCategory(cellId);
		if (m1 > 0 && m2 > 0) {
			m = 1;
		}
		return m;
	}

	@Override
	public int deleteCellAndCategory(long cellId) {
		return cellMapper.deleteCellAndCategory(cellId);
	}

	@Override
	public int updateCell(Cell cell) {
		return cellMapper.updateCell(cell);
	}

	@Override
	public List<Cell> queryCellsByStationId(long stationId) {
		return cellMapper.queryCellsByStationId(stationId);
	}

}
