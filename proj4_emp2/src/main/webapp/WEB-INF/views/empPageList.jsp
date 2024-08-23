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

	<h1>사원목록</h1>

	<a href="/proj4_emp2/emp/insert"><input type="button" id="btn" value="추가"></a><br><br>

	<table border="1">
			<tr>
				<th>rnum</th>
				<th>empno</th>
				<th>ename</th>
				<th>job</th>
				<th>mgr</th>
				<th>hireDate</th>
				<th>sal</th>
				<th>comm</th>
				<th>deptno</th>
			</tr>
		<c:if test="${ not empty map.list }">
			<c:forEach var="list" items="${ map.list }">
				<tr>
					<td>${ list.rnum }</td>
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
		</c:if>
		<c:if test="${ empty map.list }">
			<tr>
				<td colspan="9">자료가 없습니다</td>
			</tr>
		</c:if>
	</table>
	<br>
	
	<%
		Map map = (Map)request.getAttribute("map");
		int totalCount = (int)map.get("totalCount");
		
		String str_countPerPage = (String)request.getAttribute("countPerPage");
		int countPerPage = Integer.parseInt(str_countPerPage);
		
		String str_pageNo = (String)request.getAttribute("page");
		int pageNo = Integer.parseInt(str_pageNo);
		
		// double로 바꾼 값을 Math.ceil을 사용해서 반올림 해주고, 다시 int 타입으로 형변환
		int lastPage = (int)Math.ceil( (double)totalCount / countPerPage );
		
		// 한 번에 보여줄 페이지의 갯수
		int countPerSection = 3;	 
		// 페이지 섹션 위치 
		int position = (int)Math.ceil( (double)pageNo / countPerSection );
		int sec_first = ((position - 1) * countPerSection) + 1;
		int sec_last = position * countPerSection;
		if(sec_last > lastPage) {
			sec_last = lastPage;
		}
		
	%>
	
	<c:set var="lastPage2" value="<%= lastPage %>" scope='page'/>
	
	<c:if test="<%= sec_first == 1 %>">
		[이전]
	</c:if>
	<c:if test="<%= sec_first != 1 %>">
		<a href="page?page=<%= sec_first-1 %>">[이전]</a> 
	</c:if>
	
	<c:forEach var="i" begin="<%= sec_first %>" end="<%= sec_last %>">
	<c:if test="${i eq page}"> [<a href="page?page=${ i }"><strong>${ i }</strong></a>] </c:if>
		<c:if test="${i != page}">[<a href="page?page=${ i }">${ i }</a>]</c:if>
	</c:forEach>
	
	<c:if test="<%= sec_last == lastPage %>">
		[다음]
	</c:if>
	<c:if test="<%= sec_last != lastPage %>">
		<a href="page?page=<%= sec_last+1 %>">[다음]</a>
	</c:if>

</body>
</html>