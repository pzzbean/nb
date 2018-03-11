package com.ibase.web.workparam_in.service;

import java.util.List;

import com.ibase.web.workparam.domain.WorkParamDomain;
import com.ibase.web.workparam_in.domain.WorkParam_inDomain;

public interface WorkParam_inService {
	boolean updateWorkparam_in(WorkParam_inDomain workParam_in);
	
	long countWorkParam_in(WorkParam_inDomain workParam_in);
	
	List<WorkParam_inDomain> queryWorkParam_in(WorkParam_inDomain workParam_in);
	
	WorkParam_inDomain searchOneWorkParam_in(WorkParam_inDomain workParam_in);
	
	boolean insertWorkParam_in(WorkParam_inDomain workParam_in);

}
