<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file ="../includes/header.jsp" %>   


<div class="container mt-5">
	<h2>Board Update</h2>
	    <input type="hidden" name="num" id="num" value="${board.num }" >
	     <div class="mb-3 mt-3">
	      <label for="writer">Writer:</label>
	      <input type="text" class="form-control" id="writer" placeholder="Enter userid"
	      name="writer" value="${board.writer}">
	    </div>
	    
	   <div class="mb-3 mt-3">
	      <label for="title">Title:</label>
	      <input type="text" class="form-control" id="title" placeholder="Enter subject"
	      name="title" value="${board.title }">
	    </div>
    	    <div class="mb-3">
	     <label for="content">content:</label>
			  <textarea class="form-control" id="content" name="content" 
			   placeholder="Content goes here" rows=5>${board.content }</textarea>
	   </div>   
	    
     <div  class="mt-3">
    	<button type="button" class="btn btn-primary" id="btnModify">수정</button>
    </div>
</div>
<script>
	$("#btnModify").click(function(){
		dataVal = {
			"num" : $("#num").val(),
			"title" : $("#title").val(),
			"content" : $("#content").val()
		}
		$.ajax({
			type:"put",
			url :"/board/update",
			contentType : "application/json;charset=utf-8",
			data: JSON.stringify(dataVal),
			success:function (resp){
				alert(resp +" 번 글 수정 성공")
				location.href ="/board/list";
			},
			error:function (e){
				alert("수정실패 : "+e);
			}
		})
	})

</script>

</body>
</html>