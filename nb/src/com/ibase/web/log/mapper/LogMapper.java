package com.ibase.web.log.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ibase.web.log.domain.LogCXDomain;
import com.ibase.web.log.domain.LogDomain;
import com.ibase.web.log.domain.SingleTestReport;
import com.ibase.web.roadtest.domain.CellIndexResultTotal;
import com.ibase.web.roadtest.domain.TemporayWorkparamDomain2;
import com.ibase.web.testplan.domain.TemporaryTestplan;
@Component
public interface LogMapper {
	int insertLog(LogDomain logDomain);
	
	long countLog(LogDomain logDomain);
	
	List<LogDomain> queryLog(LogDomain logDomain);
	
	List<SingleTestReport> querySigneTestReport(SingleTestReport single);
	
	String countSingle(SingleTestReport single);

	long updatetLog(LogDomain logDomain);
	
	List<CellIndexResultTotal> queryByUIAndSN(LogCXDomain logCXDomain);
	
	TemporayWorkparamDomain2 queryByStationNo(LogCXDomain logCXDomain);
	
	TemporaryTestplan queryUserBySnoAndDate(LogCXDomain logCXDomain);
}
