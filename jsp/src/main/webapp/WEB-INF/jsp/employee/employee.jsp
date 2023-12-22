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
<h3>員工系統</h3>
<form action="/employee/login" method="post">
帳號:<input type="text" name="username">
密碼:<input type="password" name="password">
<input type="submit" value="ok">
</form>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>

</body>
</html>