package com.ibase.web.roadtest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ibase.web.log.domain.LogDomain;
import com.ibase.web.roadtest.domain.CellIndexResult;
import com.ibase.web.roadtest.domain.CellIndexResultTotal;
import com.ibase.web.roadtest.domain.CellParameterCheck;
import com.ibase.web.roadtest.domain.Image;
import com.ibase.web.roadtest.domain.LonLat;
import com.ibase.web.roadtest.domain.RoadTest;
import com.ibase.web.roadtest.domain.RoadTest2;
import com.ibase.web.roadtest.domain.RoadTestFile;
import com.ibase.web.roadtest.domain.RoadTestTotal;
import com.ibase.web.roadtest.domain.TemporayWorkparamDomain2;
import com.ibase.web.roadtest.domain2.Cell_new;

public interface RoadTestMapper {
     //查询集合
	List<RoadTest> queryRoadTest(RoadTest roadTest);
	//插入路测数据
	int insertRoadTest(RoadTest roadTest);
	//记录条数
	Integer countRoadTest();
	//all记录条数
	long allCountRoadTest();
	//插入路测文件
	int insertRoadTestFile(RoadTestFile roadTestFile);
	//查询路测文件
	List<RoadTestFile> queryRoadTestFile(RoadTestFile roadTestFile);
	
	// 根据文件ID查询所有经纬度
	public List<RoadTest> selectAllLng_Lat(@Param("id") Integer id);
	
	// 根据指标名字查询该指标所有数据
	public List<RoadTest> selectPCI(@Param("PCI") String PCI, @Param("id")Integer id);
	public List<RoadTest> selectRSRP(@Param("RSRP") String RSRP, @Param("id")Integer id);
	public List<RoadTest> selectSINR(@Param("SINR") String SINR, @Param("id")Integer id);
	
	List<Map<String, Object>> getAllRoadTestData(Integer id1);
	//储存图片信息
	int insertImage(Image image);
	//查询PCIx<=-140
	List<LonLat> queryRSRPXY1(@Param("RSRP") String RSRP, @Param("count") long count );
	List<LonLat> queryRSRPXY2(@Param("RSRP") String RSRP, @Param("count") long count );
	List<LonLat> queryRSRPXY3(@Param("RSRP") String RSRP, @Param("count") long count );
	List<LonLat> queryRSRPXY4(@Param("RSRP") String RSRP, @Param("count") long count );
	
	List<LonLat> querySINRXY1(@Param("SINR") String SINR, @Param("count") long count );
	List<LonLat> querySINRXY2(@Param("SINR") String SINR, @Param("count") long count );
	List<LonLat> querySINRXY3(@Param("SINR") String SINR, @Param("count") long count );
	List<LonLat> querySINRXY4(@Param("SINR") String SINR, @Param("count") long count );
	
	List<LonLat> queryPCIXY1(@Param("PCI") String PCI, @Param("count") long count );
	List<LonLat> queryPCIXY2(@Param("PCI") String PCI, @Param("count") long count );
	List<LonLat> queryPCIXY3(@Param("PCI") String PCI, @Param("count") long count );
	List<LonLat> queryPCIXY4(@Param("PCI") String PCI, @Param("count") long count );
	
	//查询图片生成的地址
	String getImageAddress(@Param("rtf_id") long rtf_id,@Param("target_name") String target_name);
	
	
	
	//添加临时日志表
	int insertTemporaryLog(CellIndexResult cir);
	//添加临时日志表中的小区工参
	int insertTemporaryLogCellParameter(CellParameterCheck cpc);
	//添加小区的路测数据
	int insertCellRoadTest(RoadTestTotal rtt);
	//根据测试时间和基站编号查询小区对应的属性
	List<RoadTestTotal> selectCellRoadTest(String station_No, String roadTestDate);
	
	List<TemporayWorkparamDomain2> selectTestPlanNewStationnew1();
	
	List<String> selectTestPlanNewStationnew2(String StationNumber);
	
	TemporayWorkparamDomain2 selectTestPlanNewStationnew3(String cell_name);
	
	List<CellIndexResultTotal> selectStationRoadTest();

	List<CellIndexResultTotal> selectCellIndexResultTotal(int userId,String testDate,String station_No);
	
	int insertCellIndexResultTotal(CellParameterCheck cellParameterCheck);	
	
	int updateTemporaryLog(CellIndexResult cir);
	
}