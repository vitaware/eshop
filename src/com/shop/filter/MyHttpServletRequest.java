package com.shop.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyHttpServletRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	public MyHttpServletRequest(HttpServletRequest request){
		super(request);
		this.request = request;
	}
	@Override
	public String getParameter(String name) {
		String value = request.getParameter(name);
		if(value==null)
			return value;
		try{
		//得到请求方式
		String method = request.getMethod();
		//对get请求方式进行增强
		if(method.equalsIgnoreCase("get")){//get GET
			value = new String(value.getBytes("ISO-8859-1"),request.getCharacterEncoding());
		}
		return value;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
}

