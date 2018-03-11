package com.ibase.core.http;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;

import com.gg.yp.bean.PaginationBean;

/**
 * 
 * @author admin
 *
 */
public class ResponsePacket3 implements Serializable{
	
	private static final long serialVersionUID = -4936075239115593554L;
	

	  /*请求结果状态码*/private int resultCode;

	  /*最新时间戳*/private long newTimestamp;

	  /*请求结果说明*/private String mMessage;

	  /*数据源*/private List<? extends Object> dataSource;

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public long getNewTimestamp() {
		return newTimestamp;
	}

	public void setNewTimestamp(long newTimestamp) {
		this.newTimestamp = newTimestamp;
	}

	public String getmMessage() {
		return mMessage;
	}

	public void setmMessage(String mMessage) {
		this.mMessage = mMessage;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public ResponsePacket3() {
		super();
	}

	public ResponsePacket3(int resultCode, String mMessage) {
		super();
		this.resultCode = resultCode;
		this.mMessage = mMessage;
	}

	public ResponsePacket3(int resultCode, long newTimestamp, String mMessage, List<? extends Object> dataSource) {
		super();
		this.resultCode = resultCode;
		this.newTimestamp = newTimestamp;
		this.mMessage = mMessage;
		this.dataSource = dataSource;
	}

	public List<? extends Object> getDataSource() {
		return dataSource;
	}

	public void setDataSource(List<? extends Object> dataSource) {
		this.dataSource = dataSource;
	}

	
	
}
