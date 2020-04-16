function ajax_register() {
    var validate = true;
    var form = $(".my-register-validation");
    if (form[0].checkValidity() === false) {
        event.preventDefault();
        event.stopPropagation();
        validate = false;
    }
    form.addClass('was-validated');
    if (validate) {
        var register_form = $("#register_form").serialize();
        $.ajax({
            type: 'POST',
            url: 'do_register',
            data: register_form,
            dataType: 'json',
            success: function (json) {
                if (json.success === "true") {
                    Swal.fire({
                        title: "Success!",
                        text: "Congratulations, Register Success",
                        icon: "success"
                    }).then(function () {
                        // 성공시 확인 버튼 클릭 후 login 페이지로 리다이렉트
                        window.location.href = "login";
                    });
                } else {
                    if (json.name === "false") {
                        //이미 존재하는 이름
                        Swal.fire({
                            title: 'Fail', /*상단 타이틀*/
                            text: 'Name is already Exist', /*내용*/
                            icon: 'error' /*아이콘 타입*/
                        });
                    } else if (json.email === "false") {
                        //이미 존재하는 이메일
                        Swal.fire({
                            title: 'Fail', /*상단 타이틀*/
                            text: 'Email is already Exist', /*내용*/
                            icon: 'error' /*아이콘 타입*/
                        });
                    } else {
                        Swal.fire({
                            title: 'Fail', /*상단 타이틀*/
                            text: 'Fail To Register', /*내용*/
                            icon: 'error'/*아이콘 타입*/
                        });
                    }
                }
            }
        });
    }
}