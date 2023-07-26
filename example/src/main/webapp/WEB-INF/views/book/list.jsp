<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value='/js/jquery-3.7.0.min.js'/>"></script>
<script type="text/javascript">	
	$(function(){
	    $('.box2 tbody tr').hover(function(){
	       $(this).css('background','skyblue');
	    },function(){
	       $(this).css('background','');
	    });
	 });
	
	function pageFunc(curPage){
		$('input[name="currentPage"]').val(curPage);
		$('form[name="frmPage"]').submit();
	}
</script>
</head>
<body>
<form action="<c:url value='/book/list'/>" 
	name="frmPage" method="post">
	<input type="text" name="currentPage">
	<input type="text" name="searchKeyword" value="${param.searchKeyword}">
	<input type="text" name="searchCondition" value="${param.searchCondition}">
</form>

	<h1>책 리스트</h1>
	<table style="text-align: center" border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>가격</th>
			<th>출판사</th>
			<th>등록일</th>
		</tr>
	
		<c:if test="${empty list}">
			<tr>
				<td colspan="5">책 목록이 없습니다.</td>
			</tr>
		
		</c:if>
		<c:if test="${!empty list}">
			<c:forEach var="vo" items="${list}"> 
				<tr>
					<td>${vo.no}</td>
					<td>${vo.title}</td>
					<td>${vo.price}</td>
					<td>${vo.publisher}</td>
					<td><fmt:formatDate value="${vo.joindate}" pattern="yyyy-MM-dd"/></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	
	<div class="divPage">
	<!-- 페이지 번호 추가 -->		
	<!-- 이전 블럭으로 이동 -->
	<c:if test="${pagingInfo.firstPage>1 }">
		<a href="#" onclick="pageFunc(${pagingInfo.firstPage-1})">
			<img src="<c:url value='/images/first.JPG'/>">
		</a>
	</c:if>	
					
	<!-- [1][2][3][4][5][6][7][8][9][10] -->
	<c:forEach var="i" begin="${pagingInfo.firstPage }" end="${pagingInfo.lastPage }">		
		<c:if test="${i == pagingInfo.currentPage }">		
			<span style="color: blue;font-weight: bold;font-size: 1em">${i}</span>
        	</c:if>
		<c:if test="${i != pagingInfo.currentPage }">		
	         <a href="#" onclick="pageFunc(${i})">[${i}]</a>
	    </c:if>   		
	</c:forEach>
	
	<!-- 다음 블럭으로 이동 -->
	<c:if test="${pagingInfo.lastPage < pagingInfo.totalPage }">
         <a href="#" onclick="pageFunc(${pagingInfo.lastPage+1})">
			<img src="<c:url value='/images/last.JPG'/>">
		</a>
	</c:if>
	<!--  페이지 번호 끝 -->
</div>
	
	<div class="search">
		<form method="post" action="<c:url value='/book/list'/>">
			<select name="searchCondition">
				<option value="title"
				<c:if test="${param.searchCondition=='title'}">
					selected = 'selected'
				</c:if>
				>제목</option>
				<option value="publisher"
				<c:if test="${param.searchCondition=='publisher'}">
					selected = 'selected'
				</c:if>
				>출판사</option>
			</select>
			<input type="text" name="searchKeyword" value="${param.searchKeyword}">
			<input type="submit" value="검색">
		</form>
	</div>
</body>
</html>