package com.ibase.core.http;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gg.yp.bean.PaginationBean;

/**
 * 
 * @author admin
 *
 */
public class ResponsePacket4 implements Serializable{
	
	private static final long serialVersionUID = -4936075239115593554L;
	
	private int code;
	private String msg;
	private Map<String,? extends Object> map;
	private Object object;
	private List<? extends Object> listObject;
	private List<Map<String,Object>> listMap;
	private PaginationBean page;
	
	
	
	
	public void setPage(PaginationBean page) {
		this.page = page;
	}
	public PaginationBean getPage() {
		return page;
	}

	public ResponsePacket4(){}
	
	public ResponsePacket4(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	

	public ResponsePacket4(List<? extends Object> listObject) {
		
		this.listObject = listObject;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, ? extends Object> getMap() {
		return map;
	}

	public void setMap(Map<String, ? extends Object> map) {
		this.map = map;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public List<? extends Object> getListObject() {
		return listObject;
	}

	public void setListObject(List<? extends Object> listObject) {
		this.listObject = listObject;
	}

	public List<Map<String, Object>> getListMap() {
		return listMap;
	}

	public void setListMap(List<Map<String, Object>> listMap) {
		this.listMap = listMap;
	}
	@Override
	public String toString() {
		return "ResponsePacket [map=" + map + ", object=" + object + ", listObject=" + listObject + ", listMap="
				+ listMap + "]";
	}
	
}
