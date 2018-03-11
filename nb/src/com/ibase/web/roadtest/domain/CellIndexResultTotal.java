package com.ibase.web.roadtest.domain;

public class CellIndexResultTotal {
	
	private int userId;//用户编号
	private String testDate;//测试时间
	private String station_No;//基站编号
	private String communityName;//小区名称
	private String wireless_RSRP;//无线信号的RSRP
	private String wireless_SINR;//无线信号的SINR
	private String near_RSRP;//邻区信号的RSRP
	private int a_Attempts; //附着性能-尝试次数
	private int a_Success;//附着性能-成功次数
	private String a_SuccessRatio;//附着性能-成功率
	private int c_ReElection;//重选性能-小区重选次数
	private int c_Success;//重选性能-小区重选成功次数
	private String c_ReElectionRatio;//重选性能-小区重选成功率
	private String p_Delay;//Ping性能-ping时延
	private int p_Pttempts;//Ping性能-Ping尝试次数
	private int p_success;//Ping性能-Ping成功次数
	private String p_SuccessRadio;//Ping性能-Ping成功率
	private String udp_UpRate;//吞吐率性能-UDP上行速率
	private String udp_DownRate;//吞吐率性能-UDP下行速率
	private String cellId;//小区编号
	private String pci;
	private String frequency;//频点
	private String r_ReElection;
	private String r_Success;
	private String r_ReElectionRatio;
	private String tac;
	private String ci;
	
	public CellIndexResultTotal() {
	}
	
	public CellIndexResultTotal(int userId, String testDate, String station_No, String communityName,
			String wireless_RSRP, String wireless_SINR, String near_RSRP, int a_Attempts, int a_Success,
			String a_SuccessRatio, int c_ReElection, int c_Success, String c_ReElectionRatio, String p_Delay,
			int p_Pttempts, int p_success, String p_SuccessRadio, String udp_UpRate, String udp_DownRate, String cellId,
			String pci, String frequency, String r_ReElection, String r_Success, String r_ReElectionRatio, String tac,
			String ci) {
		super();
		this.userId = userId;
		this.testDate = testDate;
		this.station_No = station_No;
		this.communityName = communityName;
		this.wireless_RSRP = wireless_RSRP;
		this.wireless_SINR = wireless_SINR;
		this.near_RSRP = near_RSRP;
		this.a_Attempts = a_Attempts;
		this.a_Success = a_Success;
		this.a_SuccessRatio = a_SuccessRatio;
		this.c_ReElection = c_ReElection;
		this.c_Success = c_Success;
		this.c_ReElectionRatio = c_ReElectionRatio;
		this.p_Delay = p_Delay;
		this.p_Pttempts = p_Pttempts;
		this.p_success = p_success;
		this.p_SuccessRadio = p_SuccessRadio;
		this.udp_UpRate = udp_UpRate;
		this.udp_DownRate = udp_DownRate;
		this.cellId = cellId;
		this.pci = pci;
		this.frequency = frequency;
		this.r_ReElection = r_ReElection;
		this.r_Success = r_Success;
		this.r_ReElectionRatio = r_ReElectionRatio;
		this.tac = tac;
		this.ci = ci;
	}

	public String getR_ReElection() {
		return r_ReElection;
	}
	public void setR_ReElection(String r_ReElection) {
		this.r_ReElection = r_ReElection;
	}
	public String getR_Success() {
		return r_Success;
	}
	public void setR_Success(String r_Success) {
		this.r_Success = r_Success;
	}
	public String getR_ReElectionRatio() {
		return r_ReElectionRatio;
	}
	public void setR_ReElectionRatio(String r_ReElectionRatio) {
		this.r_ReElectionRatio = r_ReElectionRatio;
	}
	public String getTac() {
		return tac;
	}
	public void setTac(String tac) {
		this.tac = tac;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	public String getStation_No() {
		return station_No;
	}
	public void setStation_No(String station_No) {
		this.station_No = station_No;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getWireless_RSRP() {
		return wireless_RSRP;
	}
	public void setWireless_RSRP(String wireless_RSRP) {
		this.wireless_RSRP = wireless_RSRP;
	}
	public String getWireless_SINR() {
		return wireless_SINR;
	}
	public void setWireless_SINR(String wireless_SINR) {
		this.wireless_SINR = wireless_SINR;
	}
	public String getNear_RSRP() {
		return near_RSRP;
	}
	public void setNear_RSRP(String near_RSRP) {
		this.near_RSRP = near_RSRP;
	}
	public int getA_Attempts() {
		return a_Attempts;
	}
	public void setA_Attempts(int a_Attempts) {
		this.a_Attempts = a_Attempts;
	}
	public int getA_Success() {
		return a_Success;
	}
	public void setA_Success(int a_Success) {
		this.a_Success = a_Success;
	}
	public String getA_SuccessRatio() {
		return a_SuccessRatio;
	}
	public void setA_SuccessRatio(String a_SuccessRatio) {
		this.a_SuccessRatio = a_SuccessRatio;
	}
	public int getC_ReElection() {
		return c_ReElection;
	}
	public void setC_ReElection(int c_ReElection) {
		this.c_ReElection = c_ReElection;
	}
	public int getC_Success() {
		return c_Success;
	}
	public void setC_Success(int c_Success) {
		this.c_Success = c_Success;
	}
	public String getC_ReElectionRatio() {
		return c_ReElectionRatio;
	}
	public void setC_ReElectionRatio(String c_ReElectionRatio) {
		this.c_ReElectionRatio = c_ReElectionRatio;
	}
	public String getP_Delay() {
		return p_Delay;
	}
	public void setP_Delay(String p_Delay) {
		this.p_Delay = p_Delay;
	}
	public int getP_Pttempts() {
		return p_Pttempts;
	}
	public void setP_Pttempts(int p_Pttempts) {
		this.p_Pttempts = p_Pttempts;
	}
	public int getP_success() {
		return p_success;
	}
	public void setP_success(int p_success) {
		this.p_success = p_success;
	}
	public String getP_SuccessRadio() {
		return p_SuccessRadio;
	}
	public void setP_SuccessRadio(String p_SuccessRadio) {
		this.p_SuccessRadio = p_SuccessRadio;
	}
	public String getUdp_UpRate() {
		return udp_UpRate;
	}
	public void setUdp_UpRate(String udp_UpRate) {
		this.udp_UpRate = udp_UpRate;
	}
	public String getUdp_DownRate() {
		return udp_DownRate;
	}
	public void setUdp_DownRate(String udp_DownRate) {
		this.udp_DownRate = udp_DownRate;
	}
	public String getCellId() {
		return cellId;
	}
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}
	public String getPci() {
		return pci;
	}
	public void setPci(String pci) {
		this.pci = pci;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	@Override
	public String toString() {
		return "CellIndexResultTotal [userId=" + userId + ", testDate=" + testDate + ", station_No=" + station_No
				+ ", communityName=" + communityName + ", wireless_RSRP=" + wireless_RSRP + ", wireless_SINR="
				+ wireless_SINR + ", near_RSRP=" + near_RSRP + ", a_Attempts=" + a_Attempts + ", a_Success=" + a_Success
				+ ", a_SuccessRatio=" + a_SuccessRatio + ", c_ReElection=" + c_ReElection + ", c_Success=" + c_Success
				+ ", c_ReElectionRatio=" + c_ReElectionRatio + ", p_Delay=" + p_Delay + ", p_Pttempts=" + p_Pttempts
				+ ", p_success=" + p_success + ", p_SuccessRadio=" + p_SuccessRadio + ", udp_UpRate=" + udp_UpRate
				+ ", udp_DownRate=" + udp_DownRate + ", cellId=" + cellId + ", pci=" + pci + ", frequency=" + frequency
				+ ", r_ReElection=" + r_ReElection + ", r_Success=" + r_Success + ", r_ReElectionRatio="
				+ r_ReElectionRatio + ", tac=" + tac + ", ci=" + ci + "]";
	}
	
}
