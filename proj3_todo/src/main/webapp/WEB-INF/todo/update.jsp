<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할 일 작성 | 할 일 관리</title>
</head>
<body>
	
	<form method="post" action="update">
		<input type="hidden" name="tno" value="${ dto.tno }"><br>
		title : <input type="text" name="title" value="${ dto.title }"><br>
		duedate : <input type="date" name="dueDate" value="${ dto.dueDate }"><br>
		finished : 
		<c:if test="${ dto.finished eq false }">
			<input type="radio" name="finished" value="N" checked="checked"> 미완료
			<input type="radio" name="finished" value="Y"> 완료 <br><br>
		</c:if>
		<c:if test="${ dto.finished eq true }">
			<input type="radio" name="finished" value="N"> 미완료
			<input type="radio" name="finished" value="Y" checked="checked"> 완료 <br><br>
		</c:if>
		<a href="list"><input type="submit" value="수정"></a>
		
<!-- 		<a href="list"><input type="button" value="뒤로가기"></a> -->

	</form>
	
</body>
</html>