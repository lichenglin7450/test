package com.it.service;

import java.util.List;

import com.it.bean.GoodsDetails;
import com.it.bean.GoodsInfo;

/**
 * 
 * Title:购物车操作
 * Description:com.it.service.CarService.java
 * Copyright: Copyright (c) j2se 8.0
 * date: 2019年2月20日下午5:24:45
 * Company:gy
 * @author lcl
 */
public class CarService {
	//购物车：存放商品的集合
	List<GoodsDetails> car;

	public List<GoodsDetails> getCar() {
		return car;
	}

	public void setCar(List<GoodsDetails> car) {
		this.car = car;
	}

	public CarService(List<GoodsDetails> car) {
		super();
		this.car = car;
	}

	public CarService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//添加指定商品到购物车
	public void addCar(GoodsInfo goodsInfo,int count){
		//是否是第一次添加？ 是 直接添加 2 如果已经有了，修改数量
		//判断商品是否存在,存在数量加1
		for (GoodsDetails goodsDetails : car) {
			if(goodsDetails.getGoodsInfo().getGoods_Id().equals(goodsInfo.getGoods_Id())){
				goodsDetails.setCount(goodsDetails.getCount()+count);
				return;
			}
		}
		//不存在，添加至购物车
		car.add(new GoodsDetails(goodsInfo,count));
	}

	 //删除指定商品
	public void delCar(GoodsInfo goodsInfo){
		for (GoodsDetails goodsDetails : car) {
			if(goodsDetails.getGoodsInfo().getGoods_Id().equals(goodsInfo.getGoods_Id())){
				car.remove(goodsDetails);
				return;
			}
		}
		
	}

	//修改指定商品的数量
	public void updCar(GoodsInfo goodsInfo, int count){
		for (GoodsDetails goodsDetails : car) {
			if(goodsDetails.getGoodsInfo().getGoods_Id().equals(goodsInfo.getGoods_Id())){
				goodsDetails.setCount(count);
				return;
			}
		}
	}



	//清空购物车
	public void clear(){
		car.clear();
	}


}
