package com.shop.web.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.UMUserDao;
import com.shop.dao.impl.UMUserDaoImpl;
import com.shop.domain.User;
import com.shop.service.UMUserService;
import com.shop.service.impl.UMUserServiceImpl;
import com.shop.utils.MD5Tools;

public class UMUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//UMUserDao ser=new UMUserDaoImpl();
			UMUserService ser=new UMUserServiceImpl();
			//鑾峰彇鍒伴〉闈紶杩囨潵鐨剈sername and password
			String username=request.getParameter("username");
			String password = request.getParameter("password");
			//閫氳繃name 璋冪敤鏂规硶鑾峰彇User瀵硅薄    娉ㄦ剰鍔犲瘑
			User ser2 = ser.loginUserSer(username, password);
			//灏嗚幏鍙栫殑瀵硅薄璁剧疆鍒颁綔鐢ㄥ煙涓�
			request.setAttribute("bynamepwd", ser2);
			request.getRequestDispatcher("/template/update.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
