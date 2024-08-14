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
	
	<form method="post" action="register">
		title : <input type="text" name="title" placeholder="할 일을 적어주세요"><br>
		duedate : <input type="date" name="dueDate"><br>
		finished : 
		<input type="radio" name="finished" value="N" checked="checked"> 미완료
		<input type="radio" name="finished" value="Y"> 완료 <br><br>
		<input type="submit" value="등록">
		
		<a href="list"><input type="button" value="뒤로가기"></a>

	</form>
	
</body>
</html>