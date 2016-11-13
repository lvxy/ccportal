package com.fh.ws;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

@Service(value="wsOperationService")
@WebService(targetNamespace = "http://ws.hantiansoft.com/")
public interface WsOperationService {
	public String execute(String json);
}
