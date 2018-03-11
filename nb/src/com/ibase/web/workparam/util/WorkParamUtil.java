package com.ibase.web.workparam.util;

import com.ibase.core.utils.StringUtil;
import com.ibase.web.workparam.domain.WorkParamDomain;

public class WorkParamUtil {
	/*
	 * 给user属性加上"%"支持模糊查询
	 * 除了id
	 */
	public static void likePro(WorkParamDomain workParam){
		if(!StringUtil.isEmpty(workParam.getWp_station_no())){
			workParam.setWp_station_no("%"+workParam.getWp_station_no()+"%");
		}
		if(!StringUtil.isEmpty(workParam.getWp_station_height())){
			workParam.setWp_station_height("%"+workParam.getWp_station_height()+"%");
		}
		if(!StringUtil.isEmpty(workParam.getWp_station_longitude())){
			workParam.setWp_station_longitude("%"+workParam.getWp_station_longitude()+"%");
		}
		if(!StringUtil.isEmpty(workParam.getWp_station_latitude())){
			workParam.setWp_station_latitude("%"+workParam.getWp_station_latitude()+"%");
		}
		if(!StringUtil.isEmpty(workParam.getWp_station_TAC())){
			workParam.setWp_station_TAC("%"+workParam.getWp_station_TAC()+"%");
		}
		if(!StringUtil.isEmpty(workParam.getWp_station_ENBID())){
			workParam.setWp_station_ENBID("%"+workParam.getWp_station_ENBID()+"%");
		}
		if(!StringUtil.isEmpty(workParam.getWp_cell_section())){
			workParam.setWp_cell_section("%"+workParam.getWp_cell_section()+"%");
		}
		if(!StringUtil.isEmpty(workParam.getWp_cell_ECI())){
			workParam.setWp_cell_ECI("%"+workParam.getWp_cell_ECI()+"%");
		}
		if(!StringUtil.isEmpty(workParam.getWp_cell_PCI())){
			workParam.setWp_cell_PCI("%"+workParam.getWp_cell_PCI()+"%");
		}
		if(!StringUtil.isEmpty(workParam.getWp_cell_workModel())){
			workParam.setWp_cell_workModel("%"+workParam.getWp_cell_workModel()+"%");
		}
		if(!StringUtil.isEmpty(workParam.getWp_cell_bearing())){
			workParam.setWp_cell_bearing("%"+workParam.getWp_cell_bearing()+"%");
		}
		if(!StringUtil.isEmpty(workParam.getWp_cell_dipAangle())){
			workParam.setWp_cell_dipAangle("%"+workParam.getWp_cell_dipAangle()+"%");
		}
		if(!StringUtil.isEmpty(workParam.getWp_cell_top_frequency())){
			workParam.setWp_cell_top_frequency("%"+workParam.getWp_cell_top_frequency()+"%");
		}
		if(!StringUtil.isEmpty(workParam.getWp_cell_top_bandwidth())){
			workParam.setWp_cell_top_bandwidth("%"+workParam.getWp_cell_top_bandwidth()+"%");
		}
		if(!StringUtil.isEmpty(workParam.getWp_cell_down_frequency())){
			workParam.setWp_cell_down_frequency("%"+workParam.getWp_cell_down_frequency()+"%");
		}
		if(!StringUtil.isEmpty(workParam.getWp_cell_down_bandwidth())){
			workParam.setWp_cell_down_bandwidth("%"+workParam.getWp_cell_down_bandwidth()+"%");
		}
	}

}
