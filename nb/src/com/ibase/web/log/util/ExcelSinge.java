package com.ibase.web.log.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ibase.web.log.domain.LogDomain;
import com.ibase.web.plane.domain.Plane;
import com.ibase.web.workparam.domain.WorkParamDomain;
import com.ibase.web.workparam_in.domain.WorkParam_inDomain;

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

public class ExcelSinge {
	
	public static void createExcel(OutputStream out,Plane plane,List<WorkParam_inDomain> wordParam,List<LogDomain> log)throws Exception{
				// 创建Excel工作薄 
				WritableWorkbook wwb = Workbook.createWorkbook(out);
				//创建一个sheet（可以创建多个sheet,一个工作薄可以有多个sheet
				WritableSheet sheet = wwb.createSheet("单验报告", 0);
				
				Label lable;
				WritableFont wfont = new WritableFont(WritableFont.createFont("楷书"),11);//设置字体、大小、加粗
				WritableCellFormat wcf = new WritableCellFormat(wfont);;
				
				int col;//列
				int row;//行
				int col_;
				int row_;
				
		//写入测试计划
				//创建标头
				col=0;row=0;col_=3;row_=0;				
				addHead(wfont,wcf,sheet,"测试计划",col,row,col_,row_);
				//测试工程师姓名
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"测试工程师姓名", col,row);
				
				col=1;row=row;
				addLable(wfont,wcf,sheet,plane.getPlan_test_engineer(), col,row);
				//测试工程师电话
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"测试工程师电话", col,row);
				
				col=3;row=row;
				addLable(wfont,wcf,sheet,plane.getPlan_te_phone(), col,row);
				//后台工程师姓名
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"后台工程师姓名", col,row);
				
				col=1;row=row;
				addLable(wfont,wcf,sheet,plane.getPlan_back_engineer(), col,row);
				//后台工程师电话
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"测试工程师电话", col,row);
				
				col=3;row=row;
				addLable(wfont,wcf,sheet,plane.getPlan_te_phone(), col,row);
				//测试内容
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"测试内容", col,row);
				
				col=1;row=row;
				addLast(wfont,wcf,sheet,plane.getPlane_test_content(), col,row);
				//测试时间
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"测试时间", col,row);
				
				col=1;row=row;
				addLast(wfont,wcf,sheet,plane.getPlane_test_time(), col,row);
		//写入工参
				//创建标头
				col=0;row=row+1;col_=3;row_=row;				
				addHead(wfont,wcf,sheet,"工参",col,row,col_,row_);
				//站号
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"站号", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(0).getWp_station_no(), col,row);
				//站高
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"站高", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(0).getWp_station_height(), col,row);
				//经度
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"经度", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(0).getWp_station_longitude(), col,row);
				//纬度
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"纬度", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(0).getWp_station_latitude(), col,row);
				//TAC
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"TAC", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(0).getWp_station_TAC(), col,row);
				//eNB ID
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"eNB ID", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(0).getWp_station_ENBID(), col,row);
			//扇区1
				col=0;row=row;
				addCellNO(wfont,wcf,sheet,wordParam.get(0).getWp_cell_section(),col,row);
				//扇区1 PCI
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"PCI", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(0).getWp_cell_PCI(), col,row);
				//扇区1   工作模式
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"工作模式", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(0).getWp_cell_workModel(), col,row);
				//扇区1	扇区方位角
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"扇区方位角", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(0).getWp_cell_bearing(), col,row);				
				//扇区1	扇区倾角
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"扇区倾角", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(0).getWp_cell_dipAangle(), col,row);
				//扇区1 	上行频点
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"上行频点", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(0).getWp_cell_top_frequency(), col,row);
				//扇区1   上行带宽
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"上行带宽", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(0).getWp_cell_top_bandwidth(), col,row);
				//扇区1   下行频点
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"下行频点", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(0).getWp_cell_down_frequency(), col,row);
				//扇区1   下行带宽
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"下行带宽", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(0).getWp_cell_down_bandwidth(), col,row);
				//扇区1	ECI
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"ECI", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(0).getWp_cell_ECI(), col,row);
			//扇区2  
				col=0;row=row+1;
				addCellNO(wfont,wcf,sheet,wordParam.get(1).getWp_cell_section(),col,row);				
				//扇区2 PCI	
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"PCI", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(1).getWp_cell_PCI(), col,row);
				//扇区2   工作模式
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"工作模式", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(1).getWp_cell_workModel(), col,row);
				//扇区2	扇区方位角
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"扇区方位角", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(1).getWp_cell_bearing(), col,row);	
				//扇区2	扇区倾角
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"扇区倾角", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(1).getWp_cell_dipAangle(), col,row);
				//扇区2 	上行频点
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"上行频点", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(1).getWp_cell_top_frequency(), col,row);
				//扇区2   上行带宽
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"上行带宽", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(1).getWp_cell_top_bandwidth(), col,row);
				//扇区1   下行频点
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet," 下行频点", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(1).getWp_cell_down_frequency(), col,row);
				//扇区1   下行带宽
				col=2;row=row;
				addLableBold(wfont,wcf,sheet," 下行带宽", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(1).getWp_cell_down_bandwidth(), col,row);
				//扇区1	ECI
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"ECI", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(1).getWp_cell_ECI(), col,row);
			//扇区3  
				col=0;row=row+1;
				addCellNO(wfont,wcf,sheet,wordParam.get(2).getWp_cell_section(),col,row);
				//扇区3 PCI	
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"PCI", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(2).getWp_cell_PCI(), col,row);
				//扇区3   工作模式
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"工作模式", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(2).getWp_cell_workModel(), col,row);
				//扇区3	扇区方位角
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"扇区方位角", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(2).getWp_cell_bearing(), col,row);	
				//扇区3	扇区倾角
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"扇区倾角", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(2).getWp_cell_dipAangle(), col,row);
				//扇区3 	上行频点
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"上行频点", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(2).getWp_cell_top_frequency(), col,row);
				//扇区3   上行带宽
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"上行带宽", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(2).getWp_cell_top_bandwidth(), col,row);
				//扇区3   下行频点
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet," 下行频点", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(2).getWp_cell_down_frequency(), col,row);
				//扇区3   下行带宽
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"下行带宽", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(2).getWp_cell_down_bandwidth(), col,row);
				//扇区3	ECI
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"ECI", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,wordParam.get(2).getWp_cell_ECI(), col,row);
		//性能日志
				//创建标头
				col=0;row=row+1;col_=3;row_=row;				
				addHead(wfont,wcf,sheet,"性能日志",col,row,col_,row_);
			//扇区1
				col=0;row=row+1;
				addCellNO(wfont,wcf,sheet,log.get(0).getCell_section(),col,row);
				//扇区1 RSRP
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"RSRP", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,log.get(0).getLog_RSRP(), col,row);
				//扇区1	SINR
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"SINR", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,log.get(0).getLog_SINR(), col,row);
				/*//扇区1	上行速率
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"上行速率", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,log.get(0).getLog_top_rate(), col,row);
				//扇区1	下行速率
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"下行速率", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,log.get(0).getLog_down_rate(), col,row);*/
				//扇区1	ping时延
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"ping时延", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,log.get(0).getLog_delayTime(), col,row);
				//扇区1	接通率
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"接通率", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,log.get(0).getLog_openRate(), col,row);
				//扇区1	重传时延
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"重传时延", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,log.get(0).getLog_ReselectDelay(), col,row);
				//扇区1	接通时延
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"接通时延", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,log.get(0).getLog_AttachDelay(), col,row);
				//扇区1       是否达标（判断）
				row=row+1;
				if(log.get(0).getStatus()==1){
					addStatus(wfont,wcf,sheet,"达标", 0,row);
				}else{
					addStatus(wfont,wcf,sheet,"不达标", 0,row);
				}
			//扇区2
				col=0;row=row+1;
				addCellNO(wfont,wcf,sheet,log.get(1).getCell_section(),col,row);
				//扇区2 RSRP
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"RSRP", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,log.get(1).getLog_RSRP(), col,row);
				//扇区2	SINR
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"SINR", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,log.get(1).getLog_SINR(), col,row);
				/*//扇区2	上行速率
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"上行速率", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,log.get(1).getLog_top_rate(), col,row);
				//扇区2	下行速率
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"下行速率", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,log.get(1).getLog_down_rate(), col,row);*/
				//扇区2	ping时延
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"ping时延", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,log.get(1).getLog_delayTime(), col,row);
				//扇区2	接通率
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"接通率", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,log.get(1).getLog_openRate(), col,row);
				//扇区2	重传时延
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"重传时延", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,log.get(1).getLog_ReselectDelay(), col,row);
				//扇区2	接通时延
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"接通时延", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,log.get(1).getLog_AttachDelay(), col,row);
				//扇区2       是否达标（判断）
				row=row+1;
				if(log.get(1).getStatus()==1){
					addStatus(wfont,wcf,sheet,"达标", 0,row);
				}else{
					addStatus(wfont,wcf,sheet,"不达标", 0,row);
				}
				
			//扇区3
				col=0;row=row+1;
				addCellNO(wfont,wcf,sheet,log.get(2).getCell_section(),col,row);
				//扇区3 RSRP
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"RSRP", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,log.get(2).getLog_RSRP(), col,row);
				//扇区3	SINR
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"SINR", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,log.get(2).getLog_SINR(), col,row);
				/*//扇区3	上行速率
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"上行速率", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,log.get(2).getLog_top_rate(), col,row);
				//扇区3	下行速率
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"下行速率", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,log.get(2).getLog_down_rate(), col,row);*/
				//扇区3	ping时延
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"ping时延", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,log.get(2).getLog_delayTime(), col,row);
				//扇区3	接通率
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"RRC接通率", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,log.get(2).getLog_openRate(), col,row);
				//扇区3	重传时延
				col=0;row=row+1;
				addLableBold(wfont,wcf,sheet,"重传时延", col,row);				
				col=1;row=row;
				addLable(wfont,wcf,sheet,log.get(2).getLog_ReselectDelay(), col,row);
				//扇区3	接通时延
				col=2;row=row;
				addLableBold(wfont,wcf,sheet,"接通时延", col,row);				
				col=3;row=row;
				addLable(wfont,wcf,sheet,log.get(2).getLog_AttachDelay(), col,row);
				//扇区3       是否达标（判断）
				if(log.get(2).getStatus()==1){
					addStatus(wfont,wcf,sheet,"达标", 0,row+1);
				}else{
					addStatus(wfont,wcf,sheet,"不达标", 0,row+1);
				}
				
				// 写入数据 
				wwb.write(); 
				// 关闭文件 
				wwb.close();
	}
	public static void createExcel2(OutputStream out,Plane plane,List<WorkParamDomain> wordParam,List<LogDomain> log)throws Exception{
		// 创建Excel工作薄 
		WritableWorkbook wwb = Workbook.createWorkbook(out);
		//创建一个sheet（可以创建多个sheet,一个工作薄可以有多个sheet
		WritableSheet sheet = wwb.createSheet("单验报告", 0);
		
		Label lable;
		WritableFont wfont = new WritableFont(WritableFont.createFont("楷书"),11);//设置字体、大小、加粗
		WritableCellFormat wcf = new WritableCellFormat(wfont);;
		
		int col;//列
		int row;//行
		int col_;
		int row_;
		
//写入测试计划
		//创建标头
		col=0;row=0;col_=3;row_=0;				
		addHead(wfont,wcf,sheet,"测试计划",col,row,col_,row_);
		//测试工程师姓名
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"测试工程师姓名", col,row);
		
		col=1;row=row;
		addLable(wfont,wcf,sheet,plane.getPlan_test_engineer(), col,row);
		//测试工程师电话
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"测试工程师电话", col,row);
		
		col=3;row=row;
		addLable(wfont,wcf,sheet,plane.getPlan_te_phone(), col,row);
		//后台工程师姓名
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"后台工程师姓名", col,row);
		
		col=1;row=row;
		addLable(wfont,wcf,sheet,plane.getPlan_back_engineer(), col,row);
		//后台工程师电话
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"测试工程师电话", col,row);
		
		col=3;row=row;
		addLable(wfont,wcf,sheet,plane.getPlan_te_phone(), col,row);
		//测试内容
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"测试内容", col,row);
		
		col=1;row=row;
		addLast(wfont,wcf,sheet,plane.getPlane_test_content(), col,row);
		//测试时间
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"测试时间", col,row);
		
		col=1;row=row;
		addLast(wfont,wcf,sheet,plane.getPlane_test_time(), col,row);
//写入工参
		//创建标头
		col=0;row=row+1;col_=3;row_=row;				
		addHead(wfont,wcf,sheet,"工参",col,row,col_,row_);
		//站号
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"站号", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(0).getWp_station_no(), col,row);
		//站高
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"站高", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(0).getWp_station_height(), col,row);
		//经度
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"经度", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(0).getWp_station_longitude(), col,row);
		//纬度
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"纬度", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(0).getWp_station_latitude(), col,row);
		//TAC
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"TAC", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(0).getWp_station_TAC(), col,row);
		//eNB ID
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"eNB ID", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(0).getWp_station_ENBID(), col,row);
	//扇区1
		col=0;row=row;
		addCellNO(wfont,wcf,sheet,wordParam.get(0).getWp_cell_section(),col,row);
		//扇区1 PCI
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"PCI", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(0).getWp_cell_PCI(), col,row);
		//扇区1   工作模式
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"工作模式", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(0).getWp_cell_workModel(), col,row);
		//扇区1	扇区方位角
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"扇区方位角", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(0).getWp_cell_bearing(), col,row);				
		//扇区1	扇区倾角
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"扇区倾角", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(0).getWp_cell_dipAangle(), col,row);
		//扇区1 	上行频点
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"上行频点", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(0).getWp_cell_top_frequency(), col,row);
		//扇区1   上行带宽
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"上行带宽", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(0).getWp_cell_top_bandwidth(), col,row);
		//扇区1   下行频点
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"下行频点", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(0).getWp_cell_down_frequency(), col,row);
		//扇区1   下行带宽
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"下行带宽", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(0).getWp_cell_down_bandwidth(), col,row);
		//扇区1	ECI
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"ECI", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(0).getWp_cell_ECI(), col,row);
	//扇区2  
		col=0;row=row+1;
		addCellNO(wfont,wcf,sheet,wordParam.get(1).getWp_cell_section(),col,row);				
		//扇区2 PCI	
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"PCI", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(1).getWp_cell_PCI(), col,row);
		//扇区2   工作模式
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"工作模式", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(1).getWp_cell_workModel(), col,row);
		//扇区2	扇区方位角
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"扇区方位角", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(1).getWp_cell_bearing(), col,row);	
		//扇区2	扇区倾角
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"扇区倾角", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(1).getWp_cell_dipAangle(), col,row);
		//扇区2 	上行频点
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"上行频点", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(1).getWp_cell_top_frequency(), col,row);
		//扇区2   上行带宽
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"上行带宽", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(1).getWp_cell_top_bandwidth(), col,row);
		//扇区1   下行频点
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet," 下行频点", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(1).getWp_cell_down_frequency(), col,row);
		//扇区1   下行带宽
		col=2;row=row;
		addLableBold(wfont,wcf,sheet," 下行带宽", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(1).getWp_cell_down_bandwidth(), col,row);
		//扇区1	ECI
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"ECI", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(1).getWp_cell_ECI(), col,row);
	//扇区3  
		col=0;row=row+1;
		addCellNO(wfont,wcf,sheet,wordParam.get(2).getWp_cell_section(),col,row);
		//扇区3 PCI	
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"PCI", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(2).getWp_cell_PCI(), col,row);
		//扇区3   工作模式
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"工作模式", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(2).getWp_cell_workModel(), col,row);
		//扇区3	扇区方位角
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"扇区方位角", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(2).getWp_cell_bearing(), col,row);	
		//扇区3	扇区倾角
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"扇区倾角", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(2).getWp_cell_dipAangle(), col,row);
		//扇区3 	上行频点
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"上行频点", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(2).getWp_cell_top_frequency(), col,row);
		//扇区3   上行带宽
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"上行带宽", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(2).getWp_cell_top_bandwidth(), col,row);
		//扇区3   下行频点
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet," 下行频点", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(2).getWp_cell_down_frequency(), col,row);
		//扇区3   下行带宽
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"下行带宽", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(2).getWp_cell_down_bandwidth(), col,row);
		//扇区3	ECI
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"ECI", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,wordParam.get(2).getWp_cell_ECI(), col,row);
//性能日志
		//创建标头
		col=0;row=row+1;col_=3;row_=row;				
		addHead(wfont,wcf,sheet,"性能日志",col,row,col_,row_);
	//扇区1
		col=0;row=row+1;
		addCellNO(wfont,wcf,sheet,log.get(0).getCell_section(),col,row);
		//扇区1 RSRP
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"RSRP", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,log.get(0).getLog_RSRP(), col,row);
		//扇区1	SINR
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"SINR", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,log.get(0).getLog_SINR(), col,row);
		/*//扇区1	上行速率
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"上行速率", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,log.get(0).getLog_top_rate(), col,row);
		//扇区1	下行速率
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"下行速率", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,log.get(0).getLog_down_rate(), col,row);*/
		//扇区1	ping时延
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"ping时延", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,log.get(0).getLog_delayTime(), col,row);
		//扇区1	接通率
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"RRC接通率", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,log.get(0).getLog_openRate(), col,row);
		//扇区1	重传时延
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"重传时延", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,log.get(0).getLog_ReselectDelay(), col,row);
		//扇区1	接通时延
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"接通时延", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,log.get(0).getLog_AttachDelay(), col,row);
		//扇区1       是否达标（判断）
		row=row+1;
		if(log.get(0).getStatus()==1){
			addStatus(wfont,wcf,sheet,"达标", 0,row);
		}else{
			addStatus(wfont,wcf,sheet,"不达标", 0,row);
		}
	//扇区2
		col=0;row=row+1;
		addCellNO(wfont,wcf,sheet,log.get(1).getCell_section(),col,row);
		//扇区2 RSRP
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"RSRP", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,log.get(1).getLog_RSRP(), col,row);
		//扇区2	SINR
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"SINR", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,log.get(1).getLog_SINR(), col,row);
		/*//扇区2	上行速率
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"上行速率", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,log.get(1).getLog_top_rate(), col,row);
		//扇区2	下行速率
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"下行速率", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,log.get(1).getLog_down_rate(), col,row);*/
		//扇区2	ping时延
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"ping时延", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,log.get(1).getLog_delayTime(), col,row);
		//扇区2	接通率
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"RRC接通率", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,log.get(1).getLog_openRate(), col,row);
		//扇区2	重传时延
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"重传时延", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,log.get(1).getLog_ReselectDelay(), col,row);
		//扇区2	接通时延
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"接通时延", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,log.get(1).getLog_AttachDelay(), col,row);
		//扇区2       是否达标（判断）
		row=row+1;
		if(log.get(1).getStatus()==1){
			addStatus(wfont,wcf,sheet,"达标", 0,row);
		}else{
			addStatus(wfont,wcf,sheet,"不达标", 0,row);
		}
		
	//扇区3
		col=0;row=row+1;
		addCellNO(wfont,wcf,sheet,log.get(2).getCell_section(),col,row);
		//扇区3 RSRP
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"RSRP", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,log.get(2).getLog_RSRP(), col,row);
		//扇区3	SINR
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"SINR", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,log.get(2).getLog_SINR(), col,row);
		/*//扇区3	上行速率
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"上行速率", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,log.get(2).getLog_top_rate(), col,row);
		//扇区3	下行速率
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"下行速率", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,log.get(2).getLog_down_rate(), col,row);*/
		//扇区3	ping时延
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"ping时延", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,log.get(2).getLog_delayTime(), col,row);
		//扇区3	接通率
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"RRC接通率", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,log.get(2).getLog_openRate(), col,row);
		//扇区3	重传时延
		col=0;row=row+1;
		addLableBold(wfont,wcf,sheet,"重传时延", col,row);				
		col=1;row=row;
		addLable(wfont,wcf,sheet,log.get(2).getLog_ReselectDelay(), col,row);
		//扇区3	接通时延
		col=2;row=row;
		addLableBold(wfont,wcf,sheet,"接通时延", col,row);				
		col=3;row=row;
		addLable(wfont,wcf,sheet,log.get(2).getLog_AttachDelay(), col,row);
		//扇区3       是否达标（判断）
		if(log.get(2).getStatus()==1){
			addStatus(wfont,wcf,sheet,"达标", 0,row+1);
		}else{
			addStatus(wfont,wcf,sheet,"不达标", 0,row+1);
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
		wcf.setAlignment(Alignment.CENTRE); // 设置左右居中
		wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 设置上下居中
		wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 设置边框线
		Label lable = new Label(col,row,value,wcf);
		sheet.setColumnView(col, 20);
		//sheet.setRowView(row,1000);
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
		//wfont.setColour(Colour.RED);
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
