<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.example.demo.vo.message,java.util.*"%>
<%
List<message> m = (List<message>) session.getAttribute("Q");
%>
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
<table border=1 align=center>
		<thead>
			<tr>
				<th>會員編號</th>
				<th>文章標題</th>
				<th>文章內容</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (message message : m) {
			%>
			<tr>
				<td><%=message.getMemberno() %></td>
				<td><%=message.getTitle() %></td>		
				<td><%=message.getContent() %></td>
				<td><a href="/message/gotoUpdate?id=<%=message.getId() %>&title=<%=message.getTitle()%>&content=<%=message.getContent()%>">更改這則留言</a>
				<td><a href="/message/gotoDelete?id=<%=message.getId()%>">刪除這則留言</a>
			<%
			}
			%>
				
		</tbody>
	</table>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>
	
</body>
</html>