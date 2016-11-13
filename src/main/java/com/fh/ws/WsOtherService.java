package com.fh.ws;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

@Service(value="wsOtherService")
@WebService(targetNamespace = "http://ws.hantiansoft.com/")
public interface WsOtherService {
	
	public String refresh(String json);
	public void refreshFSXml(String json);
}
