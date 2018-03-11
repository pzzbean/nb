package com.ibase.web.localworkparam.mapper;

import java.util.List;

import com.ibase.web.localworkparam.domain.StationProperty;

public interface StationPropertyMapper {

	// 查询所有基站属性
	List<StationProperty> queryStationProperties(StationProperty stationProperty);

	// 查询所有基站属性
	List<StationProperty> queryStationProperties2(StationProperty stationProperty);

	// 记录条数
	Integer countStationProperties();

	// 增加基站属性
	long addStationProperty(StationProperty stationProperty);

	// 删除基站属性
	int deleteStationProperty(long stationPropertyId);

	// 修改基站属性
	int updateStationProperty(StationProperty stationProperty);
}
