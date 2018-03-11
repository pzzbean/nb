package com.ibase.web.workparam_in.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ibase.core.http.ResponsePacket4;
import com.ibase.web.workparam.domain.WorkParamDomain;
import com.ibase.web.workparam.service.WorkParamService;
import com.ibase.web.workparam_in.domain.WorkParam_inDomain;
import com.ibase.web.workparam_in.service.WorkParam_inService;
import com.ibase.web.workparam_in.util.ExcelWorkParam_in;
import com.ibase.web.workparam_in.util.WorkParam_inUtil;

@Controller
@RequestMapping(value="/workParam_in")
public class WorkParam_inController {
	@Autowired
	private WorkParam_inService workParam_inService;
	
	@Autowired
	private WorkParamService workParamService;
	
	/**
     * 分页的传入的   当前页   字段为page.currentPage
     * 分页穿去的   显示条数  字段为page.pageSize
     */
    @RequestMapping(path = "/listWorkParam_in")
    @ResponseBody
    public ResponsePacket4 listWorkParam_in(WorkParam_inDomain workParam_in){
    	ResponsePacket4 json = new ResponsePacket4(-1,"查询失败！");
    	
    	//添加模糊查询，即加上'%'
    	WorkParam_inUtil.likePro(workParam_in);
    	
    	//查询数据
    	List<WorkParam_inDomain> list = workParam_inService.queryWorkParam_in(workParam_in);
    	
    	//封装
    	json.setCode(1);
    	json.setMsg("查询成功！");
    	json.setListObject(list);
    	json.setPage(workParam_in.getPage());//加入分页信息，如totalRow(总记录数)
    	return json;
    }
    
    @RequestMapping(path = "/oneWorkParam_in")
    @ResponseBody
    public ResponsePacket4 oneWorkParam_in(WorkParam_inDomain workParam_in){
    	ResponsePacket4 json = new ResponsePacket4(-1,"查询失败！");
    	
    	//查询数据
    	WorkParam_inDomain oneWorkParam = workParam_inService.searchOneWorkParam_in(workParam_in);
    	
    	//封装
    	json.setCode(1);
    	json.setMsg("查询成功！");
    	json.setObject(oneWorkParam);
    	return json;
    }
    
    /**
     * 站号和扇区不能让用户修改，防止恶意操作
     */
    @RequestMapping(path = "/updateWorkParam_in")
    @ResponseBody
    public ResponsePacket4 updateWorkParam_in(WorkParam_inDomain workParam_in,String user_id){
    	ResponsePacket4 json = new ResponsePacket4(-1,"修改失败！");
    	
    	//验证（空值验证）
    	if(WorkParam_inUtil.isNull(workParam_in)!=null){
    		json.setMsg(WorkParam_inUtil.isNull(workParam_in));
    		return json;
    	}
    	if(user_id==null||"".equals(user_id.trim())){
    		json.setMsg("user_id不能为空");
    		return json;
    	}
    	
    	//通过wp_station_no（站号）和wp_cell_section（小区）检擦WorkParam_in里是否有对应的记录
    	WorkParam_inDomain workParam_in2 = new WorkParam_inDomain();
    	workParam_in2.setWp_station_no(workParam_in.getWp_station_no());
    	workParam_in2.setWp_cell_section(workParam_in.getWp_cell_section());
    	
    	workParam_in2 = workParam_inService.searchOneWorkParam_in(workParam_in2);//从workParam_in表查询记录
    	
    	//通过wp_station_no（站号）和wp_cell_section（小区）检擦WorkParam_in里是否有对应的记录
    	WorkParamDomain workParam = new WorkParamDomain();
    	workParam.setWp_station_no(workParam_in.getWp_station_no());
    	workParam.setWp_cell_section(workParam_in.getWp_cell_section());
    	
    	workParam = workParamService.searchOneWorkParam(workParam);//从workParam表查询记录

    	int count = WorkParam_inUtil.compareWorkParam(workParam,workParam_in);//是否有不一样的数据
    	
    	//如果workParam_in中有记录则修改，没有则添加
    	if(workParam_in2==null){//添加
    		workParam_in.setStatus(1);
    		if(count>0)workParam_in.setStatus(-1);
    		
    		workParam_in.setWp_modifier(Long.parseLong(user_id));
    		workParam_inService.insertWorkParam_in(workParam_in);
    	}else{//修改    		
        	if(count>0){
        		workParam_in.setStatus(-1);
        		workParam_in.setWp_modifier(Long.parseLong(user_id));
        		workParam_inService.updateWorkparam_in(workParam_in);
        	}
    	}
    	
    	//封装
    	json.setCode(1);
    	json.setMsg("修改成功！");    	
    	return json;
    }

    /**
     * 下载
     */
    @RequestMapping(path = "/createExcelWorkParam_in")
    @ResponseBody
    public ResponsePacket4 createExcelWorkParam_in(WorkParam_inDomain workParam_in,HttpServletResponse response){
    	ResponsePacket4 json = new ResponsePacket4(-1,"下载失败！");
    	
    	//查询单验数据
    	List<WorkParam_inDomain> WorkParam_inList = workParam_inService.queryWorkParam_in(workParam_in);
    	if(WorkParam_inList.size()<=0&&WorkParam_inList==null){
    		json.setMsg("无数据");
    		return json;
    	}
    	
    	//生成工参Excel
    	int result = WorkParam_inUtil.createExcelOfWorkParam_in(response, WorkParam_inList);
    	if(result==-1){
    		return json;
    	}
        
	    //封装
	    json.setCode(1);
	    json.setMsg("生成成功！");
  	    return json;
    }
    
    
}
