package com.ibase.web.log.service;

import java.util.List;

import com.ibase.web.log.domain.LogCXDomain;
import com.ibase.web.log.domain.LogDomain;
import com.ibase.web.log.domain.SingleTestReport;
import com.ibase.web.roadtest.domain.CellIndexResultTotal;
import com.ibase.web.roadtest.domain.TemporayWorkparamDomain;
import com.ibase.web.roadtest.domain.TemporayWorkparamDomain2;
import com.ibase.web.testplan.domain.TemporaryTestplan;

public interface LogService {
	int insertLog(LogDomain logDoMain);
	
	long countLog(LogDomain logDomain);
	
	List<LogDomain> queryLog(LogDomain logDomain);
	
	public LogDomain searchSingleLog(LogDomain logDomain);
	
	List<SingleTestReport> querySigneTestReport(SingleTestReport single);
	
	long countSingle(SingleTestReport single);

	long updatetLog(LogDomain logDomain);
	
	List<CellIndexResultTotal> queryByUIAndSN(LogCXDomain logCXDomain);

	TemporayWorkparamDomain2 queryByStationNo(LogCXDomain logCXDomain);
	
	TemporaryTestplan queryUserBySnoAndDate(LogCXDomain logCXDomain);
}
