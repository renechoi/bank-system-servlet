<%--
  Created by IntelliJ IDEA.
  User: Rene
  Date: 2023/02/01
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="login-result" method="post">
    memberId: <input type="text" name="memberId"/><br>
    password: <input type="text" name="password"/>
    <button type="submit">로그인</button>
</form>

<li><button onclick="goHome()">홈으로 가기</button></li>
</body>
</html>
