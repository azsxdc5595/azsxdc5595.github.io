<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.product, com.github.pagehelper.PageInfo"
    import="java.util.*"%>
<%PageInfo<product> pageInfo = (PageInfo<product>) session.getAttribute("products");
List<product> products = pageInfo.getList();
int currentPage = pageInfo.getPageNum();
int totalPages = pageInfo.getPages(); %>
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
<span style=font-size:18px><B>菜單</B></span>
	<table border=1 align=center>
		<thead>
			<tr>
				<th>品名</th>
				<th>價目</th>
		</thead>
	
		<%for(product product:products){ %>
		<tbody>
		<tr>
			<td><%=product.getProductname() %></td>
			<td><%=product.getPrice() %></td>
	
		<%} %>
		</tbody>
	</table>
	
	<!-- 分頁信息 -->
            <div style="text-align: center; margin-top: 10px;">
                    <!-- 上一頁 -->
                    <a class="<%=pageInfo.isHasPreviousPage() ? "" : "disabled"%>"
                        href="/product/product3?page=<%=pageInfo.getPrePage()%>&size=<%=pageInfo.getPageSize()%>">&laquo; 上一頁</a>

                    <!-- 顯示分頁數字 -->
                    <% for (int pageNum = 1; pageNum <= totalPages; pageNum++) { %>
                        <a class="<%=pageNum == currentPage ? "active" : ""%>"
                            href="/product/product3?page=<%=pageNum%>&size=<%=pageInfo.getPageSize()%>"><%=pageNum%></a>
                    <% } %>

                    <!-- 下一頁 -->
                    <a class="<%=pageInfo.isHasNextPage() ? "" : "disabled"%>"
                        href="/product/product3?page=<%=pageInfo.getNextPage()%>&size=<%=pageInfo.getPageSize()%>">下一頁 &raquo;</a>
            </div>
	<a href="/member/">回上頁</a>
</div>
</div>
<div id="main"></div>
<div id="footer"></div>
    
</body>
</html>