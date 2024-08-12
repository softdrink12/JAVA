<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border-collapse: collapse;
		width: 300px;
		text-align: center;
	}
</style>
</head>
<body>

<%-- 	<div>${ dto.tno }</div> --%>
<%-- 	<div>${ dto.title }</div> --%>
<%-- 	<div>${ dto.dueDate }</div> --%>
<%-- 	<div>${ dto.finished }</div> --%>
<!-- 	<br> -->
	
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>날짜</td>
			<td>finished</td>
		</tr>
		<tr>
			<td>${ dto.tno }</td>
			<td>${ dto.title }</td>
			<td>${ dto.dueDate }</td>
			<td>${ dto.finished }</td>
		</tr>
	</table>
	<br>

	<c:url var="url1" value="/todo/list">
<%-- 		<c:param name="tno" value="${dto.tno }" /> --%>
	</c:url>
	<a href="${ url1 }"><input type="button" value="목록으로 돌아가기"></a>



</body>
</html>