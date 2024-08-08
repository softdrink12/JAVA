<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	\${ 10 + 1 } : ${ 10 + 1 }<br>
	\${ "10" + 1 } : ${ "10" + 1 } : EL은 계산할 때 문자를 숫자로 바꿔서 계산한다
	<br>
<%-- 	\${ "a" + 1 } : ${ "a" + 1 }<br> --%>
	\${ null + 1 } : ${ null + 1 }<br>
	
	<%--jsp파일에서 나누기는 div로 함 --%>
	\${ 10 / 3 } : ${ 10 / 3 }<br>
	\${ 10 div 3 } : ${ 10 div 3 }<br>
	
	<%--jsp파일에서 나머지는 mod로 함 --%>
	\${ 10 % 3 } : ${ 10 % 3 }<br>
	\${ 10 mod 3 } : ${ 10 mod 3 }<br>
	<hr>
	\${ 10 == 10 } : ${ 10 == 10 }<br>
	\${ "10" == "10" } : ${ "10" == "10" }<br>
	\${ "10" eq "10" } : ${ "10" eq "10" }<br>
	
	\${ 10 != 10 } : ${ 10 != 10 }<br>
	\${ 10 ne 10 } : ${ 10 ne 10 }<br>
	
	\${ 100 > 10 } : ${ 100 > 10 }<br>
	\${ 100 gt 10 } : ${ 100 gt 10 }<br>
	
	\${ 100 < 10 } : ${ 100 < 10 }<br>
	\${ 100 lt 10 } : ${ 100 lt 10 }<br>
	
	\${ 100 >= 10 } : ${ 100 >= 10 }<br>
	\${ 100 ge 10 } : ${ 100 ge 10 }<br>
	
	\${ 100 <= 10 } : ${ 100 <= 10 }<br>
	\${ 100 le 10 } : ${ 100 le 10 }<br>
	
	\${ (100 gt 10) eq "true" } : ${ (100 gt 10) eq "true" }
	<hr>
	\${ (100 gt 10) && (100 gt 10) } : ${ (100 gt 10) && (100 gt 10) }<br>
	\${ (100 gt 10) and (100 gt 10) } : ${ (100 gt 10) and (100 gt 10) }<br>
	
	\${ (100 gt 10) || (100 gt 10) } : ${ (100 gt 10) || (100 gt 10) }<br>
	\${ (100 gt 10) or (100 gt 10) } : ${ (100 gt 10) or (100 gt 10) }<br>
	
	\${ !(100 gt 10) } : ${ !(100 gt 10) }
	\${ not(100 gt 10) } : ${ not(100 gt 10) }
	<hr>
	<h3>출력할 것이 있으면 empty는 false</h3>
	<h3>출력할 것이 없으면 empty는 true</h3>
	\${ empty "word" } : ${ empty "word" }<br>
	\${ empty null } : ${ empty null }<br>
	\${ empty "" } : ${ empty "" }<br>
	
</body>
</html>