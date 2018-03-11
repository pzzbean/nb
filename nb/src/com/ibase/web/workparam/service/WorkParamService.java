package com.ibase.web.workparam.service;

import java.util.List;

import com.ibase.web.workparam.domain.WorkParamDomain;

public interface WorkParamService {
	public long countWorkParam(WorkParamDomain workParam);
	
	public List<WorkParamDomain> queryWorkParam(WorkParamDomain workParam);
	
	public WorkParamDomain searchOneWorkParam(WorkParamDomain workParam);
	
	public boolean deleteWorkparam(WorkParamDomain workParam);
	
	public boolean insertWorkParam(WorkParamDomain workParam);

}
