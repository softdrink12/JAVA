<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${ cmd eq 1 }">
		empno : ${ list.empno }<br>
		ename : ${ list.ename }<br>
		job : ${ list.job }<br>
		<a href="update?empno=${ list.empno }"><input type="button" value="회원수정"></a>
	</c:if>
	
	<c:if test="${ cmd eq 2 }">
		<form action="insert" method="post">
			empno : <input type="text" name="empno"><br>
			ename : <input type="text" name="ename"><br>
			job : <input type="text" name="job"><br>
			<input type="submit" value="가입">
		</form>
	</c:if>
	
	<c:if test="${ cmd eq 3 }">
		<form action="update" method="post">
			empno : <input type="hidden"name="empno" value="${ list.empno }">${ list.empno }<br>
			ename : <input type="text" name="ename" value="${ list.ename }"><br>
			job : <input type="text" name="job" value="${ list.job }"><br>
			<input type="submit" value="수정">
		</form>
	</c:if>
	
	
</body>
</html>