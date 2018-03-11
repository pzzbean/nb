package com.ibase.web.workparam_in.util;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.ibase.core.utils.StringUtil;
import com.ibase.web.workparam.domain.WorkParamDomain;
import com.ibase.web.workparam_in.domain.WorkParam_inDomain;

public class WorkParam_inUtil {
	/*
	 * 给user属性加上"%"支持模糊查询
	 * 除了id
	 */
	public static void likePro(WorkParam_inDomain workParam_in){
		if(!StringUtil.isEmpty(workParam_in.getWp_station_no())){
			workParam_in.setWp_station_no("%"+workParam_in.getWp_station_no()+"%");
		}
		if(!StringUtil.isEmpty(workParam_in.getWp_station_height())){
			workParam_in.setWp_station_height("%"+workParam_in.getWp_station_height()+"%");
		}
		if(!StringUtil.isEmpty(workParam_in.getWp_station_longitude())){
			workParam_in.setWp_station_longitude("%"+workParam_in.getWp_station_longitude()+"%");
		}
		if(!StringUtil.isEmpty(workParam_in.getWp_station_latitude())){
			workParam_in.setWp_station_latitude("%"+workParam_in.getWp_station_latitude()+"%");
		}
		if(!StringUtil.isEmpty(workParam_in.getWp_station_TAC())){
			workParam_in.setWp_station_TAC("%"+workParam_in.getWp_station_TAC()+"%");
		}
		if(!StringUtil.isEmpty(workParam_in.getWp_station_ENBID())){
			workParam_in.setWp_station_ENBID("%"+workParam_in.getWp_station_ENBID()+"%");
		}
		if(!StringUtil.isEmpty(workParam_in.getWp_cell_section())){
			workParam_in.setWp_cell_section("%"+workParam_in.getWp_cell_section()+"%");
		}
		if(!StringUtil.isEmpty(workParam_in.getWp_cell_ECI())){
			workParam_in.setWp_cell_ECI("%"+workParam_in.getWp_cell_ECI()+"%");
		}
		if(!StringUtil.isEmpty(workParam_in.getWp_cell_PCI())){
			workParam_in.setWp_cell_PCI("%"+workParam_in.getWp_cell_PCI()+"%");
		}
		if(!StringUtil.isEmpty(workParam_in.getWp_cell_workModel())){
			workParam_in.setWp_cell_workModel("%"+workParam_in.getWp_cell_workModel()+"%");
		}
		if(!StringUtil.isEmpty(workParam_in.getWp_cell_bearing())){
			workParam_in.setWp_cell_bearing("%"+workParam_in.getWp_cell_bearing()+"%");
		}
		if(!StringUtil.isEmpty(workParam_in.getWp_cell_dipAangle())){
			workParam_in.setWp_cell_dipAangle("%"+workParam_in.getWp_cell_dipAangle()+"%");
		}
		if(!StringUtil.isEmpty(workParam_in.getWp_cell_top_frequency())){
			workParam_in.setWp_cell_top_frequency("%"+workParam_in.getWp_cell_top_frequency()+"%");
		}
		if(!StringUtil.isEmpty(workParam_in.getWp_cell_top_bandwidth())){
			workParam_in.setWp_cell_top_bandwidth("%"+workParam_in.getWp_cell_top_bandwidth()+"%");
		}
		if(!StringUtil.isEmpty(workParam_in.getWp_cell_down_frequency())){
			workParam_in.setWp_cell_down_frequency("%"+workParam_in.getWp_cell_down_frequency()+"%");
		}
		if(!StringUtil.isEmpty(workParam_in.getWp_cell_down_bandwidth())){
			workParam_in.setWp_cell_down_bandwidth("%"+workParam_in.getWp_cell_down_bandwidth()+"%");
		}
	}

	/*
	 * 空值判断
	 */
	public static String isNull(WorkParam_inDomain workParam_in){
		if(StringUtil.isEmpty(workParam_in.getWp_station_no())){
			return "站号不能为空！";
		}
		return null;
	}
	
	public static int compareWorkParam(WorkParamDomain WorkParam,WorkParam_inDomain workParam_in){
		int count = 0;
		
		if(!WorkParam.getWp_station_no().equals(workParam_in.getWp_station_no())) count++;
		if(!WorkParam.getWp_station_height().equals(workParam_in.getWp_station_height())) count++;
		if(!WorkParam.getWp_station_longitude().equals(workParam_in.getWp_station_longitude())) count++;
		if(!WorkParam.getWp_station_latitude().equals(workParam_in.getWp_station_latitude())) count++;
		if(!WorkParam.getWp_station_TAC().equals(workParam_in.getWp_station_TAC())) count++;
		if(!WorkParam.getWp_station_ENBID().equals(workParam_in.getWp_station_ENBID())) count++;
		if(!WorkParam.getWp_cell_section().equals(workParam_in.getWp_cell_section())) count++;
		if(!WorkParam.getWp_cell_ECI().equals(workParam_in.getWp_cell_ECI())) count++;
		if(!WorkParam.getWp_cell_PCI().equals(workParam_in.getWp_cell_PCI())) count++;
		if(!WorkParam.getWp_cell_workModel().equals(workParam_in.getWp_cell_workModel())) count++;
		if(!WorkParam.getWp_cell_bearing().equals(workParam_in.getWp_cell_bearing())) count++;
		if(!WorkParam.getWp_cell_dipAangle().equals(workParam_in.getWp_cell_dipAangle())) count++;
		if(!WorkParam.getWp_cell_top_frequency().equals(workParam_in.getWp_cell_top_frequency())) count++;
		if(!WorkParam.getWp_cell_top_bandwidth().equals(workParam_in.getWp_cell_top_bandwidth())) count++;
		if(!WorkParam.getWp_cell_down_frequency().equals(workParam_in.getWp_cell_down_frequency())) count++;
		if(!WorkParam.getWp_cell_down_bandwidth().equals(workParam_in.getWp_cell_down_bandwidth())) count++;
		
		return count;
	}
	
	public static void insertWorkParam_inFromWorkParam(WorkParam_inDomain workParam_in,WorkParamDomain workParam){
		workParam_in.setWp_station_no(workParam.getWp_station_no());
		workParam_in.setWp_station_height(workParam.getWp_station_height());
		workParam_in.setWp_station_longitude(workParam.getWp_station_longitude());
		workParam_in.setWp_station_latitude(workParam.getWp_station_latitude());
		workParam_in.setWp_station_TAC(workParam.getWp_station_TAC());
		workParam_in.setWp_station_ENBID(workParam.getWp_station_ENBID());
		workParam_in.setWp_cell_section(workParam.getWp_cell_section());
		workParam_in.setWp_cell_ECI(workParam.getWp_cell_ECI());
		workParam_in.setWp_cell_PCI(workParam.getWp_cell_PCI());
		workParam_in.setWp_cell_workModel(workParam.getWp_cell_workModel());
		workParam_in.setWp_cell_bearing(workParam.getWp_cell_bearing());
		workParam_in.setWp_cell_dipAangle(workParam.getWp_cell_dipAangle());
		workParam_in.setWp_cell_top_frequency(workParam.getWp_cell_top_frequency());
		workParam_in.setWp_cell_top_bandwidth(workParam.getWp_cell_top_bandwidth());
		workParam_in.setWp_cell_down_frequency(workParam.getWp_cell_down_frequency());
		workParam_in.setWp_cell_down_bandwidth(workParam.getWp_cell_down_bandwidth());
	}
	
	/*
	 * 工参excel生成
	 */
	public static int createExcelOfWorkParam_in(HttpServletResponse response,List<WorkParam_inDomain> WorkParam_inList){
		response.reset();  
		response.setContentType("application/msexcel;charset=UTF-8");  
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH：mm：ss");
        OutputStream out = null;
        try {
			response.addHeader("Content-Disposition", "attachment;filename=\""  
			        + new String(("工参" +df.format(new Date())+ ".xls").getBytes("utf-8"),  
			                "ISO8859_1") + "\"");
			out = response.getOutputStream();
	    	ExcelWorkParam_in.createExcel(out, WorkParam_inList);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				return -1;
			}
		}
		
		return 1;
	}

}
