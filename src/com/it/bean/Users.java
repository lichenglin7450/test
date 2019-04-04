package com.it.bean;

public class Users {
	private int user_id;
	private String  user_name;
	private String  user_pwd;
	private String  user_addr;
	private String  user_tel;
	private String  user_sex;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_addr() {
		return user_addr;
	}
	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int user_id, String user_name, String user_pwd,
			String user_addr, String user_tel, String user_sex) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_addr = user_addr;
		this.user_tel = user_tel;
		this.user_sex = user_sex;
	}
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", user_name=" + user_name
				+ ", user_pwd=" + user_pwd + ", user_addr=" + user_addr
				+ ", user_tel=" + user_tel + ", user_sex=" + user_sex + "]";
	}
	
	
	
	

}
