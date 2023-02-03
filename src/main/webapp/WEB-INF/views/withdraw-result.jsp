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

출금한 금액은 <%=request.getParameter("withdraw")%> 입니다.

<br>
<button onclick="goHome()">홈으로 가기</button>


</body>
</html>
