package com.ibase.web.plane.service;

import java.util.List;

import com.ibase.web.plane.domain.Plane;

public interface PlaneService {
	
   long countPlane(Plane plane);
	
   List<Plane> queryPlane(Plane plane); 
	
   Plane searchSinglePlane(Plane plane);
	
   boolean updatePlane(Plane plane);	
   
   boolean insertPlane(Plane plane);
   
   boolean deletePlane(long planeId);

}
