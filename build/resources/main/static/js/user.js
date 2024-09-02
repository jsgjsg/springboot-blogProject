let index = {
    init: function () {
        $("#btn-save").on("click", () => { // function() {} 대신  ()=>{}를 사용하는 이유 : this를 바인딩하기 위해서
            this.save();
        });
        $("#btn-login").on("click", () => {
            this.login();
        });
        $("#btn-update").on("click", () => {
            this.update();
        });
    },
    login: function() {
        let data = {
            username: $("#username").val(),
            password: $("#password").val()
        };

        $.ajax({
            type: "POST",
            url: "/api/user/login",
            data: JSON.stringify(data), // http body데이터
            contentType: "application/json; charset=utf-8",
            dataType: "json" //응답이 json형식 문자열일 경우 javascript 객체로 변환해줌
        }).done(function(resp) {
            console.log(resp);
            location.href = "/";
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },
    save: function() {
        // alert('user의 save함수 호출됨');
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };

        // console.log(data);

        $.ajax({
            type: "POST",
            url: "/api/user",
            data: JSON.stringify(data), // http body데이터
            contentType: "application/json; charset=utf-8",
            dataType: "json" //응답이 json형식 문자열일 경우 javascript 객체로 변환해줌
        }).done(function(resp) {
            alert("회원가입이 완료되었습니다.");
            console.log(resp);
            location.href = "/";
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },
    update: function() {
        let id = $("#id").val();
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };
        console.log(data);

        $.ajax({
            type: "PUT",
            url: "/api/user/" + id,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp) {
            alert("회원정보 변경이 완료되었습니다.");
            console.log(resp);
            location.href = "/user/detail/" + id;
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
}

index.init();