package com.example;

import javax.jws.WebService;

@SuppressWarnings("restriction")
@WebService(endpointInterface = "com.example.JmsWebService")
public class ImplJmsWebService implements JmsWebService {

	public String echoMessage(String msg) {
		// TODO Auto-generated method stub
		return "Reply : - Helo "+msg;
	}

}
