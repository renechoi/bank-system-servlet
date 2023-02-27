$(document).ready(function () {
    console.log("ajax")
    // 아이디체크  url : "api/emailCheck.jsp", "/mysite/user",
    $("#btn-checkid").on("click", function () {

        $.ajax({
            url : '/check-id',
            type: "post",
            data : {
                memberId : $('#memberId').val()
            },
            dataType: "json",
            success : function(result) {
                if (result == false){
                    $("#checkid-msg").text("사용할 수 있는 아이디 입니다.")
                    $("#checkid-msg").css("color", "green")
                } else {
                    $("#checkid-msg").text("이미 존재하는 아이디입니다.")
                    $("#checkid-msg").css("color", "red")
                }
            },
            error: function (XHR, status, error) {
                console.log(status)
                // console.error(status + " : " + error);
            }
        });
    });

});