package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.it.bean.OrderDetail;
import com.it.bean.OrderForm;
import com.it.bean.OrderTrack;
import com.it.bean.Users;
import com.it.utils.JDBCUtils;

public class OrdersDao {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

	// 增加订单
	public boolean addOrders(OrderForm orderform) {
		// 1 编写sql
		String sql = "insert into orderform(ord_id,user_id,user_name,total)values(?,?,?,?)";
		// 2 打印sql
		System.out.println("sql-->" + sql);
		// 3 处理参数
		Object params[] = { orderform.getOrd_id(), orderform.getUser_id(),orderform.getUser_name(),
				orderform.getTotal() };
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

	// 增加订单明细
	public boolean addOrderDetails(OrderDetail orderDetail) {
		// 1 编写sql
		String sql = "insert into orderdetail(mx_id,ord_count,ord_id,goods_id,goods_name)values(?,?,?,?,?)";
		// 2 打印sql
		System.out.println("sql-->" + sql);
		// 3 处理参数
		Object params[] = { orderDetail.getMx_id(), orderDetail.getOrd_count(),
				orderDetail.getOrd_id(), orderDetail.getGoods_id(),orderDetail.getGoods_name() };
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

	// 增加订单追踪
	public boolean addOrderTrack(OrderTrack orderTrack) {
		// 1 编写sql
		String sql = "insert into ordertrack(zz_id,ord_id,ord_state,tm)values(?,?,?,?)";
		// 2 打印sql
		System.out.println("sql-->" + sql);
		// 3 处理参数
		Object params[] = { orderTrack.getZz_id(), orderTrack.getOrd_id(),
				orderTrack.getOrd_state(), orderTrack.getTm() };
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

	// 查询所有订单
	public List<OrderForm> queryAllOrderForms(OrderForm orderForm) {
		// 编写sql
		String sql = "select * from orderform where 1=1 and user_id=?";
		Object[] params={orderForm.getUser_id()};
		/*// 模糊查询
		if (orderForm != null) {
			// 判定账户名的文本框的合法性
			// "" null判定
			if (!"".equals(orderForm.getOrd_id())
					&& orderForm.getOrd_id() != null) {

				// 拼接sql
				sql += "and ord_id like '%" + orderForm.getOrd_id() + "%' ";

			}

			if (!"".equals(orderForm.getUser_id())
					&& orderForm.getUser_id() != null) {

				// 拼接sql
				sql += "and user_id like '%" + orderForm.getUser_id() + "%' ";

			}
		}*/

		System.out.println("sql-->" + sql);
		// 存放所有OrderForm信息
		List<OrderForm> listO = null;
		try {
			listO = queryRunner.query(sql, new BeanListHandler<>(OrderForm.class),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
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
		return listO;
	}
	// 查询所有订单明细
		public List<OrderDetail> queryAllOrderDetails(OrderDetail orderDetail) {
			// 编写sql
			String sql = "select * from orderdetail where ord_id=? ";
			Object[] params={orderDetail.getOrd_id()};
			
			System.out.println("sql-->" + sql);
			// 存放所有OrderForm信息
			List<OrderDetail> listO = null;
			try {
				listO = queryRunner.query(sql,new BeanListHandler<>(OrderDetail.class),params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("查询数据失败!");
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
			return listO;
		}
		// 查询所有订单追踪
		public List<OrderTrack> queryAllOrderTracks(OrderTrack orderTrack) {
			// 编写sql
			String sql = "select * from ordertrack where ord_id=? ";
			Object[] params={orderTrack.getOrd_id()};
			System.out.println("sql-->" + sql);
			// 存放所有OrderForm信息
			List<OrderTrack> listO = null;
			try {
				listO = queryRunner.query(sql, new BeanListHandler<>(OrderTrack.class),params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("查询数据失败!");
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
			return listO;
		}
}
