package com.shop.web.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.domain.Goods;
import com.shop.domain.ShoppingCart;
import com.shop.service.HGCartSer;
import com.shop.service.HGService;
import com.shop.service.impl.HGCartSerImpl;
import com.shop.service.impl.HGServiceImpl;

public class DelOneGoodsCon extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取session作用域中信息
		HttpSession session = request.getSession();
		ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");
		
		//提取ShoppingCart中用户购买信息
		Map<String, Goods> map = shoppingCart.getMap();
		
		//获取页面传递的信息
		HGService service = new HGServiceImpl();
		HGCartSer cartSer = new HGCartSerImpl();
		
		//获取页面传递的页码
		String code = (String)request.getParameter("goodsCode");
		//删除操作
		boolean bool = cartSer.deleteGoods(code);
		
		if(bool){
			session.setAttribute("shoppingCart", shoppingCart);
			//将作用域中的数据在页面进行展示
			request.getRequestDispatcher("/WEB-INF/jsps/shoppingCart.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "删除失败");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
