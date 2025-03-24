<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>ADDRESS LIST(${count })</h2>
<table border=1>
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>전화번호</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${alist }" var="address">
			<tr>
				<td>${address.num }</td>
				<td><a href="view?num=${address.num}">${address.name }</a></td>
				<td>${address.addr }</td>
				<td>${address.tel }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>