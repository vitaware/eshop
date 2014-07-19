package com.shop.dao;

import java.util.List;

import com.shop.domain.User;

public interface UMUserDao {

	/**
	 * 检查是否存在
	 * @param name  用户名称
	 * @return  user对象
	 */
	public abstract User findByName(String name);
	
	/**
	 * 注册用户
	 * @param user  从表单获 封装到 UserBean中的 对象
	 * @return   user对象
	 */
	public abstract boolean regiterUser(User user);
	/**
	 * 用户登录
	 * @param name  用户名
	 * @param pwd   用户密码
	 * @return  
	 */
	public abstract User loginUser(String name,String pwd);
	/**
	 * 更新用户信息
	 * @param user  更新用户名
	 * @return
	 */
	public abstract boolean updateUser(User user);
	/**
	 * 获取所有数据
	 * @return
	 */
	public abstract List<User> findAll();
	/**
	 * 根据id查找用户信息
	 * @param id  用户id
	 * @return
	 */
	public abstract User findUserById(String id);

}