<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
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
<form action="/porder/confirm3" method="post">
		桌號:<select name="deskno">
		<option value="C1">C1</option>	
    	<option value="B3">B3</option>		
    	<option value="B2">B2</option>		
    	<option value="B1">B1</option>		
    	<option value="A3">A3</option>			
    	<option value="A2">A2</option>
    	<option value="A1" selected>A1</option>
		</select><br> 
		日期:<input type="date" name="ordertime" required><br> 
		人數:<input type="number" name="number" min="1" oninput="value=value.replace(/[^\d]/g,'')" required><br>
		電話:<input type="tel" name="phone" required><br> 
		<input type="submit" value="ok"><br>
		<a href="/employee/system2">回管理系統</a>
	</form>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>
	
</body>
</html>