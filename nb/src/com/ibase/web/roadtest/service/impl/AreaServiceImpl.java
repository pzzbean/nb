package com.ibase.web.roadtest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibase.web.roadtest.domain.TemporayWorkparamDomain2;
import com.ibase.web.roadtest.mapper.AreaMapper;
import com.ibase.web.roadtest.service.AreaService;
@Service
public class AreaServiceImpl implements AreaService {
	@Autowired
	AreaMapper areaMapper;

	@Override
	public List<TemporayWorkparamDomain2> queryHomeArea() {
		return areaMapper.queryHomeArea();
	}

	@Override
	public List<TemporayWorkparamDomain2> queryAllByHa(String homeArea) {
		return areaMapper.queryAllByHa(homeArea);
	}

	@Override
	public List<TemporayWorkparamDomain2> queryByStationNo(String stationNo) {
		return areaMapper.queryByStationNo(stationNo);
	}

	@Override
	public List<TemporayWorkparamDomain2> selectStationAndCellBySN(String stationNo) {
		//接收基站编号
		//HashSet<Station_new> stationNumberSet=new HashSet<>();
		//根据基站号查到所有基站和小区
		/*List<TemporayWorkparamDomain2> temporayWorkparamDomain2List = new ArrayList<>();
		List<TemporayWorkparamDomain2> list1 = areaMapper.selectStationAndCellBySN(stationNo);
		for(TemporayWorkparamDomain2 temporayWorkparamDomain2 : list1){
			Station_new sn = new Station_new();
			sn.setmAltitude(temporayWorkparamDomain2.getHeight());// 海拔
			sn.setmBaseStationName(temporayWorkparamDomain2.getStation_name());// 基站名
			sn.setmBaseStationNumber(temporayWorkparamDomain2.getStation_no());// 基站编号
			sn.setmBaseStationType(null);// 基站类型
			sn.setmLatitude(temporayWorkparamDomain2.getLatitude());// 纬度
			sn.setmLongitude(temporayWorkparamDomain2.getLongitude());// 经度
			sn.setmTac(temporayWorkparamDomain2.getTac());// TAC
			stationNumberSet.add(sn);
		}
		for (Station_new currStationNumber : stationNumberSet) {
			List<Cell_new> cellList=new ArrayList<>();
			List<TemporayWorkparamDomain2> cell_namelist = areaMapper.selectStationAndCellBySN(stationNo);
			for (TemporayWorkparamDomain2 temporayWorkparamDomain2  : cell_namelist) {
				Cell_new cn = new Cell_new();
				MCommunityProjectBean mCommunityProjectBean=new MCommunityProjectBean();
				mCommunityProjectBean.setmCellID(temporayWorkparamDomain2.getCi());
				mCommunityProjectBean.setmFrequency(temporayWorkparamDomain2.getFrequency_downlink());
				mCommunityProjectBean.setmPCI(temporayWorkparamDomain2.getPci());
				cn.setmCommunityProject(mCommunityProjectBean);
				
				MCommunityNetworkOptimizationBean mcnob=new MCommunityNetworkOptimizationBean();
				mcnob.setmAntennaHangUp("40dBm");// 不知RsPower对应工参的那个属性
				mcnob.setmAzimuth(temporayWorkparamDomain2.getAzimuth());// 方位角
				mcnob.setmMechanicalLowerInclination(temporayWorkparamDomain2.getMechanical_downtilt());// 机械下倾角
				mcnob.setmPresetElectricDip(temporayWorkparamDomain2.getElectrical_downtilt());// 预置电下倾
				mcnob.setMtotalLowerInclination(temporayWorkparamDomain2.getTotal_downtilt());// 总下倾角
				mcnob.setmAntennaHangUp(temporayWorkparamDomain2.getHeight());// 
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
			temporayWorkparamDomain2List.add(currStationNumber);
		}*/
		return null;

	}
}