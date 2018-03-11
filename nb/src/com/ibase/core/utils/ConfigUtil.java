package com.ibase.core.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author admin
 *
 */
public class ConfigUtil {

	protected static final Logger logger = LoggerFactory.getLogger(ConfigUtil.class);

	private static Map<String, String> configMap = new HashMap<String, String>();

	static {
		init();
	}

	@SuppressWarnings("unchecked")
	protected static void init() {
		InputStream in = null;
		BufferedReader br = null;

		Document doc = null;
		try {
			StringBuffer buf = new StringBuffer();
			in = ConfigUtil.class.getClassLoader().getResourceAsStream("config.xml");
			br = new BufferedReader(new InputStreamReader(in));

			String line = null;
			while ((line = br.readLine()) != null) {
				buf.append(line);
			}
			doc = DocumentHelper.parseText(buf.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e2) {
				}

			}
			if (in != null) {
				try {
					in.close();
				} catch (Exception e2) {
				}
			}
		}
		Element root = doc.getRootElement();
		List<Element> list = root.elements("item");
		for (Element item : list) {
			configMap.put(item.attributeValue("name"),	item.attributeValue("value"));
		}
	}

	/**
	 * 根据item名称获取值
	 * @param name
	 * @return
	 */
	public static String getValue(String name) {
		return configMap.get(name);
	}
	public static void main(String[] args) {
		System.out.println(ConfigUtil.getValue("xcx_AppSecret"));
	}
}
