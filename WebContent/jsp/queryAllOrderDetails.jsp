<%@page import="java.util.*,com.it.bean.GoodsDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详情页面</title>
<style>
body {
	text-align: center;
}

table {
	border: 1px solid blue;
	width: 800px;
	height: 300px;
	margin-top: 50px;
	border-collapse: collapse;
}

form {
	width: 800px;
}

td, th {
	border: 1px solid black;
	text-align: center
}

a {
	text-decoration: none
}
</style>
<script src="../js/jquery-2.1.0.js"></script>
<script type="text/javascript">
	function returnOrder() {
		window.location.href = "order.do?opt=queryAllOrders";
	}
</script>
</head>
<body>
	<center>

		<br> <br>
		<center>
			<h1>
				<font color="greed">订单明细页面</font>
			</h1>


		</center>

		<table align="center" width="600px">
			<tr>
				<th>序号</th>
				<th>订单明细编号</th>
				<th>订单编号</th>
				<th>商品名</th>
				<th>数量</th>
			</tr>

			<c:forEach var="list" items="${list}" varStatus="i">


				<tr>
					<td>${i.index+1 }</td>
					<td>${list.mx_id}</td>
					<td>${list.ord_id}</td>
					<td>${list.goods_name}</td>
					<td>${list.ord_count}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<input type="button" id="returnOrder" value="返回订单"
						onclick="returnOrder()" />
	</center>
</body>
</html>