<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2025-03-21
  Time: 오전 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>상세보기</h2>
이름    : ${person.name}<br>
아이디: ${person.id}<br>
성별: ${person.gender}<br>
직업:${person.job}<br>
<a href="update?id=${person.id}">수정폼</a>
<a href="delete?id=${person.id}">삭제</a>

</body>
</html>
