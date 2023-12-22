<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.employee"%>
<%
employee e=(employee)session.getAttribute("E"); %>
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
<table width=400 align=center border=1>
		<tr>
			<td colspan=2 align=center>
			<%=e.getName() %> 這是你的員工資料
		<tr>
			<td width=100>這是你的員工編號
			<td><%=e.getEmployeeno() %>
		<tr>
			<td>這是你的帳號
			<td><%=e.getUsername() %>
		<tr>
			<td>這是你的密碼
			<td><%=e.getPassword() %>
		<tr>
			<td>這是你的電話
			<td><%=e.getPhone() %>
		<tr>
			<td colspan=2 align=center>
			<a href="/employee/managerEmployees">回上一頁</a>
			<a href="/employee/changePassword?employeeName=<%=e.getName()%>&employeePassword=<%=e.getPassword() %>">更改密碼</a>
			<a href="/employee/changePhone?employeeName=<%=e.getName()%>&employeePhone=<%=e.getPhone() %>">更改電話</a>
	</table>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>
	
</body>
</html>