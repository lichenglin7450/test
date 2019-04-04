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

	// ���Ӷ���
	public boolean addOrders(OrderForm orderform) {
		// 1 ��дsql
		String sql = "insert into orderform(ord_id,user_id,user_name,total)values(?,?,?,?)";
		// 2 ��ӡsql
		System.out.println("sql-->" + sql);
		// 3 �������
		Object params[] = { orderform.getOrd_id(), orderform.getUser_id(),orderform.getUser_name(),
				orderform.getTotal() };
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

	// ���Ӷ�����ϸ
	public boolean addOrderDetails(OrderDetail orderDetail) {
		// 1 ��дsql
		String sql = "insert into orderdetail(mx_id,ord_count,ord_id,goods_id,goods_name)values(?,?,?,?,?)";
		// 2 ��ӡsql
		System.out.println("sql-->" + sql);
		// 3 �������
		Object params[] = { orderDetail.getMx_id(), orderDetail.getOrd_count(),
				orderDetail.getOrd_id(), orderDetail.getGoods_id(),orderDetail.getGoods_name() };
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

	// ���Ӷ���׷��
	public boolean addOrderTrack(OrderTrack orderTrack) {
		// 1 ��дsql
		String sql = "insert into ordertrack(zz_id,ord_id,ord_state,tm)values(?,?,?,?)";
		// 2 ��ӡsql
		System.out.println("sql-->" + sql);
		// 3 �������
		Object params[] = { orderTrack.getZz_id(), orderTrack.getOrd_id(),
				orderTrack.getOrd_state(), orderTrack.getTm() };
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

	// ��ѯ���ж���
	public List<OrderForm> queryAllOrderForms(OrderForm orderForm) {
		// ��дsql
		String sql = "select * from orderform where 1=1 and user_id=?";
		Object[] params={orderForm.getUser_id()};
		/*// ģ����ѯ
		if (orderForm != null) {
			// �ж��˻������ı���ĺϷ���
			// "" null�ж�
			if (!"".equals(orderForm.getOrd_id())
					&& orderForm.getOrd_id() != null) {

				// ƴ��sql
				sql += "and ord_id like '%" + orderForm.getOrd_id() + "%' ";

			}

			if (!"".equals(orderForm.getUser_id())
					&& orderForm.getUser_id() != null) {

				// ƴ��sql
				sql += "and user_id like '%" + orderForm.getUser_id() + "%' ";

			}
		}*/

		System.out.println("sql-->" + sql);
		// �������OrderForm��Ϣ
		List<OrderForm> listO = null;
		try {
			listO = queryRunner.query(sql, new BeanListHandler<>(OrderForm.class),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("��ѯ����ʧ��!");
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
		return listO;
	}
	// ��ѯ���ж�����ϸ
		public List<OrderDetail> queryAllOrderDetails(OrderDetail orderDetail) {
			// ��дsql
			String sql = "select * from orderdetail where ord_id=? ";
			Object[] params={orderDetail.getOrd_id()};
			
			System.out.println("sql-->" + sql);
			// �������OrderForm��Ϣ
			List<OrderDetail> listO = null;
			try {
				listO = queryRunner.query(sql,new BeanListHandler<>(OrderDetail.class),params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("��ѯ����ʧ��!");
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
			return listO;
		}
		// ��ѯ���ж���׷��
		public List<OrderTrack> queryAllOrderTracks(OrderTrack orderTrack) {
			// ��дsql
			String sql = "select * from ordertrack where ord_id=? ";
			Object[] params={orderTrack.getOrd_id()};
			System.out.println("sql-->" + sql);
			// �������OrderForm��Ϣ
			List<OrderTrack> listO = null;
			try {
				listO = queryRunner.query(sql, new BeanListHandler<>(OrderTrack.class),params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("��ѯ����ʧ��!");
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
			return listO;
		}
}
