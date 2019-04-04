package com.it.bean;

public class OrderForm {
	private String ord_id;
	private int user_id;
	private String total;
	private String user_name;
	public String getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(String ord_id) {
		this.ord_id = ord_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public OrderForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderForm(String ord_id, int user_id, String total, String user_name) {
		super();
		this.ord_id = ord_id;
		this.user_id = user_id;
		this.total = total;
		this.user_name = user_name;
	}
	@Override
	public String toString() {
		return "OrderForm [ord_id=" + ord_id + ", user_id=" + user_id
				+ ", total=" + total + ", user_name=" + user_name + "]";
	}
	
	
}
