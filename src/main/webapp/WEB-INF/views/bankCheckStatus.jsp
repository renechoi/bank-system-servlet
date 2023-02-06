<%@ page import="com.example.banksystemservlet.domain.bank.BankResult" %>
<%@ page import="com.example.banksystemservlet.domain.member.MemberData" %><%--
  Created by IntelliJ IDEA.
  User: Rene
  Date: 2023/02/06
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>check status</title>
</head>
<body>


<%
    BankResult bankResult = (BankResult) session.getAttribute("bankResult");
    MemberData memberData = bankResult.getData();
%>

<--- 관리자 확인용 ---> <br>
성공 여부 : <%=bankResult.getMessage()%> <%=bankResult.isSuccess()%><br>
현재 로그인 된 아이디 : <%= memberData.currentlyLogin()%> <br>

</body>
</html>
