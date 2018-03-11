package com.ibase.web.roadtest.domain2;

import java.io.Serializable;

import org.springframework.stereotype.Repository;


@Repository
public class MCommunityNetworkOptimizationBean {

  /*RsPower*/private String mRsPower;
  /*天线挂高*/private String mAntennaHangUp;
  /*方位角*/private String mAzimuth;
  /*总下倾角*/private String mtotalLowerInclination;
  /*预置电下倾*/private String mPresetElectricDip;
  /*机械下倾角*/private String mMechanicalLowerInclination;
public String getmRsPower() {
	return mRsPower;
}
public void setmRsPower(String mRsPower) {
	this.mRsPower = mRsPower;
}
public String getmAntennaHangUp() {
	return mAntennaHangUp;
}
public void setmAntennaHangUp(String mAntennaHangUp) {
	this.mAntennaHangUp = mAntennaHangUp;
}
public String getmAzimuth() {
	return mAzimuth;
}
public void setmAzimuth(String mAzimuth) {
	this.mAzimuth = mAzimuth;
}
public String getMtotalLowerInclination() {
	return mtotalLowerInclination;
}
public void setMtotalLowerInclination(String mtotalLowerInclination) {
	this.mtotalLowerInclination = mtotalLowerInclination;
}
public String getmPresetElectricDip() {
	return mPresetElectricDip;
}
public void setmPresetElectricDip(String mPresetElectricDip) {
	this.mPresetElectricDip = mPresetElectricDip;
}
public String getmMechanicalLowerInclination() {
	return mMechanicalLowerInclination;
}
public void setmMechanicalLowerInclination(String mMechanicalLowerInclination) {
	this.mMechanicalLowerInclination = mMechanicalLowerInclination;
}
public MCommunityNetworkOptimizationBean(String mRsPower, String mAntennaHangUp, String mAzimuth,
		String mtotalLowerInclination, String mPresetElectricDip, String mMechanicalLowerInclination) {
	super();
	this.mRsPower = mRsPower;
	this.mAntennaHangUp = mAntennaHangUp;
	this.mAzimuth = mAzimuth;
	this.mtotalLowerInclination = mtotalLowerInclination;
	this.mPresetElectricDip = mPresetElectricDip;
	this.mMechanicalLowerInclination = mMechanicalLowerInclination;
}
public MCommunityNetworkOptimizationBean() {
	super();
}
@Override
public String toString() {
	return "MCommunityNetworkOptimizationBean [mRsPower=" + mRsPower + ", mAntennaHangUp=" + mAntennaHangUp
			+ ", mAzimuth=" + mAzimuth + ", mtotalLowerInclination=" + mtotalLowerInclination + ", mPresetElectricDip="
			+ mPresetElectricDip + ", mMechanicalLowerInclination=" + mMechanicalLowerInclination + "]";
}

  
}
