package com.ibase.web.testplan.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibase.web.localworkparam.domain.Cell;
import com.ibase.web.localworkparam.domain.CellProperty;
import com.ibase.web.localworkparam.domain.Index;
import com.ibase.web.localworkparam.domain.Station;
import com.ibase.web.localworkparam.domain.StationProperty;
import com.ibase.web.localworkparam.domain.queryAllDao.QueryCellCategoryWorkParms;
import com.ibase.web.localworkparam.service.CellPropertyService;
import com.ibase.web.localworkparam.service.CellService;
import com.ibase.web.localworkparam.service.IndexService;
import com.ibase.web.localworkparam.service.StationPropertyService;
import com.ibase.web.localworkparam.service.StationService;
import com.ibase.web.testplan.domain.SelectStationInfo;
import com.ibase.web.testplan.domain.StationCellsInfo;
import com.ibase.web.testplan.domain.Testplan;
import com.ibase.web.testplan.mapper.TestplanMapper;
import com.ibase.web.testplan.service.TestplanService;


@Service
public class TestplanServiceImpl implements TestplanService {

	@Autowired
	TestplanMapper testplanMapper;

	@Autowired
	StationService stationService;

	@Autowired
	StationPropertyService stationPropertyService;

	@Autowired
	CellService cellService;

	@Autowired
	CellPropertyService cellPropertySevice;
	@Autowired
	IndexService indexService;

	@Override
	public List<Testplan> queryTestplans() {
		List<Testplan> testplans = testplanMapper.queryTestplans();
		return testplans;
	}

	@Override
	public Testplan queryTestplanByTestplanId(long testplanId) {
		Testplan testplan = testplanMapper.queryTestplanByTestplanId(testplanId);
		return testplan;
	}

	/*
	 * @Override public int addTestplan(Testplan testplan) { int m = 0; // 添加方法
	 * int m1 = testplanMapper.addTestplan(testplan);// 添加数据到测试计划表 int m2 =
	 * testplanMapper.addOther(testplan);// 添加计划到其他表 if (m1 == 1 && m2 == 1) { m
	 * = 1; } return m; }
	 */

	@Override
	public int deleteTestplan(long testplanId) {
		int deleteTestplan = testplanMapper.deleteTestplan(testplanId);
		return deleteTestplan;
	}

	@Override
	public List<Map<String, List<? extends Object>>> queryAll(List<Long> stationIds, StationProperty stationProperty) {
		List<Map<String, List<? extends Object>>> list = new ArrayList<Map<String, List<? extends Object>>>();

		// 遍历基站id
		for (int i = 0; i < stationIds.size(); i++) {
			Map<String, List<? extends Object>> map = new TreeMap<String, List<? extends Object>>();
			
			long id = stationIds.get(i);
			System.out.println("基站ID："+id);
			Station station = stationService.queryStationById(stationIds.get(i));
			//System.out.println("基站的信息："+station.toString());
			List<Station> listStation = new ArrayList<>();
			Station station1 = new Station();
			station1.setStationId(id);
			try {

					listStation.add(station1);
					map.put("station", listStation);
				
			} catch (Exception e) {
				System.out.println("查询基站信息，该基站为空");
			}
			
			
			// 查询所有的基站属性
			List<StationProperty> listStationProperty = stationPropertyService.queryStationProperties2(stationProperty);
			map.put("listStationProperty", listStationProperty);
			
			// 根据基站id查询小区表中对应的小区，获取小区id（集合），再套循环
			List<Cell> listCell = cellService.queryCellsByStationId(stationIds.get(i));
			map.put("listCell", listCell);
			for (int j = 0; j < listCell.size(); j++) {
				long cellId = listCell.get(j).getCellId();
				String cellid = String.valueOf(cellId);
				// 根据小区id查询对应的类别以及类别对应的属性
				List<CellProperty> listCellProperty = cellPropertySevice.queryCellPropertiesByCellId(cellId);
				map.put(cellid+"CellProperty", listCellProperty);
				// 根据小区id查询对应的所有指标
				List<Index> listIndex = indexService.queryIndexesByCellId(cellId);
				map.put(cellid+"Index", listIndex);
			}
			list.add((Map<String, List<? extends Object>>) map);

		}
		return list;
	}

	
	

	
	public List<SelectStationInfo> queryAll1(List<Long> stationIds, StationProperty stationProperty) {
		List <SelectStationInfo> listSelectStationInfo=new ArrayList<>();
		// 遍历基站id
		for (int i = 0; i < stationIds.size(); i++) {
			List<StationCellsInfo> listStationCellsInfo = new ArrayList<>();
			
			SelectStationInfo selectStationInfo = new SelectStationInfo();
			long id = stationIds.get(i);
			System.out.println("基站ID："+id);
			Station station = stationService.queryStationById(stationIds.get(i));//根据基站id查询基站
			
			selectStationInfo.setStationId(station.getStationId());//设置基站id
			selectStationInfo.setStationName(station.getStationName());//设置基站名字
			
			// 查询所有的基站属性
			List<StationProperty> listStationProperty = stationPropertyService.queryStationProperties2(stationProperty);
			selectStationInfo.setListStationProperty(listStationProperty);//设置基站属性
			
			// 根据基站id查询对应基站下面的小区
			List<Cell> listCell = cellService.queryCellsByStationId(stationIds.get(i));
			for (Cell cell : listCell) {
				StationCellsInfo sci = new StationCellsInfo();
				sci.setCellId(cell.getCellId());
				sci.setCellName(cell.getCellName());
				List<QueryCellCategoryWorkParms> listQueryCellCategoryWorkParms = cellPropertySevice.queryAllStationCellInfoByCellId(cell.getCellId());
				sci.setListQueryCellCategoryWorkParms(listQueryCellCategoryWorkParms);
				sci.setListQueryIndexes(indexService.queryIndexeByCellId(cell.getCellId()));
				listStationCellsInfo.add(sci);
			}
			selectStationInfo.setListStationCellsInfo(listStationCellsInfo);//设置基站下小区信息
			listSelectStationInfo.add(selectStationInfo);
		}
		return listSelectStationInfo;
	}

	@Override
	public Testplan queryTestplanByUserId(long userId) {
		return testplanMapper.queryTestplanByUserId(userId);
	}
}
