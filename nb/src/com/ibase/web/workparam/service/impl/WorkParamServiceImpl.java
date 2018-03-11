package com.ibase.web.workparam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibase.web.workparam.domain.WorkParamDomain;
import com.ibase.web.workparam.mapper.WorkParamMapper;
import com.ibase.web.workparam.service.WorkParamService;

@Service
public class WorkParamServiceImpl implements WorkParamService {
	@Autowired
	private WorkParamMapper workParamMapper;

	@Override
	public long countWorkParam(WorkParamDomain workParam) {
		return workParamMapper.countWorkParam(workParam);
	}

	@Override
	public List<WorkParamDomain> queryWorkParam(WorkParamDomain workParam) {
		int currentPage = workParam.getPage().getCurrentPage();
		int pageSize = workParam.getPage().getPageSize();
		
		workParam.getPage().setTotalRows((int)countWorkParam(workParam));
		workParam.getPage().setStartNum((currentPage-1)*pageSize);
		workParam.getPage().setEndIndex(pageSize);		
		
		return workParamMapper.queryWorkParam(workParam);
	}

	@Override
	public WorkParamDomain searchOneWorkParam(WorkParamDomain workParam) {
		List<WorkParamDomain> list = queryWorkParam(workParam);
		if(list == null || list.size()<1)
		{
			return null;
		}
	    return list.get(0);
	}

	@Override
	public boolean deleteWorkparam(WorkParamDomain workParam) {
		
		return workParamMapper.deleteWorkparam(workParam)>=0;
	}

	@Override
	public boolean insertWorkParam(WorkParamDomain workParam) {
		return workParamMapper.insertWorkParam(workParam)>=0;
	}

}
