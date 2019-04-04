package com.it.service;

import java.util.List;

import com.it.bean.OrderDetail;
import com.it.bean.OrderForm;
import com.it.bean.OrderTrack;

public interface IOrders {
	public boolean addOrders(OrderForm orderform);
	public boolean addOrderDetails(OrderDetail orderDetail);
	public boolean addOrderTrack(OrderTrack orderTrack);
	public List<OrderForm> queryAllOrders(OrderForm orderform);
	public List<OrderDetail> queryAllOrderDetails(OrderDetail orderDetail);
	public List<OrderTrack> queryAllOrderTracks(OrderTrack orderTrack);
}
