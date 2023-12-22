<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.example.demo.vo.employee"%>
<%
employee e = (employee) session.getAttribute("E");
%>
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
<h1><%=e.getName()%>，歡迎登入</h1><br>
	<a href="/employee/system2">進入管理系統</a>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>
	
</body>
</html>