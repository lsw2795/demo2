<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>책 등록 페이지</h1>
	<form action="<c:url value='/book/write'/>" method="post">
		제목 : <input type="text" name="title"><br>
		가격 : <input type="text" name="price"><br>
		출판사 : <input type="text" name="publisher"><br><br>
		<button type="submit">등록</button>
		<hr>
		<a href="<c:url value='/book/list'/>">책 목록</a>
	</form>
</body>
</html>