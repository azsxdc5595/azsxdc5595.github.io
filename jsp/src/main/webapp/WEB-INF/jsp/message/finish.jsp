<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.message"%>
<%
message m=(message)session.getAttribute("message");
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
<h1>請確認新增的文章內容</h1>
<form action="/message/finish" method="post">
<table align=center border=1>
	<tr>
		<td aligh=center>會員編號
		<td><%=m.getMemberno() %>
	<tr>
		<td>文章標題
		<td><%=m.getTitle() %>
	<tr>
		<td>文章內容
		<td width=500><%=m.getContent() %>
	<tr>
		<td colspan=2 aligh=center>
		<input type="submit" value="確認送出"><br>
		<a href="/member/function">返回會員專區</a>
</table>
</form>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>

</body>
</html>