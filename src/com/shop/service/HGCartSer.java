package com.shop.service;

import java.util.List;

import com.shop.domain.Goods;
import com.shop.domain.ShoppingCart;

public interface HGCartSer {
	
	
	/**
	 * 向购车中添加物品
	 * @param list
	 */
	public abstract ShoppingCart addGoods(Goods goods);
	
	/**
	 * 删除购物车中物品
	 * @param list
	 */
	public abstract boolean deleteGoods(String goodsCode);
}
