package com.shop.web.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.shop.domain.Address;
import com.shop.service.AddressService;
import com.shop.service.impl.AddressServiceImpl;

public class LoadAddressServlet extends HttpServlet {
	AddressService ser=new AddressServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//获取parentid
		String parentid = request.getParameter("parentid");
		System.out.println(parentid);
		List<Address> allAddress = ser.getAllAddress(parentid);
		System.out.println( allAddress );
		
		response.setContentType("text/html;charset=utf-8");
		
		JSONArray json = new JSONArray(allAddress);
		System.out.println(json);
		response.getWriter().print(json);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
