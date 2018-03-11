package com.ibase.web.roadtest.domain;

import java.awt.Dimension;
import java.awt.Toolkit;

/*
FieldTypeComment
rti_idbigint(20) NOT NULL路测图片id
rti_namevarchar(50) NULL图片名称
rti_addressvarchar(200) NOT NULL图片保存地址
rti_formatevarchar(10) NULL图片的格式
rtf_idbigint(20) NULL文件的id
target_namevarchar(20) NULL指标的名字*/

public class Image {
	private long rti_id;
	private String rti_name; // 文件的前缀
	private String rti_address;
	private String rti_formate;
	private long rtf_id;
	private String target_name;
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	public long getRti_id() {
		return rti_id;
	}

	public void setRti_id(long rti_id) {
		this.rti_id = rti_id;
	}

	public String getRti_name() {
		return rti_name;
	}

	public void setRti_name(String rti_name) {
		this.rti_name = rti_name;
	}

	public String getRti_address() {
		return rti_address;
	}

	public void setRti_address(String rti_address) {
		this.rti_address = rti_address;
	}

	public String getRti_formate() {
		return rti_formate;
	}

	public void setRti_formate(String rti_formate) {
		this.rti_formate = rti_formate;
	}
	public long getRtf_id() {
		return rtf_id;
	}

	public void setRtf_id(long rtf_id) {
		this.rtf_id = rtf_id;
	}

	public String getTarget_name() {
		return target_name;
	}

	public void setTarget_name(String target_name) {
		this.target_name = target_name;
	}

	public Dimension getD() {
		return d;
	}

	public void setD(Dimension d) {
		this.d = d;
	}

	@Override
	public String toString() {
		return "Image [rti_id=" + rti_id + ", rti_name=" + rti_name + ", rti_address=" + rti_address + ", rti_formate="
				+ rti_formate + ", rtf_id=" + rtf_id + ", target_name=" + target_name + "]";
	}
	
	/****************************************************************
	 * 默认的文件前缀为GuiCamera，文件格式为PNG格式 The default construct will use the default Image
	 * file surname "GuiCamera", and default image format "png"
	 ****************************************************************/

}
