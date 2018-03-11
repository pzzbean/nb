package com.ibase.web.roadtest.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibase.core.utils.DateUtil;
import com.ibase.web.roadtest.domain.RoadTest;
public class RoadTestUtil {
	/*
	 * 给roadTest属性加上"%"支持模糊查询 除了id,status
	 */
	/*
	 * public static void likePro(RoadTestCount roadTestCount){
	 * 
	 * if(!StringUtil.isEmpty(roadTest.getRt_station_longitude())){
	 * roadTest.setRt_station_longitude("%"+roadTest.getRt_station_longitude()+"%");
	 * } if(!StringUtil.isEmpty(roadTest.getRt_station_latitude())){
	 * roadTest.setRt_station_latitude("%"+roadTest.getRt_station_latitude()+"%"); }
	 * if(!StringUtil.isEmpty(roadTest.getrt_count())){
	 * roadTest.setrt_count("%"+roadTest.getrt_count()+"%"); }
	 * if(!StringUtil.isEmpty(roadTest.getRt_cell_PCI())){
	 * roadTest.setRt_cell_PCI("%"+roadTest.getRt_cell_PCI()+"%"); }
	 * if(!StringUtil.isEmpty(roadTest.getRt_log_RSRP())){
	 * roadTest.setRt_log_RSRP("%"+roadTest.getRt_log_RSRP()+"%"); } if
	 * (!StringUtil.isEmpty(roadTest.getRt_log_SINR())) {
	 * roadTest.setRt_log_SINR("%"+roadTest.getRt_log_SINR()+"%"); } if
	 * (!StringUtil.isEmpty(roadTest.getRt_createTime())) {
	 * roadTest.setRt_createTime("%"+roadTest.getRt_createTime()+"%"); } if
	 * (!StringUtil.isEmpty(roadTest.getRt_creator())) {
	 * roadTest.setRt_creator("%"+roadTest.getRt_creator()+"%"); } }
	 */
	/**
	 * 封装数据
	 * 
	 * @param list
	 * @return
	 */
	/*
	 * public static List<Map> getAllData(List<RoadTest> list) { List<Map>
	 * listAllData = new ArrayList(); List<RoadTest> listData = new ArrayList(); Map
	 * map = new HashMap(); String rt_count = null; String rt_time = null; int i =
	 * 0; for(RoadTest rt : list){ i++; if(rt.getrt_count().equals(rt_count)){
	 * listData.add(rt); }else
	 * if(!rt.getrt_count().equals(rt_count)&&rt_count!=null){
	 * map.put("cell_id",rt_count); map.put("rt_time", rt_time.substring(0,10));
	 * map.put("list",listData); listAllData.add(map);
	 * 
	 * map = new HashMap(); listData = new ArrayList(); rt_count =
	 * rt.getrt_count(); rt_time = rt.getRt_time(); listData.add(rt); }else
	 * if(rt_count==null){ rt_count = rt.getrt_count(); rt_time =
	 * rt.getRt_time(); listData.add(rt); }
	 * 
	 * if(i==list.size()){ map.put("cell_id",rt_count); map.put("rt_time",
	 * rt_time.substring(0,10)); map.put("list",listData); listAllData.add(map); } }
	 * 
	 * System.out.println(listAllData.size()+"n"); //对封装的数据按日期排序(大到小) for(int
	 * k=0;k<listAllData.size();k++){ for(int l=0;l<listAllData.size()-1-k;l++){
	 * if(DateUtil.DateCompare((String)listAllData.get(l).get("rt_time"),(String)
	 * listAllData.get(l+1).get("rt_time"))<0){ Map m = listAllData.get(l+1);
	 * listAllData.set(l+1,listAllData.get(l)); listAllData.set(l,m); } } } return
	 * listAllData; }
	 */
	/**
	 * 封装数据
	 * @param list
	 * @return
	 */
	public static List<Map> getAllData(List<RoadTest> list) {
		List<Map> listAllData = new ArrayList();
		List<RoadTest> listData = new ArrayList();
		Map map = new HashMap();
		Integer rt_count = 0;
		String rt_time = null;
		int i = 0;
		for (RoadTest rt : list) {
			i++;
			if (rt.getRt_count()==rt_count) {
				listData.add(rt);
			} else if (rt.getRt_count()!=rt_count && rt_count != 0) {
				map.put("rt_count", rt_count);
				map.put("rt_time", rt_time.substring(0, 10));
				map.put("list", listData);
				listAllData.add(map);

				map = new HashMap();
				listData = new ArrayList();
				rt_count = (int) rt.getRt_count();
				rt_time = rt.getRt_time();
				listData.add(rt);
			} else if (rt_count == 0) {
				rt_count = (int) rt.getRt_count();
				rt_time = rt.getRt_time();
				listData.add(rt);
			}

			if (i == list.size()) {
				map.put("rt_count", rt_count);
				map.put("rt_time", rt_time.substring(0, 10));
				map.put("list", listData);
				listAllData.add(map);
			}
		}

		System.out.println(listAllData.size() + "n");
		// 对封装的数据按日期排序(大到小)
		for (int k = 0; k < listAllData.size(); k++) {
			for (int l = 0; l < listAllData.size() - 1 - k; l++) {
				if (DateUtil.DateCompare((String) listAllData.get(l).get("rt_time"),
						(String) listAllData.get(l + 1).get("rt_time")) < 0) {
					Map m = listAllData.get(l + 1);
					listAllData.set(l + 1, listAllData.get(l));
					listAllData.set(l, m);
				}
			}
		}
		return listAllData;
	}
}
