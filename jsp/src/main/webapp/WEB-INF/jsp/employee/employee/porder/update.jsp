<%@ page contentType="text/html;charset=UTF-8" language="java"
    import="com.example.demo.vo.porder" 
    import="java.util.*"%>
<% porder p = (porder)session.getAttribute("U"); 
%>

<html>
<head>
    <title>更新订位信息</title>
<link rel="stylesheet" href="/css/st1.css">
</head>
<body>
<div id="header"><div id="title">Ares system</div></div>
<div id="content">
<div id="contentArea">
<h2>更新订位信息</h2>

    <form action="/porder/update3" method="post">
    <table width=400 align=center border=1>
		<tr>
			<td colspan=3 align=center>這是原本的訂位資料
		<tr>
			<td width=100>原本桌號
			<td><%=p.getDeskno() %>
		<tr>
			<td>原本日期
			<td><%=p.getOrdertime() %>
			<td>想要修改的日期
			<input type="date" name="ordertime" required><br>
		<tr>
			<td>原本人數
			<td><%=p.getNumber() %>
			<td>想要修改的人數
			<input type="number" name="number" min="1" oninput="value=value.replace(/[^\d]/g,'')" required><br>
		<tr>
			<td>原本電話
			<td><%=p.getPhone() %>
			<td>想要修改的電話
			<input type="tel" name="phone" required><br>
		<tr>
			<td colspan=3 align=center>
			<a href="/employee/system2">回管理系統</a>
			<input type="submit" value="確定">
	</table>
    </form>
        

</div>
</div>
<div id="main"></div>
<div id="footer"></div>
    
</body>
</html>
