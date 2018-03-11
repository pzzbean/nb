package com.ibase.web.localworkparam.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibase.core.http.ResponsePacket4;
import com.ibase.web.localworkparam.domain.Cell;
import com.ibase.web.localworkparam.domain.Station;
import com.ibase.web.localworkparam.mapper.CellMapper;
import com.ibase.web.localworkparam.service.CellService;

@Controller
@RequestMapping(value = "/cell")
public class CellController {
	@Autowired
	CellService cellService;

	@Autowired
	protected HttpServletResponse response;

	@RequestMapping(path = "/addCell")
	@ResponseBody
	public ResponsePacket4 addCell(Cell cell) {
		ResponsePacket4 json = new ResponsePacket4(-1, "添加失败！");
		if (cellService.addCell(cell) > 0) {
			json.setCode(1);
			json.setMsg("添加成功！");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}

	@RequestMapping(path = "/queryCells")
	@ResponseBody
	public ResponsePacket4 queryCells(Cell cell) {
		Cell cell2 = cell;

		List<Cell> cells = cellService.queryCells(cell2);
		ResponsePacket4 json = new ResponsePacket4();
		json.setListObject(cells);

		json.setPage(cell2.getPage());
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}

	@RequestMapping(path = "/deleteCells")
	@ResponseBody
	public ResponsePacket4 deleteCell(long cellId) {
		int m = 0;
		ResponsePacket4 json = new ResponsePacket4(-1, "删除失败！");
		m = cellService.deleteCell(cellId);
		if (m > 0) {
			json.setCode(1);
			json.setMsg("删除成功！");
		}
		return json;
	}

	@RequestMapping(path = "updateCell")
	@ResponseBody
	public ResponsePacket4 updateCell(Cell cell) {
		ResponsePacket4 json = new ResponsePacket4(-1, "更新失败！");
		if (cellService.updateCell(cell) > 0) {
			json.setCode(1);
			json.setMsg("更新成功！");
		}
		return json;
	}

	@RequestMapping(path = "/queryCellsByStationId")
	@ResponseBody
	public ResponsePacket4 queryCellsByStationId(long stationId) {
		List<Cell> cells = cellService.queryCellsByStationId(stationId);
		ResponsePacket4 json = new ResponsePacket4();
		json.setListObject(cells);
		return json;
	}
}
