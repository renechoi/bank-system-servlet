<%@ page import="com.example.banksystemservlet.domain.member.Member" %>
<%@ page import="com.example.banksystemservlet.domain.bank.BankResult" %>
<%@ page import="com.example.banksystemservlet.domain.member.MemberData" %><%--
  Created by IntelliJ IDEA.
  User: Rene
  Date: 2023/02/01
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register-page</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/headers/">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>

    <!-- Custom styles for this template -->
    <link href="/headers.css" rel="stylesheet">
    <link href="/member.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script defer src='/register.js'></script>

</head>
<body>


<form id="join-form" action="register-result" method="get">

    <input type="hidden" name="a" value="join"/>

    <label class="block-label" for="name">이름</label>
    <input id="memberName" name="memberName" class="legend" type="text" value="" required/>

    <label class="block-label" for="memberId">ID</label>
    <input name="memberId" id="memberId" class="legend" type="text" required>
    <input id="btn-checkid" type="button" value="id 중복체크">
    <p id="checkid-msg" class="form-error">
        &nbsp;
    </p>

    <label class="block-label" for="email">Email</label>
    <input name="email" id="email" class="legend" type="text" required>

    <label class="block-label" for="address">Address</label>
    <input name="address" id="address" class="legend" type="text" required>

    <label class="block-label" for="password">Password</label>
    <input name="password" id="password" type="password" required>
    <label class="block-label" name="passwordCheck" for="passwordCheck">password 확인</label>
    <input id="passwordCheck" type="password" required>

    <label class="block-label" for="birthYear">birthYear</label>
    <select name="birthYear" id="birthYear">
        <option value="1999">1999년</option>
        <option value="1998">1998년</option>
        <option value="1997">1997년</option>
        <option value="1996">1996년</option>
        <option value="1995">1995년</option>
    </select>

    <br>

    <fieldset>
        성별
        <input type="radio" name="sex" value="M"> 남
        <input type="radio" name="sex" value="F"> 여
    </fieldset>

    <br>

    <fieldset>
        취미
        <input type="checkbox" name="favB" value="1"> 독서
        <input type="checkbox" name="favT" value="2"> 여행
        <input type="checkbox" name="favM" value="3"> 영화
    </fieldset>

    <br>
    <fieldset>
        <legend>약관동의</legend>
        <input id="agree-prov" type="checkbox" name="agreeProv" value="y">
        <label>서비스 약관에 동의합니다.</label>
    </fieldset>

    <button id="register-submit" type="submit">가입</button>
    <br>
</form>


<br>
<jsp:include page="bankCheckStatus.jsp"/>
<button onclick="goHome()">홈으로 가기</button>

</body>
</html>
