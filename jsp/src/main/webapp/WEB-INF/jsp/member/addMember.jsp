<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/st1.css">
</head>
<body>
<div id="header"><div id="title">Ares system</div></div>
<div id="content">
<div id="contentArea">
<form action="/member/add" method="post">
�m�W:<input type="text" name="name" required><br>
�b��:<input type="text" name="username" required><br>
�K�X:<input type="password" name="password" minlength="6" required><br>
e-mail:<input type="text" name="email" required><br>
<input type="submit" value="ok">
</form>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>

</body>
</html>