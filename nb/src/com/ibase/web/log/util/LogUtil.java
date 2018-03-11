package com.ibase.web.log.util;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibase.core.utils.ConfigUtil;
import com.ibase.core.utils.StringUtil;
import com.ibase.web.log.domain.LogCXDomain;
import com.ibase.web.log.domain.LogDomain;
import com.ibase.web.log.domain.LogUser;
import com.ibase.web.log.domain.SingleTestReport;
import com.ibase.web.log.service.LogService;
import com.ibase.web.log.util.excel.CCDL_Excel;
import com.ibase.web.log.util.excel.CMCC_Excel;
import com.ibase.web.log.util.excel.CT_Excel;
import com.ibase.web.log.util.excel.QCUQ_Excel;
import com.ibase.web.plane.domain.Plane;
import com.ibase.web.plane.service.PlaneService;
import com.ibase.web.roadtest.domain.CellIndexResultTotal;
import com.ibase.web.roadtest.domain.TemporayWorkparamDomain2;
import com.ibase.web.testplan.domain.TemporaryTestplan;
import com.ibase.web.workparam.domain.WorkParamDomain;
import com.ibase.web.workparam.service.WorkParamService;
import com.ibase.web.workparam_in.domain.WorkParam_inDomain;
import com.ibase.web.workparam_in.service.WorkParam_inService;
/**
 *移动 联通 电信 单验Util
 */
public class LogUtil {
	public static String isStandard(LogDomain log){
		StringBuffer sb = new StringBuffer();
		String regex = ConfigUtil.getValue("logRegex");
		double log_RSRP = Double.parseDouble(ConfigUtil.getValue("log_RSRP").replaceAll(regex, ""));
		double log_SINR = Double.parseDouble(ConfigUtil.getValue("log_SINR").replaceAll(regex, ""));
		double log_top_rate = Double.parseDouble(ConfigUtil.getValue("log_top_rate").replaceAll(regex, ""));
		double log_down_rate = Double.parseDouble(ConfigUtil.getValue("log_down_rate").replaceAll(regex, ""));
		double log_delayTime = Double.parseDouble(ConfigUtil.getValue("log_delayTime").replaceAll(regex, ""));
		double log_openRate = Double.parseDouble(ConfigUtil.getValue("log_openRate").replaceAll(regex, ""));
		double log_ReselectDelay = Double.parseDouble(ConfigUtil.getValue("log_ReselectDelay").replaceAll(regex,""));
		double log_AttachDelay = Double.parseDouble(ConfigUtil.getValue("log_AttachDelay").replaceAll(regex,""));
		
		if(Double.parseDouble(log.getLog_RSRP().replaceAll(regex, ""))<log_RSRP){
			sb.append("RSRP不达标，");
		}
		if(Double.parseDouble(log.getLog_SINR().replaceAll(regex, ""))<log_SINR){
			sb.append("SINR不达标，");
		}
		/*if(Double.parseDouble(log.getLog_top_rate().replaceAll(regex, ""))<log_top_rate){
			sb.append("上行速率不达标，");
		}
		if(Double.parseDouble(log.getLog_down_rate().replaceAll(regex, ""))<log_down_rate){
			sb.append("下行速率不达标，");
		}*/
		if(Double.parseDouble(log.getLog_delayTime().replaceAll(regex, ""))>log_delayTime){
			sb.append("ping时延不达标，");
		}
		if(Double.parseDouble(log.getLog_ReselectDelay().replaceAll(regex,""))>log_ReselectDelay){
			sb.append("重传时延不达标，");
		}
		if(Double.parseDouble(log.getLog_AttachDelay().replaceAll(regex,""))>log_AttachDelay){
			sb.append("接通时延不达标，");
		}
		if(Double.parseDouble(log.getLog_openRate().replaceAll(regex, ""))<log_openRate){
			sb.append("接通率不达标，");
		}
		if(sb.toString().equals("")){
			return null;
		}
		return sb.toString().substring(0, sb.toString().length()-1);		
	}
	
	public static String isNull(LogDomain log){
		if(log.getPlane_id()<=0){
			return "plane_id不能为空";
		}
		if(StringUtil.isEmpty(log.getStation_no())){
			return "station_no不能为空";
		}
		if(StringUtil.isEmpty(log.getCell_section())){
			return "cell_section不能为空";
		}
		if(StringUtil.isEmpty(log.getLog_RSRP())){
			return "log_RSRP不能为空";
		}
		if(StringUtil.isEmpty(log.getLog_SINR())){
			return "log_SINR不能为空";
		}
		if(StringUtil.isEmpty(log.getLog_UDPTop_rate())){
			return "log_UDPTop_rate不能为空";
		}
		if(StringUtil.isEmpty(log.getLog_UDPDown_rate())){
			return "log_UDPDown_rate不能为空";
		}
		if(StringUtil.isEmpty(log.getLog_delayTime())){
			return "log_delayTime不能为空";
		}
		if(StringUtil.isEmpty(log.getLog_openRate())){
			return "log_openRate不能为空";
		}
		
		return null;
	}
	
	public static void likePro(LogDomain log){
		if(!StringUtil.isEmpty(log.getStation_no())){
			log.setStation_no("%"+log.getStation_no()+"%");
		}
		if(!StringUtil.isEmpty(log.getCell_section())){
			log.setCell_section("%"+log.getCell_section()+"%");
		}
		if(!StringUtil.isEmpty(log.getLog_RSRP())){
			log.setLog_RSRP("%"+log.getLog_RSRP()+"%");
		}
		if(!StringUtil.isEmpty(log.getLog_SINR())){
			log.setLog_SINR("%"+log.getLog_SINR()+"%");
		}
		if(!StringUtil.isEmpty(log.getLog_UDPTop_rate())){
			log.setLog_UDPTop_rate("%"+log.getLog_UDPTop_rate()+"%");
		}
		if(!StringUtil.isEmpty(log.getLog_UDPDown_rate())){
			log.setLog_UDPDown_rate("%"+log.getLog_UDPDown_rate()+"%");
		}
		if(!StringUtil.isEmpty(log.getLog_delayTime())){
			log.setLog_delayTime("%"+log.getLog_delayTime()+"%");
		}
		if(!StringUtil.isEmpty(log.getLog_openRate())){
			log.setLog_openRate("%"+log.getLog_openRate()+"%");
		}
		if(!StringUtil.isEmpty(log.getLog_desc())){
			log.setLog_desc("%"+log.getLog_desc()+"%");
		}
		if(!StringUtil.isEmpty(log.getLog_create_time())){
			log.setLog_create_time("%"+log.getLog_create_time()+"%");
		}
		if(!StringUtil.isEmpty(log.getLog_ReselectDelay())){
			log.setLog_ReselectDelay("%"+log.getLog_ReselectDelay()+"%");
		}
		if(!StringUtil.isEmpty(log.getLog_AttachDelay())){
			log.setLog_AttachDelay("%"+log.getLog_AttachDelay()+"%");
		}
	}
	
	public static void singleData(Map dataMap,SingleTestReport single){
		
		//查询测试计划
		Plane plane = new Plane();
		plane.setPlane_test_time("%"+single.getPlane_test_time()+"%");
		plane.setUser_id(Long.parseLong(single.getUser_id()));
		List<Plane> planeList = ((PlaneService) dataMap.get("planeService")).queryPlane(plane);
		dataMap.put("plane", planeList.get(0));
		
		//查询工参
		WorkParam_inDomain WorkParam_in = new WorkParam_inDomain();
		System.out.println(WorkParam_in);
		WorkParam_in.setWp_station_no(single.getStation_no());
		List<WorkParam_inDomain> workParam_inList = ((WorkParam_inService)dataMap.get("workParam_inService")).queryWorkParam_in(WorkParam_in);
			//判断在本地工参表（workParam_in）中没有数据，就从运行商工参表（workParam）中查询
		List<WorkParamDomain> workParamList = null;
		if(workParam_inList==null||workParam_inList.size()<3){
			WorkParamDomain WorkParam = new WorkParamDomain();
			WorkParam.setWp_station_no(single.getStation_no());
			workParamList = ((WorkParamService)dataMap.get("workParamService")).queryWorkParam(WorkParam);
		}
		dataMap.put("workParam_inList",workParam_inList);
		dataMap.put("workParamList",workParamList);
		
		//查询日志
		LogDomain log = new LogDomain();
		log.setPlane_id(Long.parseLong(single.getPlane_id()));
		List<LogDomain> logList = ((LogService)dataMap.get("logService")).queryLog(log);
		dataMap.put("logList", logList);
		
	}
	/**
	 * 移动单验报告
	 * @param response 响应
	 * @param dataMap  封装的数据
	 * @param adList 
	 * @param lang 
	 * @return
	 */
	public static int createSingle(HttpServletResponse response,Map dataMap, List<String> adList, String lang){
		System.out.println("asdsadsad");
		String str = lang;
		Map<String ,String> map = null;
		map=I18nUtil.getLangMap(str);
		
		Plane plane = (Plane)dataMap.get("plane");
		List<WorkParam_inDomain> workParam_inList = (List<WorkParam_inDomain>)dataMap.get("workParam_inList");
		List<WorkParamDomain> workParamList = (List<WorkParamDomain>)dataMap.get("workParamList");
		List<LogDomain> logList = (List<LogDomain>)dataMap.get("logList");
		CMCC_Excel cmcc_Excel = new CMCC_Excel();
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			response.reset();
			response.setContentType("application/msexcel;charset=UTF-8");  
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH：mm：ss");
	        //浙江-移动单站验证报告_N940285宁波海曙广博集团NB-IoT
	        response.addHeader("Content-Disposition", "attachment;filename=\""  
                    + new String((map.get("CMCCTitle") +df.format(new Date())+ ".xls").getBytes("utf-8"),  
                            "ISO8859_1") + "\""); 
	       System.out.println("11111111");
	        if(workParam_inList!=null&&workParam_inList.size()>=3){
	        	cmcc_Excel.createExcel2_in(out, plane, workParam_inList, logList,adList,lang, logList);
	        }else{
	        	cmcc_Excel.createExcel2(out,plane, workParamList, logList,adList,lang,logList);
	        }
			
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				return -1;
			}
		}
		return 1;
	}
	/**
	 * 联通单验报告
	 * @param response 响应
	 * @param dataMap  封装的数据
	 * @param lang2 
	 * @return
	 */
	public static int createSingle_CT(HttpServletResponse response,Map dataMap, String lang2){
		String lang =lang2;
		Map<String, String> map = null;
		map=I18nUtil.getLangMap(lang);
		
		Plane plane = (Plane)dataMap.get("plane");
		List<WorkParam_inDomain> workParam_inList = (List<WorkParam_inDomain>)dataMap.get("workParam_inList");
		List<WorkParamDomain> workParamList = (List<WorkParamDomain>)dataMap.get("workParamList");
		List<LogDomain> logList = (List<LogDomain>)dataMap.get("logList");
		CT_Excel ct_Excel = new CT_Excel();
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			response.reset();  
			response.setContentType("application/msexcel;charset=UTF-8");  
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH：mm：ss");
	        response.addHeader("Content-Disposition", "attachment;filename=\""  
                    + new String((map.get("CTTitle") +df.format(new Date())+ ".xls").getBytes("utf-8"),  
                            "ISO8859_1") + "\""); 
	       
	        if(workParam_inList!=null&&workParam_inList.size()>=3){
	        	ct_Excel.createExcel_CT_in(out, plane, workParam_inList, logList,lang);
	        }else{
	        	ct_Excel.createExcel_CT(out, plane, workParamList, logList,lang);
	        }
			
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				return -1;
			}
		}
		return 1;
	}
	/**
	 * 电信单验
	 * @param response 响应
	 * @param dataMap  封装的数据
	 * @param lang 
	 * @return
	 */
	public static int createSingle_QCUQ(HttpServletResponse response,Map dataMap, String lang){
		Map<String,String> map = I18nUtil.getLangMap(lang);		
		Plane plane = (Plane)dataMap.get("plane");
		List<WorkParam_inDomain> workParam_inList = (List<WorkParam_inDomain>)dataMap.get("workParam_inList");
		List<WorkParamDomain> workParamList = (List<WorkParamDomain>)dataMap.get("workParamList");
		List<LogDomain> logList = (List<LogDomain>)dataMap.get("logList");
		System.out.println(logList);
		QCUQ_Excel qcuq_Excel = new QCUQ_Excel();
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			response.reset();  
			response.setContentType("application/msexcel;charset=UTF-8");  
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH：mm：ss");
			response.addHeader("Content-Disposition", "attachment;filename=\""  
					+ new String((map.get("QCUQTitle") +df.format(new Date())+ ".xls").getBytes("utf-8"),  
							"ISO8859_1") + "\""); 
			
			if(workParam_inList!=null&&workParam_inList.size()>=3){
				qcuq_Excel.test_in( out, plane, workParam_inList,logList, workParamList,lang );
			}else{
				qcuq_Excel.test(out, workParamList,  logList,plane, workParam_inList,lang);
			}
			
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				return -1;
			}
		}
		return 1;
	}
	
	/**
	 * 移动报告单
	 * @param args
	 */
	public static int createSingle_CCDL(HttpServletRequest request,HttpServletResponse response,LogCXDomain logCXDomain,List<CellIndexResultTotal> listCellIndexResultTotal,
			List<TemporayWorkparamDomain2> temporayWorkparamDomainList,TemporaryTestplan temporaryTestplan) {//,Map dataMap,LogCXDomain logCXDomain) {
		CCDL_Excel ccdl_Excel = new CCDL_Excel();
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			response.reset();
			response.setContentType("application/msexcel;charset=UTF-8");  
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			if(temporayWorkparamDomainList==null||logCXDomain.getTestDate()==null){
				response.addHeader("Content-Disposition", "attachment;filename=\""  
						+ new String(("NB-IOT单站核查优化测试报告_移动_.xls").getBytes("utf-8"),  
								"ISO8859_1") + "\""); 
			}else{
				response.addHeader("Content-Disposition", "attachment;filename=\""  
						+ new String(("NB-IOT"+temporayWorkparamDomainList.get(0).getStation_name()+"单站核查优化测试报告_移动_" +df.format(df.parse(logCXDomain.getTestDate()))+ ".xls").getBytes("utf-8"),  
								"ISO8859_1") + "\""); 
			}
	        /*if(workParam_inList!=null&&workParam_inList.size()>=3){
	        	ccdl_Excel.createExcel_CCDL_in(out, plane, workParam_inList, logList,adList,lang,listCellIndexResultTotal );//, logListcellIndex,cellParameter);
	        }else{
				ccdl_Excel.createExcel_CCDL(out,plane, workParamList, logList,adList,lang,logList);//cellIndex,cellParameter);
	        }*/
			ccdl_Excel.createExcel_CCDL_in(out,logCXDomain,listCellIndexResultTotal,temporayWorkparamDomainList, temporaryTestplan);// ,listCellIndexResultTotal, logListcellIndex,cellParameter);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				return -1;
			}
		}
		return 1;
	}
	
	
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("log_openRate不达标，log_openRate不达标，");
		System.out.println(String.valueOf(0));
	}

/*public static void logcddomain(Map dataMap, LogCXDomain logCXDomain) {
		//根据station_No和testDate查询出实体类CellIndexResultTotal中的数据  3条
		CellIndexResultTotal cellIndexResultTotal = new CellIndexResultTotal();
		cellIndexResultTotal.setStation_No(logCXDomain.getStation_No());
		cellIndexResultTotal.setTestDate(logCXDomain.getTestDate());
		List<CellIndexResultTotal> cellIndexList = ((LogService) dataMap.get("LogService")).queryByUIAndSN(logCXDomain);
		System.out.println(cellIndexList);
		dataMap.put("cellIndexResultTotal", cellIndexList);
		*/
//		//根据station_No和ci查询出实体类TemporayWorkparamDomain2中的数据 1条
//		TemporayWorkparamDomain2 temporayWorkparamDomain2 = new TemporayWorkparamDomain2();
//		temporayWorkparamDomain2.setStation_No(logCXDomain.getStation_No());
//		temporayWorkparamDomain2.setCi(logCXDomain.getCi());
//		
//		TemporayWorkparamDomain2 temList = logService.queryByStationNo(logCXDomain);
//		dataMap.put("temList",temList);
//		
	//}

}
