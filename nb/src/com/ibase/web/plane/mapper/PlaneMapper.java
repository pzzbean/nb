package com.ibase.web.plane.mapper;

import java.util.List;

import com.ibase.web.plane.domain.Plane;

public interface PlaneMapper {
	
	 long countPlane(Plane plane);
	
	 List<Plane> queryPlane(Plane plane);
	 
	 int updatePlane(Plane plane);	
	 
	 int insertPlane(Plane plane);
	 
	 int deletePlane(long planeId);

}
