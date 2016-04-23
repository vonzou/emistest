package net.emis.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtil {
	
	private static Logger log = Logger.getLogger(PropertiesUtil.class);
	
	/**
	 * 读取配置文件
	 * @param key 配置文件键值
	 * @param filePath 文件名（含路径）
	 * @return key对应的value
	 */
	public static String getPropertiesValue(String key, String filePath){
		Properties pps = new Properties();
		String proValue = null;
		try {
			pps.load(new FileInputStream(filePath));
			proValue = pps.getProperty(key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error("not found " + filePath + ", 请确认文件名及路径是否正确");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("IO异常：在" + filePath + "中读取key");
			e.printStackTrace();
		}
		
		return proValue;
	}
}
