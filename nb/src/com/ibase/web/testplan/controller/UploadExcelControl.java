package com.ibase.web.testplan.controller;

import java.io.InputStream;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.ResponseBody;  
import org.springframework.web.multipart.MultipartFile;  
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ibase.core.utils.ImportExcelUtil;
import com.ibase.web.testplan.domain.TemporaryTestplan;
import com.ibase.web.testplan.service.TemporaryTestplanService;  
  
  
@Controller  
@RequestMapping("/uploadExcel")    
public class UploadExcelControl {  
	
	@Autowired
	TemporaryTestplanService temporaryTestplanService;
      
      
    /** 
     * 描述：通过 jquery.form.js 插件提供的ajax方式上传文件 
     * 文件为excel表格
     * @param request 
     * @param response 
     * @throws Exception 
     */  
    @ResponseBody  
    @RequestMapping(value="ajaxUpload",method={RequestMethod.GET,RequestMethod.POST})  
    public  void  ajaxUploadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {  
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;    
          
        System.out.println("通过 jquery.form.js 提供的ajax方式上传文件！");  
          
        InputStream in =null;  
        List<List<Object>> listob = null;  
        MultipartFile file = multipartRequest.getFile("upfile");  
        if(file.isEmpty()){  
            throw new Exception("文件不存在！");  
        }  
          
        in = file.getInputStream();  
        listob = new ImportExcelUtil().getTestPlanListByExcel(in,file.getOriginalFilename());  
          
        
        //调用temporaryTestplanService中的添加方法将数据保存到数据库中
        TemporaryTestplan temporaryTestplan = new TemporaryTestplan();
        for (int i = 0; i < listob.size(); i++) {  
            List<Object> lo = listob.get(i);  
            temporaryTestplan.setUserId(String.valueOf(lo.get(0))); 
            temporaryTestplan.setTestEngineer(String.valueOf(lo.get(1))); 
            temporaryTestplan.setTestEngineerPhone(String.valueOf(lo.get(2))); 
            temporaryTestplan.setPlanCreator(String.valueOf(lo.get(3))); 
            temporaryTestplan.setPlanCreatorPhone(String.valueOf(lo.get(4))); 
            temporaryTestplan.setPlanCreateTime(String.valueOf(lo.get(5))); 
            temporaryTestplan.setPlanReviser(String.valueOf(lo.get(6))); 
            temporaryTestplan.setPlanReviseTime(String.valueOf(lo.get(7))); 
            temporaryTestplan.setState(String.valueOf(lo.get(8))); 
            temporaryTestplan.setTestStartTime(String.valueOf(lo.get(9))); 
            temporaryTestplan.setTestEndTime(String.valueOf(lo.get(10))); 
            temporaryTestplan.setStationNo(String.valueOf(lo.get(11))); 
        }  
            temporaryTestplanService.insertTemporaryTestPlans(temporaryTestplan);
           
        PrintWriter out = null;  
        response.setCharacterEncoding("utf-8");  //防止ajax接受到的中文信息乱码  
        out = response.getWriter();  
        out.print("文件导入成功！");  
        out.flush();  
        out.close();  
    }  
  
  
}  
