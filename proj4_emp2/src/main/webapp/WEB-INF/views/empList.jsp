<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="emp2.dto.EmpDTO" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border-collapse: collapse;
		width: 700px;
	}
	
	td {
		padding: 5px;
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

	<div style="text-align: right;">
		
		<c:if test="${ not empty loginDTO }">
			${ loginDTO.ename }님 환영합니다
		</c:if>
		<c:if test="${ empty loginDTO }">
			<a href="login.jsp">로그인</a>
		</c:if>
		
	</div>

	<h1>사원목록</h1>

	<a href="/proj4_emp2/emp/insert"><input type="button" id="btn" value="추가"></a><br><br>

	<table border="1">
			<tr>
				<th>empno</th>
				<th>ename</th>
				<th>job</th>
				<th>mgr</th>
				<th>hireDate</th>
				<th>sal</th>
				<th>comm</th>
				<th>deptno</th>
			</tr>
		<c:forEach var="list" items="${ list }">
			<tr>
				<td><a href="emp/read?empno=${ list.empno }">${ list.empno }</a></td>
				<td>${ list.ename }</td>
				<td>${ list.job }</td>
				<td>${ list.mgr }</td>
				<td>${ list.hireDate }</td>
				<td>${ list.sal }</td>
				<td>${ list.comm }</td>
				<td>${ list.deptno }</td>
			</tr>
		</c:forEach>
	</table>
<!-- 	<hr> -->

			<%--
			<%
				List<EmpDTO> list = (List)request.getAttribute("list");
// 				for(int i = 0; i < list.size(); i++) {
// 					EmpDTO dto = (EmpDTO)list.get(i);
					
// 					int empno = dto.getEmpno();
// 					out.println(empno + ", ");
// 				}

				for ( EmpDTO dto : list ) {
					int empno = dto.getEmpno();
					out.print(empno + ", ");
				}
			%>
			--%> 

</body>
</html>