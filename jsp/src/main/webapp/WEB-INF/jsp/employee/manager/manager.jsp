<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="com.example.demo.vo.employee"%>
<%
 employee e=(employee)session.getAttribute("E");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><%=e.getName() %>，歡迎登入</h3>
<a href="/employee/system">進入管理系統</a>

</body>
</html>