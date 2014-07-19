package com.shop.utils;

import java.util.UUID;

/**
 * 用于生成 一个 随机的id  id----唯一
 * @author Administrator
 *
 */
public class IdTools {
	
	public static String getRandomId(){
		
		return UUID.randomUUID().toString();
	}
	
	
}
