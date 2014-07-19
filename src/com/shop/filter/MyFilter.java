package com.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyFilter implements Filter{


	private FilterConfig filterConfig;
	private String defaultEncoding = "UTF-8";
	
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("过滤器");
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		String encode = filterConfig.getInitParameter("encoding");
		if(encode==null){
			encode = defaultEncoding;
		}
		request.setCharacterEncoding(encode);//POST   
		response.setContentType("text/html;charset="+encode); //杈撳嚭缂栫爜闂�?
		//璋冪敤瑁呴グ绫�---瑙ｅ喅get鏂瑰�?
		chain.doFilter(new MyHttpServletRequest(request), response);
	}


	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
