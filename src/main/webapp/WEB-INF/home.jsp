<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.banksystemservlet.domain.board.Article" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.banksystemservlet.domain.board.BoardResult" %>
<%@ page import="static sun.java2d.cmm.ColorTransform.Out" %>
<%@ page import="com.example.banksystemservlet.domain.board.Pagination" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>

<Head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bank</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/headers/">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>

    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
    <!--    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">-->
    <!-- Custom styles for this template -->
    <link href="headers.css" rel="stylesheet">
    <link href="body-stats.css" rel="stylesheet">
    <link href="body-note.css.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script defer src='register.js'></script>
    <script defer src='body-note.js.js'></script>
</head>



<body>
<%--<button>--%>
<%--    <a onclick="createAccount()"> 임시 계좌 생성 </a>--%>
<%--</button>--%>


<%
    BoardResult boardResult = (BoardResult) session.getAttribute("boardResult");
    List<Article> boardData = (List<Article>) boardResult.getBoardData();
    Pagination pagination = boardResult.getPagination();
//    boardData.stream().forEach(v -> System.out.println("v = " + v));

    pageContext.setAttribute("boardData", boardData);
    pageContext.setAttribute("pagination", pagination);

    System.out.println(pagination);
%>


<JSP 파일>

<div class="container">
    <div class="row row-cols-1 row-cols-md-2 row-cols-xl-4">
        <div class="col">
            <div class="card radius-10 border-start border-0 border-3 border-info">
                <div class="card-body">
                    <div class="d-flex align-items-center">
                        <div>
                            <p class="mb-0 text-secondary">고객 입금 금액</p>
                            <h4 class="my-1 text-info">800,000,000원</h4>
                            <p class="mb-0 font-13">2023-02-03 기준</p>
                        </div>
                        <div class="widgets-icons-2 rounded-circle bg-gradient-scooter text-white ms-auto"><i
                                class="fa fa-shopping-cart"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card radius-10 border-start border-0 border-3 border-danger">
                <div class="card-body">
                    <div class="d-flex align-items-center">
                        <div>
                            <p class="mb-0 text-secondary">거래 금액</p>
                            <h4 class="my-1 text-danger">12,000,000,000원</h4>
                            <p class="mb-0 font-13">2023-01</p>
                        </div>
                        <div class="widgets-icons-2 rounded-circle bg-gradient-bloody text-white ms-auto"><i
                                class="fa fa-dollar"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col">
            <div class="card radius-10 border-start border-0 border-3 border-warning">
                <div class="card-body">
                    <div class="d-flex align-items-center">
                        <div>
                            <p class="mb-0 text-secondary">총 회원 수</p>
                            <h4 class="my-1 text-warning">8400 명</h4>
                            <p class="mb-0 font-13">지난주 대비 +9.3%</p>
                        </div>
                        <div class="widgets-icons-2 rounded-circle bg-gradient-blooker text-white ms-auto"><i
                                class="fa fa-users"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<br>
<br>


<div class="page-content container note-has-grid">
    <ul class="nav nav-pills p-3 bg-white mb-3 rounded-pill align-items-center">
        <li class="nav-item">
            <a href="javascript:void(0)"
               class="nav-link rounded-pill note-link d-flex align-items-center px-2 px-md-3 mr-0 mr-md-2 active"
               id="all-category">
                <i class="icon-layers mr-1"></i><span class="d-none d-md-block">전체 보기</span>
            </a>
        </li>
        <li class="nav-item">
            <a href="javascript:void(0)"
               class="nav-link rounded-pill note-link d-flex align-items-center px-2 px-md-3 mr-0 mr-md-2"
               id="note-business"> <i class="icon-briefcase mr-1"></i><span class="d-none d-md-block">새소식</span></a>
        </li>
        <li class="nav-item">
            <a href="javascript:void(0)"
               class="nav-link rounded-pill note-link d-flex align-items-center px-2 px-md-3 mr-0 mr-md-2"
               id="note-social"> <i class="icon-share-alt mr-1"></i><span class="d-none d-md-block">이벤트</span></a>
        </li>
        <li class="nav-item">
            <a href="javascript:void(0)"
               class="nav-link rounded-pill note-link d-flex align-items-center px-2 px-md-3 mr-0 mr-md-2"
               id="note-important"> <i class="icon-tag mr-1"></i><span class="d-none d-md-block">FAQ</span></a>
        </li>
        <li class="nav-item ml-auto">
            <a href="javascript:void(0)" class="nav-link btn-primary rounded-pill d-flex align-items-center px-3"
               id="add-notes"> <i class="icon-note m-1"></i><span class="d-none d-md-block font-14">Add Notes</span></a>
        </li>
    </ul>
    <div class="tab-content bg-transparent">
        <div id="note-full-container" class="note-has-grid row">
            <div class="col-md-4 single-note-item all-category" style="">
                <div class="card card-body">
                    <span class="side-stick"></span>
                    <h5 class="note-title text-truncate w-75 mb-0" data-noteheading="Book a Ticket for Movie">우리 댕냥이
                        「반려동물등록증」발급하면 선물도 푸짐하개 드릴고양~ <i class="point fa fa-circle ml-1 font-10"></i></h5>
                    <p class="note-date font-12 text-muted">2023-02-01</p>
                    <div class="note-content">
                        <p class="note-inner-content text-muted"
                           data-notecontent="Blandit tempus porttitor aasfs. Integer posuere erat a ante venenatis.">
                            이벤트 기간중 반려동물 등록증 발급받고 선물 BESPOKE 제트봇 AI + 반려견 스마트워치 </p>
                    </div>
                    <div class="d-flex align-items-center">
                        <span class="mr-1"><i class="fa fa-star favourite-note"></i></span>
                        <span class="mr-1"><i class="fa fa-trash remove-note"></i></span>
                        <div class="ml-auto">
                            <div class="category-selector btn-group">
                                <a class="nav-link dropdown-toggle category-dropdown label-group p-0"
                                   data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                                   aria-expanded="true">
                                    <div class="category">
                                        <div class="category-business"></div>
                                        <div class="category-social"></div>
                                        <div class="category-important"></div>
                                        <span class="more-options text-dark"><i
                                                class="icon-options-vertical"></i></span>
                                    </div>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right category-menu">
                                    <a class="note-business badge-group-item badge-business dropdown-item position-relative category-business text-success"
                                       href="javascript:void(0);">
                                        <i class="mdi mdi-checkbox-blank-circle-outline mr-1"></i> 새소식
                                    </a>
                                    <a class="note-social badge-group-item badge-social dropdown-item position-relative category-social text-info"
                                       href="javascript:void(0);">
                                        <i class="mdi mdi-checkbox-blank-circle-outline mr-1"></i> 이벤트
                                    </a>
                                    <a class="note-important badge-group-item badge-important dropdown-item position-relative category-important text-danger"
                                       href="javascript:void(0);">
                                        <i class="mdi mdi-checkbox-blank-circle-outline mr-1"></i> FAQ
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4 single-note-item all-category note-important" style="">
                <div class="card card-body">
                    <span class="side-stick"></span>
                    <h5 class="note-title text-truncate w-75 mb-0" data-noteheading="Go for lunch"> 외환전문 플랫폼 KB Star FX
                        오픈안내 <i class="point fa fa-circle ml-1 font-10"></i></h5>
                    <p class="note-date font-12 text-muted">2023-01-26</p>
                    <div class="note-content">
                        <p class="note-inner-content text-muted"
                           data-notecontent="Blandit tempus porttitor aasfs. Integer posuere erat a ante venenatis.">항상
                            저희 은행을 이용해 주시는 고객님께 깊은 감사를 드립니다.
                            비대면 외환전문 플랫폼인 Star FX (fx.com)의 서비스를 시행함을 알려드립니다.</p>
                    </div>
                    <div class="d-flex align-items-center">
                        <span class="mr-1"><i class="fa fa-star favourite-note"></i></span>
                        <span class="mr-1"><i class="fa fa-trash remove-note"></i></span>
                        <div class="ml-auto">
                            <div class="category-selector btn-group">
                                <a class="nav-link dropdown-toggle category-dropdown label-group p-0"
                                   data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                                   aria-expanded="true">
                                    <div class="category">
                                        <div class="category-business"></div>
                                        <div class="category-social"></div>
                                        <div class="category-important"></div>
                                        <span class="more-options text-dark"><i
                                                class="icon-options-vertical"></i></span>
                                    </div>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right category-menu">
                                    <a class="note-business badge-group-item badge-business dropdown-item position-relative category-business text-success"
                                       href="javascript:void(0);">
                                        <i class="mdi mdi-checkbox-blank-circle-outline mr-1"></i> 새소식
                                    </a>
                                    <a class="note-social badge-group-item badge-social dropdown-item position-relative category-social text-info"
                                       href="javascript:void(0);">
                                        <i class="mdi mdi-checkbox-blank-circle-outline mr-1"></i> 이벤트
                                    </a>
                                    <a class="note-important badge-group-item badge-important dropdown-item position-relative category-important text-danger"
                                       href="javascript:void(0);">
                                        <i class="mdi mdi-checkbox-blank-circle-outline mr-1"></i> FAQ
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4 single-note-item all-category note-social" style="">
                <div class="card card-body">
                    <span class="side-stick"></span>
                    <h5 class="note-title text-truncate w-75 mb-0" data-noteheading="Meeting with Mr.Jojo">영업점 시간 정상 운영
                        안내 <i class="point fa fa-circle ml-1 font-10"></i></h5>
                    <p class="note-date font-12 text-muted">2023-01-21</p>
                    <div class="note-content">
                        <p class="note-inner-content text-muted"
                           data-notecontent="Blandit tempus porttitor aasfs. Integer posuere erat a ante venenatis.">
                            개인고객 모바일·인터넷뱅킹 타행이체 수수료 안내</p>
                    </div>
                    <div class="d-flex align-items-center">
                        <span class="mr-1"><i class="fa fa-star favourite-note"></i></span>
                        <span class="mr-1"><i class="fa fa-trash remove-note"></i></span>
                        <div class="ml-auto">
                            <div class="category-selector btn-group">
                                <a class="nav-link dropdown-toggle category-dropdown label-group p-0"
                                   data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                                   aria-expanded="true">
                                    <div class="category">
                                        <div class="category-business"></div>
                                        <div class="category-social"></div>
                                        <div class="category-important"></div>
                                        <span class="more-options text-dark"><i
                                                class="icon-options-vertical"></i></span>
                                    </div>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right category-menu">
                                    <a class="note-business badge-group-item badge-business dropdown-item position-relative category-business text-success"
                                       href="javascript:void(0);">
                                        <i class="mdi mdi-checkbox-blank-circle-outline mr-1"></i> 새소식
                                    </a>
                                    <a class="note-social badge-group-item badge-social dropdown-item position-relative category-social text-info"
                                       href="javascript:void(0);">
                                        <i class="mdi mdi-checkbox-blank-circle-outline mr-1"></i> 이벤트
                                    </a>
                                    <a class="note-important badge-group-item badge-important dropdown-item position-relative category-important text-danger"
                                       href="javascript:void(0);">
                                        <i class="mdi mdi-checkbox-blank-circle-outline mr-1"></i> FAQ
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>

    <!-- Modal Add notes -->
    <div class="modal fade" id="addnotesmodal" tabindex="-1" role="dialog" aria-labelledby="addnotesmodalTitle"
         style="display: none;" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content border-0">
                <div class="modal-header bg-info text-white">
                    <h5 class="modal-title text-white">Add Notes</h5>
                    <button type="button" class="close text-white" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="notes-box">
                        <div class="notes-content">
                            <form action="javascript:void(0);" id="addnotesmodalTitle">
                                <div class="row">
                                    <div class="col-md-12 mb-3">
                                        <div class="note-title">
                                            <label>Note Title</label>
                                            <input type="text" id="note-has-title" class="form-control" minlength="25"
                                                   placeholder="Title"/>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <div class="note-description">
                                            <label>Note Description</label>
                                            <textarea id="note-has-description" class="form-control" minlength="60"
                                                      placeholder="Description" rows="3"></textarea>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button id="btn-n-save" class="float-left btn btn-success" style="display: none;">Save</button>
                    <button class="btn btn-danger" data-dismiss="modal">Discard</button>
                    <button id="btn-n-add" class="btn btn-info" disabled="disabled">Add</button>
                </div>
            </div>
        </div>
    </div>
</div>



<br>




<main class="container">

    <div class="row">
        <div class="card card-margin search-form">
            <div class="card-body p-0">
                <form id="search-form" action="/board/article-search">
                    <div class="row">
                        <div class="col-12">
                            <div class="row no-gutters">
                                <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                    <label for="search-type" hidden>검색 유형</label>
                                    <select class="form-control" id="search-type" name="searchType">
                                        <option>title</option>
                                        <option>content</option>
                                        <option>memberId</option>
                                        <option>memberName</option>
                                        <option>hashtag</option>
                                    </select>
                                </div>
                                <div class="col-lg-8 col-md-6 col-sm-12 p-0">
                                    <label for="search-value" hidden>검색어</label>
                                    <input type="text" placeholder="검색어..." class="form-control" id="search-value"
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
        <table class="table" id="article-table2">
            <thead>
            <tr>
                <th class="title col-6"><a>제목</a></th>
                <th class="hashtag col-2"><a>해시태그</a></th>
                <th class="user-id"><a>작성자</a></th>
                <th class="created-at"><a>작성일</a></th>
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
<%--            <a class="btn btn-primary me-md-2" role="button" href="/board/article-write-form" id="write-article">글쓰기</a>--%>
            <a class="btn btn-primary me-md-2" role="button" href="/board/article-read-result?page=default" id="article-list-submit2">목록보기</a>
        </div>
    </div>


</main>





<footer>
    <hr>
    2023 @Rene
</footer>


</body>
</html>
