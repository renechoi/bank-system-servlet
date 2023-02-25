<%@ page import="com.example.banksystemservlet.result.BoardResult" %>
<%@ page import="com.example.banksystemservlet.domain.board.Article" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.banksystemservlet.domain.board.ArticleComment" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 컨텐츠</title>


    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/headers/">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>

    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
    <!--    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">-->
    <!-- Custom styles for this template -->
    <link href="/headers.css" rel="stylesheet">
    <link href="body-stats.css" rel="stylesheet">
    <link href="body-note.css.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script defer src='/register.js'></script>
    <script defer src='body-note.js.js'></script>


</head>
<body>


<%
    BoardResult boardResult = (BoardResult) session.getAttribute("boardResult");
    Article boardData = (Article) boardResult.getBoardData();
    List<ArticleComment> boardCommentData = (List<ArticleComment>) boardResult.getBoardCommentData();

    System.out.println("boardData = " + boardData);
    System.out.println("boardCommentData = " + boardCommentData);

    pageContext.setAttribute("boardData", boardData);
    pageContext.setAttribute("boardCommentData", boardCommentData);

%>


<main id="article-main" class="container">
    <div>
        <a>
            <h2>${boardData.title()}</h2>
        </a>
    </div>

    <div class="row g-5">
        <section class="col-md-5 col-lg-4 order-md-last">
            <aside>
                <p><span id="nickname">${boardData.memberName()}</span></p>
                <p>
                    <time id="created-at" datetime="2022-01-01T00:00:00">${boardData.createdAt()}</time>
                </p>
                <p><span id="hashtag">#java</span></p>
            </aside>
        </section>

        <article id="article-content" class="col-md-7 col-lg-8">
            <pre>${boardData.content()}<br><br></pre>
        </article>
    </div>

    <div class="row g-5">
        <section>
            <form class="row g-3" method="post" action="/board/comment-write-result?id=${boardData.id()}">
                <div class="col-8">
                    <label for="comment-textbox" hidden>댓글</label>
                    <textarea class="form-control" name="comment-content" id="comment-textbox" placeholder="댓글 쓰기.."
                              rows="3"></textarea>
                </div>
                <div class="col-auto">
                    <label for="comment-submit" hidden>댓글 쓰기</label>
                    <button class="btn btn-primary" id="comment-submit" type="submit">쓰기</button>
                </div>
            </form>



            <c:forEach var="item" items="${pageScope.boardCommentData}">
                <ul id="article-comments" class="row col-7">
                    <li>
                        <div>
                            <strong>${item.memberName()}</strong>
                            <small>
                                <time>${item.createdAt()}</time>
                            </small>
                            <p>
                                ${item.content()}
                            </p>
                        </div>
                    </li>
                </ul>
            </c:forEach>

        </section>
    </div>

    <div class="row g-5">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item">
                    <a class="page-link" href="/board/article-prev-result?id=${boardData.id()}" aria-label="Previous">
                        <span aria-hidden="true">&laquo; prev</span>
                    </a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="/board/article-next-result?id=${boardData.id()}" aria-label="Next">
                        <span aria-hidden="true">next &raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>

    <br>
    <form class="row g-3" method="post" action="/board/article-delete-result?id=${boardData.id()}">
        <div class="col-auto">
            <label for="article-delete-submit" hidden>게시글 삭제</label>
            <button class="btn btn-primary" id="article-delete-submit" type="submit">게시글 삭제</button>
        </div>
    </form>

    <form class="row g-3" method="post" action="/board/article-read-result?page=default">
        <div class="col-auto">
            <label for="article-list-submit" hidden>목록</label>
            <button class="btn btn-primary" id="article-list-submit" type="submit">목록</button>
        </div>
    </form>


</main>

</body>
</html>
