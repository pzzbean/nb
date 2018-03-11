package com.ibase.web.localworkparam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibase.core.http.ResponsePacket4;
import com.ibase.web.localworkparam.domain.Station;
import com.ibase.web.localworkparam.service.StationService;

@Controller
@RequestMapping(value = "/station")
public class StationController {
	@Autowired
	StationService stationService;

	@Autowired
	protected HttpServletResponse response;

	@Autowired
	private HttpServletRequest request;

	@RequestMapping(path = "/addStation")
	@ResponseBody
	public ResponsePacket4 addStation(Station station) {
		ResponsePacket4 json = new ResponsePacket4(-1, "添加失败！");
		if (stationService.addStation(station) > 0) {
			json.setCode(1);
			json.setMsg("添加成功！");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}

	@RequestMapping(path = "/queryStation")
	@ResponseBody
	public Station queryStationById(Integer id) {
		Integer id1 = Integer.valueOf(request.getParameter("id"));
		Station station = stationService.queryStationById(id1);
		response.addHeader("Access-Control-Allow-Origin", "*");
		return station;
	}

	@RequestMapping(path = "/queryStations")
	@ResponseBody
	public ResponsePacket4 queryStations(Station station) {

		Station station1 = new Station();
		List<Station> stations = stationService.queryStations(station);
		ResponsePacket4 json = new ResponsePacket4();
		json.setListObject(stations);
		json.setPage(station1.getPage());
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}

	@RequestMapping(path = "/deleteStation")
	@ResponseBody
	public ResponsePacket4 deleteStation(long stationId) {
		int m = 0;
		ResponsePacket4 json = new ResponsePacket4(-1, "删除失败！");
		m = stationService.deleteStation(stationId);
		if (m > 0) {
			json.setCode(1);
			json.setMsg("删除成功！");
		}
		return json;
	}

	@RequestMapping(path = "updateStation")
	@ResponseBody
	public ResponsePacket4 updateStation(Station station) {
		ResponsePacket4 json = new ResponsePacket4(-1, "更新失败！");
		if (stationService.updateStation(station) > 0) {
			json.setCode(1);
			json.setMsg("更新成功！");
		}
		return json;
	}
	
	@RequestMapping(path = "queryStationsByTestplanId")
	@ResponseBody
	public ResponsePacket4 queryStationsByTestplanId(long testplanId) {
		long id = Integer.valueOf(request.getParameter("testplanId"));
		List<Station> stations = stationService.queryStationsByTestplanId(id);
		ResponsePacket4 json = new ResponsePacket4();
		json.setListObject(stations);
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}
}
