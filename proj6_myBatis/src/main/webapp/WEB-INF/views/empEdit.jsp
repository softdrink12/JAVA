<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원수정</h1>
	<form method="post" action="emp0">
		empno : <input type="text" name="empno" value="${ emplist.empno }"><br>
		ename : <input type="text" name="ename" value="${ emplist.ename }"><Br>
		hireDate : <input type="date" name="hireDate" value="${ emplist.hireDate }">
		<br>
		<br>
		<input type="hidden" value="edit" name="cmd">
		<input type="submit" value="수정">
	</form>
</body>
</html>