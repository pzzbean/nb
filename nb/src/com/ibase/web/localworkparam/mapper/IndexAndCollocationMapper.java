package com.ibase.web.localworkparam.mapper;

import java.util.List;

import com.ibase.web.localworkparam.domain.Collocation;
import com.ibase.web.localworkparam.domain.IndexAndCollocation;

public interface IndexAndCollocationMapper {
	
	List<Collocation> queryCollocationsById(Integer indexId);

	int insertIndexAndCollocation(IndexAndCollocation indexAndCollocation);

	List<Collocation> queryNoCollocationsById(Integer indexId);

	long deleteIndexAndCollocation(IndexAndCollocation indexAndCollocation);

	long updateIndexAndCollocation(IndexAndCollocation indexAndCollocation);

}
