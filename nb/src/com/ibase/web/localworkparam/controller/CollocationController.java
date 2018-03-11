package com.ibase.web.localworkparam.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibase.core.http.ResponsePacket4;
import com.ibase.core.utils.StringUtil;
import com.ibase.web.localworkparam.domain.Collocation;
import com.ibase.web.localworkparam.service.CollocationService;

@Controller
@RequestMapping(value = "/collocation")
public class CollocationController {
	@Autowired
	CollocationService collocationService;

	@Autowired
	protected HttpServletResponse response;

	@RequestMapping(path = "/queryCollocations")
	@ResponseBody
	public ResponsePacket4 queryCollocations(Collocation collocation) {
		// 模糊查询
		if (!StringUtil.isEmpty(collocation.getCollocationName())) {
			collocation.setCollocationName("%" + collocation.getCollocationName() + "%");
		}

		List<Collocation> collocations = collocationService.queryCollocations(collocation);
		ResponsePacket4 json = new ResponsePacket4();
		json.setListObject(collocations);
		json.setPage(collocation.getPage());
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}
	
	@RequestMapping(path = "/deleteCollocationById")
	@ResponseBody
	public ResponsePacket4 deleteCollocationById(Integer collocationId) {
		ResponsePacket4 json = new ResponsePacket4(-1,"删除失败");
		if (collocationService.deleteCollocationById(collocationId)) {
			json.setMsg("删除成功");
			json.setCode(1);
		}	
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}
	
	@RequestMapping(path = "/insertCollocation")
	@ResponseBody
	public ResponsePacket4 insertCollocation(Collocation collocation) {
		ResponsePacket4 json = new ResponsePacket4(-1,"添加失败");
		if(StringUtil.isEmpty(collocation.getCollocationName())) {
			json.setMsg("配置名不能为空");
			return json;
		}
		if (collocationService.insertCollocation(collocation)) {
			json.setMsg("添加成功");
			json.setCode(1);
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}
	
	@RequestMapping(path = "/updateCollocation")
	@ResponseBody
	public ResponsePacket4 updateCollocation(Collocation collocation) {
		
		ResponsePacket4 json = new ResponsePacket4(-1,"修改失败");
		
		if(collocation.getCollocationId()<=0) {
			json.setMsg("配置id不能为空");
			return json;
		}	
		if(StringUtil.isEmpty(collocation.getCollocationName())) {
			json.setMsg("配置名不能为空");
			return json;
		}
		if (collocationService.updateCollocation(collocation)) {
			json.setMsg("修改成功");
			json.setCode(1);
		}	
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}

}
