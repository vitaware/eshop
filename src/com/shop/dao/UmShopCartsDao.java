package com.shop.dao;

import java.util.List;



import com.shop.domain.UmShopCarts;

public interface UmShopCartsDao {
	
	/**
	 * 娣诲姞鍟嗗搧鍒拌喘鐗╄溅
	 * @param usc
	 * @return
	 */

	
	public abstract boolean UmShopCarts(UmShopCarts usc);
	public abstract boolean addUmShopCarts(UmShopCarts usc);
	/**
	 * 鑾峰彇鎵�湁鐨勬暟鎹�
	 * @return
	 */
	public abstract List<UmShopCarts> findAll() ;
	/**
	 * 鍒犻櫎 鐢ㄦ埛
	 * @param name  鏍规嵁name杩涜鍒犻櫎
	 * @return
	 */
	public abstract boolean delUmShopCarts(String id);
	/**
	 * 鏍规嵁id鑾峰彇瀵硅薄
	 * @param id
	 * @return
	 */
	public abstract  UmShopCarts  findUmShopCartsById(String id);
	/**
	 * 鏇存柊鐢ㄦ埛淇℃伅
	 * @param usc
	 * @return
	 */
	public abstract  boolean updataUmShopCarts(UmShopCarts usc);
}
