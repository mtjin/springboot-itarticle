function ajax_login() {
    var validate = true;
    var form = $(".my-login-validation2");
    if (form[0].checkValidity() === false) {
        event.preventDefault();
        event.stopPropagation();
        validate = false;
    }
    form.addClass('was-validated');
    if (validate) {
        var login_form = $("#login_form").serialize();
        $.ajax({
            type: 'POST',
            url: 'do_login',
            data: login_form,
            dataType: 'json',
            success: function (json) {
                if (json.success === "true") {
                    Swal.fire({
                        title: "Success!",
                        text: "Login Success",
                        icon: "success"
                    }).then(function () {
                        // 성공시 확인 버튼 클릭 후 메인 페이지로 리다이렉트
                        window.location.href = "index";
                    });
                } else {
                    Swal.fire({
                        title: 'Fail', /*상단 타이틀*/
                        text: 'Login Fail', /*내용*/
                        icon: 'error' /*아이콘 타입*/
                    });

                }
            }
        });
    }
}