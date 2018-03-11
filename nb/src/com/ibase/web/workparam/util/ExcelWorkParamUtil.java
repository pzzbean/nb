package com.ibase.web.workparam.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.ibase.web.log.domain.LogDomain;
import com.ibase.web.plane.domain.Plane;
import com.ibase.web.workparam.domain.WorkParamDomain;
import com.ibase.web.workparam.service.WorkParamService;
import com.ibase.web.workparam_in.domain.WorkParam_inDomain;

import jxl.Cell;
import jxl.CellType;
import jxl.CellView;
import jxl.DateCell;
import jxl.LabelCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelWorkParamUtil {
	@Test
	public void text()throws Exception {
		String filePath = "d:\\工参.xls";
		//OutputStream os = new FileOutputStream(filePath);
		InputStream in = new FileInputStream("d:\\上海LN900小区规划数据20170905.xls");
		System.out.println(in);
		
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
		
		//addExcelToWorkParam(in);
		
	}
	/**
	 * 将excel的每一行数据添加到数据库中
	 */
	public static void addExcelToWorkParam(InputStream in,WorkParamService workParamService) throws Exception{
		Workbook workbook = Workbook.getWorkbook(in);
		Sheet sheet = workbook.getSheet(0);//获取第一个sheet
		WorkParamDomain workParam = new WorkParamDomain();
		
		int rows = sheet.getRows();
		int cols = sheet.getColumns();
		LabelCell strCell = null;
		NumberCell numberCell = null;
		DateCell dateCell = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		//System.out.println(rows);
		
		for(int row=1;row<rows;row++){
			//System.out.println(row);
			for(int col=0;col<cols;col++){
				//System.out.println(col);
				Cell cell = sheet.getCell(col,row);
				if(cell.getContents()!=null&&!cell.getContents().equals("")&&cell.getType() == CellType.LABEL){
					strCell = (LabelCell) cell;
					String str = strCell.getString();
					setValue(workParam,str,col);
				}else if(cell.getContents()!=null&&!cell.getContents().equals("")&&cell.getType() == CellType.NUMBER){
					numberCell = (NumberCell) cell; 
					String numStr = String.valueOf(numberCell.getValue());
					setValue(workParam,numStr,col);
				}else if(cell.getContents()!=null&&!cell.getContents().equals("")&&cell.getType() == CellType.DATE){
					dateCell = (DateCell) cell;
					String dateStr = format.format(dateCell.getDate());
					setValue(workParam,dateStr,col);
				}
			}
			workParamService.insertWorkParam(workParam);
		}
		workbook.close();
	}
	
	/**
	 * 将值判断后放入WorkParamDomain类中
	 */
	public static void setValue(WorkParamDomain workParam,String value,int col){
		if(col==0){
			workParam.setWp_station_no(value);
		}else if(col==1){
			workParam.setWp_station_height(value);
		}else if(col==2){
			workParam.setWp_station_longitude(value);
		}else if(col==3){
			workParam.setWp_station_latitude(value);
		}else if(col==4){
			workParam.setWp_station_TAC(value);
		}else if(col==5){
			workParam.setWp_station_ENBID(value);
		}else if(col==6){
			workParam.setWp_cell_section(value);
		}else if(col==7){
			workParam.setWp_cell_ECI(value);
		}else if(col==8){
			workParam.setWp_cell_PCI(value);
		}else if(col==9){
			workParam.setWp_cell_workModel(value);
		}else if(col==10){
			workParam.setWp_cell_bearing(value);
		}else if(col==11){
			workParam.setWp_cell_dipAangle(value);
		}else if(col==12){
			workParam.setWp_cell_top_frequency(value);
		}else if(col==13){
			workParam.setWp_cell_top_bandwidth(value);
		}else if(col==14){
			workParam.setWp_cell_down_frequency(value);
		}else if(col==15){
			workParam.setWp_cell_down_bandwidth(value);
		}		
	}
	
	

}
