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
	}
	
	td {
		padding: 0 20px;
	}
	
</style>
</head>
<body>

	<h1>Todo list</h1>
	
<%-- 	${ list1 } --%>
<!-- 	<hr> -->
<%-- 	${ list1[0] } --%>
<!-- 	<hr> -->
<%-- 	${ list1[5].title } --%>
<!-- 	<hr> -->
<%-- 	${ list1[5]["title"] } --%>
<!-- 	<hr> -->
<%-- 	123${null}456 --%>
	
<%-- 	<c:forEach var="list2" items="${ list1 }" begin="0" end="20"> --%>
<%-- 		<input type="checkbox">${ list2.title }  ${ list2.dueDate }<br> --%>
<%-- 	</c:forEach> --%>
	
	<table border="1">
	<c:forEach var="list2" items="${ list1 }" begin="0" end="20" varStatus="loop">
		<tr>
			<td>
				<c:if test="${ not loop.last }"><input type="checkbox"></c:if>
				<c:if test="${ loop.last }"><input type="checkbox" checked="checked"></c:if>
			</td>
			<td>${ list2.title }</td>
			<td>${ list2.dueDate }</td>
		</tr>
	</c:forEach>
	</table>
	

</body>
</html>