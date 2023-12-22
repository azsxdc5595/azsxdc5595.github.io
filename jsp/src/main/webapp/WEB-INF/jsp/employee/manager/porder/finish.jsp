<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="utf-8"
    import="com.example.demo.vo.porder"
    import="com.example.demo.vo.member"%>
 <%
porder p=(porder)session.getAttribute("P");
 
member m=(member)session.getAttribute("M");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
			這是新的訂位詳細資料
		<tr>
			<td width=100>桌號
			<td><%=p.getDeskno() %>
		<tr>
			<td>日期
			<td><%=p.getOrdertime() %>
		<tr>
			<td>人數
			<td><%=p.getNumber() %>
		<tr>
			<td>電話
			<td><%=p.getPhone() %>
		<tr>
			<td colspan=2 align=center>
			<a href="/employee/system">回管理系統</a>
			
	</table>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>

</body>
</html>