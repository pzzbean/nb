package com.ibase.web.localworkparam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibase.web.localworkparam.domain.Category;
import com.ibase.web.localworkparam.domain.CellProperty;
import com.ibase.web.localworkparam.mapper.CategoryMapper;
import com.ibase.web.localworkparam.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryMapper categoryMapper;

	@Override
	public List<Category> queryCategories(Category category) {

		int currentPage = category.getPage().getCurrentPage();
		int pageSize = category.getPage().getPageSize();
		category.getPage().setTotalRows(countCategory());
		category.getPage().setStartNum((currentPage - 1) * pageSize);
		category.getPage().setEndIndex(pageSize);

		List<Category> categories = categoryMapper.queryCategories(category);
		return categories;
	}

	@Override
	public Integer countCategory() {
		return categoryMapper.countCategory();
	}

	@Override
	public long addCategory(Category category) {
		return categoryMapper.addCategory(category);
	}

	@Override
	public int deleteCategory(long categoryId) {
		int m = 0;
		int m1 = categoryMapper.deleteCategory(categoryId);
		int m2 = categoryMapper.updateCellProperty(categoryId);
		if (m1 > 0 && m2 > 0) {
			m = 1;
		}
		return m;
	}

	@Override
	public int updateCellProperty(long categoryId) {
		return categoryMapper.updateCellProperty(categoryId);
	}

	@Override
	public int updateCategory(Category category) {
		return categoryMapper.updateCategory(category);
	}

}
