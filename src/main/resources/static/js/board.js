let index = {
    init: function () {
        $("#btn-save").on("click", () => { // function() {} 대신  ()=>{}를 사용하는 이유 : this를 바인딩하기 위해서
            this.save();
        });
        $("#btn-delete").on("click", () => {
            this.deleteById();
        });
        $("#btn-update").on("click", () => {
            this.update();
        }); // jsp에서 id가 btn-save, btn-delete, btn-update인 버튼이 눌리면 save, delete, update 함수 실행
    },
    save: function() {
        // alert('user의 save함수 호출됨');
        let data = {
            title: $("#title").val(),
            content: $("#content").val(),
            category: $("#category").val()
        }; // id가 title, content, category인 항목들의 value를 date에 입력

        $.ajax({    //ajax로 POST 요청
            type: "POST",
            url: "/api/board", // localhost:8000/api/board로 POST요청
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp) { // 성공 시
            alert("글쓰기가 완료되었습니다.");
            console.log(resp);
            location.href = "/";
        }).fail(function(error) { // 실패 시
            alert(JSON.stringify(error));
        });
    },
    deleteById: function() {
        let id = $("#id").text();
        $.ajax({
            type: "DELETE",
            url: "/api/board/" + id, // localhost:8000/api/board/{id}로 DELETE 요청
            dataType: "json"
        }).done(function(resp) {
            alert("삭제가 완료되었습니다.");
            console.log(resp);
            location.href = "/";
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },
    update: function() {
        let id = $("#id").val();
        let data = {
            title: $("#title").val(),
            content: $("#content").val(),
            category: $("#category").val()
        };

        $.ajax({
            type: "PUT",
            url: "/api/board/" + id, // localhost:8000/api/board/{id}로 PUT 요청
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp) {
            alert("글수정이 완료되었습니다.");
            console.log(resp);
            location.href = "/board/" + id;
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
}

index.init();