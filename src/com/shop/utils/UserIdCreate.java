package com.shop.utils;

import java.util.UUID;

public class UserIdCreate {
	/**
	 * 通过UUID随机产生用户ID，且唯一
	 * @return
	 */
	public static String getRandomId(){
		return UUID.randomUUID().toString();
	}
}
