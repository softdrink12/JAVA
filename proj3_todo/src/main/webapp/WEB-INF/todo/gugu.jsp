<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>구구단</h1>
	
<%-- 	${ gugulist } --%>
	
	<form action="go">
	<input type="text" name="tx">
	<input type="submit" value="구구단이동">
	</form>
	
<%-- 		<c:if test="${ gugulist eq tx }"> --%>
<%-- 			<c:url var="url1" value="/gugu/go"> --%>
<%-- 			</c:url> --%>
<%-- 		</c:if> --%>


</body>
</html>