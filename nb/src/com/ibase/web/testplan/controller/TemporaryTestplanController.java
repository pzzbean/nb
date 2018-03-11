package com.ibase.web.testplan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibase.core.http.ResponsePacket2;
import com.ibase.core.http.ResponsePacket3;
import com.ibase.core.http.ResponsePacket4;
import com.ibase.web.roadtest.domain2.Station_new;
import com.ibase.web.testplan.domain.TemporaryTestplan;
import com.ibase.web.testplan.service.TemporaryTestplanService;

@Controller
@RequestMapping(value = "/temporarytestplan")
public class TemporaryTestplanController {
	@Autowired
	TemporaryTestplanService temporaryTestplanService;

	@Autowired
	protected HttpServletResponse response;

	@Autowired
	private HttpServletRequest request;

	@RequestMapping(path = "/queryTestplans")
	@ResponseBody
	public ResponsePacket2 queryTestplans() {
		List<TemporaryTestplan> testplans = temporaryTestplanService.queryTemporaryTestplans();
		ResponsePacket2 json = new ResponsePacket2();
		json.setListObject(testplans);
		response.addHeader("Access-Control-Allow-Origin", "*");		
		return json;
	}
	
	@RequestMapping(path = "/queryTestplansByCondition")
	@ResponseBody
	public ResponsePacket2 queryTestplansByCondition(TemporaryTestplan temporaryTestplan) {
		List<TemporaryTestplan> queryTemporaryTestplansByCondition = temporaryTestplanService.queryTemporaryTestplansByCondition(temporaryTestplan);
		ResponsePacket2 json = new ResponsePacket2();
		json.setListObject(queryTemporaryTestplansByCondition);
		response.addHeader("Access-Control-Allow-Origin", "*");		
		return json;
	}
	
	@RequestMapping(path = "/insertTestplans")
	@ResponseBody
	public ResponsePacket4 insertTestplans(TemporaryTestplan temporaryTestplan) {
		ResponsePacket4 json = new ResponsePacket4(-1 , "添加失败！");
		if (temporaryTestplanService.insertTemporaryTestPlans(temporaryTestplan)>0) {
			json.setCode(1);
			json.setMsg("添加成功！");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}
	
	
	@RequestMapping(path = "/delTemporaryTestPlans")
	@ResponseBody
	public ResponsePacket4 delTemporaryTestPlans(long temporaryTestplanId) {
		ResponsePacket4 json = new ResponsePacket4(-1 , "删除失败！");
		if (temporaryTestplanService.delTemporaryTestPlans(temporaryTestplanId)>0) {
			json.setCode(1);
			json.setMsg("删除成功！");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}
	
	
	@RequestMapping(path = "/updTemporaryTestPlans")
	@ResponseBody
	public ResponsePacket4 updTemporaryTestPlans(TemporaryTestplan temporaryTestplan,long temporaryTestplanId) {
		//temporaryTestplan.setTestEngineer("12");
		//temporaryTestplanId=1;
		ResponsePacket4 json = new ResponsePacket4(-1 , "修改失败！");
		if (temporaryTestplanService.updTemporaryTestPlans(temporaryTestplan, temporaryTestplanId)>0) {
			json.setCode(1);
			json.setMsg("修改成功！");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}
	/**
	 * 根据userId,和testStartTime查询对应的基站及其对应的小区和每个小区对应需要测试的测试项，每个测试项对应的测试配置
	 * @param userId
	 * @param testDate
	 * @return
	 */
	@RequestMapping("/selectAllStation")
	@ResponseBody
	public ResponsePacket3 selectAllStation(String userId , String testStartTime){
		/*TemporaryTestplan temporaryTestplan = new TemporaryTestplan();
		temporaryTestplan.setUserId(userId);
		temporaryTestplan.setTestStartTime(testDate);*/
		ResponsePacket3 json = new ResponsePacket3(-1, "查询测试计划数据失败！");
		List<Station_new> list = temporaryTestplanService.selectAllStation(userId , testStartTime);
		//System.out.println("list:"+list);
		if (list.size() > 0) {
			json.setDataSource(list);
			json.setResultCode(1);
			json.setmMessage("查询测试计划数据成功！");
		} else {
			json.setResultCode(0);
			json.setmMessage("未查到测试计划数据！");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		//TemporaryTestplan temporaryTestplan1 = temporaryTestplanService.selectAllStation(temporaryTestplan);
		//System.out.println(temporaryTestplan1);
		return json;
	}
	
}
