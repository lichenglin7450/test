package com.it.service;

import java.util.List;

import com.it.bean.GoodsInfo;

public interface IGoods {
	public List<GoodsInfo> queryAllGoods(GoodsInfo goods) ;
	public GoodsInfo findGoodsById(GoodsInfo goods);
}
