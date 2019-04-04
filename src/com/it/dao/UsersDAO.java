package com.it.dao;


import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.it.bean.Users;
import com.it.utils.JDBCUtils;

/**
 * 
 * Title:
 * Description:com.it.dao.UsersDAO.java
 * Copyright: Copyright (c) j2se zxySoft
 * Company: zxySoft
 * @author zxy
 */

public class UsersDAO {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	// ��

	public boolean addUsers(Users users) {
		// 1 ��дsql
		String sql = "INSERT  INTO `userinfo`(`user_id`,`user_name`,`user_pwd`,`user_addr`,`user_tel`,`user_sex`) VALUES (?,?,?,?,?,?)";
		// 2 ��ӡsql
		System.out.println("sql-->" + sql);
		// 3 �������
		Object params[] = {users.getUser_id(),users.getUser_name(),users.getUser_pwd(),users.getUser_addr(),users.getUser_tel(),users.getUser_sex()};
		// �����־λ

		try {
			int rows = queryRunner.update(sql, params);
			return rows > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			throw new RuntimeException("���ʧ��!!");
		} finally {
			// �ͷ���Դ�����ݿ����ӳ�
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("�ر���Դʧ��!");
			}
		}
	}

	// ɾ
	public boolean delUsers(Users users) {
		// 1 ��дsql
				String sql = "delete from userinfo where user_id=?";
				// 2 ��ӡsql
				System.out.println("sql-->" + sql);
				// 3 �������
				Object params[] = { users.getUser_id() };
				// �����־λ

				try {
					int rows = queryRunner.update(sql, params);
					return rows > 0;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

					throw new RuntimeException("ɾ��ʧ��!!");
				} finally {
					// �ͷ���Դ�����ݿ����ӳ�
					try {
						DbUtils.close(JDBCUtils.getConnections());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new RuntimeException("�ر���Դʧ��!");
					}
				}

	}

	// ��
	public boolean updUsers(Users users) {
		// 1 ��дsql
				String sql = "update userinfo set user_name =?,user_pwd=?,user_addr=?,user_tel=?,user_sex=? where user_id=?";
				// 2 ��ӡsql
				System.out.println("sql-->" + sql);
				System.out.println(users);
				// 3 �������
				Object params[] = {users.getUser_name(),users.getUser_pwd(),users.getUser_addr(),users.getUser_tel(),users.getUser_sex(),users.getUser_id() };
				// �����־λ

				try {
					int rows = queryRunner.update(sql, params);
					return rows > 0;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

					throw new RuntimeException("�޸�ʧ��!!");
				} finally {
					// �ͷ���Դ�����ݿ����ӳ�
					try {
						DbUtils.close(JDBCUtils.getConnections());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new RuntimeException("�ر���Դʧ��!");
					}
				}
	}

	// ��
	public List<Users> queryAllUsers(Users users) {
		 //��дsql
		String sql = "select * from userinfo where 1=1 ";
		if(users!=null){
			//�ж��˻������ı���ĺϷ���
			// "" null�ж�
			if(!"".equals(users.getUser_name()) && users.getUser_name()!=null) {
				
				//ƴ��sql
				sql+="and user_name like '%"+users.getUser_name()+"%' ";
				
			}
		}
		
		System.out.println("sql-->"+sql);
		//�������Users��Ϣ
		List<Users> listU = null;
		try {
			listU = queryRunner.query(sql, new BeanListHandler<>(Users.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("��ѯ����ʧ��!");
		}
		finally {
			//�ͷ���Դ�����ݿ����ӳ�
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("�ر���Դʧ��!");
			}
		}
		return listU;
	}

	// ��ѯ����
	public Users findUsersById(Users users) {
		 //��дsql
		String sql = "select * from userinfo where user_id=?";
		//2 ��ӡsql
		 System.out.println("sql-->"+sql);
		 //3 �������
		 Object params[] = {users.getUser_id()};
		 
		 Users users1 = null;
		 try {
			users1 =  queryRunner.query(sql, new BeanHandler<Users>(Users.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��������ʧ��!");
		}
		finally {
			//�ͷ���Դ�����ݿ����ӳ�
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("�ر���Դʧ��!");
			}
		}
		return users1;
	}
	
	//��iD��ѯ����
	public Users findUsersByName(Users users) {
		 //��дsql
		String sql = "select * from userinfo where user_name=? ";
		//2 ��ӡsql
		 System.out.println("sql-->"+sql);
		 //3 �������
		 Object params[] = {users.getUser_name()};
		 
		 Users users1 = null;
		 try {
			users1 =  queryRunner.query(sql, new BeanHandler<Users>(Users.class), params);
			System.out.println("users1-->"+users1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��������ʧ��!");
		}
		finally {
			//�ͷ���Դ�����ݿ����ӳ�
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("�ر���Դʧ��!");
			}
		}
		return users1;
	}
	public boolean login(Users users) {
		 //��дsql
		String sql = "select * from userinfo where user_name=? and user_pwd=?";
		//2 ��ӡsql
		 System.out.println("sql-->"+sql);
		 //3 �������
		 Object params[] = {users.getUser_name(),users.getUser_pwd()};
		 
		 Users users1 = null;
		 try {
			users1 =  queryRunner.query(sql, new BeanHandler<Users>(Users.class), params);
		    if(users1!=null){
		    	return true;
		    }
		 } catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��������ʧ��!");
		}
		finally {
			//�ͷ���Դ�����ݿ����ӳ�
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("�ر���Դʧ��!");
			}
		}
		
		return false;
	}

}
