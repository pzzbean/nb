package com.ibase.web.localworkparam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibase.web.localworkparam.domain.StationProperty;
import com.ibase.web.localworkparam.mapper.StationMapper;
import com.ibase.web.localworkparam.mapper.StationPropertyMapper;
import com.ibase.web.localworkparam.service.StationPropertyService;

@Service
public class StationPropertyServiceImpl implements StationPropertyService {
	
	@Autowired
	StationPropertyMapper stationPropertymapper;

	@Override
	public List<StationProperty> queryStationProperties(StationProperty stationProperty) {
		
		int currentPage = stationProperty.getPage().getCurrentPage();
		int pageSize = stationProperty.getPage().getPageSize();
		stationProperty.getPage().setTotalRows(countStationProperties());
		stationProperty.getPage().setStartNum((currentPage - 1) * pageSize);
		stationProperty.getPage().setEndIndex(pageSize);
		List<StationProperty> stationProperties = stationPropertymapper.queryStationProperties(stationProperty);
		return stationProperties;
	}

	@Override
	public Integer countStationProperties() {
		return stationPropertymapper.countStationProperties();
	}

	@Override
	public long addStationProperty(StationProperty stationProperty) {
		return stationPropertymapper.addStationProperty(stationProperty);
	}

	@Override
	public int deleteStationProperty(long stationPropertyId) {
		return stationPropertymapper.deleteStationProperty(stationPropertyId);
	}

	@Override
	public int updateStationProperty(StationProperty stationProperty) {
		return stationPropertymapper.updateStationProperty(stationProperty);
	}

	@Override
	public List<StationProperty> queryStationProperties2(StationProperty stationProperty) {
		return stationPropertymapper.queryStationProperties2(stationProperty);
	}

}
