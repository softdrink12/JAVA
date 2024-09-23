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
			<span id="emp">emp > <a href="emp0">회원목록</a></span>
		</nav>
		<br>
	</header>

	<main>
		<a href="emp0?cmd=join"><input type="button" value="회원가입"></a>
		<section>
			<article>
				<form id="frm" method="get" action="emp0">
					<select name="searchType">
							<option value="1" ${searchType == 1 ? " selected='selected' " : ""}>이름</option>
							<option value="2" ${searchType == 2 ? " selected='selected' " : ""}>직책</option>
							<option value="3" ${searchType == 3 ? " selected='selected' " : ""}>이름+직책</option>
							<option value="4" ${searchType == 4 ? " selected='selected' " : ""}>연봉(이하)</option>
					</select> 
					<input type="text" name="keyword" placeholder="검색어를 입력하세요"
						value="${ keyword }"> <input type="submit" value="검색">
				
				<input type="hidden" name="orderType" value="${ orderType }">
				<table border="1">
					<caption>caption = display:none으로 감추기</caption>
					<thead>
						<tr>
							<th>선택</th>
							<th id="empno">empno
							<c:if test="${ orderType eq 'desc' }">
								↑
							</c:if>
							<c:if test="${ orderType eq 'asc' }">
								↓
							</c:if>
<%-- 							<c:if test="${ orderType eq '' or orderType eq null}"> --%>
<%-- 							</c:if> --%>
							</th>
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
								<td><input type="checkbox" name="check" value="${ list.empno }"></td>
								<td>${ list.empno }</td>
								<td><a href="emp0?cmd=edit&empno=${ list.empno }">${ list.ename }</a></td>
								<td>${ list.job }</td>
								<td>${ list.mgr }</td>
								<td><fmt:formatDate value="${ list.hireDate }"
										pattern="yyyy-MM-dd hh:mm:ss" /></td>
								<td>${ list.sal }</td>
								<td>${ list.comm }</td>
								<td>${ list.deptno }</td>
<!-- 								<td> -->
<!-- 									<form method="post" action="emp0"> -->
<!-- 										<input type="hidden" name="cmd" value="delete"> <input -->
<%-- 											type="hidden" name="empno" value="${list.empno }"> <input --%>
<!-- 											type="submit" value="삭제"> -->
<!-- 									</form> -->
<!-- 								</td> -->
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</form>
			</article>
		</section>
	</main>
<footer>휴먼</footer>
	
<script>

	document.querySelector("#empno").addEventListener("click", function() {
		const orderType = document.querySelector("[name=orderType]");
		
		// '', 'desc', 'asc' 세 개의 값을 순환하게 만들기
		
		console.log(orderType.value, orderType.value == '' );
		if(orderType.value == '') {
			orderType.value = 'desc'
		} else if(orderType.value == 'desc') {
			orderType.value = 'asc'
		} else if(orderType.value == 'asc') {
			orderType.value = ''
		}
		console.log(orderType.value);
		
		const frm = document.querySelector("#frm");
		frm.submit();
		
	})
	
</script>
	
</body>
</html>