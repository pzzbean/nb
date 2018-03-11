package com.ibase.web.testplan.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibase.web.roadtest.domain.TemporayWorkparamDomain2;
import com.ibase.web.roadtest.domain2.Cell_new;
import com.ibase.web.roadtest.domain2.MCommunityNetworkOptimizationBean;
import com.ibase.web.roadtest.domain2.MCommunityProjectBean;
import com.ibase.web.roadtest.domain2.Station_new;
import com.ibase.web.testplan.domain.TemporaryTestplan;
import com.ibase.web.testplan.mapper.TemporaryTestplanMapper;

@Service
public class TemporaryTestplanServiceImpl implements com.ibase.web.testplan.service.TemporaryTestplanService {

	@Autowired
	TemporaryTestplanMapper temporaryTestplanMapper;

	@Override
	public List<TemporaryTestplan> queryTemporaryTestplans() {
		return temporaryTestplanMapper.queryTemporaryTestplans();
	}

	
	
	@Override
	public List<TemporaryTestplan> queryTemporaryTestplansByCondition(TemporaryTestplan temporaryTestplan) {
		return temporaryTestplanMapper.queryTemporaryTestplansByCondition(temporaryTestplan);
	}



	//添加计划     临时加（可能有多个基站号传入）
	public int insertTemporaryTestPlans(TemporaryTestplan temporaryTestplan) {
		List<String> stationNoList = temporaryTestplan.getStationNoList();
		for(String stationNo : stationNoList){
			temporaryTestplan.setStationNo(stationNo);
		}
		return temporaryTestplanMapper.insertTemporaryTestPlans(temporaryTestplan);
	}



	@Override
	public int delTemporaryTestPlans(long temporaryTestplanId) {
		return temporaryTestplanMapper.delTemporaryTestPlans(temporaryTestplanId);
	}



	@Override
	public int updTemporaryTestPlans(TemporaryTestplan temporaryTestplan, long temporaryTestplanId) {
		return temporaryTestplanMapper.updTemporaryTestPlans(temporaryTestplan, temporaryTestplanId);
	}

	@Override
	public List<Station_new> selectAllStation(String userId , String testStartTime) {
		TemporaryTestplan temporaryTestplan = new TemporaryTestplan();
		//封装接收参数
		temporaryTestplan.setUserId(userId);
		temporaryTestplan.setTestStartTime(testStartTime);
		//接收基站编号
		HashSet<Station_new> stationNoSet=new HashSet<>();
		// 创建list集合存储所有基站
		List<Station_new> stationNewList = new ArrayList<>();
		List<TemporaryTestplan> list1 = temporaryTestplanMapper.selectAllStation1(temporaryTestplan);
		//System.out.println(list1.size()+"list1:"+list1);
		for (TemporaryTestplan temporaryTestplan1 : list1) {
			//通过temporaryTestplan表的基站号查询到temporayWorkparamDomain2表中的信息
			List<TemporayWorkparamDomain2> temporayWorkparamDomain2List = temporaryTestplanMapper.selectByStationNo(temporaryTestplan1.getStationNo());
			//遍历temporayWorkparamDomain2List
			for (TemporayWorkparamDomain2 temporayWorkparamDomain2 : temporayWorkparamDomain2List) {
				Station_new sn = new Station_new();
				sn.setmAltitude(temporayWorkparamDomain2.getHeight());// 海拔
				sn.setmBaseStationName(temporayWorkparamDomain2.getStation_name());// 基站名
				sn.setmBaseStationNumber(temporayWorkparamDomain2.getStation_no());// 基站编号
				sn.setmBaseStationType(null);// 基站类型
				sn.setmLatitude(temporayWorkparamDomain2.getLatitude());// 纬度
				sn.setmLongitude(temporayWorkparamDomain2.getLongitude());// 经度
				sn.setmTac(temporayWorkparamDomain2.getTac());// TAC
				stationNoSet.add(sn);
			}
		}
		
		for (Station_new currStationNumber : stationNoSet) {
			List<Cell_new> cellList=new ArrayList<>();
			//查询所有小区
			List<String> cell_namelist = temporaryTestplanMapper.selectTestPlanNewStationnew2(currStationNumber.getmBaseStationNumber());
			//遍历所有小区
			for (String currCellName : cell_namelist) {
				Cell_new cn = new Cell_new();
				cn.setmCommunityBeanName(currCellName);
				TemporayWorkparamDomain2 temporayWorkparamDomain2_3 = temporaryTestplanMapper.selectTestPlanNewStationnew3(currCellName);
				MCommunityProjectBean mCommunityProjectBean=new MCommunityProjectBean();
				mCommunityProjectBean.setmCellID(temporayWorkparamDomain2_3.getCi());
				mCommunityProjectBean.setmFrequency(temporayWorkparamDomain2_3.getDownlink());
				mCommunityProjectBean.setmPCI(temporayWorkparamDomain2_3.getPci());
				cn.setmCommunityProject(mCommunityProjectBean);
				
				MCommunityNetworkOptimizationBean mcnob=new MCommunityNetworkOptimizationBean();
				mcnob.setmAntennaHangUp("40dBm");// 不知RsPower对应工参的那个属性
				mcnob.setmAzimuth(temporayWorkparamDomain2_3.getAzimuth());// 方位角
				mcnob.setmMechanicalLowerInclination(temporayWorkparamDomain2_3.getMechanical_downtilt());// 机械下倾角
				mcnob.setmPresetElectricDip(temporayWorkparamDomain2_3.getElectrical_downtilt());// 预置电下倾
				mcnob.setMtotalLowerInclination(temporayWorkparamDomain2_3.getTotal_downtilt());// 总下倾角
				mcnob.setmAntennaHangUp(temporayWorkparamDomain2_3.getHeight());// 
				cn.setmCommunityNetworkOptimization(mcnob);
				
				List<String> listIndex =  new ArrayList<>();
				listIndex.add("Ping性能");//Ping性能ping
				listIndex.add("无线信号");//无线信号wirelessSignal
				//listIndex.add("邻区信号");//邻区信号neighborhoodSignal
				listIndex.add("附着性能");//附着性能attach
				listIndex.add("重选性能");//重选性能re-election
				listIndex.add("接入性能");//接入性能access
				listIndex.add("吞吐率性能");//吞吐率性能throughput
				cn.setmCommunityTestItemList(listIndex);
				cellList.add(cn);
			}
			currStationNumber.setmCommunityBeanList(cellList);
			stationNewList.add(currStationNumber);
		}
		return stationNewList;
	}


}
