package com.ibase.web.workparam_in.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ibase.web.log.domain.LogDomain;
import com.ibase.web.plane.domain.Plane;
import com.ibase.web.workparam_in.domain.WorkParam_inDomain;

import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelWorkParam_in {
	@Test
	public void text()throws Exception {
		String filePath = "d:\\工参.xls";
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
		wordParam1.setStatus(1);
		
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
		wordParam2.setStatus(1);
		
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
		wordParam3.setStatus(-1);
		
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
		
		
		
		
		createExcel(os,wordParamList);
		
		
		
	}
	public static void createExcel(OutputStream out,List<WorkParam_inDomain> wordParamList)throws Exception{
				// 创建Excel工作薄 
				WritableWorkbook wwb = Workbook.createWorkbook(out);
				//创建一个sheet（可以创建多个sheet,一个工作薄可以有多个sheet
				WritableSheet sheet = wwb.createSheet("工参", 0);
				
				Label lable;
				WritableFont wfont = new WritableFont(WritableFont.createFont("楷书"),11);//设置字体、大小、加粗
				WritableCellFormat wcf = new WritableCellFormat(wfont);;
				
				int col;//列
				int row;//行
				int col_;
				int row_;		
				addLableBold(wfont,wcf,sheet,"站号",0,0);
				addLableBold(wfont,wcf,sheet,"站高",1,0);
				addLableBold(wfont,wcf,sheet,"基站经度",2,0);
				addLableBold(wfont,wcf,sheet,"基站维度",3,0);
				addLableBold(wfont,wcf,sheet,"TAC",4,0);
				addLableBold(wfont,wcf,sheet,"ENBID",5,0);
				addLableBold(wfont,wcf,sheet,"扇区",6,0);
				addLableBold(wfont,wcf,sheet,"ECI",7,0);
				addLableBold(wfont,wcf,sheet,"PCI",8,0);
				addLableBold(wfont,wcf,sheet,"工作模式",9,0);
				addLableBold(wfont,wcf,sheet,"扇区方位角",10,0);
				addLableBold(wfont,wcf,sheet,"扇区倾角",11,0);
				addLableBold(wfont,wcf,sheet,"上行频点",12,0);
				addLableBold(wfont,wcf,sheet,"上行带宽",13,0);
				addLableBold(wfont,wcf,sheet,"下行频点",14,0);
				addLableBold(wfont,wcf,sheet,"下行带宽",15,0);
				addLableBold(wfont,wcf,sheet,"与运营商是否一致",16,0);
				
				
				for(int i=0;i<wordParamList.size();i++){
					addLable(wfont,wcf,sheet,wordParamList.get(i).getWp_station_no(),0,i+1);
					addLable(wfont,wcf,sheet,wordParamList.get(i).getWp_station_height(),1,i+1);
					addLable(wfont,wcf,sheet,wordParamList.get(i).getWp_station_longitude(),2,i+1);
					addLable(wfont,wcf,sheet,wordParamList.get(i).getWp_station_latitude(),3,i+1);
					addLable(wfont,wcf,sheet,wordParamList.get(i).getWp_station_TAC(),4,i+1);
					addLable(wfont,wcf,sheet,wordParamList.get(i).getWp_station_ENBID(),5,i+1);
					addLable(wfont,wcf,sheet,wordParamList.get(i).getWp_cell_section(),6,i+1);
					addLable(wfont,wcf,sheet,wordParamList.get(i).getWp_cell_ECI(),7,i+1);
					addLable(wfont,wcf,sheet,wordParamList.get(i).getWp_cell_PCI(),8,i+1);
					addLable(wfont,wcf,sheet,wordParamList.get(i).getWp_cell_workModel(),9,i+1);
					addLable(wfont,wcf,sheet,wordParamList.get(i).getWp_cell_bearing(),10,i+1);
					addLable(wfont,wcf,sheet,wordParamList.get(i).getWp_cell_dipAangle(),11,i+1);
					addLable(wfont,wcf,sheet,wordParamList.get(i).getWp_cell_top_frequency(),12,i+1);
					addLable(wfont,wcf,sheet,wordParamList.get(i).getWp_cell_top_bandwidth(),13,i+1);
					addLable(wfont,wcf,sheet,wordParamList.get(i).getWp_cell_down_frequency(),14,i+1);
					addLable(wfont,wcf,sheet,wordParamList.get(i).getWp_cell_down_frequency(),15,i+1);
			        if(wordParamList.get(i).getStatus()==1){
			        	addLable(wfont,wcf,sheet,"一致",16,i+1);
			        }else if(wordParamList.get(i).getStatus()==-1){
			        	addLable(wfont,wcf,sheet,"不一致",16,i+1);
			        }
					
				}
				
				
				// 写入数据 
				wwb.write(); 
				// 关闭文件 
				wwb.close();
	}
	/**
	 * 加粗
	 * @throws Exception 
	 */
	public static void addLableBold(WritableFont wfont,WritableCellFormat wcf,WritableSheet sheet,String value,int col,int row) throws Exception{
		wfont = new WritableFont(WritableFont.createFont("楷书"),11,WritableFont.BOLD);//设置字体、大小、加粗
		wcf = new WritableCellFormat(wfont);
		wcf.setAlignment(Alignment.CENTRE); // 设置居中
		wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 设置边框线
		Label lable = new Label(col,row,value,wcf);
		sheet.setColumnView(col, 20);
		sheet.addCell(lable);
	}
	/**
	 * 不加粗
	 * @throws WriteException 
	 */
	public static void addLable(WritableFont wfont,WritableCellFormat wcf,WritableSheet sheet,String value,int col,int row) throws WriteException{
		wfont = new WritableFont(WritableFont.createFont("楷书"),11);//设置字体、大小、加粗
		wcf = new WritableCellFormat(wfont);
		wcf.setAlignment(Alignment.CENTRE); // 设置居中
		wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 设置边框线
		Label lable = new Label(col,row,value,wcf);
		sheet.setColumnView(col, 20);
		sheet.addCell(lable);
	}
	/**
	 * 标头
	 * @throws WriteException 
	 */
	public static void addHead(WritableFont wfont,WritableCellFormat wcf,WritableSheet sheet,String value,int col,int row,int col_,int row_) throws WriteException{
		wfont = new WritableFont(WritableFont.createFont("楷书"), 16,WritableFont.BOLD);//设置字体、大小、加粗
		wcf = new WritableCellFormat(wfont);
		wcf.setAlignment(Alignment.CENTRE); // 设置居中
		wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 设置边框线
		wcf.setBackground(jxl.format.Colour.GRAY_50); // 设置单元格的背景颜色		
		
		Label lable  = new Label(col,row,value,wcf);
		sheet.mergeCells(col,row,col_,row_);//合并单元格
		sheet.addCell(lable);
	}
	/**
	 * 扇区
	 * col、row为“扇区”的坐标
	 */
	public static void addCellNO(WritableFont wfont,WritableCellFormat wcf,WritableSheet sheet,String value,int col,int row) throws WriteException{
		wfont = new WritableFont(WritableFont.createFont("楷书"), 11,WritableFont.BOLD);//设置字体、大小、加粗
		wfont.setColour(Colour.RED);
		wcf = new WritableCellFormat(wfont);
		wcf.setAlignment(Alignment.CENTRE); // 设置居中THIN  
		wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 设置边框线
		
		Label lable  = new Label(col,row,"扇区",wcf);
		sheet.addCell(lable);
		lable = new Label(col+1,row,value,wcf);
		sheet.mergeCells(col+1,row,col+3,row);//合并单元格
		sheet.addCell(lable);
	}
	/**
	 * “达标”、“不达标”
	 */
	public static void addStatus(WritableFont wfont,WritableCellFormat wcf,WritableSheet sheet,String value,int col,int row) throws WriteException{
		wfont = new WritableFont(WritableFont.createFont("楷书"), 11,WritableFont.BOLD);//设置字体、大小、加粗
		wfont.setColour(Colour.BLUE);
		wcf = new WritableCellFormat(wfont);
		wcf.setAlignment(Alignment.CENTRE); // 设置居中
		wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 设置边框线
		
		Label lable = new Label(col,row,value,wcf);
		sheet.mergeCells(col,row,col+3,row);//合并单元格
		sheet.addCell(lable);
	}
    
	/**
	 * 最后一位
	 */
	public static void addLast(WritableFont wfont,WritableCellFormat wcf,WritableSheet sheet,String value,int col,int row) throws WriteException{
		wfont = new WritableFont(WritableFont.createFont("楷书"), 11);//设置字体、大小、加粗
		wcf = new WritableCellFormat(wfont);
		wcf.setAlignment(Alignment.CENTRE); // 设置居中
		wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 设置边框线
		
	    Label lable = new Label(col,row,value,wcf);
		sheet.mergeCells(col,row,col+2,row);//合并单元格
		sheet.addCell(lable);
	}
}
