package com.ibase.web.localworkparam.mapper;

import java.util.List;

import com.ibase.web.localworkparam.domain.Station;

public interface StationMapper {
	// 新增基站数据
	long addStation(Station station);

	// 根据基站id查询基站数据
	Station queryStationById(long stationId);

	// 查询全部基站数据
	List<Station> queryStations(Station station);

	// 删除基站数据
	int deleteStation(long stationId);

	// 修改基站数据
	int updateStation(Station station);

	// 记录条数
	Integer countStation();

	// 根据测试计划id查询所有基站
	List<Station> queryStationsByTestplanId(long testplanId);

}
