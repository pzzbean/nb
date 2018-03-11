package com.ibase.web.workparam.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ibase.core.http.ResponsePacket4;
import com.ibase.web.workparam.domain.WorkParamDomain;
import com.ibase.web.workparam.service.WorkParamService;
import com.ibase.web.workparam.util.ExcelWorkParamUtil;
import com.ibase.web.workparam.util.WorkParamUtil;

@Controller
@RequestMapping(value="/workParam")
public class WorkParamController {
	@Autowired
	private WorkParamService workParamService;
	
	/**
     * 分页的传入的   当前页   字段为page.currentPage
     * 分页穿去的   显示条数  字段为page.pageSize
     */
    @RequestMapping(path = "/listWorkParam")
    @ResponseBody
    public ResponsePacket4 listUser(WorkParamDomain workParam){
    	ResponsePacket4 json = new ResponsePacket4(-1,"查询失败！");
    	
    	//添加模糊查询，即加上'%'
    	WorkParamUtil.likePro(workParam);
    	
    	//查询数据
    	List<WorkParamDomain> list = workParamService.queryWorkParam(workParam);
    	
    	//封装
    	json.setCode(1);
    	json.setMsg("查询成功！");
    	json.setListObject(list);
    	json.setPage(workParam.getPage());//加入分页信息，如totalRow(总记录数)
    	return json;
    }
    
    @RequestMapping(path = "/oneWorkParam")
    @ResponseBody
    public ResponsePacket4 oneUser(WorkParamDomain workParam){
    	ResponsePacket4 json = new ResponsePacket4(-1,"查询失败！");
    	
    	//查询数据
    	WorkParamDomain oneWorkParam = workParamService.searchOneWorkParam(workParam);
    	
    	//封装
    	json.setCode(1);
    	json.setMsg("查询成功！");
    	json.setObject(oneWorkParam);
    	return json;
    }
    
    /**
     * 上传并更新
     */
    @RequestMapping(path = "/addWorkParamExcel")
    @ResponseBody
    public ResponsePacket4 addWorkParamExcel(MultipartFile file){
    	//System.out.println("qdd111111");
    	ResponsePacket4 json = new ResponsePacket4(-1,"上传失败！");
    	//System.out.println(file.getOriginalFilename());
    	
    	//删除所有
    	workParamService.deleteWorkparam(new WorkParamDomain());
    	
    	//添加
    	InputStream in = null;
    	try {
    		in = file.getInputStream();
			ExcelWorkParamUtil.addExcelToWorkParam(in, workParamService);
		}catch (Exception e) {
			e.printStackTrace();
			json.setMsg("解析Excel出错！");
			return json;
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				json.setMsg("输入流关闭异常");
				return json;
			}
		}
    	
    	//封装
    	json.setCode(1);
    	json.setMsg("上传成功！");
    	
    	return json;
    }

}
