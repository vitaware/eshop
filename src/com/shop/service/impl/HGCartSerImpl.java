package com.shop.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.taglibs.standard.tag.common.xml.ForEachTag;
import org.junit.Test;

import com.shop.domain.Goods;
import com.shop.domain.ShoppingCart;
import com.shop.service.HGCartSer;

/**
 * 提供购物的增删改查方法
 * @author csh
 *
 */
public class HGCartSerImpl implements HGCartSer {
	//初始化购物车
	ShoppingCart sc = ShoppingCart.getShoppingCart();
	//获取购物车中所有物品
	Map<String, Goods> map = sc.getMap();
	int cartSize=sc.getCartSize();
	double totalPrice = sc.getTotalPrice();

	public ShoppingCart addGoods(Goods goods) {
		//Map<String, Goods> map = sc.getMap();
		
		//判断购物车中是否存在此商品
		if(null == map.get(goods.getGoodsCode())){
			//不存则添加,并将物品数量设置为1
			goods.setGoodsNum(1);
			map.put(goods.getGoodsCode(), goods);
			//将修改后的Map提交给购物车
			sc.setMap(map);
		}else{
			//存在则数量加1
			int bfnum = map.get(goods.getGoodsCode()).getGoodsNum()+1;
			goods.setGoodsNum(bfnum);
			map.put(goods.getGoodsCode(), goods);
			sc.setMap(map);
		}
		
		//计算那总价值和数量
		cartSize=sc.cartSize();
		totalPrice=sc.totalPrice();
		sc.setCartSize(cartSize);
		sc.setTotalPrice(totalPrice);
		return sc;
	}

	public boolean deleteGoods(String goodsCode) {
		//Map<String, Goods> map = sc.getMap();
		if(!goodsCode.equals("")){
			map.remove(goodsCode);
			sc.setMap(map);
			//计算那总价值和数量
			cartSize=sc.cartSize();
			totalPrice=sc.totalPrice();
			sc.setCartSize(cartSize);
			sc.setTotalPrice(totalPrice);
			return true;
		}else{
			return false;
		}
		
	}

	
}
