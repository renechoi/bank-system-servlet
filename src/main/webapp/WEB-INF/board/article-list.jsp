<%@ page import="com.example.banksystemservlet.domain.board.Article" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.banksystemservlet.domain.board.BoardResult" %>
<%@ page import="static sun.java2d.cmm.ColorTransform.Out" %>
<%@ page import="com.example.banksystemservlet.domain.board.Pagination" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>article list</title>


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


<%--<%--%>
<%--    String str = "hello jstl";--%>
<%--%>--%>
<%--<c:set var="strTxt2" value="${pageScope.str}"/>--%>
<%--<%--%>
<%--    String strTest = "Scriptlet";--%>
<%--    pageContext.setAttribute("strTest", strTest);--%>
<%--%>--%>
<%--<div>--%>
<%--    ${strTxt2}--%>
<%--    ????????? <c:out value="strTxt2"></c:out>--%>
<%--    ????????? jstl = ${strTest}--%>
<%--    <br>--%>

<%--    <c:forEach var="item" items="${pageScope.strTest}">--%>
<%--        item <br>--%>
<%--    </c:forEach>--%>
<%--</div>--%>


<%
    BoardResult boardResult = (BoardResult) session.getAttribute("boardResult");
    List<Article> boardData = (List<Article>) boardResult.getBoardData();
    Pagination pagination = boardResult.getPagination();
//    boardData.stream().forEach(v -> System.out.pri    ntln("v = " + v));

    pageContext.setAttribute("boardData", boardData);
    pageContext.setAttribute("pagination", pagination);

    System.out.println(pagination);

%>
<c:set var="boardData" value="${pageScope.boardData}"/>


<main class="container">

    <div class="row">
        <div class="card card-margin search-form">
            <div class="card-body p-0">
                <form id="search-form" action="article-search">
                    <div class="row">
                        <div class="col-12">
                            <div class="row no-gutters">
                                <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                    <label for="search-type" hidden>?????? ??????</label>
                                    <select class="form-control" id="search-type" name="searchType">
                                        <option>title</option>
                                        <option>content</option>
                                        <option>memberId</option>
                                        <option>memberName</option>
                                        <option>hashtag</option>
                                    </select>
                                </div>
                                <div class="col-lg-8 col-md-6 col-sm-12 p-0">
                                    <label for="search-value" hidden>?????????</label>
                                    <input type="text" placeholder="?????????..." class="form-control" id="search-value"
                                           name="searchValue">
                                </div>
                                <div class="col-lg-1 col-md-3 col-sm-12 p-0">
                                    <button type="submit" class="btn btn-base">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                             viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                             stroke-linecap="round" stroke-linejoin="round"
                                             class="feather feather-search">
                                            <circle cx="11" cy="11" r="8"></circle>
                                            <line x1="21" y1="21" x2="16.65" y2="16.65"></line>
                                        </svg>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="row">
        <table class="table" id="article-table">
            <thead>
            <tr>
                <th class="title col-6"><a>??????</a></th>
                <th class="hashtag col-2"><a>????????????</a></th>
                <th class="user-id"><a>?????????</a></th>
                <th class="created-at"><a>?????????</a></th>
            </tr>
            </thead>


            <tbody>
            <c:forEach var="item" items="${pageScope.boardData}">
                <tr>
                    <td class="title"><a onclick="articleShow(${item.id()})" href = "/board/article-content?id=${item.id()}"  style="cursor:hand">${item.title()}</a></td>
                    <td class="hashtag"><span class="badge text-bg-secondary mx-1"><a
                            class="text-reset">#java</a></span></td>
                    <td class="user-id">${item.memberName()}</td>
                    <td class="created-at">
                        <time>${item.createdAt()}</time>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

    <div class="row">
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <a class="btn btn-primary me-md-2" role="button" href="/board/article-write-form" id="write-article">?????????</a>
        </div>
    </div>


    <div class="row">
        <nav id="pagination" aria-label="Page navigation">
            <ul class="pagination justify-content-center">
                <li class="page-item"><a class="page-link" onclick="listPageMove(${pagination.pageCount},${pagination.currentPage-1})"  style="cursor:hand">Previous</a></li>
<%--                href="/board/article-read-result?page=${pagination.currentPage-1}"--%>

                <c:forEach var="i" begin="1" end="${pagination.pageCount}">
                    <li class="page-item"><a class="page-link" href="/board/article-read-result?page=${i}">${i}</a></li>
                </c:forEach>

                <li class="page-item"><a class="page-link" onclick="listPageMove(${pagination.pageCount},${pagination.currentPage+1})"  style="cursor:hand">Next</a></li>
<%--                href="/board/article-read-result?page=${pagination.currentPage+1}"--%>
            </ul>
        </nav>
    </div>
</main>


<Br>
<br>

</body>
</html>
