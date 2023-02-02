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
</head>
<body>

<form id="withdraw-form" action="withdraw" method="post">
    <label for="withdraw-form">출금할 금액을 입력하세요</label>
    <input name="withdraw" id="withdraw" class="legend" type="text" required>
    <button id="withdraw-submit" type="submit">출금</button>
    <br>
</form>

</body>
</html>
