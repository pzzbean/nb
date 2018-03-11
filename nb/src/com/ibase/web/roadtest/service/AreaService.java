package com.ibase.web.roadtest.service;

import java.util.List;

import com.ibase.web.roadtest.domain.TemporayWorkparamDomain2;
import com.ibase.web.testplan.domain.TemporaryTestplan;

public interface AreaService {

	List<TemporayWorkparamDomain2> queryHomeArea();

	List<TemporayWorkparamDomain2> queryAllByHa(String homeArea);

	List<TemporayWorkparamDomain2> queryByStationNo(String stationNo);

	List<TemporayWorkparamDomain2> selectStationAndCellBySN(String stationNo);

}
