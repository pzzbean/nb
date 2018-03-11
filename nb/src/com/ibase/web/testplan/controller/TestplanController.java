package com.ibase.web.testplan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibase.core.http.ResponsePacket4;
import com.ibase.core.http.ResponsePacket2;
import com.ibase.web.localworkparam.domain.StationProperty;
import com.ibase.web.testplan.domain.SelectStationInfo;
import com.ibase.web.testplan.domain.Testplan;
import com.ibase.web.testplan.service.TestplanService;

@Controller
@RequestMapping(value = "/testplan")
public class TestplanController {
	@Autowired
	TestplanService testplanService;

	@Autowired
	protected HttpServletResponse response;

	@Autowired
	private HttpServletRequest request;

	@RequestMapping(path = "/queryTestplans")
	@ResponseBody
	public ResponsePacket2 queryTestplans() {
		List<Testplan> testplans = testplanService.queryTestplans();
		ResponsePacket2 json = new ResponsePacket2();
		json.setListObject(testplans);
		response.addHeader("Access-Control-Allow-Origin", "*");		
		return json;
	}

	@RequestMapping(path = "/queryTestplanByTestplanId")
	@ResponseBody
	public Testplan queryTestplanByTestplanId(Integer testplanId) {
		Integer id = Integer.valueOf(request.getParameter("testplanId"));
		Testplan testplan = testplanService.queryTestplanByTestplanId(id);
		response.addHeader("Access-Control-Allow-Origin", "*");
		return testplan;
	}

	@RequestMapping(path = "deleteTestplan")
	@ResponseBody
	public ResponsePacket4 deleteTestplan(Integer testplanId) {
		ResponsePacket4 json = new ResponsePacket4(-1 , "删除失败！");
		if (testplanService.deleteTestplan(testplanId)>0) {
			json.setCode(1);
			json.setMsg("删除成功！");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}
	
	@RequestMapping(path = "/queryAll")
	@ResponseBody
	public ResponsePacket2 queryAll(StationProperty stationProperty) {
		List<Long> stationIds = new ArrayList<>();
		String stationId = request.getParameter("stationId");
		stationId = stationId.substring(1, stationId.length()-1);
		System.out.println(stationId);
		String ids[] = stationId.split(",");
		for (String string : ids) {
			stationIds.add(Long.valueOf(string));
		}
		List<Map<String, List<? extends Object>>> list = testplanService.queryAll(stationIds, stationProperty);
		ResponsePacket2 json = new ResponsePacket2();
		json.setMaplist(list);
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
		
	}
	

	@RequestMapping(path = "/queryAll1")
	@ResponseBody
	public ResponsePacket2 queryAll1(StationProperty stationProperty) {
		List<Long> stationIds = new ArrayList<>();
		String stationId = request.getParameter("stationId");
		stationId = stationId.substring(1, stationId.length()-1);
		System.out.println(stationId);
		String ids[] = stationId.split(",");
		for (String string : ids) {
			stationIds.add(Long.valueOf(string));
		}
		List<SelectStationInfo> list = testplanService.queryAll1(stationIds, stationProperty);
		ResponsePacket2 json = new ResponsePacket2();
		response.addHeader("Access-Control-Allow-Origin", "*");json.setListObject(list);
		return json;
	}
	
	@RequestMapping(path = "/queryTestplanByUserId")
	@ResponseBody
	public Testplan queryTestplanByUserId(Integer userId) {
		Integer userId1 = Integer.valueOf(request.getParameter("userId"));
		Testplan testplan = testplanService.queryTestplanByUserId(userId1);
		response.addHeader("Access-Control-Allow-Origin", "*");
		return testplan;
	}
	
}
