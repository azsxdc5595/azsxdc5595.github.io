<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.example.demo.vo.message,com.example.demo.vo.member"%>
<%message m=(message)session.getAttribute("MU");
member m1=(member)session.getAttribute("M");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/message/update" method="post">
<table aligh=center border=1>
	<tr>
		<td colspan=4 align=center>
		<%=m1.getName() %>，這是你原本的留言內容
	<tr>
		<td>原本的文章標題
		<td><%=m.getTitle() %>
		<td>請輸入新的文章標題
		<td><input type="text" name="title">
	<tr>
		<td>原本的文章內容
		<td width=500><%=m.getContent() %>
		<td>請輸入新的文章內容
		<td width=500><input type="text" name="content">
		
	<tr>
		<td aligh=center>
		<a href="/member/function">回會員專區</a>
		<td><input type="submit" value="更改">
		<td><input type="hidden" name="id" value="<%=m.getId() %>">

</table>
</form>
</body>
</html>