package com.fh.util;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 获取配置信息的入口
 */
public class ConfigUtils {

	private static String default_config = "/config.properties";

	private static Properties config;

	private static Logger logger = LoggerFactory.getLogger(ConfigUtils.class);

	static{
		reloadConfig();
	}
	
	private ConfigUtils() {
	}

	public static void reloadConfig() {
		config = new Properties();
		try {
			InputStream is = ConfigUtils.class.getResourceAsStream(default_config);
			config.load(is);
			logger.info("Reload config "+default_config);
		} catch (Exception e) {
			logger.error("初始化配置失败",e);
		}
	}
	/**
	 * 获取属性值
	 * 
	 * @param 属性键值
	 * @return 属性值, 未找到则返回null
	 */
	public static String getProperty(String key) {
		if(config==null){
			return null;
		}
		String value = config.getProperty(key);
		return value == null ? value : value.trim();
	}

	/**
	 * 设置属性值
	 * 
	 * @param 属性键值
	 * @return 
	 */
	public static Boolean updateProperty(String key,String value) {
		config = new Properties();
		try {
			URL resourceurl = ConfigUtils.class.getResource(default_config);
			InputStream is = ConfigUtils.class.getResourceAsStream(default_config);
			config.load(is);
			OutputStream fos = new FileOutputStream(resourceurl.getPath());
			config.setProperty(key, value);
			config.store(fos, "Store key->"+key+" property->"+value);
			return true;
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("初始化配置失败：" + e.getCause());
			}
			return false;
		}
	}
}
