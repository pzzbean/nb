package com.ibase.web.roadtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibase.web.roadtest.domain.SaveLogFile;
import com.ibase.web.roadtest.mapper.AreaMapper;
import com.ibase.web.roadtest.mapper.FileMapper;
import com.ibase.web.roadtest.service.FileService;
@Service
public class fileServiceImpl implements FileService {

	@Autowired
	FileMapper fileMapper;
	
	@Override
	public void insertFiles(SaveLogFile saveLogFile) {
		fileMapper.insertFiles(saveLogFile);
	}

}
