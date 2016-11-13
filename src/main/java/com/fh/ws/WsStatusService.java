package com.fh.ws;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

@Service(value="wsConfigService")
@WebService(targetNamespace = "http://ws.hantiansoft.com/")
public interface WsStatusService {
	
	public String find(String json);
	
	public String findAll(String json);
	
}
