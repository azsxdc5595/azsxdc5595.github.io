<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.employee"
    import="java.util.*"%>
<%List<employee> e=(List<employee>)session.getAttribute("employees"); %>
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
<h1>所有員工</h1>
<table border="1" align=center>
		<thead>
			<tr>
				<th>員工id</th>
				<th>員工編號</th>
				<th>姓名</th>
				<th>員工電話</th>
				<th>職位</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (employee employee : e) {
			%>
			<tr>
				<td><%=employee.getId()%></td>
				<td><%=employee.getEmployeeno()%></td>
				<td><%=employee.getName()%></td>
				<td><%=employee.getPhone()%></td>
				<td><%=employee.getType()%></td>				
				<td><a href="/employee/changePosition?employeeName=<%=employee.getName()%>&employeeType=<%=employee.getType()%>">更改員工職位</a></td>
				<td><a href="/employee/gotoDeleteEmployee?employeeId=<%=employee.getId()%>">刪除員工資料</a></td>
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