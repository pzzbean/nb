package com.ibase.web.localworkparam.service;

import java.util.List;

import com.ibase.web.localworkparam.domain.Collocation;
import com.ibase.web.localworkparam.domain.IndexAndCollocation;

public interface IndexAndCollocationService {

	List<Collocation> queryCollocationsById(Integer indexId);

	int insertIndexAndCollocation(IndexAndCollocation indexAndCollocation);

	List<Collocation> queryNoCollocationsById(Integer indexId);

	boolean deleteIndexAndCollocation(IndexAndCollocation indexAndCollocation);

	boolean updateIndexAndCollocation(IndexAndCollocation indexAndCollocation);

}
