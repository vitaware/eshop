package com.shop.dao;

import java.util.List;

import com.shop.domain.Goods;

public interface HGDao {
	/**
	 * 根据物品类型搜索物品
	 * @param type
	 * @return
	 */
	public abstract List<Goods> selectGoodsByType(int type);
	
	/**
	 * 
	 * @param goodsCode
	 * @return
	 */
	public abstract Goods selectGoodsByCode(String goodsCode);
}
