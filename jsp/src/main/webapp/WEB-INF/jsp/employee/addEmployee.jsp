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
<form action="/employee/add" method="post">
姓名:<input type="text" name="name" required><br>
帳號:<input type="text" name="username" required><br>
密碼:<input type="password" name="password" minlength="6" required><br>
連絡電話:<input type="text" name="number" oninput="value=value.replace(/[^\d]/g,'')" required><br>
請選擇你的職位:
<select name="type">
    <option value="1">課長</option>
    <option value="0" selected>社員</option>
</select>
<input type="submit" value="ok">
</form>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>

</body>
</html>