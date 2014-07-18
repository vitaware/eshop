package com.shop.web.control;

import java.io.IOException;
import java.io.PrintWriter;

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

public class shoppingCartCon extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//调用Service层中获取数据信息的方法
		HGService service = new HGServiceImpl();
		HGCartSer cartSer = new HGCartSerImpl();
		
		String code = request.getParameter("goodsCode");
		//Goods goods = (Goods)request.getAttribute("goods");
		Goods goods = service.selectGoodsByCodeSer(code);
		if(goods !=null){
			//将获取的物品添加到购物车中
			ShoppingCart shoppingCart = cartSer.addGoods(goods);
			HttpSession session = request.getSession();//作用域设置为session
			//将获取的数据添加到作用域中
			session.setAttribute("shoppingCart", shoppingCart);
			
			//将作用域中的数据在页面进行展示
			request.getRequestDispatcher("/WEB-INF/jsps/shoppingCart.jsp").forward(request, response);
		}else{
			//有错误进行提示
			request.setAttribute("message", "信息不存在,还未录入");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
		
		/*//判断code是否为0，为0则跳转shoppingCart.jsp界面
		if(code.equals("0")){
			//将作用域中的数据在页面进行展示
			request.getRequestDispatcher("/WEB-INF/jsps/shoppingCart.jsp").forward(request, response);
		}else{
			//有错误进行提示
			request.setAttribute("message", "信息不存在,还未录入");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}*/
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
