package com.shop.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.shop.domain.FormBean;

/**
 * Form ---->FormBean
 * @author Administrator
 *
 */
public class FormToBeanTools {

	public static FormBean  toFormBean(ServletRequest request){
		FormBean bean = null;
		try {
			//1 获取表单中的数据  ----map
			Map map = request.getParameterMap();
			
			Class  forName = Class.forName("com.shop.domain.FormBean");
			 bean = (FormBean) forName.newInstance();
			//2 将map中的数据 封装到 FormBean中
			BeanUtils.populate(bean, map);
		} catch ( Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	public static Object  toFormBean2(ServletRequest request){
		Object bean = null;
		try {
			//1 获取表单中的数据  ----map
			Map map = request.getParameterMap();
			
			Class  forName = Class.forName("com.goods.domain.FormBean");
			bean =  forName.newInstance();
			//2 将map中的数据 封装到 FormBean中
			BeanUtils.populate(bean, map);
		} catch ( Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
}
