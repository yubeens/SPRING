<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file ="../includes/header.jsp" %>   
<div class="container mt-5">

	<h2>로그인</h2>
     <div class="mb-3">
      <label for="id">id:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
    </div>
     <div class="mb-3">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password"
             placeholder="Enter password" name="password">
    </div>
    <button type="button" class="btn btn-primary" id="btnLogin">로그인</button>
</div>
<script>
$("#btnLogin").click(function(){
	$.ajax({
        type :"post",
        url : "/member/login",
        contentType:"application/json;charset=utf-8",
        data : JSON.stringify({
                id: $("#id").val(),
                password: $("#password").val()
            }
        )
	})  //ajax
        .done(function (resp) {
            if(resp =="no"){
                alert("회원이 아닙니다. 회원가입하세요")
                location.href="/member/join"
            }else if(resp == "success"){
                alert("로그인 성공")
                location.href="/board/list"
            }else{
                alert("비밀번호를 확인하세요")
            }

        })
        .fail(function () {
            alert("로그인 실패")
        })
}) // btnLogin

</script>

</body>
</html>