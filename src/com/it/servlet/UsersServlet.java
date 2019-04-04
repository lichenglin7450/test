package com.it.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.it.bean.Users;
import com.it.service.IUsers;
import com.it.service.UsersImpl;
import com.it.utils.StringUtil;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet({ "/UsersServlet", "/user.do" })
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersServlet() {
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
		// 1 设置编码格式
		request.setCharacterEncoding("utf-8");
		// 2 获取opt
		String opt = request.getParameter("opt");
		// 3 获取页面信息
		String user_name = request.getParameter("user_name");
		String user_pwd = request.getParameter("user_pwd");
		// 4 生成对象
		Users users = new Users();
		// 5 调用service
		IUsers iUsers = new UsersImpl();
		// 6 生成session
		HttpSession session = request.getSession();
		boolean flag = false;

		// 6  判断要实现的功能
		if ("login".equals(opt)) {
			if (StringUtil.isNotEmpty(user_name)) {
				users.setUser_name(user_name);
			}
			if (StringUtil.isNotEmpty(user_pwd)) {
				users.setUser_pwd(user_pwd);
			}
			//执行
			flag = iUsers.login(users);
			if(flag){
				Users users1 = iUsers.findUsersByName(users);
				System.out.println("userservlet"+users1);
				
				session.setAttribute("users1", users1);
				response.sendRedirect("index.jsp");
			}else{
				response.sendRedirect("login.html");
			}

		}
		if ("reg".equals(opt)) {

		}

	}

}
