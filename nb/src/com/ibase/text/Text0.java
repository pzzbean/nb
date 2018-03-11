package com.ibase.text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.ibase.web.log.domain.LogDomain;
import com.ibase.web.plane.domain.Plane;
import com.ibase.web.workparam.domain.WorkParamDomain;
import com.ibase.web.workparam_in.domain.WorkParam_inDomain;

import freemarker.template.Configuration;
import freemarker.template.Template;
import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import sun.misc.BASE64Encoder;

public class Text0 {
	public static void main(String[] args) {
		System.out.println("-----main start------");
		new HelloB();
		new HelloB();
		System.out.println("-------main end------");
	}
	@Test
	public void text()throws Exception {
		
		String filePath = "d:\\单验报告.xls";
		OutputStream os = new FileOutputStream(filePath);
		
		Plane plane = new Plane();
		plane.setPlan_test_engineer("杜鹏程");
		plane.setPlan_te_phone("13800138000");
		plane.setPlan_back_engineer("宛少文");
		plane.setPlan_be_phone("13800138000");
		plane.setPlane_test_content("F03624");
		plane.setPlane_test_time("2017-9-20");
		
		WorkParam_inDomain wordParam1 = new WorkParam_inDomain();
		wordParam1.setWp_station_no("F03624");
		wordParam1.setWp_station_height("40");
		wordParam1.setWp_station_longitude("121.18692");
		wordParam1.setWp_station_latitude("31.03289");
		wordParam1.setWp_station_TAC("6528");
		wordParam1.setWp_station_ENBID("952166");
		wordParam1.setWp_cell_section("1");
		wordParam1.setWp_cell_ECI("ECI:243481621");
		wordParam1.setWp_cell_PCI("63");
		wordParam1.setWp_cell_workModel("In-band");
		wordParam1.setWp_cell_bearing("0");
		wordParam1.setWp_cell_dipAangle("6");
		wordParam1.setWp_cell_top_frequency("21752");
		wordParam1.setWp_cell_top_bandwidth("0.2MHz");
		wordParam1.setWp_cell_down_frequency("3752");
		wordParam1.setWp_cell_down_bandwidth("0.2MHz");
		
		WorkParam_inDomain wordParam2 = new WorkParam_inDomain();
		wordParam2.setWp_station_no("F03624");
		wordParam2.setWp_station_height("40");
		wordParam2.setWp_station_longitude("121.18692");
		wordParam2.setWp_station_latitude("31.03289");
		wordParam2.setWp_station_TAC("6528");
		wordParam2.setWp_station_ENBID("952166");
		wordParam2.setWp_cell_section("2");
		wordParam2.setWp_cell_ECI("ECI:243481621");
		wordParam2.setWp_cell_PCI("63");
		wordParam2.setWp_cell_workModel("In-band");
		wordParam2.setWp_cell_bearing("0");
		wordParam2.setWp_cell_dipAangle("6");
		wordParam2.setWp_cell_top_frequency("21752");
		wordParam2.setWp_cell_top_bandwidth("0.2MHz");
		wordParam2.setWp_cell_down_frequency("3752");
		wordParam2.setWp_cell_down_bandwidth("0.2MHz");
		
		WorkParam_inDomain wordParam3 = new WorkParam_inDomain();
		wordParam3.setWp_station_no("F03624");
		wordParam3.setWp_station_height("40");
		wordParam3.setWp_station_longitude("121.18692");
		wordParam3.setWp_station_latitude("31.03289");
		wordParam3.setWp_station_TAC("6528");
		wordParam3.setWp_station_ENBID("952166");
		wordParam3.setWp_cell_section("3");
		wordParam3.setWp_cell_ECI("ECI:243481621");
		wordParam3.setWp_cell_PCI("63");
		wordParam3.setWp_cell_workModel("In-band");
		wordParam3.setWp_cell_bearing("0");
		wordParam3.setWp_cell_dipAangle("6");
		wordParam3.setWp_cell_top_frequency("21752");
		wordParam3.setWp_cell_top_bandwidth("0.2MHz");
		wordParam3.setWp_cell_down_frequency("3752");
		wordParam3.setWp_cell_down_bandwidth("0.2MHz");
		
		List<WorkParam_inDomain> wordParamList = new ArrayList<WorkParam_inDomain>();
		wordParamList.add(wordParam1);
		wordParamList.add(wordParam2);
		wordParamList.add(wordParam3);
		
		LogDomain log = new LogDomain();
		log.setPlane_id(1);
		log.setStation_no("F03624");
		log.setCell_section("1");
		log.setLog_RSRP("-83");
		log.setLog_SINR("6.6");
		log.setLog_iperfTop_rate("5.89Kbps");
		log.setLog_iperfDown_rate("10.09Kbps");
		log.setLog_delayTime("619");
		log.setLog_openRate("100%");
		log.setStatus(1);
		log.setCell_section("1");
		
		LogDomain log2 = new LogDomain();
		log2.setPlane_id(1);
		log2.setStation_no("F03624");
		log2.setCell_section("1");
		log2.setLog_RSRP("-83");
		log2.setLog_SINR("6.6");
		log2.setLog_iperfTop_rate("5.89Kbps");
		log2.setLog_iperfDown_rate("10.09Kbps");
		log2.setLog_delayTime("619");
		log2.setLog_openRate("100%");
		log2.setStatus(1);
		log2.setCell_section("2");
		
		LogDomain log3 = new LogDomain();
		log3.setPlane_id(1);
		log3.setStation_no("F03624");
		log3.setCell_section("1");
		log3.setLog_RSRP("-83");
		log3.setLog_SINR("6.6");
		log3.setLog_iperfTop_rate("5.89Kbps");
		log3.setLog_iperfDown_rate("10.09Kbps");
		log3.setLog_delayTime("619");
		log3.setLog_openRate("100%");
		log3.setStatus(1);
		log3.setCell_section("3");
		
		List<LogDomain> logList = new ArrayList<LogDomain>();
		logList.add(log);
		logList.add(log2);
		logList.add(log3);
		
		createExcel2(os,plane,wordParamList,logList);
	}

	public void createExcel2(OutputStream out,Plane plane,List<WorkParam_inDomain> wordParam,List<LogDomain> log) throws Exception{
		// 创建Excel工作薄 
		WritableWorkbook wwb = Workbook.createWorkbook(out);
		//创建一个sheet（可以创建多个sheet,一个工作薄可以有多个sheet
		WritableSheet sheet0 = wwb.createSheet("单验报告", 0);
		WritableSheet sheet1 = wwb.createSheet("单验报告1", 1);
		
		WritableFont wfont = new WritableFont(WritableFont.createFont("楷书"),11);//设置字体、大小
		WritableCellFormat wcf = new WritableCellFormat(wfont);
		
		createExcelSubclass1(wfont,wcf,sheet0,plane,wordParam,log);
		
		Text1 text1 = new Text1();
		//添加最上方的标题
		text1.addHeadSheet2(sheet1,log.get(0));
		//添加标题下面的基本信息
		text1.addBaseInfo(sheet1,log.get(0),plane);
		text1.addBlankCell(sheet1);
		//添加下方第一个表格
		text1.addTable1Info(sheet1,log.get(0),plane);
		//添加下方第二个表格
		text1.addTable2Info(sheet1,log.get(0),plane);
		text1.setColumnView(sheet1);

		// 写入数据 
		wwb.write(); 
		// 关闭文件 
		wwb.close();
		
	}
	
	public void createExcelSubclass1(WritableFont wfont,WritableCellFormat wcf,WritableSheet sheet,Plane plane,List<WorkParam_inDomain> wordParam_in,List<LogDomain> logList) throws Exception{
		Map map = new HashMap();
		Map<String, BorderLineStyle> mapBorder = new HashMap<String, BorderLineStyle>();
		
		int col = 0;//列 
		int row=0;//行
		int col_=14;
		int row_=0;
		
		col=0;row=row;col_=14;row_=row;
		map.put("value","NB-IOT单站点验证报告");map.put("bold", true);map.put("fontSize", 20);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.THIN);mapBorder.put("right", BorderLineStyle.THIN);
		mapBorder.put("bottom", BorderLineStyle.THIN);mapBorder.put("left", BorderLineStyle.THIN);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", 1300);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=0;row=row+1;col_=18;row_=row;
		map.put("value","");map.put("rowHeight", 200);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//基站描述
		row_ = stationDesc(wfont,wcf,sheet,(WorkParam_inDomain)wordParam_in.get(0),col,row,col_,row_,map,mapBorder);
		
		//参数验证
		col=0;row=row_+1;col_=18;row_=row;
		map.put("value","参数验证");map.put("bold", true);map.put("fontSize", 14);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.THICK);mapBorder.put("right", BorderLineStyle.THICK);
		mapBorder.put("bottom", BorderLineStyle.THICK);mapBorder.put("left", BorderLineStyle.THICK);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", false);map.put("cellWidth", null);map.put("rowHeight", 400);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=0;row=row+1;col_=18;row_=row;
		map.put("value","");map.put("mapBorder",null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);		
		//基站参数
		row_ = Stationparam(wfont,wcf,sheet,(WorkParam_inDomain)wordParam_in.get(0),col,row,col_,row_,map,mapBorder);
		//小区参数（工程）
		row_ = cellParamEngineering_in( wfont, wcf, sheet,wordParam_in, col, row, col_, row_, map, mapBorder);
		//小区参数（网优）
		row_ = cellParamNetwork_in( wfont, wcf, sheet,wordParam_in, col, row, col_, row_, map, mapBorder);
		
		//功能验证
		col=0;row=row_+1;col_=18;row_=row;
		map.put("value","功能验证");map.put("bold", true);map.put("fontSize", 14);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.THICK);mapBorder.put("right", BorderLineStyle.THICK);
		mapBorder.put("bottom", BorderLineStyle.THICK);mapBorder.put("left", BorderLineStyle.THICK);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", false);map.put("cellWidth", null);map.put("rowHeight", 400);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//业务验证
		row_ = BusinessVerification( wfont, wcf, sheet,logList, col, row, col_, row_, map, mapBorder);
		//验证结论
		row_ = VerificationConclusion( wfont, wcf, sheet,logList, col, row_, col_, row_, map, mapBorder);
		//工程师类型
		row_ = EngineerDesc( wfont, wcf, sheet,plane, col, row_, col_, row_, map, mapBorder);
	
	}
	
	/**
	 * 基站描述
	 * 返回row_
	 */
	public int stationDesc(WritableFont wfont,WritableCellFormat wcf,WritableSheet sheet,Object obj,int col,int row,int col_,int row_,Map map,Map<String, BorderLineStyle> mapBorder) throws Exception{
		WorkParam_inDomain workParam_inDomain ;
		WorkParamDomain workParamDomain;
		String stationName ="";//站名
		String stationNo = null;//站号
		String date = "";//日期
		String area = "";//区县
		String address = "";//地址
		String stationType = "";//站型
		String deviceType = "";//设备类型
		
		if(obj instanceof WorkParam_inDomain){
			workParam_inDomain = (WorkParam_inDomain)obj;
			stationNo = workParam_inDomain.getWp_station_no();
		}
		if(obj instanceof WorkParamDomain){
			workParamDomain = (WorkParamDomain)obj;
			stationNo = workParamDomain.getWp_station_no();
		}
			
		col=0;row=row+1;col_=18;row_=row;
		map.put("value","基站描述");map.put("bold", true);map.put("fontSize", 14);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.THICK);mapBorder.put("right", BorderLineStyle.THICK);
		mapBorder.put("bottom", BorderLineStyle.THICK);mapBorder.put("left", BorderLineStyle.THICK);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", false);map.put("cellWidth", null);map.put("rowHeight", 400);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=0;row=row+1;col_=18;row_=row;
		map.put("value","");map.put("mapBorder",null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=0;row=row_+1;col_=0;row_=row+6;
		map.put("value","");map.put("mapBorder",null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=1;row=row;col_=col;row_=row;
		map.put("value","站名：");map.put("bold", false);map.put("fontSize", 14);map.put("fontType", "楷书");
		mapBorder.put("top", null);mapBorder.put("right", null);
		mapBorder.put("bottom", null);mapBorder.put("left",null);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);		
		//站名
		col=col_+1;row=row;col_=col+3;row_=row;
		map.put("value",stationName);map.put("bold", false);map.put("fontSize", 14);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.DOTTED);mapBorder.put("right", BorderLineStyle.DOTTED);
		mapBorder.put("bottom", BorderLineStyle.DOTTED);mapBorder.put("left",BorderLineStyle.DOTTED);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col_+1;row=row;col_=col+2;row_=row;
		map.put("value","");map.put("mapBorder",null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","日期:");map.put("bold", false);map.put("fontSize", 14);map.put("fontType", "楷书");
		mapBorder.put("top", null);mapBorder.put("right", null);
		mapBorder.put("bottom", null);mapBorder.put("left",null);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);		
		//日期
		col=col_+1;row=row;col_=col+3;row_=row;
		map.put("value",date);map.put("bold", false);map.put("fontSize", 14);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.DOTTED);mapBorder.put("right", BorderLineStyle.DOTTED);
		mapBorder.put("bottom", BorderLineStyle.DOTTED);mapBorder.put("left",BorderLineStyle.DOTTED);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=1;row=row+1;col_=14;row_=row;
		map.put("value","");map.put("mapBorder",null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=1;row=row+1;col_=col;row_=row;
		map.put("value","站号：");map.put("bold", false);map.put("fontSize", 14);map.put("fontType", "楷书");
		mapBorder.put("top", null);mapBorder.put("right", null);
		mapBorder.put("bottom", null);mapBorder.put("left",null);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//站号
		col=col_+1;row=row;col_=col+3;row_=row;
		map.put("value",stationNo);map.put("bold", false);map.put("fontSize", 14);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.DOTTED);mapBorder.put("right", BorderLineStyle.DOTTED);
		mapBorder.put("bottom", BorderLineStyle.DOTTED);mapBorder.put("left",BorderLineStyle.DOTTED);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col_+1;row=row;col_=col+2;row_=row;
		map.put("value","");map.put("mapBorder",null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","区县:");map.put("bold", false);map.put("fontSize", 14);map.put("fontType", "楷书");
		mapBorder.put("top", null);mapBorder.put("right", null);
		mapBorder.put("bottom", null);mapBorder.put("left",null);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//区县
		col=col_+1;row=row;col_=col+3;row_=row;
		map.put("value",area);map.put("bold", false);map.put("fontSize", 14);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.DOTTED);mapBorder.put("right", BorderLineStyle.DOTTED);
		mapBorder.put("bottom", BorderLineStyle.DOTTED);mapBorder.put("left",BorderLineStyle.DOTTED);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=1;row=row_+1;col_=14;row_=row;
		map.put("value","");map.put("mapBorder",null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=1;row=row+1;col_=col;row_=row;
		map.put("value","地址:");map.put("bold", false);map.put("fontSize", 14);map.put("fontType", "楷书");
		mapBorder.put("top", null);mapBorder.put("right", null);
		mapBorder.put("bottom", null);mapBorder.put("left",null);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//地址
		col=col_+1;row=row_;col_=col+5;row_=row;
		map.put("value",address);map.put("bold", false);map.put("fontSize", 14);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.DOTTED);mapBorder.put("right", BorderLineStyle.DOTTED);
		mapBorder.put("bottom", BorderLineStyle.DOTTED);mapBorder.put("left",BorderLineStyle.DOTTED);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col_+2;row=row_;col_=col;row_=row;
		map.put("value","站型:");map.put("bold", false);map.put("fontSize", 14);map.put("fontType", "楷书");
		mapBorder.put("top", null);mapBorder.put("right", null);
		mapBorder.put("bottom", null);mapBorder.put("left",null);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//站型
		col=col_+1;row=row_;col_=col+3;row_=row;
		map.put("value",stationType);map.put("bold", false);map.put("fontSize", 14);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.DOTTED);mapBorder.put("right", BorderLineStyle.DOTTED);
		mapBorder.put("bottom", BorderLineStyle.DOTTED);mapBorder.put("left",BorderLineStyle.DOTTED);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=1;row=row_+1;col_=14;row_=row;
		map.put("value","");map.put("mapBorder",null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=1;row=row_+1;col_=col+1;row_=row;
		map.put("value","设备类型:");map.put("bold", false);map.put("fontSize", 14);map.put("fontType", "楷书");
		mapBorder.put("top", null);mapBorder.put("right", null);
		mapBorder.put("bottom", null);mapBorder.put("left",null);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", false);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//设备类型
		col=col_+1;row=row_;col_=col+3;row_=row;
		map.put("value",deviceType);map.put("bold", false);map.put("fontSize", 14);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.DOTTED);mapBorder.put("right", BorderLineStyle.DOTTED);
		mapBorder.put("bottom", BorderLineStyle.DOTTED);mapBorder.put("left",BorderLineStyle.DOTTED);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col_+1;row=row_;col_=14;row_=row;
		map.put("value","");map.put("mapBorder",null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=0;row=row_+1;col_=14;row_=row;
		map.put("value","");map.put("mapBorder",null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		return row_;
		
	}
	
	/**
	 * 基站参数
	 */
	public int Stationparam(WritableFont wfont,WritableCellFormat wcf,WritableSheet sheet,Object obj,int col,int row,int col_,int row_,Map map,Map<String, BorderLineStyle> mapBorder) throws Exception{
		WorkParam_inDomain workParam_inDomain ;
		WorkParamDomain workParamDomain;
		String longitude = "";//经度
		String longitudeStandard = "";//经度规划参数
		String latitude = "";//纬度
		String latitudeStandard = "";//纬度规划参数
		String height = "";//海拔即站高
		String heightStandard = "";//海拔规划参数
		String TAC = "";//tac
		String TACStandard = "";//tac规划参数
		String NodeBID = "";//NodeBID
		String NodeBIDStandard = "";//NodeBID规划参数
		
		if(obj instanceof WorkParam_inDomain){
			workParam_inDomain = (WorkParam_inDomain)obj;
			longitude = workParam_inDomain.getWp_station_longitude();
			latitude = workParam_inDomain.getWp_station_latitude();
			height = workParam_inDomain.getWp_station_height();
			TAC = workParam_inDomain.getWp_station_TAC();
		}
		if(obj instanceof WorkParamDomain){
			workParamDomain = (WorkParamDomain)obj;
			longitude = workParamDomain.getWp_station_longitude();
			latitude = workParamDomain.getWp_station_latitude();
			height = workParamDomain.getWp_station_height();
			TAC = workParamDomain.getWp_station_TAC();
		}
		
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","基站参数（工程）");map.put("bold", true);map.put("fontSize", 12);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.THIN);mapBorder.put("right", BorderLineStyle.THIN);
		mapBorder.put("bottom", BorderLineStyle.THIN);mapBorder.put("left", BorderLineStyle.THIN);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value","规划数据");map.put("bold", false);map.put("fontSize", 12);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.THIN);mapBorder.put("right", BorderLineStyle.THIN);
		mapBorder.put("bottom", BorderLineStyle.THIN);mapBorder.put("left", BorderLineStyle.THIN);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value","实测数据");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value","验证通过");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col_+1;row=row_;col_=18;row_=row;
		map.put("value","备注");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//经度
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","经度");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//经度 	规划数据
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value",longitudeStandard);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//经度	实测数据
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value",longitude);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//经度	验证是否通过
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value","");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//经度	备注
		col=col_+1;row=row_;col_=col+9;row_=row;
		map.put("value","");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//纬度
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","纬度");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//纬度 	规划数据
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value",latitudeStandard);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//纬度	实测数据
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value",latitude);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//纬度	验证是否通过
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value","");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//纬度 	备注
		col=col_+1;row=row_;col_=col+9;row_=row;
		map.put("value","");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//海拔
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","海拔（m）");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//海拔 	规划数据
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value",heightStandard);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//海拔	实测数据
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value",height);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//海拔	验证是否通过
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value","");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//海拔 	备注
		col=col_+1;row=row_;col_=col+9;row_=row;
		map.put("value","");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//TAC
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","TAC");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//TAC 	规划数据
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value",TACStandard);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//TAC	实测数据
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value",TAC);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//TAC	验证是否通过
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value","");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//TAC 	备注
		col=col_+1;row=row_;col_=col+9;row_=row;
		map.put("value","");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//NodeBID
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","NodeBID");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//NodeBID 	规划数据
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value",NodeBIDStandard);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//NodeBID	实测数据
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value",NodeBID);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//NodeBID	验证是否通过
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value","");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//NodeBID 	备注
		col=col_+1;row=row_;col_=col+9;row_=row;
		map.put("value","");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=0;row=row_+1;col_=col+18;row_=row+1;
		map.put("value","");map.put("mapBorder",null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		return row_;
	}
	
	/**
	 * 小区参数（工程）workParm_in
	 */
	public int cellParamEngineering_in(WritableFont wfont,WritableCellFormat wcf,WritableSheet sheet,List<WorkParam_inDomain> workParam_inList,int col,int row,int col_,int row_,Map map,Map<String, BorderLineStyle> mapBorder) throws Exception{
		
		col=0;row=row_+1;col_=col+2;row_=row+1;
		map.put("value","小区参数(工程)");map.put("bold", true);map.put("fontSize", 12);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.THIN);mapBorder.put("right", BorderLineStyle.THIN);
		mapBorder.put("bottom", BorderLineStyle.THIN);mapBorder.put("left", BorderLineStyle.THIN);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区名1
		col=col_+1;row=row;col_=col+2;row_=row;
		map.put("value","小区名1");map.put("bold", false);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col;row=row+1;col_=col;row_=row;
		map.put("value","规划数据");map.put("fontSize", 10);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","实测数据");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","结果");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区名2
		col=col_+1;row=row-1;col_=col+2;row_=row;
		map.put("value","小区名2");map.put("bold", false);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col;row=row+1;col_=col;row_=row;
		map.put("value","规划数据");map.put("fontSize", 10);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","实测数据");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","结果");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区名3
		col=col_+1;row=row-1;col_=col+2;row_=row;
		map.put("value","小区名3");map.put("bold", false);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col;row=row+1;col_=col;row_=row;
		map.put("value","规划数据");map.put("fontSize", 10);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","实测数据");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","结果");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//备注
		col=col+1;row=row-1;col_=18;row_=row+1;
		map.put("value","备注");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区id
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","小区ID(Cell ID)");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区id1	规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区id1	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(0).getWp_cell_section());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区id1	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区id2	规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区id2	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(1).getWp_cell_section());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区id2	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区id3	规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区id3	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(2).getWp_cell_section());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区id3	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区id	备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//频点
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","频点");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区1频点		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1频点		实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1频点		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
				
		//小区2频点		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2频点			实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2频点		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
				
		//小区3频点		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3频点		实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3频点		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);				
		//小区3频点		备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//PCI
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","PCI");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
				
		//小区1PCI		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1PCI	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(0).getWp_cell_PCI());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1PCI		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
				
		//小区2PCI		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2PCI		实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(1).getWp_cell_PCI());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2PCI	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
						
		//小区3PCI		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3PCI	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(2).getWp_cell_PCI());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3PCI		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);				
		//小区3PCI		备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//PRACH
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","PRACH");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区1PRACH		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1PRACH	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1PRACH			结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
						
		//小区2PRACH			规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2PRACH			实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2PRACH		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
								
		//小区3频点		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3频点		实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3频点		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);				
		//小区3频点		备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=0;row=row+1;col_=18;row_=row+1;
		map.put("value","");map.put("fontSize", 12);map.put("mapBorder",null);map.put("cellWidth", 10);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		return row_;
	}
	
	/**
	 * 小区参数（工程）workParm
	 */
	public int cellParamEngineering(WritableFont wfont,WritableCellFormat wcf,WritableSheet sheet,List<WorkParamDomain> workParam_inList,int col,int row,int col_,int row_,Map map,Map<String, BorderLineStyle> mapBorder) throws Exception{
		
		col=0;row=row_+1;col_=col+2;row_=row+1;
		map.put("value","小区参数(工程)");map.put("bold", true);map.put("fontSize", 12);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.THIN);mapBorder.put("right", BorderLineStyle.THIN);
		mapBorder.put("bottom", BorderLineStyle.THIN);mapBorder.put("left", BorderLineStyle.THIN);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区名1
		col=col_+1;row=row;col_=col+2;row_=row;
		map.put("value","小区名1");map.put("bold", false);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col;row=row+1;col_=col;row_=row;
		map.put("value","规划数据");map.put("fontSize", 10);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","实测数据");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","结果");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区名2
		col=col_+1;row=row-1;col_=col+2;row_=row;
		map.put("value","小区名2");map.put("bold", false);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col;row=row+1;col_=col;row_=row;
		map.put("value","规划数据");map.put("fontSize", 10);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","实测数据");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","结果");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区名3
		col=col_+1;row=row-1;col_=col+2;row_=row;
		map.put("value","小区名3");map.put("bold", false);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col;row=row+1;col_=col;row_=row;
		map.put("value","规划数据");map.put("fontSize", 10);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","实测数据");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","结果");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//备注
		col=col+1;row=row-1;col_=18;row_=row+1;
		map.put("value","备注");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区id
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","小区ID(Cell ID)");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区id1	规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区id1	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(0).getWp_cell_section());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区id1	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区id2	规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区id2	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(1).getWp_cell_section());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区id2	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区id3	规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区id3	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(2).getWp_cell_section());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区id3	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区id	备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//频点
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","频点");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区1频点		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1频点		实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1频点		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
				
		//小区2频点		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2频点			实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2频点		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
				
		//小区3频点		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3频点		实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3频点		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);				
		//小区3频点		备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//PCI
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","PCI");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
				
		//小区1PCI		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1PCI	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(0).getWp_cell_PCI());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1PCI		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
				
		//小区2PCI		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2PCI		实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(1).getWp_cell_PCI());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2PCI	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
						
		//小区3PCI		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3PCI	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(2).getWp_cell_PCI());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3PCI		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);				
		//小区3PCI		备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//PRACH
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","PRACH");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区1PRACH		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1PRACH	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1PRACH			结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
						
		//小区2PRACH			规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2PRACH			实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2PRACH		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
								
		//小区3频点		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3频点		实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3频点		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);				
		//小区3频点		备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=0;row=row+1;col_=18;row_=row+1;
		map.put("value","");map.put("fontSize", 12);map.put("mapBorder",null);map.put("cellWidth", 10);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		return row_;
	}
	
	/**
	 * 小区参数（网优）workParm_in
	 */
	public int cellParamNetwork_in (WritableFont wfont,WritableCellFormat wcf,WritableSheet sheet,List<WorkParam_inDomain> workParam_inList,int col,int row,int col_,int row_,Map map,Map<String, BorderLineStyle> mapBorder) throws Exception{
		col=0;row=row_+1;col_=col+2;row_=row+1;
		map.put("value","小区参数（网优）");map.put("bold", true);map.put("fontSize", 12);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.THIN);mapBorder.put("right", BorderLineStyle.THIN);
		mapBorder.put("bottom", BorderLineStyle.THIN);mapBorder.put("left", BorderLineStyle.THIN);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区名1
		col=col_+1;row=row;col_=col+2;row_=row;
		map.put("value","小区名1");map.put("bold", false);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col;row=row+1;col_=col;row_=row;
		map.put("value","规划数据");map.put("fontSize", 10);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","实测数据");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","结果");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区名2
		col=col_+1;row=row-1;col_=col+2;row_=row;
		map.put("value","小区名2");map.put("bold", false);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col;row=row+1;col_=col;row_=row;
		map.put("value","规划数据");map.put("fontSize", 10);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","实测数据");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","结果");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区名3
		col=col_+1;row=row-1;col_=col+2;row_=row;
		map.put("value","小区名3");map.put("bold", false);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col;row=row+1;col_=col;row_=row;
		map.put("value","规划数据");map.put("fontSize", 10);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","实测数据");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","结果");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//备注
		col=col+1;row=row-1;col_=18;row_=row+1;
		map.put("value","备注");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区1	RsPower(dBm)
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","RsPower(dBm)");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区1RsPower(dBm)	规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1RsPower(dBm)	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1RsPower(dBm)	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区2RsPower(dBm)	规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2RsPower(dBm)	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2RsPower(dBm)	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区3RsPower(dBm)	规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3RsPower(dBm)	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3RsPower(dBm)	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区3RsPower(dBm)	备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//天线挂高（米）
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","天线挂高（米）");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区1天线挂高（米）		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1天线挂高（米）		实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1天线挂高（米）	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
				
		//小区2天线挂高（米）		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2天线挂高（米）			实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2天线挂高（米）		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
				
		//小区3天线挂高（米）		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3天线挂高（米）		实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3天线挂高（米）	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);				
		//小区3天线挂高（米）		备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//方位角（度）
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","方位角（度）");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
				
		//小区1方位角（度）		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1方位角（度）	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(0).getWp_cell_bearing());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1方位角（度）		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
				
		//小区2方位角（度）		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2方位角（度）		实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(1).getWp_cell_bearing());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2方位角（度）	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
						
		//小区3方位角（度）		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3方位角（度）	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(2).getWp_cell_bearing());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3方位角（度）		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);				
		//小区3方位角（度）		备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//总下倾角（度）
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","总下倾角（度）");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区1总下倾角（度）		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1总下倾角（度）	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(0).getWp_cell_dipAangle());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1总下倾角（度）		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
						
		//小区2总下倾角（度）			规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2总下倾角（度）			实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(1).getWp_cell_dipAangle());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2总下倾角（度）		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
								
		//小区3总下倾角（度）	规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3总下倾角（度）	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(2).getWp_cell_dipAangle());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3总下倾角（度）	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);				
		//小区3总下倾角（度）		备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//预制电下倾（度）
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","预制电下倾（度）");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区1预制电下倾（度）		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1预制电下倾（度）	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1预制电下倾（度）		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
						
		//小区2预制电下倾（度）			规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2预制电下倾（度）			实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2预制电下倾（度）		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
								
		//小区3预制电下倾（度）    	规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3预制电下倾（度）		实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3总下倾角（度）	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);				
		//小区3总下倾角（度）		备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//机械下倾角（度）
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","机械下倾角（度）");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区1机械下倾角（度）		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1机械下倾角（度）	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1机械下倾角（度）		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
						
		//小区2机械下倾角（度）			规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2机械下倾角（度）			实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2机械下倾角（度）		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
								
		//小区3机械下倾角（度）    	规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3机械下倾角（度）		实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3机械下倾角（度）    	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);				
		//小区3机械下倾角（度）		备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=0;row=row+1;col_=18;row_=row+1;
		map.put("value","");map.put("fontSize", 12);map.put("mapBorder", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		return row_;
	}
	
	/**
	 * 小区参数（网优）workParm
	 */
	public int cellParamNetwork (WritableFont wfont,WritableCellFormat wcf,WritableSheet sheet,List<WorkParamDomain> workParam_inList,int col,int row,int col_,int row_,Map map,Map<String, BorderLineStyle> mapBorder) throws Exception{
		col=0;row=row_+1;col_=col+2;row_=row+1;
		map.put("value","小区参数（网优）");map.put("bold", true);map.put("fontSize", 12);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.THIN);mapBorder.put("right", BorderLineStyle.THIN);
		mapBorder.put("bottom", BorderLineStyle.THIN);mapBorder.put("left", BorderLineStyle.THIN);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区名1
		col=col_+1;row=row;col_=col+2;row_=row;
		map.put("value","小区名1");map.put("bold", false);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col;row=row+1;col_=col;row_=row;
		map.put("value","规划数据");map.put("fontSize", 10);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","实测数据");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","结果");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区名2
		col=col_+1;row=row-1;col_=col+2;row_=row;
		map.put("value","小区名2");map.put("bold", false);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col;row=row+1;col_=col;row_=row;
		map.put("value","规划数据");map.put("fontSize", 10);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","实测数据");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","结果");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区名3
		col=col_+1;row=row-1;col_=col+2;row_=row;
		map.put("value","小区名3");map.put("bold", false);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col;row=row+1;col_=col;row_=row;
		map.put("value","规划数据");map.put("fontSize", 10);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","实测数据");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","结果");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//备注
		col=col+1;row=row-1;col_=18;row_=row+1;
		map.put("value","备注");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区1	RsPower(dBm)
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","RsPower(dBm)");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区1RsPower(dBm)	规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1RsPower(dBm)	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1RsPower(dBm)	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区2RsPower(dBm)	规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2RsPower(dBm)	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2RsPower(dBm)	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区3RsPower(dBm)	规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3RsPower(dBm)	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3RsPower(dBm)	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区3RsPower(dBm)	备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//天线挂高（米）
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","天线挂高（米）");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区1天线挂高（米）		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1天线挂高（米）		实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1天线挂高（米）	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
				
		//小区2天线挂高（米）		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2天线挂高（米）			实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2天线挂高（米）		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
				
		//小区3天线挂高（米）		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3天线挂高（米）		实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3天线挂高（米）	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);				
		//小区3天线挂高（米）		备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//方位角（度）
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","方位角（度）");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
				
		//小区1方位角（度）		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1方位角（度）	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(0).getWp_cell_bearing());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1方位角（度）		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
				
		//小区2方位角（度）		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2方位角（度）		实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(1).getWp_cell_bearing());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2方位角（度）	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
						
		//小区3方位角（度）		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3方位角（度）	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(2).getWp_cell_bearing());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3方位角（度）		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);				
		//小区3方位角（度）		备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//总下倾角（度）
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","总下倾角（度）");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区1总下倾角（度）		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1总下倾角（度）	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(0).getWp_cell_dipAangle());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1总下倾角（度）		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
						
		//小区2总下倾角（度）			规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2总下倾角（度）			实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(1).getWp_cell_dipAangle());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2总下倾角（度）		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
								
		//小区3总下倾角（度）	规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3总下倾角（度）	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",workParam_inList.get(2).getWp_cell_dipAangle());map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3总下倾角（度）	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);				
		//小区3总下倾角（度）		备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//预制电下倾（度）
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","预制电下倾（度）");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区1预制电下倾（度）		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1预制电下倾（度）	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1预制电下倾（度）		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
						
		//小区2预制电下倾（度）			规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2预制电下倾（度）			实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2预制电下倾（度）		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
								
		//小区3预制电下倾（度）    	规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3预制电下倾（度）		实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3总下倾角（度）	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);				
		//小区3总下倾角（度）		备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//机械下倾角（度）
		col=0;row=row_+1;col_=col+2;row_=row;
		map.put("value","机械下倾角（度）");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//小区1机械下倾角（度）		规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1机械下倾角（度）	实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1机械下倾角（度）		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
						
		//小区2机械下倾角（度）			规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2机械下倾角（度）			实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2机械下倾角（度）		结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
								
		//小区3机械下倾角（度）    	规划数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3机械下倾角（度）		实测数据
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3机械下倾角（度）    	结果
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","");map.put("fontSize", 12);map.put("cellWidth", 15);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);				
		//小区3机械下倾角（度）		备注
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=0;row=row+1;col_=18;row_=row+1;
		map.put("value","");map.put("fontSize", 12);map.put("mapBorder", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		return row_;
	}
	
	/**
	 * 业务验证
	 */
	public int BusinessVerification(WritableFont wfont,WritableCellFormat wcf,WritableSheet sheet,List<LogDomain> logList,int col,int row,int col_,int row_,Map map,Map<String, BorderLineStyle> mapBorder) throws Exception{
		StringBuffer sb = new StringBuffer();
		
		col=col;row=row+1;col_=18;row_=row;
		map.put("value","");map.put("mapBorder", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=0;row=row_+1;col_=col+3;row_=row+1;
		map.put("value","业务验证");map.put("bold", true);map.put("fontSize", 12);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.THIN);mapBorder.put("right", BorderLineStyle.THIN);
		mapBorder.put("bottom", BorderLineStyle.THIN);mapBorder.put("left", BorderLineStyle.THIN);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//验证通过
		col=col_+1;row=row;col_=col+2;row_=row;
		map.put("value","验证通过");map.put("bold", false);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col;row=row+1;col_=col;row_=row;
		map.put("value","小区名1");map.put("fontSize", 10);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","小区名2");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col+1;row=row;col_=col;row_=row;
		map.put("value","小区名3");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//备注
		col=col+1;row=row-1;col_=18;row_=row+1;
		map.put("value","备注");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//基站工程师验证项
		col=0;row=row_+1;col_=col+1;row_=row;
		map.put("value","基站工程师验证项");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//上行业务拨测
		col=col_+1;row=row;col_=col+1;row_=row;
		map.put("value","上行业务拨测");map.put("fontSize", 12);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//3个小区“是”
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","是");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","是");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value","是");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value","每个小区发起attach附着，并上行发包3次，确保终端可以附着成功，发包业务成功。");
		map.put("fontCenter",false);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//网优工程师验证项
		col=0;row=row+1;col_=col+1;row_=row+3;
		map.put("value","网优工程师验证项");map.put("fontCenter",true);map.put("fontSize", 10);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);		
		//接入成功率测试
		col=col_+1;row=row;col_=col+1;row_=row;
		map.put("value","接入成功率测试");map.put("fontCenter",true);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1	接入成功率
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",logList.get(0).getLog_openRate());map.put("fontCenter",true);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2	接入成功率
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",logList.get(1).getLog_openRate());map.put("fontCenter",true);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3	接入成功率
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",logList.get(2).getLog_openRate());map.put("fontCenter",true);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//备注
		sb.append("RRC建立成功率\n")
		  .append("1）定点测试：RSRP≥-80dBm，SINR≥20dB\n")
		  .append("2）做Ping业务测试，每次Ping间隔10S（大于UE不活动定时器），确保终端可以回到空闲态。\n")
		  .append("3）测试次数要求最少10次。\n")
		  .append("验收标准：成功率100%");
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value",sb.toString());map.put("fontCenter",false);map.put("rowHeight", 1500);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);	
		
		//时延测试
		col=2;row=row+1;col_=col+1;row_=row;
		map.put("value","ping时延测试");map.put("fontCenter",true);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1	ping时延
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",logList.get(0).getLog_delayTime());map.put("fontCenter",true);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2	ping时延
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",logList.get(1).getLog_delayTime());map.put("fontCenter",true);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3	ping时延
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",logList.get(2).getLog_delayTime());map.put("fontCenter",true);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//备注
		sb.append("PING 32Bytes时延\n")
		  .append("1）定点测试：RSRP≥-80dBm，SINR≥20dB\n")
		  .append("2）空载网络/轻载网络闲时测试。\n")
		  .append("3）连续测试次数要求最少50次。\n")
		  .append("4）测试间隔时间为2S。\n")
		  .append("5）传输时延小于3ms，端到端时延抖动小于2ms，建议服务器直接连接PGW测试。\n")
		  .append("6）排除非RAN侧或非华为设备原因引起的指标异常\n")
		  .append("验收标准：<1.5秒");
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value",sb.toString());map.put("fontCenter",false);map.put("rowHeight", 3000);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//单用户上行吞吐率测试
		col=2;row=row+1;col_=col+1;row_=row;
		map.put("value","单用户上行吞吐率测试");map.put("fontCenter",true);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1	单用户上行吞吐率测试
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",logList.get(0).getLog_iperfTop_rate());map.put("fontCenter",true);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2	单用户上行吞吐率测试
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",logList.get(1).getLog_iperfTop_rate());map.put("fontCenter",true);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3	单用户上行吞吐率测试
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",logList.get(2).getLog_iperfTop_rate());map.put("fontCenter",true);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//备注
		sb.append("上行速率测试：")
		  .append("1）空载网络\n")
		  .append("2）定点测试，选择RSRP≥-80dBm，SINR≥20dB。\n")
		  .append("3）上行发包≥300Bytes；\n")
		  .append("4）连续测试次数要求最少10次。\n")
		  .append("5）排除非RAN侧原因引起的指标异常\n")
		  .append("6）排除由于非华为设备原因引起的指标异常\n")
		  .append("测试方法：\n")
		  .append("1）通过Probe路测工具提供的AT命令配置功能发送300Bytes的数据。\n")
		  .append("2）观察路测工具中MAC层上行吞吐率。\n")
		  .append("验收标准：\n")
		  .append("10kbps");
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value",sb.toString());map.put("fontCenter",false);map.put("rowHeight", 5500);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//单用户下行吞吐率测试
		col=2;row=row+1;col_=col+1;row_=row;
		map.put("value","单用户下行吞吐率测试");map.put("fontCenter",true);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区1	单用户上行吞吐率测试
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",logList.get(0).getLog_iperfDown_rate());map.put("fontCenter",true);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区2	单用户上行吞吐率测试
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",logList.get(1).getLog_iperfDown_rate());map.put("fontCenter",true);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//小区3	单用户上行吞吐率测试
		col=col_+1;row=row;col_=col;row_=row;
		map.put("value",logList.get(2).getLog_iperfDown_rate());map.put("fontCenter",true);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//备注
		sb.append("下行速率测试：：")
		  .append("1）空载网络\n")
		  .append("2）定点测试，选择RSRP≥-80dBm，SINR≥20dB。\n")
		  .append("3）下行ftp文件大小约1MBytes；\n")
		  .append("4）持续下载5分钟以上。\n")
		  .append("5）排除非RAN侧原因引起的指标异常。\n")
		  .append("6）排除由于非华为设备原因引起的指标异常\n")
		  .append("测试方法：\n")
		  .append("1）通过FTP服务器向终端发起下行灌包业务\n")
		  .append("2）观察路测工具中MAC层下行吞吐率。\n")
		  .append("验收标准：\n")
		  .append("15kbps");
		col=col_+1;row=row;col_=18;row_=row;
		map.put("value",sb.toString());map.put("fontCenter",false);map.put("rowHeight", 5500);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=0;row=row+1;col_=18;row_=row;
		map.put("value","");map.put("fontCenter",true);map.put("rowHeight", 500);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		return row_;
	}
	
	/**
	 * 验证结论
	 */
	public int VerificationConclusion(WritableFont wfont,WritableCellFormat wcf,WritableSheet sheet,List<LogDomain> logList,int col,int row,int col_,int row_,Map map,Map<String, BorderLineStyle> mapBorder) throws Exception{
		StringBuffer sb = new StringBuffer();
		col=0;row=row_+1;col_=18;row_=row+1;
		map.put("value","验证结论");map.put("bold", true);map.put("fontSize", 12);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.THICK);mapBorder.put("right", BorderLineStyle.THICK);
		mapBorder.put("bottom", BorderLineStyle.THICK);mapBorder.put("left", BorderLineStyle.THICK);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", false);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=1;row=row_+2;col_=col+1;row_=row;
		map.put("value","是否通过验证：");map.put("bold", false);map.put("fontSize", 12);map.put("fontType", "楷书");
		map.put("mapBorder", null);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//验证结果
		col=col_+1;row=row_;col_=col;row_=row;
		map.put("value","");map.put("bold", false);map.put("fontSize", 12);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.THIN);mapBorder.put("right", BorderLineStyle.THIN);
		mapBorder.put("bottom", BorderLineStyle.THIN);mapBorder.put("left", BorderLineStyle.THIN);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//备注
		sb.append("");
		col=0;row=row_+2;col_=18;row_=row;
		map.put("value","      备注："+sb);map.put("bold", false);map.put("fontSize", 12);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.THIN);mapBorder.put("right", BorderLineStyle.THIN);
		mapBorder.put("bottom", BorderLineStyle.THIN);mapBorder.put("left", BorderLineStyle.THIN);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", false);map.put("cellWidth", null);map.put("rowHeight", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=0;row=row_+1;col_=18;row_=row;
		map.put("value","");map.put("mapBorder", null);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		return row_;
	}
	
	/**
	 * 工程师信息
	 */
	public int EngineerDesc(WritableFont wfont,WritableCellFormat wcf,WritableSheet sheet,Plane plane,int col,int row,int col_,int row_,Map map,Map<String, BorderLineStyle> mapBorder) throws Exception{
		col=0;row=row_+1;col_=col+1;row_=row;
		map.put("value","工程师类型");map.put("bold", true);map.put("fontSize", 14);map.put("fontType", "楷书");
		mapBorder.put("top", BorderLineStyle.THICK);mapBorder.put("right", BorderLineStyle.THICK);
		mapBorder.put("bottom", BorderLineStyle.THICK);mapBorder.put("left", BorderLineStyle.THICK);
		map.put("mapBorder", mapBorder);
		map.put("fontCenter", true);map.put("cellWidth", null);map.put("rowHeight", 400);
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value","姓名");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value","日期");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value","电话");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		col=col_+1;row=row_;col_=18;row_=row;
		map.put("value","签名");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//基站工程师
		col=0;row=row_+1;col_=col+1;row_=row;
		map.put("value","基站工程师");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//基站工程师姓名
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value",plane.getPlan_test_engineer());
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//基站工程师日期
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value","");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//基站工程师电话
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value",plane.getPlan_te_phone());
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//基站工程师签名
		col=col_+1;row=row_;col_=18;row_=row;
		map.put("value","");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		//网优工程师
		col=0;row=row_+1;col_=col+1;row_=row;
		map.put("value","网优工程师");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//网优工程师姓名
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value","");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//网优工程师日期
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value","");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//网优工程师电话
		col=col_+1;row=row_;col_=col+1;row_=row;
		map.put("value","");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		//网优工程师签名
		col=col_+1;row=row_;col_=18;row_=row;
		map.put("value","");
		map.put("col", col);map.put("row", row);map.put("newCol", col_);map.put("newRow", row_);
		createcell(wfont,wcf,sheet,map);
		
		
		return row_;
	}
	
	
	/**
	 * @param map
	 * 	value:值(object)
	 * 	bold:是否加粗（true,false）
	 * 	fontSize:字体大小（int）
	 * 	fontType:字体（String）
	 *  fontCenter:字体居中（true,false）
	 * 
	 * 	borderDirection:边框方向["top","right","bottom","left"]
	 *  borderStyle:THICK(粗线)，THIN(黑线)，DOTTED(点线)
	 *  mapBorder:[{"top",BorderLineStyle},....]
	 * 
	 *  col:开始列
	 *  row：开始行
	 *  newCol:结束列
	 *  newRow:结束行
	 *  
	 *  cellWidth:列宽（int）
	 *  rowHeight:行高（int）
	 * @throws Exception 
	 */
	public void createcell(WritableFont wfont,WritableCellFormat wcf,WritableSheet sheet,Map map) throws Exception{
		//是否加粗，字体，字体大小
		if((boolean)map.get("bold")){
			wfont = new WritableFont(WritableFont.createFont((String)map.get("fontType")),(int)map.get("fontSize"),WritableFont.BOLD);//设置字体、大小、加粗
		}else{
			wfont = new WritableFont(WritableFont.createFont((String)map.get("fontType")),(int)map.get("fontSize"));//设置字体、大小、加粗
		}		
		wcf = new WritableCellFormat(wfont);
		wcf.setWrap(true);//自动换行
		//字体居中
		if((boolean)map.get("fontCenter")){
			wcf.setAlignment(Alignment.CENTRE); // 设置居中			
		}
		wcf.setVerticalAlignment(VerticalAlignment.CENTRE);  
		//边框线样式
		if(map.get("mapBorder")!=null){
			if(((Map)map.get("mapBorder")).get("top")!=null){
				wcf.setBorder(Border.TOP,(BorderLineStyle)((Map)map.get("mapBorder")).get("top")); // 设置边框线
			}
			if(((Map)map.get("mapBorder")).get("right")!=null){
				wcf.setBorder(Border.RIGHT,(BorderLineStyle)((Map)map.get("mapBorder")).get("right")); // 设置边框线
			}
			if(((Map)map.get("mapBorder")).get("bottom")!=null){
				wcf.setBorder(Border.BOTTOM,(BorderLineStyle)((Map)map.get("mapBorder")).get("bottom")); // 设置边框线
			}
			if(((Map)map.get("mapBorder")).get("left")!=null){
				wcf.setBorder(Border.LEFT,(BorderLineStyle)((Map)map.get("mapBorder")).get("left")); // 设置边框线
			}
		}
		Label lable = new Label((int)map.get("col"),(int)map.get("row"),(String)map.get("value"),wcf);
		//列宽、行高
		if(map.get("cellWidth")!=null){
			sheet.setColumnView((int)map.get("col"),(int)map.get("cellWidth"));
		}
		if(map.get("rowHeight")!=null){
			sheet.setRowView((int)map.get("row"),(int)map.get("rowHeight"));
		}
		//合并单元格
		if(map.get("newCol")!=null&&map.get("newRow")!=null){
			sheet.mergeCells((int)map.get("col"),(int)map.get("row"),(int)map.get("newCol"),(int)map.get("newRow"));//合并单元格
		}
		sheet.addCell(lable);
	}
	
	@Test
	public void test2 () throws Exception{
		Configuration configuration = new Configuration();  
	    configuration.setDefaultEncoding("utf-8"); 
	    configuration.setDirectoryForTemplateLoading(new File("D:/")); 
	    File outFile = new File("D:/docImg.doc");
	    
	    Map<String,String> dataMap = new HashMap<String,String>(); 
	    dataMap.put("img",getImageStr());
	    
	    Template t =  configuration.getTemplate("DocImg.ftl","utf-8"); 
	    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240);  
        t.process(dataMap, out);  
        out.close(); 
	}
	
	public String getImageStr(){  
        String imgFile = "d:/qq.png";  
        InputStream in = null;  
        byte[] data = null;  
        try {  
            in = new FileInputStream(imgFile);  
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        BASE64Encoder encoder = new BASE64Encoder();  
        return encoder.encode(data);  
    }
}
