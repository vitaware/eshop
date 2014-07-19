package com.shop.domain;

import java.util.Date;

/**
 * User  Bean
 * @author Administrator
 */
public class User {
	private String id;
	private String name;
	private String pwd;
	private Date birthday;
	private String gender;
	private String address;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String name, String pwd, Date birthday,
			String gender, String address) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.birthday = birthday;
		this.gender = gender;
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [address=" + address + ", birthday=" + birthday
				+ ", gender=" + gender + ", id=" + id + ", name=" + name
				+ ", pwd=" + pwd + "]";
	}
	
	
	
}	