package com.shop.domain;
/**
 * 封装物品信息
 * 1，物品ID---goodsId
 * 2，物品编码----goodsCode
 * 3，物品名称---goodsName
 * 4,物品数量---goodsNum
 * 5，物品状态 ---goodsStatus
 * 6,物品类型----goodsType
 * 7,物品描述-----goodsDescription
 * 8,物品价格----goodsPrice
 * @author csh
 *
 */
public class Goods {
	private String goodsId;
	private String goodsCode;
	private String goodsName;
	private int goodsNum;
	private String goodsStatus;
	private int goodsType;
	private String goodsDescription;
	private Double goodsPrice;
	
	public Goods() {}

	

	public Goods(String goodsId, String goodsCode, String goodsName,
			int goodsNum, String goodsStatus, int goodsType,
			String goodsDescription, Double goodsPrice) {
		super();
		this.goodsId = goodsId;
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.goodsNum = goodsNum;
		this.goodsStatus = goodsStatus;
		this.goodsType = goodsType;
		this.goodsDescription = goodsDescription;
		this.goodsPrice = goodsPrice;
	}



	public Double getGoodsPrice() {
		return goodsPrice;
	}



	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}



	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getGoodsStatus() {
		return goodsStatus;
	}

	public void setGoodsStatus(String goodsStatue) {
		this.goodsStatus = goodsStatue;
	}

	public int getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(int goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsDescription() {
		return goodsDescription;
	}

	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}



	@Override
	public String toString() {
		return "Goods [goodsCode=" + goodsCode + ", goodsDescription="
				+ goodsDescription + ", goodsId=" + goodsId + ", goodsName="
				+ goodsName + ", goodsNum=" + goodsNum + ", goodsPrice="
				+ goodsPrice + ", goodsStatus=" + goodsStatus + ", goodsType="
				+ goodsType + "]";
	}

	
	
}
