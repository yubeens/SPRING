<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file ="includes/header.jsp" %>
<div class="container mt-3">
    <h2>File List</h2>
    <div class="row">
        <c:forEach items="${farr }" var="item">
            <div class="card col-4 mt-3" style="width:300px">
                <img class="card-img-top" src="/resources/images/${item.fileimage}"
                     alt="${item.fileimage}"
                     style="width:200px;height:100px">
                <div class="card-body">
                    <h4 class="card-title">${item.title }</h4>
                    <p class="card-text">${item.writer }</p>
                    <p class="card-text">${item.content }</p>
                </div>
            </div>
        </c:forEach>
    </div>

    <br>
</div>


</body>
</html>
