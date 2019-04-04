package com.it.service;

import java.util.List;

import com.it.bean.Users;
/**
 * 
 * Title:用户接口
 * Description:com.it.service.IUsers.java
 * Copyright: Copyright (c) j2se 8.0
 * date: 2019年2月22日下午4:31:26
 * Company:gy
 * @author lcl
 */
public interface IUsers {
	//增
	public boolean addUsers(Users users);
	//删
	public boolean delUsers(Users users);
	//改
	public boolean updUsers(Users users);
	//查询全部
	public List<Users> queryAllUsers(Users users);
	//用id查单个
	public Users findUsersById(Users users);
	//用name查单个
		public Users findUsersByName(Users users);
	//登录
	public boolean login(Users users);

}
