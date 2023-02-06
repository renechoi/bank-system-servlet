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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <link href="/headers.css" rel="stylesheet">
    <link href="acticle-content.css" rel="stylesheet">
    <script defer src='/register.js'></script>

</head>
<body>


<main id="article-main" class="container">

    <div class="row g-5">
        <section class="col-md-5 col-lg-4 order-md-last">
            <aside>
                <p><span id="nickname">Rene</span></p>
                <p><a id="email" href="mailto:djkehh@gmail.com">rene@mail.com</a></p>
                <p><time id="created-at" datetime="2022-01-01T00:00:00">2023-01-01</time></p>
                <p><span id="hashtag">#java</span></p>
            </aside>
        </section>

        <article id="article-content" class="col-md-7 col-lg-8">
            <pre>본문<br><br></pre>
        </article>
    </div>

    <div class="row g-5">
        <section>
            <form class="row g-3">
                <div class="col-8">
                    <label for="comment-textbox" hidden>댓글</label>
                    <textarea class="form-control" id="comment-textbox" placeholder="댓글 쓰기.." rows="3"></textarea>
                </div>
                <div class="col-auto">
                    <label for="comment-submit" hidden>댓글 쓰기</label>
                    <button class="btn btn-primary" id="comment-submit" type="submit">쓰기</button>
                </div>
            </form>

            <ul id="article-comments" class="row col-7">
                <li>
                    <div>
                        <strong>안성민1</strong>
                        <small><time>2022-01-01</time></small>
                        <p>
                            댓글창입니다
                        </p>
                    </div>
                </li>
                <li>
                    <div>
                        <strong>안성민2</strong>
                        <small><time>2022-01-01</time></small>
                        <p>
                            댓글창입니다
                        </p>
                    </div>
                </li>
            </ul>

        </section>
    </div>

    <div class="row g-5">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo; prev</span>
                    </a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">next &raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>

</main>

</body>
</html>
