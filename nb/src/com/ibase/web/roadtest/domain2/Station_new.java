package com.ibase.web.roadtest.domain2;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class Station_new {
	/*基站编号*/private String mBaseStationNumber;
	  /*TAC*/private String mTac;
	  /*海拔*/private String mAltitude;
	  ///*扇区*/private String mSector;
	  /*基站类型*/private String mBaseStationType;
	  /*纬度*/private String mLatitude;
	  /*经度*/private String mLongitude;
	  /*基站名*/private String mBaseStationName;
	  ///*基站距离*/private String mBaseStationDistance;
	  /*小区数据集*/private List<Cell_new>mCommunityBeanList;
	public String getmBaseStationNumber() {
		return mBaseStationNumber;
	}
	public void setmBaseStationNumber(String mBaseStationNumber) {
		this.mBaseStationNumber = mBaseStationNumber;
	}
	public String getmTac() {
		return mTac;
	}
	public void setmTac(String mTac) {
		this.mTac = mTac;
	}
	public String getmAltitude() {
		return mAltitude;
	}
	public void setmAltitude(String mAltitude) {
		this.mAltitude = mAltitude;
	}
	public String getmBaseStationType() {
		return mBaseStationType;
	}
	public void setmBaseStationType(String mBaseStationType) {
		this.mBaseStationType = mBaseStationType;
	}
	public String getmLatitude() {
		return mLatitude;
	}
	public void setmLatitude(String mLatitude) {
		this.mLatitude = mLatitude;
	}
	public String getmLongitude() {
		return mLongitude;
	}
	public void setmLongitude(String mLongitude) {
		this.mLongitude = mLongitude;
	}
	public String getmBaseStationName() {
		return mBaseStationName;
	}
	public void setmBaseStationName(String mBaseStationName) {
		this.mBaseStationName = mBaseStationName;
	}
	public List<Cell_new> getmCommunityBeanList() {
		return mCommunityBeanList;
	}
	public void setmCommunityBeanList(List<Cell_new> mCommunityBeanList) {
		this.mCommunityBeanList = mCommunityBeanList;
	}
	public Station_new(String mBaseStationNumber, String mTac, String mAltitude, String mBaseStationType,
			String mLatitude, String mLongitude, String mBaseStationName, List<Cell_new> mCommunityBeanList) {
		super();
		this.mBaseStationNumber = mBaseStationNumber;
		this.mTac = mTac;
		this.mAltitude = mAltitude;
		this.mBaseStationType = mBaseStationType;
		this.mLatitude = mLatitude;
		this.mLongitude = mLongitude;
		this.mBaseStationName = mBaseStationName;
		this.mCommunityBeanList = mCommunityBeanList;
	}
	public Station_new() {
		super();
	}
	@Override
	public String toString() {
		return "Station_new [mBaseStationNumber=" + mBaseStationNumber + ", mTac=" + mTac + ", mAltitude=" + mAltitude
				+ ", mBaseStationType=" + mBaseStationType + ", mLatitude=" + mLatitude + ", mLongitude=" + mLongitude
				+ ", mBaseStationName=" + mBaseStationName + ", mCommunityBeanList=" + mCommunityBeanList + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mAltitude == null) ? 0 : mAltitude.hashCode());
		result = prime * result + ((mBaseStationName == null) ? 0 : mBaseStationName.hashCode());
		result = prime * result + ((mBaseStationNumber == null) ? 0 : mBaseStationNumber.hashCode());
		result = prime * result + ((mBaseStationType == null) ? 0 : mBaseStationType.hashCode());
		result = prime * result + ((mLatitude == null) ? 0 : mLatitude.hashCode());
		result = prime * result + ((mLongitude == null) ? 0 : mLongitude.hashCode());
		result = prime * result + ((mTac == null) ? 0 : mTac.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Station_new other = (Station_new) obj;
		if (mAltitude == null) {
			if (other.mAltitude != null)
				return false;
		} else if (!mAltitude.equals(other.mAltitude))
			return false;
		if (mBaseStationName == null) {
			if (other.mBaseStationName != null)
				return false;
		} else if (!mBaseStationName.equals(other.mBaseStationName))
			return false;
		if (mBaseStationNumber == null) {
			if (other.mBaseStationNumber != null)
				return false;
		} else if (!mBaseStationNumber.equals(other.mBaseStationNumber))
			return false;
		if (mBaseStationType == null) {
			if (other.mBaseStationType != null)
				return false;
		} else if (!mBaseStationType.equals(other.mBaseStationType))
			return false;
		if (mLatitude == null) {
			if (other.mLatitude != null)
				return false;
		} else if (!mLatitude.equals(other.mLatitude))
			return false;
		if (mLongitude == null) {
			if (other.mLongitude != null)
				return false;
		} else if (!mLongitude.equals(other.mLongitude))
			return false;
		if (mTac == null) {
			if (other.mTac != null)
				return false;
		} else if (!mTac.equals(other.mTac))
			return false;
		return true;
	}

}
