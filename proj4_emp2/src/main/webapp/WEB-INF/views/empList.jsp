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
</style>
</head>
<body>

	<table border="1">
			<tr>
				<th><input type="checkbox"></th>
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
				<td><input type="checkbox"></td>
				<td>${ list.empno }</td>
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