<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.example.demo.vo.activity"%>
<%activity a=(activity)session.getAttribute("D");%>
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
<form action="/activity/delete" method="post">
<h1>是否取消活動?</h1>
<a href="/employee/system">回管理系統</a><br>
<input type="hidden" name="id">
<input type="submit" value="確定取消">
</form>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>

</body>
</html>