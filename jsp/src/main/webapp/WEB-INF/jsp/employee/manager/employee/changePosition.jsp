<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.employee"%>
<%employee e=(employee)session.getAttribute("Position"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/employee/changePositionSuccess" method="post">
		<table border=1>
			<tr>
				<td colspan=3 aligh=center>員工姓名，<%=e.getName() %>
			<tr>
				<td width=100>原本職位
				<td><%=e.getType() %>
			<tr>
				<td colspan=3 aligh=center>
				新的職位:
				<select name="newType">
    			<option value="1">課長</option>
    			<option value="0" selected>社員</option>
				</select>
			<tr>
				<td colspan=3 aligh=center>
				<a href="/employee/managerEmployees">回到管理員工資料</a>
				<input type="hidden" name="employeeName" value="<%=e.getName() %>">
				<input type="submit" value="確定">
		</table>
	</form>
</body>
</html>