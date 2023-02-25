<%@ page import="com.example.banksystemservlet.result.BankResult" %>
<%@ page import="com.example.banksystemservlet.domain.member.MemberData" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.example.banksystemservlet.domain.member.Member" %>
<%@ page import="com.example.banksystemservlet.result.MemberResult" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>check status</title>
</head>
<body>


<%
    PrintWriter printWriter = response.getWriter();
    try {
        MemberResult memberResult = (MemberResult) session.getAttribute("memberResult");
        Member member = memberResult.member();
        printWriter.println("\n");
        printWriter.println("\n<--- 관리자 확인용 --->\n");
        printWriter.printf("성공 여부: %s %s\n", memberResult.message(), memberResult.isSuccess());
        printWriter.printf("현재 로그인 된 아이디: %s\n", member.isLoginStatus() ? member.getMemberId() : "not login");
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
