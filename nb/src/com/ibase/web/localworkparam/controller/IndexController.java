package com.ibase.web.localworkparam.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibase.core.http.ResponsePacket4;
import com.ibase.core.utils.StringUtil;
import com.ibase.web.localworkparam.domain.Index;
import com.ibase.web.localworkparam.service.IndexService;

@Controller
@RequestMapping(value = "/index")
public class IndexController {
	@Autowired
	IndexService indexService;

	@Autowired
	protected HttpServletResponse response;

	@Autowired
	private HttpServletRequest request;

	@RequestMapping(path = "/queryIndexes")
	@ResponseBody
	public ResponsePacket4 queryIndexes(Index index) {
		// 模糊查询
		if (!StringUtil.isEmpty(index.getIndexName())) {
			index.setIndexName("%" + index.getIndexName() + "%");
		}
		List<Index> indexes = indexService.queryIndexes(index);
		ResponsePacket4 json = new ResponsePacket4();
		System.out.println(indexes);
		json.setListObject(indexes);
		json.setPage(index.getPage());
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}

	@RequestMapping(path = "/selectIndex")
	@ResponseBody
	public ResponsePacket4 selectIndex(Index index) {
		List<Index> index1 = indexService.selectIndex(index);
		ResponsePacket4 json = new ResponsePacket4();
		json.setListObject(index1);
		json.setPage(index.getPage());
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;

	}

	@RequestMapping(path = "/insertIndex")
	@ResponseBody
	public ResponsePacket4 insertIndex(Index index) {
		ResponsePacket4 json = new ResponsePacket4(-1, "添加失败");
		if (StringUtil.isEmpty(index.getIndexName())) {
			json.setMsg("指标名不能为空");
			return json;
		}
		if (indexService.insertIndex(index)) {
			json.setMsg("添加成功");
			json.setCode(1);
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}

	@RequestMapping(path = "/updateIndex")
	@ResponseBody
	public ResponsePacket4 updateIndex(Index index) {
		ResponsePacket4 json = new ResponsePacket4(-1, "修改失败");
		if (index.getIndexId() <= 0) {
			json.setMsg("指标id不能为空");
			return json;
		}
		if (StringUtil.isEmpty(index.getIndexName())) {
			json.setMsg("指标名不能为空");
			return json;
		}
		if (indexService.updateIndex(index)) {
			json.setMsg("修改成功");
			json.setCode(1);
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}

	@RequestMapping(path = "/deleteIndex")
	@ResponseBody
	public ResponsePacket4 deleteIndex(Integer indexId) {
		ResponsePacket4 json = new ResponsePacket4(-1, "删除失败");
		if (indexService.deleteIndex(indexId)) {
			json.setMsg("删除成功");
			json.setCode(1);
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}
}
