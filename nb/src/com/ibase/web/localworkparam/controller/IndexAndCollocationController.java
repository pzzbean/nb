package com.ibase.web.localworkparam.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.ibase.core.http.ResponsePacket4;
import com.ibase.web.localworkparam.domain.Collocation;
import com.ibase.web.localworkparam.domain.IndexAndCollocation;
import com.ibase.web.localworkparam.service.IndexAndCollocationService;

@Controller
@RequestMapping(value = "/indexAndCollocation")
public class IndexAndCollocationController {
	@Autowired
	IndexAndCollocationService indexAndCollocationService;

	@Autowired
	protected HttpServletResponse response;

	@RequestMapping(path = "/queryCollocationsById")
	@ResponseBody
	public List<Collocation> queryCollocationsById(Integer indexId) {
		System.out.println(indexId);
		List<Collocation> Collocations = indexAndCollocationService.queryCollocationsById(indexId);
		response.addHeader("Access-Control-Allow-Origin", "*");
		return Collocations;
	}

	@RequestMapping(path = "/insertIndexAndCollocation")
	@ResponseBody
	public ResponsePacket4 insertIndexAndCollocation(IndexAndCollocation indexAndCollocation) {
		response.addHeader("Access-Control-Allow-Origin", "*");

		ResponsePacket4 json = new ResponsePacket4(-1, "添加失败！");
		if (indexAndCollocationService.insertIndexAndCollocation(indexAndCollocation) > 0) {
			json.setCode(1);
			json.setMsg("添加成功！");
		}
		return json;
	}

	/**
	 * 查询未配置的配置项
	 * 
	 * @param indexId
	 * @return
	 */
	@RequestMapping(path = "/queryNoCollocationsById")
	@ResponseBody
	public List<Collocation> queryNoCollocationsById(Integer indexId) {
		System.out.println(indexId);
		List<Collocation> Collocations = indexAndCollocationService.queryNoCollocationsById(indexId);
		response.addHeader("Access-Control-Allow-Origin", "*");
		return Collocations;
	}

	@RequestMapping(path = "/deleteIndexAndCollocation")
	@ResponseBody
	public ResponsePacket4 deleteIndexAndCollocation(IndexAndCollocation indexAndCollocation) {
		response.addHeader("Access-Control-Allow-Origin", "*");

		ResponsePacket4 json = new ResponsePacket4(-1, "删除失败！");
		if (indexAndCollocationService.deleteIndexAndCollocation(indexAndCollocation)) {
			json.setCode(1);
			json.setMsg("删除成功！");
		}

		return json;
	}

	@RequestMapping(path = "/updateIndexAndCollocation")
	@ResponseBody
	public ResponsePacket4 updateIndexAndCollocation(String updateConllectionValue, String indexId) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		System.out.println("p" + indexId);
		System.out.println("5" + updateConllectionValue);
		ResponsePacket4 json = new ResponsePacket4(-1, "修改失败！");
		JSONArray jsonArray = JSONArray.parseArray(updateConllectionValue);
		List<IndexAndCollocation> list = (List<IndexAndCollocation>) jsonArray.toJavaList(IndexAndCollocation.class);
		for (IndexAndCollocation indexAndCollocation : list) {
			System.out.println("ok"+indexAndCollocation.getCollocationId());
			if (indexAndCollocationService.updateIndexAndCollocation(indexAndCollocation)) {
				json.setCode(1);
				System.out.println("ok2"+indexAndCollocation.getCollocationId());
				json.setMsg("修改成功！");
			}
			System.out.println("ok3"+indexAndCollocation.getCollocationId());
		}

		return json;
	}
}
