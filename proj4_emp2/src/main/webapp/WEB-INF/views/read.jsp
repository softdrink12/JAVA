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
		width: 500px;
	}
	
	td {
		padding: 5px 20px;
		text-align: center;
	}
	
 	a:link{ 
         color: inherit; 
         text-decoration: none; 
     } 

     a:visited{ 
          color: inherit; 
          text-decoration: none; 
     } 
     
     #btn {
		border: 1px solid black;
		width: 60px;
		height: 30px;
		background-color: white;
	}

</style>
</head>
<body>

	<h1>상세정보</h1>

	<table border="1">
			<tr><th>empno</th><td>${ reading.empno }</td></tr>
		<tr><th>ename</th><td>${ reading.ename }</td></tr>
		<tr><th>job</th><td>${ reading.job }</td></tr>
		<tr><th>mgr</th><td>${ reading.mgr }</td></tr>
		<tr><th>hireDate</th><td>${ reading.hireDate }</td></tr>
		<tr><th>sal</th><td>${ reading.sal }</td></tr>
		<tr><th>comm</th><td>${ reading.comm }</td></tr>
		<tr><th>deptno</th><td>${ reading.deptno }</td></tr>
		</table>
		<br>
		<a href="/proj4_emp2/emp/update?empno=${ reading.empno }"><input type="button" id="btn" value="수정"></a>
		<a href="/proj4_emp2/emp/delete?empno=${ reading.empno }"><input type="button" id="btn" value="삭제"></a>
</body>
</html>