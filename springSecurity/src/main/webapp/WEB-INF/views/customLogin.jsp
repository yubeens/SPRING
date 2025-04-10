<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 25. 4. 10.
  Time: 오후 3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/login">
    id : <input type="text" name="username" id="username"
                placeholder="Enter id"><br/>
    pwd:<input type="password" name="password"
               id="password" placeholder="Enter password"><br/>
    <button type="submit">로그인 </button>
</form>
</body>
</html>
