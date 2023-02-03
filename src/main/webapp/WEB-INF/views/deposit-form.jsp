<%--
  Created by IntelliJ IDEA.
  User: Rene
  Date: 2023/02/02
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src='/register.js'></script>
</head>
<body>

<form id="deposit-form" action="deposit-result" method="post">
    <label for="deposit-form">입금할 금액을 입력하세요</label>
    <input name="deposit" id="deposit" class="legend" type="text" required>
    <button id="deposit-submit" type="submit">입금</button>
    <br>
</form>

<br>
<button onclick="goHome()">홈으로 가기</button>

</body>
</html>
