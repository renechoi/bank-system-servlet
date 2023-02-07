<%@ page import="com.example.banksystemservlet.domain.bank.BankResult" %>
<%@ page import="com.example.banksystemservlet.domain.member.MemberData" %>
<%@ page import="java.io.PrintWriter" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>check status</title>
</head>
<body>


<%
    PrintWriter printWriter = response.getWriter();
    try {
        BankResult bankResult = (BankResult) session.getAttribute("bankResult");
        MemberData memberData = bankResult.getData();
        printWriter.println("\n<--- 관리자 확인용 --->\n");
        printWriter.printf("성공 여부: %s %s\n", bankResult.getMessage(), bankResult.isSuccess());
        printWriter.printf("현재 로그인 된 아이디: %s\n", memberData.currentlyLogin());
    } catch (Exception e){
        printWriter.println("<--- 관리자 확인용 --->\n\n");
        printWriter.println(e.getMessage());
    }
%>

<%--<--- 관리자 확인용 ---> <br>--%>
<%--성공 여부 : <%=bankResult.getMessage()%> <%=bankResult.isSuccess()%><br>--%>
<%--현재 로그인 된 아이디 : <%= memberData.currentlyLogin()%> <br>--%>

</body>
</html>
