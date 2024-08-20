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
		text-align: center;
	}

	#btn {
		border: 1px solid black;
		width: 60px;
		height: 30px;
		background-color: white;
	}
	input {
		width: 90%;
	}
	
</style>
</head>
<body>

	<form method="post" action="update">
		<table border=1>
		<tr><th>empno</th><td>${ update.empno }</td></tr>
		<tr><th>ename</th><td><input type="text" name="ename" value="${ update.ename }"></td></tr>
		<tr><th>job</th><td><input type="text" name="job" value="${ update.job }"></td></tr>
		<tr><th>mgr</th><td><input type="text" name="mgr" value="${ update.mgr }"></td></tr>
		<tr><th>hireDate</th><td><input type="date" name="hireDate" value="${ update.hireDate }"></td></tr>
		<tr><th>sal</th><td><input type="text" name="sal" value="${ update.sal }"></td></tr>
		<tr><th>comm</th><td><input type="text" name="comm" value="${ update.comm }"></td></tr>
		<tr><th>deptno</th><td><input type="text" name="deptno" value="${ update.deptno }"></td></tr>
		</table>
		<br>
		<input type="submit" id="btn" value="수정">
	</form>

</body>
</html>