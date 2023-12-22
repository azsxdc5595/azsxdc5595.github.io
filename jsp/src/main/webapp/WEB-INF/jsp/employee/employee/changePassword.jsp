<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.employee"%>
<%
employee e=(employee)session.getAttribute("E");
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
<form action="/employee/changeSuccess2" method="post">
	<table border=1 align=center>
		<tr>
			<td colspan=3 align=center><%=e.getName()%>，請輸入想要的新密碼
		<tr>
			<td width=100>原本密碼
			<td><%=e.getPassword() %>
			<td>新密碼
			<input type="password" name="employeePassword"><br>
		<tr>
			<td colspan=3 align=center>
			<a href="/employee/managerEmployee">回上一頁</a>
			<input type="hidden" name="employeeName" value="<%=e.getName() %>">
			<input type="submit" value="確定">
	</table>
	</form>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>
	
</body>
</html>