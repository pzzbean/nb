package com.ibase.web.log.util.excel;
/**
 * 中国移动Excel方法
 */

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
import com.ibase.web.log.service.LogService;
import com.ibase.web.log.service.impl.LogServiceImpl;
import com.ibase.web.log.util.I18nUtil;
import com.ibase.web.plane.domain.Plane;
import com.ibase.web.roadtest.domain.CellIndexResultTotal;
import com.ibase.web.workparam.domain.WorkParamDomain;
import com.ibase.web.workparam_in.domain.WorkParam_inDomain;

public class CMCC_Excel {

	public void createExcel2_in(OutputStream out, Plane plane, List<WorkParam_inDomain> wordParam, List<LogDomain> log,
			List<String> adList, String lang,List<LogDomain> logList) throws Exception {
		// 创建Excel工作薄
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建一个sheet（可以创建多个sheet,一个工作薄可以有多个sheet
		HSSFSheet sheet0 = wb.createSheet(Map.get("reportPage"));//报告页
		HSSFSheet sheet1 = wb.createSheet(Map.get("PerResults"));//网优工程师测试表格
		HSSFSheet sheet2 = wb.createSheet(Map.get("AttachedPic"));//效果图
		HSSFSheet sheet3 = wb.createSheet(Map.get("Problems"));//问题汇总
		createExcelSubclass_in(wb, sheet0, plane, wordParam, log,lang);
		createExcelNetworkOptimizationTest(wb, sheet1,lang,logList);
		createExcelSummaryOfproblems(wb, sheet3,lang);
		int row = 8;
		for (String adderss : adList) {
			ExcelPoiUtil.createImage(out, wb, sheet2, adderss,row);
			row+=30;
		}

		// 写入数据
		wb.write(out);
		// 关闭文件
		wb.close();

	}

	public void createExcel2(OutputStream out, Plane plane, List<WorkParamDomain> wordParam, List<LogDomain> log,
			List<String> adList, String lang,List<LogDomain> logList) throws Exception {
		System.out.println(wordParam);
		
		// 创建Excel工作薄
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建一个sheet（可以创建多个sheet,一个工作薄可以有多个sheet
		HSSFSheet sheet0 = wb.createSheet(Map.get("reportPage"));//报告页
		HSSFSheet sheet1 = wb.createSheet(Map.get("PerResults"));//网优工程师测试表格
		HSSFSheet sheet2 = wb.createSheet(Map.get("AttachedPic"));//效果图
		HSSFSheet sheet3 = wb.createSheet(Map.get("Problems"));//问题汇总
		createExcelSubclass(wb, sheet0, plane, wordParam, log,lang);
		createExcelNetworkOptimizationTest(wb, sheet1,lang,logList);
		createExcelSummaryOfproblems(wb, sheet3,lang);	
		int row = 8;
		for (String adderss : adList) {
			ExcelPoiUtil.createImage(out, wb, sheet2, adderss,row);
			row+=30;
		}
		// 写入数据
		wb.write(out);
		// 关闭文件
		wb.close();

	}

	public void createExcelSubclass_in(HSSFWorkbook wb, HSSFSheet sheet, Plane plane,
			List<WorkParam_inDomain> wordParam_in, List<LogDomain> logList, String lang) throws Exception {
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		Map map = new HashMap();

		int col = 0;// 列
		int row = 0;// 行
		int colTo = 14;
		int rowTo = 0;

		col = 0;
		row = row;
		colTo = 14;
		rowTo = row;
		//NB-IOT单站点验证报告
		map.put("cellValue", Map.get("NB-IOTSS"));
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 20);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", (short) 1300);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 0;
		row = row + 1;
		colTo = 18;
		rowTo = row;
		
		map.put("cellValue", "");
		map.put("rowHeight", (short) 200);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 基站描述
		rowTo = stationDesc(wb, sheet, (WorkParam_inDomain) wordParam_in.get(0), col, row, colTo, rowTo, map,lang);

		// 参数验证
		col = 0;
		row = rowTo + 1;
		colTo = 18;
		rowTo = row;
		map.put("cellValue",Map.get("ParCheck"));
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_THICK);
		map.put("borderRight", HSSFCellStyle.BORDER_THICK);
		map.put("borderBottom", HSSFCellStyle.BORDER_THICK);
		map.put("borderLeft", HSSFCellStyle.BORDER_THICK);

		map.put("fontCenter", false);
		map.put("columnWidth", null);
		map.put("rowHeight", (short) 400);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 0;
		row = row + 1;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("map", null);
		map.put("borderTop", null);
		map.put("borderRight", null);
		map.put("borderBottom", null);
		map.put("borderLeft", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 基站参数
		rowTo = Stationparam(wb, sheet, (WorkParam_inDomain) wordParam_in.get(0), col, row, colTo, rowTo, map,lang,logList);
		// 小区参数（工程）
		rowTo = cellParamEngineering_in(wb, sheet, wordParam_in, col, row, colTo, rowTo, map,lang,logList);
		// 小区参数（网优）
		rowTo = cellParamNetwork_in(wb, sheet, wordParam_in, col, row, colTo, rowTo, map,lang,logList);

		// 功能验证
		col = 0;
		row = rowTo + 1;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", Map.get("PerCheck"));
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_THICK);
		map.put("borderRight", HSSFCellStyle.BORDER_THICK);
		map.put("borderBottom", HSSFCellStyle.BORDER_THICK);
		map.put("borderLeft", HSSFCellStyle.BORDER_THICK);

		map.put("fontCenter", false);
		map.put("columnWidth", null);
		map.put("rowHeight", (short) 400);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 业务验证
		rowTo = BusinessVerification(wb, sheet, logList, col, row, colTo, rowTo, map,lang);
		// 验证结论
		rowTo = VerificationConclusion(wb, sheet, logList, col, rowTo, colTo, rowTo, map,lang);
		// 工程师类型
		rowTo = EngineerDesc(wb, sheet, plane, col, rowTo, colTo, rowTo, map,lang);

	}

	public void createExcelNetworkOptimizationTest(HSSFWorkbook wb, HSSFSheet sheet3, String lang,List<LogDomain> logList) throws Exception {
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		Map map = new HashMap();

		int col = 0;// 列
		int row = 0;// 行
		int colTo = 25;
		int rowTo = 0;
		//N940100宁波海曙宁波档案馆NB-IoT
		map.put("cellValue",Map.get("NB-IoT"));
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 14);
		map.put("borderTop", null);
		map.put("borderRight", null);
		map.put("borderBottom", null);
		map.put("borderLeft", null);
		map.put("map", map);
		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", (short) 500);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row + 1;
		rowTo = row;
		col = 0;
		colTo = col;
		//站名:
		map.put("cellValue",Map.get("SiteName"));
		map.put("fontCenter", false);
		map.put("LRAlignment", false);
		map.put("TBAlignment", false);
		map.put("fontSize", (short) 10);

		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 1;
		colTo = col + 5;
		map.put("cellValue", " ");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 6;
		colTo = col;
		//站号:
		map.put("cellValue",Map.get("SiteId"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", null);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 1;
		colTo = col + 1;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 2;
		colTo = 25;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", null);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row + 1;
		rowTo = row;
		col = 0;
		colTo = col;
		//日期:
		map.put("cellValue",Map.get("Date"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", null);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 1;
		colTo = col + 1;
		map.put("cellValue", " ");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 2;
		colTo = col + 1;
		//测试手机型号:
		map.put("cellValue",Map.get("CellPhoneT"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", null);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 2;
		colTo = col + 1;
		map.put("cellValue", " ");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 2;
		colTo = col + 1;
		//测试手机号码1:
		map.put("cellValue",Map.get("Telephone1"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", null);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 2;
		colTo = col + 1;
		map.put("cellValue", " ");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 2;
		colTo = col + 1;
		//测试手机号码2:
		map.put("cellValue",Map.get("Telephone2"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", null);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 2;
		colTo = col + 1;
		map.put("cellValue", " ");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 2;
		colTo = col + 1;
		//优化工程师:
		map.put("cellValue",Map.get("EngineerName"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", null);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 2;
		colTo = col + 1;
		map.put("cellValue", " ");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 2;
		colTo = 25;
		map.put("cellValue", " ");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", null);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row + 1;
		rowTo = row;
		col = 0;
		colTo = col + 1;
		//软件版本:
		map.put("cellValue",Map.get("Version"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", null);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 2;
		colTo = col + 1;
		map.put("cellValue", " ");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 2;
		colTo = 25;
		map.put("cellValue", " ");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", null);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row + 1;
		rowTo = row;
		col = 0;
		colTo = 17;
		//单验工程师业务验证项：
		map.put("cellValue",Map.get("PerItems"));
		map.put("fontWeight", (short) 1000);
		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("fontSize", (short) 14);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THICK);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row + 1;
		rowTo = row + 9;
		col = 0;
		colTo = col + 1;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THICK);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 业务测试情况
		row = row;
		rowTo = row;
		col = col + 2;
		colTo = col + 3;
		//业务测试情况:
		map.put("cellValue",Map.get("Items"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("fontSize", (short) 10);
		map.put("fontWeight", null);
		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("rowHeight", (short) 500);
		map.put("backgroundColour", HSSFColor.GREY_50_PERCENT.index);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 尝试次数
		row = row;
		rowTo = row;
		col = col + 4;
		colTo = col + 2;
		//尝试次数
		map.put("cellValue",Map.get("Attempts"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 成功次数
		row = row;
		rowTo = row;
		col = col + 3;
		colTo = col + 2;
		//成功次数
		map.put("cellValue",Map.get("Successful"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 失败次数
		row = row;
		rowTo = row;
		col = col + 3;
		colTo = col + 2;
		//失败次数
		map.put("cellValue",Map.get("Failure"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 成功率
		row = row;
		rowTo = row;
		col = col + 3;
		colTo = col + 2;
		//成功率
		map.put("cellValue",Map.get("Ratio"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row + 1;
		rowTo = row;
		col = 2;
		colTo = col + 3;
		//Ping时延测试:
		map.put("cellValue", Map.get("PingDelay"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("fontSize", (short) 10);
		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("backgroundColour", null);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 尝试次数值
		row = row;
		rowTo = row;
		col = col + 4;
		colTo = col + 2;
		map.put("cellValue", logList.get(0).getLog_delayTime());
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 成功次数值
		row = row;
		rowTo = row;
		col = col + 3;
		colTo = col + 2;
		map.put("cellValue", logList.get(1).getLog_delayTime());
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 失败次数值
		row = row;
		rowTo = row;
		col = col + 3;
		colTo = col + 2;
		map.put("cellValue",logList.get(2).getLog_delayTime());
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 成功率值
		row = row;
		rowTo = row;
		col = col + 3;
		colTo = col + 2;
		map.put("cellValue", logList.get(2).getLog_delayTime());
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// FTP吞吐量测试
		row = row + 1;
		rowTo = row + 1;
		col = 2;
		colTo = col + 3;
		//FTP吞吐量测试
		map.put("cellValue",Map.get("FTP"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("backgroundColour", HSSFColor.GREY_50_PERCENT.index);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 4;
		colTo = col + 11;
		//好点
		map.put("cellValue",Map.get("GoodPoint"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row + 1;
		rowTo = row;
		col = col;
		colTo = col + 3;
		//129小区
		map.put("cellValue",Map.get("129Cell"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 4;
		colTo = col + 3;
		//130小区
		map.put("cellValue",Map.get("130Cell"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 4;
		colTo = col + 3;
		//131小区
		map.put("cellValue",Map.get("131Cell"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row + 1;
		rowTo = row + 2;
		col = 2;
		colTo = col + 1;
		//FTP下行吞吐量
		map.put("cellValue",Map.get("FTPDownlink"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("backgroundColour", null);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// RSRP(dBm)
		row = row;
		rowTo = row;
		col = col + 2;
		colTo = col + 1;
		map.put("cellValue", "RSRP(dBm)");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 129小区RSRP(dBm)值
		row = row;
		rowTo = row;
		col = col + 2;
		colTo = col + 3;
		map.put("cellValue",logList.get(0).getLog_RSRP());//获得数据库RSRP的值
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 130小区RSRP(dBm)值
		row = row;
		rowTo = row;
		col = col + 4;
		colTo = col + 3;
		map.put("cellValue",logList.get(1).getLog_RSRP());//获得数据库RSRP的值
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 131小区RSRP(dBm)值
		row = row;
		rowTo = row;
		col = col + 4;
		colTo = col + 3;
		map.put("cellValue", logList.get(2).getLog_RSRP());//获得数据库RSRP的值
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		// Average SINR(dB)
		row = row + 1;
		rowTo = row;
		col = 4;
		colTo = col + 1;
		map.put("cellValue", "Average SINR(dB)");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 129小区Average SINR(dB)值
		row = row;
		rowTo = row;
		col = col + 2;
		colTo = col + 3;
		map.put("cellValue", logList.get(0).getLog_SINR());//SINR的数据库值
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 130小区Average SINR(dB)值
		row = row;
		rowTo = row;
		col = col + 4;
		colTo = col + 3;
		map.put("cellValue", logList.get(1).getLog_SINR());//SINR的数据库值
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 131小区Average SINR(dB)值
		row = row;
		rowTo = row;
		col = col + 4;
		colTo = col + 3;
		map.put("cellValue", logList.get(2).getLog_SINR());//SINR的数据库值
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		// 下行吞吐量(kbps)
		row = row + 1;
		rowTo = row;
		col = 4;
		colTo = col + 1;
		//下行吞吐量(kbps)
		map.put("cellValue",Map.get("ThroughputD"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 129小区下行吞吐量(kbps))值
		row = row;
		rowTo = row;
		col = col + 2;
		colTo = col + 3;
		map.put("cellValue", logList.get(0).getLog_FTPDown_rate());
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 130小区下行吞吐量(kbps)值
		row = row;
		rowTo = row;
		col = col + 4;
		colTo = col + 3;
		map.put("cellValue",  logList.get(1).getLog_FTPDown_rate());
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 131小区下行吞吐量(kbps)值
		row = row;
		rowTo = row;
		col = col + 4;
		colTo = col + 3;
		map.put("cellValue",  logList.get(2).getLog_FTPDown_rate());
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// FTP上行吞吐量
		row = row + 1;
		rowTo = row + 2;
		col = 2;
		colTo = col + 1;
		//FTP上行吞吐量
		map.put("cellValue", Map.get("FTPUplink"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// FTP上行吞吐量 RSRP(dBm)
		row = row;
		rowTo = row;
		col = col + 2;
		colTo = col + 1;
		map.put("cellValue", "RSRP(dBm)");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// FTP上行吞吐量 RSRP(dBm)129小区的值
		row = row;
		rowTo = row;
		col = col + 2;
		colTo = col + 3;
		map.put("cellValue", logList.get(0).getLog_RSRP());//RSRP数据库的值
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// FTP上行吞吐量 RSRP(dBm)130小区的值
		row = row;
		rowTo = row;
		col = col + 4;
		colTo = col + 3;
		map.put("cellValue",logList.get(1).getLog_RSRP());//RSRP数据库的值
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// FTP上行吞吐量 RSRP(dBm)131小区的值
		row = row;
		rowTo = row;
		col = col + 4;
		colTo = col + 3;
		map.put("cellValue",logList.get(2).getLog_RSRP());//RSRP数据库的值
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// FTP上行吞吐量 Average SINR(dB)
		row = row + 1;
		rowTo = row;
		col = 4;
		colTo = col + 1;
		map.put("cellValue", "Average SINR(dB)");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// FTP上行吞吐量 Average SINR(dB)129小区的值
		row = row;
		rowTo = row;
		col = col + 2;
		colTo = col + 3;
		map.put("cellValue",logList.get(0).getLog_SINR());
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// FTP上行吞吐量 Average SINR(dB)130小区的值
		row = row;
		rowTo = row;
		col = col + 4;
		colTo = col + 3;
		map.put("cellValue", logList.get(1).getLog_SINR());
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// FTP上行吞吐量 Average SINR(dB)131小区的值
		row = row;
		rowTo = row;
		col = col + 4;
		colTo = col + 3;
		map.put("cellValue", logList.get(2).getLog_SINR());
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// FTP上行吞吐量上行吞吐量
		row = row + 1;
		rowTo = row;
		col = 4;
		colTo = col + 1;
		//上行吞吐量(kbps)
		map.put("cellValue", Map.get("ThroughputUp"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// FTP上行吞吐量 上行吞吐量(kbps)129小区的值
		row = row;
		rowTo = row;
		col = col + 2;
		colTo = col + 3;
		map.put("cellValue", logList.get(0).getLog_FTPTop_rate());
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// FTP上行吞吐量上行吞吐量(kbps)130小区的值
		row = row;
		rowTo = row;
		col = col + 4;
		colTo = col + 3;
		map.put("cellValue", logList.get(1).getLog_FTPTop_rate());
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// FTP上行吞吐量 上行吞吐量(kbps)131小区的值
		row = row;
		rowTo = row;
		col = col + 4;
		colTo = col + 3;
		map.put("cellValue",logList.get(2).getLog_FTPTop_rate());
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
		// 备注
		row = 4;
		rowTo = row;
		col = 18;
		colTo = 25;
		//备注
		map.put("cellValue", Map.get("Remarks"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderLeft", HSSFCellStyle.BORDER_THICK);
		map.put("borderBottom", HSSFCellStyle.BORDER_THICK);
		map.put("borderTop", HSSFCellStyle.BORDER_THICK);
		map.put("borderRight", HSSFCellStyle.BORDER_THICK);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row + 1;
		rowTo = row;
		col = 18;
		colTo = 25;
		//验证标准
		map.put("cellValue", Map.get("Methodology"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row + 1;
		rowTo = row;
		col = 18;
		colTo = 25;
//		PING 32Bytes时延\r\n" + "1）定点测试：RSRP≥-16000dBm，SINR≥20dB\r\n" + "2）空载网络/轻载网络闲时测试。\r\n"
//		+ "3）连续测试次数要求最少50次。\r\n" + "4）测试间隔时间为2S。\r\n" + "5）传输时延小于3ms，端到端时延抖动小于2ms，建议服务器直接连接PGW测试。\r\n"
//		+ "6）排除非RAN侧或非华为设备原因引起的指标异常。\r\n" + "验收标准：<1.5秒
		map.put("cellValue",
				Map.get("PING32Bytes")+"\r\n" + Map.get("StaticRSRP")+"\r\n" + Map.get("InIdel")+"\r\n"
						+ Map.get("AtLeast") + "\r\n" + Map.get("EachInterval")+"\r\n" + Map.get("TranDelay")+"\r\n"
						+ Map.get("ExcludeAb")+"\r\n" + Map.get("Standard"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row + 1;
		rowTo = row + 1;
		col = 18;
		colTo = 25;
		map.put("cellValue", " ");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row + 2;
		rowTo = row + 2;
		col = 18;
		colTo = 25;
		//下行速率测试（UDP灌包测试）：\r\n" + "1）空载网络\r\n" + "2）定点测试，选择RSRP≥-16000dBm，SINR≥20dB。\r\n"
//		+ "3）下行发包≥300Bytes；\r\n" + "4）连续测试次数要求最少20次。\r\n" + "5）排除非RAN侧原因引起的指标异常。\r\n" + "6）排除由于非设备原因引起的指标异常\r\n"
//		+ "测试方法：\r\n" + "1）通过服务器向终端发起下行灌包业务。\r\n" + "2）观察路测工具中MAC层下行吞吐率。\r\n" + "验收标准：\r\n" + "3000kbps 
		map.put("cellValue", Map.get("DownlinkUDP")+"\r\n" +Map.get("InIdel")+"\r\n" + Map.get("StaticRSRP")+" \r\n"
				+Map.get("DownlinkSend")+" \r\n" + Map.get("AtLeast20")+" \r\n" + Map.get("ExcludeAbIn")+" \r\n" + Map.get("ExcludeByEq")+" \r\n"
				+ Map.get("TestMethods")+" \r\n" + Map.get("DownlinkPac")+" \r\n" + Map.get("ObserveDown")+" \r\n" + Map.get("AcceptanceCriteria")+" \r\n" + "3000kbps ");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row + 3;
		rowTo = row + 2;
		col = 18;
		colTo = 25;
//		上行速率测试（UDP灌包测试）：\r\n" + "1）空载网络\r\n" + "2）定点测试，选择RSRP≥-16000dBm，SINR≥20dB。\r\n"
//		+ "3）上行发包≥300Bytes；\r\n" + "4）连续测试次数要求最少20次。\r\n" + "5）排除非RAN侧原因引起的指标异常。\r\n" + "6）排除由于非设备原因引起的指标异常\r\n"
//		+ "测试方法：\r\n" + "1）通过路测工具发送300Bytes的数据。\r\n" + "2）观察路测工具中MAC层上行吞吐率。\r\n" + "验收标准：\r\n" + "10kbps
		map.put("cellValue", Map.get("UplinkUDP")+" \r\n" + Map.get("InIdel")+" \r\n" + Map.get("PointTest")+" \r\n"
				+ Map.get("UplinkSend")+" \r\n" + Map.get("AtLeast20")+" \r\n" + Map.get("ExcludeAbIn")+" \r\n" + Map.get("ExcludeByEq")+" \r\n"
				+ Map.get("TestMethods")+" \r\n" + Map.get("SendData")+" \r\n" + Map.get("ObserveUp")+" \r\n" + Map.get("AcceptanceCriteria")+" \r\n" + "10kbps");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);
		map.put("map", map);
		ExcelPoiUtil.createCell(wb, sheet3, map);
	}

	/**
	 * 问题汇总
	 * 
	 * @param wfont
	 * @param wcf
	 * @param sheet3
	 * @param lang 
	 * @throws Exception
	 */
	public void createExcelSummaryOfproblems(HSSFWorkbook wb, HSSFSheet sheet3, String lang) throws Exception {
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		Map map = new HashMap();

		int col = 0;// 列
		int row = 0;// 行
		int colTo = 0;
		int rowTo = 0;
		// 序号
		map.put("cellValue", Map.get("No"));
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 10);
		map.put("fontType", "幼圆");
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);
		map.put("backgroundColour", HSSFColor.LIGHT_ORANGE.index);
		map.put("map", map);
		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", 1600);
		map.put("rowHeight", (short) 320);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 1;
		colTo = col;
		//问题类别
		map.put("cellValue",Map.get("Category"));
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("columnWidth", 3000);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 1;
		colTo = col;
		//问题描述与分析
		map.put("cellValue", Map.get("ProblemDescription"));
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("columnWidth", 5600);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 1;
		colTo = col;
		//调整方法
		map.put("cellValue",Map.get("Adjustment"));
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("columnWidth", 5600);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		row = row;
		rowTo = row;
		col = col + 1;
		colTo = col;
		//问题现状
		map.put("cellValue", Map.get("Status"));
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		map.put("columnWidth", 3200);
		ExcelPoiUtil.createCell(wb, sheet3, map);

		for (int i = 0; i < 24; i++) {
			row = i + 1;
			rowTo = row;
			col = 0;
			colTo = col;
			map.put("cellValue", " ");
			map.put("borderTop", HSSFCellStyle.BORDER_THIN);
			map.put("borderRight", HSSFCellStyle.BORDER_THIN);
			map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
			map.put("col", col);
			map.put("row", row);
			map.put("colTo", colTo);
			map.put("rowTo", rowTo);
			map.put("columnWidth", 1600);
			map.put("backgroundColour", null);
			ExcelPoiUtil.createCell(wb, sheet3, map);
		}
		for (int i = 0; i < 24; i++) {
			row = i + 1;
			rowTo = row;
			col = 1;
			colTo = col;
			map.put("cellValue", " ");
			map.put("borderTop", HSSFCellStyle.BORDER_THIN);
			map.put("borderRight", HSSFCellStyle.BORDER_THIN);
			map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
			map.put("col", col);
			map.put("row", row);
			map.put("colTo", colTo);
			map.put("rowTo", rowTo);
			map.put("columnWidth", 3000);
			map.put("backgroundColour", null);
			ExcelPoiUtil.createCell(wb, sheet3, map);
		}
		for (int i = 0; i < 24; i++) {
			row = i + 1;
			rowTo = row;
			col = 2;
			colTo = col;
			map.put("cellValue", " ");
			map.put("borderTop", HSSFCellStyle.BORDER_THIN);
			map.put("borderRight", HSSFCellStyle.BORDER_THIN);
			map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
			map.put("col", col);
			map.put("row", row);
			map.put("colTo", colTo);
			map.put("rowTo", rowTo);
			map.put("columnWidth", 5600);
			map.put("backgroundColour", null);
			ExcelPoiUtil.createCell(wb, sheet3, map);
		}

		for (int i = 0; i < 24; i++) {
			row = i + 1;
			rowTo = row;
			col = 3;
			colTo = col;
			map.put("cellValue", " ");
			map.put("borderTop", HSSFCellStyle.BORDER_THIN);
			map.put("borderRight", HSSFCellStyle.BORDER_THIN);
			map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
			map.put("col", col);
			map.put("row", row);
			map.put("colTo", colTo);
			map.put("rowTo", rowTo);
			map.put("columnWidth", 5600);
			map.put("backgroundColour", null);
			ExcelPoiUtil.createCell(wb, sheet3, map);
		}
		for (int i = 0; i < 24; i++) {
			row = i + 1;
			rowTo = row;
			col = 4;
			colTo = col;
			map.put("cellValue", " ");
			map.put("borderTop", HSSFCellStyle.BORDER_THIN);
			map.put("borderRight", HSSFCellStyle.BORDER_THIN);
			map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
			map.put("col", col);
			map.put("row", row);
			map.put("colTo", colTo);
			map.put("rowTo", rowTo);
			map.put("columnWidth", 3200);
			map.put("backgroundColour", null);
			ExcelPoiUtil.createCell(wb, sheet3, map);
		}

	}

	public void createExcelSubclass(HSSFWorkbook wb, HSSFSheet sheet, Plane plane, List<WorkParamDomain> wordParam_in,
			List<LogDomain> logList, String lang) throws Exception {
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		Map map = new HashMap();
		int col = 0;// 列
		int row = 0;// 行
		int colTo = 14;
		int rowTo = 0;

		col = 0;
		row = row;
		colTo = 14;
		rowTo = row;
		//NB-IOT单站点验证报告
		map.put("cellValue", Map.get("NB-IOTSS"));
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 20);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", (short) 1300);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 0;
		row = row + 1;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("rowHeight", (short) 200);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 基站描述
		rowTo = stationDesc(wb, sheet, (WorkParamDomain) wordParam_in.get(0), col, row, colTo, rowTo, map,lang);
		// 参数验证
		col = 0;
		row = rowTo + 1;
		colTo = 18;
		rowTo = row;
		//参数验证
		map.put("cellValue", Map.get("ParCheck"));
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_THICK);
		map.put("borderRight", HSSFCellStyle.BORDER_THICK);
		map.put("borderBottom", HSSFCellStyle.BORDER_THICK);
		map.put("borderLeft", HSSFCellStyle.BORDER_THICK);

		map.put("fontCenter", false);
		map.put("columnWidth", null);
		map.put("rowHeight", (short) 400);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 0;
		row = row + 1;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("map", null);
		map.put("borderTop", null);
		map.put("borderRight", null);
		map.put("borderBottom", null);
		map.put("borderLeft", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 基站参数
		rowTo = Stationparam(wb, sheet, (WorkParamDomain) wordParam_in.get(0), col, row, colTo, rowTo, map,lang,logList);
		// 小区参数（工程）
		rowTo = cellParamEngineering(wb, sheet, wordParam_in, col, row, colTo, rowTo, map,lang,logList);
		// 小区参数（网优）
		rowTo = cellParamNetwork(wb, sheet, wordParam_in, col, row, colTo, rowTo, map,lang,logList);

		// 功能验证
		col = 0;
		row = rowTo + 1;
		colTo = 18;
		rowTo = row;
		//功能验证
		map.put("cellValue", Map.get("PerCheck"));
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_THICK);
		map.put("borderRight", HSSFCellStyle.BORDER_THICK);
		map.put("borderBottom", HSSFCellStyle.BORDER_THICK);
		map.put("borderLeft", HSSFCellStyle.BORDER_THICK);

		map.put("fontCenter", false);
		map.put("columnWidth", null);
		map.put("rowHeight", (short) 400);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 业务验证
		rowTo = BusinessVerification(wb, sheet, logList, col, row, colTo, rowTo, map,lang);
		// 验证结论
		rowTo = VerificationConclusion(wb, sheet, logList, col, rowTo, colTo, rowTo, map,lang);
		// 工程师类型
		rowTo = EngineerDesc(wb, sheet, plane, col, rowTo, colTo, rowTo, map,lang);

	}

	/**
	 * 基站描述 返回rowTo
	 * @param lang 
	 */
	public int stationDesc(HSSFWorkbook wb, HSSFSheet sheet, Object obj, int col, int row, int colTo, int rowTo,
			Map map, String lang) throws Exception {
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		WorkParam_inDomain workParam_inDomain;
		WorkParamDomain workParamDomain;
		String stationName = "";// 站名
		String stationNo = null;// 站号
		String date = "";// 日期
		String area = "";// 区县
		String address = "";// 地址
		String stationType = "";// 站型
		String deviceType = "";// 设备类型

		if (obj instanceof WorkParam_inDomain) {
			workParam_inDomain = (WorkParam_inDomain) obj;
			stationNo = workParam_inDomain.getWp_station_no();
		}
		if (obj instanceof WorkParamDomain) {
			workParamDomain = (WorkParamDomain) obj;
			stationNo = workParamDomain.getWp_station_no();
		}

		col = 0;
		row = row + 1;
		colTo = 18;
		rowTo = row;
		//基站描述
		map.put("cellValue",Map.get("SiteInformation"));
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_THICK);
		map.put("borderRight", HSSFCellStyle.BORDER_THICK);
		map.put("borderBottom", HSSFCellStyle.BORDER_THICK);
		map.put("borderLeft", HSSFCellStyle.BORDER_THICK);

		map.put("fontCenter", false);
		map.put("columnWidth", null);
		map.put("rowHeight", (short) 400);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 0;
		row = row + 1;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("borderTop", null);
		map.put("borderRight", null);
		map.put("borderBottom", null);
		map.put("borderLeft", null);
		map.put("fontWeight", null);
		map.put("map", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 0;
		row = rowTo + 1;
		colTo = 0;
		rowTo = row + 6;
		map.put("cellValue", "");
		map.put("map", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 1;
		row = row;
		colTo = col;
		rowTo = row;
		//站名：
		map.put("cellValue",Map.get("SiteName"));
		map.put("fontWeight", null);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", null);
		map.put("borderRight", null);
		map.put("borderBottom", null);
		map.put("borderLeft", null);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 站名
		col = colTo + 1;
		row = row;
		colTo = col + 3;
		rowTo = row;
		map.put("cellValue", stationName);
		map.put("fontWeight", null);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderRight", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderBottom", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderLeft", HSSFCellStyle.BORDER_DOTTED);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = colTo + 1;
		row = row;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", "");
		map.put("map", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//日期:
		map.put("cellValue", Map.get("Date"));
		map.put("fontWeight", null);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", null);
		map.put("borderRight", null);
		map.put("borderBottom", null);
		map.put("borderLeft", null);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 日期
		col = colTo + 1;
		row = row;
		colTo = col + 3;
		rowTo = row;
		map.put("cellValue", date);
		map.put("fontWeight", null);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderRight", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderBottom", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderLeft", HSSFCellStyle.BORDER_DOTTED);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 1;
		row = row + 1;
		colTo = 14;
		rowTo = row;
		map.put("cellValue", "");
		map.put("map", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 1;
		row = row + 1;
		colTo = col;
		rowTo = row;
		//站号：
		map.put("cellValue", Map.get("SiteId"));
		map.put("fontWeight", null);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", null);
		map.put("borderRight", null);
		map.put("borderBottom", null);
		map.put("borderLeft", null);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 站号
		col = colTo + 1;
		row = row;
		colTo = col + 3;
		rowTo = row;
		map.put("cellValue", stationNo);
		map.put("fontWeight", null);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderRight", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderBottom", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderLeft", HSSFCellStyle.BORDER_DOTTED);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = colTo + 1;
		row = row;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", "");
		map.put("map", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//区县:
		map.put("cellValue",Map.get("County"));
		map.put("fontWeight", null);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", null);
		map.put("borderRight", null);
		map.put("borderBottom", null);
		map.put("borderLeft", null);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 区县
		col = colTo + 1;
		row = row;
		colTo = col + 3;
		rowTo = row;
		map.put("cellValue", area);
		map.put("fontWeight", null);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderRight", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderBottom", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderLeft", HSSFCellStyle.BORDER_DOTTED);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 1;
		row = rowTo + 1;
		colTo = 14;
		rowTo = row;
		map.put("cellValue", "");
		map.put("map", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 1;
		row = row + 1;
		colTo = col;
		rowTo = row;
		//地址:
		map.put("cellValue", Map.get("Address"));
		map.put("fontWeight", null);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", null);
		map.put("borderRight", null);
		map.put("borderBottom", null);
		map.put("borderLeft", null);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 地址
		col = colTo + 1;
		row = rowTo;
		colTo = col + 5;
		rowTo = row;
		map.put("cellValue", address);
		map.put("fontWeight", null);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderRight", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderBottom", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderLeft", HSSFCellStyle.BORDER_DOTTED);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = colTo + 2;
		row = rowTo;
		colTo = col;
		rowTo = row;
		//站型:
		map.put("cellValue", Map.get("SiteType"));
		map.put("fontWeight", null);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", null);
		map.put("borderRight", null);
		map.put("borderBottom", null);
		map.put("borderLeft", null);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 站型
		col = colTo + 1;
		row = rowTo;
		colTo = col + 3;
		rowTo = row;
		map.put("cellValue", stationType);
		map.put("fontWeight", null);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderRight", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderBottom", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderLeft", HSSFCellStyle.BORDER_DOTTED);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 1;
		row = rowTo + 1;
		colTo = 14;
		rowTo = row;
		map.put("cellValue", "");
		map.put("map", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 1;
		row = rowTo + 1;
		colTo = col + 1;
		rowTo = row;
		//设备类型:
		map.put("cellValue", Map.get("equipmentCa"));
		map.put("fontWeight", null);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", null);
		map.put("borderRight", null);
		map.put("borderBottom", null);
		map.put("borderLeft", null);

		map.put("fontCenter", false);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 设备类型
		col = colTo + 1;
		row = rowTo;
		colTo = col + 3;
		rowTo = row;
		map.put("cellValue", deviceType);
		map.put("fontWeight", null);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderRight", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderBottom", HSSFCellStyle.BORDER_DOTTED);
		map.put("borderLeft", HSSFCellStyle.BORDER_DOTTED);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = colTo + 1;
		row = rowTo;
		colTo = 14;
		rowTo = row;
		map.put("cellValue", "");
		map.put("map", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 0;
		row = rowTo + 1;
		colTo = 14;
		rowTo = row;
		map.put("cellValue", "");
		map.put("map", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		return rowTo;

	}

	/**
	 * 基站参数
	 */
	public int Stationparam(HSSFWorkbook wb, HSSFSheet sheet, Object obj, int col, int row, int colTo, int rowTo,
			Map map ,String lang,List<LogDomain> logList) throws Exception {
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		WorkParam_inDomain workParam_inDomain;
		WorkParamDomain workParamDomain;
		String longitude = "";// 经度
		String longitudeStandard = "";// 经度规划参数
		String latitude = "";// 纬度
		String latitudeStandard = "";// 纬度规划参数
		String height = "";// 海拔即站高
		String heightStandard = "";// 海拔规划参数
		String TAC = "";// tac
		String TACStandard = "";// tac规划参数
		String NodeBID = "";// NodeBID
		String NodeBIDStandard = "";// NodeBID规划参数

		if (obj instanceof WorkParam_inDomain) {
			workParam_inDomain = (WorkParam_inDomain) obj;
			longitude = workParam_inDomain.getWp_station_longitude();
			latitude = workParam_inDomain.getWp_station_latitude();
			height = workParam_inDomain.getWp_station_height();
			TAC = workParam_inDomain.getWp_station_TAC();
		}
		if (obj instanceof WorkParamDomain) {
			workParamDomain = (WorkParamDomain) obj;
			longitude = workParamDomain.getWp_station_longitude();
			latitude = workParamDomain.getWp_station_latitude();
			height = workParamDomain.getWp_station_height();
			TAC = workParamDomain.getWp_station_TAC();
		}

		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		//基站参数（工程）
		map.put("cellValue", Map.get("SiteParam"));
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 12);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		//规划数据
		map.put("cellValue",Map.get("Planned"));
		map.put("fontWeight", null);
		map.put("fontSize", (short) 12);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		//实测数据
		map.put("cellValue", Map.get("Actual"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		//验证通过
		map.put("cellValue", Map.get("VerifyThrough"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = colTo + 1;
		row = rowTo;
		colTo = 18;
		rowTo = row;
		//备注
		map.put("cellValue", Map.get("Note"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 经度
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("Longitude"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 经度 规划数据
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", longitudeStandard);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 经度 实测数据
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", longitude);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 经度 验证是否通过
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 经度 备注
		col = colTo + 1;
		row = rowTo;
		colTo = col + 9;
		rowTo = row;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 纬度
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue",Map.get("Latitude"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 纬度 规划数据
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", latitudeStandard);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 纬度 实测数据
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", latitude);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 纬度 验证是否通过
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 纬度 备注
		col = colTo + 1;
		row = rowTo;
		colTo = col + 9;
		rowTo = row;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 海拔
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("Height"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 海拔 规划数据
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", heightStandard);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 海拔 实测数据
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", height);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 海拔 验证是否通过
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 海拔 备注
		col = colTo + 1;
		row = rowTo;
		colTo = col + 9;
		rowTo = row;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// TAC
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue","TAC");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// TAC 规划数据
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", TACStandard);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// TAC 实测数据
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", TAC);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// TAC 验证是否通过
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// TAC 备注
		col = colTo + 1;
		row = rowTo;
		colTo = col + 9;
		rowTo = row;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// NodeBID
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue","NodeBID");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// NodeBID 规划数据
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue","");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// NodeBID 实测数据
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", NodeBID);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// NodeBID 验证是否通过
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// NodeBID 备注
		col = colTo + 1;
		row = rowTo;
		colTo = col + 9;
		rowTo = row;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 0;
		row = rowTo + 1;
		colTo = col + 18;
		rowTo = row + 1;
		map.put("cellValue", "");
		map.put("map", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		return rowTo;
	}

	/**
	 * 小区参数（工程）workParm_in
	 * @param lang 
	 */
	public int cellParamEngineering_in(HSSFWorkbook wb, HSSFSheet sheet, List<WorkParam_inDomain> workParam_inList,
			int col, int row, int colTo, int rowTo, Map map, String lang,List<LogDomain> logList) throws Exception {
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row + 1;
		//小区参数(工程)
		map.put("cellValue", Map.get("CellParam"));
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 12);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区名1
		col = colTo + 1;
		row = row;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("Sector1"));
		map.put("fontWeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col;
		row = row + 1;
		colTo = col;
		rowTo = row;
		//规划数据
		map.put("cellValue", Map.get("Planned"));
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//实测数据
		map.put("cellValue", Map.get("Actual"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//结果
		map.put("cellValue", Map.get("Check"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区名2
		col = colTo + 1;
		row = row - 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontWeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col;
		row = row + 1;
		colTo = col;
		rowTo = row;
		//规划数据
		map.put("cellValue", Map.get("Planned"));
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//实测数据
		map.put("cellValue", Map.get("Actual"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//结果
		map.put("cellValue", Map.get("Check"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区名3
		col = colTo + 1;
		row = row - 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("Sector3"));
		map.put("fontWeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col;
		row = row + 1;
		colTo = col;
		rowTo = row;
		//规划数据
		map.put("cellValue", Map.get("Planned"));
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//实测数据
		map.put("cellValue", Map.get("Actual"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//结果
		map.put("cellValue", Map.get("Check"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 备注
		col = col + 1;
		row = row - 1;
		colTo = 18;
		rowTo = row + 1;
		map.put("cellValue", Map.get("Remarks"));
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区id
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("CellID"));
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区id1 规划数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(0).getLog_cellID());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区id1 实测数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(0).getWp_cell_section());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区id1 结果
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区id2 规划数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(1).getLog_cellID());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区id2 实测数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(1).getWp_cell_section());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区id2 结果
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区id3 规划数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(2).getLog_cellID());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区id3 实测数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(2).getWp_cell_section());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区id3 结果
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区id 备注
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 频点
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", "Version");//新改成版本 log_version
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1频点 规划数据  新改成版本 log_version
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(0).getLog_version());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1频点 实测数据	新改成版本 log_version
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1频点 结果	新改成版本 log_version
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区2频点 规划数据	新改成版本 log_version
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",  logList.get(1).getLog_version());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2频点 实测数据		新改成版本 log_version
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2频点 结果		新改成版本 log_version
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3频点 规划数据		新改成版本 log_version
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",  logList.get(2).getLog_version());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3频点 实测数据		新改成版本 log_version
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3频点 结果		新改成版本 log_version
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3频点 备注		新改成版本 log_version
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// PCI
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", "PCI");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1PCI 规划数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1PCI 实测数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(0).getWp_cell_PCI());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1PCI 结果
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区2PCI 规划数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2PCI 实测数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(1).getWp_cell_PCI());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2PCI 结果
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3PCI 规划数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3PCI 实测数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(2).getWp_cell_PCI());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3PCI 结果
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3PCI 备注
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// PRACH
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", "LogPCI");//新改成LogPCI  log_PCI
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1PRACH 规划数据		新改成Log_PCI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(0).getLog_PCI());//新改成Log_PCI
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1PRACH 实测数据		新改成Log_PCI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1PRACH 结果		新改成Log_PCI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区2PRACH 规划数据		新改成Log_PCI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(0).getLog_PCI());//Log_PCI
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2PRACH 实测数据		新改成Log_PCI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2PRACH 结果		新改成Log_PCI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
			
		// 小区3频点 规划数据		新改成Log_PCI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(2).getLog_PCI());//Log_PCI
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3频点 实测数据		新改成Log_PCI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3频点 结果		新改成Log_PCI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3频点 备注			新改成Log_PCI
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 0;
		row = row + 1;
		colTo = 18;
		rowTo = row + 1;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("map", null);
		map.put("columnWidth", 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		return rowTo;
	}

	/**
	 * 小区参数（工程）workParm
	 * @param lang 
	 */
	public int cellParamEngineering(HSSFWorkbook wb, HSSFSheet sheet, List<WorkParamDomain> workParam_inList, int col,
			int row, int colTo, int rowTo, Map map, String lang,List<LogDomain> logList) throws Exception {
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row + 1;
		//小区参数(工程)
		map.put("cellValue", Map.get("CellParam"));
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 12);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区名1
		col = colTo + 1;
		row = row;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("Sector1"));
		map.put("fontWeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col;
		row = row + 1;
		colTo = col;
		rowTo = row;
		map.put("cellValue", Map.get("Planned"));
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", Map.get("Actual"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", Map.get("Check"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区名2
		col = colTo + 1;
		row = row - 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("Sector2"));
		map.put("fontWeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col;
		row = row + 1;
		colTo = col;
		rowTo = row;
		map.put("cellValue", Map.get("Planned"));
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", Map.get("Actual"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", Map.get("Check"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区名3
		col = colTo + 1;
		row = row - 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("Sector3"));
		map.put("fontWeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col;
		row = row + 1;
		colTo = col;
		rowTo = row;
		map.put("cellValue", Map.get("Planned"));
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", Map.get("Actual"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", map.get("Check"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 备注
		col = col + 1;
		row = row - 1;
		colTo = 18;
		rowTo = row + 1;
		map.put("cellValue", Map.get("Remarks"));
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区id
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("CellID"));
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区id1 规划数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(0).getLog_cellID());//  log_cellId
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区id1 实测数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(0).getWp_cell_section());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区id1 结果
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区id2 规划数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(1).getLog_cellID()); // log_cellId
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区id2 实测数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(1).getWp_cell_section());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区id2 结果
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区id3 规划数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(2).getLog_cellID()); // log_cellId
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区id3 实测数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(2).getWp_cell_section());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区id3 结果
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区id 备注
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 频点		新改成版本log_Version
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue","Version");//新改成版本log_Version
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1频点 规划数据		新改成版本log_Version
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(0).getLog_version());//log_Version的数据库值
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1频点 实测数据		新改成版本log_Version
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1频点 结果		新改成版本log_Version
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区2频点 规划数据		新改成版本log_Version
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",  logList.get(1).getLog_version());//log_Version的数据库值
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2频点 实测数据		新改成版本log_Version
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2频点 结果		新改成版本log_Version
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3频点 规划数据		新改成版本log_Version
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(2).getLog_version());//log_Version的数据库值
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3频点 实测数据		新改成版本log_Version
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3频点 结果		新改成版本log_Version
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3频点 备注		新改成版本log_Version
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// PCI
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", "PCI");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1PCI 规划数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1PCI 实测数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(0).getWp_cell_PCI());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1PCI 结果
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区2PCI 规划数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2PCI 实测数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(1).getWp_cell_PCI());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2PCI 结果
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3PCI 规划数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3PCI 实测数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(2).getWp_cell_PCI());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3PCI 结果
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3PCI 备注
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// PRACH  	新改成PCI log_PCI
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", "LogPCI");//新改成PCI log_PCI
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1PRACH 规划数据			新改成PCI log_PCI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(0).getLog_PCI());//获取log_PCI的数据库值
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1PRACH 实测数据			新改成PCI log_PCI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1PRACH 结果			新改成PCI log_PCI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区2PRACH 规划数据			新改成PCI log_PCI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(1).getLog_PCI());//获取log_PCI的数据库值
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2PRACH 实测数据			新改成PCI log_PCI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2PRACH 结果			新改成PCI log_PCI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3频点 规划数据			新改成PCI log_PCI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(2).getLog_PCI());//获取log_PCI的数据库值
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3频点 实测数据			新改成PCI log_PCI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3频点 结果			新改成PCI log_PCI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3频点 备注			新改成PCI log_PCI
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 0;
		row = row + 1;
		colTo = 18;
		rowTo = row + 1;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("map", null);
		map.put("columnWidth", 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		return rowTo;
	}

	/**
	 * 小区参数（网优）workParm_in
	 * @param lang 
	 */
	public int cellParamNetwork_in(HSSFWorkbook wb, HSSFSheet sheet, List<WorkParam_inDomain> workParam_inList, int col,
			int row, int colTo, int rowTo, Map map, String lang,List<LogDomain> logList) throws Exception {
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row + 1;
		//小区参数（网优）
		map.put("cellValue", Map.get("CellParameters"));
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 12);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区名1
		col = colTo + 1;
		row = row;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("Sector1"));
		map.put("fontWeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col;
		row = row + 1;
		colTo = col;
		rowTo = row;
		//规划数据
		map.put("cellValue", Map.get("Planned"));
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//实测数据
		map.put("cellValue", Map.get("Actual"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//结果
		map.put("cellValue", Map.get("Check"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区名2
		col = colTo + 1;
		row = row - 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("Sector2"));
		map.put("fontWeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col;
		row = row + 1;
		colTo = col;
		rowTo = row;
		//规划数据
		map.put("cellValue", Map.get("Planned"));
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//实测数据
		map.put("cellValue", Map.get("Actual"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//结果
		map.put("cellValue", Map.get("Check"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区名3
		col = colTo + 1;
		row = row - 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("Sector3"));
		map.put("fontWeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col;
		row = row + 1;
		colTo = col;
		rowTo = row;
		//规划数据
		map.put("cellValue", Map.get("Planned"));
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//实测数据
		map.put("cellValue", Map.get("Actual"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//结果
		map.put("cellValue", Map.get("Check"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 备注
		col = col + 1;
		row = row - 1;
		colTo = 18;
		rowTo = row + 1;
		map.put("cellValue", Map.get("Remarks"));
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1 RsPower(dBm)		//新改成iperfDown	log_iperfDown_rate
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", "iperfDown");//新改成iperfDown log_iperfDown_rate
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1RsPower(dBm) 规划数据		//新改成iperfDown	log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(0).getLog_iperfDown_rate());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1RsPower(dBm) 实测数据			//新改成iperfDown	log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1RsPower(dBm) 结果		//新改成iperfDown	log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区2RsPower(dBm) 规划数据		//新改成iperfDown	log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(1).getLog_iperfDown_rate());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2RsPower(dBm) 实测数据		//新改成iperfDown	log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2RsPower(dBm) 结果		//新改成iperfDown	log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3RsPower(dBm) 规划数据		//新改成iperfDown	log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(2).getLog_iperfDown_rate());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3RsPower(dBm) 实测数据		//新改成iperfDown	log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3RsPower(dBm) 结果		//新改成iperfDown	log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3RsPower(dBm) 备注		//新改成iperfDown	log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 天线挂高（米）		//新改成重传时延Log_ReselectDelay
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("RetransmissionDelay"));//新改成重传时延Log_ReselectDelay
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1天线挂高（米） 规划数据		//新改成重传时延Log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(0).getLog_ReselectDelay());//重传时延
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1天线挂高（米） 实测数据    		//重传时延
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1天线挂高（米） 结果		//新改成重传时延Log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区2天线挂高（米） 规划数据		//新改成重传时延Log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(1).getLog_ReselectDelay());//重传时延
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2天线挂高（米） 实测数据		//新改成重传时延Log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2天线挂高（米） 结果		//新改成重传时延Log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3天线挂高（米） 规划数据		//新改成重传时延Log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(2).getLog_ReselectDelay());//重传时延
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3天线挂高（米） 实测数据		//新改成重传时延Log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3天线挂高（米） 结果		//新改成重传时延Log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3天线挂高（米） 备注		//新改成重传时延Log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 方位角（度）		//新改成log_iperfTop_rate
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", "iperfTop");//新改成log_iperfTop_rate
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		
		// 小区1方位角（度） 规划数据		//新改成log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(0).getLog_iperfTop_rate());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1方位角（度） 实测数据		//新改成log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(0).getWp_cell_bearing());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1方位角（度） 结果		//新改成log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区2方位角（度） 规划数据		//新改成log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(1).getLog_iperfTop_rate());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2方位角（度） 实测数据		//新改成log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(1).getWp_cell_bearing());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2方位角（度） 结果		//新改成log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3方位角（度） 规划数据		//新改成log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(2).getLog_iperfTop_rate());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3方位角（度） 实测数据		//新改成log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(2).getWp_cell_bearing());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3方位角（度） 结果		//新改成log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3方位角（度） 备注		//新改成log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 总下倾角（度）
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("Downhill"));
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1总下倾角（度） 规划数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1总下倾角（度） 实测数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(0).getWp_cell_dipAangle());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1总下倾角（度） 结果
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区2总下倾角（度） 规划数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2总下倾角（度） 实测数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(1).getWp_cell_dipAangle());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2总下倾角（度） 结果
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3总下倾角（度） 规划数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3总下倾角（度） 实测数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(2).getWp_cell_dipAangle());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3总下倾角（度） 结果
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3总下倾角（度） 备注
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 预制电下倾（度）		//新改成接通时延   log_AttachDelay
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("ConnectionDelay"));//新改成接通时延log_AttachDelay
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1预制电下倾（度） 规划数据	//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(0).getLog_AttachDelay());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1预制电下倾（度） 实测数据	//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1预制电下倾（度） 结果	//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区2预制电下倾（度） 规划数据	//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(1).getLog_AttachDelay());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2预制电下倾（度） 实测数据	//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2预制电下倾（度） 结果	//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3预制电下倾（度） 规划数据	//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(2).getLog_AttachDelay());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3预制电下倾（度） 实测数据	//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3总下倾角（度） 结果	//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3总下倾角（度） 备注	//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 机械下倾角（度）		//新改成RSSI log_RSSI
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("RSSI"));//新改成RSSI log_RSSI
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1机械下倾角（度） 规划数据		//新改成RSSI log_RSSI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(0).getLog_RSSI());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1机械下倾角（度） 实测数据		//新改成RSSI log_RSSI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1机械下倾角（度） 结果		//新改成RSSI log_RSSI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区2机械下倾角（度） 规划数据		//新改成RSSI log_RSSI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(1).getLog_RSSI());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2机械下倾角（度） 实测数据		//新改成RSSI log_RSSI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2机械下倾角（度） 结果		//新改成RSSI log_RSSI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3机械下倾角（度） 规划数据		//新改成RSSI log_RSSI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(2).getLog_RSSI());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3机械下倾角（度） 实测数据		//新改成RSSI log_RSSI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3机械下倾角（度） 结果		//新改成RSSI log_RSSI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3机械下倾角（度） 备注		//新改成RSSI log_RSSI
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 0;
		row = row + 1;
		colTo = 18;
		rowTo = row + 1;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("map", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		return rowTo;
	}

	/**
	 * 小区参数（网优）workParm
	 * @param lang 
	 */
	public int cellParamNetwork(HSSFWorkbook wb, HSSFSheet sheet, List<WorkParamDomain> workParam_inList, int col,
			int row, int colTo, int rowTo, Map map, String lang,List<LogDomain> logList) throws Exception {
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row + 1;
		map.put("cellValue", Map.get("CellParameters"));
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 12);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区名1
		col = colTo + 1;
		row = row;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("Sector1"));
		map.put("fontWeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col;
		row = row + 1;
		colTo = col;
		rowTo = row;
		//规划数据
		map.put("cellValue", Map.get("Planned"));
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//实测数据
		map.put("cellValue", Map.get("Actual"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//结果
		map.put("cellValue", Map.get("Check"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区名2
		col = colTo + 1;
		row = row - 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("Sector2"));
		map.put("fontWeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col;
		row = row + 1;
		colTo = col;
		rowTo = row;
		//规划数据
		map.put("cellValue", Map.get("Planned"));
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//实测数据
		map.put("cellValue", Map.get("Actual"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//结果
		map.put("cellValue", Map.get("Check"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区名3
		col = colTo + 1;
		row = row - 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("Sector3"));
		map.put("fontWeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col;
		row = row + 1;
		colTo = col;
		rowTo = row;
		//规划数据
		map.put("cellValue", Map.get("Planned"));
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//实测数据
		map.put("cellValue", Map.get("Actual"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		//结果
		map.put("cellValue", Map.get("Check"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 备注
		col = col + 1;
		row = row - 1;
		colTo = 18;
		rowTo = row + 1;
		map.put("cellValue", Map.get("Remarks"));
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1 RsPower(dBm)		//新改成iperfDown   log_iperfDown_rate
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", "iperfDown");//新改成iperfDown   log_iperfDown_rate
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1RsPower(dBm) 规划数据			//新改成iperfDown   log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(0).getLog_iperfDown_rate());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1RsPower(dBm) 实测数据		//新改成iperfDown   log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1RsPower(dBm) 结果		//新改成iperfDown   log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区2RsPower(dBm) 规划数据		//新改成iperfDown   log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(1).getLog_iperfDown_rate());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2RsPower(dBm) 实测数据		//新改成iperfDown   log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2RsPower(dBm) 结果		//新改成iperfDown   log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3RsPower(dBm) 规划数据		//新改成iperfDown   log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(2).getLog_iperfDown_rate());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3RsPower(dBm) 实测数据		//新改成iperfDown   log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3RsPower(dBm) 结果		//新改成iperfDown   log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3RsPower(dBm) 备注		//新改成iperfDown   log_iperfDown_rate
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 天线挂高（米）		//改成重传时延   log_ReselectDelay
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("RetransmissionDelay"));//改成重传时延logList.get(0).getLog_ReselectDelay()
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1天线挂高（米） 规划数据		//改成重传时延   log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(0).getLog_ReselectDelay());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1天线挂高（米） 实测数据		//改成重传时延   log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1天线挂高（米） 结果		//改成重传时延   log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区2天线挂高（米） 规划数据		//改成重传时延   log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(1).getLog_ReselectDelay());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2天线挂高（米） 实测数据		//改成重传时延   log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2天线挂高（米） 结果		//改成重传时延   log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3天线挂高（米） 规划数据		//改成重传时延   log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(2).getLog_ReselectDelay());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3天线挂高（米） 实测数据		//改成重传时延   log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3天线挂高（米） 结果		//改成重传时延   log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3天线挂高（米） 备注		//改成重传时延   log_ReselectDelay
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 方位角（度）		//新改成iperfTop  log_iperfTop_rate
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue","iperfTop");//新改成iperfTop  log_iperfTop_rate
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1方位角（度） 规划数据		//新改成iperfTop  log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(0).getLog_iperfTop_rate());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1方位角（度） 实测数据		//新改成iperfTop  log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(0).getWp_cell_bearing());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1方位角（度） 结果		//新改成iperfTop  log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区2方位角（度） 规划数据		//新改成iperfTop  log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(1).getLog_iperfTop_rate());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2方位角（度） 实测数据		//新改成iperfTop  log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(1).getWp_cell_bearing());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2方位角（度） 结果		//新改成iperfTop  log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3方位角（度） 规划数据		//新改成iperfTop  log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(2).getLog_iperfTop_rate());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3方位角（度） 实测数据		//新改成iperfTop  log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(2).getWp_cell_bearing());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3方位角（度） 结果		//新改成iperfTop  log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3方位角（度） 备注		//新改成iperfTop  log_iperfTop_rate
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 总下倾角（度）
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("Downhill"));
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1总下倾角（度） 规划数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1总下倾角（度） 实测数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(0).getWp_cell_dipAangle());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1总下倾角（度） 结果
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区2总下倾角（度） 规划数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2总下倾角（度） 实测数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(1).getWp_cell_dipAangle());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2总下倾角（度） 结果
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3总下倾角（度） 规划数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3总下倾角（度） 实测数据
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", workParam_inList.get(2).getWp_cell_dipAangle());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3总下倾角（度） 结果
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3总下倾角（度） 备注
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 预制电下倾（度）		//新改成接通时延   log_AttachDelay
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("ConnectionDelay"));//新改成接通时延log_AttachDelay
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1预制电下倾（度） 规划数据		//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(0).getLog_AttachDelay());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1预制电下倾（度） 实测数据		//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1预制电下倾（度） 结果		//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区2预制电下倾（度） 规划数据		//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(1).getLog_AttachDelay());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2预制电下倾（度） 实测数据		//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2预制电下倾（度） 结果		//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3预制电下倾（度） 规划数据		//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(2).getLog_AttachDelay());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3预制电下倾（度） 实测数据		//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3总下倾角（度） 结果		//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3总下倾角（度） 备注		//新改成接通时延   log_AttachDelay
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 机械下倾角（度）		//新改成RSSI  log_RSSI
		col = 0;
		row = rowTo + 1;
		colTo = col + 2;
		rowTo = row;
		map.put("cellValue", Map.get("RSSI"));//新改成RSSI  log_RSSI
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区1机械下倾角（度） 规划数据		//新改成RSSI  log_RSSI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(0).getLog_RSSI());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1机械下倾角（度） 实测数据		//新改成RSSI  log_RSSI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1机械下倾角（度） 结果		//新改成RSSI  log_RSSI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区2机械下倾角（度） 规划数据		//新改成RSSI  log_RSSI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(1).getLog_RSSI());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2机械下倾角（度） 实测数据		//新改成RSSI  log_RSSI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2机械下倾角（度） 结果		//新改成RSSI  log_RSSI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 小区3机械下倾角（度） 规划数据		//新改成RSSI  log_RSSI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",logList.get(2).getLog_RSSI());
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3机械下倾角（度） 实测数据		//新改成RSSI  log_RSSI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3机械下倾角（度） 结果		//新改成RSSI  log_RSSI
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("columnWidth", 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3机械下倾角（度） 备注		//新改成RSSI  log_RSSI
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 0;
		row = row + 1;
		colTo = 18;
		rowTo = row + 1;
		map.put("cellValue", "");
		map.put("fontSize", (short) 12);
		map.put("map", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		return rowTo;
	}

	/**
	 * 业务验证
	 * @param lang 
	 */
	public int BusinessVerification(HSSFWorkbook wb, HSSFSheet sheet, List<LogDomain> logList, int col, int row,
			int colTo, int rowTo, Map map, String lang) throws Exception {
		StringBuffer sb = new StringBuffer();
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		col = col;
		row = row + 1;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", Map.get("TestingItems"));
		map.put("map", null);
		map.put("borderTop", null);
		map.put("borderRight", null);
		map.put("borderBottom", null);
		map.put("borderLeft", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 0;
		row = rowTo + 1;
		colTo = col + 3;
		rowTo = row + 1;
		//业务验证
		map.put("cellValue", "");
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 12);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 验证通过
		col = colTo + 1;
		row = row;
		colTo = col + 2;
		rowTo = row;

		map.put("cellValue", Map.get("VerifyThrough"));
		map.put("fontWeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col;
		row = row + 1;
		colTo = col;
		rowTo = row;
		map.put("cellValue", Map.get("Sector1"));
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", Map.get("Sector2"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = col + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", Map.get("Sector3"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 备注
		col = col + 1;
		row = row - 1;
		colTo = 18;
		rowTo = row + 1;
		map.put("cellValue", Map.get("Remarks"));
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 基站工程师验证项
		col = 0;
		row = rowTo + 1;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", Map.get("BaseStationE"));
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 上行业务拨测
		col = colTo + 1;
		row = row;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", Map.get("UplinkSurvey"));
		map.put("fontSize", (short) 12);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 3个小区“是”
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", Map.get("Yes"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",  Map.get("Yes"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue",  Map.get("Yes"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
//每个小区发起attach附着，并上行发包3次，确保终端可以附着成功，发包业务成功。
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", Map.get("EachCommunity"));
		map.put("fontCenter", false);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 网优工程师验证项
		col = 0;
		row = row + 1;
		colTo = col + 1;
		rowTo = row + 3;
		map.put("cellValue", Map.get("CheckingItems"));
		map.put("fontCenter", true);
		map.put("fontSize", (short) 10);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 接入成功率测试
		col = colTo + 1;
		row = row;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", Map.get("Attach"));
		map.put("fontCenter", true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1 接入成功率
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(0).getLog_openRate());
		map.put("fontCenter", true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2 接入成功率
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(1).getLog_openRate());
		map.put("fontCenter", true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3 接入成功率
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(2).getLog_openRate());
		map.put("fontCenter", true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 备注
		sb.append("RRC建立成功率\n").append("1）定点测试：RSRP≥-80dBm，SINR≥20dB\n")
				.append("2）做Ping业务测试，每次Ping间隔10S（大于UE不活动定时器），确保终端可以回到空闲态。\n").append("3）测试次数要求最少10次。\n")
				.append("验收标准：成功率100%");
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", sb.toString());
		map.put("fontCenter", false);
		map.put("rowHeight", (short) 2600);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 时延测试
		col = 2;
		row = row + 1;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", Map.get("Ping"));
		map.put("fontCenter", true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1 ping时延
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(0).getLog_delayTime());
		map.put("fontCenter", true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2 ping时延
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(1).getLog_delayTime());
		map.put("fontCenter", true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3 ping时延
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(2).getLog_delayTime());
		map.put("fontCenter", true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 备注
		sb.append("PING 32Bytes时延\n").append("1）定点测试：RSRP≥-80dBm，SINR≥20dB\n").append("2）空载网络/轻载网络闲时测试。\n")
				.append("3）连续测试次数要求最少50次。\n").append("4）测试间隔时间为2S。\n")
				.append("5）传输时延小于3ms，端到端时延抖动小于2ms，建议服务器直接连接PGW测试。\n").append("6）排除非RAN侧或非华为设备原因引起的指标异常\n")
				.append("验收标准：<1.5秒");
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", sb.toString());
		map.put("fontCenter", false);
		map.put("rowHeight", (short) 3000);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 单用户上行吞吐率测试
		col = 2;
		row = row + 1;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", Map.get("UplinkThroughput"));
		map.put("fontCenter", true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1 单用户上行吞吐率测试
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(0).getLog_UDPTop_rate());
		map.put("fontCenter", true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2 单用户上行吞吐率测试
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(1).getLog_UDPTop_rate());
		map.put("fontCenter", true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3 单用户上行吞吐率测试
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(2).getLog_UDPTop_rate());
		map.put("fontCenter", true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 备注
		sb.append("上行速率测试：").append("1）空载网络\n").append("2）定点测试，选择RSRP≥-80dBm，SINR≥20dB。\n").append("3）上行发包≥300Bytes；\n")
				.append("4）连续测试次数要求最少10次。\n").append("5）排除非RAN侧原因引起的指标异常\n").append("6）排除由于非华为设备原因引起的指标异常\n")
				.append("测试方法：\n").append("1）通过Probe路测工具提供的AT命令配置功能发送300Bytes的数据。\n").append("2）观察路测工具中MAC层上行吞吐率。\n")
				.append("验收标准：\n").append("10kbps");
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", sb.toString());
		map.put("fontCenter", false);
		map.put("rowHeight", (short) 2600);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 单用户下行吞吐率测试
		col = 2;
		row = row + 1;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", Map.get("DownlinkThroughput"));
		map.put("fontCenter", true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区1 单用户上行吞吐率测试
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(0).getLog_UDPDown_rate());
		map.put("fontCenter", true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区2 单用户上行吞吐率测试
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(1).getLog_UDPDown_rate());
		map.put("fontCenter", true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 小区3 单用户上行吞吐率测试
		col = colTo + 1;
		row = row;
		colTo = col;
		rowTo = row;
		map.put("cellValue", logList.get(2).getLog_UDPDown_rate());
		map.put("fontCenter", true);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 备注
		sb.append("下行速率测试：：").append("1）空载网络\n").append("2）定点测试，选择RSRP≥-80dBm，SINR≥20dB。\n")
				.append("3）下行ftp文件大小约1MBytes；\n").append("4）持续下载5分钟以上。\n").append("5）排除非RAN侧原因引起的指标异常。\n")
				.append("6）排除由于非华为设备原因引起的指标异常\n").append("测试方法：\n").append("1）通过FTP服务器向终端发起下行灌包业务\n")
				.append("2）观察路测工具中MAC层下行吞吐率。\n").append("验收标准：\n").append("15kbps");
		col = colTo + 1;
		row = row;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", sb.toString());
		map.put("fontCenter", false);
		map.put("rowHeight", (short) 2600);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 0;
		row = row + 1;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontCenter", true);
		map.put("rowHeight", (short) 500);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		return rowTo;
	}

	/**
	 * 验证结论
	 * @param lang 
	 */
	public int VerificationConclusion(HSSFWorkbook wb, HSSFSheet sheet, List<LogDomain> logList, int col, int row,
			int colTo, int rowTo, Map map, String lang) throws Exception {
		String str = lang;
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		StringBuffer sb = new StringBuffer();
		col = 0;
		row = rowTo + 1;
		colTo = 18;
		rowTo = row + 1;
		//验证结论
		map.put("cellValue", Map.get("VerificationResult"));
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 12);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_THICK);
		map.put("borderRight", HSSFCellStyle.BORDER_THICK);
		map.put("borderBottom", HSSFCellStyle.BORDER_THICK);
		map.put("borderLeft", HSSFCellStyle.BORDER_THICK);

		map.put("fontCenter", false);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 1;
		row = rowTo + 2;
		colTo = col + 1;
		rowTo = row;
		map.put("borderTop", null);
		map.put("borderRight", null);
		map.put("borderBottom", null);
		map.put("borderLeft", null);
		//是否通过验证：
		map.put("cellValue", Map.get("SuccessOrNot"));
		map.put("fontWeight", null);
		map.put("fontSize", (short) 12);
		map.put("fontType", "楷书");
		map.put("map", null);
		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 验证结果
		col = colTo + 1;
		row = rowTo;
		colTo = col;
		rowTo = row;
		map.put("cellValue", "");
		map.put("fontWeight", null);
		map.put("fontSize", (short) 12);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 备注
		sb.append("");
		col = 0;
		row = rowTo + 2;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", Map.get("Note") + sb);
		map.put("fontWeight", null);
		map.put("fontSize", (short) 12);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);

		map.put("fontCenter", false);
		map.put("columnWidth", null);
		map.put("rowHeight", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = 0;
		row = rowTo + 1;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("map", null);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		return rowTo;
	}

	/**
	 * 工程师信息
	 */
	public int EngineerDesc(HSSFWorkbook wb, HSSFSheet sheet, Plane plane, int col, int row, int colTo, int rowTo,
			Map map,String lang) throws Exception {
		String str = lang;
		Map<String, String> Map = I18nUtil.getLangMap(lang);
		col = 0;
		row = rowTo + 1;
		colTo = col + 1;
		rowTo = row;
		//工程师类型
		map.put("cellValue", Map.get("Engineers"));
		map.put("fontWeight", (short) 1000);
		map.put("fontSize", (short) 14);
		map.put("fontType", "楷书");
		map.put("borderTop", HSSFCellStyle.BORDER_THIN);
		map.put("borderRight", HSSFCellStyle.BORDER_THIN);
		map.put("borderBottom", HSSFCellStyle.BORDER_THIN);
		map.put("borderLeft", HSSFCellStyle.BORDER_THIN);

		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("columnWidth", null);
		map.put("rowHeight", (short) 400);
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		//姓名
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		//日期
		map.put("cellValue", Map.get("DateN"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		//电话
		map.put("cellValue", Map.get("Telephone"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		col = colTo + 1;
		row = rowTo;
		colTo = 18;
		rowTo = row;
		//签名
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 基站工程师
		col = 0;
		row = rowTo + 1;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", Map.get("Backend"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 基站工程师姓名
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", plane.getPlan_test_engineer());
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 基站工程师日期
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 基站工程师电话
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", plane.getPlan_te_phone());
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 基站工程师签名
		col = colTo + 1;
		row = rowTo;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		// 网优工程师
		col = 0;
		row = rowTo + 1;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", Map.get("Testing"));
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 网优工程师姓名
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 网优工程师日期
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 网优工程师电话
		col = colTo + 1;
		row = rowTo;
		colTo = col + 1;
		rowTo = row;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);
		// 网优工程师签名
		col = colTo + 1;
		row = rowTo;
		colTo = 18;
		rowTo = row;
		map.put("cellValue", "");
		map.put("col", col);
		map.put("row", row);
		map.put("colTo", colTo);
		map.put("rowTo", rowTo);
		ExcelPoiUtil.createCell(wb, sheet, map);

		return rowTo;
	}

}