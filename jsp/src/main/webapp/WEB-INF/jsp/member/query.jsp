<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.example.demo.vo.member"%>
<%member m=(member)session.getAttribute("M"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width=400 border=1 align=center>
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
	
</body>
</html>