<%--
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script defer src='/register.js'></script>

</head>
<body>

<form id="join-form" action="register-result" method="get">
    <label for="memberName">성명</label>
    <input name="memberName" id="memberName" class="legend" type="text" required>
    <br>
    <label for="memberId">ID</label>
    <input name="memberId" id="memberId" class="legend" type="text" required>
    <br>
    <label for="password">Password</label>
    <input name="password" id="password" type="password" required>
    <br>
    <label name="passwordCheck" for="passwordCheck">password 확인</label>
    <input id="passwordCheck" type="password" required>
    <br>

    <label for="birthYear">birthYear</label>
    <select name="birthYear" id="birthYear">
        <option value="1999">1999년</option>
        <option value="1998">1998년</option>
        <option value="1997">1997년</option>
        <option value="1996">1996년</option>
        <option value="1995">1995년</option>
    </select>

    <br>

    성별
    <input type="radio" name="sex" value="M"> 남
    <input type="radio" name="sex" value="F"> 여

    <br>

    취미
    <input type="checkbox" name="favB" value="1"> 독서
    <input type="checkbox" name="favT" value="2"> 여행
    <input type="checkbox" name="favM" value="3"> 영화

    <br>
    <button id="register-submit" type="submit">가입</button>
    <br>
</form>

<%--<form name="regFrm" method="post" action="register-result">--%>
<%--    <table cellpadding="5">--%>
<%--        <tr>--%>
<%--            <td bgcolor="#99CCCC">--%>
<%--                <table border="1" cellspacing="0" cellpadding="2" width="600">--%>
<%--                    <tr bgcolor="#CCFFFF">--%>
<%--                        <td colspan="3"><span style="color: #000000; "><b>회원 가입</b></span></td>--%>
<%--                    </tr>--%>

<%--                    <tr>--%>
<%--                        <td width="20%">성명</td>--%>
<%--                        <td width="50%">--%>
<%--                            <input name="memberName" id="memberName2" class="legend" type="text" required size="15">--%>
<%--                        </td>--%>
<%--                        <td width="30%">성명을 입력하세요.</td>--%>
<%--                    </tr>--%>

<%--                    <tr>--%>
<%--                        <td width="20%">아이디</td>--%>
<%--                        <td width="50%">--%>
<%--                            <input name="id" size="15">--%>
<%--                            <input type="button" value="ID중복확인" onClick="idCheck(this.form.id.value)">--%>
<%--                        </td>--%>
<%--                        <td width="30%">아이디를 입력하세요</td>--%>
<%--                    </tr>--%>

<%--                    <tr>--%>
<%--                        <td>패스워드</td>--%>
<%--                        <td><input name="password" id="password2" type="password" required size="15"></td>--%>
<%--                        <td>패스워드를 적어주세요.</td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>패스워드 확인</td>--%>
<%--                        <td><input id="passwordCheck2" type="password" required size="15"></td>--%>
<%--                        <td>패스워드를 확인합니다.</td>--%>
<%--                    </tr>--%>

<%--                    <tr>--%>
<%--                        <td colspan="3" align="center">--%>
<%--                            <input type="button" value="회원가입" onclick="inputCheck()">--%>
<%--                            &nbsp; &nbsp;--%>
<%--                            <input type="reset" value="다시쓰기">--%>
<%--                            &nbsp; &nbsp;--%>
<%--                            <input type="button" value="로그인" onClick="login()">--%>
<%--                        </td>--%>
<%--                    </tr>--%>

<%--                </table>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form>--%>

<button onclick="goHome()">홈으로 가기</button>

</body>
</html>
