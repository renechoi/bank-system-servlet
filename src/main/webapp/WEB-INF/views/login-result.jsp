<%@ page import="com.example.banksystemservlet.domain.member.Member" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Rene
  Date: 2023/02/02
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src='/register.js'></script>
</head>
<body>

<% Member member = (Member) session.getAttribute("member");

    session.getAttributeNames().asIterator()
            .forEachRemaining(name-> System.out.println("name = " + name));
%>

로그인 되었습니다. <br>

이름 <%=member.getName() %>
아이디 <%=member.getMemberId() %>

<br>
<button onclick="goHome()">홈으로 가기</button>



</body>
</html>
