package com.ibase.web.localworkparam.domain;

import com.ibase.core.base.BaseDomain;

public class Cell extends BaseDomain {

	private long cellId;					//小区id
	private String cellName;				//小区名
	private String mechanicalDipAngle;		//机械下倾角
	private String antennaHeight;			//天线挂高
	private String azimuth;					//方位角
	private String totalDipAngle;			//总下倾角
	private String prefabricatedDipAngle;	//预制电下倾角
	private long stationId;					//基站id
	private String section;	//扇区
	private String frequency;
	private String pci;
	private String rsPower;
	
	public long getCellId() {
		return cellId;
	}
	public void setCellId(long cellId) {
		this.cellId = cellId;
	}
	public String getCellName() {
		return cellName;
	}
	public void setCellName(String cellName) {
		this.cellName = cellName;
	}
	public String getMechanicalDipAngle() {
		return mechanicalDipAngle;
	}
	public void setMechanicalDipAngle(String mechanicalDipAngle) {
		this.mechanicalDipAngle = mechanicalDipAngle;
	}
	public String getAntennaHeight() {
		return antennaHeight;
	}
	public void setAntennaHeight(String antennaHeight) {
		this.antennaHeight = antennaHeight;
	}
	public String getAzimuth() {
		return azimuth;
	}
	public void setAzimuth(String azimuth) {
		this.azimuth = azimuth;
	}
	public String getTotalDipAngle() {
		return totalDipAngle;
	}
	public void setTotalDipAngle(String totalDipAngle) {
		this.totalDipAngle = totalDipAngle;
	}
	public String getPrefabricatedDipAngle() {
		return prefabricatedDipAngle;
	}
	public void setPrefabricatedDipAngle(String prefabricatedDipAngle) {
		this.prefabricatedDipAngle = prefabricatedDipAngle;
	}
	public long getStationId() {
		return stationId;
	}
	public void setStationId(long stationId) {
		this.stationId = stationId;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getPci() {
		return pci;
	}
	public void setPci(String pci) {
		this.pci = pci;
	}
	public String getRsPower() {
		return rsPower;
	}
	public void setRsPower(String rsPower) {
		this.rsPower = rsPower;
	}
	@Override
	public String toString() {
		return "Cell [cellId=" + cellId + ", cellName=" + cellName + ", mechanicalDipAngle=" + mechanicalDipAngle
				+ ", antennaHeight=" + antennaHeight + ", azimuth=" + azimuth + ", totalDipAngle=" + totalDipAngle
				+ ", prefabricatedDipAngle=" + prefabricatedDipAngle + ", stationId=" + stationId + ", section="
				+ section + ", frequency=" + frequency + ", pci=" + pci + ", rsPower=" + rsPower + "]";
	}
	
	
	
}
