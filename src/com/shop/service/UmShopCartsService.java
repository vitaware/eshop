package com.shop.service;



import java.util.List;


import com.shop.domain.UmShopCarts;

public interface UmShopCartsService {

	/**
	 * 添加
	 * @param user  从表现层获表单中获取到 对象
	 * @return
	 */
	public abstract boolean addUmShopCartsSer(UmShopCarts usc);
	/**
	 * 获取所有的数据
	 * @return
	 */
	public abstract List<UmShopCarts> findAllSer();
	
	/**
	 * 根据 id 删除User
	 * @param temp
	 * @return
	 */
	public abstract boolean delUmShopCartsSer(String id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public abstract  UmShopCarts  findUmShopCartsById(String id);
	/**
	 * 更新对象
	 * @param usc
	 * @return
	 */
	public abstract  boolean updataUmShopCartsSer(UmShopCarts usc);
	
}