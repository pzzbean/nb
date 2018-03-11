package com.ibase.web.roadtest.domain;

public class TemporayWorkparamDomain {
	private String province;//省份
	private String county;//区县
	private String territorial_branch;//属地分公司
	private String factory_name;//厂家名称
	private String station_name;//站名
	private String cell_name;//小区中文名
	private String cgi;//CGI
	private String tracking_area_code;//跟踪区码
	private String cell_logo;//小区标识
	private String physical_cell_logo;//物理小区标识
	private String corresponding_2g_station_name;//对应2G站名
	private String corresponding_2g_cell_name;//对应2G小区名
	private String cell_2g_cgi;//2G小区CGI
	private String longitude;//经度
	private String latitude;//纬度
	private String central_carrier_channel_number;//中心载频的信道号
	private String cell_bandwidth;//小区带宽
	private String work_frequency;//工作频段
	private String carrier_frequency_number;//载频数量
	private String overlay_type;//覆盖类型
	private String electron_downdip_angle;//电子下倾角
	private String mechanical_downdip_angle;//机械下倾角
	private String total_downdip_angle;//总下倾角
	private String azimuth;//方位角
	private String antenna_hang_height;//天线挂高
	private String equipment_maintenance_status;//设备维护状态
	private String manager_status;//管理状态
	private String max_transmit_power;//最大发射功率
	private String equipment_type;//设备型号
	private String equipment_version;//设备版本号
	private String address;//地址
	public TemporayWorkparamDomain() {
	}
	public TemporayWorkparamDomain(String province, String county, String territorial_branch, String factory_name,
			String station_name, String cell_name, String cgi, String tracking_area_code, String cell_logo,
			String physical_cell_logo, String corresponding_2g_station_name, String corresponding_2g_cell_name,
			String cell_2g_cgi, String longitude, String latitude, String central_carrier_channel_number,
			String cell_bandwidth, String work_frequency, String carrier_frequency_number, String overlay_type,
			String electron_downdip_angle, String mechanical_downdip_angle, String total_downdip_angle, String azimuth,
			String antenna_hang_height, String equipment_maintenance_status, String manager_status,
			String max_transmit_power, String equipment_type, String equipment_version, String address) {
		super();
		this.province = province;
		this.county = county;
		this.territorial_branch = territorial_branch;
		this.factory_name = factory_name;
		this.station_name = station_name;
		this.cell_name = cell_name;
		this.cgi = cgi;
		this.tracking_area_code = tracking_area_code;
		this.cell_logo = cell_logo;
		this.physical_cell_logo = physical_cell_logo;
		this.corresponding_2g_station_name = corresponding_2g_station_name;
		this.corresponding_2g_cell_name = corresponding_2g_cell_name;
		this.cell_2g_cgi = cell_2g_cgi;
		this.longitude = longitude;
		this.latitude = latitude;
		this.central_carrier_channel_number = central_carrier_channel_number;
		this.cell_bandwidth = cell_bandwidth;
		this.work_frequency = work_frequency;
		this.carrier_frequency_number = carrier_frequency_number;
		this.overlay_type = overlay_type;
		this.electron_downdip_angle = electron_downdip_angle;
		this.mechanical_downdip_angle = mechanical_downdip_angle;
		this.total_downdip_angle = total_downdip_angle;
		this.azimuth = azimuth;
		this.antenna_hang_height = antenna_hang_height;
		this.equipment_maintenance_status = equipment_maintenance_status;
		this.manager_status = manager_status;
		this.max_transmit_power = max_transmit_power;
		this.equipment_type = equipment_type;
		this.equipment_version = equipment_version;
		this.address = address;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getTerritorial_branch() {
		return territorial_branch;
	}
	public void setTerritorial_branch(String territorial_branch) {
		this.territorial_branch = territorial_branch;
	}
	public String getFactory_name() {
		return factory_name;
	}
	public void setFactory_name(String factory_name) {
		this.factory_name = factory_name;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	public String getCell_name() {
		return cell_name;
	}
	public void setCell_name(String cell_name) {
		this.cell_name = cell_name;
	}
	public String getCgi() {
		return cgi;
	}
	public void setCgi(String cgi) {
		this.cgi = cgi;
	}
	public String getTracking_area_code() {
		return tracking_area_code;
	}
	public void setTracking_area_code(String tracking_area_code) {
		this.tracking_area_code = tracking_area_code;
	}
	public String getCell_logo() {
		return cell_logo;
	}
	public void setCell_logo(String cell_logo) {
		this.cell_logo = cell_logo;
	}
	public String getPhysical_cell_logo() {
		return physical_cell_logo;
	}
	public void setPhysical_cell_logo(String physical_cell_logo) {
		this.physical_cell_logo = physical_cell_logo;
	}
	public String getCorresponding_2g_station_name() {
		return corresponding_2g_station_name;
	}
	public void setCorresponding_2g_station_name(String corresponding_2g_station_name) {
		this.corresponding_2g_station_name = corresponding_2g_station_name;
	}
	public String getCorresponding_2g_cell_name() {
		return corresponding_2g_cell_name;
	}
	public void setCorresponding_2g_cell_name(String corresponding_2g_cell_name) {
		this.corresponding_2g_cell_name = corresponding_2g_cell_name;
	}
	public String getCell_2g_cgi() {
		return cell_2g_cgi;
	}
	public void setCell_2g_cgi(String cell_2g_cgi) {
		this.cell_2g_cgi = cell_2g_cgi;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getCentral_carrier_channel_number() {
		return central_carrier_channel_number;
	}
	public void setCentral_carrier_channel_number(String central_carrier_channel_number) {
		this.central_carrier_channel_number = central_carrier_channel_number;
	}
	public String getCell_bandwidth() {
		return cell_bandwidth;
	}
	public void setCell_bandwidth(String cell_bandwidth) {
		this.cell_bandwidth = cell_bandwidth;
	}
	public String getWork_frequency() {
		return work_frequency;
	}
	public void setWork_frequency(String work_frequency) {
		this.work_frequency = work_frequency;
	}
	public String getCarrier_frequency_number() {
		return carrier_frequency_number;
	}
	public void setCarrier_frequency_number(String carrier_frequency_number) {
		this.carrier_frequency_number = carrier_frequency_number;
	}
	public String getOverlay_type() {
		return overlay_type;
	}
	public void setOverlay_type(String overlay_type) {
		this.overlay_type = overlay_type;
	}
	public String getElectron_downdip_angle() {
		return electron_downdip_angle;
	}
	public void setElectron_downdip_angle(String electron_downdip_angle) {
		this.electron_downdip_angle = electron_downdip_angle;
	}
	public String getMechanical_downdip_angle() {
		return mechanical_downdip_angle;
	}
	public void setMechanical_downdip_angle(String mechanical_downdip_angle) {
		this.mechanical_downdip_angle = mechanical_downdip_angle;
	}
	public String getTotal_downdip_angle() {
		return total_downdip_angle;
	}
	public void setTotal_downdip_angle(String total_downdip_angle) {
		this.total_downdip_angle = total_downdip_angle;
	}
	public String getAzimuth() {
		return azimuth;
	}
	public void setAzimuth(String azimuth) {
		this.azimuth = azimuth;
	}
	public String getAntenna_hang_height() {
		return antenna_hang_height;
	}
	public void setAntenna_hang_height(String antenna_hang_height) {
		this.antenna_hang_height = antenna_hang_height;
	}
	public String getEquipment_maintenance_status() {
		return equipment_maintenance_status;
	}
	public void setEquipment_maintenance_status(String equipment_maintenance_status) {
		this.equipment_maintenance_status = equipment_maintenance_status;
	}
	public String getManager_status() {
		return manager_status;
	}
	public void setManager_status(String manager_status) {
		this.manager_status = manager_status;
	}
	public String getMax_transmit_power() {
		return max_transmit_power;
	}
	public void setMax_transmit_power(String max_transmit_power) {
		this.max_transmit_power = max_transmit_power;
	}
	public String getEquipment_type() {
		return equipment_type;
	}
	public void setEquipment_type(String equipment_type) {
		this.equipment_type = equipment_type;
	}
	public String getEquipment_version() {
		return equipment_version;
	}
	public void setEquipment_version(String equipment_version) {
		this.equipment_version = equipment_version;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "TemporayWorkparamDomain [province=" + province + ", county=" + county + ", territorial_branch="
				+ territorial_branch + ", factory_name=" + factory_name + ", station_name=" + station_name
				+ ", cell_name=" + cell_name + ", cgi=" + cgi + ", tracking_area_code=" + tracking_area_code
				+ ", cell_logo=" + cell_logo + ", physical_cell_logo=" + physical_cell_logo
				+ ", corresponding_2g_station_name=" + corresponding_2g_station_name + ", corresponding_2g_cell_name="
				+ corresponding_2g_cell_name + ", cell_2g_cgi=" + cell_2g_cgi + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", central_carrier_channel_number=" + central_carrier_channel_number
				+ ", cell_bandwidth=" + cell_bandwidth + ", work_frequency=" + work_frequency
				+ ", carrier_frequency_number=" + carrier_frequency_number + ", overlay_type=" + overlay_type
				+ ", electron_downdip_angle=" + electron_downdip_angle + ", mechanical_downdip_angle="
				+ mechanical_downdip_angle + ", total_downdip_angle=" + total_downdip_angle + ", azimuth=" + azimuth
				+ ", antenna_hang_height=" + antenna_hang_height + ", equipment_maintenance_status="
				+ equipment_maintenance_status + ", manager_status=" + manager_status + ", max_transmit_power="
				+ max_transmit_power + ", equipment_type=" + equipment_type + ", equipment_version=" + equipment_version
				+ ", address=" + address + "]";
	}
	
}
