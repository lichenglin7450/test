<%@page import="java.util.*,com.it.bean.GoodsDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单页面</title>
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
	function queryAllOrderDetails(id) {
		alert(id);
		window.location.href = "order.do?opt=queryAllOrderDetails&ord_id="+id;
	}
	function queryAllOrderTracks(id) {
		window.location.href = "order.do?opt=queryAllOrderTracks&ord_id=" +id;
	}
	function returnShowGoods() {
		window.location.href = "showGoods.jsp";
	}
	function returnShowCar() {
		window.location.href = "showCar.jsp";
	}
</script>
</head>
<body>
	<center>

		<br> <br>
		<center>
			<h1>
				<font color="greed">订单页面</font>
			</h1>


		</center>

		<table align="center" width="600px">
			<tr>
				<th>序号</th>
				<th>订单编号</th>
				<th>用户名</th>
				<th>总价</th>
				<th>操作</th>
			</tr>

			<c:forEach var="listO" items="${listO}" varStatus="i">


				<tr>
					<td>${i.index+1 }</td>
					<td>${listO.ord_id}</td>
					<td>${listO.user_name}</td>
					<td>${listO.total}&nbsp;RMB</td>
					<td><input type="button" id="queryAllOrderDetails"
						value="查看明细" onclick="queryAllOrderDetails('${listO.ord_id}')" />
						&nbsp; <input type="button" id="queryAllOrderTracks" value="查看状态"
						onclick="queryAllOrderTracks('${listO.ord_id}')" />
					</td>
					<%-- <td>
						<a href="../order.do?opt=queryAllOrderDetails&ord_id=${listO.ord_id}">查看明细</a>
						<a href="../order.do?opt=queryAllOrderTracks&ord_id=${listO.ord_id}">查看状态</a>
					</td> --%>	
				</tr>
			</c:forEach>
		</table>
		<br> <input type="button" id="returnShowGoods" value="返回商品列表"
			onclick="returnShowGoods()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" id="returnShowCar" value="查看购物车"
			onclick="returnShowCar()" />
	</center>
</body>
</html>