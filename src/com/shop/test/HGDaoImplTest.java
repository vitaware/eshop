package com.shop.test;

import java.util.List;

import org.junit.Test;

import com.shop.dao.HGDao;
import com.shop.dao.impl.HGDaoImpl;
import com.shop.domain.Goods;

public class HGDaoImplTest {
	HGDao hgDao = new HGDaoImpl();
	
	@Test
	public void selectGoodsByType(){
		List<Goods> goodsByType = hgDao.selectGoodsByType(1);
		//System.out.println(goodsByType.size());
		for (Goods goods : goodsByType) {
			System.out.println(goods);
		}
	}
	
	@Test
	public void selectGoodsByCode(){
		Goods goods = hgDao.selectGoodsByCode("mi2ssss");
		System.out.println(goods);
	}
	
}
