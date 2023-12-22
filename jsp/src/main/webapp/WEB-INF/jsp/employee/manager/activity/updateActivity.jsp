<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.example.demo.vo.activity"%>
<%activity a=(activity)session.getAttribute("U");%>
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
<form action="/activity/update" method="post">
	<table width=600 border=1 align=center>
		<tr>
			<td>原本的活動名稱
			<td><%=a.getName() %>
			<td>想修改的新名稱
			<td><input type="text" name="name">
		<tr>
			<td>原本的活動內容
			<td><%=a.getContent() %>
			<td>想修改的新內容
			<td><input type="text" name="content">
		<tr>
			<td>原本的活動時間
			<td><%=a.getEventtime() %>
			<td>想修改的新時間
			<td><input type="text" name="eventtime">
		<tr>
			<td colspan=4 align=center>
			<input type="hidden" name="id" value="<%=a.getId()%>">
			<a href="/employee/system">回管理系統</a>
			<input type="submit" value="更改">
	</table>
</form>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>

</body>
</html>