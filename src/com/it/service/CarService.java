package com.it.service;

import java.util.List;

import com.it.bean.GoodsDetails;
import com.it.bean.GoodsInfo;

/**
 * 
 * Title:���ﳵ����
 * Description:com.it.service.CarService.java
 * Copyright: Copyright (c) j2se 8.0
 * date: 2019��2��20������5:24:45
 * Company:gy
 * @author lcl
 */
public class CarService {
	//���ﳵ�������Ʒ�ļ���
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
	
	//���ָ����Ʒ�����ﳵ
	public void addCar(GoodsInfo goodsInfo,int count){
		//�Ƿ��ǵ�һ����ӣ� �� ֱ����� 2 ����Ѿ����ˣ��޸�����
		//�ж���Ʒ�Ƿ����,����������1
		for (GoodsDetails goodsDetails : car) {
			if(goodsDetails.getGoodsInfo().getGoods_Id().equals(goodsInfo.getGoods_Id())){
				goodsDetails.setCount(goodsDetails.getCount()+count);
				return;
			}
		}
		//�����ڣ���������ﳵ
		car.add(new GoodsDetails(goodsInfo,count));
	}

	 //ɾ��ָ����Ʒ
	public void delCar(GoodsInfo goodsInfo){
		for (GoodsDetails goodsDetails : car) {
			if(goodsDetails.getGoodsInfo().getGoods_Id().equals(goodsInfo.getGoods_Id())){
				car.remove(goodsDetails);
				return;
			}
		}
		
	}

	//�޸�ָ����Ʒ������
	public void updCar(GoodsInfo goodsInfo, int count){
		for (GoodsDetails goodsDetails : car) {
			if(goodsDetails.getGoodsInfo().getGoods_Id().equals(goodsInfo.getGoods_Id())){
				goodsDetails.setCount(count);
				return;
			}
		}
	}



	//��չ��ﳵ
	public void clear(){
		car.clear();
	}


}
