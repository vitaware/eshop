package com.shop.web.control;

import java.io.IOException;
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

public class UMUpdateConServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			UMUserService ser=new UMUserServiceImpl();
			try {
				//灏嗚〃鍗曟暟鎹�灏佽鍒�Formbean涓�
				FormBean  fb = FormToBeanTools.toFormBean(request);
				//灏咶ormBean灏佽鍒癠serBean涓�
				User user = new User();
				ConvertUtils.register(new DateLocaleConverter(), Date.class); //java銆倁til
				
				BeanUtils.copyProperties(user, fb);
				
				//璋冪敤Service灞備腑娉ㄥ唽鏂规硶杩涜鏇存柊
				boolean registUserSer = ser.updateUserSer(user);
				if(registUserSer){
					 HttpSession  session = request.getSession();
					request.setAttribute("message", "<meta http-equiv='refresh' content='3;url=message.jsp'>淇敼鎴愬姛锛�绉掑悗璺宠浆锛�");
					request.getRequestDispatcher("message.jsp").forward(request, response); 
				}else{
				 
					HttpSession  session = request.getSession();
					session.setAttribute("message", "淇敼澶辫触~~~");
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
