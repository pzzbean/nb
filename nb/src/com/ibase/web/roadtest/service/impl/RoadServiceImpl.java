package com.ibase.web.roadtest.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibase.web.roadtest.domain.CellIndexResult;
import com.ibase.web.roadtest.domain.CellIndexResultTotal;
import com.ibase.web.roadtest.domain.CellParameterCheck;
import com.ibase.web.roadtest.domain.Image;
import com.ibase.web.roadtest.domain.LonLat;
import com.ibase.web.roadtest.domain.RoadTest;
import com.ibase.web.roadtest.domain.RoadTest2;
import com.ibase.web.roadtest.domain.RoadTestData;
import com.ibase.web.roadtest.domain.RoadTestFile;
import com.ibase.web.roadtest.domain.RoadTestTotal;
import com.ibase.web.roadtest.domain.TemporayWorkparamDomain2;
import com.ibase.web.roadtest.domain2.Cell_new;
import com.ibase.web.roadtest.domain2.MCommunityNetworkOptimizationBean;
import com.ibase.web.roadtest.domain2.MCommunityProjectBean;
import com.ibase.web.roadtest.domain2.StationNoTestDate;
import com.ibase.web.roadtest.domain2.Station_new;
import com.ibase.web.roadtest.domain2.TestPlan_new;
import com.ibase.web.roadtest.mapper.RoadTestMapper;
import com.ibase.web.roadtest.service.RoadService;

@Service
public class RoadServiceImpl implements RoadService {

	@Autowired

	RoadTestMapper roadTestMapper;
	@Autowired(required = true) // 证明其是一个实体类
	RoadTestTotal rtt;
	@Autowired
	TestPlan_new tpn;

	@Override
	public boolean insertRoadTest(RoadTest roadTest) {
		int result = roadTestMapper.insertRoadTest(roadTest);
		return result > 0;
	}

	@Override
	public List<RoadTest> queryRoadTest(RoadTest roadTest) {
		int currentPage = roadTest.getPage().getCurrentPage();
		int pageSize = roadTest.getPage().getPageSize();
		roadTest.getPage().setTotalRows(countRoadTest());
		roadTest.getPage().setStartNum((currentPage - 1) * pageSize);
		roadTest.getPage().setEndIndex(pageSize);
		return roadTestMapper.queryRoadTest(roadTest);
	}

	@Override
	public Integer countRoadTest() {
		return roadTestMapper.countRoadTest();
	}

	@Override
	public long allCountRoadTest() {

		return roadTestMapper.allCountRoadTest();
	}

	@Override
	public int insertRoadTestFile(RoadTestFile roadTestFile) {
		return roadTestMapper.insertRoadTestFile(roadTestFile);
	}

	@Override
	public List<RoadTestFile> queryRoadTestFile(RoadTestFile roadTestFile) {
		int currentPage = roadTestFile.getPage().getCurrentPage();
		int pageSize = roadTestFile.getPage().getPageSize();
		int totalRows = 0;
		if (countRoadTest() == null) {
			totalRows = 0;
		} else {
			totalRows = countRoadTest();
		}
		roadTestFile.getPage().setTotalRows(totalRows);
		roadTestFile.getPage().setStartNum((currentPage - 1) * pageSize);
		roadTestFile.getPage().setEndIndex(pageSize);
		return roadTestMapper.queryRoadTestFile(roadTestFile);
	}

	@Override
	public List<RoadTest> selectAllLng_Lat(Integer id) {

		System.out.println(id);
		return roadTestMapper.selectAllLng_Lat(id);
	}

	@Override
	public List<RoadTest> selectPCI(String PCI, Integer id) {
		return roadTestMapper.selectPCI(PCI, id);
	}

	@Override
	public List<RoadTest> selectRSRP(String RSRP, Integer id) {
		return roadTestMapper.selectRSRP(RSRP, id);
	}

	@Override
	public List<RoadTest> selectSINR(String SINR, Integer id) {
		return roadTestMapper.selectSINR(SINR, id);
	}

	@Override
	public List<Map<String, Object>> getAllRoadTestData(Integer id1) {
		List<Map<String, Object>> data = roadTestMapper.getAllRoadTestData(id1);
		return data;
	}

	@Override
	public int insertImage(Image image) {

		return roadTestMapper.insertImage(image);
	}

	@Override
	public List<LonLat> queryRSRPXY1(String RSRP, Long count) {

		return roadTestMapper.queryRSRPXY1(RSRP, count);
	}

	@Override
	public List<LonLat> queryRSRPXY2(String RSRP, Long count) {

		return roadTestMapper.queryRSRPXY2(RSRP, count);
	}

	@Override
	public boolean getImageAddress(long rtf_id, String target_name) {
		String address = roadTestMapper.getImageAddress(rtf_id, target_name);
		System.out.println(address);
		return address == null;
	}

	@Override
	public String getAddress(long rtf_id, String target_name) {
		String address = roadTestMapper.getImageAddress(rtf_id, target_name);
		System.out.println("address" + address);
		return address;
	}

	@Override
	public List<LonLat> queryRSRPXY3(String RSRP, Long count) {
		return roadTestMapper.queryRSRPXY3(RSRP, count);
	}

	@Override
	public List<LonLat> queryRSRPXY4(String RSRP, Long count) {
		return roadTestMapper.queryRSRPXY4(RSRP, count);
	}

	@Override
	public List<LonLat> querySINRXY1(String SINR, long count) {
		return roadTestMapper.querySINRXY1(SINR, count);
	}

	@Override
	public List<LonLat> querySINRXY2(String SINR, long count) {
		return roadTestMapper.querySINRXY2(SINR, count);
	}

	@Override
	public List<LonLat> querySINRXY3(String SINR, long count) {
		return roadTestMapper.querySINRXY3(SINR, count);
	}

	@Override
	public List<LonLat> querySINRXY4(String SINR, long count) {
		return roadTestMapper.querySINRXY4(SINR, count);
	}

	@Override
	public List<LonLat> queryPCIXY1(String PCI, long count) {
		return roadTestMapper.queryPCIXY1(PCI, count);
	}

	@Override
	public List<LonLat> queryPCIXY2(String PCI, long count) {
		return roadTestMapper.queryPCIXY1(PCI, count);
	}

	@Override
	public List<LonLat> queryPCIXY3(String PCI, long count) {
		return roadTestMapper.queryPCIXY3(PCI, count);
	}

	@Override
	public List<LonLat> queryPCIXY4(String PCI, long count) {
		return roadTestMapper.queryPCIXY4(PCI, count);
	}

	@Override
	public int insertTemporaryLog(CellIndexResult cir) {
		// TODO Auto-generated method stub
		return roadTestMapper.insertTemporaryLog(cir);
	}

	@Override
	public int insertTemporaryLogCellParameter(CellParameterCheck cpc) {
		// TODO Auto-generated method stub
		return roadTestMapper.insertTemporaryLogCellParameter(cpc);
	}

	@Override
	public int insertCellRoadTest(RoadTestData rtd) {
		int m = 0;
		rtt.setUserId(rtd.getUserId());
		rtt.setStation_No(rtd.getStation_No());
		rtt.setCommunityName(rtd.getCommunityName());
		List<RoadTest2> rtlist = rtd.getRtlist();
		
		for (RoadTest2 roadTest2 : rtlist) {
			rtt.setCellId(roadTest2.getCellId());
			rtt.setRoadTestDate(roadTest2.getRoadTestDate());
			rtt.setLongitude(roadTest2.getLongitude());
			rtt.setLatitude(roadTest2.getLatitude());
			rtt.setPCI(roadTest2.getPCI());
			rtt.setRSRP(roadTest2.getRSRP());
			rtt.setSINR(roadTest2.getSINR());
			m = roadTestMapper.insertCellRoadTest(rtt);
			System.out.println(rtt);
		}

		return m;
	}

	@Override
	public List<RoadTestTotal> selectCellRoadTest(String station_No, String roadTestDate) {

		return roadTestMapper.selectCellRoadTest(station_No, roadTestDate);
	}

	@Override
	public TestPlan_new selectTestPlanNew(String userId) {
		// 根据用户编号查询测试计划，
		tpn.setPlanId(1);
		tpn.setTestAddress("上海");
		/*
		 * //获取当前系统时间 Date day=new Date(); 
		 * SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		 * String date = df.format(day);
		 */
		
		Date day = new Date();   
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(day);
		
		tpn.setTestDate(date);
		tpn.setTestUser("admin");
		return tpn;
	}

	/*
	 * */
	@Override
	public List<Station_new> selectTestPlanNewStationnew() {
		System.out.println("selectTestPlanNewStationnew");
		//接收基站编号
		HashSet<Station_new> stationNumberSet=new HashSet<>();
		// 默认测试id为1，查询所有的基站(因为所有的基站都是嘉定区的)
		List<Station_new> stationNewList = new ArrayList<>();
		List<TemporayWorkparamDomain2> list1 = roadTestMapper.selectTestPlanNewStationnew1();
		// System.out.println(list1.size()+"list1:"+list1);
		for (TemporayWorkparamDomain2 temporayWorkparamDomain2 : list1) {
			Station_new sn = new Station_new();
			sn.setmAltitude(temporayWorkparamDomain2.getHeight());// 海拔
			sn.setmBaseStationName(temporayWorkparamDomain2.getStation_name());// 基站名
			sn.setmBaseStationNumber(temporayWorkparamDomain2.getStation_no());// 基站编号
			sn.setmBaseStationType(null);// 基站类型
			sn.setmLatitude(temporayWorkparamDomain2.getLatitude());// 纬度
			sn.setmLongitude(temporayWorkparamDomain2.getLongitude());// 经度
			sn.setmTac(temporayWorkparamDomain2.getTac());// TAC
			stationNumberSet.add(sn);
		}
		for (Station_new currStationNumber : stationNumberSet) {
			List<Cell_new> cellList=new ArrayList<>();
			List<String> cell_namelist = roadTestMapper.selectTestPlanNewStationnew2(currStationNumber.getmBaseStationNumber());
			for (String currCellName : cell_namelist) {
				Cell_new cn = new Cell_new();
				cn.setmCommunityBeanName(currCellName);
				TemporayWorkparamDomain2 temporayWorkparamDomain2_3 = roadTestMapper.selectTestPlanNewStationnew3(currCellName);
				MCommunityProjectBean mCommunityProjectBean=new MCommunityProjectBean();
				mCommunityProjectBean.setmCellID(temporayWorkparamDomain2_3.getCi());
				mCommunityProjectBean.setmFrequency(temporayWorkparamDomain2_3.getFrequency_downlink());
				mCommunityProjectBean.setmPCI(temporayWorkparamDomain2_3.getPci());
				cn.setmCommunityProject(mCommunityProjectBean);
				
				MCommunityNetworkOptimizationBean mcnob=new MCommunityNetworkOptimizationBean();
				mcnob.setmAntennaHangUp("40dBm");// 不知RsPower对应工参的那个属性
				mcnob.setmAzimuth(temporayWorkparamDomain2_3.getAzimuth());// 方位角
				mcnob.setmMechanicalLowerInclination(temporayWorkparamDomain2_3.getMechanical_downtilt());// 机械下倾角
				mcnob.setmPresetElectricDip(temporayWorkparamDomain2_3.getElectrical_downtilt());// 预置电下倾
				mcnob.setMtotalLowerInclination(temporayWorkparamDomain2_3.getTotal_downtilt());// 总下倾角
				mcnob.setmAntennaHangUp(temporayWorkparamDomain2_3.getHeight());// 
				cn.setmCommunityNetworkOptimization(mcnob);
				
				List<String> listIndex =  new ArrayList<>();
				listIndex.add("Ping性能");//Ping性能ping
				listIndex.add("无线信号");//无线信号wirelessSignal
				//listIndex.add("邻区信号");//邻区信号neighborhoodSignal
				listIndex.add("附着性能");//附着性能attach
				listIndex.add("重选性能");//重选性能re-election
				listIndex.add("接入性能");//接入性能access
				listIndex.add("吞吐率性能");//吞吐率性能throughput
				cn.setmCommunityTestItemList(listIndex);
				cellList.add(cn);
			}
			currStationNumber.setmCommunityBeanList(cellList);
			stationNewList.add(currStationNumber);
		}
		return stationNewList;
	}

	@Override
	public List<StationNoTestDate> selectStationRoadTest() {
		List<StationNoTestDate> list1 = new ArrayList<>();
		List<CellIndexResultTotal> list = roadTestMapper.selectStationRoadTest();
		for (CellIndexResultTotal cellIndexResultTotal : list) {
			StationNoTestDate std = new StationNoTestDate();
			std.setStation_No(cellIndexResultTotal.getStation_No());
			std.setTestDate(cellIndexResultTotal.getTestDate());
			std.setTestUserName("admin");
			list1.add(std);
		}
		return list1;
	}

	@Override
	public List<CellIndexResultTotal> selectCellIndexResultTotal(int userId,String testDate,String station_No) {
		List<CellIndexResultTotal> list = roadTestMapper.selectCellIndexResultTotal(userId,testDate,station_No);
		return list;
	}

	@Override
	public int insertCellIndexResultTotal(CellParameterCheck cellParameterCheck) {
		return roadTestMapper.insertCellIndexResultTotal(cellParameterCheck);
	}

	@Override
	public int updateTemporaryLog(CellIndexResult cir) {
		return roadTestMapper.updateTemporaryLog(cir);
	}

}
