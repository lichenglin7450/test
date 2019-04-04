<%@page import="com.it.bean.GoodsInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<style>
body {
	text-align: center;
}

table {
	border: 1px solid blue;
	width: 600px;
	height: 300px;
	margin-top: 50px;
	border-collapse: collapse;
}

form {
	width: 600px;
}

td, th {
	border: 1px solid black;
	text-align: center
}

a {
	text-decoration: none
}
</style>
</head>
<body>
<center>
		<h1>

			<marquee>
				<font color="red">欢迎进入本网站！！！！！！</font>
			</marquee>
		</h1>


	</center>
	<%
		List<GoodsInfo> goodsInfo1 =(List<GoodsInfo>) request.getAttribute("goodsInfo");
	%>
	<table align="center">
		<tr>
			<th>序号</th>
			<th>商品编号</th>
			<th>商品名</th>
			<th>价格</th>
			<th>操作</th>
		</tr>
		<%
			for(int i=0;i<goodsInfo1.size();i++){
			
		%>
		<tr>
			<td><%=i+1 %></td>
			<td><%=goodsInfo1.get(i).getGoods_Id() %></td>
			<td><%=goodsInfo1.get(i).getGoods_Name() %></td>
			<td><%=goodsInfo1.get(i).getGoods_Price() %></td>
			<td><a href="buy.do?opt=buy&goods_Id=<%=goodsInfo1.get(i).getGoods_Id() %>">添加到购物车</a></td>
		</tr>
		
		<%} %>
	</table>	

</body>
</html>