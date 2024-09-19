<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border-collapse: collapse;
}

td {
	padding: 10px;
}

#logo {
	font-size: 40px;
}

#emp {
	font-size: 20px;
}
</style>
</head>
<body>

	<header>
		<span id="logo">Logo</span> <br>
		<nav>
			<span id="emp">emp > 회원목록</span>
		</nav>
		<br>
		<a href="emp0?cmd=join"><input type="button" value="회원가입"></a>
	</header>

	<main>
		<section>
			<article>
				<table border="1">
					<caption>caption = display:none으로 감추기</caption>
					<thead>
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
					</thead>
					<tbody>
						<c:forEach var="list" items="${ emplist }">
							<tr>
								<td>${ list.empno }</td>
								<td><a href="emp0?cmd=edit&empno=${ list.empno }">${ list.ename }</a></td>
								<td>${ list.job }</td>
								<td>${ list.mgr }</td>
								<td>
								<fmt:formatDate value="${ list.hireDate }" pattern="yyyy-MM-dd hh:mm:ss"/>
								</td>
								<td>${ list.sal }</td>
								<td>${ list.comm }</td>
								<td>${ list.deptno }</td>
								<td>
									<form method="post" action="emp0">
										<input type="hidden" name="cmd" value="delete">
										<input type="hidden" name="empno" value="${list.empno }">
										<input type="submit" value="삭제">
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</article>
		</section>
	</main>

</body>
</html>