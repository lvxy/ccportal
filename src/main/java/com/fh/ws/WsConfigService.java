package com.fh.ws;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

@Service(value="wsConfigService")
@WebService(targetNamespace = "http://ws.hantiansoft.com/")
public interface WsConfigService {
	
	public String add(String json);

	public String delete(String json);

	public String update(String json);

	public String find(String json);
	
	public String findAll(String json);
	
	/**
	 * 在添加 ivr 子级菜单的时候, 判断该菜单名称是否已经存在其被添加的子级菜单中的下级菜单里存在.(避免上下级菜单互相调用引起的无限循环)
	 */
	public String findIvr(String json);

	public String count(String json);
	
	public String page(String json);
}
