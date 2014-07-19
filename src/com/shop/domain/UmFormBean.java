package com.shop.domain;



/**
 * FormBean  
 * @author Administrator
 *
 */
public class UmFormBean {
	private String id;
	private String name;
	private String goodsname;
	private String colour;
	private int  productnum;
	private String commoditytyp;
	private double price;
	
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
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public int getProductnum() {
		return productnum;
	}
	public void setProductnum(int productnum) {
		this.productnum = productnum;
	}
	public String getCommoditytyp() {
		return commoditytyp;
	}
	public void setCommoditytyp(String commoditytyp) {
		this.commoditytyp = commoditytyp;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public UmFormBean(String id,String name, String goodsname, String colour,
			int productnum, String commoditytyp, double price) {
		super();
		this.id = id; 
		this.name = name;
		this.goodsname = goodsname;
		this.colour = colour;
		this.productnum = productnum;
		this.commoditytyp = commoditytyp;
		this.price = price;
	}
	
	public UmFormBean() {
		// TODO Auto-generated constructor stub
	}
	
	
}
