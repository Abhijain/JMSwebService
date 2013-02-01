package com.example;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@SuppressWarnings("restriction")
@WebService
@SOAPBinding(style=Style.DOCUMENT)
public interface JmsWebService {
	@WebMethod
	String echoMessage(String msg);


}
