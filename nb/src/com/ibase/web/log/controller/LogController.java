package com.ibase.web.log.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibase.core.http.ResponsePacket;
import com.ibase.core.http.ResponsePacket2;
import com.ibase.core.utils.StringUtil;
import com.ibase.web.log.domain.LogCXDomain;
import com.ibase.web.log.domain.LogDomain;
import com.ibase.web.log.domain.LogUser;
import com.ibase.web.log.domain.SingleTestReport;
import com.ibase.web.log.service.LogService;
import com.ibase.web.log.service.impl.LogServiceImpl;
import com.ibase.web.log.util.CSVUtils;
import com.ibase.web.log.util.I18nUtil;
import com.ibase.web.log.util.LogUtil;
import com.ibase.web.plane.service.PlaneService;
import com.ibase.web.roadtest.controlle.RoadTestController;
import com.ibase.web.roadtest.domain.CellIndexResultTotal;
import com.ibase.web.roadtest.domain.LonLat;
import com.ibase.web.roadtest.domain.TemporayWorkparamDomain;
import com.ibase.web.roadtest.domain.TemporayWorkparamDomain2;
import com.ibase.web.roadtest.service.RoadService;
import com.ibase.web.testplan.domain.TemporaryTestplan;
import com.ibase.web.user.domain.User;
import com.ibase.web.user.service.UserService;
import com.ibase.web.workparam.service.WorkParamService;
import com.ibase.web.workparam_in.domain.WorkParam_inDomain;
import com.ibase.web.workparam_in.service.WorkParam_inService;

@Controller
@RequestMapping(value = "/log")
public class LogController {
	@Autowired
	private LogService logService;
	@Autowired
	private WorkParam_inService workParam_inService;
	@Autowired
	private WorkParamService workParamService;
	@Autowired
	private PlaneService planeService;
	@Autowired
	private RoadService roadService;
	@Autowired
	private RoadTestController roadTestController;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;

	/*
	 * @RequestMapping(path = "/insertLog")
	 * 
	 * @ResponseBody public ResponsePacket insertLog(LogDomain logDomain, String
	 * user_id) { ResponsePacket json = new ResponsePacket(-1, "添加日志失败！");
	 * System.out.println("k"); // 空值验证 if (StringUtil.isEmpty(user_id)) {
	 * json.setMsg("user_id不能为空"); return json; } System.out.println("k0"); if
	 * (LogUtil.isNull(logDomain) != null) { System.out.println(logDomain);
	 * json.setMsg(LogUtil.isNull(logDomain)); return json; }
	 * System.out.println("k0"); // 判断性能是否达标 logDomain.setStatus(1); String log_desc
	 * = LogUtil.isStandard(logDomain); if (log_desc != null) {
	 * logDomain.setStatus(-1); logDomain.setLog_desc(log_desc); }
	 * 
	 * // 添加 logDomain.setLog_creator(Long.parseLong(user_id));
	 * logService.insertLog(logDomain);
	 * 
	 * if (logDomain.getLog_id() > 0) { //
	 * System.out.println(logDomain.getLog_id()); json.setCode(1);
	 * json.setMsg("添加成功！"); } System.out.println("k2"); return json; }
	 */
	//根据测试时间和基站编号查询所有小区的测试结果插入报告
	@RequestMapping(path="queryByUIAndSN")
	@ResponseBody
	public ResponsePacket queryByUIAndSN(LogCXDomain logCXDomain) {
		List<CellIndexResultTotal> cellIndex = logService.queryByUIAndSN(logCXDomain);
		ResponsePacket json = new ResponsePacket();
		json.setListObject(cellIndex);
		return json;
	}
	//根据ci小区id和小区表示查询所有小区的测试结果插入报告
	@RequestMapping(path="queryByStationNo")
	@ResponseBody
	public TemporayWorkparamDomain2 queryByStationNo(LogCXDomain logCXDomain) {
		TemporayWorkparamDomain2 tem = logService.queryByStationNo(logCXDomain);
		return tem;
	}

	@RequestMapping(path = "/insertLog")
	@ResponseBody
	public ResponsePacket updatetLog(LogDomain logDomain, String user_id) {
		ResponsePacket json = new ResponsePacket(-1, "添加日志失败！");
		System.out.println("k");
		// 空值验证
		if (StringUtil.isEmpty(user_id)) {
			json.setMsg("user_id不能为空");
			return json;
		}
		System.out.println("k0");
		/*
		 * if (LogUtil.isNull(logDomain) != null) { System.out.println(logDomain);
		 * json.setMsg(LogUtil.isNull(logDomain)); return json; }
		 */
		System.out.println("k0");
		// 判断性能是否达标
		logDomain.setStatus(1);
		// String log_desc = LogUtil.isStandard(logDomain);
		/*
		 * if (log_desc != null) { logDomain.setStatus(-1);
		 * logDomain.setLog_desc(log_desc); }
		 */

		// 添加
		logDomain.setLog_creator(Long.parseLong(user_id));
		long updateLog = logService.updatetLog(logDomain);

		if (updateLog > 0) {
			// System.out.println(logDomain.getLog_id());
			System.out.println("c");
			json.setCode(1);
			json.setMsg("添加成功！");
		}
		System.out.println("k2");
		return json;
	}

	/**
	 * 分页的传入的 当前页 字段为page.currentPage 分页穿去的 显示条数 字段为page.pageSize
	 */
	@RequestMapping(path = "/listLog")
	@ResponseBody
	public ResponsePacket listLog(LogDomain log) {
		// 添加模糊查询，即加上'%'
		LogUtil.likePro(log);
		System.out.println("ok");
		// 查询数据
		List<LogDomain> list = logService.queryLog(log);
		System.out.println("ok2");
		// 封装
		ResponsePacket json = new ResponsePacket(1, "查询成功");
		json.setListObject(list);
		json.setPage(log.getPage());
		System.out.println("ok3");
		return json;
	}

	/**
	 * 单验数据
	 */
	@RequestMapping(path = "/listSingle")
	@ResponseBody
	public ResponsePacket ListSingleTestReport(SingleTestReport single) {
		// 模糊查询
		if (!StringUtil.isEmpty(single.getStation_no())) {
			single.setStation_no("%" + single.getStation_no() + "%");
		}

		// 查询数据
		List<SingleTestReport> list = logService.querySigneTestReport(single);

		// 封装
		ResponsePacket json = new ResponsePacket(1, "查询成功");
		json.setListObject(list);
		json.setPage(single.getPage());

		return json;

	}

//	/**
//	 * 移动单验报告
//	 */
//	@RequestMapping(path = "/createSingle1")
//	@ResponseBody
//	public ResponsePacket createSingle2(HttpServletRequest request, SingleTestReport single,
//			HttpServletResponse response) {
//		String[] indexArr = { "rsrp", "sinr" };
//		long rtf_id = 1;
//		List<String> adList = new ArrayList<>();
//		for (String target_name : indexArr) {
//			String address = roadService.getAddress(rtf_id, target_name);
//			adList.add(address);
//		}
//		single.setPlane_test_time(single.getPlane_test_time().substring(0, 10));
//		ResponsePacket json = new ResponsePacket(-1, "单验报告生成失败！");
//		System.out.println(single.getPlane_id() + ":" + single.getUser_id() + ":" + single.getPlane_test_time());
//
//		// 封装数据
//		Map dataMap = new HashMap();
//		dataMap.put("planeService", planeService);
//		dataMap.put("workParam_inService", workParam_inService);
//		dataMap.put("workParamService", workParamService);
//		dataMap.put("logService", logService);
//		LogUtil.singleData(dataMap, single);
//		String lang = I18nUtil.getLanguage(request);
//		// 生成单验报告
//		int result = LogUtil.createSingle(response, dataMap, adList, lang);
//		if (result == -1)
//			return json;
//
//		// 封装状态
//		json.setCode(1);
//		json.setMsg("单验报告生成成功！");
//		return json;
//	}

	/**
	 * 联通单验报告
	 */
	@RequestMapping(path = "/createSingle3")
	@ResponseBody
	public ResponsePacket createSingle_CT(SingleTestReport single, HttpServletResponse response) {
		single.setPlane_test_time(single.getPlane_test_time().substring(0, 10));
		ResponsePacket json = new ResponsePacket(-1, "单验报告生成失败！");
		System.out.println(single.getPlane_id() + ":" + single.getUser_id() + ":" + single.getPlane_test_time());

		// 封装数据
		Map dataMap = new HashMap();
		dataMap.put("planeService", planeService);
		dataMap.put("workParam_inService", workParam_inService);
		dataMap.put("workParamService", workParamService);
		dataMap.put("logService", logService);
		LogUtil.singleData(dataMap, single);
		String lang = I18nUtil.getLanguage(request);
		// 生成单验报告
		int result = LogUtil.createSingle_CT(response, dataMap, lang);
		if (result == -1)
			return json;

		// 封装状态
		json.setCode(1);
		json.setMsg("单验报告生成成功！");
		return json;
	}

	/**
	 * 电信单验报告
	 */
	@RequestMapping(path = "/createSingle2")
	@ResponseBody
	public ResponsePacket createSingle_QCUQ(SingleTestReport single, HttpServletResponse response,WorkParam_inDomain workParam_in) {
		single.setPlane_test_time(single.getPlane_test_time().substring(0, 10));
		ResponsePacket json = new ResponsePacket(-1, "单验报告生成失败！");
		System.out.println(single.getPlane_id() + ":" + single.getUser_id() + ":" + single.getPlane_test_time());
		// 封装数据
		Map dataMap = new HashMap();
		dataMap.put("planeService", planeService);
		dataMap.put("workParam_inService", workParam_inService);
		dataMap.put("workParamService", workParamService);
		dataMap.put("logService", logService);
		LogUtil.singleData(dataMap, single);
		String lang = I18nUtil.getLanguage(request);
		System.out.println("lang" + lang);
		// 生成单验报告
		int result = LogUtil.createSingle_QCUQ(response, dataMap, lang);
		if (result == -1)
			return json;

		// 封装状态
		json.setCode(1);
		json.setMsg("单验报告生成成功！");
		return json;
	}
	
	
	/**
	 * 上海移动CCDL报告
	 */
	@RequestMapping(path="/createSingle1")
	@ResponseBody
	public ResponsePacket createSingle_CCDL(HttpServletRequest request, HttpServletResponse response,LogCXDomain logCXDomain){//,SingleTestReport single) {
		System.out.println("进入方法。。。。。。。");
		System.out.println("参数"+logCXDomain);
		Map dataMap = new HashMap();
		dataMap.put("logService", logService);
		ResponsePacket json = new ResponsePacket(-1,"单验报告生成失败");
		if(logCXDomain.getStation_No()==null||logCXDomain.getTestDate()==null){
			json.setCode(-1);
			json.setMsg("数据不匹配，单验报告生成失败!");
			return json;
		}else{
			//生成单验报告
			List<TemporayWorkparamDomain2> temporayWorkparamDomainList =new ArrayList<>();
			//根据基站编号和测试日期查询工参
			List<CellIndexResultTotal> listCellIndexResultTotals = logService.queryByUIAndSN(logCXDomain);
			TemporaryTestplan temporaryTestplan=new TemporaryTestplan();
			temporaryTestplan=logService.queryUserBySnoAndDate(logCXDomain);
			if(listCellIndexResultTotals==null||listCellIndexResultTotals.size()==0){
				json.setCode(-1);
				json.setMsg("日志数据为空，单验报告生成失败!");
				return json;
			}else{
					for (CellIndexResultTotal cellIndexResultTotal : listCellIndexResultTotals) {
						System.out.println("基站下的小区:----"+cellIndexResultTotal);
					}
					List<LogCXDomain> listLcd=new ArrayList<>();
					//获得当前基站下的小区的ci
					for (CellIndexResultTotal cellIndexResultTotal : listCellIndexResultTotals) {
							System.out.println("日志里面的小区中文名："+cellIndexResultTotal.getCommunityName());
							System.out.println("长度"+cellIndexResultTotal.getCi());
							listLcd.add(new LogCXDomain(cellIndexResultTotal.getTestDate(),cellIndexResultTotal.getStation_No(),
							cellIndexResultTotal.getCi()));
					}
					for (LogCXDomain lcd : listLcd) {
						TemporayWorkparamDomain2 temp = logService.queryByStationNo(lcd);
						if(temp!=null){
							//根据基站编号和ci查询对应的小区工参
							temporayWorkparamDomainList.add(temp);
						}else{
							json.setCode(-1);
							json.setMsg("工参数据为空，单验报告生成失败!");
							return json;
						}
					}
					
					LogUser logUser=new LogUser();
					if(listCellIndexResultTotals==null||temporayWorkparamDomainList==null){
						json.setCode(-1);
						json.setMsg("单验报告生成失败!");
						return json;
					}else{
						int result = LogUtil.createSingle_CCDL(request, response,logCXDomain,listCellIndexResultTotals,temporayWorkparamDomainList,temporaryTestplan);
						if(result == -1) {
							return json;
						}
						//封装状态
						json.setCode(1);
						json.setMsg("报告生成成功");
						return json;
					}
			}
		}
	}

	/**
	 * CSV
	 */
	@RequestMapping(path = "/createSingle4")
	@ResponseBody
	public ResponsePacket createSingle_CS(LogDomain logDomain, HttpServletResponse response) {

		ResponsePacket json = new ResponsePacket(-1, "单验报告生成失败！");
		List<LogDomain> list = logService.queryLog(logDomain);
		List<Object> head = CSVUtils.getHead();
		List<List<Object>> dataList = CSVUtils.getDataList(list);
		String outPutPath = "D:\\CSV";
		String filename = "测试报告";
		// 生成单验报告
		File result = CSVUtils.createCSVFile(head, dataList, outPutPath, filename);
		if (result == null) {
			return json;
		}

		// 封装状态
		json.setCode(1);
		json.setMsg("单验报告生成成功！");
		return json;
	}

	// 前端页面勾选指标，返回所有指标对应的方法，放入map集合中
	@RequestMapping(path = "/autoCreateReport", method = RequestMethod.GET)
	@ResponseBody
	public ResponsePacket2 autoCreateReport() throws IOException {
		HttpSession session = request.getSession();

		// 获取前端传入的指标名字组合成的字符串
		String parameter = request.getParameter("paramS");

		// 定义一个map键是指标加上域范围对应的方法序号，值是查到的数据集合
		Map<String, List<LonLat>> mapinfo = new HashMap<String, List<LonLat>>();

		// 根据逗号将指标组成的字符串填入数组中
		String[] param = null;
		param = parameter.split(",");

		session.setAttribute("param", param);

		ResponsePacket2 json = new ResponsePacket2();

		// 循环指标数组，找到对应的指标时，调用相应的方法
		for (int i = 0; i < param.length; i++) {
			System.out.println("param[i]:" + param[i].toString());
			String RSRP = "rt_log_RSRP";
			String rsrp = "rsrp";
			String SINR = "rt_log_SINR";
			String sinr = "sinr";
			String PCI = "rt_cell_PCI";
			String pci = "pci";
			if ("RSRP".equalsIgnoreCase(param[i]) == true) {
				List<LonLat> queryRSRPXY1 = roadTestController.queryRSRPXY1(RSRP, 1);
				List<LonLat> queryRSRPXY2 = roadTestController.queryRSRPXY2(RSRP, 1);
				List<LonLat> queryRSRPXY3 = roadTestController.queryRSRPX3(RSRP, 1);
				List<LonLat> queryRSRPXY4 = roadTestController.queryRSRPX4(RSRP, 1);
				for (int j = 1; j < 20; j++) {
					j = 1;
					mapinfo.put(rsrp + j, queryRSRPXY1);
					j++;
					mapinfo.put(rsrp + j, queryRSRPXY2);
					j++;
					mapinfo.put(rsrp + j, queryRSRPXY3);
					j++;
					mapinfo.put(rsrp + j, queryRSRPXY4);
					break;
				}
			}
			if ("SINR".equalsIgnoreCase(param[i]) == true) {
				List<LonLat> querySINRXY1 = roadTestController.querySINRXY1(SINR, 1);
				List<LonLat> querySINRXY2 = roadTestController.querySINRXY2(SINR, 1);
				List<LonLat> querySINRXY3 = roadTestController.querySINRXY3(SINR, 1);
				List<LonLat> querySINRXY4 = roadTestController.querySINRXY4(SINR, 1);
				for (int j = 1; j < 20; j++) {
					j = 1;
					mapinfo.put(sinr + j, querySINRXY1);
					j++;
					mapinfo.put(sinr + j, querySINRXY2);
					j++;
					mapinfo.put(sinr + j, querySINRXY3);
					j++;
					mapinfo.put(sinr + j, querySINRXY4);
					break;
				}
			}
			if ("PCI".equalsIgnoreCase(param[i]) == true) {
				List<LonLat> queryPCIXY1 = roadTestController.queryPCIXY1(PCI, 1);
				List<LonLat> queryPCIXY2 = roadTestController.queryPCIXY2(PCI, 1);
				List<LonLat> queryPCIXY3 = roadTestController.queryPCIXY3(PCI, 1);
				List<LonLat> queryPCIXY4 = roadTestController.queryPCIXY4(PCI, 1);
				for (int j = 1; j < 20; j++) {
					j = 1;
					mapinfo.put(pci + j, queryPCIXY1);
					j++;
					mapinfo.put(pci + j, queryPCIXY2);
					j++;
					mapinfo.put(pci + j, queryPCIXY3);
					j++;
					mapinfo.put(pci + j, queryPCIXY4);
					break;
				}
			}

		}
		json.setMapinfo(mapinfo);
		System.out.println("param数组的值:" + param.toString());
		System.out.println("param数组的大小:" + param.length);

		response.addHeader("Access-Control-Allow-Origin", "*");
		System.out.println("json" + json.toString());
		return json;
	}

}
