package com.ibase.web.roadtest.controlle;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ibase.web.roadtest.domain.SaveLogFile;
import com.ibase.web.roadtest.service.FileService;

@Controller
@RequestMapping(value = "/file")
public class FileUploadController {
		@Autowired
		private FileService fileService;
		
	 	@RequestMapping(value="/fileupload" , method = RequestMethod.POST)
	 	@ResponseBody
	    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	        String res = sdf.format(new Date());

	        // upload文件夹位置
	        String rootPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
	        // 原始名称
	        String originalFileName = file.getOriginalFilename();
	        // 新文件名
	       // String newFileName = "sliver" + res + originalFileName.substring(originalFileName.lastIndexOf("."));
	        // 创建年月文件夹
	        Calendar date = Calendar.getInstance();
	        File dateDirs = new File(date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH)+1));

	        // 新文件
	        File newFile = new File(rootPath + File.separator + dateDirs + File.separator + originalFileName);
	        // 判断目标文件所在目录是否存在
	        if( !newFile.getParentFile().exists()) {
	            // 如果目标文件所在的目录不存在，则创建父目录
	            newFile.getParentFile().mkdirs();
	        }
	        System.out.println(newFile);
	        // 将内存中的数据写入磁盘
	        file.transferTo(newFile);
	        // 新文件名
	        String newFileName = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH)+1) + "/" + res + originalFileName;
	        //为了保存上传的文件到数据库中  
	        SaveLogFile saveLogFile = new SaveLogFile();
	        
	        saveLogFile.setLogfileName(newFileName);
	        saveLogFile.setLogfileUrl(rootPath);
	        saveLogFile.setUserId("11");
	        saveLogFile.setPlanId("12");
	        saveLogFile.setTestDate("1111");
	        saveLogFile.setStationNo("60473");
	        
	        fileService.insertFiles(saveLogFile);
	        return  newFileName;
	       
	    }
	}