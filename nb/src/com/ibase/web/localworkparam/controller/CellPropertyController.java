package com.ibase.web.localworkparam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibase.core.http.ResponsePacket4;
import com.ibase.web.localworkparam.domain.Cell;
import com.ibase.web.localworkparam.domain.CellProperty;
import com.ibase.web.localworkparam.domain.StationProperty;
import com.ibase.web.localworkparam.service.CellPropertyService;

@Controller
@RequestMapping(value = "/cellproperty")
public class CellPropertyController {
	@Autowired
	CellPropertyService cellPropertyService;

	@Autowired
	protected HttpServletResponse response;

	@Autowired
	private HttpServletRequest request;

	@RequestMapping(path = "/addCellProperty")
	@ResponseBody
	public ResponsePacket4 addCellProperty(CellProperty cellProperty) {
		ResponsePacket4 json = new ResponsePacket4(-1, "添加失败！");
		if (cellPropertyService.addCellProperty(cellProperty) > 0) {
			json.setCode(1);
			json.setMsg("添加成功！");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}

	@RequestMapping(path = "/queryCellPropertiesByCellId")
	@ResponseBody
	public List<CellProperty> queryCellPropertiesByCellId(Integer cellId) {
		Integer cellId1 = Integer.valueOf(request.getParameter("cellId"));
		List<CellProperty> cellProperties = cellPropertyService.queryCellPropertiesByCellId(cellId);
		response.addHeader("Access-Control-Allow-Origin", "*");
		return cellProperties;
	}

	@RequestMapping(path = "/queryCellProperties")
	@ResponseBody
	public ResponsePacket4 queryCellProperties(CellProperty cellProperty) {
		List<CellProperty> cellProperties = cellPropertyService.queryCellProperties(cellProperty);
		ResponsePacket4 json = new ResponsePacket4();
		json.setListObject(cellProperties);
		json.setPage(cellProperty.getPage());
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}

	@RequestMapping(path = "/deleteCellProperty")
	@ResponseBody
	public ResponsePacket4 deleteCellProperty(long cellPropertyId) {
		ResponsePacket4 json = new ResponsePacket4(-1, "删除失败！");

		if (cellPropertyService.deleteCellProperty(cellPropertyId) > 0) {
			json.setCode(1);
			json.setMsg("删除成功！");
		}
		return json;
	}

	@RequestMapping(path = "updateCellProperty")
	@ResponseBody
	public ResponsePacket4 updateCellProperty(CellProperty cellProperty) {
		ResponsePacket4 json = new ResponsePacket4(-1, "更新失败！");
		if (cellPropertyService.updateCellProperty(cellProperty) > 0) {
			json.setCode(1);
			json.setMsg("更新成功！");
		}
		return json;
	}
}
