package com.ibase.web.log.util.excel;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.junit.Test;

import com.ibase.core.utils.ExcelPoiUtil;
import com.ibase.web.log.domain.LogDomain;
import com.ibase.web.log.util.I18nUtil;
import com.ibase.web.plane.domain.Plane;
import com.ibase.web.workparam.domain.WorkParamDomain;
import com.ibase.web.workparam_in.domain.WorkParam_inDomain;

import jxl.format.BorderLineStyle;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;

/**
 * 联通报告
 */
public class CT_Excel {	
	@Test
	public void createExcel_CT(OutputStream out,Plane plane,List<WorkParamDomain> wordParamList,List<LogDomain> log, String lang) throws Exception{		
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		// 创建Excel工作薄 
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一个sheet（可以创建多个sheet,一个工作薄可以有多个sheet
		HSSFSheet sheet0 = wb.createSheet(Map.get("SingleTemplate"));
	    createExcelSubclass_CT(wb,sheet0, plane, wordParamList, log,lang);
		// 写入数据 
		wb.write(out); 
		// 关闭文件 
		wb.close();
		
	}
	public void createExcelSubclass_CT(HSSFWorkbook wb,HSSFSheet sheet,Plane plane,List wordParamList,List<LogDomain> logList, String lang) throws Exception{
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		Map<String, BorderLineStyle> mapBorder = new HashMap<String, BorderLineStyle>();
		Map map = new HashMap();
		int row = 0;
		int col = 0;
		int rowTo =0;
		int colTo=3;
		map.put("cellValue","");map.put("fontWeight",(short)1000);map.put("fontSize",(short) 18);//map.put("fontName", "宋体");
		map.put("columnWidth", 3000);map.put("rowHeight",(short) 500);
		map.put("LRAlignment", true);map.put("TBAlignment",true);
		map.put("col", row);map.put("row",row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		map.put("borderBottom",HSSFCellStyle.BORDER_THICK);		
		map.put("borderRight",HSSFCellStyle.BORDER_THICK);	 
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; col=col+4;rowTo =row;colTo=col;
		map.put("cellValue",Map.get("NB-IOT"));
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		map.put("columnWidth", 4500);
		map.put("borderBottom",HSSFCellStyle.BORDER_THICK);
		map.put("borderRight",null);
		
		ExcelPoiUtil.createCell(wb, sheet, map);
		//F50830天马山
		row=row; col=col+1;rowTo =row;colTo=col+1;	
		map.put("cellValue",Map.get("TMmountain"));
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		map.put("columnWidth", 4500);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
//上海联通单站核查优化测试报告
		row=row; col=col+2;rowTo =row;colTo=col+4;
		map.put("cellValue",Map.get("ShCTTest"));
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		map.put("columnWidth",3000);
		map.put("borderRight",HSSFCellStyle.BORDER_THICK);
		 
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;col=col+5;colTo=col;rowTo=row;
		map.put("cellValue"," ");
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		map.put("borderRight",null);
		 
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;col=col+1;colTo=col;rowTo=row;
		map.put("cellValue"," ");
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);	
		
		row=row;col=col+1;colTo=col;rowTo=row;
		map.put("cellValue"," ");
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;col=col+1;colTo=col;rowTo=row;
		map.put("cellValue"," ");
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
	
		row=row;col=col+1;colTo=col+4;rowTo=row;
		map.put("cellValue"," ");
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		map.put("borderLeft",HSSFCellStyle.BORDER_THICK);
		map.put("borderRight",HSSFCellStyle.BORDER_THICK);
		 
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;  colTo=col+4; col=0;rowTo=row;
		map.put("cellValue"," ");map.put("rowHeight",(short)300);
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		//测试人员信息
		row = TestEngineerinfo(wb,sheet, plane, col, row, colTo, rowTo, map, mapBorder,lang);
		//核查测试内容
		auditTestContent(wb,sheet, wordParamList, logList, col, row, colTo, rowTo, map,lang);
	}
	/**
	 * 测试人员信息
	 * @return
	 * @throws Exception 
	 */
	
	public int TestEngineerinfo(HSSFWorkbook wb,HSSFSheet sheet,Plane plane,int col,int row,int colTo,int rowTo,Map map,Map<String, BorderLineStyle> mapBorder,String lang) throws Exception{
			
		String testEngineerName = plane.getPlan_test_engineer();//测试工程师
		String backEngineerName = plane.getPlan_back_engineer();//eNB后台工程师		
		String ManageName = "";                                 //测试负责人	
		String testTime = plane.getPlane_test_time();           //查勘日期（年/月/日)	
		String eNBVer ="";                                      //eNB Ver值
		String testEngineerNu = plane.getPlan_te_phone();       //测试工程师电话
		String backEngineerNu = plane.getPlan_be_phone();       //后台工程师电话
		String ManageNu = "";                                   //测试负责人电话
		String testEngineerEm = "";								//测试工程师Email
		String backEngineerEm = "";								//后台工程师Email
		String ManageEm = "";									//测试负责人Email
		String end = "";									    //终端		
		Map<String, String> Map = I18nUtil.getLangMap(lang);		
		row=row+1;  colTo=colTo; col=0;rowTo=row;
		map.put("backgroundColour", HSSFColor.SKY_BLUE.index);map.put("fontSize",(short) 9);map.put("fontName", "宋体");
		map.put("cellValue","TestersIn ");map.put("rowHeight",(short)300);map.put("fontWeight",null);
		map.put("borderBottom",HSSFCellStyle.BORDER_THIN);map.put("borderLeft",HSSFCellStyle.BORDER_THIN);		
		map.put("borderRight",HSSFCellStyle.BORDER_THIN);
		
	
		 
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		row=row+1;rowTo=row;col=0;colTo=col+3;
		map.put("borderBottom",HSSFCellStyle.BORDER_THIN);
		
		map.put("borderTop",HSSFCellStyle.BORDER_THIN);
		map.put("borderRight",HSSFCellStyle.BORDER_THIN);
	    map.put("backgroundColour", null);map.put("rowHeight",(short)300);
		
		map.put("cellValue",Map.get("TestEngineer"));//测试工程师
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=0;colTo=col+3;
		map.put("cellValue",Map.get("eNBBackEngineer"));//eNB后台工程师 
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=0;colTo=col+3;
		map.put("cellValue",Map.get("TestPerson"));//测试负责人
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=0;colTo=col+3;
		map.put("cellValue",Map.get("SurveyDate"));//查勘日期（年/月/日)
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row-3;rowTo=row;col=col+4;colTo=col+4;
		map.put("cellValue",testEngineerName);//测试工程师
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+4;
		map.put("cellValue",backEngineerName);//eNB后台工程师 
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+4;
		map.put("cellValue",ManageName);//测试负责人
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+4;
		map.put("cellValue",testTime);//查勘日期（年/月/日)
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//电话		
		row=row-3;rowTo=row;col=col+5;colTo=col;
		map.put("cellValue",Map.get("Tell"));//电话:
		map.put("backgroundColour",null);
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue",Map.get("Tell"));//电话:
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue",Map.get("Tell"));//电话:
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","eNB Ver ");//eNB Ver
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//电话值
		row=row-3;rowTo=row;col=col+1;colTo=col+4;
		map.put("cellValue",testEngineerNu);//测试工程师电话值:
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+4;
		map.put("cellValue",backEngineerNu);//后台工程师电话值:
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+4;
		map.put("cellValue",ManageNu);//测试负责人电话值:
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+4;
		map.put("cellValue",eNBVer);//eNB Ver值
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//email	
		row=row-3;rowTo=row;col=col+5;colTo=col;
		map.put("cellValue","email:");//email:
		map.put("backgroundColour",null);
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","email:");//email:
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","email:");//email:
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue",Map.get("Terminal"));//eNB Ver
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//email值
		row=row-3;rowTo=row;col=col+1;colTo=col+4;
		map.put("cellValue",testEngineerEm);//email值
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+4;
		map.put("cellValue",backEngineerEm);//email值
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+4;
		map.put("cellValue",ManageEm);//email值
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+4;
		map.put("cellValue", end);//终端值
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//单站考核		
		row=row+1;rowTo=row+2;col=0;colTo=col+3;
		map.put("cellValue",Map.get("SingleStation"));
		map.put("backgroundColour",null);map.put("fontWeight",(short)1000);
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//单站考核值
		row=row;rowTo=row+2;col=col+4;colTo=col+4;
		map.put("cellValue",Map.get("SingleStationValue"));
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//速率验证
		row=row;rowTo=row;col=col+5;colTo=col+2;
		map.put("cellValue",Map.get("RatePass"));
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//时延验证		
		row=row+1;rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("TimeDelayP"));
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//小区覆盖		
		row=row+1;rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("CommunityNormal"));
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
//速率是否通过值
		row=row-2;rowTo=row;col=col+3;colTo=col;
		map.put("cellValue",Map.get("RateValueP"));
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//时延是否通过值		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue",Map.get("TimeDelayValueP"));
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);		
//小区覆盖是否正常值		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue",Map.get("CommunityNormalP"));
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//空格		
		row=row-2;rowTo=row;col=col+1;colTo=col+7;
		map.put("cellValue","");
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+7;
		map.put("cellValue","");
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+7;
		map.put("cellValue","");
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		return rowTo=row+1;
	}
	/**
	 *核查测试内容
	 */
	public int auditTestContent(HSSFWorkbook wb,HSSFSheet sheet,List<WorkParamDomain> wordParamList,List<LogDomain> log,int col,int row,int colTo,int rowTo,Map map,String lang
			) throws Exception {
		Map<String, String> Map = I18nUtil.getLangMap(lang);		
		row=row+1;  col=0; colTo=20;rowTo=row;
		Map<String, BorderLineStyle> mapBorder = new HashMap<String, BorderLineStyle>();
		map.put("backgroundColour", HSSFColor.SKY_BLUE.index);map.put("fontSize",(short) 10);map.put("fontName", "宋体");
		//核查测试内容
		map.put("cellValue",Map.get("TestContentC"));map.put("rowHeight",(short)300);
		map.put("borderBottom",HSSFCellStyle.BORDER_THIN);map.put("borderTop",HSSFCellStyle.BORDER_THIN);
		
		 
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		//NO.1确认被测站点的基本物理配置是否和规划配置一致
		row = no_1Info(wb,sheet, wordParamList, log, col, row, colTo, rowTo, mapBorder,lang);
		//NO.2基本配置参数检查
        row = no_2Info(wb,sheet,wordParamList, col, row, colTo, rowTo, map,lang);
		//NO.3连接模式下基本业务功能检查（测试点导频质量要求：RS_RSRP>-100dBm）
		
        row = no_3Info(wb,sheet,log, col, row, colTo, rowTo, map,lang);
		
		return rowTo;
	}
	/**
	 * NO.1
	 */
	public int no_1Info(HSSFWorkbook wb,HSSFSheet sheet,List<WorkParamDomain> wordParamList,List<LogDomain> log,int col,int row,int colTo,int rowTo,Map map,String lang) throws Exception {
		Map<String, String> Map = I18nUtil.getLangMap(lang);	
		Map<String, BorderLineStyle> mapBorder = new HashMap<String, BorderLineStyle>();
		String stationHight = wordParamList.get(0).getWp_station_height();              //站高
		String longitude = wordParamList.get(0).getWp_station_longitude();              //经度
		String latitude = wordParamList.get(0).getWp_station_latitude();                //纬度
		String workModel1  = wordParamList.get(0).getWp_cell_workModel();                //方位角
		String workModel2  = wordParamList.get(1).getWp_cell_workModel();                //方位角
		String workModel3  = wordParamList.get(2).getWp_cell_workModel();                //方位角
		row=row+1; rowTo=row;col=0;colTo=col;
		map.put("backgroundColour", null);
		map.put("cellValue","NO.1");map.put("col", col);map.put("LRAlignment", false);map.put("TBAlignment",false);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		map.put("borderBottom",HSSFCellStyle.BORDER_THIN);
		map.put("borderRight",HSSFCellStyle.BORDER_THIN);
		 
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; rowTo=row;col=col+1;colTo=20;
		//确认被测站点的基本物理配置是否和规划配置一致
		map.put("cellValue",Map.get("MeasuredSite"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//NB站点		
		row=row+1; rowTo=row+7;col=col-1;colTo=col;
		map.put("cellValue",Map.get("NBSite"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		//检测项
		row=row; rowTo=row+1;col=col+1;colTo=col+2;map.put("LRAlignment", true);map.put("TBAlignment",true);
		map.put("cellValue",Map.get("DetectionItem"));map.put("col", col);map.put("fontWeight",null);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
     	ExcelPoiUtil.createCell(wb, sheet, map);
//站高
		row=row+2; rowTo=row;col=col;colTo=col+2;
		
		map.put("backgroundColour", HSSFColor.YELLOW.index);
		map.put("fontColour",HSSFColor.RED.index);
		map.put("cellValue",Map.get("StationHigh"));map.put("col", col);map.put("LRAlignment", false);map.put("TBAlignment",false);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//经度	
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("Longitude"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//维度	
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("Latitude"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//天线型号		
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("AntennaModel"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//天线类型		
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("AntennaType"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//是否是否共天馈		
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("AntennaFeeder"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//U900站点
		row=row+1; rowTo=row+2;col=col-1;colTo=col;
		map.put("backgroundColour", null);map.put("fontWeight",(short)1000);
		map.put("fontColour",null);
		map.put("cellValue",Map.get("U900Site"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//方位角 
		row=row; rowTo=row;col=col+1;colTo=col+2;
		map.put("fontWeight",null);map.put("backgroundColour", HSSFColor.YELLOW.index);
		map.put("fontColour",HSSFColor.RED.index);
		map.put("cellValue",Map.get("Azimuth"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//物理倾角		
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("PhysicalDip"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		row=row+1; rowTo=row;col=col;colTo=col+2;
		ExcelPoiUtil.createCell(wb, sheet, map);
//电子倾角
		
		map.put("cellValue",Map.get("ElectronicTiltAngle"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//设计值
		row=13;rowTo=row;col=4;colTo=col+2;
		map.put("backgroundColour", null);map.put("fontColour", null);map.put("LRAlignment", true);map.put("TBAlignment",true);
		map.put("cellValue",Map.get("DesignValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S1		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("fontWeight",(short)1000);
		map.put("cellValue","S1");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","S2");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3	
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("columnWidth", 3000);
		map.put("cellValue","S3");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
//站高值 
		row=row+1;rowTo=row;col=4;colTo=col;
		map.put("fontWeight",null);map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//经度值
		row=row+1;rowTo=row;col=4;colTo=col+2;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//纬度值		
		row=row+1;rowTo=row;col=col;colTo=col+2;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//天线型号值
		row=row+1;rowTo=row;col=col;colTo=col+2;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//天线类型值
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//是否共天馈（如果是请填写和W/G共天馈）值		
		
		row=row+1;rowTo=row;col=4;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//方位角值
		row=row+1;rowTo=row;col=4;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//物理倾角值		
		row=row+1;rowTo=row;col=4;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//电子倾角值	
		row=row+1;rowTo=row;col=4;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//实测值
		row=13;rowTo=row;col=7;colTo=col+2;
		map.put("backgroundColour", null);
		map.put("cellValue",Map.get("MeasuredValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S1    
		row=row+1;rowTo=row;col=7;colTo=col;
		map.put("fontWeight",(short)1000);
		map.put("cellValue","S1");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","S1");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","S3");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//站高值
		row=row+1;rowTo=row;col=7;colTo=col;
		map.put("fontWeight",null);map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",stationHight);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue",stationHight);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue",stationHight);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//经度值   
		row=row+1;rowTo=row;col=7;colTo=col+2;
		map.put("cellValue",longitude);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//纬度值  
		row=row+1;rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",latitude);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//天线型号值
		row=row+1;rowTo=row;col=col;colTo=col+2;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//天线类型值
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//是否共天馈（如果是请填写和W/G共天馈）		
		row=row+1;rowTo=row;col=7;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//方位角值		
		row=row+1;rowTo=row;col=7;colTo=col;
		map.put("cellValue",workModel1);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue",workModel2);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue",workModel3);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
//物理倾角值		
		row=row+1;rowTo=row;col=7;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//电子倾角值		
		row=row+1;rowTo=row;col=7;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//结论		
		row=13;rowTo=row+1;col=col+1;colTo=col;
		map.put("backgroundColour",null);
		map.put("cellValue","Conclusion");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//1结论站高			
		row=row+2;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//2结论经度		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//3结论纬度		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//4结论天线型号	
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//5结论天线类型
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//6结论是否共天馈（如果是请填写和W/G共天馈）		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//7结论方位角
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//8结论物理倾角
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//9结论电子倾角
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//备注     
		row=13; rowTo=row+1; col=col+1;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//站高备注		
		row=row+2; rowTo=row; col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//经度备注		
		row=row+1; rowTo=row; col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);		
//纬度备注
		row=row+1; rowTo=row; col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//天线类型备注
		row=row+1; rowTo=row; col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);		
//天线型号备注	
		row=row+1; rowTo=row; col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);	
//是否共天馈备注
		row=row+1; rowTo=row; col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);	
//方位角备注
		row=row+1; rowTo=row; col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);	
//物理倾角备注	
		row=row+1; rowTo=row; col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);	
//电子倾角备注	
		row=row+1; rowTo=row; col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);	
		return rowTo;
	}
	/**
	 * NO.2
	 */
	public int no_2Info(HSSFWorkbook wb,HSSFSheet sheet,List<WorkParamDomain> workParamList,int col,int row,int colTo,int rowTo,Map map,String lang) throws Exception {
//NO.2	
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		String PCI1 = workParamList.get(0).getWp_cell_PCI();       //PCI
		String PCI2 = workParamList.get(1).getWp_cell_PCI();
		String PCI3 = workParamList.get(2).getWp_cell_PCI(); 
		String BW = "";										       //BW
		String cellId1 = workParamList.get(0).getWp_cell_section();//小区号
		String cellId2 = workParamList.get(1).getWp_cell_section();
		String cellId3 = workParamList.get(2).getWp_cell_section();
		
		String eNBID   = workParamList.get(0).getWp_station_ENBID();//eNBID
		String TAC = workParamList.get(0).getWp_station_TAC();      //TAC
		
		String result = "";
		row=row+1; rowTo=row;col=0;colTo=col;
		map.put("backgroundColour",null);
		map.put("borderBottom",HSSFCellStyle.BORDER_THIN);		
		map.put("borderRight",HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft",HSSFCellStyle.BORDER_THIN);
		map.put("borderTop",HSSFCellStyle.BORDER_THIN);
		map.put("cellValue","NO.2");map.put("col", col);map.put("LRAlignment", false);map.put("TBAlignment",false);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);	
		ExcelPoiUtil.createCell(wb, sheet, map);
//配置参数检查		
		row=row; rowTo=row;col=col+1;colTo=20;
		map.put("cellValue",Map.get("ConParameterCheck"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
//空格
		row=row+1; rowTo=row+8;col=0;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//检查项		
		row=25; rowTo=row+1;col=col+1;colTo=col+2;
		map.put("fontWeight",null);map.put("LRAlignment", true);map.put("TBAlignment",true);
		map.put("cellValue",Map.get("InspectionItem"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//PCI		
		row=row+2; rowTo=row;col=col;colTo=col+2;
		map.put("fontWeight",null);map.put("LRAlignment", true);map.put("TBAlignment",true);
		map.put("cellValue","PCI");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//频点		
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("Frequency"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//BW	
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue","BW");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//CELL ID		
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue","CELL ID");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//eNBID	
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue","eNBID");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//归属TAC		
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("OwnershipTAC"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//逻辑小区检查		
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("LogicalCell"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//设计值
		row=25; rowTo=row; col=colTo+1;colTo=col+2;
		map.put("cellValue",Map.get("DesignValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S1		
		row=row+1; rowTo=row; col=col;colTo=col;
		map.put("fontWeight",(short)1000);
		map.put("cellValue","S1");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue","S2");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue","S3");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//PCI值		
		row=row+1; rowTo=row; col=4;colTo=col;
		map.put("fontWeight",null);map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",Map.get("PCIValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",Map.get("PCIValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",Map.get("PCIValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
//频点值		
		row=row+1; rowTo=row; col=4;colTo=col;
		map.put("cellValue",Map.get("FrequencyValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",Map.get("FrequencyValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",Map.get("FrequencyValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//BW值		
		row=row+1; rowTo=row; col=4;colTo=col;
		map.put("cellValue",Map.get("BWValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",Map.get("BWValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",Map.get("BWValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//CELL ID值		
		row=row+1; rowTo=row; col=4;colTo=col;
		map.put("cellValue",Map.get("CELLIDValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",Map.get("CELLIDValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",Map.get("CELLIDValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//eNBID值
		row=row+1; rowTo=row; col=4;colTo=col+2;
		map.put("cellValue",Map.get("eNBIDValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//归属TAC值
		row=row+1; rowTo=row; col=4;colTo=col+2;
		map.put("cellValue",Map.get("OwnershipTACValues"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//逻辑小区检查
		//S1
		row=row+1; rowTo=row; col=4;colTo=col+1;
//		if(){
//			map.put("fontColour",HSSFColor.RED.index);
//		};
		map.put("cellValue","S1");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		//S2
		row=row; rowTo=row; col=col+2;colTo=col+1;
////		if(){
////			map.put("fontColour",HSSFColor.RED.index);
////		};
		map.put("cellValue","S2");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
    	ExcelPoiUtil.createCell(wb, sheet, map);
	   //S3
		row=row; rowTo=row; col=col+2;colTo=col+1;
//		if(){
//			map.put("fontColour",HSSFColor.RED.index);
//		};
		map.put("cellValue","S3");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//实测值	
		row=25; rowTo=row; col=7;colTo=col+2;
		map.put("backgroundColour", null);
		map.put("cellValue",Map.get("MeasuredValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S1		
		row=row+1;rowTo=row; col=7;colTo=col;
		map.put("fontWeight",(short)1000);
		map.put("cellValue","S1");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue","S1");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3		
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue","S1");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//PCI实测值		
		row=row+1;rowTo=row; col=7;colTo=col;
		map.put("fontWeight",null);map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",PCI1);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",PCI2);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",PCI3);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//频点实测值		
		row=row+1;rowTo=row; col=7;colTo=col;
		map.put("fontWeight",null);map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//BW实测值		
		row=row+1;rowTo=row; col=7;colTo=col;
		map.put("fontWeight",null);map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",BW);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",BW);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",BW);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//CELL ID实测值		
		row=row+1;rowTo=row; col=7;colTo=col;
		map.put("fontWeight",null);map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",cellId1);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",cellId2);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",cellId3);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//eNBID实测值
		row=row+1;rowTo=row; col=7;colTo=col+2;
		map.put("cellValue",eNBID);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//归属TAC实测值
		row=row+1;rowTo=row; col=7;colTo=col+2;
		map.put("cellValue",TAC);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//结论
		row=25;rowTo=row+1; col=10;colTo=col;
		map.put("cellValue",Map.get("Conclusion"));map.put("col", col);map.put("backgroundColour", null);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//PIC结论
		row=row+2;rowTo=row; col=col; colTo=col;
		map.put("cellValue",Map.get("PICConclusion"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//频点结论
		row=row+1;rowTo=row; col=col; colTo=col;
		map.put("cellValue",Map.get("FrequencyConclusion"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//BW结论
		row=row+1;rowTo=row; col=col; colTo=col;
		map.put("cellValue",Map.get("BWConclusion"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//CELL ID结论
		row=row+1;rowTo=row; col=col; colTo=col;
		map.put("cellValue",Map.get("CELLIDConclusion"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//eNB ID结论
		row=row+1;rowTo=row; col=col; colTo=col;
		map.put("cellValue",Map.get("eNBIDConclusion"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//归属TAC结论
		row=row+1;rowTo=row; col=col; colTo=col;
		map.put("cellValue",Map.get("OwnershipTACConclusion"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//备注
		row=25;rowTo=row+1;col=col+1;colTo=20;
		map.put("cellValue",Map.get("Note"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//		
		row=row+2;rowTo=row+1;col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//1		
		row=row+2;rowTo=row;col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//2		
		row=row+1;rowTo=row;col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//3
		row=row+1;rowTo=row;col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//4
		row=row+1;rowTo=row;col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//5
		row=row+1;rowTo=row;col=col-1;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		
		
		return rowTo;
		

	}
	/**
	 * NO.3
	 */
	public int no_3Info(HSSFWorkbook wb,HSSFSheet sheet,List<LogDomain> logList,int col,int row,int colTo,int rowTo,Map map,String lang) throws Exception {
		Map<String, String> Map = I18nUtil.getLangMap(lang);		
		String RSRP1 = logList.get(0).getLog_RSRP();             //RSRP1															 //
		String RSRP2 = logList.get(1).getLog_RSRP();			 //RSRP2
		String RSRP3 = logList.get(2).getLog_RSRP();             //RSRP3
		
		String SINR1 = logList.get(0).getLog_SINR();             //SINR1															 //
		String SINR2 = logList.get(1).getLog_SINR();			 //SINR2
		String SINR3 = logList.get(2).getLog_SINR();             //SINR3
		
		String log_top_rate1 = logList.get(0).getLog_UDPTop_rate();  //上行速率 1 
		String log_top_rate2 = logList.get(1).getLog_UDPTop_rate();  //上行速率 2 
		String log_top_rate3 = logList.get(2).getLog_UDPTop_rate();  //上行速率 3 
		
		String log_delayTime1 = logList.get(0).getLog_delayTime(); //ping时延1
		String log_delayTime2 = logList.get(1).getLog_delayTime(); //ping时延2
		String log_delayTime3 = logList.get(2).getLog_delayTime(); //ping时延3
		
		String log_openRate1   = logList.get(0).getLog_openRate();  //接通率1
		String log_openRate2   = logList.get(1).getLog_openRate();  //接通率2
		String log_openRate3   = logList.get(2).getLog_openRate();  //接通率3
		Map<String, BorderLineStyle> mapBorder = new HashMap<String, BorderLineStyle>();
//NO.3			
		row=row+1;rowTo=row;col=0;colTo=col;
		map.put("fontWeight",(short)1000);map.put("LRAlignment", false);map.put("TBAlignment",false);
		map.put("cellValue","NO.3");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//连接模式下基本业务功能检查(测试点导频质量要求：RS_RSRP>-100dBm )
		row=row;rowTo=row;col=col+1;colTo=20;
		map.put("cellValue",Map.get("FunctionCheck"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//TM3 alternative		
		row=row+1;rowTo=row+11;col=0;colTo=col;
		map.put("cellValue","TM3 alternative");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//小区信		
		row=35;rowTo=row+1;col=col+1;colTo=col+2;
		map.put("cellValue",Map.get("CellLetter"));map.put("fontWeight",null);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//检测项		
		row=row+2;rowTo=row+2;col=col;colTo=col+2;
		map.put("cellValue",Map.get("DetectionItem"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//100bytes上行速率(kbps)		
		row=row+3;rowTo=row;col=col;colTo=col+2;
		map.put("LRAlignment", true);map.put("TBAlignment",true);
		map.put("cellValue",Map.get("UplinkRate"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//时延(s)		
		row=row+1;rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("TimeDelay"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//接通率		
		row=row+1;rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("ConnectionRate"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//掉话率		
		row=row+1;rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("DropRate"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//小区信息		
		row=row+1;rowTo=row;col=col;colTo=20;
		map.put("backgroundColour", HSSFColor.SKY_BLUE.index);
		map.put("cellValue",Map.get("CellIn"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//单站异常情况		
		row=row+1;rowTo=row;col=col;colTo=col+3;

		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",Map.get("SingleStationAnomaly"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//单站异常情况		
		row=row+1;rowTo=row;col=col;colTo=col+3;
		map.put("backgroundColour", null);
		map.put("cellValue",Map.get("RelatedLogFiles"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S1测试点导频信号质量(RSRP&SINR)		
		row=35;rowTo=row;col=4;colTo=col+5;
		map.put("cellValue",Map.get("S1PilotSignalQuality"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//RSRP		
		row=row+1;rowTo=row;col=4;colTo=col+2;
		map.put("cellValue","RSRP");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//SINR 		
		row=row;rowTo=row;col=col+3;colTo=col+2;
		map.put("cellValue","SINR ");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

//S1RSRP值		
		row=row+1;rowTo=row+1;col=4;colTo=col+2;
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",RSRP1);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S1SINR值 		
		row=row;rowTo=row+1;col=col+3;colTo=col+2;
		map.put("cellValue",SINR1);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S1		
		row=row+2;rowTo=row;col=4;colTo=col+5;
		map.put("backgroundColour", null);
		map.put("cellValue","S1");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//100bytes上行速率(kbps)值		
		row=row+1;rowTo=row;col=4;colTo=col+5;
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",log_top_rate1);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//时延(s)值		
		row=row+1;rowTo=row;col=4;colTo=col+5;
		map.put("cellValue",log_delayTime1);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//接通率值		
		row=row+1;rowTo=row;col=4;colTo=col+5;
		map.put("cellValue",log_openRate1);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//掉话率值		
		row=row+1;rowTo=row;col=4;colTo=col+5;
		map.put("cellValue","");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2测试点导频信号质量(RSRP&SINR)		
		row=35;rowTo=row;col=col+6;colTo=col+5;
		map.put("backgroundColour", null);
		map.put("cellValue",Map.get("S2PilotSignalQuality"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2RSRP		
		row=row+1;rowTo=row;col=10;colTo=col+2;
		map.put("backgroundColour", null);
		map.put("cellValue","RSRP");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2SINR 		
		row=row;rowTo=row;col=col+3;colTo=col+2;
		map.put("cellValue","SINR ");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2RSRP值		
		row=row+1;rowTo=row+1;col=10;colTo=col+2;
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",RSRP2);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2SINR值		
		row=row;rowTo=row+1;col=col+3;colTo=col+2;
		map.put("cellValue",SINR2);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2		
		row=row+2;rowTo=row;col=10;colTo=col+5;
		map.put("backgroundColour", null);
		map.put("cellValue","S2");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2100bytes上行速率(kbps)值
		row=row+1;rowTo=row;col=10;colTo=col+5;
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",log_top_rate1);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2时延(s)值
		row=row+1;rowTo=row;col=10;colTo=col+5;
		map.put("cellValue",log_delayTime2);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2接通率值
		row=row+1;rowTo=row;col=10;colTo=col+5;
		map.put("cellValue",log_openRate2);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2掉话率值
		row=row+1;rowTo=row;col=10;colTo=col+5;
		map.put("cellValue","");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3测试点导频信号质量(RSRP&SINR)		
		row=35;rowTo=row;col=col+6;colTo=col+4;
		map.put("backgroundColour",null);
		map.put("cellValue",Map.get("S3PilotSignalQuality"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3RSRP	
		row=row+1;rowTo=row;col=16;colTo=col+2;
		map.put("cellValue","RSRP");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3SINR 	
		row=row;rowTo=row;col=col+3;colTo=col+1;
		map.put("cellValue","SINR ");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3RSRP值 	
		row=row+1;rowTo=row+1;col=16;colTo=col+2;
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",RSRP3);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3SINR值 	
		row=row;rowTo=row+1;col=col+3;colTo=col+1;
		map.put("cellValue",SINR3);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3 	
		row=row+2;rowTo=row;col=16;colTo=20;
		map.put("backgroundColour",null);
		map.put("cellValue","S3");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3100bytes上行速率(kbps)值 	
		row=row+1;rowTo=row;col=16;colTo=20;
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",log_top_rate3);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3时延(s)值 	
		row=row+1;rowTo=row;col=16;colTo=20;	
		map.put("cellValue",log_delayTime3);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3接通率值 	
		row=row+1;rowTo=row;col=16;colTo=20;	
		map.put("cellValue",log_openRate3);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3掉话率值 	
		row=row+1;rowTo=row;col=16;colTo=20;	
		map.put("cellValue","");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//备注	
		row=45;rowTo=row;col=5;colTo=col+1;
		map.put("cellValue","Note");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//备注值	
		row=row;rowTo=row;col=col+2;colTo=20;
		map.put("backgroundColour", HSSFColor.YELLOW.index);
		map.put("cellValue","Note");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//备注	
		row=row+1;rowTo=row;col=5;colTo=col+1;
		map.put("backgroundColour", null);
		map.put("cellValue","Note");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//备注值	
		row=row;rowTo=row;col=col+2;colTo=20;
		map.put("backgroundColour", null);
		map.put("cellValue","Note");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//末尾
		row=row+1;rowTo=row;col=0;colTo=col;
		map.put("cellValue","");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=20;
		map.put("cellValue","");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		return rowTo;
	}
	
//kai
	public void createExcel_CT_in(OutputStream out,Plane plane,List<WorkParam_inDomain> wordParamList,List<LogDomain> log, String lang) throws Exception{		
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		// 创建Excel工作薄 
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一个sheet（可以创建多个sheet,一个工作薄可以有多个sheet
		HSSFSheet sheet0 = wb.createSheet(Map.get("SingleTemplate"));
	    createExcelSubclass_CT_in(wb,sheet0, plane, wordParamList, log,lang);
		// 写入数据 
		wb.write(out); 
		// 关闭文件 
		wb.close();
		
	}
	public void createExcelSubclass_CT_in(HSSFWorkbook wb,HSSFSheet sheet,Plane plane,List<WorkParam_inDomain> wordParamList,List<LogDomain> logList, String lang) throws Exception{

		Map<String, String> Map = I18nUtil.getLangMap(lang);
		
		Map<String, BorderLineStyle> mapBorder = new HashMap<String, BorderLineStyle>();
		Map map = new HashMap();
		int row = 0;
		int col = 0;
		int rowTo =0;
		int colTo=3;
		map.put("cellValue","");map.put("fontWeight",(short)1000);map.put("fontSize",(short) 18);map.put("fontName", "宋体");
		map.put("columnWidth", 3000);map.put("rowHeight",(short) 500);map.put("LRAlignment", true);map.put("TBAlignment",true);
		map.put("col", row);map.put("row",row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		map.put("borderBottom",HSSFCellStyle.BORDER_THICK);		
		map.put("borderRight",HSSFCellStyle.BORDER_THICK);	 
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; col=col+4;rowTo =row;colTo=col;
		map.put("cellValue",Map.get("NB-IOT"));
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		map.put("columnWidth", 4500);
		map.put("borderBottom",HSSFCellStyle.BORDER_THICK);
		map.put("borderRight",null);
		
		ExcelPoiUtil.createCell(wb, sheet, map);
//F50830天马山	
		row=row; col=col+1;rowTo =row;colTo=col+1;
		map.put("cellValue",Map.get("TMmountain"));
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		map.put("columnWidth", 4500);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
//上海联通单站核查优化测试报告
		row=row; col=col+2;rowTo =row;colTo=col+4;
		map.put("cellValue",Map.get("ShCTTest"));
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		map.put("columnWidth",3000);
		map.put("borderRight",HSSFCellStyle.BORDER_THICK);
		 
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;col=col+5;colTo=col;rowTo=row;
		map.put("cellValue"," ");
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		map.put("borderRight",null);
		 
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;col=col+1;colTo=col;rowTo=row;
		map.put("cellValue"," ");
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);	
		
		row=row;col=col+1;colTo=col;rowTo=row;
		map.put("cellValue"," ");
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;col=col+1;colTo=col;rowTo=row;
		map.put("cellValue"," ");
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
	
		row=row;col=col+1;colTo=col+4;rowTo=row;
		map.put("cellValue"," ");
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		map.put("borderLeft",HSSFCellStyle.BORDER_THICK);
		map.put("borderRight",HSSFCellStyle.BORDER_THICK);
		 
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;  colTo=col+4; col=0;rowTo=row;
		map.put("cellValue"," ");;map.put("rowHeight",(short)300);
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		//测试人员信息
		row = TestEngineerinfo(wb,sheet, plane, col, row, colTo, rowTo, map, mapBorder,lang);
		//核查测试内容
		auditTestContent_in(wb,sheet, wordParamList, logList, col, row, colTo, rowTo, map,lang);
	}
	/**
	 * 测试人员信息
	 * @return
	 * @throws Exception 
	 */
	
	public int TestEngineerinfo_in(HSSFWorkbook wb,HSSFSheet sheet,Plane plane,int col,int row,int colTo,int rowTo,Map map,Map<String, BorderLineStyle> mapBorder,String lang) throws Exception{
		Map<String, String> Map = I18nUtil.getLangMap(lang);	
		String testEngineerName = plane.getPlan_test_engineer();//测试工程师
		String backEngineerName = plane.getPlan_back_engineer();//eNB后台工程师		
		String ManageName = "";                                 //测试负责人	
		String testTime = plane.getPlane_test_time();           //查勘日期（年/月/日)	
		String eNBVer ="";                                      //eNB Ver值
		String testEngineerNu = plane.getPlan_te_phone();       //测试工程师电话
		String backEngineerNu = plane.getPlan_be_phone();       //后台工程师电话
		String ManageNu = "";                                   //测试负责人电话
		String testEngineerEm = "";								//测试工程师Email
		String backEngineerEm = "";								//后台工程师Email
		String ManageEm = "";									//测试负责人Email
		String end = "";									    //终端
		row=row+1;  colTo=colTo; col=0;rowTo=row;
		map.put("backgroundColour", HSSFColor.SKY_BLUE.index);
		map.put("backgroundColour", HSSFColor.SKY_BLUE.index);map.put("fontSize",(short) 9);map.put("fontName", "宋体");
		//测试人员信息
		map.put("cellValue",Map.get("TestersIn"));map.put("rowHeight",(short)300);map.put("fontWeight",null);
		map.put("borderBottom",HSSFCellStyle.BORDER_THIN);map.put("borderLeft",HSSFCellStyle.BORDER_THIN);		
		map.put("borderRight",HSSFCellStyle.BORDER_THIN);
		 
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		row=row+1;rowTo=row;col=0;colTo=col+3;
		map.put("borderBottom",HSSFCellStyle.BORDER_THIN);
		
		map.put("borderTop",HSSFCellStyle.BORDER_THIN);
		map.put("borderRight",HSSFCellStyle.BORDER_THIN);
	    map.put("backgroundColour", null);
		map.put("columnWidth",3000);map.put("rowHeight",(short)300);
		
		map.put("cellValue",Map.get("TestEngineer"));//测试工程师
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=0;colTo=col+3;
		map.put("cellValue",Map.get("eNBBackEngineer"));//eNB后台工程师 
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=0;colTo=col+3;
		map.put("cellValue",Map.get("TestPerson"));//测试负责人
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=0;colTo=col+3;
		map.put("cellValue",Map.get("SurveyDate"));//查勘日期（年/月/日)
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row-3;rowTo=row;col=col+4;colTo=col+4;
		map.put("cellValue",testEngineerName);//测试工程师
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+4;
		map.put("cellValue",backEngineerName);//eNB后台工程师 
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+4;
		map.put("cellValue",ManageName);//测试负责人
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+4;
		map.put("cellValue",testTime);//查勘日期（年/月/日)
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//电话		
		row=row-3;rowTo=row;col=col+5;colTo=col;
		map.put("cellValue",Map.get("Tell"));//电话:
		map.put("backgroundColour",null);
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue",Map.get("Tell"));//电话:
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue",Map.get("Tell"));//电话:
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","eNB Ver ");//eNB Ver
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//电话值
		row=row-3;rowTo=row;col=col+1;colTo=col+4;
		map.put("cellValue",testEngineerNu);//测试工程师电话值:
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+4;
		map.put("cellValue",backEngineerNu);//后台工程师电话值:
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+4;
		map.put("cellValue",ManageNu);//测试负责人电话值:
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+4;
		map.put("cellValue",eNBVer);//eNB Ver值
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//email	
		row=row-3;rowTo=row;col=col+5;colTo=col;
		map.put("cellValue","email:");//email:
		map.put("backgroundColour",null);
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","email:");//email:
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","email:");//email:
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue",Map.get("Terminal"));//eNB Ver
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//email值
		row=row-3;rowTo=row;col=col+1;colTo=col+4;
		map.put("cellValue",testEngineerEm);//email值
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+4;
		map.put("cellValue",backEngineerEm);//email值
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+4;
		map.put("cellValue",ManageEm);//email值
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+4;
		map.put("cellValue", end);//终端值
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//单站考核		
		row=row+1;rowTo=row+2;col=0;colTo=col+3;
		map.put("cellValue",Map.get("SingleStation"));
		map.put("backgroundColour",null);map.put("fontWeight",(short)1000);
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//单站考核值
		row=row;rowTo=row+2;col=col+4;colTo=col+4;
		map.put("cellValue",Map.get("SingleStationValue"));
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//速率验证
		row=row;rowTo=row;col=col+5;colTo=col+2;
		map.put("cellValue",Map.get("RatePass"));//速率是否通过
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//时延验证		
		row=row+1;rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("TimeDelayP"));//时延是否通过
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//小区覆盖		
		row=row+1;rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("CommunityNormal"));//小区覆盖是否正常
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
//		
		row=row-2;rowTo=row;col=col+3;colTo=col;
		map.put("cellValue",Map.get("RateValueP"));//速率是否通过值
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue",Map.get("TimeDelayValueP"));//时延是否通过值
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);		
//		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue",Map.get("CommunityNormalP"));//小区覆盖是否正常值
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//空格		
		row=row-2;rowTo=row;col=col+1;colTo=col+7;
		map.put("cellValue","");
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+7;
		map.put("cellValue","");
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row+1;rowTo=row;col=col;colTo=col+7;
		map.put("cellValue","");
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		return rowTo=row+1;
	}
	/**
	 *核查测试内容
	 */
	public int auditTestContent_in(HSSFWorkbook wb,HSSFSheet sheet,List<WorkParam_inDomain> wordParamList,List<LogDomain> log,int col,int row,int colTo,int rowTo,Map map,String lang) throws Exception {
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		row=row+1;  col=0; colTo=20;rowTo=row;
		Map<String, BorderLineStyle> mapBorder = new HashMap<String, BorderLineStyle>();
		map.put("backgroundColour", HSSFColor.SKY_BLUE.index);map.put("fontSize",(short) 10);map.put("fontName", "宋体");
		map.put("cellValue",Map.get("TestContent"));map.put("rowHeight",(short)300);
		map.put("borderBottom",HSSFCellStyle.BORDER_THIN);map.put("borderTop",HSSFCellStyle.BORDER_THICK);
		map.put("borderBottom",HSSFCellStyle.BORDER_THIN);
		 
		map.put("col", col);map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		//NO.1确认被测站点的基本物理配置是否和规划配置一致
		row = no_1Info_in(wb,sheet, wordParamList, log, col, row, colTo, rowTo, mapBorder,lang);
		//NO.2基本配置参数检查
        row = no_2Info_in(wb,sheet,wordParamList, col, row, colTo, rowTo, map,lang);
		//NO.3连接模式下基本业务功能检查（测试点导频质量要求：RS_RSRP>-100dBm）
		
        row = no_3Info_in(wb,sheet,log, col, row, colTo, rowTo, map,lang);
		
		return rowTo;
	}
	/**
	 * NO.1
	 */
	public int no_1Info_in(HSSFWorkbook wb,HSSFSheet sheet,List<WorkParam_inDomain> wordParamList,List<LogDomain> log,int col,int row,int colTo,int rowTo,Map map,String lang) throws Exception {
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		Map<String, BorderLineStyle> mapBorder = new HashMap<String, BorderLineStyle>();
		String stationHight = wordParamList.get(0).getWp_station_height();              //站高
		String longitude = wordParamList.get(0).getWp_station_longitude();              //经度
		String latitude = wordParamList.get(0).getWp_station_latitude();                //纬度
		String workModel1  = wordParamList.get(0).getWp_cell_workModel();                //方位角
		String workModel2  = wordParamList.get(1).getWp_cell_workModel();                //方位角
		String workModel3  = wordParamList.get(2).getWp_cell_workModel();                //方位角
		row=row+1; rowTo=row;col=0;colTo=col;
		map.put("backgroundColour", null);
		map.put("cellValue","NO.1");map.put("col", col);map.put("LRAlignment", false);map.put("TBAlignment",false);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		//开map.put("borderBottom",HSSFCellStyle.BORDER_THIN);
		map.put("borderRight",HSSFCellStyle.BORDER_THIN);
		 
		ExcelPoiUtil.createCell(wb, sheet, map);
//确认被测站点的基本物理配置是否和规划配置一致		
		row=row; rowTo=row;col=col+1;colTo=20;
		map.put("cellValue",Map.get("MeasuredSite"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//NB站点		
		row=row+1; rowTo=row+7;col=col-1;colTo=col;
		map.put("cellValue",Map.get("NBSite"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//检测项		
		row=row; rowTo=row+1;col=col+1;colTo=col+2;map.put("LRAlignment", true);map.put("TBAlignment",true);
		map.put("cellValue",Map.get("DetectionItem"));map.put("col", col);map.put("fontWeight",null);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
     	ExcelPoiUtil.createCell(wb, sheet, map);
//站高
		row=row+2; rowTo=row;col=col;colTo=col+2;
		
		map.put("backgroundColour", HSSFColor.YELLOW.index);
		map.put("fontColour",HSSFColor.RED.index);
		map.put("cellValue",Map.get("StationHigh"));map.put("col", col);map.put("LRAlignment", false);map.put("TBAlignment",false);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//经度	
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("Longitude"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//维度	
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("Dimension"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//天线型号		
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("AntennaModel"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//天线类型		
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("AntennaType"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//是否是否共天馈		
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("AntennaFeeder"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//U900站点
		row=row+1; rowTo=row+2;col=col-1;colTo=col;
		map.put("backgroundColour", null);map.put("fontWeight",(short)1000);
		map.put("fontColour",null);
		map.put("cellValue",Map.get("U900Site"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//方位角 
		row=row; rowTo=row;col=col+1;colTo=col+2;
		map.put("fontWeight",null);map.put("backgroundColour", HSSFColor.YELLOW.index);
		map.put("fontColour",HSSFColor.RED.index);
		map.put("cellValue",Map.get("Azimuth"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//物理倾角		
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("PhysicalDip"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		row=row+1; rowTo=row;col=col;colTo=col+2;
		ExcelPoiUtil.createCell(wb, sheet, map);
//电子倾角
		
		map.put("cellValue",Map.get("ElectronicTiltAngle"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//设计值
		row=13;rowTo=row;col=4;colTo=col+2;
		map.put("backgroundColour", null);map.put("fontColour", null);map.put("LRAlignment", true);map.put("TBAlignment",true);
		map.put("cellValue",Map.get("DesignValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S1		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("fontWeight",(short)1000);
		map.put("cellValue","S1");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","S2");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3	
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("columnWidth", 3000);
		map.put("cellValue","S3");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
//站高值 
		row=row+1;rowTo=row;col=4;colTo=col;
		map.put("fontWeight",null);map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//经度值
		row=row+1;rowTo=row;col=4;colTo=col+2;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//纬度值		
		row=row+1;rowTo=row;col=col;colTo=col+2;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//天线型号值
		row=row+1;rowTo=row;col=col;colTo=col+2;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//天线类型值
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//是否共天馈（如果是请填写和W/G共天馈）值		
		
		row=row+1;rowTo=row;col=4;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//方位角值
		row=row+1;rowTo=row;col=4;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//物理倾角值		
		row=row+1;rowTo=row;col=4;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//电子倾角值	
		row=row+1;rowTo=row;col=4;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//实测值
		row=13;rowTo=row;col=7;colTo=col+2;
		map.put("backgroundColour", null);
		map.put("cellValue",Map.get("MeasuredValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S1    
		row=row+1;rowTo=row;col=7;colTo=col;
		map.put("fontWeight",(short)1000);
		map.put("cellValue","S1");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","S1");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","S3");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//站高值
		row=row+1;rowTo=row;col=7;colTo=col;
		map.put("fontWeight",null);map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",stationHight);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue",stationHight);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue",stationHight);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//经度值   
		row=row+1;rowTo=row;col=7;colTo=col+2;
		map.put("cellValue",longitude);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//纬度值  
		row=row+1;rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",latitude);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//天线型号值
		row=row+1;rowTo=row;col=col;colTo=col+2;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//天线类型值
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//是否共天馈（如果是请填写和W/G共天馈）		
		row=row+1;rowTo=row;col=7;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//方位角值		
		row=row+1;rowTo=row;col=7;colTo=col;
		map.put("cellValue",workModel1);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue",workModel2);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue",workModel3);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
//物理倾角值		
		row=row+1;rowTo=row;col=7;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//电子倾角值		
		row=row+1;rowTo=row;col=7;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//结论		
		row=13;rowTo=row+1;col=col+1;colTo=col;
		map.put("backgroundColour",null);
		map.put("cellValue",Map.get("Conclusion"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//1结论站高			
		row=row+2;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//2结论经度		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//3结论纬度		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//4结论天线型号	
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//5结论天线类型
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//6结论是否共天馈（如果是请填写和W/G共天馈）		
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//7结论方位角
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//8结论物理倾角
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//9结论电子倾角
		row=row+1;rowTo=row;col=col;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//备注     
		row=13; rowTo=row+1; col=col+1;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//站高备注		
		row=row+2; rowTo=row; col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//经度备注		
		row=row+1; rowTo=row; col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);		
//纬度备注
		row=row+1; rowTo=row; col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//天线类型备注
		row=row+1; rowTo=row; col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);		
//天线型号备注	
		row=row+1; rowTo=row; col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);	
//是否共天馈备注
		row=row+1; rowTo=row; col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);	
//方位角备注
		row=row+1; rowTo=row; col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);	
//物理倾角备注	
		row=row+1; rowTo=row; col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);	
//电子倾角备注	
		row=row+1; rowTo=row; col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);	
		return rowTo;
	}
	/**
	 * NO.2
	 */
	public int no_2Info_in(HSSFWorkbook wb,HSSFSheet sheet,List<WorkParam_inDomain> workParamList,int col,int row,int colTo,int rowTo,Map map,String lang) throws Exception {
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		
		Map<String, BorderLineStyle> mapBorder = new HashMap<String, BorderLineStyle>();
//NO.2	
		String PCI1 = workParamList.get(0).getWp_cell_PCI();       //PCI
		String PCI2 = workParamList.get(1).getWp_cell_PCI();
		String PCI3 = workParamList.get(2).getWp_cell_PCI(); 
		String BW = "";										       //BW
		String cellId1 = workParamList.get(0).getWp_cell_section();//小区号
		String cellId2 = workParamList.get(1).getWp_cell_section();
		String cellId3 = workParamList.get(3).getWp_cell_section();
		
		String eNBID   = workParamList.get(0).getWp_station_ENBID();//eNBID
		String TAC = workParamList.get(0).getWp_station_TAC();      //TAC
		
		String result = "";
		row=row+1; rowTo=row;col=0;colTo=col; 
		map.put("fontWeight",(short)1000);map.put("backgroundColour",null);
		map.put("cellValue","NO.2");map.put("col", col);map.put("LRAlignment", false);map.put("TBAlignment",false);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		map.put("borderBottom",HSSFCellStyle.BORDER_THIN);map.put("borderRight",HSSFCellStyle.BORDER_THIN);				
		map.put("borderTop",HSSFCellStyle.BORDER_THIN);
		ExcelPoiUtil.createCell(wb, sheet, map);
//配置参数检查		
		row=row; rowTo=row;col=col+1;colTo=20;
		map.put("cellValue",Map.get("ConParameterCheck"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
//空格
		row=row+1; rowTo=row+8;col=0;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//检查项		
		row=25; rowTo=row+1;col=col+1;colTo=col+2;
		map.put("fontWeight",null);map.put("LRAlignment", true);map.put("TBAlignment",true);
		map.put("cellValue",Map.get("InspectionItem"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//PCI		
		row=row+2; rowTo=row;col=col;colTo=col+2;
		map.put("fontWeight",null);map.put("LRAlignment", true);map.put("TBAlignment",true);
		map.put("cellValue","PCI");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//频点		
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("Frequency"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//BW	
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue","BW");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//CELL ID		
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue","CELL ID");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//eNBID	
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue","eNBID");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//归属TAC		
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("OwnershipTAC"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//逻辑小区检查		
		row=row+1; rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("LogicalCell"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//设计值
		row=25; rowTo=row; col=colTo+1;colTo=col+2;
		map.put("cellValue",Map.get("DesignValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S1		
		row=row+1; rowTo=row; col=col;colTo=col;
		map.put("fontWeight",(short)1000);
		map.put("cellValue","S1");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue","S2");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue","S3");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//PCI值		
		row=row+1; rowTo=row; col=4;colTo=col;
		map.put("fontWeight",null);map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",Map.get("PCIValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",Map.get("PCIValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",Map.get("PCIValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
//频点值		
		row=row+1; rowTo=row; col=4;colTo=col;
		map.put("cellValue",Map.get("FrequencyValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",Map.get("FrequencyValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",Map.get("FrequencyValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//BW值		
		row=row+1; rowTo=row; col=4;colTo=col;
		map.put("cellValue",Map.get("BWValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",Map.get("BWValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",Map.get("BWValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//CELL ID值		
		row=row+1; rowTo=row; col=4;colTo=col;
		map.put("cellValue",Map.get("CELLIDValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",Map.get("CELLIDValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row; rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",Map.get("CELLIDValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//eNBID值
		row=row+1; rowTo=row; col=4;colTo=col+2;
		map.put("cellValue",Map.get("eNBIDValue"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//归属TAC值
		row=row+1; rowTo=row; col=4;colTo=col+2;
		map.put("cellValue",Map.get("OwnershipTACValues"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//逻辑小区检查
		//S1
		row=row+1; rowTo=row; col=4;colTo=col+1;
//		if(){
//			map.put("fontColour",HSSFColor.RED.index);
//		};
		map.put("cellValue","S1");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		//S2
		row=row; rowTo=row; col=col+2;colTo=col+1;
////		if(){
////			map.put("fontColour",HSSFColor.RED.index);
////		};
		map.put("cellValue","S2");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
    	ExcelPoiUtil.createCell(wb, sheet, map);
	   //S3
		row=row; rowTo=row; col=col+2;colTo=col+1;
//		if(){
//			map.put("fontColour",HSSFColor.RED.index);
//		};
		map.put("cellValue","S3");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//实测值	
		row=25; rowTo=row; col=7;colTo=col+2;
		map.put("backgroundColour", null);
		map.put("cellValue","MeasuredValue");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S1		
		row=row+1;rowTo=row; col=7;colTo=col;
		map.put("fontWeight",(short)1000);
		map.put("cellValue","S1");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue","S1");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3		
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue","S1");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//PCI实测值		
		row=row+1;rowTo=row; col=7;colTo=col;
		map.put("fontWeight",null);map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",PCI1);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",PCI2);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",PCI3);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//频点实测值		
		row=row+1;rowTo=row; col=7;colTo=col;
		map.put("fontWeight",null);map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//BW实测值		
		row=row+1;rowTo=row; col=7;colTo=col;
		map.put("fontWeight",null);map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",BW);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",BW);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",BW);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//CELL ID实测值		
		row=row+1;rowTo=row; col=7;colTo=col;
		map.put("fontWeight",null);map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",cellId1);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",cellId2);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row; col=col+1;colTo=col;
		map.put("cellValue",cellId3);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//eNBID实测值
		row=row+1;rowTo=row; col=7;colTo=col+2;
		map.put("cellValue",eNBID);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//归属TAC实测值
		row=row+1;rowTo=row; col=7;colTo=col+2;
		map.put("cellValue",TAC);map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//结论
		row=25;rowTo=row+1; col=10;colTo=col;
		map.put("cellValue",Map.get("Conclusion"));map.put("col", col);map.put("backgroundColour", null);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//PIC结论
		row=row+2;rowTo=row; col=col; colTo=col;
		map.put("cellValue",Map.get("PICConclusion"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//频点结论
		row=row+1;rowTo=row; col=col; colTo=col;
		map.put("cellValue",Map.get("FrequencyConclusion"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//BW结论
		row=row+1;rowTo=row; col=col; colTo=col;
		map.put("cellValue",Map.get("BWConclusion"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//CELL ID结论
		row=row+1;rowTo=row; col=col; colTo=col;
		map.put("cellValue",Map.get("CELLIDConclusion"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//eNB ID结论
		row=row+1;rowTo=row; col=col; colTo=col;
		map.put("cellValue",Map.get("eNBIDConclusion"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//归属TAC结论
		row=row+1;rowTo=row; col=col; colTo=col;
		map.put("cellValue",Map.get("OwnershipTACConclusion"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//备注
		row=25;rowTo=row+1;col=col+1;colTo=20;
		map.put("cellValue",Map.get("Note"));map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//		
		row=row+2;rowTo=row+1;col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//1		
		row=row+2;rowTo=row;col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//2		
		row=row+1;rowTo=row;col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//3
		row=row+1;rowTo=row;col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//4
		row=row+1;rowTo=row;col=col;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//5
		row=row+1;rowTo=row;col=col-1;colTo=20;
		map.put("cellValue","");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		
		
		return rowTo;
		

	}
	/**
	 * NO.3
	 */
	public int no_3Info_in(HSSFWorkbook wb,HSSFSheet sheet,List<LogDomain> logList,int col,int row,int colTo,int rowTo,Map map,String lang) throws Exception {
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		String RSRP1 = logList.get(0).getLog_RSRP();             //RSRP1															 //
		String RSRP2 = logList.get(1).getLog_RSRP();			 //RSRP2
		String RSRP3 = logList.get(2).getLog_RSRP();             //RSRP3
		
		String SINR1 = logList.get(0).getLog_SINR();             //SINR1															 //
		String SINR2 = logList.get(1).getLog_SINR();			 //SINR2
		String SINR3 = logList.get(2).getLog_SINR();             //SINR3
		
		String log_top_rate1 = logList.get(0).getLog_UDPTop_rate();  //上行速率 1 
		String log_top_rate2 = logList.get(1).getLog_UDPTop_rate();  //上行速率 2 
		String log_top_rate3 = logList.get(2).getLog_UDPTop_rate();  //上行速率 3 
		
		String log_delayTime1 = logList.get(0).getLog_delayTime(); //ping时延1
		String log_delayTime2 = logList.get(1).getLog_delayTime(); //ping时延2
		String log_delayTime3 = logList.get(2).getLog_delayTime(); //ping时延3
		
		String log_openRate1   = logList.get(0).getLog_openRate();  //接通率1
		String log_openRate2   = logList.get(1).getLog_openRate();  //接通率2
		String log_openRate3   = logList.get(2).getLog_openRate();  //接通率3
		Map<String, BorderLineStyle> mapBorder = new HashMap<String, BorderLineStyle>();
//NO.3			
		row=row+1;rowTo=row;col=0;colTo=col;
		map.put("fontWeight",(short)1000);map.put("LRAlignment", false);map.put("TBAlignment",false);
		map.put("cellValue","NO.3");map.put("col", col);
		map.put("row", row);map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//连接模式下基本业务功能检查(测试点导频质量要求：RS_RSRP>-100dBm )
		row=row;rowTo=row;col=col+1;colTo=20;
		map.put("cellValue",Map.get("FunctionCheck"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//TM3 alternative		
		row=row+1;rowTo=row+11;col=0;colTo=col;
		map.put("cellValue","TM3 alternative");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//小区信		
		row=35;rowTo=row+1;col=col+1;colTo=col+2;
		map.put("cellValue",Map.get("CellLetter"));map.put("fontWeight",null);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//检测项		
		row=row+2;rowTo=row+2;col=col;colTo=col+2;
		map.put("cellValue",Map.get("DetectionItem"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//100bytes上行速率(kbps)		
		row=row+3;rowTo=row;col=col;colTo=col+2;
		map.put("LRAlignment", true);map.put("TBAlignment",true);
		map.put("cellValue",Map.get("UplinkRate"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//时延(s)		
		row=row+1;rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("TimeDelay"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//接通率		
		row=row+1;rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("ConnectionRate"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//掉话率		
		row=row+1;rowTo=row;col=col;colTo=col+2;
		map.put("cellValue",Map.get("DropRate"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//小区信息		
		row=row+1;rowTo=row;col=col;colTo=20;
		map.put("backgroundColour", HSSFColor.SKY_BLUE.index);
		map.put("cellValue",Map.get("CellIn"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//单站异常情况		
		row=row+1;rowTo=row;col=col;colTo=col+3;
		//map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",Map.get("SingleStationAnomaly"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//相关Log文件		
		row=row+1;rowTo=row;col=col;colTo=col+3;
		map.put("backgroundColour", null);
		map.put("cellValue",Map.get("RelatedLogFiles"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S1测试点导频信号质量(RSRP&SINR)		
		row=35;rowTo=row;col=4;colTo=col+5;
		map.put("cellValue",Map.get("S1PilotSignalQuality"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//RSRP		
		row=row+1;rowTo=row;col=4;colTo=col+2;
		map.put("cellValue","RSRP");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//SINR 		
		row=row;rowTo=row;col=col+3;colTo=col+2;
		map.put("cellValue","SINR ");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

//S1RSRP值		
		row=row+1;rowTo=row+1;col=4;colTo=col+2;
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",RSRP1);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S1SINR值 		
		row=row;rowTo=row+1;col=col+3;colTo=col+2;
		map.put("cellValue",SINR1);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S1		
		row=row+2;rowTo=row;col=4;colTo=col+5;
		map.put("backgroundColour", null);
		map.put("cellValue","S1");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//100bytes上行速率(kbps)值		
		row=row+1;rowTo=row;col=4;colTo=col+5;
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",log_top_rate1);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//时延(s)值		
		row=row+1;rowTo=row;col=4;colTo=col+5;
		map.put("cellValue",log_delayTime1);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//接通率值		
		row=row+1;rowTo=row;col=4;colTo=col+5;
		map.put("cellValue",log_openRate1);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//掉话率值		
		row=row+1;rowTo=row;col=4;colTo=col+5;
		map.put("cellValue","");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2测试点导频信号质量(RSRP&SINR)		
		row=35;rowTo=row;col=col+6;colTo=col+5;
		map.put("backgroundColour", null);
		map.put("cellValue","S2PilotSignalQuality");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2RSRP		
		row=row+1;rowTo=row;col=10;colTo=col+2;
		map.put("backgroundColour", null);
		map.put("cellValue","RSRP");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2SINR 		
		row=row;rowTo=row;col=col+3;colTo=col+2;
		map.put("cellValue","SINR ");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2RSRP值		
		row=row+1;rowTo=row+1;col=10;colTo=col+2;
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",RSRP2);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2SINR值		
		row=row;rowTo=row+1;col=col+3;colTo=col+2;
		map.put("cellValue",SINR2);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2		
		row=row+2;rowTo=row;col=10;colTo=col+5;
		map.put("backgroundColour", null);
		map.put("cellValue","S2");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2100bytes上行速率(kbps)值
		row=row+1;rowTo=row;col=10;colTo=col+5;
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",log_top_rate1);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2时延(s)值
		row=row+1;rowTo=row;col=10;colTo=col+5;
		map.put("cellValue",log_delayTime2);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2接通率值
		row=row+1;rowTo=row;col=10;colTo=col+5;
		map.put("cellValue",log_openRate2);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S2掉话率值
		row=row+1;rowTo=row;col=10;colTo=col+5;
		map.put("cellValue","");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3测试点导频信号质量(RSRP&SINR)		
		row=35;rowTo=row;col=col+6;colTo=col+4;
		map.put("backgroundColour",null);
		map.put("cellValue",Map.get("S3PilotSignalQuality"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3RSRP	
		row=row+1;rowTo=row;col=16;colTo=col+2;
		map.put("cellValue","RSRP");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3SINR 	
		row=row;rowTo=row;col=col+3;colTo=col+1;
		map.put("cellValue","SINR ");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3RSRP值 	
		row=row+1;rowTo=row+1;col=16;colTo=col+2;
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",RSRP3);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3SINR值 	
		row=row;rowTo=row+1;col=col+3;colTo=col+1;
		map.put("cellValue",SINR3);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3 	
		row=row+2;rowTo=row;col=16;colTo=20;
		map.put("backgroundColour",null);
		map.put("cellValue","S3");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3100bytes上行速率(kbps)值 	
		row=row+1;rowTo=row;col=16;colTo=20;
		map.put("backgroundColour", HSSFColor.GREEN.index);
		map.put("cellValue",log_top_rate3);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3时延(s)值 	
		row=row+1;rowTo=row;col=16;colTo=20;	
		map.put("cellValue",log_delayTime3);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3接通率值 	
		row=row+1;rowTo=row;col=16;colTo=20;	
		map.put("cellValue",log_openRate3);
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//S3掉话率值 	
		row=row+1;rowTo=row;col=16;colTo=20;	
		map.put("cellValue","");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//备注	
		row=45;rowTo=row;col=5;colTo=col+1;
		map.put("cellValue",Map.get("Note"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//备注值	
		row=row;rowTo=row;col=col+2;colTo=20;
		//map.put("backgroundColour", null);
		map.put("backgroundColour", HSSFColor.YELLOW.index);
		map.put("cellValue",Map.get("Note"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//备注	
		row=row+1;rowTo=row;col=5;colTo=col+1;
		map.put("backgroundColour", null);
		map.put("cellValue",Map.get("Note"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//备注值	
		row=row;rowTo=row;col=col+2;colTo=20;
		map.put("backgroundColour", null);
		map.put("cellValue",Map.get("NoteValue"));
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//末尾
		row=row+1;rowTo=row;col=0;colTo=col;
		map.put("cellValue","");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		row=row;rowTo=row;col=col+1;colTo=20;
		map.put("cellValue","");
		map.put("col", col);map.put("row", row);
		map.put("colTo", colTo);map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		return rowTo;
	}


	
}
