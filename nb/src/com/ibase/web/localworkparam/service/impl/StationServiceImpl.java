package com.ibase.web.localworkparam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibase.web.localworkparam.domain.Station;
import com.ibase.web.localworkparam.mapper.CellMapper;
import com.ibase.web.localworkparam.mapper.StationMapper;
import com.ibase.web.localworkparam.service.StationService;

@Service
public class StationServiceImpl implements StationService {

	@Autowired
	StationMapper stationMapper;

	@Autowired
	CellMapper cellMapper;

	@Override
	public long addStation(Station station) {
		return stationMapper.addStation(station);
	}

	@Override
	public int deleteStation(long stationId) {
		int m = 0;
		int m1 = stationMapper.deleteStation(stationId);
		System.out.println("m1"+m1);
		int m2 = cellMapper.updateStationId(stationId);
		System.out.println("m2"+m2);
		if (m1 == 1 && m2 == 1) {
			m = 1;
		}
		return m;
	}

	@Override
	public int updateStation(Station station) {
		return stationMapper.updateStation(station);
	}

	@Override
	public Station queryStationById(long stationId) {
		// 根据基站id查询基站数据
		Station station = stationMapper.queryStationById(stationId);
		return station;
	}

	@Override
	public List<Station> queryStations(Station station) {

		int currentPage = station.getPage().getCurrentPage();
		int pageSize = station.getPage().getPageSize();
		station.getPage().setTotalRows(countStation());

		System.out.println(station.getPage().getTotalRows());
		System.out.println("小区表总条目count：" + countStation());

		station.getPage().setStartNum((currentPage - 1) * pageSize);
		station.getPage().setEndIndex(pageSize);
		// 查询全部基站数据
		List<Station> stations = stationMapper.queryStations(station);
		return stations;
	}

	@Override
	public Integer countStation() {
		return stationMapper.countStation();
	}

	@Override
	public List<Station> queryStationsByTestplanId(long testplanId) {
		// TODO Auto-generated method stub
		return stationMapper.queryStationsByTestplanId(testplanId);
	}

}
