package com.ibase.web.roadtest.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import com.ibase.web.roadtest.domain.CellIndexResult;
import com.ibase.web.roadtest.domain.CellIndexResultTotal;
import com.ibase.web.roadtest.domain.CellParameterCheck;
import com.ibase.web.roadtest.domain.Image;
import com.ibase.web.roadtest.domain.LonLat;
import com.ibase.web.roadtest.domain.RoadTest;
import com.ibase.web.roadtest.domain.RoadTestData;
import com.ibase.web.roadtest.domain.RoadTestFile;
import com.ibase.web.roadtest.domain.RoadTestTotal;
import com.ibase.web.roadtest.domain2.StationNoTestDate;
import com.ibase.web.roadtest.domain2.Station_new;
import com.ibase.web.roadtest.domain2.TestPlan_new;
public interface RoadService {
	//新增路测数据
	boolean insertRoadTest(RoadTest roadTest);
	
	//查询路测数据
	List<RoadTest> queryRoadTest(RoadTest roadTest);
	//记录条数
	Integer countRoadTest();
	//总条数
	long allCountRoadTest();
	//插入路测文件
	int insertRoadTestFile(RoadTestFile roadTestFile);
	//查询路测文件
	List<RoadTestFile> queryRoadTestFile(RoadTestFile roadTestFile);
	
	// 根据文件ID查询所有经纬度
	public List<RoadTest> selectAllLng_Lat(Integer id);
	
	// 根据指标名字查询该指标所有数据
	public List<RoadTest> selectPCI(String PCI, Integer id);
	public List<RoadTest> selectRSRP(String RSRP, Integer id);
	public List<RoadTest> selectSINR(String SINR, Integer id);
	List<Map<String, Object>> getAllRoadTestData(Integer id1);
	//插入图片信息
	int insertImage(Image image);
	//模拟范围数据
	List<LonLat> queryRSRPXY1(String RSRP, Long count);
	List<LonLat> queryRSRPXY2(String RSRP, Long count);
	List<LonLat> queryRSRPXY3(String RSRP, Long count);
	List<LonLat> queryRSRPXY4(String RSRP, Long count);

	List<LonLat> querySINRXY1(String sINR, long count);
	List<LonLat> querySINRXY2(String sINR, long count);
	List<LonLat> querySINRXY3(String sINR, long count);
	List<LonLat> querySINRXY4(String sINR, long count);

	List<LonLat> queryPCIXY1(String PCI, long count);
	List<LonLat> queryPCIXY2(String PCI, long count);
	List<LonLat> queryPCIXY3(String PCI, long count);
	List<LonLat> queryPCIXY4(String PCI, long count);

	boolean getImageAddress(long rtf_id, String target_name);

	String getAddress(long rtf_id, String target_name);

	int insertTemporaryLog(CellIndexResult cir);

	int insertTemporaryLogCellParameter(CellParameterCheck cpc);

	int insertCellRoadTest(RoadTestData rtd);

	List<RoadTestTotal> selectCellRoadTest(String station_No, String roadTestDate);

	TestPlan_new selectTestPlanNew(String userId);

	List<Station_new> selectTestPlanNewStationnew();

	List<StationNoTestDate> selectStationRoadTest();

	List<CellIndexResultTotal> selectCellIndexResultTotal(int userId,String testDate,String station_No);
	
	int insertCellIndexResultTotal(CellParameterCheck cellParameterCheck);
	
	int updateTemporaryLog(CellIndexResult cir);
}
