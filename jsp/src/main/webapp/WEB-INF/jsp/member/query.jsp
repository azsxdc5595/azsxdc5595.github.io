<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.example.demo.vo.member"%>
<%member m=(member)session.getAttribute("M"); %>
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
	<table width=400 border=1 align=center>
		<tr>
			<td>會員編號
			<td><%=m.getMemberno() %>
		<tr>
			<td>帳號
			<td><%=m.getUsername() %>
		<tr>
			<td>會員名稱
			<td><%=m.getName() %>
		<tr>
			<td>郵箱
			<td><%=m.getEmail() %>
		<tr>
			<td colspan=2 align=center>
			<a href="/member/function">回會員專區</a>			
	</table>
	
</div>
</div>
<div id="main"></div>
<div id="footer"></div>

</body>
</html>