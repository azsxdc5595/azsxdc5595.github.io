<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.example.demo.vo.activity,java.util.*"%>
<%List<activity> a=(List<activity>)session.getAttribute("A"); %>
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
			</tr>	
			<%} %>
		</tbody>
	</table>
</div>
<br><br><br><br><br>
<a href="/member/function" style="font-size:30px">回會員專區</a>
</div>
<div id="main"></div>
<div id="footer"></div>
	
</body>
</html>