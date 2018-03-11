package com.ibase.web.roadtest.domain2;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class Cell_new {
	/*小区名字*/private String mCommunityBeanName;

	  /*小区工程*/private MCommunityProjectBean mCommunityProject;
	  /*小区网优*/private MCommunityNetworkOptimizationBean mCommunityNetworkOptimization;

	  /*还有需要请新增*/
	  /*小区测试项*/private List<String> mCommunityTestItemList;

	public String getmCommunityBeanName() {
		return mCommunityBeanName;
	}

	public void setmCommunityBeanName(String mCommunityBeanName) {
		this.mCommunityBeanName = mCommunityBeanName;
	}

	public MCommunityProjectBean getmCommunityProject() {
		return mCommunityProject;
	}

	public void setmCommunityProject(MCommunityProjectBean mCommunityProject) {
		this.mCommunityProject = mCommunityProject;
	}

	public MCommunityNetworkOptimizationBean getmCommunityNetworkOptimization() {
		return mCommunityNetworkOptimization;
	}

	public void setmCommunityNetworkOptimization(MCommunityNetworkOptimizationBean mCommunityNetworkOptimization) {
		this.mCommunityNetworkOptimization = mCommunityNetworkOptimization;
	}

	public List<String> getmCommunityTestItemList() {
		return mCommunityTestItemList;
	}

	public void setmCommunityTestItemList(List<String> mCommunityTestItemList) {
		this.mCommunityTestItemList = mCommunityTestItemList;
	}

	public Cell_new(String mCommunityBeanName, MCommunityProjectBean mCommunityProject,
			MCommunityNetworkOptimizationBean mCommunityNetworkOptimization, List<String> mCommunityTestItemList) {
		super();
		this.mCommunityBeanName = mCommunityBeanName;
		this.mCommunityProject = mCommunityProject;
		this.mCommunityNetworkOptimization = mCommunityNetworkOptimization;
		this.mCommunityTestItemList = mCommunityTestItemList;
	}

	public Cell_new() {
		super();
	}

	@Override
	public String toString() {
		return "Cell_new [mCommunityBeanName=" + mCommunityBeanName + ", mCommunityProject=" + mCommunityProject
				+ ", mCommunityNetworkOptimization=" + mCommunityNetworkOptimization + ", mCommunityTestItemList="
				+ mCommunityTestItemList + "]";
	}

	  
}
