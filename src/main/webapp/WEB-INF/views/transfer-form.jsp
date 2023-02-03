<%--
  Created by IntelliJ IDEA.
  User: Rene
  Date: 2023/02/02
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src='/register.js'></script>
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

<br>
<button onclick="goHome()">홈으로 가기</button>

</body>
</html>
