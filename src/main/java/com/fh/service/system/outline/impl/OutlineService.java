package com.fh.service.system.outline.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.CallResult;
import com.fh.util.DataAccessUtils;
import com.fh.util.GsonUtils;
import com.fh.util.PageData;
import com.fh.service.system.outline.OutlineManager;

/** 
 * 说明： 外线配置
 * 
 * 创建时间：2016-11-13
 * @version
 */
@Service("outlineService")
public class OutlineService implements OutlineManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public CallResult save(PageData pd)throws Exception{
		//设置参数
		Map<String,Object> row=new HashMap<String, Object>();
		Map<String,String> bizdata=new HashMap<String, String>();
		
		row.put("scope", "gateway");
		row.put("_bizdata", bizdata);
		row.put("userName",pd.get("USERNAME"));
		row.put("realm",pd.get("REALM"));
		row.put("password",pd.get("PASSWORD"));
		row.put("register",pd.get("REGISTER"));
		row.put("type",pd.get("TYPE"));
		row.put("port",pd.get("PORT"));
		// BizdataField
		bizdata.put("timeout",(String) pd.get("TIMEOUT"));
		bizdata.put("incoming_type",(String) pd.get("INCOMING_TYPE"));
		bizdata.put("incoming_exten",(String) pd.get("INCOMING_EXTEN"));
		bizdata.put("incoming_callcenter",(String) pd.get("INCOMING_CALLCENTER"));
		bizdata.put("incoming_ivr",(String) pd.get("INCOMING_IVR"));
		bizdata.put("effective_caller_id_name",(String) pd.get("EFFECTIVE_CALLER_ID_NAME"));
		bizdata.put("force_effective_caller_id_name",(String) pd.get("FORCE_EFFECTIVE_CALLER_ID_NAME"));
		bizdata.put("type_blacklist",(String) pd.get("TYPE_BLACKLIST"));
		
		CallResult return_result=DataAccessUtils.addConfigData(GsonUtils.toJson(row));	
		return return_result;
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		//设置参数
		Map<String,Object> row=new HashMap<String, Object>();
		Map<String,String> bizdata=new HashMap<String, String>();
		row.put("scope", "gateway");
		row.put("userName", pd.get("OUTLINE_NAME"));
		
		CallResult	callAddResult=DataAccessUtils.deleteConfigData(GsonUtils.toJson(row));
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		String pre_username=pd.getString("PRE_OUTLINE_NAME");
		//设置参数
		Map<String,Object> row=new HashMap<String, Object>();
		Map<String,String> bizdata=new HashMap<String, String>();
		
		row.put("scope", "gateway");
		row.put("_bizdata", bizdata);
		row.put("userName",pd.get("USERNAME"));
		row.put("realm",pd.get("REALM"));
		row.put("password",pd.get("PASSWORD"));
		row.put("register",pd.get("REGISTER"));
		row.put("type",pd.get("TYPE"));
		row.put("port",pd.get("PORT"));
		// BizdataField
		bizdata.put("timeout",(String) pd.get("TIMEOUT"));
		bizdata.put("incoming_type",(String) pd.get("INCOMING_TYPE"));
		bizdata.put("incoming_exten",(String) pd.get("INCOMING_EXTEN"));
		bizdata.put("incoming_callcenter",(String) pd.get("INCOMING_CALLCENTER"));
		bizdata.put("incoming_ivr",(String) pd.get("INCOMING_IVR"));
		bizdata.put("effective_caller_id_name",(String) pd.get("EFFECTIVE_CALLER_ID_NAME"));
		bizdata.put("force_effective_caller_id_name",(String) pd.get("FORCE_EFFECTIVE_CALLER_ID_NAME"));
		bizdata.put("type_blacklist",(String) pd.get("TYPE_BLACKLIST"));
				
		if(pre_username.equals(pd.getString("USERNAME"))){
			CallResult return_result=DataAccessUtils.updateConfigData(GsonUtils.toJson(row));	
		}else{
			row.put("userName", pre_username);
			CallResult	callDelResult=DataAccessUtils.deleteConfigData(GsonUtils.toJson(row));
			row.put("userName", pd.get("USERNAME"));
			CallResult	callAddResult=DataAccessUtils.addConfigData(GsonUtils.toJson(row));
			
		}
		
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page,PageData pd)throws Exception{
		List varList=new ArrayList();
		int  countExten=DataAccessUtils.count("{'scope':'gateway'}");
//		PageData pd =page.getPd();
		page.setTotalResult(countExten); 
		// 当前页：
		int currentPage = pd.get("page.currentPage") == null ? page.getCurrentPage() : Integer.valueOf((String) pd.get("page.currentPage"));
		// 每页数量
		int pageSize = pd.get("page.showCount") == null ? page.getShowCount() : Integer.valueOf((String) pd.get("page.showCount"));	
		//拼接查询条件
		Map<String,Object> row=new HashMap<String, Object>();
		
		row.put("scope", "gateway");
		row.put("page", String.valueOf(currentPage));
		row.put("pageSize", String.valueOf(pageSize));
		row.put("userName", pd.getString("keywords"));
		
		List<Map<String, Object>> dataList=DataAccessUtils.findAllConfigData(GsonUtils.toJson(row));
		page.setCurrentPage(currentPage);
		page.setShowCount(pageSize);
		page.getTotalPage();
		
		for(Map dd :dataList){
			Map filldata=new HashMap();
			filldata.put("USERNAME", dd.get("userName"));
			filldata.put("REALM", dd.get("realm"));
			filldata.put("PASSWORD", dd.get("password"));
			filldata.put("REGISTER", dd.get("register"));
			filldata.put("TYPE", dd.get("type"));
			filldata.put("PORT", dd.get("port"));
			Map<String,String> bizData=(Map<String, String>) dd.get("_bizdata");
			filldata.put("TIMEOUT", bizData.get("timeout"));
			filldata.put("INCOMING_TYPE", bizData.get("incoming_type"));
			filldata.put("INCOMING_IVR", bizData.get("incoming_ivr"));
			filldata.put("INCOMING_EXTEN", bizData.get("incoming_exten"));
			filldata.put("INCOMING_CALLCENTER", bizData.get("incoming_callcenter"));
			filldata.put("EFFECTIVE_CALLER_ID_NAME", bizData.get("effective_caller_id_name"));
			filldata.put("FORCE_EFFECTIVE_CALLER_ID_NAME", bizData.get("force_effective_caller_id_name"));
			filldata.put("TYPE_BLACKLIST", bizData.get("type_blacklist"));
			varList.add(filldata);
		}
		return varList;
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("OutlineMapper.listAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("OutlineMapper.findById", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findByUsername(PageData pd)throws Exception{
		//拼接查询条件
		Map<String,Object> row=new HashMap<String, Object>();
		
		row.put("scope", "gateway");
		row.put("userName", pd.getString("OUTLINE_USERNAME"));
		
		CallResult call_result=DataAccessUtils.findConfigData(GsonUtils.toJson(row));
		Map<String, Object> result_map=new HashMap<String,Object >();
		result_map=(Map<String, Object>) call_result.getResult();
		
		pd.put("USERNAME", result_map.get("userName"));
		pd.put("REALM", result_map.get("realm"));
		pd.put("PASSWORD", result_map.get("password"));
		pd.put("REGISTER", result_map.get("register"));
		pd.put("TYPE", result_map.get("type"));
		pd.put("PORT", result_map.get("port"));
		Map<String,String> bizData=(Map<String, String>) result_map.get("_bizdata");
		pd.put("TIMEOUT", bizData.get("timeout"));
		pd.put("INCOMING_TYPE", bizData.get("incoming_type"));
		pd.put("INCOMING_IVR", bizData.get("incoming_ivr"));
		pd.put("INCOMING_EXTEN", bizData.get("incoming_exten"));
		pd.put("INCOMING_CALLCENTER", bizData.get("incoming_callcenter"));
		pd.put("EFFECTIVE_CALLER_ID_NAME", bizData.get("effective_caller_id_name"));
		pd.put("FORCE_EFFECTIVE_CALLER_ID_NAME", bizData.get("force_effective_caller_id_name"));
		pd.put("TYPE_BLACKLIST", bizData.get("type_blacklist"));
		return pd;
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("OutlineMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

