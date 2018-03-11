package com.ibase.web.roadtest.domain;

import com.ibase.core.base.BaseDomain;

/*REATE TABLE `roadtestfile` (
		  `rtf_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '路测文件的id',
		  `rtf_name` varchar(20) DEFAULT NULL COMMENT '路测文件的名称',
		  `user_id` bigint(20) DEFAULT NULL COMMENT '路测人员',
		  `rtf_time` varchar(20) DEFAULT NULL COMMENT '路测的大概时间',
		  PRIMARY KEY (`rtf_id`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8*/
public class RoadTestFile extends BaseDomain {
	private long rtf_id;
	private String rtf_name;
	private Integer user_id;
	private String rtf_time;
	private String rtf_upload_time;

	public RoadTestFile(long rtf_id, String rtf_name, Integer user_id, String rtf_time, String rtf_upload_time) {
		this.rtf_id = rtf_id;
		this.rtf_name = rtf_name;
		this.user_id = user_id;
		this.rtf_time = rtf_time;
		this.rtf_upload_time = rtf_upload_time;
	}

	public RoadTestFile(long rtf_id, String rtf_name, String rtf_time, String rtf_upload_time) {
		this.rtf_id = rtf_id;
		this.rtf_name = rtf_name;
		this.rtf_time = rtf_time;
		this.rtf_upload_time = rtf_upload_time;
	}

	public RoadTestFile() {
	}

	public long getRtf_id() {
		return rtf_id;
	}

	public void setRtf_id(long rtf_id) {
		this.rtf_id = rtf_id;
	}

	public String getRtf_name() {
		return rtf_name;
	}

	public void setRtf_name(String rtf_name) {
		this.rtf_name = rtf_name;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getRtf_time() {
		return rtf_time;
	}

	public void setRtf_time(String rtf_time) {
		this.rtf_time = rtf_time;
	}

	public String getRtf_upload_time() {
		return rtf_upload_time;
	}

	public void setRtf_upload_time(String rtf_upload_time) {
		this.rtf_upload_time = rtf_upload_time;
	}

	@Override
	public String toString() {
		return "RoadTestFile [rtf_id=" + rtf_id + ", rtf_name=" + rtf_name + ", user_id=" + user_id + ", rtf_time="
				+ rtf_time + ", rtf_upload_time=" + rtf_upload_time + "]";
	}

}
