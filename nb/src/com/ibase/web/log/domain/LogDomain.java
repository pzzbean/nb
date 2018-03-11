package com.ibase.web.log.domain;

import com.ibase.core.base.BaseDomain;
/**
 * 性能日志
 */
/*FieldTypeComment
log_idbigint(20) NOT NULL
plane_idbigint(20) NULL计划id
station_novarchar(20) NULL基站号
cell_sectionvarchar(20) NULL
log_RSRPvarchar(10) NULLRSRP
log_SINRvarchar(10) NULLSINR
log_iperfTop_ratevarchar(20) NULL上行速率
log_iperfDown_ratevarchar(20) NULL下行速率
log_delayTimevarchar(10) NULLping时延
log_openRatevarchar(10) NULL接通率
log_ReselectDelayvarchar(10) NULL重传时延
log_AttachDelayvarchar(10) NULL接通时延
statusint(2) NULL-1:不达标，1:达标
log_descvarchar(100) NULL说明
log_creatorbigint(20) NULL创建人
log_create_timedatetime NULL创建时间
log_versionvarchar(20) NULL版本
log_cellIDvarchar(20) NULL
log_PCIvarchar(20) NULL
log_RSSIvarchar(20) NULL
log_UDPTop_ratevarchar(20) NULLUDP上行速率
log_UDPDown_ratevarchar(20) NULLUDP下行速率
log_FTPTop_ratevarchar(20) NULLFTP上行速率
log_FTPDown_ratevarchar(20) NULLFTP下行速率
log_PingOldvarchar(20) NULL*/
public class LogDomain extends BaseDomain {
	private long log_id;
	private long plane_id;
	private String station_no;
	private String cell_section;
	private String log_RSRP;
	private String log_SINR;
	private String log_iperfTop_rate;
	private String log_iperfDown_rate;
	private String log_delayTime;
	private String log_ReselectDelay;
	private String log_AttachDelay;
	private String log_openRate;
	private int status;
	private String log_desc;
	private long log_creator;
	private String log_create_time;
	private String log_version;
	private String log_cellID;
	private String log_PCI;
	private String log_RSSI;
	private String log_UDPTop_rate;
	private String log_UDPDown_rate;
	private String log_FTPTop_rate;
	private String log_FTPDown_rate;
	private String log_PingOld;
	
	public long getLog_id() {
		return log_id;
	}
	public void setLog_id(long log_id) {
		this.log_id = log_id;
	}
	public long getPlane_id() {
		return plane_id;
	}
	public void setPlane_id(long plane_id) {
		this.plane_id = plane_id;
	}
	public String getStation_no() {
		return station_no;
	}
	public void setStation_no(String station_no) {
		this.station_no = station_no;
	}
	public String getCell_section() {
		return cell_section;
	}
	public void setCell_section(String cell_section) {
		this.cell_section = cell_section;
	}
	public String getLog_RSRP() {
		return log_RSRP;
	}
	public void setLog_RSRP(String log_RSRP) {
		this.log_RSRP = log_RSRP;
	}
	public String getLog_SINR() {
		return log_SINR;
	}
	public void setLog_SINR(String log_SINR) {
		this.log_SINR = log_SINR;
	}
	public String getLog_iperfTop_rate() {
		return log_iperfTop_rate;
	}
	public void setLog_iperfTop_rate(String log_iperfTop_rate) {
		this.log_iperfTop_rate = log_iperfTop_rate;
	}
	public String getLog_iperfDown_rate() {
		return log_iperfDown_rate;
	}
	public void setLog_iperfDown_rate(String log_iperfDown_rate) {
		this.log_iperfDown_rate = log_iperfDown_rate;
	}
	public String getLog_delayTime() {
		return log_delayTime;
	}
	public void setLog_delayTime(String log_delayTime) {
		this.log_delayTime = log_delayTime;
	}
	public String getLog_ReselectDelay() {
		return log_ReselectDelay;
	}
	public void setLog_ReselectDelay(String log_ReselectDelay) {
		this.log_ReselectDelay = log_ReselectDelay;
	}
	public String getLog_AttachDelay() {
		return log_AttachDelay;
	}
	public void setLog_AttachDelay(String log_AttachDelay) {
		this.log_AttachDelay = log_AttachDelay;
	}
	public String getLog_openRate() {
		return log_openRate;
	}
	public void setLog_openRate(String log_openRate) {
		this.log_openRate = log_openRate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getLog_desc() {
		return log_desc;
	}
	public void setLog_desc(String log_desc) {
		this.log_desc = log_desc;
	}
	public long getLog_creator() {
		return log_creator;
	}
	public void setLog_creator(long log_creator) {
		this.log_creator = log_creator;
	}
	public String getLog_create_time() {
		return log_create_time;
	}
	public void setLog_create_time(String log_create_time) {
		this.log_create_time = log_create_time;
	}
	public String getLog_version() {
		return log_version;
	}
	public void setLog_version(String log_version) {
		this.log_version = log_version;
	}
	public String getLog_cellID() {
		return log_cellID;
	}
	public void setLog_cellID(String log_cellID) {
		this.log_cellID = log_cellID;
	}
	public String getLog_PCI() {
		return log_PCI;
	}
	public void setLog_PCI(String log_PCI) {
		this.log_PCI = log_PCI;
	}
	public String getLog_RSSI() {
		return log_RSSI;
	}
	public void setLog_RSSI(String log_RSSI) {
		this.log_RSSI = log_RSSI;
	}
	public String getLog_UDPTop_rate() {
		return log_UDPTop_rate;
	}
	public void setLog_UDPTop_rate(String log_UDPTop_rate) {
		this.log_UDPTop_rate = log_UDPTop_rate;
	}
	public String getLog_UDPDown_rate() {
		return log_UDPDown_rate;
	}
	public void setLog_UDPDown_rate(String log_UDPDown_rate) {
		this.log_UDPDown_rate = log_UDPDown_rate;
	}
	public String getLog_FTPTop_rate() {
		return log_FTPTop_rate;
	}
	public void setLog_FTPTop_rate(String log_FTPTop_rate) {
		this.log_FTPTop_rate = log_FTPTop_rate;
	}
	public String getLog_FTPDown_rate() {
		return log_FTPDown_rate;
	}
	public void setLog_FTPDown_rate(String log_FTPDown_rate) {
		this.log_FTPDown_rate = log_FTPDown_rate;
	}
	public String getLog_PingOld() {
		return log_PingOld;
	}
	public void setLog_PingOld(String log_PingOld) {
		this.log_PingOld = log_PingOld;
	}
	@Override
	public String toString() {
		return "LogDomain [log_id=" + log_id + ", plane_id=" + plane_id + ", station_no=" + station_no
				+ ", cell_section=" + cell_section + ", log_RSRP=" + log_RSRP + ", log_SINR=" + log_SINR
				+ ", log_iperfTop_rate=" + log_iperfTop_rate + ", log_iperfDown_rate=" + log_iperfDown_rate
				+ ", log_delayTime=" + log_delayTime + ", log_ReselectDelay=" + log_ReselectDelay + ", log_AttachDelay="
				+ log_AttachDelay + ", log_openRate=" + log_openRate + ", status=" + status + ", log_desc=" + log_desc
				+ ", log_creator=" + log_creator + ", log_create_time=" + log_create_time + ", log_version="
				+ log_version + ", log_cellID=" + log_cellID + ", log_PCI=" + log_PCI + ", log_RSSI=" + log_RSSI
				+ ", log_UDPTop_rate=" + log_UDPTop_rate + ", log_UDPDown_rate=" + log_UDPDown_rate
				+ ", log_FTPTop_rate=" + log_FTPTop_rate + ", log_FTPDown_rate=" + log_FTPDown_rate + ", log_PingOld="
				+ log_PingOld + "]";
	}
	
	
	
}
