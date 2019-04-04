<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<center><br><br><br><br><br><br>
欢迎<font color="red" size="5">${users1.user_name }</font>登录本网站！
<h2>
<a href="show.do">查看商品</a>&nbsp;&nbsp;&nbsp;
<a href="jsp/showCar.jsp">查看购物车</a>&nbsp;&nbsp;&nbsp;
<a href="order.do?opt=queryAllOrders">查看订单</a>
</h2>
</center>
</body>
</html>