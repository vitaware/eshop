package com.shop.web.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.domain.Goods;
import com.shop.service.HGService;
import com.shop.service.impl.HGServiceImpl;

public class ShowPageCon extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//调用Service层中获取数据信息的方法
		HGService service = new HGServiceImpl();
		
		//获取页面传递的页码
		String typeStr = (String)request.getParameter("type");
		int type = Integer.parseInt(typeStr);
		List<Goods> selectGoods = service.selectGoodsByTypeSer(type);
		if(selectGoods !=null && selectGoods.size()>0){
			//将获取的数据添加到作用域中
			request.setAttribute("selectGoods", selectGoods);
			
			//将作用域中的数据在页面进行展示
			request.getRequestDispatcher("/WEB-INF/jsps/show.jsp").forward(request, response);
		}else{
			//有错误进行提示
			request.setAttribute("message", "信息不存在,还未录入");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
