package com.it.bean;

public class OrderDetail {
	private String mx_id;
	private String ord_count;
	private String ord_id;
	private String goods_id;
	private String goods_name;
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(String mx_id, String ord_count, String ord_id,
			String goods_id, String goods_name) {
		super();
		this.mx_id = mx_id;
		this.ord_count = ord_count;
		this.ord_id = ord_id;
		this.goods_id = goods_id;
		this.goods_name = goods_name;
	}
	public String getMx_id() {
		return mx_id;
	}
	public void setMx_id(String mx_id) {
		this.mx_id = mx_id;
	}
	public String getOrd_count() {
		return ord_count;
	}
	public void setOrd_count(String ord_count) {
		this.ord_count = ord_count;
	}
	public String getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(String ord_id) {
		this.ord_id = ord_id;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	@Override
	public String toString() {
		return "OrderDetail [mx_id=" + mx_id + ", ord_count=" + ord_count
				+ ", ord_id=" + ord_id + ", goods_id=" + goods_id
				+ ", goods_name=" + goods_name + "]";
	}
	
	
	
}
