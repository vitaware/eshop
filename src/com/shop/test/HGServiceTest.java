package com.shop.test;

import java.util.List;

import org.junit.Test;

import com.shop.domain.Goods;
import com.shop.service.HGService;
import com.shop.service.impl.HGServiceImpl;

public class HGServiceTest {
	
	HGService service = new HGServiceImpl();
	
	@Test
	public void selectGoodsByTypeSer(){
		List<Goods> goodsByTypeSer = service.selectGoodsByTypeSer(1);
		//System.out.println(goodsByType.size());
		for (Goods goods : goodsByTypeSer) {
			System.out.println(goods);
		}
	}
	
	@Test
	public void selectGoodsByCode(){
		Goods goods = service.selectGoodsByCodeSer("mi2ssss");
		System.out.println(goods);
	}
}
