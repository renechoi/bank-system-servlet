<%@ page import="com.example.banksystemservlet.result.BoardResult" %><%--
  Created by IntelliJ IDEA.
  User: Rene
  Date: 2023/02/06
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    BoardResult boardResult = (BoardResult) session.getAttribute("boardResult");
%>

<--- 관리자 확인용 ---> <br>
성공 여부 : <%=boardResult.getMessage()%> <br>



</body>
</html>
