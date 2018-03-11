package com.ibase.web.plane.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibase.web.plane.domain.Plane;
import com.ibase.web.plane.mapper.PlaneMapper;
import com.ibase.web.plane.service.PlaneService;
import com.ibase.web.user.domain.User;

@Service
public class PlaneServiceImpl implements PlaneService {
	@Autowired
	private PlaneMapper planeMapper;

	@Override
	public long countPlane(Plane plane) {
		return planeMapper.countPlane(plane);
	}

	@Override
	public List<Plane> queryPlane(Plane plane) {
		int currentPage = plane.getPage().getCurrentPage();
    	int pageSize = plane.getPage().getPageSize();
    	
		plane.getPage().setTotalRows((int)countPlane(plane));
		plane.getPage().setStartNum((currentPage-1)*pageSize);
		plane.getPage().setEndIndex(pageSize);
		System.out.println(plane.getUser_id());
		return planeMapper.queryPlane(plane);
	}

	@Override
	public Plane searchSinglePlane(Plane plane) {
		List<Plane> list = queryPlane(plane);
		if(list == null || list.size()<1)
		{
			return null;
		}
	    return list.get(0);
	}

	@Override
	public boolean updatePlane(Plane plane) {		
		return planeMapper.updatePlane(plane)>=0;
	}

	@Override
	public boolean insertPlane(Plane plane) {
		return planeMapper.insertPlane(plane)>0;
	}

	@Override
	public boolean deletePlane(long planeId) {		
		return planeMapper.deletePlane(planeId)>=0;
	}

}
