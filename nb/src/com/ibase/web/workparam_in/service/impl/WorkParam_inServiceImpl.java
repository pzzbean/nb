package com.ibase.web.workparam_in.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibase.web.workparam_in.domain.WorkParam_inDomain;
import com.ibase.web.workparam_in.mapper.WorkParam_inMapper;
import com.ibase.web.workparam_in.service.WorkParam_inService;

@Service
public class WorkParam_inServiceImpl implements WorkParam_inService {
	@Autowired
	private WorkParam_inMapper workParam_inMapper;

	@Override
	public long countWorkParam_in(WorkParam_inDomain workParam_in) {
		return workParam_inMapper.countWorkParam_in(workParam_in);
	}

	@Override
	public List<WorkParam_inDomain> queryWorkParam_in(WorkParam_inDomain workParam_in) {
		int currentPage = workParam_in.getPage().getCurrentPage();
    	int pageSize = workParam_in.getPage().getPageSize();
    	//System.out.println(pageSize);
    	
    	workParam_in.getPage().setTotalRows((int)countWorkParam_in(workParam_in));
    	workParam_in.getPage().setStartNum((currentPage-1)*pageSize);
    	workParam_in.getPage().setEndIndex(pageSize);
		
		return workParam_inMapper.queryWorkParam_in(workParam_in);
	}

	@Override
	public WorkParam_inDomain searchOneWorkParam_in(WorkParam_inDomain workParam_in) {
		List<WorkParam_inDomain> list = queryWorkParam_in(workParam_in);
		if(list == null || list.size()<1)
		{
			return null;
		}
	    return list.get(0);
	}

	@Override
	public boolean updateWorkparam_in(WorkParam_inDomain workParam_in) {		
		return workParam_inMapper.updateWorkparam_in(workParam_in)>=0;
	}

	@Override
	public boolean insertWorkParam_in(WorkParam_inDomain workParam_in) {
		return workParam_inMapper.insertWorkParam_in(workParam_in)>=0;
	}

}
