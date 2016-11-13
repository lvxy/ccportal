package com.fh.util;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

public class GsonUtils { 
	private static Logger logger = LoggerFactory.getLogger(GsonUtils.class);
	
	private static Gson gson;
	static{
		JsonSerializer<Date> dateSerializer = new JsonSerializer<Date>() {
			@Override
			public JsonElement serialize(Date src, java.lang.reflect.Type typeOfSrc,
					JsonSerializationContext context) {
				return src == null ? null : new JsonPrimitive(src.getTime());
			}
		};
		
		gson= new GsonBuilder().serializeNulls().setDateFormat(DateFormat.FULL, DateFormat.FULL).registerTypeAdapter(Date.class, dateSerializer).create();
		logger.info("chenhb: Gson serializeNulls DateFormat.FULL");
	}
	
	/**
	 * 转换成单引号的json字符串
	 * @return
	 */
	public static String toSingleQuoteJson(Object object){
		if(object==null){
			return null;
		}
		
		String result=gson.toJson(object);
		result=result.replaceAll("\"", "'");
		return result;
	}
	
	/**
	 * 转换成json字符串
	 * @return
	 */
	public static String toJson(Object object){
		if(object==null){
			return null;
		}
		
		String result=gson.toJson(object);
		return result;
	}

	/**
	 * 从json转换为对象
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> classOfT){
		if(StringUtils.isBlank(json)||classOfT==null){
			return null;
		}
		
		return gson.fromJson(json, classOfT);
	}

	/**
	 * 从json转换为复杂对象
	 * 此处仅仅为一个示例
	 * @return
	 */
	public static List<Date> fromJsonToDateList(String json){
		if(StringUtils.isBlank(json)){
			return null;
		}
		
		//GsonUtil.getGson().fromJson(json,new TypeToken<List<Date>>(){}.getType());
		List<Date> dateList=gson.fromJson(json,new TypeToken<List<Date>>(){}.getType());
		return dateList;
	}
	
	/**
	 * 取得gson对象
	 * @return
	 */
	public static Gson getGson() {
		return gson;
	}
	
}
