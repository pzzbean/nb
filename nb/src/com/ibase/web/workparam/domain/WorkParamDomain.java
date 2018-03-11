package com.ibase.web.workparam.domain;

import com.ibase.core.base.BaseDomain;
import com.sun.xml.internal.ws.message.MimeAttachmentSet;
/**
 * 运营商工参
 */
public class WorkParamDomain extends BaseDomain {
	private long wp_id;
	private String wp_station_no;
	private String wp_station_height;
	private String wp_station_longitude;
	private String wp_station_latitude;
	private String wp_station_TAC;
	private String wp_station_ENBID;
	private String wp_cell_section;//扇区
	private String wp_cell_ECI;
	private String wp_cell_PCI;
	private String wp_cell_workModel;//方位角
	private String wp_cell_bearing;
	private String wp_cell_dipAangle;
	private String wp_cell_top_frequency;
	private String wp_cell_top_bandwidth;
	private String wp_cell_down_frequency;
	private String wp_cell_down_bandwidth;
	
	public String getWp_cell_down_bandwidth() {
		return wp_cell_down_bandwidth;
	}
	public void setWp_cell_down_bandwidth(String wp_cell_down_bandwidth) {
		this.wp_cell_down_bandwidth = wp_cell_down_bandwidth;
	}
	public long getWp_id() {
		return wp_id;
	}
	public void setWp_id(long wp_id) {
		this.wp_id = wp_id;
	}
	public String getWp_station_no() {
		return wp_station_no;
	}
	public void setWp_station_no(String wp_station_no) {
		this.wp_station_no = wp_station_no;
	}
	public String getWp_station_height() {
		return wp_station_height;
	}
	public void setWp_station_height(String wp_station_height) {
		this.wp_station_height = wp_station_height;
	}
	public String getWp_station_longitude() {
		return wp_station_longitude;
	}
	public void setWp_station_longitude(String wp_station_longitude) {
		this.wp_station_longitude = wp_station_longitude;
	}
	public String getWp_station_latitude() {
		return wp_station_latitude;
	}
	public void setWp_station_latitude(String wp_station_latitude) {
		this.wp_station_latitude = wp_station_latitude;
	}
	public String getWp_station_TAC() {
		return wp_station_TAC;
	}
	public void setWp_station_TAC(String wp_station_TAC) {
		this.wp_station_TAC = wp_station_TAC;
	}
	public String getWp_station_ENBID() {
		return wp_station_ENBID;
	}
	public void setWp_station_ENBID(String wp_station_ENBID) {
		this.wp_station_ENBID = wp_station_ENBID;
	}
	public String getWp_cell_section() {
		return wp_cell_section;
	}
	public void setWp_cell_section(String wp_cell_section) {
		this.wp_cell_section = wp_cell_section;
	}
	public String getWp_cell_ECI() {
		return wp_cell_ECI;
	}
	public void setWp_cell_ECI(String wp_cell_ECI) {
		this.wp_cell_ECI = wp_cell_ECI;
	}
	public String getWp_cell_PCI() {
		return wp_cell_PCI;
	}
	public void setWp_cell_PCI(String wp_cell_PCI) {
		this.wp_cell_PCI = wp_cell_PCI;
	}
	public String getWp_cell_workModel() {
		return wp_cell_workModel;
	}
	public void setWp_cell_workModel(String wp_cell_workModel) {
		this.wp_cell_workModel = wp_cell_workModel;
	}
	public String getWp_cell_bearing() {
		return wp_cell_bearing;
	}
	public void setWp_cell_bearing(String wp_cell_bearing) {
		this.wp_cell_bearing = wp_cell_bearing;
	}
	public String getWp_cell_dipAangle() {
		return wp_cell_dipAangle;
	}
	public void setWp_cell_dipAangle(String wp_cell_dipAangle) {
		this.wp_cell_dipAangle = wp_cell_dipAangle;
	}
	public String getWp_cell_top_frequency() {
		return wp_cell_top_frequency;
	}
	public void setWp_cell_top_frequency(String wp_cell_top_frequency) {
		this.wp_cell_top_frequency = wp_cell_top_frequency;
	}
	public String getWp_cell_top_bandwidth() {
		return wp_cell_top_bandwidth;
	}
	public void setWp_cell_top_bandwidth(String wp_cell_top_bandwidth) {
		this.wp_cell_top_bandwidth = wp_cell_top_bandwidth;
	}
	public String getWp_cell_down_frequency() {
		return wp_cell_down_frequency;
	}
	public void setWp_cell_down_frequency(String wp_cell_down_frequency) {
		this.wp_cell_down_frequency = wp_cell_down_frequency;
	}
	 
	public static void main(String[] args) {
		Object  o =0;
	}

}
