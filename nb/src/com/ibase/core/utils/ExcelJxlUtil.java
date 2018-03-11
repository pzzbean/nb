package com.ibase.core.utils;

import java.awt.Color;
import java.util.Map;

import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;

public class ExcelJxlUtil {
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
	 *  
	 *  cellBackground:单元格背景色，无颜色填null
	 *  	jxl.format.Colour.RED:红色
	 *  	jxl.format.Colour.BLUE:蓝色
	 *  	......
	 *  
	 * fontColour:字体颜色
	 * 		值：Colour.RED......
	 *  
	 */
	public static void createcell(WritableSheet sheet,Map map) throws Exception{
		WritableFont wfont = null;
		WritableCellFormat wcf = null;
		
		//是否加粗，字体，字体大小
		if((boolean)map.get("bold")){
			wfont = new WritableFont(WritableFont.createFont((String)map.get("fontType")),(int)map.get("fontSize"),WritableFont.BOLD);//设置字体、大小、加粗
		}else{
			wfont = new WritableFont(WritableFont.createFont((String)map.get("fontType")),(int)map.get("fontSize"));//设置字体、大小、加粗
		}		
		//字体颜色
		if(map.get("fontColour")!=null){
			wfont.setColour((Colour)map.get("fontColour"));
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
		//单元格背景色
		if(map.get("cellBackground")!=null){
			wcf.setBackground((Colour)map.get("cellBackground"));
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

}
