<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 	아이디 : ${ dto.userID }<br> --%>
<%-- 	비밀번호 : ${ dto.userPW } --%>
	
	아이디 : ${ memberDTO.userID }<br>
	비밀번호 : ${ memberDTO.userPW }

</body>
</html>