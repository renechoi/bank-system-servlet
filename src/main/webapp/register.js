$("body").prepend("<header></header>");
// $("header").load("./frontpage/header.html header");
$("header").load("/header.html header");


function goHome() {
    location.href='/'
    // location.href = '../bank/register-page.jsp'
}

function register() {
    location.href='/bank/view/register-form'
    // location.href = '../bank/register-page.jsp'
}

function login() {
    location.href = "/bank/view/login-form"
}

function logout() {
    location.href = "/bank/view/logout-result"
}

function deposit() {
    location.href = "/bank/view/deposit-form"
}

function withdraw() {
    location.href = "/bank/view/withdraw-form"
}

function transfer() {
    location.href = "/bank/view/transfer-form"
}

function checkBalance() {
    location.href = "/bank/view/check-balance-result"
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
