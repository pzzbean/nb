package com.ibase.web.log.util.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.ibase.core.http.ResponsePacket;
import com.ibase.core.utils.ExcelPoiUtil;
import com.ibase.web.log.controller.LogController;
import com.ibase.web.log.domain.LogCXDomain;
import com.ibase.web.log.domain.LogDomain;
import com.ibase.web.log.domain.LogUser;
import com.ibase.web.log.domain.SingleTestReport;
import com.ibase.web.log.mapper.LogMapper;
import com.ibase.web.log.service.LogService;
import com.ibase.web.log.service.impl.LogServiceImpl;
import com.ibase.web.plane.domain.Plane;
import com.ibase.web.roadtest.domain.CellIndexResult;
import com.ibase.web.roadtest.domain.CellIndexResultTotal;
import com.ibase.web.roadtest.domain.CellParameterCheck;
import com.ibase.web.roadtest.domain.TemporayWorkparamDomain2;
import com.ibase.web.testplan.domain.TemporaryTestplan;
import com.ibase.web.workparam.domain.WorkParamDomain;
import com.ibase.web.workparam_in.domain.WorkParam_inDomain;

/**
 * 
 * CCDL站报告
 * @author Administrator
 *
 */
public class CCDL_Excel {
	
	public void createExcel_CCDL_in(OutputStream out,LogCXDomain logCXDomain,List<CellIndexResultTotal>	listCellIndexResultTotal ,//
			List<TemporayWorkparamDomain2> temporayWorkparamDomainList,TemporaryTestplan temporaryTestplan) throws Exception,IOException{// List<LogDomain> logList,List<CellIndexResult> cellIndex,List<CellParameterCheck> cellParameter) throws Exception,IOException{	
			HSSFWorkbook wb = new HSSFWorkbook();//创建工作簿
			HSSFSheet sheet0 = wb.createSheet("验收标准");//验收标准
			HSSFSheet sheet1 = wb.createSheet("测试验收结果");//测试验收结果
			HSSFSheet sheet2 = wb.createSheet("性能验收覆盖效果图");//性能验收覆盖效果图 
			createExcelAcceptanceCriteria(wb,sheet0);//验收标准
			createExcelAcceptanceResults_in(wb,sheet1,logCXDomain,listCellIndexResultTotal,temporayWorkparamDomainList,temporaryTestplan);//,listCellIndexResultTotal,logList,cellIndex,cellParameter);//测试验收结果
			createExcelEffectDiagram(wb,sheet2,logCXDomain,temporayWorkparamDomainList);//性能验收覆盖效果图 
//			int row = 8;
//			for (String adderss : adList) {
//				ExcelPoiUtil.createImage(out, wb, sheet2, adderss,row);
//				row+=30;
//			}

			// 写入数据
			wb.write(out);
			// 关闭文件
			wb.close();
			
		}
//	public void createExcel_CCDL(OutputStream out, List<String> adList
//		,List<LogDomain> logList) throws Exception,IOException{//,List<CellIndexResult> cellIndex,List<CellParameterCheck> cellParameter) throws Exception,IOException{
//		HSSFWorkbook wb = new HSSFWorkbook();//创建工作簿
//		HSSFSheet sheet0 = wb.createSheet("验收标准");//验收标准
//		HSSFSheet sheet1 = wb.createSheet("测试验收结果");//测试验收结果
//		HSSFSheet sheet2 = wb.createSheet("性能验收覆盖效果图");//性能验收覆盖效果图 
//		createExcelAcceptanceCriteria(wb,sheet0);//验收标准
//		//createExcelAcceptanceResults(wb,sheet1,lang,logList);//,cellIndex,cellParameter);//测试验收结果
//		createExcelEffectDiagram(wb,sheet2);//性能验收覆盖效果图 
//		int row = 8;
//		for (String adderss : adList) {
//			ExcelPoiUtil.createImage(out, wb, sheet2, adderss,row);
//			row+=30;
//		}
//
//		// 写入数据
//		wb.write(out);
//		// 关闭文件
//		wb.close();
//	}
//	
	private void createExcelAcceptanceCriteria(HSSFWorkbook wb, HSSFSheet sheet) {
		
		Map map = new HashMap();
		
		int col = 0;// 列
		int row = 0;// 行
		int colTo =0;
		int rowTo = 0;
		
		//验收类别
		col = 0;
		row = 0;
		colTo = 1;
		rowTo = 0;
		map.put("cellValue", "验收类别");
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 15);
		map.put("fontType", "楷书");
		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth",(int)8000);
		//map.put("columnWidth", (int)2000);
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//1、基站参数验证
		col = 0;
		row = 1;
		colTo = 1;
		rowTo = 1;
		map.put("cellValue", "1、基站参数验证");
		map.put("rowHeight", (short)800);
		map.put("fontWeight", (short)200);
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//2、小区工程参数验证
		col = 0;
		row = 2;
		colTo = 1;
		rowTo = 2;
		map.put("cellValue", "2、小区工程参数验证");
		map.put("rowHeight", (short)400);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//3、小区网优参数验证
		col = 0;
		row = 3;
		colTo = 1;
		rowTo = 3;
		map.put("cellValue", "3、小区网优参数验证");
		map.put("rowHeight", (short)1200);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//4、站点状态验证
		col = 0;
		row = 4;
		colTo = 1;
		rowTo = 4;
		map.put("cellValue", "4、站点状态验证");
		map.put("rowHeight", (short)400);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//		//验收类别
//		rowTo = AcceptanceCategory(wb,sheet,col,row,colTo,rowTo);
		
		//验收方法
		col = 3;
		row =0;
		colTo = 3;
		rowTo =0;
		map.put("cellValue", "验收方法");
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 15);
		map.put("fontType", "楷书");
		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", (int)15000);
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//性能验收
		col = 0;
		row = 5;
		colTo = 0;
		rowTo = 37;
		map.put("cellValue", "性能验收");
		map.put("columnWidth", (int)6000);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//附着性能验证
		col = 1;
		row = 5;
		colTo = 1;
		rowTo = 7;
		map.put("cellValue", "附着性能验证");
		map.put("columnWidth", (int)4000);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//重选性能验证（考察项）
		col = 1;
		row = 8;
		colTo = 1;
		rowTo = 10;
		map.put("cellValue", "重选性能验证 \r\n"+"（考察项）");
		map.put("columnWidth", (int)4000);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//接入性能验证
		col = 1;
		row = 11;
		colTo = 1;
		rowTo = 14;
		map.put("cellValue", "接入性能验证");
		map.put("columnWidth", (int)4000);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//Ping时延性能验证
		col = 1;
		row = 15;
		colTo = 1;
		rowTo = 20;
		map.put("cellValue", "Ping时延性能验证");
		map.put("columnWidth", (int)4000);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//上行峰值速率测试 
		col = 1;
		row = 21;
		colTo = 1;
		rowTo = 24;
		map.put("cellValue", "上行峰值速率测试 ");
		map.put("columnWidth", (int)4000);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//下行峰值速率测试
		col = 1;
		row = 25;
		colTo = 1;
		rowTo = 30;
		map.put("cellValue", "下行峰值速率测试 ");
		map.put("columnWidth", (int)4000);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//覆盖性能验证（列入全网优化）
		col = 1;
		row = 31;
		colTo = 1;
		rowTo = 37;
		map.put("cellValue", "覆盖性能验证 \r\n"+"（列入全网优化） ");
		map.put("columnWidth", (int)4000);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		
		//验收目的
		col = 2;
		row = 0;
		colTo = 2;
		rowTo = 0;
		map.put("cellValue", "验收目的");
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 15);
		map.put("fontType", "楷书");
		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", (int)8000);
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//经度、纬度、TAC、NodeB ID；
		col = 2;
		row = 1;
		colTo = 2;
		rowTo = 1;
		map.put("cellValue", "经度、纬度、TAC、NodeB ID；");
		map.put("rowHeight", (short)800);
		map.put("fontWeight", (short)200);
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//Cell ID、频点、PCI、天线端口数；
		col = 2;
		row = 2;
		colTo = 2;
		rowTo = 2;
		map.put("cellValue", "Cell ID、频点、PCI、天线端口数；");
		map.put("rowHeight", (short)400);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//RsPower、天线挂高、方向角、总下倾角、预置电下倾、机械下倾角；
		col = 2;
		row = 3;
		colTo = 2;
		rowTo = 3;
		map.put("cellValue", "RsPower、天线挂高、\r\n"+"方向角、总下倾角、预\r\n"+"置电下倾、机械下倾\r\n"+"角；");
		map.put("rowHeight", (short)1200);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short)10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//站点是否运行正常，有无告警；
		col = 2;
		row = 4;
		colTo = 2;
		rowTo = 4;
		map.put("cellValue", "站点是否运行正常，"+"有无告警；");
		map.put("rowHeight", (short)400);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//站点各小区attach成功率；
		col = 2;
		row = 5;
		colTo = 2;
		rowTo = 7;
		map.put("cellValue", "站点各小区attach"+"成功率；");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//站点各小区重选成功率
		col = 2;
		row = 8;
		colTo = 2;
		rowTo = 10;
		map.put("cellValue", "站点各小区重选成功率");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//RRC连接成功率
		col = 2;
		row = 11;
		colTo = 2;
		rowTo = 14;
		map.put("cellValue", "RRC连接成功率");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//PING时延测试
		col = 2;
		row = 15;
		colTo = 2;
		rowTo = 20;
		map.put("cellValue", "PING时延测试");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//MAC层上行吞吐率
		col = 2;
		row = 21;
		colTo = 2;
		rowTo = 24;
		map.put("cellValue", "MAC层上行吞吐率 ");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//单用户下行吞吐率
		col = 2;
		row = 25;
		colTo = 2;
		rowTo = 30;
		map.put("cellValue", "单用户下行吞吐率 ");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//验证站点各小区覆盖是否正常，是否存在天线接反、弱覆盖等情况；
		col = 2;
		row = 31;
		colTo = 2;
		rowTo = 37;
		map.put("cellValue", "验证站点各小区覆盖是 \r\n"+"否正常，是否存在天线 \r\n"+"接反、弱覆盖等情况； ");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		
		//验收方法
		col = 3;
		row =0;
		colTo = 3;
		rowTo =0;
		map.put("cellValue", "验收方法");
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 15);
		map.put("fontType", "楷书");
		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", (int)15000);
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//OMC查询及GSM工参查询
		col = 3;
		row = 1;
		colTo = 3;
		rowTo = 1;
		map.put("cellValue", "OMC查询及GSM工参查询");
		map.put("rowHeight", (short)800);
		map.put("fontWeight", (short)200);
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//OMC查询
		col = 3;
		row = 2;
		colTo = 3;
		rowTo = 2;
		map.put("cellValue", "OMC查询");
		map.put("rowHeight", (short)400);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		/**
		 * OMC查询：RsPower、预置电下倾（未替换天线站见GSM工参表）
		 * GSM工参查询：天线挂高、方向角、机械下倾角；
		 * 总下倾角：预置电下倾+机械下倾角；
		 */
		col = 3;
		row = 3;
		colTo = 3;
		rowTo = 3;
		map.put("cellValue", "OMC查询：RsPower、预置电下倾（未替换天线站见GSM工参表）\r\n" + 
				"GSM工参查询：天线挂高、方向角、机械下倾角；\r\n" + 
				"总下倾角：预置电下倾+机械下倾角；");
		map.put("rowHeight", (short)1200);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short)10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//OMC查询
		col = 3;
		row = 4;
		colTo = 3;
		rowTo = 4;
		map.put("cellValue", "OMC查询");
		map.put("rowHeight", (short)400);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//1） 定点测试：RSRP≥-80dBm，SINR≥20dB；
		//2） 终端发起Attach操作流程；
		//3） 测试次数要求最少5次。
		col = 3;
		row = 5;
		colTo = 3;
		rowTo = 7;
		map.put("cellValue", "1） 定点测试：RSRP≥-80dBm，SINR≥20dB；\r\n" + 
				"2） 终端发起Attach操作流程；\r\n" + 
				"3） 测试次数要求最少5次。");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//1） 选取小区覆盖边缘区域，触发站间小区重选及站内小区间重选；
		//2） 要求站间小区重选至少5次，站内小区间重选至少5次；
		col = 3;
		row = 8;
		colTo = 3;
		rowTo = 10;
		map.put("cellValue", "1） 选取小区覆盖边缘区域，触发站间小区重选及站内小区间重选；\r\n" + 
				"2） 要求站间小区重选至少5次，站内小区间重选至少5次；");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		/**
		 * 1） 定点测试：RSRP≥-80dBm，SINR≥20dB；
		 * 2） 做Ping业务测试，每次Ping间隔10S（大于UE不活动定时器，现网UE不活动定时器为20秒，可以间隔30s），确保终端可以回到空闲态。
		 * 3） 测试次数要求最少10次。 
		 * 
		 */
		col = 3;
		row = 11;
		colTo = 3;
		rowTo = 14;
		map.put("cellValue", "1） 定点测试：RSRP≥-80dBm，SINR≥20dB；\r\n" + 
				"2） 做Ping业务测试，每次Ping间隔10S（大于UE不活动定时器，现网UE不活动定时器为20秒，可以间隔30s），确保终端可以回到空闲态。\r\n" + 
				"3） 测试次数要求最少10次。 ");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		/*
		 * 1） PING 包大小32Bytes；
		 * 2） 定点测试：RSRP≥-80dBm，SINR≥20dB；
		 * 3） 空载网络/轻载网络闲时测试；
		 * 4） 连续测试次数要求最少10次；
		 * 5） 测试间隔时间为2S（华为软件设置3-60秒，按照3秒间隔测试）；
		 * 6） 排除设备原因引起的指标异常。
		 */
		col = 3;
		row = 15;
		colTo = 3;
		rowTo = 20;
		map.put("cellValue", "1） PING 包大小32Bytes；\r\n" + 
				"2） 定点测试：RSRP≥-80dBm，SINR≥20dB；\r\n" + 
				"3） 空载网络/轻载网络闲时测试；\r\n" + 
				"4） 连续测试次数要求最少10次；\r\n" + 
				"5） 测试间隔时间为2S（华为软件设置3-60秒，按照3秒间隔测试）；\r\n" + 
				"6） 排除设备原因引起的指标异常。");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		/*
		 * 1） 空载网络；
		 * 2） 定点测试，选择RSRP≥-80dBm，SINR≥20dB；
		 * 3） 上行发包≥300Bytes；
		 * 4） 连续测试次数要求最少10次；
		 * 5） 排除设备原因引起的指标异常。
		 */
		col = 3;
		row = 21;
		colTo = 3;
		rowTo = 24;
		map.put("cellValue", "1） 空载网络；\r\n" + 
				"2） 定点测试，选择RSRP≥-80dBm，SINR≥20dB；\r\n" + 
				"3） 上行发包≥300Bytes；\r\n" + 
				"4） 连续测试次数要求最少10次；\r\n" + 
				"5） 排除设备原因引起的指标异常。 ");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		/*
		 * 1） 空载网络；
		 * 2） 定点测试，选择RSRP≥-80dBm，SINR≥20dB；
		 * 3） 下行发包≥1MBytes；
		 * 4） 连续测试次数要求最少10次；(12月20日讨论改为至少连续测试10分钟)
		 * 5） 排除设备原因引起的指标异常。
		 */
		col = 3;
		row = 25;
		colTo = 3;
		rowTo = 30;
		map.put("cellValue", "1） 空载网络；\r\n" + 
				"2） 定点测试，选择RSRP≥-80dBm，SINR≥20dB；\r\n" + 
				"3） 下行发包≥1MBytes；\r\n" + 
				"4） 连续测试次数要求最少10次；(12月20日讨论改为至少连续测试10分钟)\r\n" + 
				"5） 排除设备原因引起的指标异常。 ");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		/*
		 * 1） 将终端锁定在单验小区；
		 * 2） 规划覆盖区域内遍历测试，以不超过30km/h的时速对服务小区主瓣方向120度覆盖范围内道路进行遍历测试，尽量涵盖1-5级道路；
		 */
		col = 3;
		row = 31;
		colTo = 3;
		rowTo = 37;
		map.put("cellValue", "1） 将终端锁定在单验小区；2） 规划覆盖区域内遍历测 \r\n"+
		"试，以不超过30km/h的时速对服务小区主瓣方向120度覆盖范  \r\n"+
				"围内道路进行遍历测试，尽量涵盖1-5级道路； ");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		
		//验收标准
		col = 4;
		row = 0;
		colTo = 4;
		rowTo =0;
		map.put("cellValue", "验收标准");
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 15);
		map.put("fontType", "楷书");
		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", (int)20000);
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		
		/*
		 * 实际经纬度数据与规划数据的偏差在允许范围内即认为验收通过，
		 * 偏差允许范围:市区小于50米、县城小于75米、农村小于200米。其他参数需与规划数据一致。
		 * (经纬度直接继承同站 GSM工参)
		 */
		col = 4;
		row = 1;
		colTo = 4;
		rowTo = 1;
		map.put("cellValue", "实际经纬度数据与规划数据的偏差在允许范围内即认为验收通过，偏差允许范围：\r\n"+
		"市区小于50米、县城小于75米、农村小于200米。其他参数需与规划数据一致。\r\n"+
				"(经纬度直接继承同站 GSM工参)");
		map.put("rowHeight", (short)800);
		map.put("fontWeight", (short)200);
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//实际配置数据与规划数据一致；
		col = 4;
		row = 2;
		colTo = 4;
		rowTo = 2;
		map.put("cellValue", "实际配置数据与规划数据一致；");
		map.put("rowHeight", (short)400);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		/**
		 * 实际数据与规划数据一致；(直接继承同RRU GSM工参)；
		 */
		col = 4;
		row = 3;
		colTo = 4;
		rowTo = 3;
		map.put("cellValue", "实际数据与规划数据一致；(直接继承同RRU GSM工参)；");
		map.put("rowHeight", (short)1200);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short)10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//运行正常，无告警
		col = 4;
		row = 4;
		colTo = 4;
		rowTo = 4;
		map.put("cellValue", "运行正常，无告警");
		map.put("rowHeight", (short)400);
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//attach成功率100%。
		col = 4;
		row = 5;
		colTo = 4;
		rowTo = 7;
		map.put("cellValue", "attach成功率100%。");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		//重选成功率100%（现阶段均为独立站点，且按照流量站点为交维均为去激活状态，
		//无法进行站点重选测试，站间重选测试列入全网优化）； 
		col = 4;
		row = 8;
		colTo = 4;
		rowTo = 10;
		map.put("cellValue", "重选成功率100%（现阶段均为独立站点，且按照流量站点为交维均为去激活状态，\r\n"+
		"无法进行站点重选测试，站间重选测试列入全网优化）； ");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		/**
		 * RRC连接成功率100%。
		 */
		col = 4;
		row = 11;
		colTo = 4;
		rowTo = 14;
		map.put("cellValue", "RRC连接成功率100%。 ");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		/*
		 * PING时延≤ 1.5s。
		 */
		col = 4;
		row = 15;
		colTo = 4;
		rowTo = 20;
		map.put("cellValue", "PING时延≤ 1.5s。");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		/*
		 * MAC层上行平均吞吐率≥10Kbps
		 */
		col = 4;
		row = 21;
		colTo = 4;
		rowTo = 24;
		map.put("cellValue", "MAC层上行平均吞吐率≥10Kbps ");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		/*
		 * MAC层下行平均吞吐率≥13Kbps；
		 * （未部署下载服务器，解决服务器后再进行下载测试，
		 * 服务器解决前已经进行单验的放入全网测试）
		 */
		col = 4;
		row = 25;
		colTo = 4;
		rowTo = 30;
		map.put("cellValue", "MAC层下行平均吞吐率≥13Kbps；（未部署下载服务器，解决服务器后再进行 \r\n"+
		"下载测试，服务器解决前已经进行单验的放入全网测试） ");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		/*
		 * 图片
		 */
		col = 4;
		row = 31;
		colTo = 4;
		rowTo = 37;
		map.put("cellValue", "");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
	}


	private void createExcelAcceptanceResults_in(HSSFWorkbook wb, HSSFSheet sheet1,LogCXDomain logCXDomain,List<CellIndexResultTotal> listCellIndexResultTotal,
			List<TemporayWorkparamDomain2> temporayWorkparamDomainList,TemporaryTestplan temporaryTestplan) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Map map = new HashMap();
		int col = 0;// 列
		int row = 0;// 行
		int colTo =0;
		int rowTo = 0;
		//标题
		col = 0;
		row = 0;
		colTo = 20;
		row = 0;
		map.put("cellValue", "NB-IOT"+isNull(temporayWorkparamDomainList.get(0).getStation_name())+"单站核查优化测试报告_移动_"+df.format(df.parse(isNull(logCXDomain.getTestDate())))+"");
		map.put("rowHeight",(short)500);
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 15);
		map.put("fontType", "楷书");
		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("borderTop", HSSFCellStyle.BORDER_THICK);
		map.put("borderRight", HSSFCellStyle.BORDER_THICK);
		map.put("borderBottom", HSSFCellStyle.BORDER_THICK);
		map.put("borderLeft", HSSFCellStyle.BORDER_THICK);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 0;
		row = 1;
		colTo = 20;
		rowTo = 1;
		map.put("cellValue", "");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",HSSFColor.WHITE.index);
		map.put("borderTop",HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom",HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//测试人员信息
		col = 0;
		row = 2;
		colTo = 20;
		rowTo = 2;
		map.put("cellValue", "测试人员信息");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",HSSFColor.LIGHT_BLUE.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//测试工程师
		col = 0;
		row = 3;
		colTo = 3;
		rowTo = 3;
		map.put("cellValue", "测试工程师");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 4;
		row = 3;
		colTo = 8;
		rowTo = 3;
		map.put("cellValue", isNull(temporaryTestplan.getTestEngineer()));
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//电话
		col = 9;
		row = 3;
		colTo = 9;
		rowTo = 3;
		map.put("cellValue", "电话:");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 10;
		row = 3;
		colTo = 14;
		rowTo = 3;
		map.put("cellValue",isNull(temporaryTestplan.getTestEngineerPhone()));
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//Email:
		col = 15;
		row = 3;
		colTo = 15;
		rowTo = 3;
		map.put("cellValue", "Email:");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 16;
		row = 3;
		colTo = 20;
		rowTo = 3;
		map.put("cellValue", "17317537120@163.com");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		//eNB后台工程师
		col = 0;
		row = 4;
		colTo = 3;
		rowTo = 4;
		map.put("cellValue", "eNB后台工程师");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 4;
		row = 4;
		colTo = 8;
		rowTo = 4;
		map.put("cellValue", "黄仲伟");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//电话
		col = 9;
		row = 4;
		colTo = 9;
		rowTo = 4;
		map.put("cellValue", "电话:");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 10;
		row = 4;
		colTo = 14;
		rowTo = 4;
		map.put("cellValue", "15172409302");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//Email:
		col = 15;
		row = 4;
		colTo = 15;
		rowTo = 4;
		map.put("cellValue", "Email:");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 16;
		row = 4;
		colTo = 20;
		rowTo = 4;
		map.put("cellValue", "15172409302@163.com");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		//测试负责人
		col = 0;
		row = 5;
		colTo = 3;
		rowTo = 5;
		map.put("cellValue", "测试负责人");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 4;
		row = 5;
		colTo = 8;
		rowTo = 5;
		map.put("cellValue", isNull(temporaryTestplan.getPlanCreator()));
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//电话
		col = 9;
		row = 5;
		colTo = 9;
		rowTo = 5;
		map.put("cellValue", "电话:");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 10;
		row = 5;
		colTo = 14;
		rowTo = 5;
		map.put("cellValue", isNull(temporaryTestplan.getPlanCreatorPhone()));
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//Email:
		col = 15;
		row = 5;
		colTo = 15;
		rowTo = 5;
		map.put("cellValue", "Email:");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 16;
		row = 5;
		colTo = 20;
		rowTo = 5;
		map.put("cellValue", "13753679435@163.com");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//查勘日期（年/月/日）
		col = 0;
		row = 6;
		colTo = 3;
		rowTo = 6;
		map.put("cellValue", "查勘日期（年/月/日）");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 4;
		row = 6;
		colTo = 8;
		rowTo = 6;
		map.put("cellValue", isNull(df.format(df.parse(logCXDomain.getTestDate()))));
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//eNB Ver
		col = 9;
		row = 6;
		colTo = 9;
		rowTo = 6;
		map.put("cellValue", "eNB Ver");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 10;
		row = 6;
		colTo = 14;
		rowTo = 6;
		map.put("cellValue", "Eran12.1");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//终端：
		col = 15;
		row = 6;
		colTo = 15;
		rowTo = 6;
		map.put("cellValue", "终端：");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 16;
		row = 6;
		colTo = 20;
		rowTo = 6;
		map.put("cellValue", "利尔达V100R100C20B657");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//单站整体考核是否通过
		col = 0;
		row = 7;
		colTo = 3;
		rowTo = 16;
		map.put("cellValue", "单站整体考核是否通过");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 4;
		row = 7;
		colTo = 6;
		rowTo = 16;
		map.put("cellValue", "");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//基站参数验证
		col = 7;
		row = 7;
		colTo = 8;
		rowTo = 7;
		map.put("cellValue", "基站参数验证");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		col = 9;
		row = 7;
		colTo = 10;
		rowTo = 7;
		map.put("cellValue", "是");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 11;
		row = 7;
		colTo = 20;
		rowTo = 7;
		map.put("cellValue", "如果异常，请说明");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		//小区工程参数验证
		col = 7;
		row = 8;
		colTo = 8;
		rowTo = 8;
		map.put("cellValue", "小区工程参数验证");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		col = 9;
		row = 8;
		colTo = 10;
		rowTo = 8;
		map.put("cellValue", "是");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 11;
		row =8;
		colTo = 20;
		rowTo = 8;
		map.put("cellValue", "如果异常，请说明");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		//小区网优参数验证
		col = 7;
		row = 9;
		colTo = 8;
		rowTo = 9;
		map.put("cellValue", "小区网优参数验证");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		col = 9;
		row = 9;
		colTo = 10;
		rowTo = 9;
		map.put("cellValue", "是");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 11;
		row = 9;
		colTo = 20;
		rowTo = 9;
		map.put("cellValue", "如果异常，请说明");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		//站点状态验证
		col = 7;
		row = 10;
		colTo = 8;
		rowTo = 10;
		map.put("cellValue", "站点状态验证");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		col = 9;
		row = 10;
		colTo = 10;
		rowTo = 10;
		map.put("cellValue", "是");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 11;
		row = 10;
		colTo = 20;
		rowTo = 10;
		map.put("cellValue", "如果异常，请说明");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		//附着性能验证
		col = 7;
		row = 11;
		colTo = 8;
		rowTo = 11;
		map.put("cellValue", "附着性能验证");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		col = 9;
		row = 11;
		colTo = 10;
		rowTo = 11;
		map.put("cellValue", "是");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 11;
		row = 11;
		colTo = 20;
		rowTo = 11;
		map.put("cellValue", "如果异常，请说明");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		//重选 性能验证（考察项）
		col = 7;
		row = 12;
		colTo = 8;
		rowTo = 12;
		map.put("cellValue", "重选性能验证（考察项）");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		col = 9;
		row = 12;
		colTo = 10;
		rowTo = 12;
		map.put("cellValue", "是");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 11;
		row = 12;
		colTo = 20;
		rowTo = 12;
		map.put("cellValue", "如果异常，请说明");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		//接入性能验证
		col = 7;
		row = 13;
		colTo = 8;
		rowTo = 13;
		map.put("cellValue", "接入性能验证");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		col = 9;
		row = 13;
		colTo = 10;
		rowTo = 13;
		map.put("cellValue", "是");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 11;
		row = 13;
		colTo = 20;
		rowTo = 13;
		map.put("cellValue", "如果异常，请说明");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		//Ping时延性能验证
		col = 7;
		row = 14;
		colTo = 8;
		rowTo = 14;
		map.put("cellValue", "Ping时延性能验证");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		col = 9;
		row = 14;
		colTo = 10;
		rowTo = 14;
		map.put("cellValue", "是");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 11;
		row = 14;
		colTo = 20;
		rowTo = 14;
		map.put("cellValue", "如果异常，请说明");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		//上行峰值速率测试
		col = 7;
		row = 15;
		colTo = 8;
		rowTo = 15;
		map.put("cellValue", "上行峰值速率测试");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		col = 9;
		row = 15;
		colTo = 10;
		rowTo = 15;
		map.put("cellValue", "是");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 11;
		row = 15;
		colTo = 20;
		rowTo = 15;
		map.put("cellValue", "如果异常，请说明");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		
		//下行峰值速率验证
		col = 7;
		row = 16;
		colTo = 8;
		rowTo = 16;
		map.put("cellValue", "下行峰值速率验证");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		col = 9;
		row = 16;
		colTo = 10;
		rowTo = 16;
		map.put("cellValue", "不具备测试条件");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 11;
		row = 16;
		colTo = 20;
		rowTo = 16;
		map.put("cellValue", "如果异常，请说明");
		map.put("fontWeight", (short)200);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		
		//检测测试内容
		col = 0;
		row = 17;
		colTo = 20;
		rowTo = 17;
		map.put("cellValue", "检测测试内容");
		map.put("fontWeight", (short)1000);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",HSSFColor.LIGHT_BLUE.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//No.1
		col = 0;
		row = 18;
		colTo = 0;
		rowTo = 18;
		map.put("cellValue", "No.1");
		map.put("fontWeight", (short)1000);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//参考验证
		col = 1;
		row = 18;
		colTo = 20;
		rowTo = 18;
		map.put("cellValue", "参考验证");
		map.put("fontWeight", (short)1000);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//检测项
		col = 0;
		row = 19;
		colTo = 3;
		rowTo = 20;
		map.put("cellValue", "检测项");
		map.put("fontWeight", (short)1000);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//设计值
		col = 4;
		row = 19;
		colTo = 3+listCellIndexResultTotal.size();
		rowTo = 19;
		map.put("cellValue", "设计值");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		for(int i=0;i<listCellIndexResultTotal.size();i++) {
			
		//listCellIndexResultTotal里有三条数据,可以获得小区id
		CellIndexResultTotal cellIndexResultTotal=listCellIndexResultTotal.get(i);
		//S1
		col = 4+i;
		row = 20;
		colTo = 4+i;
		rowTo = 20;
		map.put("cellValue", "S"+(i+1));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1设计值经度值
		col = 4+i;
		row = 21;
		colTo = 4+i;
		rowTo = 21;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(i).getLatitude()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//S1设计值纬度值
		col = 4+i;
		row = 22;
		colTo = 4+i;
		rowTo = 22;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(i).getLongitude()));//temporayWorkparamDomain2.getLongitude()
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//S1设计值TAC
		col = 4+i;
		row = 23;
		colTo = 4+i;
		rowTo = 23;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(i).getTac()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//S1设计值eNodeB ID
		col = 4+i;
		row = 24;
		colTo = 4+i;
		rowTo = 24;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(i).getStation_no()));//temporayWorkparamDomain2.getStation_No() 
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//S1设计值cellid
		col = 4+i;
		row = 25;
		colTo = 4+i;
		rowTo = 25;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(i).getCi()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1设计值频点
		col = 4+i;
		row = 26;
		colTo = 4+i;
		rowTo = 26;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(i).getDownlink()));//listCellIndexResultTotal.get(i).getFrequency()
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//S1设计值PCI
		col = 4+i;
		row = 27;
		colTo = 4+i;
		rowTo = 27;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(i).getPci()));//listCellIndexResultTotal.get(i).getPci()
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//S1设计值天线端口数
		col = 4+i;
		row = 28;
		colTo = 4+i;
		rowTo = 28;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(i).getAntenna_path()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1设计值RS POWER
		col = 4+i;
		row = 29;
		colTo = 4+i;
		rowTo = 29;
		map.put("cellValue", isNull(temporayWorkparamDomainList.get(i).getAntenna_path()+"*10W"));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1设计值天线挂高
		col = 4+i;
		row = 30;
		colTo = 4+i;
		rowTo = 30;
		map.put("cellValue", isNull(temporayWorkparamDomainList.get(i).getHeight()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1设计值方向角
		col = 4+i;
		row = 31;
		colTo = 4+i;
		rowTo = 31;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(i).getAzimuth()));//temporayWorkparamDomain2.getAzimuth() 
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1设计值总下倾角
		col = 4+i;
		row = 32;
		colTo = 4+i;
		rowTo = 32;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(i).getTotal_downtilt()));//temporayWorkparamDomain2.getTotal_downtilt() 
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1设计值预置电下倾
		col = 4+i;
		row = 33;
		colTo = 4+i;
		rowTo = 33;
		map.put("cellValue", isNull(temporayWorkparamDomainList.get(i).getElectrical_downtilt()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1设计值机械下倾
		col = 4+i;
		row = 34;
		colTo = 4+i;
		rowTo = 34;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(i).getMechanical_downtilt()));//temporayWorkparamDomain2.getMechanical_downtilt()
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
				//S1检测项
				col = 4+i;
				row = 35;
				colTo = 4+i;
				rowTo = 35;
				map.put("cellValue", "S"+(i+1));
				map.put("fontWeight", (short)400);	
				map.put("fontSize", (short) 10);
				map.put("rowHeight",(short)250);
				map.put("columnWidth",(int)3500);
				map.put("backgroundColour",	null);
				map.put("col", col);
				map.put("row", row);
				map.put("colTo", colTo);
				map.put("rowTo", rowTo);
				ExcelPoiUtil.createCell(wb, sheet1, map);
				
				//S1是否运行正常
				col = 4+i;
				row = 36;
				colTo = 4+i;
				rowTo = 36;
				map.put("cellValue", "是");
				map.put("fontWeight", (short)400);	
				map.put("fontSize", (short) 10);
				map.put("rowHeight",(short)250);
				map.put("columnWidth",(int)3500);
				map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
				map.put("col", col);
				map.put("row", row);
				map.put("colTo", colTo);
				map.put("rowTo", rowTo);
				ExcelPoiUtil.createCell(wb, sheet1, map);
				
				//S1是否有告警
				col = 4+i;
				row = 37;
				colTo = 4+i;
				rowTo = 37;
				map.put("cellValue", "否");
				map.put("fontWeight", (short)400);	
				map.put("fontSize", (short) 10);
				map.put("rowHeight",(short)250);
				map.put("columnWidth",(int)3500);
				map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
				map.put("col", col);
				map.put("row", row);
				map.put("colTo", colTo);
				map.put("rowTo", rowTo);
				ExcelPoiUtil.createCell(wb, sheet1, map);
				
				//S1测试点导频信号质量(RSRP&SINR)
				col = 4+i*6;
				row = 39;
				colTo = 9+i*6;
				rowTo = 39;
				map.put("cellValue", "S"+(i+1)+"测试点导频信号质量(RSRP&SINR)");
				map.put("fontWeight", (short)400);	
				map.put("fontSize", (short) 10);
				map.put("rowHeight",(short)250);
				map.put("backgroundColour",	null);
				map.put("LRAlignment",true);
				map.put("columnWidth ",(int)8000);
				map.put("col", col);
				map.put("row", row);
				map.put("colTo", colTo);
				map.put("rowTo", rowTo);
				ExcelPoiUtil.createCell(wb, sheet1, map);

				//RSRP
				col = 4+i*6;
				row = 40;
				colTo = 6+i*6;
				rowTo = 40;
				map.put("cellValue", "RSRP");
				map.put("fontWeight", (short)400);	
				map.put("fontSize", (short) 10);
				map.put("rowHeight",(short)250);
				map.put("backgroundColour",	null);
				map.put("LRAlignment",true);
				map.put("columnWidth ",(int)4000);
				map.put("col", col);
				map.put("row", row);
				map.put("colTo", colTo);
				map.put("rowTo", rowTo);
				ExcelPoiUtil.createCell(wb, sheet1, map);
				
				col = 4+i*6;
				row = 41;
				colTo = 6+i*6;
				rowTo = 42;
				map.put("cellValue",listCellIndexResultTotal.get(i).getWireless_RSRP());
				map.put("fontWeight", (short)400);	
				map.put("fontSize", (short) 10);
				map.put("rowHeight",(short)250);
				map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
				map.put("LRAlignment",true);
				map.put("columnWidth ",(int)4000);
				map.put("col", col);
				map.put("row", row);
				map.put("colTo", colTo);
				map.put("rowTo", rowTo);
				ExcelPoiUtil.createCell(wb, sheet1, map);
				
				//SINR 
				col = 7+i*6;
				row = 40;
				colTo = 9+i*6;
				rowTo = 40;
				map.put("cellValue", "SINR ");
				map.put("fontWeight", (short)400);	
				map.put("fontSize", (short) 10);
				map.put("rowHeight",(short)250);
				map.put("backgroundColour",	null);
				map.put("columnWidth ",(int)4000);
				map.put("LRAlignment",true);
				map.put("col", col);
				map.put("row", row);
				map.put("colTo", colTo);
				map.put("rowTo", rowTo);
				ExcelPoiUtil.createCell(wb, sheet1, map);
				
				col = 7+i*6;
				row = 41;
				colTo = 9+i*6;
				rowTo = 42;
				map.put("cellValue",listCellIndexResultTotal.get(i).getWireless_SINR());
				map.put("fontWeight", (short)400);	
				map.put("fontSize", (short) 10);
				map.put("rowHeight",(short)250);
				map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
				map.put("columnWidth ",(int)4000);
				map.put("LRAlignment",true);
				map.put("col", col);
				map.put("row", row);
				map.put("colTo", colTo);
				map.put("rowTo", rowTo);
				ExcelPoiUtil.createCell(wb, sheet1, map);
				
		}	
		
		
		//实测值
		col = 4+listCellIndexResultTotal.size();
		row = 19;
		colTo = 6+2*listCellIndexResultTotal.size()-3;
		rowTo = 19;
		map.put("cellValue", "实测值");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		for(int j=0;j<listCellIndexResultTotal.size();j++) {
			//listCellIndexResultTotal里有三条数据,可以获得小区id
			CellIndexResultTotal cellIndexResultTotal1= listCellIndexResultTotal.get(j);		
		//S1
		col = 4+listCellIndexResultTotal.size()+j;
		row = 20;
		colTo =  4+listCellIndexResultTotal.size()+j;
		rowTo = 20;
		map.put("cellValue", "S"+(1+j));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1实测值经度值
		col =  4+listCellIndexResultTotal.size()+j;
		row = 21;
		colTo = 4+listCellIndexResultTotal.size()+j;
		rowTo = 21;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(j).getLatitude()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1实测值纬度值
		col =  4+listCellIndexResultTotal.size()+j;
		row = 22;
		colTo =  4+listCellIndexResultTotal.size()+j;
		rowTo = 22;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(j).getLongitude()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1实测值TAC
		col = 4+listCellIndexResultTotal.size()+j;
		row = 23;
		colTo =  4+listCellIndexResultTotal.size()+j;
		rowTo = 23;
		map.put("cellValue", isNull(listCellIndexResultTotal.get(j).getTac()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1实测值eNodeB ID
		col =  4+listCellIndexResultTotal.size()+j;
		row = 24;
		colTo = 4+listCellIndexResultTotal.size()+j;
		rowTo = 24;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(j).getStation_no()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1实测值cellid
		col = 4+listCellIndexResultTotal.size()+j;
		row = 25;
		colTo = 4+listCellIndexResultTotal.size()+j;
		rowTo = 25;
		map.put("cellValue",listCellIndexResultTotal.get(j).getCellId());
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1实测值频点
		col = 4+listCellIndexResultTotal.size()+j;
		row = 26;
		colTo = 4+listCellIndexResultTotal.size()+j;
		rowTo = 26;
		map.put("cellValue", listCellIndexResultTotal.get(j).getFrequency());
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1实测值PCI
		col = 4+listCellIndexResultTotal.size()+j;
		row = 27;
		colTo = 4+listCellIndexResultTotal.size()+j;
		rowTo = 27;
		map.put("cellValue", listCellIndexResultTotal.get(j).getPci());
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1实测值天线端口数
		col = 4+listCellIndexResultTotal.size()+j;
		row = 28;
		colTo = 4+listCellIndexResultTotal.size()+j;
		rowTo = 28;
		map.put("cellValue", isNull(temporayWorkparamDomainList.get(j).getAntenna_path()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1实测值RS POWER
		col =  4+listCellIndexResultTotal.size()+j;
		row = 29;
		colTo = 4+listCellIndexResultTotal.size()+j;
		rowTo = 29;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(j).getAntenna_path()+"*10W"));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1实测值天线挂高
		col =  4+listCellIndexResultTotal.size()+j;
		row = 30;
		colTo =  4+listCellIndexResultTotal.size()+j;
		rowTo = 30;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(j).getHeight()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1实测值方向角
		col =  4+listCellIndexResultTotal.size()+j;
		row = 31;
		colTo =  4+listCellIndexResultTotal.size()+j;
		rowTo = 31;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(j).getAzimuth()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1实测值总下倾角
		col =  4+listCellIndexResultTotal.size()+j;
		row =32;
		colTo =  4+listCellIndexResultTotal.size()+j;
		rowTo = 32;
		map.put("cellValue", isNull(temporayWorkparamDomainList.get(j).getTotal_downtilt()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1实测值预置电下倾
		col = 4+listCellIndexResultTotal.size()+j;
		row =33;
		colTo =  4+listCellIndexResultTotal.size()+j;
		rowTo = 33;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(j).getElectrical_downtilt()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//S1实测值机械下倾
		col = 4+listCellIndexResultTotal.size()+j;
		row =34;
		colTo = 4+listCellIndexResultTotal.size()+j;
		rowTo = 34;
		map.put("cellValue",isNull(temporayWorkparamDomainList.get(j).getMechanical_downtilt()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		}
		//结论
		col = 7+2*listCellIndexResultTotal.size()-3;
		row = 19;
		colTo = 7+2*listCellIndexResultTotal.size()-3;
		rowTo = 20;
		map.put("cellValue", "结论");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 8+2*listCellIndexResultTotal.size()-3;
		row = 19;
		colTo = 12+2*listCellIndexResultTotal.size()-3;
		rowTo = 19;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
	
		col = 13+2*listCellIndexResultTotal.size()-3;
		row = 19;
		colTo = 17+2*listCellIndexResultTotal.size()-3;
		rowTo = 19;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		
		col = 8+2*listCellIndexResultTotal.size()-3;
		row = 20;
		colTo = 12+2*listCellIndexResultTotal.size()-3;
		rowTo = 20;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 13+2*listCellIndexResultTotal.size()-3;
		row = 20;
		colTo = 17+2*listCellIndexResultTotal.size()-3;
		rowTo = 20;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//基站参数
		col = 0;
		row = 21;
		colTo = 0;
		rowTo = 24;
		map.put("cellValue", "基站参数");
		map.put("fontWeight", (short)1000);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//经度
		col = 1;
		row = 21;
		colTo = 3;
		rowTo = 21;
		map.put("cellValue", "经度");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//经度结论值
		col = 7+2*listCellIndexResultTotal.size()-3;
		row = 21;
		colTo = 7+2*listCellIndexResultTotal.size()-3;
		rowTo = 21;
		map.put("cellValue", "一致");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 8+2*listCellIndexResultTotal.size()-3;
		row = 21;
		colTo = 17+2*listCellIndexResultTotal.size()-3;
		rowTo = 21;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//纬度
		col = 1;
		row = 22;
		colTo = 3;
		rowTo = 22;
		map.put("cellValue", "纬度");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//纬度结论值
		col = 7+2*listCellIndexResultTotal.size()-3;
		row = 22;
		colTo = 7+2*listCellIndexResultTotal.size()-3;
		rowTo = 22;
		map.put("cellValue", "一致");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 8+2*listCellIndexResultTotal.size()-3;
		row = 22;
		colTo = 17+2*listCellIndexResultTotal.size()-3;
		rowTo = 22;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);


		//TAC
		col = 1;
		row = 23;
		colTo = 3;
		rowTo = 23;
		map.put("cellValue", "TAC");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);


		
		col = 8+2*listCellIndexResultTotal.size()-3;
		row = 23;
		colTo = 17+2*listCellIndexResultTotal.size()-3;
		rowTo = 23;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);


		//eNodeB ID
		col = 1;
		row = 24;
		colTo = 3;
		rowTo = 24;
		map.put("cellValue", "eNodeB ID");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//eNodeB ID结论值
		col = 7+2*listCellIndexResultTotal.size()-3;
		row = 24;
		colTo = 7+2*listCellIndexResultTotal.size()-3;
		rowTo = 24;
		map.put("cellValue", "一致");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 8+2*listCellIndexResultTotal.size()-3;
		row = 24;
		colTo = 17+2*listCellIndexResultTotal.size()-3;
		rowTo = 24;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		
		//小区参数
		col = 0;
		row = 25;
		colTo = 0;
		rowTo = 28;
		map.put("cellValue", "小区参数");
		map.put("fontWeight", (short)1000);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//cellid
		col = 1;
		row = 25;
		colTo = 3;
		rowTo = 25;
		map.put("cellValue", "cellid");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

	
		for(int a=0;a<temporayWorkparamDomainList.size();a++){
			//TAC结论值
			if(temporayWorkparamDomainList.get(a).getTac().equals(listCellIndexResultTotal.get(a).getTac())||
					temporayWorkparamDomainList.get(a).getTac()==listCellIndexResultTotal.get(a).getTac()) {
				System.out.println("一致");
				col = 7+2*listCellIndexResultTotal.size()-3;
				row = 23;
				colTo = 7+2*listCellIndexResultTotal.size()-3;
				rowTo = 23;
				map.put("cellValue", "一致");
				map.put("fontWeight", (short)400);	
				map.put("fontSize", (short) 10);
				map.put("rowHeight",(short)250);
				map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
				map.put("col", col);
				map.put("row", row);
				map.put("colTo", colTo);
				map.put("rowTo", rowTo);
				ExcelPoiUtil.createCell(wb, sheet1, map);
			}else {
				col = 7+2*listCellIndexResultTotal.size()-3;
				row = 23;
				colTo = 7+2*listCellIndexResultTotal.size()-3;
				rowTo = 23;
				map.put("cellValue", "不一致");
				map.put("fontWeight", (short)400);	
				map.put("fontSize", (short) 10);
				map.put("rowHeight",(short)250);
				map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
				map.put("col", col);
				map.put("row", row);
				map.put("colTo", colTo);
				map.put("rowTo", rowTo);
				ExcelPoiUtil.createCell(wb, sheet1, map);
			}

			//cellid结论值
			if(temporayWorkparamDomainList.get(a).getCi()==listCellIndexResultTotal.get(a).getCellId()||temporayWorkparamDomainList.get(a).getCi().equals(listCellIndexResultTotal.get(a).getCellId())){
					col = 7+2*listCellIndexResultTotal.size()-3;
					row = 25;
					colTo = 7+2*listCellIndexResultTotal.size()-3;
					rowTo = 25;
					map.put("cellValue", "一致");
					map.put("fontWeight", (short)400);	
					map.put("fontSize", (short) 10);
					map.put("rowHeight",(short)250);
					map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
					map.put("col", col);
					map.put("row", row);
					map.put("colTo", colTo);
					map.put("rowTo", rowTo);
					ExcelPoiUtil.createCell(wb, sheet1, map);
			}else{
			col = 7+2*listCellIndexResultTotal.size()-3;
			row = 25;
			colTo = 7+2*listCellIndexResultTotal.size()-3;
			rowTo = 25;
			map.put("cellValue", "不一致");
			map.put("fontWeight", (short)400);	
			map.put("fontSize", (short) 10);
			map.put("rowHeight",(short)250);
			map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
			map.put("col", col);
			map.put("row", row);
			map.put("colTo", colTo);
			map.put("rowTo", rowTo);
			ExcelPoiUtil.createCell(wb, sheet1, map);
		}
			//频点结论值
			if(temporayWorkparamDomainList.get(a).getDownlink()==listCellIndexResultTotal.get(a).getFrequency()||temporayWorkparamDomainList.get(a).getDownlink().equals(listCellIndexResultTotal.get(a).getFrequency())){
				col = 7+2*listCellIndexResultTotal.size()-3;
				row = 26;
				colTo = 7+2*listCellIndexResultTotal.size()-3;
				rowTo = 26;
				map.put("cellValue", "一致");
				map.put("fontWeight", (short)400);	
				map.put("fontSize", (short) 10);
				map.put("rowHeight",(short)250);
				map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
				map.put("col", col);
				map.put("row", row);
				map.put("colTo", colTo);
				map.put("rowTo", rowTo);
				ExcelPoiUtil.createCell(wb, sheet1, map);
			}else{
				col = 7+2*listCellIndexResultTotal.size()-3;
				row = 26;
				colTo = 7+2*listCellIndexResultTotal.size()-3;
				rowTo = 26;
				map.put("cellValue", "不一致");
				map.put("fontWeight", (short)400);	
				map.put("fontSize", (short) 10);
				map.put("rowHeight",(short)250);
				map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
				map.put("col", col);
				map.put("row", row);
				map.put("colTo", colTo);
				map.put("rowTo", rowTo);
				ExcelPoiUtil.createCell(wb, sheet1, map);
			}
			//PCI结论值
			if(temporayWorkparamDomainList.get(a).getPci()==listCellIndexResultTotal.get(a).getPci()||temporayWorkparamDomainList.get(a).getPci().equals(listCellIndexResultTotal.get(a).getPci())){
				col = 7+2*listCellIndexResultTotal.size()-3;
				row = 27;
				colTo = 7+2*listCellIndexResultTotal.size()-3;
				rowTo = 27;
				map.put("cellValue", "一致");
				map.put("fontWeight", (short)400);	
				map.put("fontSize", (short) 10);
				map.put("rowHeight",(short)250);
				map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
				map.put("col", col);
				map.put("row", row);
				map.put("colTo", colTo);
				map.put("rowTo", rowTo);
				ExcelPoiUtil.createCell(wb, sheet1, map);
			}else{
				col = 7+2*listCellIndexResultTotal.size()-3;
				row = 27;
				colTo = 7+2*listCellIndexResultTotal.size()-3;
				rowTo = 27;
				map.put("cellValue", "不一致");
				map.put("fontWeight", (short)400);	
				map.put("fontSize", (short) 10);
				map.put("rowHeight",(short)250);
				map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
				map.put("col", col);
				map.put("row", row);
				map.put("colTo", colTo);
				map.put("rowTo", rowTo);
				ExcelPoiUtil.createCell(wb, sheet1, map);
			}

		}


		col = 8+2*listCellIndexResultTotal.size()-3;
		row = 25;
		colTo = 17+2*listCellIndexResultTotal.size()-3;
		rowTo = 25;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//频点
		col = 1;
		row = 26;
		colTo = 3;
		rowTo = 26;
		map.put("cellValue", "频点");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		col = 8+2*listCellIndexResultTotal.size()-3;
		row = 26;
		colTo = 17+2*listCellIndexResultTotal.size()-3;
		rowTo = 26;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);


		//PCI
		col = 1;
		row = 27;
		colTo = 3;
		rowTo = 27;
		map.put("cellValue", "PCI");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		col = 8+2*listCellIndexResultTotal.size()-3;
		row = 27;
		colTo = 17+2*listCellIndexResultTotal.size()-3;
		rowTo = 27;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//天线端口数
		col = 1;
		row = 28;
		colTo = 3;
		rowTo = 28;
		map.put("cellValue", "天线端口数");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//天线端口数结论值
		col = 7+2*listCellIndexResultTotal.size()-3;
		row = 28;
		colTo = 7+2*listCellIndexResultTotal.size()-3;
		rowTo = 28;
		map.put("cellValue", "一致");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 8+2*listCellIndexResultTotal.size()-3;
		row = 28;
		colTo = 17+2*listCellIndexResultTotal.size()-3;
		rowTo = 28;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//小区网优参数
		col = 0;
		row = 29;
		colTo = 0;
		rowTo = 34;
		map.put("cellValue", "小区网优参数");
		map.put("fontWeight", (short)1000);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//RS POWER
		col = 1;
		row = 29;
		colTo = 3;
		rowTo = 29;
		map.put("cellValue", "RS POWER");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//RS POWER结论值
		col = 7+2*listCellIndexResultTotal.size()-3;
		row = 29;
		colTo = 7+2*listCellIndexResultTotal.size()-3;
		rowTo = 29;
		map.put("cellValue", "一致");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 8+2*listCellIndexResultTotal.size()-3;
		row = 29;
		colTo = 17+2*listCellIndexResultTotal.size()-3;
		rowTo = 29;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//天线挂高
		col = 1;
		row = 30;
		colTo = 3;
		rowTo = 30;
		map.put("cellValue", "天线挂高");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//天线挂高结论值
		col = 7+2*listCellIndexResultTotal.size()-3;
		row = 30;
		colTo = 7+2*listCellIndexResultTotal.size()-3;
		rowTo = 30;
		map.put("cellValue", "一致");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 8+2*listCellIndexResultTotal.size()-3;
		row = 30;
		colTo = 17+2*listCellIndexResultTotal.size()-3;
		rowTo = 30;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);


		//方向角
		col = 1;
		row = 31;
		colTo = 3;
		rowTo = 31;
		map.put("cellValue", "方向角");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//方向角结论值
		col = 7+2*listCellIndexResultTotal.size()-3;
		row = 31;
		colTo = 7+2*listCellIndexResultTotal.size()-3;
		rowTo = 31;
		map.put("cellValue", "一致");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 8+2*listCellIndexResultTotal.size()-3;
		row = 31;
		colTo = 17+2*listCellIndexResultTotal.size()-3;
		rowTo = 31;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//总下倾角
		col = 1;
		row = 32;
		colTo = 3;
		rowTo = 32;
		map.put("cellValue", "总下倾角");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//总下倾角结论值
		col = 7+2*listCellIndexResultTotal.size()-3;
		row = 32;
		colTo = 7+2*listCellIndexResultTotal.size()-3;
		rowTo = 32;
		map.put("cellValue", "一致");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 8+2*listCellIndexResultTotal.size()-3;
		row = 32;
		colTo = 17+2*listCellIndexResultTotal.size()-3;
		rowTo = 32;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		

		//预置电下倾
		col = 1;
		row = 33;
		colTo = 3;
		rowTo = 33;
		map.put("cellValue", "预置电下倾");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//预置电下倾结论值
		col = 7+2*listCellIndexResultTotal.size()-3;
		row = 33;
		colTo = 7+2*listCellIndexResultTotal.size()-3;
		rowTo = 33;
		map.put("cellValue", "一致");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 8+2*listCellIndexResultTotal.size()-3;
		row = 33;
		colTo = 17+2*listCellIndexResultTotal.size()-3;
		rowTo = 33;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);


		//机械下倾
		col = 1;
		row = 34;
		colTo = 3;
		rowTo = 34;
		map.put("cellValue", "机械下倾");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//机械下倾结论值
		col = 7+2*listCellIndexResultTotal.size()-3;
		row = 34;
		colTo = 7+2*listCellIndexResultTotal.size()-3;
		rowTo = 34;
		map.put("cellValue", "一致");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 8+2*listCellIndexResultTotal.size()-3;
		row = 34;
		colTo = 17+2*listCellIndexResultTotal.size()-3;
		rowTo = 34;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//站点状态
		col = 0;
		row = 35;
		colTo = 0;
		rowTo = 37;
		map.put("cellValue", "站点状态");
		map.put("fontWeight", (short)1000);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//检测项
		col = 1;
		row = 35;
		colTo = 3;
		rowTo = 35;
		map.put("cellValue", "检测项");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		////////////////////////
		col = 4+listCellIndexResultTotal.size();
		row = 35;
		colTo = 17+listCellIndexResultTotal.size();
		rowTo = 35;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//是否运行正常
		col = 1;
		row = 36;
		colTo = 3;
		rowTo = 36;
		map.put("cellValue", "是否运行正常");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		

		//说明：按照入网流程，交维时由维护部激活，运行正常指可以正常激活单验。
		col = 4+listCellIndexResultTotal.size();
		row = 36;
		colTo = 17+listCellIndexResultTotal.size();
		rowTo = 36;
		map.put("cellValue", "说明：按照入网流程，交维时由维护部激活，运行正常指可以正常激活单验。");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",null);
		map.put("LRAlignment", false);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//是否有告警
		col = 1;
		row = 37;
		colTo = 3;
		rowTo = 37;
		map.put("cellValue", "是否有告警");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("LRAlignment",true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col = 4+listCellIndexResultTotal.size();
		row = 37;
		colTo = 17+listCellIndexResultTotal.size();
		rowTo = 37;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)3500);
		map.put("backgroundColour",null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//No.2
		col = 0;
		row = 38;
		colTo = 0;
		rowTo = 38;
		map.put("cellValue", "No.2");
		map.put("fontWeight", (short)1000);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth", (int)4000);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//性能验证
		col = 1;
		row = 38;
		colTo = 20;
		rowTo = 38;
		map.put("cellValue", "性能验证");
		map.put("fontWeight", (short)1000);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//TM3 alternative
		col = 0;
		row = 39;
		colTo = 0;
		rowTo = 49;
		map.put("cellValue", "TM3 alternative");
		map.put("fontWeight", (short)1000);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//小区
		col = 1;
		row = 39;
		colTo = 3;
		rowTo = 40;
		map.put("cellValue", "小区");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("LRAlignment",true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//检测项
		col = 1;
		row = 41;
		colTo = 3;
		rowTo = 43;
		map.put("cellValue", "检测项");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("backgroundColour",	null);
		map.put("LRAlignment",true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		

		
//		//S2测试点导频信号质量(RSRP&SINR)
//		col = 10;
//		row = 39;
//		colTo = 15;
//		rowTo = 39;
//		map.put("cellValue", "S2测试点导频信号质量(RSRP&SINR)");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("backgroundColour",	null);
//		map.put("LRAlignment",true);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//
//		//RSRP
//		col = 10;
//		row = 40;
//		colTo = 12;
//		rowTo = 40;
//		map.put("cellValue", "RSRP");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("backgroundColour",	null);
//		map.put("LRAlignment",true);
//		map.put("columnWidth ",(int)4000);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//		
//		col =10;
//		row = 41;
//		colTo =12;
//		rowTo = 42;
//		map.put("cellValue", "");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("LRAlignment",true);
//		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//		
//		//SINR 
//		col = 13;
//		row = 40;
//		colTo = 15;
//		rowTo = 40;
//		map.put("cellValue", "SINR ");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("LRAlignment",true);
//		map.put("rowHeight",(short)250);
//		map.put("backgroundColour",	null);
//		map.put("columnWidth ",(int)4000);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//		
//		col = 13;
//		row = 41;
//		colTo = 15;
//		rowTo = 42;
//		map.put("cellValue", "");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("LRAlignment",true);
//		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//	
//	/////////////////////////////////
//		//S3测试点导频信号质量(RSRP&SINR)
//		col =16;
//		row = 39;
//		colTo = 20;
//		rowTo = 39;
//		map.put("cellValue", "S3测试点导频信号质量(RSRP&SINR)");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("backgroundColour",	null);
//		map.put("LRAlignment",true);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//
//		//RSRP
//		col = 16;
//		row = 40;
//		colTo = 18;
//		rowTo = 40;
//		map.put("cellValue", "RSRP");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("backgroundColour",	null);
//		map.put("LRAlignment",true);
//		map.put("columnWidth ",(int)4000);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//		
//		col =16;
//		row = 41;
//		colTo =18;
//		rowTo = 42;
//		map.put("cellValue", "");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("LRAlignment",true);
//		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//		
//		//SINR 
//		col = 19;
//		row = 40;
//		colTo = 20;
//		rowTo = 40;
//		map.put("cellValue", "SINR ");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("LRAlignment",true);
//		map.put("rowHeight",(short)250);
//		map.put("backgroundColour",	null);
//		map.put("columnWidth ",(int)4000);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//		
//		col = 19;
//		row = 41;
//		colTo = 20;
//		rowTo = 42;
//		map.put("cellValue", "");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("LRAlignment",true);
//		map.put("backgroundColour",	HSSFColor.SEA_GREEN.index);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//站点各小区attach成功率
		col =1;
		row = 44;
		colTo = 3;
		rowTo = 44;
		map.put("cellValue", "站点各小区attach成功率");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("LRAlignment",true);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//站点各小区重选成功率
		col =1;
		row = 45;
		colTo = 3;
		rowTo = 45;
		map.put("cellValue", "站点各小区重选成功率");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("LRAlignment",true);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//RRC连接成功率
		col =1;
		row = 46;
		colTo = 3;
		rowTo = 46;
		map.put("cellValue", "RRC连接成功率");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("LRAlignment",true);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//PING时延测试
		col =1;
		row = 47;
		colTo = 3;
		rowTo = 47;
		map.put("cellValue", "PING时延测试");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("LRAlignment",true);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//MAC层上行吞吐率
		col =1;
		row = 48;
		colTo = 3;
		rowTo = 48;
		map.put("cellValue", "MAC层上行吞吐率");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("LRAlignment",true);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//单用户下行吞吐率
		col =1;
		row = 49;
		colTo = 3;
		rowTo = 49;
		map.put("cellValue", "单用户下行吞吐率");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("LRAlignment",true);
		map.put("backgroundColour",	null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		for(int i=0;i<listCellIndexResultTotal.size();i++) {
			CellIndexResultTotal cellIndexResultTotal=listCellIndexResultTotal.get(i);
	
		//性能验证S1
		col = 4+(i*6);
		row = 43;
		colTo = 9+(i*6);
		rowTo = 43;
		map.put("cellValue", "S"+(i+1));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("LRAlignment",true);
		map.put("backgroundColour",null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//站点各小区attach成功率S1
		col =4+(i*6);
		row = 44;
		colTo = 9+(i*6);
		rowTo = 44;
		
		map.put("cellValue",isNull(listCellIndexResultTotal.get(i).getA_SuccessRatio()+""));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("LRAlignment",true);
		map.put("backgroundColour",HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//站点各小区重选成功率S1
		col =4+(i*6);
		row = 45;
		colTo = 9+(i*6);
		rowTo = 45;
		map.put("cellValue", isNull(listCellIndexResultTotal.get(i).getC_ReElectionRatio()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("LRAlignment",true);
		map.put("backgroundColour",HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);


		//RRC连接成功率S1
		col =4+(i*6);
		row = 46;
		colTo = 9+(i*6);
		rowTo = 46;
		map.put("cellValue", isNull(listCellIndexResultTotal.get(i).getC_ReElectionRatio()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("LRAlignment",true);
		map.put("backgroundColour",HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//PING时延测试S1
		col =4+(i*6);
		row = 47;
		colTo = 9+(i*6);
		rowTo = 47;
		map.put("cellValue",isNull(listCellIndexResultTotal.get(i).getP_Delay()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("LRAlignment",true);
		map.put("backgroundColour",HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);

		//MAC层上行吞吐率S1
		col =4+(i*6);
		row = 48;
		colTo =9+(i*6);
		rowTo = 48;
		map.put("cellValue",isNull(listCellIndexResultTotal.get(i).getUdp_UpRate()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("LRAlignment",true);
		map.put("backgroundColour",HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		//单用户下行吞吐率S1
		col =4+(i*6);
		row = 49;
		colTo = 9+(i*6);
		rowTo = 49;
		map.put("cellValue",isNull(listCellIndexResultTotal.get(i).getUdp_DownRate()));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("LRAlignment",true);
		map.put("backgroundColour",HSSFColor.SEA_GREEN.index);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		}
//		//性能验证S2
//		col =10;
//		row = 43;
//		colTo = 15;
//		rowTo = 43;
//		map.put("cellValue", "S2");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("LRAlignment",true);
//		map.put("backgroundColour",	null);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//
//		//站点各小区attach成功率S2
//		col =10;
//		row = 44;
//		colTo = 15;
//		rowTo = 44;
//		map.put("cellValue", "");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("LRAlignment",true);
//		map.put("backgroundColour",HSSFColor.SEA_GREEN.index);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//		
//
//		//站点各小区重选成功率S2
//		col =10;
//		row = 45;
//		colTo = 15;
//		rowTo = 45;
//		map.put("cellValue", "");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("LRAlignment",true);
//		map.put("backgroundColour",HSSFColor.SEA_GREEN.index);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//
//		//RRC连接成功率S2
//		col =10;
//		row = 46;
//		colTo = 15;
//		rowTo = 46;
//		map.put("cellValue", "");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("LRAlignment",true);
//		map.put("backgroundColour",HSSFColor.SEA_GREEN.index);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//
//		//PING时延测试S2
//		col =10;
//		row = 47;
//		colTo = 15;
//		rowTo = 47;
//		map.put("cellValue", "");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("LRAlignment",true);
//		map.put("backgroundColour",HSSFColor.SEA_GREEN.index);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//		
//		//MAC层上行吞吐率S2
//		col =10;
//		row = 48;
//		colTo =15;
//		rowTo = 48;
//		map.put("cellValue", listCellIndexResultTotal.get(1).getUdp_DownRate());
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("LRAlignment",true);
//		map.put("backgroundColour",HSSFColor.SEA_GREEN.index);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//
//		//单用户下行吞吐率S2
//		col =10;
//		row = 49;
//		colTo = 15;
//		rowTo = 49;
//		map.put("cellValue", "");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("LRAlignment",true);
//		map.put("backgroundColour",HSSFColor.SEA_GREEN.index);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//		
//		//性能验证S3
//		col =16;
//		row = 43;
//		colTo = 20;
//		rowTo = 43;
//		map.put("cellValue", "S3");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("LRAlignment",true);
//		map.put("backgroundColour",	null);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//
//		//MAC层上行吞吐率S3
//		col =16;
//		row = 48;
//		colTo = 20;
//		rowTo = 48;
//		map.put("cellValue", "");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("LRAlignment",true);
//		map.put("backgroundColour",HSSFColor.SEA_GREEN.index);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//
//		//站点各小区attach成功率S3
//		col =16;
//		row = 44;
//		colTo = 20;
//		rowTo = 44;
//		map.put("cellValue", "");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("LRAlignment",true);
//		map.put("backgroundColour",HSSFColor.SEA_GREEN.index);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//
//		//站点各小区重选成功率S3
//		col =16;
//		row = 45;
//		colTo = 20;
//		rowTo = 45;
//		map.put("cellValue", "");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("LRAlignment",true);
//		map.put("backgroundColour",HSSFColor.SEA_GREEN.index);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//
//		//RRC连接成功率S3
//		col =16;
//		row = 46;
//		colTo = 20;
//		rowTo = 46;
//		map.put("cellValue", "");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("LRAlignment",true);
//		map.put("backgroundColour",HSSFColor.SEA_GREEN.index);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//
//		//PING时延测试S3
//		col =16;
//		row = 47;
//		colTo = 20;
//		rowTo = 47;
//		map.put("cellValue", "");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("LRAlignment",true);
//		map.put("backgroundColour",HSSFColor.SEA_GREEN.index);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
//
//		//单用户下行吞吐率S3
//		col =16;
//		row = 49;
//		colTo = 20;
//		rowTo = 49;
//		map.put("cellValue", "");
//		map.put("fontWeight", (short)400);	
//		map.put("fontSize", (short) 10);
//		map.put("rowHeight",(short)250);
//		map.put("LRAlignment",true);
//		map.put("backgroundColour",HSSFColor.SEA_GREEN.index);
//		map.put("col", col);
//		map.put("row", row);
//		map.put("colTo", colTo);
//		map.put("rowTo", rowTo);
//		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		//备注
		col =0;
		row = 50;
		colTo = 0;
		rowTo = 50;
		map.put("cellValue", "备注");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("LRAlignment",true);
		map.put("backgroundColour",null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		
		col =1;
		row = 50;
		colTo = 20;
		rowTo = 50;
		map.put("cellValue", "");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("LRAlignment",true);
		map.put("backgroundColour",null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet1, map);
		}
	
	
	private void createExcelEffectDiagram(HSSFWorkbook wb, HSSFSheet sheet2,LogCXDomain logCXDomain,List<TemporayWorkparamDomain2> temporayWorkparamDomainList) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Map map = new HashMap();
		int col = 0;// 列
		int row = 0;// 行
		int colTo =0;
		int rowTo = 0;
		
		//覆盖效果图：
		col =0;
		row = 0;
		colTo = 0;
		rowTo = 0;
		map.put("cellValue", "覆盖效果图：");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("columnWidth",(int)13000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet2, map);
		
		//站名：长寿大楼HL1H/长寿大楼HG01H/长寿大楼HB01H：
		col =0;
		row = 1;
		colTo = 0;
		rowTo = 1;
		map.put("cellValue", "站名：NB-IOT"+isNull(temporayWorkparamDomainList.get(0).getStation_name())+"单站核查优化测试报告_移动_");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet2, map);
		
		//日期：2018/01/08
		col =0;
		row = 2;
		colTo = 0;
		rowTo = 2;
		map.put("cellValue",  isNull(df.format(df.parse(logCXDomain.getTestDate()))));
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet2, map);
		
		//DT RSRP分布 路测地图
		col =0;
		row =6;
		colTo = 0;
		rowTo = 25;
		map.put("cellValue", "DT RSRP分布图 路测地图");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);
		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet2, map);
		
		//RSRP coverage map
		//RSRP分布图 
		col =1;
		row =6;
		colTo =17;
		rowTo = 6;
		map.put("cellValue", "RSRP coverage map\r\n" + 
				"RSRP分布图 ");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet2, map);
		//图片
		col =1;
		row =7;
		colTo =17;
		rowTo = 25;
		map.put("cellValue", "RSRP coverage map\r\n" + 
				"RSRP分布图 ");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet2, map);
			
		//DT SINR分布图 路测地图
		col =0;
		row =26;
		colTo = 0;
		rowTo = 47;
		map.put("cellValue", "DT SINR分布图\r\n" + 
				"路测地图");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet2, map);

		//SINR coverage map
		//SINR分布图 
		col =1;
		row =26;
		colTo =17;
		rowTo = 26;
		map.put("cellValue", "SINR coverage map\r\n" + 
				"SINR分布图 ");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet2, map);
		//图片
		col =1;
		row =27;
		colTo =17;
		rowTo = 47;
		map.put("cellValue", "RSRP coverage map\r\n" + 
				"RSRP分布图 ");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet2, map);
		
		//站内重选路测地图
		col =0;
		row =48;
		colTo =0;
		rowTo = 69;
		map.put("cellValue", "站内重选路测地图");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet2, map);

		//站内重选 
		col =1;
		row =48;
		colTo =17;
		rowTo = 48;
		map.put("cellValue", "站内重选");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet2, map);
		//图片
		col =1;
		row =49;
		colTo =17;
		rowTo = 69;
		map.put("cellValue", "RSRP coverage map\r\n" + 
				"RSRP分布图 ");
		map.put("fontWeight", (short)400);	
		map.put("fontSize", (short) 10);
		map.put("rowHeight",(short)250);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet2, map);

	}
	
	private String isNull(String str){
		if(str==null||str==""||str.equals("")||str.equals(null)){
			return "";
		}else{
			return str;
		}
	}
}
