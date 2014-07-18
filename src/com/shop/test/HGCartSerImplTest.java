package com.shop.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shop.domain.Goods;
import com.shop.domain.ShoppingCart;
import com.shop.service.HGCartSer;
import com.shop.service.impl.HGCartSerImpl;

public class HGCartSerImplTest {
	HGCartSer cartSer = new HGCartSerImpl();
	@Test
	public final void testAddGoods() {
		Goods goods = new Goods("121324", "xiaomi3", "ะกรื",	2, "nnn", 3,"gfkjsldjgjfgjgkj",1399.9);
		cartSer.addGoods(goods);
		cartSer.addGoods(goods);
		ShoppingCart cart = cartSer.addGoods(goods);
		System.out.println(cart.getTotalPrice());
		System.out.println(cart.getCartSize());
	}

	@Test
	public final void testDeleteGoods() {
		fail("Not yet implemented"); // TODO
	}

}
