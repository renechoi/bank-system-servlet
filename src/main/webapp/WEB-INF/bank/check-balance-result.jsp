<%@ page import="java.util.Arrays" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="com.example.banksystemservlet.result.BankResult" %>
<%@ page import="com.example.banksystemservlet.result.BankResult" %>
<%@ page import="com.example.banksystemservlet.domain.member.Member" %>
<%@ page import="com.example.banksystemservlet.domain.bank.Account" %>
<%@ page import="java.util.Map" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>check balance bankResult</title>

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
    BankResult bankResult1 = (BankResult) session.getAttribute("bankResult");
    Map<Member, Account> memberAccountMap = bankResult1.memberWithAccount();

    pageContext.setAttribute("memberAndAccount", memberAccountMap.entrySet());
%>

<body>

잔액 조회하기 <br>
<table border="1">
    <tr>
        <th>고객번호</th>
        <th>고객명</th>
        <th>계좌번호</th>
        <th>잔액</th>
    </tr>

    <c:forEach var="item" items="${pageScope.memberAndAccount}">
        <tr>
            <td>${item.getKey().getMemberId()}</td>
            <td>${item.getKey().getName()}</td>
            <td>${item.getValue().getAccountNumber()}</td>
            <td>${item.getValue().getBalance()}</td>
        </tr>
    </c:forEach>
</table>


<jsp:include page="bankCheckStatus.jsp"/>


<br>
<button onclick="goHome()">홈으로 가기</button>


</body>
</html>
