<%--
  Created by IntelliJ IDEA.
  User: Rene
  Date: 2023/02/05
  Time: 9:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>새 게시글 등록</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/headers/">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>

    <!-- Custom styles for this template -->
    <link href="/headers.css" rel="stylesheet">
    <link href="acticle-content.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script defer src='/register.js'></script>

</head>
<body>



<div class="container">


    <form id="article-form" action = "article-save-result" method="post">
        <div class="row mb-3 justify-content-md-center">
            <label for="title" class="col-sm-2 col-lg-1 col-form-label text-sm-end">제목</label>
            <div class="col-sm-8 col-lg-9">
                <input type="text" class="form-control" id="title" name="title" required>
            </div>
        </div>
        <div class="row mb-3 justify-content-md-center">
            <label for="content" class="col-sm-2 col-lg-1 col-form-label text-sm-end">본문</label>
            <div class="col-sm-8 col-lg-9">
                <textarea class="form-control" id="content" name="content" rows="5" required></textarea>
            </div>
        </div>
        <div class="row mb-5 justify-content-md-center">
            <div class="col-sm-10 d-grid gap-2 d-sm-flex justify-content-sm-end">
                <button onclick="articleSave()" type="submit" class="btn btn-primary" id="submit-button">저장11111</button>
                <button onclick="articleCancel()" type="button" class="btn btn-secondary" id="cancel-button">취소</button>
            </div>
        </div>
    </form>

</div>



</body>
</html>
