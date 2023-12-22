<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="/product/add" method="post">
	編號:<input type="text" name="productno" required><br>
	品名:<input type="text" name="productname" required><br>
	價目:<input type="text" name="price" oninput="value=value.replace(/[^\d]/g,'')" required><br>
	<input type="submit" value="ok">
	</form>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>
	
</body>
</html>