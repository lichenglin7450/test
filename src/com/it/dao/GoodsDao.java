package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.it.bean.GoodsInfo;
import com.it.utils.JDBCUtils;

public class GoodsDao {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	// ��
	public List<GoodsInfo> queryAllGoods(GoodsInfo goods) {
		 //��дsql
		String sql = "select * from goodsInfo where 1=1 ";
		/*if(goods!=null){
			//�ж��˻������ı���ĺϷ���
			// "" null�ж�
			if(!"".equals(goods.getUser_name()) && goods.getUser_name()!=null) {
				
				//ƴ��sql
				sql+="and user_name like '%"+users.getUser_name()+"%' ";
				
			}
			
			if(!"".equals(new Integer(users.getUser_age())) && users.getUser_age()!=0) {
				sql+=" and user_age like '%"+users.getUser_age()+"%'";
				
			}
		}*/
		
		System.out.println("sql-->"+sql);
		//�������Users��Ϣ
		List<GoodsInfo> listU = null;
		try {
			listU = queryRunner.query(sql, new BeanListHandler<>(GoodsInfo.class));
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
	public GoodsInfo findGoodsById(GoodsInfo goods) {
		 //��дsql
		String sql = "select * from goodsInfo where goods_Id=?";
		//2 ��ӡsql
		 System.out.println("sql-->"+sql);
		 //3 �������
		 Object params[] = {goods.getGoods_Id()};
		 
		 GoodsInfo good = null;
		 try {
			 good =  queryRunner.query(sql, new BeanHandler<GoodsInfo>(GoodsInfo.class), params);
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
		return good;
	}
}
