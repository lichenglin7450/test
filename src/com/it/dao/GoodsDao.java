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
	// 查
	public List<GoodsInfo> queryAllGoods(GoodsInfo goods) {
		 //编写sql
		String sql = "select * from goodsInfo where 1=1 ";
		/*if(goods!=null){
			//判定账户名的文本框的合法性
			// "" null判定
			if(!"".equals(goods.getUser_name()) && goods.getUser_name()!=null) {
				
				//拼接sql
				sql+="and user_name like '%"+users.getUser_name()+"%' ";
				
			}
			
			if(!"".equals(new Integer(users.getUser_age())) && users.getUser_age()!=0) {
				sql+=" and user_age like '%"+users.getUser_age()+"%'";
				
			}
		}*/
		
		System.out.println("sql-->"+sql);
		//存放所有Users信息
		List<GoodsInfo> listU = null;
		try {
			listU = queryRunner.query(sql, new BeanListHandler<>(GoodsInfo.class));
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
	public GoodsInfo findGoodsById(GoodsInfo goods) {
		 //编写sql
		String sql = "select * from goodsInfo where goods_Id=?";
		//2 打印sql
		 System.out.println("sql-->"+sql);
		 //3 处理参数
		 Object params[] = {goods.getGoods_Id()};
		 
		 GoodsInfo good = null;
		 try {
			 good =  queryRunner.query(sql, new BeanHandler<GoodsInfo>(GoodsInfo.class), params);
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
		return good;
	}
}
