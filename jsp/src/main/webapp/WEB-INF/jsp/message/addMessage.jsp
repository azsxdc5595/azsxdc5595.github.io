<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/st1.css">
</head>
<body>
<div id="header"><div id="title">Ares system</div></div>
<div id="content">
<div id="contentArea">
	<form action="/message/add" method="post">
		文章標題:<input type="text" name="title" required><br>
		文章內容:<input type="text" name="content" required><br>
		<input type="submit" value="送出留言"><br>
		<a href="/member/function">回會員專區</a>
	</form>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>
</body>
</html>