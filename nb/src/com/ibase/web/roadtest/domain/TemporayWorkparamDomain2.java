package com.ibase.web.roadtest.domain;

public class TemporayWorkparamDomain2 {
	private Integer id;       //主键
	private String home_area;//褰掑睘鍖哄煙
	private String station_name;//绔欏悕锛圔TS name锛�
	private String station_english_name;//eNodeB name鑻辨枃鍚�
	private String physical_station_name;//鐗╃悊绔欏悕锛堝叡绔橪TE/GSM绔欏悕锛�
	private String cell_chinese_name;//灏忓尯涓枃鍚�
	private String cell_english_name;//灏忓尯鑻辨枃鍚�
	private String station_no;//eNB ID(鍩虹珯缂栧彿)
	private String ci;//CI(璁＄畻鍚庣殑灏忓尯id)
	private String station_no_hex;//eNB ID(HEX)(鍩虹珯缂栧彿鍗佸叚杩涘埗)
	private String sector_id;//Sector ID
	private String local_cell_resource_id;//Local Cell Resource ID(灏忓尯鐨勬簮id)
	private String cell_id;//CellID
	private String longitude;//缁忓害
	private String latitude;//绾害
	private String antenna_manufacturer;//澶╃嚎鍘傚
	private String antenna_type;//澶╃嚎鍨嬪彿
	private String antenna_path;//Antenna path
	private String height;//Height
	private String azimuth;//Azimuth(鏂逛綅瑙�)
	private String fixed_electrical_downtilt;//Fixed Electrical Downtilt锛堝浐瀹氱數瀛愪笅鍊捐锛�
	private String electrical_downtilt;//Electrical Downtilt(鐢靛瓙涓嬪�捐)
	private String mechanical_downtilt;//Mechanical Downtilt(鏈烘涓嬪�捐)
	private String total_downtilt;//Total Downtilt鎬讳笅鍊捐
	private String inside_or_outside;//瀹ゅ唴瀹ゅ
	private String nbiot_operation_mode;//NB-IoT operation mode鎿嶄綔妯″紡
	private String eutra_operating_Band;//E-UTRA_Operating_Band锛圗-UTRA鏈夋晥棰戞锛�
	private String downlink;//NB-IoT standalone EARFCN Downlink(standaloneEarfcnDL)(涓嬭棰戠偣)
	private String frequency_downlink;//Frequency downlink
	private String downlink_channel_bandwidth;//Downlink channel bandwidth
	private String earfcn_uplink;//EARFCN uplink
	private String frequency_uplink;//Frequency_uplink
	private String uplink_channel_bandwidth;//Uplink channel bandwidth
	private String maximum_output_power;//Maximum output power
	private String mcc;//MCC
	private String mnc_length_in_plmn;//MNC length in PLMN
	private String mnc;//MNC
	private String tac;//Tracking Area Code
	private String tac_hex;//TAC(Hex)鍗佸叚杩涘埗
	private String pci;//Physical layer cell identity锛坧ci锛�
	private String uplink_reference_signals_cyclic_shift;//Uplink reference signals cyclic shift
	private String group_assignment_for_pusch;//Group assignment for PUSCH
	private String cell_technology;//Cell technology
	private String bbu;//BBU
	private String rru;//RRU
	private String remark;//澶囨敞
	public TemporayWorkparamDomain2() {
	}
	public TemporayWorkparamDomain2(Integer id ,String home_area, String station_name, String station_english_name,
			String physical_station_name, String cell_chinese_name, String cell_english_name, String station_no,
			String ci, String station_no_hex, String sector_id, String local_cell_resource_id, String cell_id,
			String longitude, String latitude, String antenna_manufacturer, String antenna_type, String antenna_path,
			String height, String azimuth, String fixed_electrical_downtilt, String electrical_downtilt,
			String mechanical_downtilt, String total_downtilt, String inside_or_outside, String nbiot_operation_mode,
			String eutra_operating_Band, String downlink, String frequency_downlink, String downlink_channel_bandwidth,
			String earfcn_uplink, String frequency_uplink, String uplink_channel_bandwidth, String maximum_output_power,
			String mcc, String mnc_length_in_plmn, String mnc, String tac, String tac_hex, String pci,
			String uplink_reference_signals_cyclic_shift, String group_assignment_for_pusch, String cell_technology,
			String bbu, String rru, String remark) {
		super();
		this.id = id;
		this.home_area = home_area;
		this.station_name = station_name;
		this.station_english_name = station_english_name;
		this.physical_station_name = physical_station_name;
		this.cell_chinese_name = cell_chinese_name;
		this.cell_english_name = cell_english_name;
		this.station_no = station_no;
		this.ci = ci;
		this.station_no_hex = station_no_hex;
		this.sector_id = sector_id;
		this.local_cell_resource_id = local_cell_resource_id;
		this.cell_id = cell_id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.antenna_manufacturer = antenna_manufacturer;
		this.antenna_type = antenna_type;
		this.antenna_path = antenna_path;
		this.height = height;
		this.azimuth = azimuth;
		this.fixed_electrical_downtilt = fixed_electrical_downtilt;
		this.electrical_downtilt = electrical_downtilt;
		this.mechanical_downtilt = mechanical_downtilt;
		this.total_downtilt = total_downtilt;
		this.inside_or_outside = inside_or_outside;
		this.nbiot_operation_mode = nbiot_operation_mode;
		this.eutra_operating_Band = eutra_operating_Band;
		this.downlink = downlink;
		this.frequency_downlink = frequency_downlink;
		this.downlink_channel_bandwidth = downlink_channel_bandwidth;
		this.earfcn_uplink = earfcn_uplink;
		this.frequency_uplink = frequency_uplink;
		this.uplink_channel_bandwidth = uplink_channel_bandwidth;
		this.maximum_output_power = maximum_output_power;
		this.mcc = mcc;
		this.mnc_length_in_plmn = mnc_length_in_plmn;
		this.mnc = mnc;
		this.tac = tac;
		this.tac_hex = tac_hex;
		this.pci = pci;
		this.uplink_reference_signals_cyclic_shift = uplink_reference_signals_cyclic_shift;
		this.group_assignment_for_pusch = group_assignment_for_pusch;
		this.cell_technology = cell_technology;
		this.bbu = bbu;
		this.rru = rru;
		this.remark = remark;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHome_area() {
		return home_area;
	}
	public void setHome_area(String home_area) {
		this.home_area = home_area;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	public String getStation_english_name() {
		return station_english_name;
	}
	public void setStation_english_name(String station_english_name) {
		this.station_english_name = station_english_name;
	}
	public String getPhysical_station_name() {
		return physical_station_name;
	}
	public void setPhysical_station_name(String physical_station_name) {
		this.physical_station_name = physical_station_name;
	}
	public String getCell_chinese_name() {
		return cell_chinese_name;
	}
	public void setCell_chinese_name(String cell_chinese_name) {
		this.cell_chinese_name = cell_chinese_name;
	}
	public String getCell_english_name() {
		return cell_english_name;
	}
	public void setCell_english_name(String cell_english_name) {
		this.cell_english_name = cell_english_name;
	}
	public String getStation_no() {
		return station_no;
	}
	public void setStation_no(String station_no) {
		this.station_no = station_no;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getStation_no_hex() {
		return station_no_hex;
	}
	public void setStation_no_hex(String station_no_hex) {
		this.station_no_hex = station_no_hex;
	}
	public String getSector_id() {
		return sector_id;
	}
	public void setSector_id(String sector_id) {
		this.sector_id = sector_id;
	}
	public String getLocal_cell_resource_id() {
		return local_cell_resource_id;
	}
	public void setLocal_cell_resource_id(String local_cell_resource_id) {
		this.local_cell_resource_id = local_cell_resource_id;
	}
	public String getCell_id() {
		return cell_id;
	}
	public void setCell_id(String cell_id) {
		this.cell_id = cell_id;
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
	public String getAntenna_manufacturer() {
		return antenna_manufacturer;
	}
	public void setAntenna_manufacturer(String antenna_manufacturer) {
		this.antenna_manufacturer = antenna_manufacturer;
	}
	public String getAntenna_type() {
		return antenna_type;
	}
	public void setAntenna_type(String antenna_type) {
		this.antenna_type = antenna_type;
	}
	public String getAntenna_path() {
		return antenna_path;
	}
	public void setAntenna_path(String antenna_path) {
		this.antenna_path = antenna_path;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getAzimuth() {
		return azimuth;
	}
	public void setAzimuth(String azimuth) {
		this.azimuth = azimuth;
	}
	public String getFixed_electrical_downtilt() {
		return fixed_electrical_downtilt;
	}
	public void setFixed_electrical_downtilt(String fixed_electrical_downtilt) {
		this.fixed_electrical_downtilt = fixed_electrical_downtilt;
	}
	public String getElectrical_downtilt() {
		return electrical_downtilt;
	}
	public void setElectrical_downtilt(String electrical_downtilt) {
		this.electrical_downtilt = electrical_downtilt;
	}
	public String getMechanical_downtilt() {
		return mechanical_downtilt;
	}
	public void setMechanical_downtilt(String mechanical_downtilt) {
		this.mechanical_downtilt = mechanical_downtilt;
	}
	public String getTotal_downtilt() {
		return total_downtilt;
	}
	public void setTotal_downtilt(String total_downtilt) {
		this.total_downtilt = total_downtilt;
	}
	public String getInside_or_outside() {
		return inside_or_outside;
	}
	public void setInside_or_outside(String inside_or_outside) {
		this.inside_or_outside = inside_or_outside;
	}
	public String getNbiot_operation_mode() {
		return nbiot_operation_mode;
	}
	public void setNbiot_operation_mode(String nbiot_operation_mode) {
		this.nbiot_operation_mode = nbiot_operation_mode;
	}
	public String getEutra_operating_Band() {
		return eutra_operating_Band;
	}
	public void setEutra_operating_Band(String eutra_operating_Band) {
		this.eutra_operating_Band = eutra_operating_Band;
	}
	public String getDownlink() {
		return downlink;
	}
	public void setDownlink(String downlink) {
		this.downlink = downlink;
	}
	public String getFrequency_downlink() {
		return frequency_downlink;
	}
	public void setFrequency_downlink(String frequency_downlink) {
		this.frequency_downlink = frequency_downlink;
	}
	public String getDownlink_channel_bandwidth() {
		return downlink_channel_bandwidth;
	}
	public void setDownlink_channel_bandwidth(String downlink_channel_bandwidth) {
		this.downlink_channel_bandwidth = downlink_channel_bandwidth;
	}
	public String getEarfcn_uplink() {
		return earfcn_uplink;
	}
	public void setEarfcn_uplink(String earfcn_uplink) {
		this.earfcn_uplink = earfcn_uplink;
	}
	public String getFrequency_uplink() {
		return frequency_uplink;
	}
	public void setFrequency_uplink(String frequency_uplink) {
		this.frequency_uplink = frequency_uplink;
	}
	public String getUplink_channel_bandwidth() {
		return uplink_channel_bandwidth;
	}
	public void setUplink_channel_bandwidth(String uplink_channel_bandwidth) {
		this.uplink_channel_bandwidth = uplink_channel_bandwidth;
	}
	public String getMaximum_output_power() {
		return maximum_output_power;
	}
	public void setMaximum_output_power(String maximum_output_power) {
		this.maximum_output_power = maximum_output_power;
	}
	public String getMcc() {
		return mcc;
	}
	public void setMcc(String mcc) {
		this.mcc = mcc;
	}
	public String getMnc_length_in_plmn() {
		return mnc_length_in_plmn;
	}
	public void setMnc_length_in_plmn(String mnc_length_in_plmn) {
		this.mnc_length_in_plmn = mnc_length_in_plmn;
	}
	public String getMnc() {
		return mnc;
	}
	public void setMnc(String mnc) {
		this.mnc = mnc;
	}
	public String getTac() {
		return tac;
	}
	public void setTac(String tac) {
		this.tac = tac;
	}
	public String getTac_hex() {
		return tac_hex;
	}
	public void setTac_hex(String tac_hex) {
		this.tac_hex = tac_hex;
	}
	public String getPci() {
		return pci;
	}
	public void setPci(String pci) {
		this.pci = pci;
	}
	public String getUplink_reference_signals_cyclic_shift() {
		return uplink_reference_signals_cyclic_shift;
	}
	public void setUplink_reference_signals_cyclic_shift(String uplink_reference_signals_cyclic_shift) {
		this.uplink_reference_signals_cyclic_shift = uplink_reference_signals_cyclic_shift;
	}
	public String getGroup_assignment_for_pusch() {
		return group_assignment_for_pusch;
	}
	public void setGroup_assignment_for_pusch(String group_assignment_for_pusch) {
		this.group_assignment_for_pusch = group_assignment_for_pusch;
	}
	public String getCell_technology() {
		return cell_technology;
	}
	public void setCell_technology(String cell_technology) {
		this.cell_technology = cell_technology;
	}
	public String getBbu() {
		return bbu;
	}
	public void setBbu(String bbu) {
		this.bbu = bbu;
	}
	public String getRru() {
		return rru;
	}
	public void setRru(String rru) {
		this.rru = rru;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "TemporayWorkparamDomain2 [id=" + id + ",home_area=" + home_area + ", station_name=" + station_name
				+ ", station_english_name=" + station_english_name + ", physical_station_name=" + physical_station_name
				+ ", cell_chinese_name=" + cell_chinese_name + ", cell_english_name=" + cell_english_name
				+ ", station_no=" + station_no + ", ci=" + ci + ", station_no_hex=" + station_no_hex + ", sector_id="
				+ sector_id + ", local_cell_resource_id=" + local_cell_resource_id + ", cell_id=" + cell_id
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", antenna_manufacturer="
				+ antenna_manufacturer + ", antenna_type=" + antenna_type + ", antenna_path=" + antenna_path
				+ ", height=" + height + ", azimuth=" + azimuth + ", fixed_electrical_downtilt="
				+ fixed_electrical_downtilt + ", electrical_downtilt=" + electrical_downtilt + ", mechanical_downtilt="
				+ mechanical_downtilt + ", total_downtilt=" + total_downtilt + ", inside_or_outside="
				+ inside_or_outside + ", nbiot_operation_mode=" + nbiot_operation_mode + ", eutra_operating_Band="
				+ eutra_operating_Band + ", downlink=" + downlink + ", frequency_downlink=" + frequency_downlink
				+ ", downlink_channel_bandwidth=" + downlink_channel_bandwidth + ", earfcn_uplink=" + earfcn_uplink
				+ ", frequency_uplink=" + frequency_uplink + ", uplink_channel_bandwidth=" + uplink_channel_bandwidth
				+ ", maximum_output_power=" + maximum_output_power + ", mcc=" + mcc + ", mnc_length_in_plmn="
				+ mnc_length_in_plmn + ", mnc=" + mnc + ", tac=" + tac + ", tac_hex=" + tac_hex + ", pci=" + pci
				+ ", uplink_reference_signals_cyclic_shift=" + uplink_reference_signals_cyclic_shift
				+ ", group_assignment_for_pusch=" + group_assignment_for_pusch + ", cell_technology=" + cell_technology
				+ ", bbu=" + bbu + ", rru=" + rru + ", remark=" + remark + "]";
	}
}
