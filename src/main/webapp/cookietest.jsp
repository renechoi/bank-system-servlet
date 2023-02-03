<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: Rene
  Date: 2023/02/03
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

test

<%

  Cookie[] cookies = request.getCookies();
  if (cookies != null){
    System.out.println("aaaaaaaaaaa");
    for (int i =0; i<cookies.length; ++i){
      System.out.println("Cookie Name["+i+"] = " + cookies[i].getName());
      if(cookies[i].getName().equals("currentlyLogin")){
        System.out.println(cookies[i].getName());
        System.out.println(cookies[i].getValue());
      }
    }
  }

  System.out.println(Arrays.toString(Arrays.stream(cookies).toArray()));
  System.out.println(cookies[0].getName());
  System.out.println(cookies[1].getName());
  System.out.println(cookies[0].getValue());
  System.out.println(cookies[1].getValue());
%>
</body>
</html>
