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
    <title>login form</title>

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