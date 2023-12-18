<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.example.demo.vo.message,com.example.demo.vo.member"%>
<%message m=(message)session.getAttribute("MD");
member m1=(member)session.getAttribute("M");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/message/delete" method="post">
<table aligh=center border=1>
	<tr>
		<td colspan=2 align=center>
		<%=m1.getName() %>，這是你原本的留言內容
	<tr>
		<td>原本的文章標題
		<td><%=m.getTitle() %>
	<tr>
		<td width=500>原本的文章內容
		<td><%=m.getContent() %>
	<tr>
		<td colspan=3 aligh=center>
		<a href="/member/function">回會員專區</a>
		<input type="hidden" name="id" value="<%=m.getId() %>">
		<input type="submit" value="確定刪除">
</table>
</form>
</body>
</html>