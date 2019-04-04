package com.it.bean;
/**
 * 
 * Title:商品信息类
 * Description:com.it.bean.GoodsInfo.java
 * Copyright: Copyright (c) j2se 8.0
 * date: 2019年2月20日下午4:54:19
 * Company:gy
 * @author lcl
 */
public class GoodsInfo {
	private String goods_Id;//商品编号
	private String goods_Name;//商品名称
	private Double goods_Price;//商品价格
	public String getGoods_Id() {
		return goods_Id;
	}
	public void setGoods_Id(String goods_Id) {
		this.goods_Id = goods_Id;
	}
	public String getGoods_Name() {
		return goods_Name;
	}
	public void setGoods_Name(String goods_Name) {
		this.goods_Name = goods_Name;
	}
	public double getGoods_Price() {
		return goods_Price;
	}
	public void setGoods_Price(double goods_Price) {
		this.goods_Price = goods_Price;
	}
	public GoodsInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GoodsInfo(String goods_Id, String goods_Name, double goods_Price) {
		super();
		this.goods_Id = goods_Id;
		this.goods_Name = goods_Name;
		this.goods_Price = goods_Price;
	}
	@Override
	public String toString() {
		return "GoodsInfo [goods_Id=" + goods_Id + ", goods_Name=" + goods_Name
				+ ", goods_Price=" + goods_Price + "]";
	}
	

}
