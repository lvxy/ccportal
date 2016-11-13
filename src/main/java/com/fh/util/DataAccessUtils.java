package com.fh.util;

import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fh.ws.WsConfigService;
import com.fh.ws.WsOperationService;
import com.fh.ws.WsOtherService;
import com.fh.ws.WsStatusService;

//定义接口更灵活
public class DataAccessUtils {
	private static final Logger logger = LoggerFactory.getLogger(DataAccessUtils.class);
	
	private static String token=null;
	static{
		token=ConfigUtils.getProperty("token");
		token=token==null?"":token;
	}
	
	/**
	 * 获取状态信息
	 * @param scope
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Map<String, Object>> findAllStatusData(String json){
		logger.info("chenhb-log-findAllStatusData:"+json);
		try {
			@SuppressWarnings("rawtypes")
			Map jsonMap = GsonUtils.fromJson(json, Map.class);
			jsonMap.put("token", token);
			json=GsonUtils.toJson(jsonMap);
			
			WsStatusService statusWsClient=SpringContextHolder.getBean("statusWsClient");
			String accountsJson = statusWsClient.findAll(json);
			CallResult callResult=GsonUtils.fromJson(accountsJson, CallResult.class);
			if(!callResult.isNormalReturn()){
				return new ArrayList<Map<String,Object>>();
			}
			return (ArrayList<Map<String,Object>>)callResult.getResult();
		} catch (Exception e) {
			logger.error("chenhb: DataAccess findMulti failed",e);
			return new ArrayList<Map<String,Object>>();
		}
	}
	
	/**
	 * 获取呼叫状态信息
	 * @param scope
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Map<String, Object>> findAllCallStatusData(String json){
		logger.info("chenhb-log-findAllStatusData:"+json);
		try {
			@SuppressWarnings("rawtypes")
			Map jsonMap = GsonUtils.fromJson(json, Map.class);
			jsonMap.put("token", token);
			json=GsonUtils.toJson(jsonMap);
			
			WsStatusService statusWsClient=SpringContextHolder.getBean("statusWsClient");
			String accountsJson = statusWsClient.findAll(json);
			CallResult callResult=GsonUtils.fromJson(accountsJson, CallResult.class);
			if(!callResult.isNormalReturn()){
				return new ArrayList<Map<String,Object>>();
			}
			return (ArrayList<Map<String,Object>>)callResult.getResult();
		} catch (Exception e) {
			logger.error("chenhb: DataAccess findMulti failed",e);
			return new ArrayList<Map<String,Object>>();
		}
	}
	
	
	/**
	 * 获取配置信息
	 * @param scope
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Map<String, Object>> findAllConfigData(String json){
		logger.info("chenhb-log-findAllConfigData:"+json);
		try {
			@SuppressWarnings("rawtypes")
			Map jsonMap = GsonUtils.fromJson(json, Map.class);
			jsonMap.put("token", token);
			json=GsonUtils.toJson(jsonMap);
			
			WsConfigService configWsClient=SpringContextHolder.getBean("configWsClient");
			String accountsJson = configWsClient.findAll(json);
			CallResult callResult=GsonUtils.fromJson(accountsJson, CallResult.class);
			if(!callResult.isNormalReturn()){
				return new ArrayList<Map<String,Object>>();
			}
			return (ArrayList<Map<String,Object>>)callResult.getResult();
		} catch (Exception e) {
			logger.error("chenhb: DataAccess findAll failed",e);
			return new ArrayList<Map<String,Object>>();
		}
	}

	/**
	 * 添加配置信息
	 * @param scope
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static CallResult addConfigData(String json){
		logger.info("chenhb-log-addConfigData:"+json);
		try {
			@SuppressWarnings("rawtypes")
			Map jsonMap = GsonUtils.fromJson(json, Map.class);
			jsonMap.put("token", token);
			json=GsonUtils.toJson(jsonMap);
			
			WsConfigService configWsClient=SpringContextHolder.getBean("configWsClient");
			String accountsJson = configWsClient.add(json);
			CallResult callResult=GsonUtils.fromJson(accountsJson, CallResult.class);
			return callResult;
		} catch (Exception e) {
			logger.error("chenhb: DataAccess add failed",e);
			CallResult callResult=new CallResult();
			callResult.setErrmsg(e.getMessage());
			callResult.setCode(CallResult.UNEXPECTED_ERROR);
			return callResult;
		}
	}

	/**
	 * 删除配置信息
	 * @param scope
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static CallResult deleteConfigData(String json){
		logger.info("chenhb-log-deleteConfigData:"+json);
		try {
			@SuppressWarnings("rawtypes")
			Map jsonMap = GsonUtils.fromJson(json, Map.class);
			jsonMap.put("token", token);
			json=GsonUtils.toJson(jsonMap);
			
			WsConfigService configWsClient=SpringContextHolder.getBean("configWsClient");
			String accountsJson = configWsClient.delete(json);
			CallResult callResult=GsonUtils.fromJson(accountsJson, CallResult.class);
			return callResult;
		} catch (Exception e) {
			logger.error("chenhb: DataAccess delete failed",e);
			CallResult callResult=new CallResult();
			callResult.setErrmsg(e.getMessage());
			callResult.setCode(CallResult.UNEXPECTED_ERROR);
			return callResult;
		}
	}
	
	/**
	 * 更新配置信息
	 * @param scope
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static CallResult updateConfigData(String json){
		logger.info("chenhb-log-updateConfigData:"+json);
		try {
			@SuppressWarnings("rawtypes")
			Map jsonMap = GsonUtils.fromJson(json, Map.class);
			jsonMap.put("token", token);
			json=GsonUtils.toJson(jsonMap);
			
			WsConfigService configWsClient=SpringContextHolder.getBean("configWsClient");
			String resultJson = configWsClient.update(json);
			CallResult callResult=GsonUtils.fromJson(resultJson, CallResult.class);
			return callResult;
		} catch (Exception e) {
			logger.error("chenhb: DataAccess update failed",e);
			CallResult callResult=new CallResult();
			callResult.setErrmsg(e.getMessage());
			callResult.setCode(CallResult.UNEXPECTED_ERROR);
			return callResult;
		}
	}
	
	/**
	 * 查找配置信息
	 * @param scope
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static CallResult findConfigData(String json){
		logger.info("chenhb-log-findConfigData:"+json);
		try {
			@SuppressWarnings("rawtypes")
			Map jsonMap = GsonUtils.fromJson(json, Map.class);
			jsonMap.put("token", token);
			json=GsonUtils.toJson(jsonMap);
			
			WsConfigService configWsClient=SpringContextHolder.getBean("configWsClient");
			String resultJson = configWsClient.find(json);
			CallResult callResult=GsonUtils.fromJson(resultJson, CallResult.class);
			return callResult;
		} catch (Exception e) {
			logger.error("chenhb: DataAccess update failed",e);
			CallResult callResult=new CallResult();
			callResult.setErrmsg(e.getMessage());
			callResult.setCode(CallResult.UNEXPECTED_ERROR);
			return callResult;
		}
	}

	/**
	 * 执行命令
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static CallResult executeCommand(String json){
		logger.info("chenhb-log-executeCommand:"+json);
		try {
			@SuppressWarnings("rawtypes")
			Map jsonMap = GsonUtils.fromJson(json, Map.class);
			jsonMap.put("token", token);
			json=GsonUtils.toJson(jsonMap);
			
			WsOperationService operationWsClient=SpringContextHolder.getBean("operationWsClient");
			String resultJson = operationWsClient.execute(json);
			CallResult callResult=GsonUtils.fromJson(resultJson, CallResult.class);
			return callResult;
		} catch (Exception e) {
			logger.error("chenhb: Execute command failed",e);
			CallResult callResult=new CallResult();
			callResult.setErrmsg(e.getMessage());
			callResult.setCode(CallResult.UNEXPECTED_ERROR);
			return callResult;
		}
	}
	
	/**
	 * 配置Other信息
	 * @param scope
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static CallResult otherRefresh(String json){
		logger.info("chenhb-log-otherRefresh:"+json);
		try {
			@SuppressWarnings("rawtypes")
			Map jsonMap = GsonUtils.fromJson(json, Map.class);
			jsonMap.put("token", token);
			json=GsonUtils.toJson(jsonMap);
			
			WsOtherService otherWsClient=SpringContextHolder.getBean("otherWsClient");
			String resultJson = otherWsClient.refresh(json);
			CallResult callResult=GsonUtils.fromJson(resultJson, CallResult.class);
			return callResult;
		} catch (Exception e) {
			logger.error("chenhb: Other refresh failed",e);
			CallResult callResult=new CallResult();
			callResult.setErrmsg(e.getMessage());
			callResult.setCode(CallResult.UNEXPECTED_ERROR);
			return callResult;
		}
	}
	
	/**
	 * 获取配置信息数量
	 * @param scope
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Integer count(String json){
		logger.info("chenhb-log-findCountConfigData:"+json);
		try {
			@SuppressWarnings("rawtypes")
			Map jsonMap = GsonUtils.fromJson(json, Map.class);
			jsonMap.put("token", token);
			json=GsonUtils.toJson(jsonMap);
			
			WsConfigService configWsClient=SpringContextHolder.getBean("configWsClient");
			String accountsJson = configWsClient.count(json);
			CallResult callResult=GsonUtils.fromJson(accountsJson, CallResult.class);
			if(!callResult.isNormalReturn()){
				return 0;
			}
			return  ((Double) callResult.getResult()).intValue();
		} catch (Exception e) {
			logger.error("chenhb: DataAccess findCount failed",e);
			return 0;
		}
	}

	/**
	 * 获取分页数据
	 * @param scope
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Map<String, Object>> page(String json){
		logger.info("chenhb-log-findPageConfigData:"+json);
		try {
			@SuppressWarnings("rawtypes")
			Map jsonMap = GsonUtils.fromJson(json, Map.class);
			jsonMap.put("token", token);
			json=GsonUtils.toJson(jsonMap);
			
			WsConfigService configWsClient=SpringContextHolder.getBean("configWsClient");
			String accountsJson = configWsClient.page(json);
			CallResult callResult=GsonUtils.fromJson(accountsJson, CallResult.class);
			if(!callResult.isNormalReturn()){
				return new ArrayList<Map<String,Object>>();
			}
			return  (ArrayList<Map<String, Object>>) callResult.getResult();
		} catch (Exception e) {
			logger.error("chenhb: DataAccess findPage failed" + e.getMessage(), e);
			return new ArrayList<Map<String,Object>>();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Map<String, Object>> findIvr(String json) {
		logger.info("chenhb-log-findPageConfigData:"+json);
		try {
			@SuppressWarnings("rawtypes")
			Map jsonMap = GsonUtils.fromJson(json, Map.class);
			jsonMap.put("token", token);
			json=GsonUtils.toJson(jsonMap);
			
			WsConfigService configWsClient=SpringContextHolder.getBean("configWsClient");
			String accountsJson = configWsClient.findIvr(json);
			CallResult callResult=GsonUtils.fromJson(accountsJson, CallResult.class);
			if(!callResult.isNormalReturn()){
				return new ArrayList<Map<String,Object>>();
			}
			return  (ArrayList<Map<String, Object>>) callResult.getResult();
		} catch (Exception e) {
			logger.error("chenhb: DataAccess findPage failed" + e.getMessage(), e);
			return new ArrayList<Map<String,Object>>();
		}
	}

}
