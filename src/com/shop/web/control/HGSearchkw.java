package com.shop.web.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.domain.Goods;
import com.shop.service.HGService;
import com.shop.service.impl.HGServiceImpl;

public class HGSearchkw extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String wd = request.getParameter("wd").trim();
		//String name=new String(wd.getBytes("ISO8859-1"),"UTF-8");
		//String wds = java.net.URLDecoder.decode(wd,"GBK");  
		HGService service = new HGServiceImpl();
		List<Goods> selectGoods = service.selectGoods(wd);
		if(selectGoods !=null && selectGoods.size()>0){
			//将获取的数据添加到作用域
			request.setAttribute("selectGoods", selectGoods);
			
			//数据展示
			request.getRequestDispatcher("/WEB-INF/jsps/show.jsp").forward(request, response);
		}else{
			//提示
			request.setAttribute("message", "信息不存在");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
