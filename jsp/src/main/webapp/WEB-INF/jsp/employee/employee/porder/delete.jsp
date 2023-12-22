<%@ page contentType="text/html;charset=UTF-8" language="java"
    import="com.example.demo.vo.porder"
    import="java.util.*"%>
<% porder p = (porder)session.getAttribute("D"); 
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

    <form action="/porder/delete3" method="post">
    <table width=400 align=center border=1>
		<tr>
			<td colspan=3 align=center>這是原本的訂位資料
		<tr>
			<td width=100>原本桌號
			<td><%=p.getDeskno() %>
		<tr>
			<td>原本日期
			<td><%=p.getOrdertime() %>
		<tr>
			<td>原本人數
			<td><%=p.getNumber() %>

		<tr>
			<td>原本電話
			<td><%=p.getPhone() %>
		<tr>
			<td colspan=3 align=center>
			<a href="/employee/system2">返回管理系統</a>
			<input type="hidden" name="porderId" value="<%=p.getId() %>">
			<input type="submit" value="確定刪除訂位">
	</table>
    </form>
        

</div>
</div>
<div id="main"></div>
<div id="footer"></div>

</body>
</html>
