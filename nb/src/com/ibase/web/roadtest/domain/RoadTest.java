package com.ibase.web.roadtest.domain;

import com.ibase.core.base.BaseDomain;

/*rt_id BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
rt_time VARCHAR(10) DEFAULT NULL COMMENT'测试时间',
rt_station_longitude VARCHAR(15) DEFAULT NULL COMMENT'基站经度',
rt_station_latitude VARCHAR(15) DEFAULT NULL COMMENT'基站维度',
rt_station_no VARCHAR(20) DEFAULT NULL COMMENT'站号',
rt_cell_PCI VARCHAR(15) DEFAULT NULL COMMENT'PCI',
rt_log_RSRP VARCHAR(10) DEFAULT NULL COMMENT'RSRP',
rt_log_SINR VARCHAR(10) DEFAULT NULL COMMENT'SINR',
rt_createTime DATE DEFAULT NULL COMMENT'创建时间',
rt_creator BIGINT(20) DEFAULT 0 COMMENT'创建人user_id' */
public class RoadTest extends BaseDomain {
	// 成员变量
	private long rt_id;
	private String rt_time;
	private String rt_station_longitude;
	private String rt_station_latitude;
	private String rt_cellId;
	private String rt_cell_PCI;
	private String rt_log_RSRP;
	private String rt_log_SINR;
	private String rt_createTime;
	private String rt_creator;
	private long rt_count;
	private String rt_name;
	
	

	public RoadTest() {
		super();
	}

	public RoadTest(long rt_id, String rt_time, String rt_station_longitude, String rt_station_latitude,
			String rt_cellId, String rt_cell_PCI, String rt_log_RSRP, String rt_log_SINR, String rt_createTime,
			String rt_creator, long rt_count, String rt_name) {
		super();
		this.rt_id = rt_id;
		this.rt_time = rt_time;
		this.rt_station_longitude = rt_station_longitude;
		this.rt_station_latitude = rt_station_latitude;
		this.rt_cellId = rt_cellId;
		this.rt_cell_PCI = rt_cell_PCI;
		this.rt_log_RSRP = rt_log_RSRP;
		this.rt_log_SINR = rt_log_SINR;
		this.rt_createTime = rt_createTime;
		this.rt_creator = rt_creator;
		this.rt_count = rt_count;
		this.rt_name = rt_name;
	}



	public RoadTest(long rt_id, String rt_station_longitude, String rt_station_latitude) {
		super();
		this.rt_id = rt_id;
		this.rt_station_longitude = rt_station_longitude;
		this.rt_station_latitude = rt_station_latitude;
	}
	

	public RoadTest(long rt_id, String rt_cell_PCI, String rt_log_RSRP, String rt_log_SINR) {
		super();
		this.rt_id = rt_id;
		this.rt_cell_PCI = rt_cell_PCI;
		this.rt_log_RSRP = rt_log_RSRP;
		this.rt_log_SINR = rt_log_SINR;
	}

	// 成员方法
	public long getRt_id() {
		return rt_id;
	}

	public void setRt_id(long rt_id) {
		this.rt_id = rt_id;
	}

	public String getRt_time() {
		return rt_time;
	}

	public void setRt_time(String rt_time) {
		this.rt_time = rt_time;
	}

	public String getRt_station_longitude() {
		return rt_station_longitude;
	}

	public void setRt_station_longitude(String rt_station_longitude) {
		this.rt_station_longitude = rt_station_longitude;
	}

	public String getRt_station_latitude() {
		return rt_station_latitude;
	}

	public void setRt_station_latitude(String rt_station_latitude) {
		this.rt_station_latitude = rt_station_latitude;
	}

	public String getRt_cellId() {
		return rt_cellId;
	}

	public void setRt_cellId(String rt_cellId) {
		this.rt_cellId = rt_cellId;
	}

	public String getRt_cell_PCI() {
		return rt_cell_PCI;
	}

	public void setRt_cell_PCI(String rt_cell_PCI) {
		this.rt_cell_PCI = rt_cell_PCI;
	}

	public String getRt_log_RSRP() {
		return rt_log_RSRP;
	}

	public void setRt_log_RSRP(String rt_log_RSRP) {
		this.rt_log_RSRP = rt_log_RSRP;
	}

	public String getRt_log_SINR() {
		return rt_log_SINR;
	}

	public void setRt_log_SINR(String rt_log_SINR) {
		this.rt_log_SINR = rt_log_SINR;
	}

	public String getRt_createTime() {
		return rt_createTime;
	}

	public void setRt_createTime(String rt_createTime) {
		this.rt_createTime = rt_createTime;
	}

	public String getRt_creator() {
		return rt_creator;
	}

	public void setRt_creator(String rt_creator) {
		this.rt_creator = rt_creator;
	}

	public long getRt_count() {
		return rt_count;
	}

	public void setRt_count(long rt_count) {
		this.rt_count = rt_count;
	}

	public String getRt_name() {
		return rt_name;
	}

	public void setRt_name(String rt_name) {
		this.rt_name = rt_name;
	}

	@Override
	public String toString() {
		return "RoadTest [rt_id=" + rt_id + ", rt_time=" + rt_time + ", rt_station_longitude=" + rt_station_longitude
				+ ", rt_station_latitude=" + rt_station_latitude + ", rt_cellId=" + rt_cellId + ", rt_cell_PCI="
				+ rt_cell_PCI + ", rt_log_RSRP=" + rt_log_RSRP + ", rt_log_SINR=" + rt_log_SINR + ", rt_createTime="
				+ rt_createTime + ", rt_creator=" + rt_creator + ", rt_count=" + rt_count + ", rt_name=" + rt_name
				+ "]";
	}
	
	

}
