package com.it.service;

import java.util.List;

import com.it.bean.OrderDetail;
import com.it.bean.OrderForm;
import com.it.bean.OrderTrack;
import com.it.dao.OrdersDao;

public class OrdersImpl implements IOrders {
	
	OrdersDao ordersdao = new OrdersDao();

	@Override
	public boolean addOrders(OrderForm orderform) {
		// TODO Auto-generated method stub
		return ordersdao.addOrders(orderform);
	}

	@Override
	public boolean addOrderDetails(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return ordersdao.addOrderDetails(orderDetail);
	}

	@Override
	public boolean addOrderTrack(OrderTrack orderTrack) {
		// TODO Auto-generated method stub
		return ordersdao.addOrderTrack(orderTrack);
	}

	@Override
	public List<OrderForm> queryAllOrders(OrderForm orderform) {
		// TODO Auto-generated method stub
		return ordersdao.queryAllOrderForms(orderform);
	}

	@Override
	public List<OrderDetail> queryAllOrderDetails(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return ordersdao.queryAllOrderDetails(orderDetail);
	}

	@Override
	public List<OrderTrack> queryAllOrderTracks(OrderTrack orderTrack) {
		// TODO Auto-generated method stub
		return ordersdao.queryAllOrderTracks(orderTrack);
	}

}
