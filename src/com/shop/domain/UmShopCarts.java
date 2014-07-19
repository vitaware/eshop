package com.shop.domain;

public class UmShopCarts {
	private String id;
	private String userid;
	private String goodsname;
	private String colour;
	private String commoditytyp;
	private double price;
	private int  productnum;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	public UmShopCarts() {
		// TODO Auto-generated constructor stub
	}
	public UmShopCarts(String id, String name, String goodsname, String colour,
			 String commoditytyp, double price,int productnum ) {
		super();
		this.id = id;
		this.userid = userid;
		this.goodsname = goodsname;
		this.colour = colour;
		this.productnum = productnum ;
		this.commoditytyp = commoditytyp;
		this.price = price;
	}
	@Override
	public String toString() {
		return "UmShopCarts [colour=" + colour + ", commoditytyp="
				+ commoditytyp + ", goodsname=" + goodsname + ", id=" + id
				+ ", price=" + price + ", productnum=" + productnum
				+ ", userid=" + userid + "]";
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
}
