package com.ibase.core.http;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gg.yp.bean.PaginationBean;
import com.ibase.web.roadtest.domain.LonLat;

/**
 * 
 * @author admin
 *
 */
public class ResponsePacket2 implements Serializable{
	
	private static final long serialVersionUID = -4936075239115593554L;
	
	
	private List<? extends Object> listObject;
	private List<Map<String,Object>> listMap;
	private Map<String,List<LonLat>> mapinfo;
	private Map<String,List<Object>> mapObject;
	private List<Map<String, List<? extends Object>>> maplist;
	
	
	
	
	
	
	
	public ResponsePacket2(List<? extends Object> listObject, List<Map<String, Object>> listMap,
			Map<String, List<LonLat>> mapinfo, Map<String, List<Object>> mapObject,
			List<Map<String, List<? extends Object>>> maplist) {
		super();
		this.listObject = listObject;
		this.listMap = listMap;
		this.mapinfo = mapinfo;
		this.mapObject = mapObject;
		this.maplist = maplist;
	}
	public List<Map<String, List<? extends Object>>> getMaplist() {
		return maplist;
	}
	public void setMaplist(List<Map<String, List<? extends Object>>> maplist) {
		this.maplist = maplist;
	}
	public Map<String, List<Object>> getMapObject() {
		return mapObject;
	}
	public void setMapObject(Map<String, List<Object>> mapObject) {
		this.mapObject = mapObject;
	}
	public List<? extends Object> getListObject() {
		return listObject;
	}
	public void setListObject(List<? extends Object> listObject) {
		this.listObject = listObject;
	}
	
	public void setListObject(List<? extends Object> listObject,List<? extends Object> listObject1) {
		this.listObject = listObject;
		this.listObject = listObject1;
	}
	
	public List<Map<String, Object>> getListMap() {
		return listMap;
	}
	public void setListMap(List<Map<String, Object>> listMap) {
		this.listMap = listMap;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ResponsePacket2 [listObject=" + listObject + ", listMap=" + listMap + ", mapinfo=" + mapinfo + "]";
	}
	public ResponsePacket2(List<? extends Object> listObject, List<Map<String, Object>> listMap) {
		super();
		this.listObject = listObject;
		this.listMap = listMap;
	}
	public ResponsePacket2() {
		super();
	}
	public ResponsePacket2(List<? extends Object> listObject) {
		super();
		this.listObject = listObject;
	}
	public Map<String, List<LonLat>> getMapinfo() {
		return mapinfo;
	}
	public void setMapinfo(Map<String, List<LonLat>> mapinfo) {
		this.mapinfo = mapinfo;
	}
	public ResponsePacket2(List<? extends Object> listObject, List<Map<String, Object>> listMap,
			Map<String, List<LonLat>> mapinfo) {
		super();
		this.listObject = listObject;
		this.listMap = listMap;
		this.mapinfo = mapinfo;
	}
	public ResponsePacket2(List<? extends Object> listObject, List<Map<String, Object>> listMap,
			Map<String, List<LonLat>> mapinfo, Map<String, List<Object>> mapObject) {
		super();
		this.listObject = listObject;
		this.listMap = listMap;
		this.mapinfo = mapinfo;
		this.mapObject = mapObject;
	}
	
	
}
