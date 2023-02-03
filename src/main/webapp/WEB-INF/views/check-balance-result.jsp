<%@ page import="java.util.Arrays" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="com.example.banksystemservlet.domain.member.InfoMessage" %><%--
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

<%
    ObjectMapper objectMapper = new ObjectMapper();
    InfoMessage infoMessage = (InfoMessage) request.getAttribute("infoMessage");
    String accountInfo = objectMapper.writeValueAsString(infoMessage);
%>
<body>

잔액 조회하기 <br>

<table>
    <tr>
        <th>고객번호</th>
        <th>계좌번호</th>
        <th>계좌명</th>
        <th>아이디</th>
        <th>잔액</th>
    </tr>

    <tr>
<%--        프로퍼티 접근법 : ${} 안써지는 이유는 ? --%>
        <td><%=infoMessage.memberNumber()%></td>
        <td><%=infoMessage.accountNumber()%></td>
        <td><%=infoMessage.name()%></td>
        <td><%=infoMessage.memberId()%></td>
        <td><%=infoMessage.balance()%></td>
    </tr>
</table>


<br>
<li><a href="../index.html">홈으로 가기</a></li>


</body>
</html>
