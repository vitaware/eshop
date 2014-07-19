package com.shop.domain;

import java.util.HashMap;

/**
 * FormBean  
 * @author Administrator
 *
 */
public class FormBean {
	private String id;
	private String name;
	private String pwd;
	private String repwd;
	private String birthday;
	private String gender;
	private String address;
	//灏佽Error
	private HashMap error  = new HashMap();
	
	public HashMap getError() {
		return error;
	}
	public void setError(HashMap error) {
		this.error = error;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRepwd() {
		return repwd;
	}
	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
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
	public FormBean(){}
	
	public  boolean proving(){
		boolean flag = true ;
		//鐢ㄦ埛鍚� \w  6-12
		if(name==null || name.trim().equals("")){
			flag = false;
			error.put("errorname", "鐢ㄦ埛涓嶈兘涓虹┖");
		} else{
			flag = name.matches("\\w{6,12}");
			if(!flag){
				error.put("errorname", "鐢ㄦ埛鍙兘鏄瓧绗�鏁板瓧_ 6--12浣�");
				 flag = false;
			}
		}
		
		//瀵嗙爜
		if(pwd==null || pwd.trim().equals("")){
			flag = false;
		}else{
			flag = pwd.matches("\\w{3,16}");
			if(!flag){
				error.put("errorpwd", "瀵嗙爜鍙兘鏄瓧绗�鏁板瓧_ 3--16浣�");
				 flag=false;
			}
		}
		
		//鍒ゆ柇涓ゆ瀵嗙爜鏄惁涓�嚧
		if(!repwd.equals(pwd)){
				error.put("errorrepwd", "涓ゆ瀵嗙爜涓嶄竴鑷�");
				 flag = false;
		}
		
		//鍒ゆ柇鏃ユ湡鏄惁涓簄ull
		if(birthday==null){
			return flag = false;
		}
		
		
 
		return flag;
	}
}
