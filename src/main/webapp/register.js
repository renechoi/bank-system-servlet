$("body").prepend("<header></header>");
// $("header").load("./frontpage/header.html header");
$("header").load("/header.html header");


function goHome() {
    location.href='/'
    // location.href = '../bank/register-page.jsp'
}

function register() {
    location.href='/member/register-form'
    // location.href = '../bank/register-page.jsp'
}

function login() {
    location.href = "/member/login-form"
}

function logout() {
    location.href = "/member/logout-result"
}





function createAccount() {
    location.href = "/bank/create-account-form"
}

function deposit() {
    location.href = "/bank/deposit-form"
}

function withdraw() {
    location.href = "/bank/withdraw-form"
}

function transfer() {
    location.href = "/bank/transfer-form"
}

function checkBalance() {
    location.href = "/bank/check-balance-result"
}

function writeArticle(){
    location.href = "/board/article-write-form"
}

function articleSave(){
    location.href = "/board/article-save-result"
}

function articleCancel(){
    location.href = "/"
}

function articleShow(articleId){

    location.href = "/board/article-content" + "/" + articleId
    // window.open('/board/article-content','','');
}

function writeComment(articleId){
    location.href = "/comment-write-result?id=" + articleId
}


function listPageMove(pageCount, currentPage){
    if (currentPage <= 0 ||currentPage > pageCount ) {
        return;
    }
    location.href = "/board/article-read-result?page=" + currentPage;
}

function idCheck(id) {
    if (id == "") {
        alert("아이디를 입력해 주세요.");
        id.focus();
        return;
    }
    // url = "idCheck.jsp?id=" + id;
    // window.open(url, "IDCheck", "width=300,height=150");
}

function inputCheck(){}
