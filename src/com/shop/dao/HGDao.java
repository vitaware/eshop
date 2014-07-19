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
	 * 根据物品编号搜索物品
	 * @param goodsCode
	 * @return
	 */
	public abstract Goods selectGoodsByCode(String goodsCode);
	/**
	 * 模糊查询
	 * @param search
	 * @return
	 */
	
	public abstract List<Goods> selectGoods(String search);
}
