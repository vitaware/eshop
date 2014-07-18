package com.shop.service;

import java.util.List;

import com.shop.domain.Goods;

public interface HGService {
	/**
	 * 根据物品类型查找所有物品
	 * @param type  物品类型
	 * @return
	 */
	public abstract List<Goods> selectGoodsByTypeSer(int type);
	
	/**
	 * 根据物品编号查找物品
	 * @param goodsCode物品编号
	 * @return
	 */
	public abstract Goods selectGoodsByCodeSer(String goodsCode);
}
