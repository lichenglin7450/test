package com.it.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.it.bean.GoodsDetails;
import com.it.bean.GoodsInfo;
import com.it.service.CarService;
import com.it.service.GoodsImpl;
import com.it.service.IGoods;
import com.it.utils.StringUtil;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet({ "/BuyServlet", "/buy.do" })
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		//获取页面信息
		String opt = request.getParameter("opt");
		String goods_Id = request.getParameter("goods_Id");
		String count = request.getParameter("count");
		//生成对象
		GoodsInfo goodsInfo = new GoodsInfo();
		IGoods iGoods = new GoodsImpl();
		//购物车
		List<GoodsDetails> car=null;
		//生成session
		HttpSession session = request.getSession();
		//判断是否是第一次加入购物车
		if(session.getAttribute("car")==null){
			car = new ArrayList<GoodsDetails>();
			session.setAttribute("car",car);
		}
		//否则从session获取
		car = (List<GoodsDetails>) session.getAttribute("car");
		//给车关联service
				CarService carService = new CarService(car);
		//判断业务
		//1 删除商品
		if("del".equals(opt)){
			goodsInfo.setGoods_Id(goods_Id);
			carService.delCar(goodsInfo);
			response.sendRedirect("jsp/showCar.jsp");
			return;
		}
		//2 清空购物车
		if("cls".equals(opt)){
			carService.clear();
			response.sendRedirect("jsp/showCar.jsp");
			return;
		}
		//3 继续购物
		if("buy".equals(opt)){
			if(StringUtil.isNotEmpty(goods_Id)){
				goodsInfo.setGoods_Id(goods_Id);
			}
			GoodsInfo goodsInof3 =iGoods.findGoodsById(goodsInfo);
			carService.addCar(goodsInof3,1);
			response.sendRedirect("jsp/showCar.jsp");
			return;
		}
		//4 修改数量
		if("upd".equals(opt)){
			System.out.println(goods_Id+"\t"+count);
			goodsInfo.setGoods_Id(goods_Id);
			carService.updCar(goodsInfo, Integer.parseInt(count));
			response.sendRedirect("jsp/showCar.jsp");
			return;
		}
	}

}
