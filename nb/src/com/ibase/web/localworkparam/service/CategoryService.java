package com.ibase.web.localworkparam.service;

import java.util.List;

import com.ibase.web.localworkparam.domain.Category;
import com.ibase.web.localworkparam.domain.CellProperty;

public interface CategoryService {

	// 查询所有类别
	List<Category> queryCategories(Category category);

	// 记录条数
	Integer countCategory();

	// 增加类别
	long addCategory(Category category);

	// 删除类别
	int deleteCategory(long categoryId);	
	
	// 修改小区属性表（类别删除后，将对应category_id置为0）
	int updateCellProperty(long categoryId);
	
	// 修改类别
	int updateCategory(Category category);

}