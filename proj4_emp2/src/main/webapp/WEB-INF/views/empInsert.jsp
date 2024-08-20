<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</style>

</head>
<body>

	<form method="post" action="insert">
		<table border=1>
		<tr><th>empno</th><td><input type="text" name="empno"></td></tr>
		<tr><th>ename</th><td><input type="text" name="ename"></td></tr>
		<tr><th>job</th><td><input type="text" name="job"></td></tr>
		<tr><th>mgr</th><td><input type="text" name="mgr"></td></tr>
		<tr><th>hireDate</th><td><input type="date" name="hireDate"></td></tr>
		<tr><th>sal</th><td><input type="text" name="sal"></td></tr>
		<tr><th>comm</th><td><input type="text" name="comm"></td></tr>
		<tr><th>deptno</th><td><input type="text" name="deptno"></td></tr>
		</table>
		<br>
		<input type="submit" value="추가">
	</form>

</body>
</html>