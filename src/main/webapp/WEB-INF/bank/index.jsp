<%@ page import="com.example.banksystemservlet.domain.bankManager.AccountDao" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page errorPage="../index.html" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/headers/">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>

    <!-- Custom styles for this template -->
    <link href="headers.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script defer src='register.js'></script>
</head>
<body>

<a href="index.jsp">bankManager </a> <br>


현황 보여주기

<%
    Cookie[] cookies = request.getCookies();
//
//    if (cookies != null){
//        for (int i =0; i<cookies.length; ++i){
//            if(cookies[i].getName().equals("currentlyLogin")){
//                System.out.println(cookies[i].getName());
//                System.out.println(cookies[i].getValue());
//            }
//        }
//    }
    System.out.println(Arrays.toString(Arrays.stream(cookies).toArray()));
    System.out.println(cookies[0].getName());
    System.out.println(cookies[1].getName());
    System.out.println(cookies[0].getValue());
    System.out.println(cookies[1].getValue());
    Cookie currentIdCookie = Arrays.stream(request.getCookies())
            .filter(cookie -> cookie.getName().equals("currentlyLogin"))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("ex"));
    String value = currentIdCookie.getValue();
%>

<%=value%>

</body>
</html>