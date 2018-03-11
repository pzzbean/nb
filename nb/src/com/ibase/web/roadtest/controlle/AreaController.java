package com.ibase.web.roadtest.controlle;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibase.core.http.ResponsePacket;
import com.ibase.core.http.ResponsePacket4;
import com.ibase.web.roadtest.domain.TemporayWorkparamDomain2;
import com.ibase.web.roadtest.service.AreaService;

@Controller
@RequestMapping(value = "/area")
public class AreaController {
	@Autowired
	private AreaService areaService;
	@Autowired
	private HttpServletRequest request;
	/**
	 * 查询所有区域
	 * @return
	 */
	@RequestMapping("/queryHomeArea")
	@ResponseBody
	public ResponsePacket queryHomeArea(){
		List<TemporayWorkparamDomain2> list = areaService.queryHomeArea();
		
		ResponsePacket json = new ResponsePacket(list);
		System.out.println(json);
		return json;
	}
	/**
	 * 根据区域查询其所有信息
	 * @param home_area
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/queryAllByHa")
	@ResponseBody
	public ResponsePacket queryAllByHa(String homeArea) throws Exception{
		String homeArea1=new String((request.getParameter("homeArea")).getBytes("iso-8859-1"),"utf-8");
		//if判断   如果区域=全部 则查询出所有区域
		if(homeArea1.equals("全部")){
			List<TemporayWorkparamDomain2> list = areaService.queryHomeArea();
			ResponsePacket json = new ResponsePacket(list);
			System.out.println(json);
			return json;
		}else{
			List<TemporayWorkparamDomain2> list = areaService.queryAllByHa(homeArea1);
			ResponsePacket json = new ResponsePacket(list);
			System.out.println(json);
			return json;
		}
	}
	/**
	 * 根据基站号查询其对应信息
	 * @param stationNo
	 * @return
	 */
	@RequestMapping("/queryByStationNo")
	@ResponseBody
	public ResponsePacket queryByStationNo(String stationNo){
		List<TemporayWorkparamDomain2> list = areaService.queryByStationNo(stationNo);
		ResponsePacket json = new ResponsePacket(list);
		System.out.println(json);
		return json;
	}
	/**
	 * 根据基站号查询对应的基站和小区
	 * @param stationNo
	 * @return
	 */
	@RequestMapping("/selectStationAndCellBySN")
	@ResponseBody
	public ResponsePacket4 selectStationAndCellBySN(String stationNo){
		List<TemporayWorkparamDomain2> list = areaService.selectStationAndCellBySN(stationNo);
		ResponsePacket4 json = new ResponsePacket4(list);
		System.out.println(json);
		return json;
	}
}
