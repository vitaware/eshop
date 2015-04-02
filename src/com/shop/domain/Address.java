package com.shop.domain;

public class Address {
	private String id;
	private String name;
	private String parentid;
	private String orderfield;
	
	//新增构造方法
	public Address(String id, String name, String parentid, String orderfield) {
		this.id = id;
		this.name = name;
		this.parentid = parentid;
		this.orderfield = orderfield;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getOrderfield() {
		return orderfield;
	}
	public void setOrderfield(String orderfield) {
		this.orderfield = orderfield;
	}
	
	
}
