<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file ="../includes/header.jsp" %>
<div class="container mt-3">
    <form action="join" method="post" id="frm">
        <div class="mb-3 mt-3">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
        </div>
        <div class="row">
            <div class="col mb-3">
                <label for="id">id:</label>
                <input type="text" class="form-control" id="id" placeholder="Enter Userid" name="id">
            </div>
            <div class="col mb-3 align-self-end">
                <span id="idcheck"></span>
            </div>
        </div>
        <div class="mb-3">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password"
                   placeholder="Enter password" name="password">
        </div>

        <div class="mb-3">
            <label for="pwd_check">Password_Check:</label>
            <input type="password" class="form-control" id="pwd_check"
                   placeholder="Enter pwd_check" name="pwd_check">
        </div>
        <div class="mb-3">
            <label for="addr">Address:</label>
            <input type="password" class="form-control" id="addr"
                   placeholder="Enter Address" name="addr">
        </div>
        <div  class="mt-3">
            <button type="button" class="btn btn-primary" id="btnJoin">회원가입</button>
        </div>
    </form>
</div>
<script>
    $("#btnJoin").click(function () {
        const  data = {
            id : $("#id").val(),
            name : $("#name").val(),
            password : $("#password").val(),
            addr : $("#addr").val()
        }
        $.ajax({
            type : "post",
            url : "/member/join",
            contentType : "application/json;charset=utf-8",
            data : JSON.stringify(data)
            })
            .done(function (resp) {
                alert(resp)
                if(resp == "success"){
                    alert("회원 가입을 축하합니다");
                    $("#idcheck").html("");
                    location.href="/member/login"
                }else if(resp =="fail"){
                   $("#idcheck").html("<b>아이디 중복확인 하세요</b>")
                   $("#id").val("");
                }
            })
            .fail(function (e) {
                alert("회원가입실패 :" + e);
            })
    })
</script>
</body>
</html>
