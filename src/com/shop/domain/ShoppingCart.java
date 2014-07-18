package com.shop.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 购物车封装类
 * 1,List<Goods>  包含购物车中所有的物品
 * 2，double totalPrice 购物车中物品总价值
 * 3，int cartSize 购物车中物品总数
 * 4，boolean deleteGoods(String goodsCode)删除物品
 * 5,修改物品数量，包含增加和减少
 * 6,清空购物车deleteAll
 * @author csh
 *
 */
public class ShoppingCart {
	private Map<String,Goods> map = new HashMap<String,Goods>();
	private double totalPrice=0;
	private int cartSize=0;
	
	/**
	 * 计算购物车中物品总数和价格总数
	
	{
		if(map.size()>0){
			List<Goods> list = (List<Goods>)map.values();
		
			for (Goods goods : list) {
				cartSize +=goods.getGoodsNum();
			}
			
			for (Goods goods2 : list) {
				totalPrice +=goods2.getGoodsPrice()*goods2.getGoodsNum();
			}
		}
		
	} 
	*/
	
	/**
	 * 单例模型：饿汉式
	 * 
	 */
	private static ShoppingCart shoppingCart = new ShoppingCart();
	
	private ShoppingCart(){}
	
	public static ShoppingCart getShoppingCart(){
		return shoppingCart;
	}
	/**
	 * 计算总价值
	 */
	public double totalPrice(){
		Collection<Goods> values = map.values();
		double num2=0;
		for (Goods goods2 : values) {
			num2 +=goods2.getGoodsPrice()*goods2.getGoodsNum();
		}
		return num2;
	}
	/**
	 * 计算所有物品数量
	 */
	public int cartSize(){
		 Collection<Goods> values = map.values();
			int num =0;
			for (Goods goods : values) {
				num +=goods.getGoodsNum();
			}
			return num;
	}
	
	public Map<String, Goods> getMap() {
		return map;
	}

	public void setMap(Map<String, Goods> map) {
		this.map = map;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getCartSize() {
		return cartSize;
	}

	public void setCartSize(int cartSize) {
		this.cartSize = cartSize;
	}
	
	
}
