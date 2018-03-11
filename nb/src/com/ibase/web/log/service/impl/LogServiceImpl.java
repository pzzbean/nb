package com.ibase.web.log.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibase.web.log.domain.LogCXDomain;
import com.ibase.web.log.domain.LogDomain;
import com.ibase.web.log.domain.SingleTestReport;
import com.ibase.web.log.mapper.LogMapper;
import com.ibase.web.log.service.LogService;
import com.ibase.web.roadtest.domain.CellIndexResultTotal;
import com.ibase.web.roadtest.domain.TemporayWorkparamDomain2;
import com.ibase.web.testplan.domain.TemporaryTestplan;

@Service
public class LogServiceImpl implements LogService {
	
	
	@Autowired
	public LogMapper logMapper;
	
	@Autowired
	HttpServletRequest request;
	
	@Override 
	public TemporayWorkparamDomain2 queryByStationNo(LogCXDomain logCXDomain) {
		return logMapper.queryByStationNo(logCXDomain);
	}

	@Override
	public List<CellIndexResultTotal> queryByUIAndSN(LogCXDomain logCXDomain){
		List<CellIndexResultTotal> list=logMapper.queryByUIAndSN(logCXDomain);
		return list;
	}

	@Override
	public int insertLog(LogDomain logMain) {
		return logMapper.insertLog(logMain);
	}

	@Override
	public long countLog(LogDomain logDomain) {
		return logMapper.countLog(logDomain);
	}

	@Override
	public List<LogDomain> queryLog(LogDomain logDomain) {
		int currentPage = logDomain.getPage().getCurrentPage();
    	int pageSize = logDomain.getPage().getPageSize();
    	
    	logDomain.getPage().setTotalRows((int)countLog(logDomain));
    	logDomain.getPage().setStartNum((currentPage-1)*pageSize);
    	logDomain.getPage().setEndIndex(pageSize);
		
		return logMapper.queryLog(logDomain);
	}
	
	@Override
	public LogDomain searchSingleLog(LogDomain logDomain) {
		List<LogDomain> list = queryLog(logDomain);
		if(list == null || list.size()<1)
		{
			return null;
		}
	    return list.get(0);
	}

	@Override
	public List<SingleTestReport> querySigneTestReport(SingleTestReport  single) {
		int currentPage = single.getPage().getCurrentPage();
    	int pageSize = single.getPage().getPageSize();
    	
    	single.getPage().setTotalRows((int)countSingle(single));
    	single.getPage().setStartNum((currentPage-1)*pageSize);
    	single.getPage().setEndIndex(pageSize);
		return logMapper.querySigneTestReport(single);
	}
	public long countSingle(SingleTestReport  single) {
		String count = logMapper.countSingle(single);
		if(count!=null&&!"".equals(count)){
			return Long.parseLong(count);
		}
		return 0;
	}

	@Override
	public long updatetLog(LogDomain logDomain) {
		return logMapper.updatetLog(logDomain);
		
	}

	@Override
	public TemporaryTestplan queryUserBySnoAndDate(LogCXDomain logCXDomain) {
		// TODO Auto-generated method stub
		return logMapper.queryUserBySnoAndDate(logCXDomain);
	}

}
