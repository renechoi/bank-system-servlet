<%@ page import="java.util.Arrays" %><%--
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
    <script src='/register.js'></script>
</head>
<body>

<form action="login-result" method="post">
    memberId: <input type="text" name="memberId"/><br>
    password: <input type="text" name="password"/>
    <button type="submit">로그인</button>
</form>

<button onclick="goHome()">홈으로 가기</button>

<%

    Cookie currentIdCookie = Arrays.stream(request.getCookies())
            .filter(cookie -> cookie.getName().equals("currentlyLogin"))
            .findFirst().orElse(new Cookie("none", "현재 로그인 되어 있지 않습니다."));

    String value = currentIdCookie.getValue();
%>

<br>
현재 로그인
<%=value%>

</body>
</html>
