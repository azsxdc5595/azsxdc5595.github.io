<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.message"
    import="java.util.*"%>
<%List<message> m=(List<message>)session.getAttribute("messages");%>
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
<div id="contentArea2">
<span style=font-size:20pt><B>所有留言</B></span>
	<table border=1 align=center>
		<thead>
			<tr>
				<th>會員名</th>
				<th>文章標題</th>
				<th>文章內容</th>
			</tr>
		</thead>
		<tbody>
			<%
			for(message message:m){
			%>
			<tr>
				<td><%=message.getMemberno() %></td>
				<td><%=message.getTitle() %></td>
				<td><%=message.getContent() %></td>
			<%} %>
		</tbody>
	</table>
	<a href="/employee/system">返回管理系統</a>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>
	
</body>
</html>