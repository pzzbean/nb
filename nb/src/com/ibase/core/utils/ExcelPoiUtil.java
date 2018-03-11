package com.ibase.core.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

public class ExcelPoiUtil {

	@Test
	public void test() throws Exception, IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet1 = wb.createSheet("sheet1");

		Map map = new HashMap();
		map.put("cellValue", "qdd1");
		map.put("columnWidth", 10000);
		map.put("fontSize", (short) 16);
		map.put("rowHeight", (short) 1000);
		map.put("fontWeight", null);
		map.put("LRAlignment", true);
		map.put("TBAlignment", true);
		map.put("fontColour", HSSFColor.BLUE.index);
		map.put("backgroundColour", HSSFColor.RED.index);
		map.put("borderBottom", HSSFCellStyle.BORDER_THICK);
		map.put("borderLeft", HSSFCellStyle.BORDER_THICK);
		map.put("borderRight", HSSFCellStyle.BORDER_THICK);
		map.put("borderTop", HSSFCellStyle.BORDER_THICK);
		map.put("col", 1);
		map.put("row", 1);
		map.put("colTo", 4);
		map.put("rowTo", 1);
		createCell(wb, sheet1, map);

		map.put("backgroundColour", null);
		map.put("col", 1);
		map.put("row", 2);
		map.put("colTo", 4);
		map.put("rowTo", 2);
		createCell(wb, sheet1, map);

		FileOutputStream fileOut = new FileOutputStream("d:/poi.xls");
		wb.write(fileOut);

	}

	/**
	 * cellValue(String):单元格的值 col（int）:开始列 row:开始行 colTo(int):结束列 rowTo(int)：结束行
	 * 列宽：columnWidth(int) 行高：rowHeight(short)
	 * 边框线样式：borderBottom（下），borderLeft(左)，borderRight(右)，borderTop（上）
	 * 值：HSSFCellStyle.BORDER_THIN(黑线)、 HSSFCellStyle.BORDER_THICK(粗黑线)
	 * 字号：fontSize(short) 左右居中：LRAlignment（true,false） 上下居中：TBAlignment(true,false)
	 * 字体颜色：fontColour 值：HSSFColor.RED.index...... 字体名称：fontName(String)
	 * 字体加粗：fontWeight(short) 值：map.put("fontWeight",(short)1000)
	 * 背景色：backgroundColour 值：HSSFColor.BLUE.index......
	 */
	public static void createCell(HSSFWorkbook wb, HSSFSheet sheet, Map map) {
		HSSFFont font = wb.createFont();
		HSSFCellStyle style = wb.createCellStyle();
		HSSFRow row = sheet.getRow((int) map.get("row"));

		if (row == null) {
			row = sheet.createRow((int) map.get("row"));
		}
		HSSFCell cell = row.createCell((int) map.get("col"));
		cell.setCellValue((String) map.get("cellValue"));

		// 设置列宽、行高
		rowHeightAndColWidth(sheet, row, map);

		// 边框设置
		border(style, map);

		// 字体设置（字号、居中、颜色）
		font(style, font, map);

		// 单元格背景色
		backgroundColour(style, map);

		style.setFont(font);
		cell.setCellStyle(style);

		// 合并单元格
		MergedRegion(sheet, style, map);
	}

	/**
	 * 合并单元格
	 */
	public static void MergedRegion(HSSFSheet sheet, HSSFCellStyle style, Map map) {
		int rowNum = (int) map.get("row");
		int rowToNum = (int) map.get("rowTo");
		int colNum = (int) map.get("col");
		int colToNum = (int) map.get("colTo");
		// 没有合并的单元格则退出
		if (rowNum == rowToNum && colNum == colToNum) {
			return;
		}
		// 合并单元格
		if (map.get("colTo") != null && map.get("rowTo") != null) {
			CellRangeAddress cra = new CellRangeAddress(rowNum, rowToNum, colNum, colToNum);
			sheet.addMergedRegion(cra);
		}
		// 给单元格加样式
		for (int i = rowNum; i <= rowToNum; i++) {
			HSSFRow row = sheet.getRow(i);
			if (row == null)
				row = sheet.createRow(i);
			for (int j = colNum; j <= colToNum; j++) {
				HSSFCell cell = row.getCell(j);
				if (cell == null)
					cell = row.createCell(j);
				cell.setCellStyle(style);
			}
		}

	}

	/**
	 * 设置背景色
	 */
	public static void backgroundColour(HSSFCellStyle style, Map map) {
		// 单元格背景色
		if (map.get("backgroundColour") != null) {
			style.setFillForegroundColor((short) map.get("backgroundColour"));
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		}
		// style.setFillBackgroundColor(HSSFColor.AQUA.index);
		// style.setFillPattern(HSSFCellStyle.BIG_SPOTS);
	}

	/**
	 * 设置列宽、行高
	 */
	public static void rowHeightAndColWidth(HSSFSheet sheet, HSSFRow row, Map map) {
		// 设置列宽
		if (map.get("columnWidth") != null) {
			sheet.setColumnWidth((int) map.get("col"), (int) map.get("columnWidth"));
		}
		// 设置行高
		if (map.get("rowHeight") != null) {
			row.setHeight((short) map.get("rowHeight"));
		}
	}

	/**
	 * 边框设置
	 */
	public static void border(HSSFCellStyle style, Map map) {
		// 边框线
		if (map.get("borderBottom") != null) {
			style.setBorderBottom((short) map.get("borderBottom"));// 下边框
		}
		if (map.get("borderLeft") != null) {
			style.setBorderLeft((short) map.get("borderLeft"));// 下边框
		}
		if (map.get("borderRight") != null) {
			style.setBorderRight((short) map.get("borderRight"));// 下边框
		}
		if (map.get("borderTop") != null) {
			style.setBorderTop((short) map.get("borderTop"));// 下边框
		}
	}

	/**
	 * 字体设置
	 */
	private static void font(HSSFCellStyle style, HSSFFont font, Map map) {
		// 字号
		if (map.get("fontSize") != null) {
			font.setFontHeightInPoints((short) map.get("fontSize"));
		}
		// 左右居中
		if (map.get("LRAlignment") != null && (boolean) map.get("LRAlignment") == true) {
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		}
		// 上下居中
		if (map.get("TBAlignment") != null && (boolean) map.get("TBAlignment") == true) {
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
		}
		// 字体颜色
		if (map.get("fontColour") != null) {
			font.setColor((short) map.get("fontColour"));
		}
		// 字体加粗
		if (map.get("fontWeight") != null) {
			font.setBoldweight((short) map.get("fontWeight"));
		}
		// 字体名称
		if (map.get("fontName") != null) {
			font.setFontName((String) map.get("fontName"));
		}
	}

	/**
	 * 插入图片的方法
	 * @param out
	 * @param wb
	 * @param sheet
	 * @param adderss 
	 * @throws IOException
	 */
	public static void createImage(OutputStream out, HSSFWorkbook wb, HSSFSheet sheet, String adderss,int row) throws IOException {
		BufferedImage bufferImg = null;
		// 先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
		
		ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
		bufferImg = ImageIO.read(new File(adderss));
		ImageIO.write(bufferImg, "jpg", byteArrayOut);
		// 画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// anchor主要用于设置图片的属性
		
		HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 255, 255, (short) 2, row, (short) 15, 23+row);//col row
//		anchor.setAnchorType(3);
		// 插入图片
		patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));

	}
}