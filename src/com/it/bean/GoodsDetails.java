package com.it.bean;
/**
 * 
 * Title:商品明细
 * Description:com.it.bean.GoodsDetails.java
 * Copyright: Copyright (c) j2se 8.0
 * date: 2019年2月20日下午4:56:37
 * Company:gy
 * @author lcl
 */
public class GoodsDetails {
	private GoodsInfo goodsInfo;//商品
	private  int  count;//数量
	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public GoodsDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GoodsDetails(GoodsInfo goodsInfo, int count) {
		super();
		this.goodsInfo = goodsInfo;
		this.count = count;
	}
	@Override
	public String toString() {
		return "GoodsDetails [goodsInfo=" + goodsInfo + ", count=" + count
				+ "]";
	}
	

}
