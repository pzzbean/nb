package com.ibase.web.workparam_in.mapper;

import java.util.List;

import com.ibase.web.workparam_in.domain.WorkParam_inDomain;

public interface WorkParam_inMapper {
	int updateWorkparam_in(WorkParam_inDomain workParam_in);
	
	long countWorkParam_in(WorkParam_inDomain workParam_in);
	
	List<WorkParam_inDomain> queryWorkParam_in(WorkParam_inDomain workParam_in);
	
	WorkParam_inDomain searchOneWorkParam_in(WorkParam_inDomain workParam_in);
	
	int insertWorkParam_in(WorkParam_inDomain workParam_in);

}
