package com.it.service;

import java.util.List;

import com.it.bean.Users;
/**
 * 
 * Title:�û��ӿ�
 * Description:com.it.service.IUsers.java
 * Copyright: Copyright (c) j2se 8.0
 * date: 2019��2��22������4:31:26
 * Company:gy
 * @author lcl
 */
public interface IUsers {
	//��
	public boolean addUsers(Users users);
	//ɾ
	public boolean delUsers(Users users);
	//��
	public boolean updUsers(Users users);
	//��ѯȫ��
	public List<Users> queryAllUsers(Users users);
	//��id�鵥��
	public Users findUsersById(Users users);
	//��name�鵥��
		public Users findUsersByName(Users users);
	//��¼
	public boolean login(Users users);

}
