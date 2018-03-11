package com.ibase.web.roadtest.mapper;

import java.util.List;

import com.ibase.web.roadtest.domain.TemporayWorkparamDomain2;
import com.ibase.web.testplan.domain.TemporaryTestplan;

public interface AreaMapper {
	//��ѯ��ͬ����
	List<TemporayWorkparamDomain2> queryHomeArea();
	//���ݲ�ͬ�����ѯ���Ӧ��������Ϣ
	List<TemporayWorkparamDomain2> queryAllByHa(String homeArea);
	//ͨ����վ�Ų�ѯ
	List<TemporayWorkparamDomain2> queryByStationNo(String stationNo);
	//查询基站号和小区
	List<TemporayWorkparamDomain2> selectStationAndCellBySN(String stationNo);

}
