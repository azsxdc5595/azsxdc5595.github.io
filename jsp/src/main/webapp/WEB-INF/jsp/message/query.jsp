<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.message, java.util.*, com.github.pagehelper.PageInfo"%>
<%
    PageInfo<message> pageInfo = (PageInfo<message>) session.getAttribute("message");
    List<message> messages = pageInfo.getList();
    int currentPage = pageInfo.getPageNum();
    int totalPages = pageInfo.getPages();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/st1.css">
</head>
<body>
    <div id="header">
        <div id="title">Ares system</div>
    </div>
    <div id="content">
        <div id="contentArea">
            <table border="1" align="center">
                <thead>
                    <tr>
                        <th>文章標題</th>
                        <th>文章內容</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (message msg : messages) { %>
                        <tr>
                            <td><%=msg.getTitle()%></td>
                            <td><%=msg.getContent()%></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>

            <!-- 分頁信息 -->
            <div style="text-align: center; margin-top: 10px;">
                    <!-- 上一頁 -->
                    <a class="<%=pageInfo.isHasPreviousPage() ? "" : "disabled"%>"
                        href="/message/message?page=<%=pageInfo.getPrePage()%>&size=<%=pageInfo.getPageSize()%>">&laquo; 上一頁</a>

                    <!-- 顯示分頁數字 -->
                    <% for (int pageNum = 1; pageNum <= totalPages; pageNum++) { %>
                        <a class="<%=pageNum == currentPage ? "active" : ""%>"
                            href="/message/message?page=<%=pageNum%>&size=<%=pageInfo.getPageSize()%>"><%=pageNum%></a>
                    <% } %>

                    <!-- 下一頁 -->
                    <a class="<%=pageInfo.isHasNextPage() ? "" : "disabled"%>"
                        href="/message/message?page=<%=pageInfo.getNextPage()%>&size=<%=pageInfo.getPageSize()%>">下一頁 &raquo;</a>
            </div>
            <br><br><br>
            <a href="/member/function">回會員專區</a>
        </div>
    </div>
    <div id="main"></div>
    <div id="footer"></div>
</body>
</html>
