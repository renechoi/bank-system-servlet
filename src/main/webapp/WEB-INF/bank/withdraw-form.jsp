
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>withdraw form</title>
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

<form id="withdraw-form" action="withdraw-result" method="post">
    <label for="withdraw-form">출금할 금액을 입력하세요</label>
    <input name="withdraw" id="withdraw" class="legend" type="text" required>
    <button id="withdraw-submit" type="submit">출금</button>
    <br>
</form>




<jsp:include page="bankCheckStatus.jsp" />

<button onclick="goHome()">홈으로 가기</button>

</body>
</html>
