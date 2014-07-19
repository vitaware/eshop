package com.shop.service;

import java.util.List;

import com.shop.domain.User;

public interface UMUserService {

	/**
	 * 注册用户
	 * @param user  从表现层获表单中获取到 User对象
	 * @return
	 */
	public abstract boolean registUserSer(User user);
	/**
	 * 登录板块
	 * @param name  用户姓名
	 * @param pwd   用户密码
	 * @return  user对象
	 */
	public abstract User loginUserSer(String name,String pwd);
	/**
	 * 用户信息更新
	 * @param user   用户信息
	 * @return
	 */
	public abstract boolean updateUserSer(User user);
	/**
	 * 获取所有用户信息
	 * @return
	 */
	public abstract List<User> findAllSer();
	/**
	 * 根据用户id获取用户信息
	 * @return
	 */
	public abstract User findUserByIdSer(String id);
}