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
<form action="add" method="post">
活動名稱:<input type="text" name="name" required><br>
內容:<input type="text" name="content" required><br>
活動時間:<input type="text" name="eventtime" required><br>
<input type="submit" value="新增">
</form>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>

</body>
</html>