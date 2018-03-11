package com.ibase.text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import com.ibase.web.log.domain.LogDomain;
import com.ibase.web.plane.domain.Plane;
import com.ibase.web.workparam_in.domain.WorkParam_inDomain;

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
import sun.misc.BASE64Encoder;

public class Text1 {
	public static void main(String[] args) {
		new Text1().test();
	}
	
	@Test
	public void test(){
		//需要参数logid
		int log_id = 1;
		/*LogDomain ld = new LogDomain();
		ld.setLog_id(log_id);
		//通过log_id查询log表中的对应数据
		LogDomain log = logService.searchSingleLog(ld);
		*/
		//暂时用假数据替换上面的值
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
		//通过log中的plane_id查询对应plane
		//暂时做假数据
		Plane plane = new Plane();
		plane.setPlan_id(1);
		plane.setPlan_test_engineer("杜鹏程");
		plane.setPlan_te_phone("13800138000");
		plane.setPlan_back_engineer("宛少文");
		plane.setPlan_be_phone("13800138000");
		plane.setPlane_test_content("F03624");
		plane.setPlane_test_time("2017-9-20");
		
		String filePath = "d:\\单站点检验报告.xls";
		OutputStream os = null;
		try {
			os = new FileOutputStream(filePath);
			createExcelSheet2(os,log,plane);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void createExcelSheet2(OutputStream os, LogDomain log, Plane plane) {
		WritableWorkbook wwb = null;
		try {
			wwb = Workbook.createWorkbook(os);
			//创建一个sheet（可以创建多个sheet,一个工作薄可以有多个sheet
			WritableSheet sheet = wwb.createSheet("网优工程师测试表格", 1);
			//添加最上方的标题
			addHeadSheet2(sheet,log);
			//添加标题下面的基本信息
			addBaseInfo(sheet,log,plane);
			addBlankCell(sheet);
			//添加下方第一个表格
			addTable1Info(sheet,log,plane);
			//添加下方第二个表格
			addTable2Info(sheet,log,plane);
			setColumnView(sheet);
			// 写入数据 
			wwb.write(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			// 关闭文件 
			try {
				if(wwb!=null){
					wwb.close();
				}
				
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void setColumnView(WritableSheet sheet){
		sheet.setColumnView(1, 2);
		sheet.setColumnView(2, 2);
		sheet.setColumnView(3, 2);
		sheet.setColumnView(7, 2);
		sheet.setColumnView(8, 2);
		sheet.setColumnView(9, 2);
		sheet.setColumnView(10, 2);
		sheet.setColumnView(14,2);
		sheet.setColumnView(15, 2);
		sheet.setColumnView(17, 2);
		sheet.setColumnView(18, 2);
		sheet.setColumnView(19, 2);
		sheet.setColumnView(21,2);
		sheet.setColumnView(22, 2);
		sheet.setColumnView(23, 2);
		sheet.setColumnView(24, 2);
		for(int i=25;i<60;i++){
			sheet.setColumnView(i, 3);
		}
	}
	
	public void addBlankCell(WritableSheet sheet) {
		WritableFont wfont = new WritableFont(WritableFont.createFont("宋体"),10,WritableFont.NO_BOLD);//设置字体、大小、加粗
		WritableCellFormat wcf = new WritableCellFormat(wfont);
		try {
			// 设置居中
			Label lable  = new Label(0,5,"",wcf);
			sheet.mergeCells(0,5,3,16);//合并单元格
			sheet.addCell(lable);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	//添加下方表格2
	public void addTable2Info(WritableSheet sheet,LogDomain log, Plane plane){
			//灰色标题
			addGrayTitle(sheet,"FTP吞吐量测试",4,10,14,10);
			addGrayTitle(sheet,"好点",15,10,39,10);
			//灰色标题后的空格
			addTableCell(sheet,"",40,10,49,10);
			//添加表格左侧标题
			addTableCell(sheet,"FTP下行吞吐量",4,11,9,13);
			addTableCell(sheet,"FTP上行吞吐量",4,14,9,16);
			addTableCell(sheet,"RSRP(dBm)",10,11,14,11);
			addTableCell(sheet,"Average SINR(dB)",10,12,14,12);
			addTableCell(sheet,"下行吞吐量(kbps)",10,13,14,13);
			addTableCell(sheet,"RSRP(dBm)",10,14,14,14);
			addTableCell(sheet,"Average SINR(dB)",10,15,14,15);
			addTableCell(sheet,"上行吞吐量(kbps)",10,16,14,16);
			
			for(int i=11;i<17;i++){
				addTableCell(sheet,"",15,i,39,i);
			}
			
			//两个备注下面的单元格的值
			addTableCell(sheet,"",40,11,49,13);
			addTableCell(sheet,"",40,14,49,16);
			
		}
	//添加下方表格1
	public void addTable1Info(WritableSheet sheet,LogDomain log, Plane plane){
		//单验工程师业务验证项：
		addtableTitle(sheet);
		//备注
		addRemarks(sheet);
		//灰色标题
		addGrayTitle(sheet,"业务测试情况：",4,5,14,5);
		addGrayTitle(sheet,"尝试次数",15,5,21,5);
		addGrayTitle(sheet,"成功次数",22,5,27,5);
		addGrayTitle(sheet,"失败次数",28,5,33,5);
		addGrayTitle(sheet,"成功率",34,5,39,5);
		//验证标准调用普通表格内容的方法
		addTableCell(sheet,"验证标准",40,5,49,5);
		//添加表格左侧标题
		addTableCell(sheet,"RRC Setup Success Rate",4,6,14,6);
		addTableCell(sheet,"ERAB Setup Success Rate",4,7,14,7);
		addTableCell(sheet,"Access Success Rate",4,8,14,8);
		addTableCell(sheet,"Ping时延测试",4,9,14,9);
		//添加表格数据
		for(int i=6;i<10;i++){
			addTableCell(sheet,"0",15,i,21,i);
			addTableCell(sheet,"0",22,i,27,i);
			addTableCell(sheet,"0",28,i,33,i);
			addTableCell(sheet,"0.00%",34,i,39,i);
			addTableCell(sheet,"",40,i,49,i);
		}
	}
	public void addTableCell(WritableSheet sheet,String title,int col,int row,int _col,int _row) {
		WritableFont wfont = new WritableFont(WritableFont.createFont("宋体"),10,WritableFont.NO_BOLD);//设置字体、大小、加粗
		WritableCellFormat wcf = new WritableCellFormat(wfont);
		try {
			// 设置居中
			wcf.setAlignment(Alignment.CENTRE);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			Label lable  = new Label(col,row,title,wcf);
			sheet.mergeCells(col,row,_col,_row);//合并单元格
			sheet.addCell(lable);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public void addGrayTitle(WritableSheet sheet,String title,int col,int row,int _col,int _row) {
		WritableFont wfont = new WritableFont(WritableFont.createFont("宋体"),10,WritableFont.NO_BOLD);//设置字体、大小、加粗
		WritableCellFormat wcf = new WritableCellFormat(wfont);
		try {
			// 设置居中
			wcf.setAlignment(Alignment.CENTRE);
			wcf.setBackground(jxl.format.Colour.GRAY_50);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			Label lable  = new Label(col,row,title,wcf);
			sheet.mergeCells(col,row,_col,_row);//合并单元格
			sheet.addCell(lable);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	public void addtableTitle(WritableSheet sheet){
		WritableFont wfont = new WritableFont(WritableFont.createFont("宋体"),14,WritableFont.BOLD);//设置字体、大小、加粗
		WritableCellFormat wcf = new WritableCellFormat(wfont);
		try {
			// 设置居中
			wcf.setAlignment(Alignment.CENTRE);
			wcf.setBorder(Border.BOTTOM, BorderLineStyle.THICK);
			Label lable  = new Label(0,4,"单验工程师业务验证项：",wcf);
			sheet.mergeCells(0,4,39,4);//合并单元格
			sheet.addCell(lable);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void addRemarks(WritableSheet sheet){
		//备注
		WritableFont wfont = new WritableFont(WritableFont.createFont("宋体"),10,WritableFont.BOLD);//设置字体、大小、加粗
		WritableCellFormat wcf = new WritableCellFormat(wfont);
		try {
			// 设置居中
			wcf.setAlignment(Alignment.CENTRE);
			wcf.setBorder(Border.ALL, BorderLineStyle.THICK);
			Label lable  = new Label(40,4,"备注",wcf);
			sheet.mergeCells(40,4,49,4);//合并单元格
			sheet.addCell(lable);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	//添加标题下面的基本信息
	public void addBaseInfo(WritableSheet sheet,LogDomain log, Plane plane){
		//添加标题
		addBaseInfoTitle(sheet,"站名：",0,1,0,1);
		addBaseInfoValue(sheet,"",2,1,14,1);
		
		addBaseInfoTitle(sheet,"站号：",16,1,16,1);
		addBaseInfoValue(sheet,log.getStation_no(),20,1,23,1);
		
		addBaseInfoTitle(sheet,"日期：",0,2,0,2);
		addBaseInfoValue(sheet,"",2,2,5,2);
		
		addBaseInfoTitle(sheet,"测试手机型号：",6,2,6,2);
		addBaseInfoValue(sheet,"",11,2,13,2);
		
		addBaseInfoTitle(sheet,"测试手机号码1：",14,2,19,2);
		addBaseInfoValue(sheet,plane.getPlan_te_phone(),20,2,24,2);
		
		addBaseInfoTitle(sheet,"测试手机号码2：",25,2,30,2);
		addBaseInfoValue(sheet,"",31,2,35,2);
		
		addBaseInfoTitle(sheet,"优化工程师：",36,2,39,2);
		addBaseInfoValue(sheet,"",40,2,45,2);
		
		addBaseInfoTitle(sheet,"软件版本：",0,3,0,3);
		addBaseInfoValue(sheet,"",4,3,12,3);
	}
	//添加标题下面的站名：XX  站号：XX 等的小标题
	public void addBaseInfoTitle(WritableSheet sheet,String title,int col,int row,int _col,int _row){
		
		WritableFont wfont = new WritableFont(WritableFont.createFont("宋体"),10,WritableFont.NO_BOLD);//设置字体、大小、加粗
		WritableCellFormat wcf = new WritableCellFormat(wfont);
		try {
			// 设置居中
			wcf.setAlignment(Alignment.CENTRE);
			Label lable  = new Label(col,row,title,wcf);
			sheet.mergeCells(col,row,_col,_row);//合并单元格
			sheet.addCell(lable);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	//添加标题下面的站名：XX  站号：XX 等的值
		public void addBaseInfoValue(WritableSheet sheet,String value,int col,int row,int _col,int _row){
			
			WritableFont wfont = new WritableFont(WritableFont.createFont("宋体"),10,WritableFont.NO_BOLD);//设置字体、大小、加粗
			WritableCellFormat wcf = new WritableCellFormat(wfont);
			try {
				// 设置居中
				wcf.setAlignment(Alignment.CENTRE);
				wcf.setBorder(Border.BOTTOM, BorderLineStyle.THIN); // 设置边框线
				Label lable  = new Label(col,row,value,wcf);
				sheet.mergeCells(col,row,_col,_row);//合并单元格
				sheet.addCell(lable);
			} catch (WriteException e) {
				e.printStackTrace();
			} 
		}
	//添加标题
	public void addHeadSheet2(WritableSheet sheet,LogDomain log){
		
		WritableFont wfont = new WritableFont(WritableFont.createFont("黑体"),16,WritableFont.BOLD);//设置字体、大小、加粗
		WritableCellFormat wcf = new WritableCellFormat(wfont);
		try {
			// 设置居中
			wcf.setAlignment(Alignment.CENTRE);
			Label lable  = new Label(0,0,log.getStation_no()+"单站验证测试表格",wcf);
			sheet.mergeCells(0,0,50,0);//合并单元格
			sheet.addCell(lable);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
