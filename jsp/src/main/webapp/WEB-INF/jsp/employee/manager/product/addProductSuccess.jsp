<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.product"%>
<%product p=(product)session.getAttribute("product"); %>
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
<div id="contentArea">
<h1>新品項<%=p.getProductname() %>成功上架</h1>
<a href="/employee/product">回管理商品資料</a>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>

</body>
</html>