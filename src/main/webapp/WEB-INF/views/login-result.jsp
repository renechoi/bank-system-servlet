<%@ page import="com.example.banksystemservlet.domain.member.Member" %><%--
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
</head>
<body>

<% Member member = (Member) session.getAttribute("member"); %>

로그인 되었습니다. <br>

이름 <%=member.getName() %>
아이디 <%=member.getMemberId() %>

<br>
<li><button onclick="goHome()">홈으로 가기</a></li>

</body>
</html>
