$("body").prepend("<header></header>");
$("header").load("./frontpage/header.html header");


function register() {
    // location.href='register-page.html'
    location.href = '../view/register-page.jsp'
}

function login() {
    location.href = "../view/login-page.jsp"
}

function logout() {
    location.href = "/view/logout-result"
}

function deposit() {
    location.href = "../view/deposit.jsp"
}

function withdraw() {
    location.href = "../view/withdraw.jsp"
}

function transfer() {
    location.href = "../view/transfer.jsp"
}

function checkBalance() {
    location.href = "/view/check-balance"
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

