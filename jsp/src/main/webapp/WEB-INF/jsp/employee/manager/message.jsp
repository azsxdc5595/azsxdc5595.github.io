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
</head>
<body>
	<h2>所有留言</h2>	
	<table border=1>
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
</body>
</html>