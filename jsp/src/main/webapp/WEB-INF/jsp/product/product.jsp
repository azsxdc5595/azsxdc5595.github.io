<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.product"
    import="java.util.*"%>
<%List<product> p=(List<product>)session.getAttribute("products"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/st1.css">
</head>
<body>
<div id="header"><div id="title">Ares system</div></div>
<div id="content">

<div id="contentArea2">
<span style=font-size:18px><B>菜單</B></span>
	<table border=1 align=center>
		<thead>
			<tr>
				<th>菜色編號</th>
				<th>品名</th>
				<th>價目</th>
		</thead>
	
		<%for(product product:p){ %>
		<tbody>
		<tr>
			<td><%=product.getProductno() %></td>
			<td><%=product.getProductname() %></td>
			<td><%=product.getPrice() %></td>
	
		<%} %>
		</tbody>
	</table>
	<a href="/member/function">回會員專區</a>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>
    
</body>
</html>