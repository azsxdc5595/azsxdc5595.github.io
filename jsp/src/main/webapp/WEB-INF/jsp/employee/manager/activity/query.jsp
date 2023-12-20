<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.example.demo.vo.activity,java.util.*"%>
<%List<activity> a=(List<activity>)session.getAttribute("A"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1 align=center>
		<thead>
			<tr>
				<th>活動編號
				<th>活動名稱
				<th>內容
				<th>活動時間
			</tr>
		</thead>
		<tbody>
			<%for(activity activity:a){ %>
			<tr>
				<td align=center><%=activity.getId() %>
				<td><%=activity.getName() %>
				<td><%=activity.getContent() %>
				<td><%=activity.getEventtime() %>
				<td><a href="gotoUpdate?id=<%=activity.getId() %>">更改這個活動</a>
				<td><a href="gotoDelete?id=<%=activity.getId() %>">取消這個活動</a>
			</tr>	
			<%} %>
		</tbody>
	</table>
</body>
</html>