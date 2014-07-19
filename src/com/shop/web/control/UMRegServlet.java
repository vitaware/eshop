package com.shop.web.control;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.shop.domain.FormBean;
import com.shop.domain.User;
import com.shop.service.UMUserService;
import com.shop.service.impl.UMUserServiceImpl;
import com.shop.utils.FormToBeanTools;

public class UMRegServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UMUserService  service = new UMUserServiceImpl();
		try {
			//灏嗚〃鍗曟暟鎹�灏佽鍒�Formbean涓�
			FormBean  fb = FormToBeanTools.toFormBean(request);
			if(!fb.proving()){
				//鐢ㄤ簬鍥炴樉
				request.setAttribute("formbean", fb );
				//鐢ㄤ簬閿欒鎻愮ず
				request.setAttribute("formerror", fb.getError());
				request.getRequestDispatcher("/WEB-INF/jsps/register.jsp").forward(request, response);
				return ;
			}
			
			//灏咶ormBean灏佽鍒癠serBean涓�
			User user = new User();
			
			ConvertUtils.register(new DateLocaleConverter(), Date.class); //java.util
			
			BeanUtils.copyProperties(user, fb);
			
			//璋冪敤Service灞備腑娉ㄥ唽鏂规硶杩涜娉ㄥ唽
			boolean registUserSer = service.registUserSer(user);
			request.setCharacterEncoding("UTF-8");
			if(registUserSer){
				 HttpSession  session = request.getSession();
				session.setAttribute("userbean", user);
				request.setAttribute("message", "<meta http-equiv='refresh' content='3;url=index.jsp'> 注册完成，3秒后跳转");
				request.getRequestDispatcher("message.jsp").forward(request, response); 
			}else{
				HttpSession  session = request.getSession();
				session.setAttribute("message", "zhuceshibai");
				request.getRequestDispatcher("message.jsp").forward(request, response); 
			}
		} catch ( Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
