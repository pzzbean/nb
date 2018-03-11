package com.ibase.web.log.util;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.ibase.web.log.domain.LogDomain;

/**
 * 
 * CSV文件导出工具类
 * 
 * Created on 2014-08-07
 * 
 * @author
 * @reviewer
 */
public class CSVUtils {

	/**
	 * CSV文件生成方法
	 * 
	 * @param head
	 * @param dataList
	 * @param outPutPath
	 * @param filename
	 * @return
	 */
	public static File createCSVFile(List<Object> head, List<List<Object>> dataList, String outPutPath,
			String filename) {

		File csvFile = null;
		BufferedWriter csvWtriter = null;
		try {
			csvFile = new File(outPutPath + File.separator + filename + ".csv");
			File parent = csvFile.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			csvFile.createNewFile();

			// GB2312使正确读取分隔符","
			csvWtriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "GB2312"), 1024);
			// 写入文件头部
			writeRow(head, csvWtriter);
			// 写入文件内容
			for (List<Object> row : dataList) {
				writeRow(row, csvWtriter);
			}
			csvWtriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				csvWtriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return csvFile;
	}

	/**
	 * 写一行数据方法
	 * 
	 * @param row
	 * @param csvWriter
	 * @throws IOException
	 */
	private static void writeRow(List<Object> row, BufferedWriter csvWriter) throws IOException {
		// 写入文件头部
		for (Object data : row) {
			StringBuffer sb = new StringBuffer();
			String rowStr = sb.append("\"").append(data).append("\",").toString();
			csvWriter.write(rowStr);
		}
		csvWriter.newLine();
	}

	/**
	 * 
	 * @param 数据list
	 * @return
	 */
	public static List<List<Object>> getDataList(List<LogDomain> list) {

		List<List<Object>> datalist = new ArrayList<>();
		for (LogDomain logDomain : list) {
			List<Object> listObj = new ArrayList<>();
			listObj.add(logDomain.getCell_section());
			listObj.add(logDomain.getLog_RSRP());
			listObj.add(logDomain.getLog_SINR());
			listObj.add(logDomain.getLog_iperfTop_rate());
			listObj.add(logDomain.getLog_iperfDown_rate());
			listObj.add(logDomain.getLog_delayTime());
			listObj.add(logDomain.getLog_openRate());
			listObj.add(logDomain.getLog_ReselectDelay());
			listObj.add(logDomain.getLog_AttachDelay());
			datalist.add(listObj);
		}
		return datalist;
	}
	public static List<Object> getHead() {
		List<Object> head = new ArrayList<>();
		head.add("扇区");
		head.add("RSRP");
		head.add("SINR");
		head.add("上行速率");
		head.add("下行速率");
		head.add("ping时延");
		head.add("接通率");
		head.add("重传时延");
		head.add("接通时延");	
		return head;
	}
}
