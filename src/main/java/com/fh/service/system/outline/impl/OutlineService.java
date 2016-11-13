package com.fh.service.system.outline.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
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
	public void save(PageData pd)throws Exception{
		dao.save("OutlineMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("OutlineMapper.delete", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("OutlineMapper.edit", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		List varList=new ArrayList();
		int  countExten=DataAccessUtils.count("{'scope':'gateway'}");
		page.setTotalResult(countExten);
		PageData pd =page.getPd();
		// 当前页：
		int currentPage = pd.get("page.currentPage") == null ? page.getCurrentPage() : Integer.valueOf((String) pd.get("page.currentPage"));
		// 每页数量
		int pageSize = pd.get("page.showCount") == null ? page.getShowCount() : Integer.valueOf((String) pd.get("page.showCount"));	
		//拼接查询条件
		Map<String,Object> row=new HashMap<String, Object>();
		Map<String,String> bizdata=new HashMap<String, String>();
		
		row.put("scope", "gateway");
		row.put("page", String.valueOf(currentPage));
		row.put("pageSize", String.valueOf(pageSize));
		row.put("userName", pd.getString("keywords"));
		
		List<Map<String, Object>> dataList=DataAccessUtils.findAllConfigData(GsonUtils.toJson(row));
		page.setCurrentPage(currentPage);
		page.setShowCount(pageSize);
		
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
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("OutlineMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

