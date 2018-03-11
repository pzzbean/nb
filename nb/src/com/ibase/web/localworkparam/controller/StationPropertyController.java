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
import com.ibase.web.localworkparam.domain.StationProperty;
import com.ibase.web.localworkparam.service.StationPropertyService;

@Controller
@RequestMapping(value = "/stationproperty")
public class StationPropertyController {
	@Autowired
	StationPropertyService stationPropertyService;

	@Autowired
	protected HttpServletResponse response;

	@RequestMapping(path = "/addStationProperty")
	@ResponseBody
	public ResponsePacket4 addStationproperty(StationProperty stationproperty) {
		ResponsePacket4 json = new ResponsePacket4(-1, "添加失败！");
		if (stationPropertyService.addStationProperty(stationproperty) > 0) {
			json.setCode(1);
			json.setMsg("添加成功！");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}

	@RequestMapping(path = "/queryStationProperties")
	@ResponseBody
	public ResponsePacket4 stationProperties(StationProperty stationProperty) {
		List<StationProperty> stationProperties = stationPropertyService.queryStationProperties(stationProperty);
		ResponsePacket4 json = new ResponsePacket4();
		json.setListObject(stationProperties);
		json.setPage(stationProperty.getPage());
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;

	}

	@RequestMapping(path = "/deleteStationProperty")
	@ResponseBody
	public ResponsePacket4 deleteStationProperty(long stationPropertyId) {
		ResponsePacket4 json = new ResponsePacket4(-1, "删除失败！");

		if (stationPropertyService.deleteStationProperty(stationPropertyId) > 0) {
			json.setCode(1);
			json.setMsg("删除成功！");
		}
		return json;
	}

	@RequestMapping(path = "updateStationProperty")
	@ResponseBody
	public ResponsePacket4 updateStationProperty(StationProperty stationProperty) {
		ResponsePacket4 json = new ResponsePacket4(-1, "更新失败！");
		if (stationPropertyService.updateStationProperty(stationProperty) > 0) {
			json.setCode(1);
			json.setMsg("更新成功！");
		}
		return json;
	}

}
