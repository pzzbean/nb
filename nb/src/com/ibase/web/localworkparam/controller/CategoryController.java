package com.ibase.web.localworkparam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibase.core.http.ResponsePacket4;
import com.ibase.web.localworkparam.domain.Category;
import com.ibase.web.localworkparam.domain.Cell;
import com.ibase.web.localworkparam.service.CategoryService;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@Autowired
	protected HttpServletResponse response;

	@Autowired
	private HttpServletRequest request;

	@RequestMapping(path = "/addCategory")
	@ResponseBody
	public ResponsePacket4 addCategory(Category category) {
		ResponsePacket4 json = new ResponsePacket4(-1, "添加失败！");
		if (categoryService.addCategory(category) > 0) {
			json.setCode(1);
			json.setMsg("添加成功！");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}

	@RequestMapping(path = "/queryCategories")
	@ResponseBody
	public ResponsePacket4 queryCategories(Category category) {

		List<Category> categories = categoryService.queryCategories(category);
		ResponsePacket4 json = new ResponsePacket4();
		json.setListObject(categories);

		json.setPage(category.getPage());
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}

	@RequestMapping(path = "/deleteCategory")
	@ResponseBody
	public ResponsePacket4 deleteCategory(long categoryId) {
		int m = 0;
		ResponsePacket4 json = new ResponsePacket4(-1, "删除失败！");
		m = categoryService.deleteCategory(categoryId);
		if (m > 0) {
			json.setCode(1);
			json.setMsg("删除成功！");
		}
		return json;
	}
	
	@RequestMapping(path = "updateCategory")
	@ResponseBody
	public ResponsePacket4 updateCategory(Category category) {
		ResponsePacket4 json = new ResponsePacket4(-1, "更新失败！");
		if (categoryService.updateCategory(category) > 0) {
			json.setCode(1);
			json.setMsg("更新成功！");
		}
		return json;
	}

}
