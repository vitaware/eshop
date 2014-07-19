package com.shop.web.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.domain.User;
import com.shop.service.UMUserService;
import com.shop.service.impl.UMUserServiceImpl;

public class UMLoginConServlet extends HttpServlet {

	UMUserService ser=new UMUserServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//鑾峰彇琛ㄥ崟涓暟鎹�
		String name=request.getParameter("username");
		String pwd=request.getParameter("password");
		//璋冪敤service涓殑鐧诲綍鏂规硶
		User user=null;
		if(name!=null && pwd!=null && !name.trim().equals("") && !pwd.trim().equals("")){
			user=ser.loginUserSer(name, pwd);
		}
		if(user!=null){
			HttpSession session=request.getSession();
			session.setAttribute("loginuser", user);
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "错啦");
			request.getRequestDispatcher("./message.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
