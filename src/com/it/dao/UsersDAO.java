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
	// 增

	public boolean addUsers(Users users) {
		// 1 编写sql
		String sql = "INSERT  INTO `userinfo`(`user_id`,`user_name`,`user_pwd`,`user_addr`,`user_tel`,`user_sex`) VALUES (?,?,?,?,?,?)";
		// 2 打印sql
		System.out.println("sql-->" + sql);
		// 3 处理参数
		Object params[] = {users.getUser_id(),users.getUser_name(),users.getUser_pwd(),users.getUser_addr(),users.getUser_tel(),users.getUser_sex()};
		// 定义标志位

		try {
			int rows = queryRunner.update(sql, params);
			return rows > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			throw new RuntimeException("添加失败!!");
		} finally {
			// 释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
	}

	// 删
	public boolean delUsers(Users users) {
		// 1 编写sql
				String sql = "delete from userinfo where user_id=?";
				// 2 打印sql
				System.out.println("sql-->" + sql);
				// 3 处理参数
				Object params[] = { users.getUser_id() };
				// 定义标志位

				try {
					int rows = queryRunner.update(sql, params);
					return rows > 0;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

					throw new RuntimeException("删除失败!!");
				} finally {
					// 释放资源到数据库连接池
					try {
						DbUtils.close(JDBCUtils.getConnections());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new RuntimeException("关闭资源失败!");
					}
				}

	}

	// 改
	public boolean updUsers(Users users) {
		// 1 编写sql
				String sql = "update userinfo set user_name =?,user_pwd=?,user_addr=?,user_tel=?,user_sex=? where user_id=?";
				// 2 打印sql
				System.out.println("sql-->" + sql);
				System.out.println(users);
				// 3 处理参数
				Object params[] = {users.getUser_name(),users.getUser_pwd(),users.getUser_addr(),users.getUser_tel(),users.getUser_sex(),users.getUser_id() };
				// 定义标志位

				try {
					int rows = queryRunner.update(sql, params);
					return rows > 0;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

					throw new RuntimeException("修改失败!!");
				} finally {
					// 释放资源到数据库连接池
					try {
						DbUtils.close(JDBCUtils.getConnections());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new RuntimeException("关闭资源失败!");
					}
				}
	}

	// 查
	public List<Users> queryAllUsers(Users users) {
		 //编写sql
		String sql = "select * from userinfo where 1=1 ";
		if(users!=null){
			//判定账户名的文本框的合法性
			// "" null判定
			if(!"".equals(users.getUser_name()) && users.getUser_name()!=null) {
				
				//拼接sql
				sql+="and user_name like '%"+users.getUser_name()+"%' ";
				
			}
		}
		
		System.out.println("sql-->"+sql);
		//存放所有Users信息
		List<Users> listU = null;
		try {
			listU = queryRunner.query(sql, new BeanListHandler<>(Users.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
		}
		finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return listU;
	}

	// 查询单个
	public Users findUsersById(Users users) {
		 //编写sql
		String sql = "select * from userinfo where user_id=?";
		//2 打印sql
		 System.out.println("sql-->"+sql);
		 //3 处理参数
		 Object params[] = {users.getUser_id()};
		 
		 Users users1 = null;
		 try {
			users1 =  queryRunner.query(sql, new BeanHandler<Users>(Users.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询单个数据失败!");
		}
		finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return users1;
	}
	
	//用iD查询单个
	public Users findUsersByName(Users users) {
		 //编写sql
		String sql = "select * from userinfo where user_name=? ";
		//2 打印sql
		 System.out.println("sql-->"+sql);
		 //3 处理参数
		 Object params[] = {users.getUser_name()};
		 
		 Users users1 = null;
		 try {
			users1 =  queryRunner.query(sql, new BeanHandler<Users>(Users.class), params);
			System.out.println("users1-->"+users1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询单个数据失败!");
		}
		finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return users1;
	}
	public boolean login(Users users) {
		 //编写sql
		String sql = "select * from userinfo where user_name=? and user_pwd=?";
		//2 打印sql
		 System.out.println("sql-->"+sql);
		 //3 处理参数
		 Object params[] = {users.getUser_name(),users.getUser_pwd()};
		 
		 Users users1 = null;
		 try {
			users1 =  queryRunner.query(sql, new BeanHandler<Users>(Users.class), params);
		    if(users1!=null){
		    	return true;
		    }
		 } catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询单个数据失败!");
		}
		finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		
		return false;
	}

}
