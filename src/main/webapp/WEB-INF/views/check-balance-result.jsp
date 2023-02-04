<%@ page import="java.util.Arrays" %>
<%@ page import="java.net.URLDecoder" %>
<%--<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>--%>
<%@ page import="com.example.banksystemservlet.domain.member.MemberData" %>
<%@ page import="com.example.banksystemservlet.domain.member.MemberData" %>
<%@ page import="com.example.banksystemservlet.domain.member.MemberData" %>
<%@ page import="com.example.banksystemservlet.domain.bank.Result" %><%--
  Created by IntelliJ IDEA.
  User: Rene
  Date: 2023/02/02
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>check balance result</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/headers/">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>

    <!-- Custom styles for this template -->
    <link href="/headers.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script defer src='/register.js'></script>
</head>

<%
    Result result = (Result) session.getAttribute("result");
    MemberData memberData = result.getMemberData();
%>
<body>

잔액 조회하기 <br>

<table>
    <tr>
        <th>고객번호</th>
        <th>계좌번호</th>
        <th>계좌명</th>
        <th>아이디</th>
        <th>잔액</th>
    </tr>

    <tr>
        <%--        프로퍼티 접근법 : ${} 안써지는 이유는 ? --%>
        <td><%=memberData.memberNumber()%></td>
        <td><%=memberData.accountNumber()%></td>
        <td><%=memberData.name()%></td>
        <td><%=memberData.memberId()%></td>
        <td><%=memberData.balance()%></td>
    </tr>
</table>


<br>
<button onclick="goHome()">홈으로 가기</button>


</body>
</html>
