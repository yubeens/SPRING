<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file ="../includes/header.jsp" %>   

<div class="container mt-5">
	<h2>Board Write</h2>
	 <form action="insert" method="post" name="frm">
	     <div class="mb-3 mt-3">
	      <label for="writer">Writer:</label>
	      <input type="text" class="form-control" id="writer" placeholder="Enter userid"
	      name="writer" >
	    </div>
	    
	   <div class="mb-3 mt-3">
	      <label for="title">Title:</label>
	      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
	    </div>
       <div class="mb-3">
	     <label for="content">content:</label>
			  <textarea class="form-control" id="content" name="content" 
			   placeholder="Content goes here" rows=5></textarea>
	   </div>   
	    
     <div  class="mt-3">
    	<button type="submit" class="btn btn-primary">Submit</button>
    </div>
  </form>
</div>

</body>
</html>