<%@ page import="com.example.banksystemservlet.domain.bank.BankResult" %>
<%@ page import="com.example.banksystemservlet.domain.member.MemberData" %><%--
  Created by IntelliJ IDEA.
  User: Rene
  Date: 2023/02/02
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>transfer form</title>

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
<body>

<form id="transfer-form" action="transfer-result" method="post">
    <label for="transfer-form">송금할 대상 아이디를 입력하세요</label>
    <input name="transferId" id="transferId" class="legend" type="text" required>

    <label for="transfer-form">송금할 금액을 입력하세요</label>
    <input name="transferAmount" id="transferAmount" class="legend" type="text" required>

    <button id="transfer-submit" type="submit">송금</button>
    <br>
</form>


<jsp:include page="bankCheckStatus.jsp" />
<br>
<button onclick="goHome()">홈으로 가기</button>

</body>
</html>
