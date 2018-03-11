package com.ibase.web.roadtest.domain2;

import java.io.Serializable;

import org.springframework.stereotype.Repository;


@Repository
public class MCommunityProjectBean {

  /*Cell ID*/private String mCellID;

  /*频点*/private String mFrequency;

  /*PCI*/private String mPCI;

public String getmCellID() {
	return mCellID;
}

public void setmCellID(String mCellID) {
	this.mCellID = mCellID;
}

public String getmFrequency() {
	return mFrequency;
}

public void setmFrequency(String mFrequency) {
	this.mFrequency = mFrequency;
}

public String getmPCI() {
	return mPCI;
}

public void setmPCI(String mPCI) {
	this.mPCI = mPCI;
}

public MCommunityProjectBean(String mCellID, String mFrequency, String mPCI) {
	super();
	this.mCellID = mCellID;
	this.mFrequency = mFrequency;
	this.mPCI = mPCI;
}

public MCommunityProjectBean() {
	super();
}

@Override
public String toString() {
	return "MCommunityProjectBean [mCellID=" + mCellID + ", mFrequency=" + mFrequency + ", mPCI=" + mPCI + "]";
}

 
}
