package com.ibase.web.log.util.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.ibase.core.utils.ExcelPoiUtil;
import com.ibase.web.log.domain.LogDomain;
import com.ibase.web.log.util.I18nUtil;
import com.ibase.web.plane.domain.Plane;
import com.ibase.web.workparam.domain.WorkParamDomain;
import com.ibase.web.workparam_in.domain.WorkParam_inDomain;

public class QCUQ_Excel {

	public void test(OutputStream out,List<WorkParamDomain> wordParam, List<LogDomain> log,Plane plane,List<WorkParam_inDomain> wordParam_in, String lang) throws Exception, IOException{
		System.out.println(wordParam);
		Map<String, String> Map = I18nUtil.getLangMap(lang);//中英文切换
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet1 = wb.createSheet("sheet1");
		
		Map map = new HashMap();
		map.put("cellValue",wordParam.get(0).getWp_station_no() + Map.get("QCUQTitle"));
		map.put("columnWidth",4000);
		map.put("fontSize",(short)10);
		map.put("rowHeight",(short)450);
		map.put("fontWeight",(short)1000);
		map.put("LRAlignment", true);map.put("TBAlignment",true);
		map.put("fontColour",HSSFColor.BLACK.index);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("borderBottom",HSSFCellStyle.BORDER_THIN);map.put("borderLeft",HSSFCellStyle.BORDER_THIN);
		map.put("borderRight",HSSFCellStyle.BORDER_THIN);map.put("borderTop",HSSFCellStyle.BORDER_THIN);
		map.put("col", 0);map.put("row",0);map.put("colTo",7);map.put("rowTo",0);
		ExcelPoiUtil.createCell(wb,sheet1,map);
//站点名称		
		map.put("cellValue", Map.get("SiteName"));
		map.put("col", 0);map.put("row",1);map.put("colTo",0);map.put("rowTo",2);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue", wordParam.get(0).getWp_station_no());
		map.put("fontWeight",null);
		map.put("backgroundColour",null);	
		map.put("col", 1);map.put("row",1);map.put("colTo",2);map.put("rowTo",2);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","eNodeBid");
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 3);map.put("row", 1);map.put("colTo", 4);map.put("rowTo", 1);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("fontWeight",null);
		map.put("backgroundColour",null);
		map.put("col", 3);map.put("row", 2);map.put("colTo", 4);map.put("rowTo", 2);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 经度
		map.put("cellValue",Map.get("Longitude"));
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 5);map.put("row", 1);map.put("colTo", 5);map.put("rowTo", 1);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",wordParam.get(0).getWp_station_longitude());
		map.put("fontWeight",null);
		map.put("backgroundColour",null);
		map.put("col", 6);map.put("row", 1);map.put("colTo", 7);map.put("rowTo", 1);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 纬度
		map.put("cellValue",Map.get("Latitude"));
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 5);map.put("row", 2);map.put("colTo", 5);map.put("rowTo", 2);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",wordParam.get(0).getWp_station_latitude());
		map.put("fontWeight",null);
		map.put("backgroundColour",null);
		map.put("col", 6);map.put("row", 2);map.put("colTo", 7);map.put("rowTo", 2);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 测试内容
		map.put("cellValue",Map.get("TestContent"));
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 0);map.put("row", 3);map.put("colTo", 2);map.put("rowTo", 4);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		// 测试结果
		map.put("cellValue",Map.get("TestResult"));
		map.put("fontWeight",(short)1000);
		map.put("col", 3);map.put("row", 3);map.put("colTo", 5);map.put("rowTo", 3);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 小区1
		map.put("cellValue",Map.get("Cell1"));
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 3);map.put("row", 4);map.put("colTo", 3);map.put("rowTo", 4);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",Map.get("Longitude")+wordParam.get(0).getWp_station_longitude()+"\r\n"+Map.get("Latitude")+wordParam.get(0).getWp_station_latitude());
		map.put("fontWeight",null);
		map.put("backgroundColour", null);
		map.put("col", 3);map.put("row", 5);map.put("colTo", 3);map.put("rowTo", 5);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(0).getCell_section());
		map.put("col", 3);map.put("row", 6);map.put("colTo", 3);map.put("rowTo", 6);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",wordParam.get(0).getWp_cell_PCI());
		map.put("col", 3);map.put("row", 7);map.put("colTo", 3);map.put("rowTo", 7);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 3);map.put("row", 8);map.put("colTo", 3);map.put("rowTo", 8);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 3);map.put("row", 9);map.put("colTo", 3);map.put("rowTo", 9);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 3);map.put("row", 10);map.put("colTo", 3);map.put("rowTo", 10);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(0).getLog_RSRP());
		map.put("col", 3);map.put("row", 11);map.put("colTo", 3);map.put("rowTo", 11);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(0).getLog_SINR());
		map.put("col", 3);map.put("row", 12);map.put("colTo", 3);map.put("rowTo", 12);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(0).getLog_openRate());
		map.put("col", 3);map.put("row", 13);map.put("colTo", 3);map.put("rowTo", 13);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(0).getLog_UDPTop_rate());
		map.put("col", 3);map.put("row", 14);map.put("colTo", 3);map.put("rowTo", 14);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(0).getLog_UDPDown_rate());
		map.put("col", 3);map.put("row", 15);map.put("colTo", 3);map.put("rowTo", 15);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(0).getLog_delayTime());
		map.put("col", 3);map.put("row", 16);map.put("colTo", 3);map.put("rowTo", 16);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 小区2
		map.put("cellValue",Map.get("Cell2"));
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 4);map.put("row", 4);map.put("colTo", 4);map.put("rowTo", 4);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",Map.get("Longitude")+wordParam.get(1).getWp_station_longitude()+"\r\n"+Map.get("Latitude")+wordParam.get(2).getWp_station_latitude());
		map.put("fontWeight",null);
		map.put("backgroundColour", null);
		map.put("col", 4);map.put("row", 5);map.put("colTo", 4);map.put("rowTo", 5);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(1).getCell_section());
		map.put("col", 4);map.put("row", 6);map.put("colTo", 4);map.put("rowTo", 6);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",wordParam.get(1).getWp_cell_PCI());
		map.put("col", 4);map.put("row", 7);map.put("colTo", 4);map.put("rowTo", 7);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 4);map.put("row", 8);map.put("colTo", 4);map.put("rowTo", 8);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 4);map.put("row", 9);map.put("colTo", 4);map.put("rowTo", 9);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 4);map.put("row", 10);map.put("colTo", 4);map.put("rowTo", 10);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(1).getLog_RSRP());
		map.put("col", 4);map.put("row", 11);map.put("colTo", 4);map.put("rowTo", 11);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(1).getLog_SINR());
		map.put("col", 4);map.put("row", 12);map.put("colTo", 4);map.put("rowTo", 12);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(1).getLog_openRate());
		map.put("col", 4);map.put("row", 13);map.put("colTo", 4);map.put("rowTo", 13);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(1).getLog_UDPTop_rate());
		map.put("col", 4);map.put("row", 14);map.put("colTo", 4);map.put("rowTo", 14);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(1).getLog_UDPDown_rate());
		map.put("col", 4);map.put("row", 15);map.put("colTo", 4);map.put("rowTo", 15);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(1).getLog_delayTime());
		map.put("col", 4);map.put("row", 16);map.put("colTo", 4);map.put("rowTo", 16);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 小区3
		map.put("cellValue",Map.get("Cell3"));
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 5);map.put("row", 4);map.put("colTo", 5);map.put("rowTo", 4);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",Map.get("Longitude")+wordParam.get(2).getWp_station_longitude()+"\r\n"+Map.get("Latitude")+wordParam.get(2).getWp_station_latitude());
		map.put("fontWeight",null);
		map.put("backgroundColour", null);
		map.put("col", 5);map.put("row", 5);map.put("colTo", 5);map.put("rowTo", 5);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(2).getCell_section());
		map.put("col", 5);map.put("row", 6);map.put("colTo", 5);map.put("rowTo", 6);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",wordParam.get(2).getWp_cell_PCI());
		map.put("col", 5);map.put("row", 7);map.put("colTo", 5);map.put("rowTo", 7);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 5);map.put("row", 8);map.put("colTo", 5);map.put("rowTo", 8);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 5);map.put("row", 9);map.put("colTo", 5);map.put("rowTo", 9);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 5);map.put("row", 10);map.put("colTo", 5);map.put("rowTo", 10);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(2).getLog_RSRP());
		map.put("col", 5);map.put("row", 11);map.put("colTo", 5);map.put("rowTo", 11);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(2).getLog_SINR());
		map.put("col", 5);map.put("row", 12);map.put("colTo", 5);map.put("rowTo", 12);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(2).getLog_openRate());
		map.put("col", 5);map.put("row", 13);map.put("colTo", 5);map.put("rowTo", 13);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(2).getLog_UDPTop_rate());
		map.put("col", 5);map.put("row", 14);map.put("colTo", 5);map.put("rowTo", 14);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(2).getLog_UDPDown_rate());
		map.put("col", 5);map.put("row", 15);map.put("colTo", 5);map.put("rowTo", 15);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",log.get(2).getLog_delayTime());
		map.put("col", 5);map.put("row", 16);map.put("colTo", 5);map.put("rowTo", 16);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 结论
		map.put("cellValue",Map.get("Conclusion"));
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 6);map.put("row", 3);map.put("colTo", 6);map.put("rowTo", 4);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("fontWeight",null);
		map.put("backgroundColour", null);
		map.put("col", 6);map.put("row", 5);map.put("colTo", 6);map.put("rowTo", 5);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",cell_section(log, wordParam));
		map.put("col", 6);map.put("row", 6);map.put("colTo", 6);map.put("rowTo", 6);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",cell_PCI(wordParam_in, wordParam));
		map.put("col", 6);map.put("row", 7);map.put("colTo", 6);map.put("rowTo", 7);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 6);map.put("row", 8);map.put("colTo", 6);map.put("rowTo", 8);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 6);map.put("row", 9);map.put("colTo", 6);map.put("rowTo", 9);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 6);map.put("row", 10);map.put("colTo", 6);map.put("rowTo", 10);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","-");
		map.put("col", 6);map.put("row", 11);map.put("colTo", 6);map.put("rowTo", 11);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","-");
		map.put("col", 6);map.put("row", 12);map.put("colTo", 6);map.put("rowTo", 12);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",openRate(log));
		map.put("col", 6);map.put("row", 13);map.put("colTo", 6);map.put("rowTo", 13);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",top_rate(log));
		map.put("col", 6);map.put("row", 14);map.put("colTo", 6);map.put("rowTo", 14);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",down_rate(log));
		map.put("col", 6);map.put("row", 15);map.put("colTo", 6);map.put("rowTo", 15);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",ping(log));
		map.put("col", 6);map.put("row", 16);map.put("colTo", 6);map.put("rowTo", 16);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 备注
		map.put("cellValue",Map.get("Remarks"));
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 7);map.put("row", 3);map.put("colTo", 7);map.put("rowTo", 4);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("fontWeight",null);
		map.put("backgroundColour", null);
		map.put("col", 7);map.put("row", 5);map.put("colTo", 7);map.put("rowTo", 5);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 6);map.put("colTo", 7);map.put("rowTo", 6);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 7);map.put("colTo", 7);map.put("rowTo", 7);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 8);map.put("colTo", 7);map.put("rowTo", 8);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 9);map.put("colTo", 7);map.put("rowTo", 9);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 10);map.put("colTo", 7);map.put("rowTo", 10);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 11);map.put("colTo", 7);map.put("rowTo", 11);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 12);map.put("colTo", 7);map.put("rowTo", 12);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 13);map.put("colTo", 7);map.put("rowTo", 13);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 14);map.put("colTo", 7);map.put("rowTo", 14);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 15);map.put("colTo", 7);map.put("rowTo", 15);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 16);map.put("colTo", 7);map.put("rowTo", 16);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 基础信息检查
		map.put("cellValue",Map.get("BasicInInspection"));
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 0);map.put("row", 5);map.put("colTo", 0);map.put("rowTo", 7);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 站点状态检查
		map.put("cellValue",Map.get("SiteStatus"));
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 0);map.put("row", 8);map.put("colTo", 0);map.put("rowTo", 10);
		ExcelPoiUtil.createCell(wb,sheet1,map);
				
		// 单站功能验证
		map.put("cellValue",Map.get("SingleStFun"));
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 0);map.put("row", 11);map.put("colTo", 0);map.put("rowTo", 16);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 经纬度
		map.put("cellValue",Map.get("LatitudeLongitude"));
		map.put("fontWeight",null);
		map.put("backgroundColour",null);
		map.put("col", 1);map.put("row", 5);map.put("colTo", 1);map.put("rowTo", 5);
		ExcelPoiUtil.createCell(wb,sheet1,map);
	//现场测试经纬度与设计是否相符			
		map.put("cellValue",Map.get("CoincideDesign"));
		map.put("LRAlignment", false);
		map.put("col", 2);map.put("row", 5);map.put("colTo", 2);map.put("rowTo", 5);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// cellid
		map.put("cellValue","cellid");
		map.put("LRAlignment", true);
		map.put("col", 1);map.put("row", 6);map.put("colTo", 1);map.put("rowTo", 6);
		ExcelPoiUtil.createCell(wb,sheet1,map);
	//现场测试小区ID是否与设计一致	
		map.put("cellValue",Map.get("FieldTestCellID"));
		map.put("LRAlignment", false);
		map.put("col", 2);map.put("row", 6);map.put("colTo", 2);map.put("rowTo", 6);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// PCI
		map.put("cellValue","PCI");
		map.put("LRAlignment", true);
		map.put("col", 1);map.put("row", 7);map.put("colTo", 1);map.put("rowTo", 7);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//现场测试小区PCI是否与设计一致
		map.put("cellValue",Map.get("FieldTestPCI"));
		map.put("LRAlignment", false);
		map.put("col", 2);map.put("row", 7);map.put("colTo", 2);map.put("rowTo", 7);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 告警检查
		map.put("cellValue",Map.get("AlarmCheck"));
		map.put("LRAlignment", true);
		map.put("col", 1);map.put("row", 8);map.put("colTo", 1);map.put("rowTo", 8);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//测试站点有无告警、传输是否正常、小区状态是否正常
		map.put("cellValue",Map.get("TestSite"));
		map.put("LRAlignment", false);
		map.put("col", 2);map.put("row", 8);map.put("colTo", 2);map.put("rowTo", 8);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 上行RSSI检查
		map.put("cellValue",Map.get("UpsideRSSIC"));
		map.put("LRAlignment", true);
		map.put("col", 1);map.put("row", 9);map.put("colTo", 1);map.put("rowTo", 9);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//空载RSSI值不高于RSSI参考值（-120dBm）6dB，否则认为RSSI异常
		map.put("cellValue",Map.get("Abnormal"));
		map.put("LRAlignment", false);
		map.put("col", 2);map.put("row", 9);map.put("colTo", 2);map.put("rowTo", 9);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 驻波比检查 
		map.put("cellValue",Map.get("BobbiInspection"));
		map.put("LRAlignment", true);
		map.put("col", 1);map.put("row", 10);map.put("colTo", 1);map.put("rowTo", 10);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//使用高精度驻波比监测，要求检测出的驻波比小于1.5
		map.put("cellValue",Map.get("PrecisionMonitoring"));
		map.put("LRAlignment", false);
		map.put("col", 2);map.put("row", 10);map.put("colTo", 2);map.put("rowTo", 10);
		ExcelPoiUtil.createCell(wb,sheet1,map);
				
		// 测试场景
		map.put("cellValue",Map.get("TestScene"));
		map.put("LRAlignment", true);
		map.put("col", 1);map.put("row", 11);map.put("colTo", 1);map.put("rowTo", 12);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//平均RSRP
		map.put("cellValue",Map.get("AverageRSRP"));
		map.put("LRAlignment", false);
		map.put("col", 2);map.put("row", 11);map.put("colTo", 2);map.put("rowTo", 11);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//平均SNR
		map.put("cellValue",Map.get("AverageSNR"));
		map.put("LRAlignment", false);
		map.put("col", 2);map.put("row", 12);map.put("colTo", 2);map.put("rowTo", 12);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 测试内容
		map.put("cellValue",Map.get("TestContent"));
		map.put("LRAlignment", true);
		map.put("col", 1);map.put("row", 13);map.put("colTo", 1);map.put("rowTo", 16);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//attach成功率
		map.put("cellValue",Map.get("AttachSuRate"));
		map.put("columnWidth",15000);
		map.put("LRAlignment", false);
		map.put("col", 2);map.put("row", 13);map.put("colTo", 2);map.put("rowTo", 13);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//单用户上行峰值吞吐率（UDP上行灌包）(>=10kbps)
		map.put("cellValue",Map.get("UDPUplinkPackage"));
		map.put("col", 2);map.put("row", 14);map.put("colTo", 2);map.put("rowTo", 14);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//单用户下行峰值吞吐率（UDP下行灌包）(>=14kbps)
		map.put("cellValue",Map.get("UDPDownlinkPackage"));
		map.put("col", 2);map.put("row", 15);map.put("colTo", 2);map.put("rowTo", 15);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//ping时延（<1.5s)
		map.put("cellValue",Map.get("PingDelay"));
		map.put("col", 2);map.put("row", 16);map.put("colTo", 2);map.put("rowTo", 16);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 备注说明		
		map.put("cellValue",Map.get("Descr"));
		map.put("fontWeight",(short)1000);
		map.put("columnWidth",5000);
		map.put("LRAlignment", true);
		map.put("col", 0);map.put("row", 17);map.put("colTo", 0);map.put("rowTo", 17);
		ExcelPoiUtil.createCell(wb,sheet1,map);		
//		"1.attach成功率：要求RSRP>=-80dBm，反复发起attach 5次，计算成功率，建议标准100%。\r\n" + 
//		"2.单用户上行峰值吞吐率：要求空载，选择RSRP>=-80dBm & SINR>20dB点测试，上行发包>=300Bytes，测试3次，速率>=10kbps时可认为达标。\r\n" + 
//		"3.单用户下行峰值吞吐率：要求空载，选择RSRP>=-80dBm & SINR>20dB点测试，下行发包>=300Bytes，测试3次，速率>=14kbps时可认为达标。\r\n" + 
//		"4.ping时延测试：要求空载，选择RSRP>=-80dBm & SINR>20dB点测试，idle态发起UE ping UDP服务器，ping包大小32Bytes，ping包间隔2秒，ping次数10次，建议标准<1.5s。\r\n" + 
//		"5.上行RSSI参考值：RSSI在子载波带宽为15kHz时的理论值为-131dBm。在180kHZ全带宽的理论值为-120dBm。"
		map.put("cellValue",Map.get("AttachSURate")+"\r\n" + 
						Map.get("SingleRate")+"\r\n" + 
						Map.get("SingleDownRate")+"\r\n" + 
						Map.get("PingDelayT")+"\r\n" + 
						Map.get("UplinkRSSIRe"));
		map.put("LRAlignment", false);
		map.put("fontWeight",null);
		map.put("col", 0);map.put("row", 18);map.put("colTo", 7);map.put("rowTo", 24);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
//		FileOutputStream fileOut = new FileOutputStream("E:/poi.xls");   
		wb.write(out);   
	}
	
	public void test_in(OutputStream out,Plane plane,List<WorkParam_inDomain> wordParam_in,List<LogDomain> logList, List<WorkParamDomain> workParam, String lang) throws Exception, IOException{
		String str = lang;
		Map<String,String> Map = I18nUtil.getLangMap(lang);		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet1 = wb.createSheet("sheet1");
		
		Map map = new HashMap();
		//站（站点名称）单站验证记录表
		map.put("cellValue", wordParam_in.get(0).getWp_station_no() + "StationRecord");
		map.put("columnWidth",4000);
		map.put("fontSize",(short)10);
		map.put("rowHeight",(short)450);
		map.put("fontWeight",(short)1000);
		map.put("LRAlignment", true);map.put("TBAlignment",true);
		map.put("fontColour",HSSFColor.BLACK.index);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("borderBottom",HSSFCellStyle.BORDER_THIN);map.put("borderLeft",HSSFCellStyle.BORDER_THIN);
		map.put("borderRight",HSSFCellStyle.BORDER_THIN);map.put("borderTop",HSSFCellStyle.BORDER_THIN);
		map.put("col", 0);map.put("row",0);map.put("colTo",7);map.put("rowTo",0);
		ExcelPoiUtil.createCell(wb,sheet1,map);
//站点名称		
		map.put("cellValue", Map.get("SiteName"));
		map.put("col", 0);map.put("row",1);map.put("colTo",0);map.put("rowTo",2);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue", wordParam_in.get(0).getWp_station_no());
		map.put("fontWeight",null);
		map.put("backgroundColour",null);
		map.put("col", 1);map.put("row",1);map.put("colTo",2);map.put("rowTo",2);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","eNodeBid");
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 3);map.put("row", 1);map.put("colTo", 4);map.put("rowTo", 1);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("fontWeight",null);
		map.put("backgroundColour",null);
		map.put("col", 3);map.put("row", 2);map.put("colTo", 4);map.put("rowTo", 2);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 经度
		map.put("cellValue",Map.get("Longitude"));
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 5);map.put("row", 1);map.put("colTo", 5);map.put("rowTo", 1);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",wordParam_in.get(0).getWp_station_longitude());
		map.put("fontWeight",null);
		map.put("backgroundColour",null);
		map.put("col", 6);map.put("row", 1);map.put("colTo", 7);map.put("rowTo", 1);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 纬度
		map.put("cellValue",Map.get("Latitude"));
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 5);map.put("row", 2);map.put("colTo", 5);map.put("rowTo", 2);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",wordParam_in.get(0).getWp_station_latitude());
		map.put("fontWeight",null);
		map.put("backgroundColour",null);
		map.put("col", 6);map.put("row", 2);map.put("colTo", 7);map.put("rowTo", 2);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 测试内容
		map.put("cellValue",Map.get("TestContent"));
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 0);map.put("row", 3);map.put("colTo", 2);map.put("rowTo", 4);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		// 测试结果
		map.put("cellValue",Map.get("TestResult"));
		map.put("fontWeight",(short)1000);
		map.put("col", 3);map.put("row", 3);map.put("colTo", 5);map.put("rowTo", 3);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 小区1
		map.put("cellValue",Map.get("Cell1"));
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 3);map.put("row", 4);map.put("colTo", 3);map.put("rowTo", 4);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("fontWeight",null);
		map.put("backgroundColour", null);
		map.put("col", 3);map.put("row", 5);map.put("colTo", 3);map.put("rowTo", 5);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 3);map.put("row", 6);map.put("colTo", 3);map.put("rowTo", 6);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 3);map.put("row", 7);map.put("colTo", 3);map.put("rowTo", 7);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 3);map.put("row", 8);map.put("colTo", 3);map.put("rowTo", 8);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 3);map.put("row", 9);map.put("colTo", 3);map.put("rowTo", 9);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 3);map.put("row", 10);map.put("colTo", 3);map.put("rowTo", 10);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",logList.get(0).getLog_RSRP());
		map.put("col", 3);map.put("row", 11);map.put("colTo", 3);map.put("rowTo", 11);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",logList.get(0).getLog_SINR());
		map.put("col", 3);map.put("row", 12);map.put("colTo", 3);map.put("rowTo", 12);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",logList.get(0).getLog_openRate());
		map.put("col", 3);map.put("row", 13);map.put("colTo", 3);map.put("rowTo", 13);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",logList.get(0).getLog_UDPTop_rate());
		map.put("col", 3);map.put("row", 14);map.put("colTo", 3);map.put("rowTo", 14);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",logList.get(0).getLog_UDPDown_rate());
		map.put("col", 3);map.put("row", 15);map.put("colTo", 3);map.put("rowTo", 15);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",logList.get(0).getLog_delayTime());
		map.put("col", 3);map.put("row", 16);map.put("colTo", 3);map.put("rowTo", 16);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 小区2
		map.put("cellValue",Map.get("Cell2"));
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 4);map.put("row", 4);map.put("colTo", 4);map.put("rowTo", 4);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("fontWeight",null);
		map.put("backgroundColour", null);
		map.put("col", 4);map.put("row", 5);map.put("colTo", 4);map.put("rowTo", 5);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 4);map.put("row", 6);map.put("colTo", 4);map.put("rowTo", 6);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 4);map.put("row", 7);map.put("colTo", 4);map.put("rowTo", 7);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 4);map.put("row", 8);map.put("colTo", 4);map.put("rowTo", 8);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 4);map.put("row", 9);map.put("colTo", 4);map.put("rowTo", 9);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 4);map.put("row", 10);map.put("colTo", 4);map.put("rowTo", 10);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",logList.get(1).getLog_RSRP());
		map.put("col", 4);map.put("row", 11);map.put("colTo", 4);map.put("rowTo", 11);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",logList.get(1).getLog_SINR());
		map.put("col", 4);map.put("row", 12);map.put("colTo", 4);map.put("rowTo", 12);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",logList.get(1).getLog_openRate());
		map.put("col", 4);map.put("row", 13);map.put("colTo", 4);map.put("rowTo", 13);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",logList.get(1).getLog_UDPTop_rate());
		map.put("col", 4);map.put("row", 14);map.put("colTo", 4);map.put("rowTo", 14);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",logList.get(1).getLog_UDPDown_rate());
		map.put("col", 4);map.put("row", 15);map.put("colTo", 4);map.put("rowTo", 15);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",logList.get(1).getLog_delayTime());
		map.put("col", 4);map.put("row", 16);map.put("colTo", 4);map.put("rowTo", 16);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 小区3
		map.put("cellValue",Map.get("Cell3"));
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 5);map.put("row", 4);map.put("colTo", 5);map.put("rowTo", 4);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("fontWeight",null);
		map.put("backgroundColour", null);
		map.put("col", 5);map.put("row", 5);map.put("colTo", 5);map.put("rowTo", 5);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 5);map.put("row", 6);map.put("colTo", 5);map.put("rowTo", 6);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 5);map.put("row", 7);map.put("colTo", 5);map.put("rowTo", 7);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 5);map.put("row", 8);map.put("colTo", 5);map.put("rowTo", 8);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 5);map.put("row", 9);map.put("colTo", 5);map.put("rowTo", 9);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 5);map.put("row", 10);map.put("colTo", 5);map.put("rowTo", 10);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",logList.get(2).getLog_RSRP());
		map.put("col", 5);map.put("row", 11);map.put("colTo", 5);map.put("rowTo", 11);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",logList.get(2).getLog_SINR());
		map.put("col", 5);map.put("row", 12);map.put("colTo", 5);map.put("rowTo", 12);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",logList.get(2).getLog_openRate());
		map.put("col", 5);map.put("row", 13);map.put("colTo", 5);map.put("rowTo", 13);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",logList.get(2).getLog_UDPTop_rate());
		map.put("col", 5);map.put("row", 14);map.put("colTo", 5);map.put("rowTo", 14);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",logList.get(2).getLog_UDPDown_rate());
		map.put("col", 5);map.put("row", 15);map.put("colTo", 5);map.put("rowTo", 15);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",logList.get(2).getLog_delayTime());
		map.put("col", 5);map.put("row", 16);map.put("colTo", 5);map.put("rowTo", 16);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 结论
		map.put("cellValue",Map.get("Conclusion"));
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 6);map.put("row", 3);map.put("colTo", 6);map.put("rowTo", 4);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("fontWeight",null);
		map.put("backgroundColour", null);
		map.put("col", 6);map.put("row", 5);map.put("colTo", 6);map.put("rowTo", 5);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",cell_section(logList, workParam));
		map.put("col", 6);map.put("row", 6);map.put("colTo", 6);map.put("rowTo", 6);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",cell_PCI(wordParam_in, workParam));
		map.put("col", 6);map.put("row", 7);map.put("colTo", 6);map.put("rowTo", 7);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 6);map.put("row", 8);map.put("colTo", 6);map.put("rowTo", 8);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 6);map.put("row", 9);map.put("colTo", 6);map.put("rowTo", 9);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 6);map.put("row", 10);map.put("colTo", 6);map.put("rowTo", 10);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","-");
		map.put("col", 6);map.put("row", 11);map.put("colTo", 6);map.put("rowTo", 11);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","-");
		map.put("col", 6);map.put("row", 12);map.put("colTo", 6);map.put("rowTo", 12);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",openRate(logList));
		map.put("col", 6);map.put("row", 13);map.put("colTo", 6);map.put("rowTo", 13);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",top_rate(logList));
		map.put("col", 6);map.put("row", 14);map.put("colTo", 6);map.put("rowTo", 14);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",down_rate(logList));
		map.put("col", 6);map.put("row", 15);map.put("colTo", 6);map.put("rowTo", 15);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",ping(logList));
		map.put("col", 6);map.put("row", 16);map.put("colTo", 6);map.put("rowTo", 16);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 备注
		map.put("cellValue",Map.get("Note"));
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 7);map.put("row", 3);map.put("colTo", 7);map.put("rowTo", 4);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("fontWeight",null);
		map.put("backgroundColour", null);
		map.put("col", 7);map.put("row", 5);map.put("colTo", 7);map.put("rowTo", 5);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 6);map.put("colTo", 7);map.put("rowTo", 6);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 7);map.put("colTo", 7);map.put("rowTo", 7);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 8);map.put("colTo", 7);map.put("rowTo", 8);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 9);map.put("colTo", 7);map.put("rowTo", 9);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 10);map.put("colTo", 7);map.put("rowTo", 10);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 11);map.put("colTo", 7);map.put("rowTo", 11);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 12);map.put("colTo", 7);map.put("rowTo", 12);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 13);map.put("colTo", 7);map.put("rowTo", 13);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 14);map.put("colTo", 7);map.put("rowTo", 14);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 15);map.put("colTo", 7);map.put("rowTo", 15);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue","");
		map.put("col", 7);map.put("row", 16);map.put("colTo", 7);map.put("rowTo", 16);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 基础信息检查
		map.put("cellValue",Map.get("BasicInInspection"));
		map.put("fontWeight",(short)1000);
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 0);map.put("row", 5);map.put("colTo", 0);map.put("rowTo", 7);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 站点状态检查
		map.put("cellValue",Map.get("SiteStatus"));
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 0);map.put("row", 8);map.put("colTo", 0);map.put("rowTo", 10);
		ExcelPoiUtil.createCell(wb,sheet1,map);
				
		// 单站功能验证
		map.put("cellValue",Map.get("SingleStFun"));
		map.put("backgroundColour", HSSFColor.GREY_25_PERCENT.index);
		map.put("col", 0);map.put("row", 11);map.put("colTo", 0);map.put("rowTo", 16);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 经纬度
		map.put("cellValue",Map.get("LatitudeLongitude"));
		map.put("fontWeight",null);
		map.put("backgroundColour",null);
		map.put("col", 1);map.put("row", 5);map.put("colTo", 1);map.put("rowTo", 5);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//现场测试经纬度与设计是否相符		
		map.put("cellValue",Map.get("CoincideDesign"));
		map.put("LRAlignment", false);
		map.put("col", 2);map.put("row", 5);map.put("colTo", 2);map.put("rowTo", 5);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// cellid
		map.put("cellValue","cellid");
		map.put("LRAlignment", true);
		map.put("col", 1);map.put("row", 6);map.put("colTo", 1);map.put("rowTo", 6);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//现场测试小区ID是否与设计一致
		map.put("cellValue",Map.get("FieldTestCellID"));
		map.put("LRAlignment", false);
		map.put("col", 2);map.put("row", 6);map.put("colTo", 2);map.put("rowTo", 6);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// PCI
		map.put("cellValue","PCI");
		map.put("LRAlignment", true);
		map.put("col", 1);map.put("row", 7);map.put("colTo", 1);map.put("rowTo", 7);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//现场测试小区PCI是否与设计一致
		map.put("cellValue",Map.get("FieldTestPCI"));
		map.put("LRAlignment", false);
		map.put("col", 2);map.put("row", 7);map.put("colTo", 2);map.put("rowTo", 7);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 告警检查
		map.put("cellValue",Map.get("AlarmCheck"));
		map.put("LRAlignment", true);
		map.put("col", 1);map.put("row", 8);map.put("colTo", 1);map.put("rowTo", 8);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//测试站点有无告警、传输是否正常、小区状态是否正常
		map.put("cellValue",Map.get("TestSite"));
		map.put("LRAlignment", false);
		map.put("col", 2);map.put("row", 8);map.put("colTo", 2);map.put("rowTo", 8);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 上行RSSI检查
		map.put("cellValue",Map.get("UpsideRSSIC"));
		map.put("LRAlignment", true);
		map.put("col", 1);map.put("row", 9);map.put("colTo", 1);map.put("rowTo", 9);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//空载RSSI值不高于RSSI参考值（-120dBm）6dB，否则认为RSSI异常
		map.put("cellValue",Map.get("Abnormal"));
		map.put("LRAlignment", false);
		map.put("col", 2);map.put("row", 9);map.put("colTo", 2);map.put("rowTo", 9);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 驻波比检查 
		map.put("cellValue",Map.get("BobbiInspection"));
		map.put("LRAlignment", true);
		map.put("col", 1);map.put("row", 10);map.put("colTo", 1);map.put("rowTo", 10);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//使用高精度驻波比监测，要求检测出的驻波比小于1.5
		map.put("cellValue",Map.get("PrecisionMonitoring"));
		map.put("LRAlignment", false);
		map.put("col", 2);map.put("row", 10);map.put("colTo", 2);map.put("rowTo", 10);
		ExcelPoiUtil.createCell(wb,sheet1,map);
				
		// 测试场景
		map.put("cellValue",Map.get("TestScene"));
		map.put("LRAlignment", true);
		map.put("col", 1);map.put("row", 11);map.put("colTo", 1);map.put("rowTo", 12);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",Map.get("AverageRSRP"));
		map.put("LRAlignment", false);
		map.put("col", 2);map.put("row", 11);map.put("colTo", 2);map.put("rowTo", 11);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		map.put("cellValue",Map.get("AverageSNR"));
		map.put("LRAlignment", false);
		map.put("col", 2);map.put("row", 12);map.put("colTo", 2);map.put("rowTo", 12);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 测试内容
		map.put("cellValue",Map.get("TestContent"));
		map.put("LRAlignment", true);
		map.put("col", 1);map.put("row", 13);map.put("colTo", 1);map.put("rowTo", 16);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//attach成功率
		map.put("cellValue",Map.get("AttachSuRate"));
		map.put("columnWidth",15000);
		map.put("LRAlignment", false);
		map.put("col", 2);map.put("row", 13);map.put("colTo", 2);map.put("rowTo", 13);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//单用户上行峰值吞吐率（UDP上行灌包）(>=10kbps)
		map.put("cellValue",Map.get("UDPUplinkPackage"));
		map.put("col", 2);map.put("row", 14);map.put("colTo", 2);map.put("rowTo", 14);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//单用户下行峰值吞吐率（UDP下行灌包）(>=14kbps)
		map.put("cellValue",Map.get("UDPDownlinkPackage"));
		map.put("col", 2);map.put("row", 15);map.put("colTo", 2);map.put("rowTo", 15);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		//ping时延（<1.5s)
		map.put("cellValue",Map.get("PingDelay"));
		map.put("col", 2);map.put("row", 16);map.put("colTo", 2);map.put("rowTo", 16);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
		// 备注说明		
		map.put("cellValue",Map.get("Descr"));
		map.put("fontWeight",(short)1000);
		map.put("columnWidth",5000);
		map.put("LRAlignment", true);
		map.put("col", 0);map.put("row", 17);map.put("colTo", 0);map.put("rowTo", 17);
		ExcelPoiUtil.createCell(wb,sheet1,map);		
//		1.attach成功率：要求RSRP>=-80dBm，反复发起attach 5次，计算成功率，建议标准100%。\r\n" + 
//		2.单用户上行峰值吞吐率：要求空载，选择RSRP>=-80dBm & SINR>20dB点测试，上行发包>=300Bytes，测试3次，速率>=10kbps时可认为达标。\r\n + 
//		3.单用户下行峰值吞吐率：要求空载，选择RSRP>=-80dBm & SINR>20dB点测试，下行发包>=300Bytes，测试3次，速率>=14kbps时可认为达标。\r\n + 
//		4.ping时延测试：要求空载，选择RSRP>=-80dBm & SINR>20dB点测试，idle态发起UE ping UDP服务器，ping包大小32Bytes，ping包间隔2秒，ping次数10次，建议标准<1.5s。\r\n + 
//		5.上行RSSI参考值：RSSI在子载波带宽为15kHz时的理论值为-131dBm。在180kHZ全带宽的理论值为-120dBm。
		map.put("cellValue",Map.get("AttachSURate ")+"\r\n" + 
						Map.get("SingleUpRate ")+"\r\n" + 
						Map.get("SingleDownRate ")+"\r\n" + 
						Map.get("PingDelayT")+" \r\n" + 
						Map.get("UplinkRSSIRe "));
		map.put("LRAlignment", false);
		map.put("fontWeight",null);
		map.put("col", 0);map.put("row", 18);map.put("colTo", 7);map.put("rowTo", 24);
		ExcelPoiUtil.createCell(wb,sheet1,map);
		
//		FileOutputStream fileOut = new FileOutputStream("E:/poi.xls");   
		wb.write(out);   
	}
	public String openRate (List<LogDomain> log) {
		String result = "正常";
		if (!(log.get(0).getLog_openRate().equals("100")
			&&log.get(0).getLog_openRate().equals("100")
			&&log.get(0).getLog_openRate().equals("100"))) {
			result = "异常";
		}
		return result;
	}
	
	public String ping (List<LogDomain> log) {
		String result = "正常";
		String log1 = log.get(0).getLog_delayTime();
		String log2 = log.get(1).getLog_delayTime();
		String log3 = log.get(2).getLog_delayTime();
		if (Double.parseDouble(log1.substring(0, log1.length()-3)) >= 1500.0
		  ||Double.parseDouble(log2.substring(0, log2.length()-3)) >= 1500.0
		  ||Double.parseDouble(log3.substring(0, log3.length()-3)) >= 1500.0) {
			result = "异常";
		}
		return result;
	} 
	
	public String top_rate (List<LogDomain> log) {
		String result = "正常";
		String log_top_rate1 = log.get(0).getLog_UDPTop_rate();
		String log_top_rate2 = log.get(1).getLog_UDPTop_rate();
		String log_top_rate3 = log.get(2).getLog_UDPTop_rate();
		if (Long.parseLong(log_top_rate1.substring(0, log_top_rate1.indexOf("."))) < 10
		  ||Long.parseLong(log_top_rate2.substring(0, log_top_rate2.indexOf("."))) < 10
		  ||Long.parseLong(log_top_rate3.substring(0, log_top_rate3.indexOf("."))) < 10) {
			result = "异常";
		}
		return result;
	} 
	
	public String down_rate (List<LogDomain> log) {
		String result = "正常";
		if (Long.parseLong(log.get(0).getLog_UDPDown_rate().substring(0, log.get(0).getLog_UDPDown_rate().indexOf("."))) < 14
		  ||Long.parseLong(log.get(1).getLog_UDPDown_rate().substring(0, log.get(0).getLog_UDPDown_rate().indexOf("."))) < 14
		  ||Long.parseLong(log.get(2).getLog_UDPDown_rate().substring(0, log.get(0).getLog_UDPDown_rate().indexOf("."))) < 14) {
			result = "异常";
		}
		return result;
	} 
	
	public String cell_section (List<LogDomain> log, List<WorkParamDomain> workParam ) {
		String result = "与设计一致";
		if (workParam.get(0).getWp_cell_section().equals(log.get(0).getCell_section())
		  ||workParam.get(1).getWp_cell_section().equals(log.get(1).getCell_section())
		  ||workParam.get(2).getWp_cell_section().equals(log.get(2).getCell_section())) {
			result = "与设计不一致";
		}
		return result;
	}
	
	public String cell_PCI  (List<WorkParam_inDomain> wordParam_in, List<WorkParamDomain> workParam ) {
		String result = "与设计一致";
		if (workParam.get(0).getWp_cell_PCI().equals(wordParam_in.get(0).getWp_cell_PCI())
		  ||workParam.get(1).getWp_cell_PCI().equals(wordParam_in.get(1).getWp_cell_PCI())
		  ||workParam.get(2).getWp_cell_PCI().equals(wordParam_in.get(2).getWp_cell_PCI())) {
			result = "与设计不一致";
		}
		return result;
	}
}
