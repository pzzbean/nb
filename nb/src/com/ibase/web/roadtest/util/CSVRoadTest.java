package com.ibase.web.roadtest.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibase.core.utils.DateUtil;
import com.ibase.web.roadtest.domain.RoadTest;
import com.ibase.web.roadtest.domain.RoadTestFile;
import com.ibase.web.roadtest.service.RoadService;

public class CSVRoadTest {

	public static boolean addRoadTest(FileReader fr, RoadService roadService,Integer rt_count,String rt_name) {
		boolean flag = true;
		if (rt_count==null) {
			rt_count = 1;
		} else {
			rt_count++;
		}
		try {
			
			BufferedReader reader = new BufferedReader(fr);// 文件路径
			String firstLine[] = reader.readLine().split(",");// 第一行信息不用
			String line = null;
			// 字段个数为第一行标题的个数
			int col = firstLine.length;
			int count = 0;
			while ((line = reader.readLine()) != null) {
				RoadTest roadTest = new RoadTest();
				String[] lineDateArr = new String[col];// 定义字段个数长度的字符串
				String item[] = line.split(",");// CSV格式文件为逗号分隔符文件，这里根据逗号切分
					System.out.println(item[0]);
				for (int i = 0; i < item.length; i++) {
					lineDateArr[i] = item[i];
				}
				int index = 0;
				System.out.println(lineDateArr[index]);
				// 把日期格式改为美式并把字符串转化为日期

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yy HH:mm:ss", Locale.ENGLISH);
				Date date = sdf.parse(lineDateArr[index]);
				// 封装数据
				roadTest.setRt_time(DateUtil.formatFullDate(date));
				roadTest.setRt_station_longitude(lineDateArr[++index]);
				roadTest.setRt_station_latitude(lineDateArr[++index]);
				roadTest.setRt_cellId(lineDateArr[++index]);
				roadTest.setRt_cell_PCI(lineDateArr[++index]);
				roadTest.setRt_log_RSRP(lineDateArr[++index]);
				roadTest.setRt_log_SINR(lineDateArr[++index]);
				roadTest.setRt_count(rt_count);
				roadTest.setRt_name(rt_name);
				flag=roadService.insertRoadTest(roadTest);
				
				if (count==0) {
					RoadTestFile roadTestFile = new RoadTestFile();
					roadTestFile.setRtf_name(rt_name);
					roadTestFile.setRtf_time(DateUtil.formatFullDate(date));
					roadService.insertRoadTestFile(roadTestFile);
					count++;
				}
				
			}
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		} finally {
			return flag;
		}
	}
}
