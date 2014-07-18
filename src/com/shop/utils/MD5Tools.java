package com.shop.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Tools {
	
	/**
	 * MD5算法,传入字符创，放回MD5编码的字符创
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public  static String getMD5String(String str){
		//创建MD5算法
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		//将String通过MD5转化为字节数组
		byte[] digest = md.digest(str.getBytes());
		
		//创建BASE64Encoder对象
		BASE64Encoder en = new BASE64Encoder();
		
		//字节数组通过base64进行编码，产生新的String
		String encode = en.encode(digest);
		return encode;
	}
}
