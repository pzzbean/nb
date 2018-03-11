package com.ibase.web.workparam.mapper;

import java.util.List;

import com.ibase.web.workparam.domain.WorkParamDomain;

public interface WorkParamMapper {
	public long countWorkParam(WorkParamDomain workParam);
	
	public List<WorkParamDomain> queryWorkParam(WorkParamDomain workParam);
	
	public WorkParamDomain searchOneWorkParam(WorkParamDomain workParam);
	
	public int deleteWorkparam(WorkParamDomain workParam);
	
	public int insertWorkParam(WorkParamDomain workParam);

}
