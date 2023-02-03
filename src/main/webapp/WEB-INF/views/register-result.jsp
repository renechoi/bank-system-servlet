<%--
  Created by IntelliJ IDEA.
  User: Rene
  Date: 2023/02/01
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
회원가입 결과 !!! <br>

당신의 이름: <%=request.getParameter("memberName")%> <br>
당신의 아이디: <%=request.getParameter("memberId")%> <br>
당신의 비밀번호: <%=request.getParameter("password")%> <br>

<br>
<li><button onclick="goHome()">홈으로 가기</button></li>
</body>
</html>
