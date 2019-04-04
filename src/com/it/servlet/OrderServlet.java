package com.it.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.it.bean.GoodsDetails;
import com.it.bean.OrderDetail;
import com.it.bean.OrderForm;
import com.it.bean.OrderTrack;
import com.it.bean.Users;
import com.it.service.IOrders;
import com.it.service.OrdersImpl;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet({ "/OrderServlet", "/order.do" })
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ���ñ����ʽ
		response.setCharacterEncoding("utf-8");
		// ��ȡҳ����Ϣ
		//String opt = request.getParameter("opt");
		String opt = new String(request.getParameter("opt").getBytes("iso-8859-1"), "utf-8");
		
		// ���ɶ���
		OrderForm orderForm = new OrderForm();
		OrderDetail orderDetail = new OrderDetail();
		OrderTrack orderTrack = new OrderTrack();
		// ����service
		IOrders iOrders = new OrdersImpl();
		//session
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users1");
		// ��ȡ���ﳵ�е��ܽ��
		List<GoodsDetails> car = (List<GoodsDetails>) session.getAttribute("car");
		// �ж�ҵ��
		if ("addOrder".equals(opt)) {
			// ����orderId
			String ord_id = UUID.randomUUID().toString();
			// ��ȡsession�Լ�session�д��user_id��user_name
			
			System.out.println("orderservlet"+users);
			//String user_id =String.valueOf(users.getUser_id()) ;
			int user_id = users.getUser_id();
			String user_name = users.getUser_name();
			
			String total = request.getParameter("total");
			// 1 ��������ֵ
			orderForm.setOrd_id(ord_id);
			System.out.println(ord_id);
			orderForm.setUser_id(user_id);
			System.out.println(user_id);
			orderForm.setUser_name(user_name);
			System.out.println(user_name);
			orderForm.setTotal(total);
			System.out.println(total);
			boolean flag =  iOrders.addOrders(orderForm);

			
			
			// 4��ת������ҳ��
			
			if (flag) {
				// 2 ������ϸ--��ϸid���û�������Ʒ�������������ۣ�С�� �����ɶ���ʱ��
				for (int i = 0; i < car.size(); i++) {
					// ����mx_id
					String mx_id = UUID.randomUUID().toString();
					orderDetail.setMx_id(mx_id);
					orderDetail.setOrd_count(String.valueOf(car.get(i).getCount()));
					orderDetail.setGoods_name(car.get(i).getGoodsInfo()
							.getGoods_Name());
					orderDetail.setOrd_id(ord_id);
					orderDetail
							.setGoods_id(car.get(i).getGoodsInfo().getGoods_Id());
					iOrders.addOrderDetails(orderDetail);
					
				}
				// 3 ����׷��
				String zz_id = UUID.randomUUID().toString();
				// 3-1���ɶ���״̬
				int ord_state = new Random().nextInt(8) + 1;
				// 3-2���ɶ�������ʱ��(ϵͳ��ǰʱ��)
				Long time = System.currentTimeMillis();
				Date date = new Date(time);
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				String tm = dateFormat.format(date);
				// 3-3������׷�ٸ�ֵ
				orderTrack.setZz_id(zz_id);
				orderTrack.setOrd_id(ord_id);
				orderTrack.setOrd_state(String.valueOf(ord_state));
				orderTrack.setTm(tm);
				iOrders.addOrderTrack(orderTrack);
				response.sendRedirect("order.do?opt=queryAllOrders");
			} else {
				response.sendRedirect("error.jsp");
			}
			
			return;

		}
		
		if ("queryAllOrders".equals(opt)) {
			/*
			 * // ��ȡģ����ѯorderid String orderid =
			 * request.getParameter("orderid"); // ��ȡģ����ѯuserid String userid =
			 * request.getParameter("userid"); // ģ����ѯ // "" null if
			 * (!"".equals(orderid) && orderid != null) {
			 * orderForm.setOrd_id(orderid); } if (!"".equals(userid) && userid
			 * != null) { orderForm.setUser_id(userid); ; }
			 */
			
			//System.out.println(users.toString());
			int user_id = users.getUser_id();
			orderForm.setUser_id(user_id);
			List<OrderForm> listO = iOrders.queryAllOrders(orderForm);
			request.setAttribute("listO", listO);
			request.getRequestDispatcher("jsp/queryAllOrders.jsp").forward(
					request, response);

		}
		if ("queryAllOrderDetails".equals(opt)) {
			//String ord_id = new String(request.getParameter("ord_id").getBytes("iso-8859-1"), "utf-8");
			String ord_id=request.getParameter("ord_id");
			orderDetail.setOrd_id(ord_id);
			System.out.println(ord_id);
			List<OrderDetail> list = iOrders.queryAllOrderDetails(orderDetail);
			System.out.println(list);
			request.setAttribute("list", list);
			request.getRequestDispatcher("jsp/queryAllOrderDetails.jsp")
					.forward(request, response);
		}
		if ("queryAllOrderTracks".equals(opt)) {
			String ord_id = new String(request.getParameter("ord_id").getBytes(
					"iso-8859-1"), "utf-8");
			orderTrack.setOrd_id(ord_id);
			List<OrderTrack> list = iOrders.queryAllOrderTracks(orderTrack);
			request.setAttribute("list", list);
			request.getRequestDispatcher("jsp/queryAllOrderTracks.jsp")
					.forward(request, response);
		}

	}

}
