<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

아무${ a3 }글씨<br>
아무${ a4 }글씨<br>

	<c:set var="id" value="idid" scope="page"></c:set>
	${ id }<br>
	
	<%
		int a = 10;
	%>
	<c:set var="a1" value="<%= a %>" scope="page"/>
	${ a1 } <br>
	<c:set var="a2" value="${ id }" scope="page"/>
	${ a2 } <br>
	
	scope 생략시 page<br>
	<c:set var="a3" value="login"/>
	
	<c:set var="a4" value="login2" scope="session"/>
	
	<%
		// scope page
		System.out.println( "a3 : " + pageContext.getAttribute("a3") );
		// scope session
		System.out.println( "a4 : " + session.getAttribute("a4") );
	%>
	
	<hr>
	<c:set var="game" value="메이플" scope="page"/>
	<c:set var="game" value="발로란트" scope="request"/>
	<c:set var="game" value="메탈슬러그" scope="session"/>
	<c:set var="game" value="스컬" scope="application"/>
	
	el: page > request > session > application 순으로 찾음 <br>
	
	game : ${ game }<br>
	pageScope : ${ pageScope.game }<br>
	requestScope : ${ requestScope.game }<br>
	sessionScope : ${ sessionScope.game }<br>
	applicationScope : ${ applicationScope.game }<br>
	<hr>
	<c:if test="true">
		<strong>항상 참</strong>
	</c:if>
	<br>
	
	<c:if test="${ id eq'idid' }">
		관리자입니다<br>
	</c:if>
	<c:if test="${ id ne'idid' }">
		관리자가 아닙니다<br>
	</c:if>
	<c:if test="${ not (id ne 'idid') }">
		관리자가 아닙니다<br>
	</c:if>
	
	<c:choose>
		<c:when test="${ empty id }">
			id는 필수입니다
		</c:when>
		<c:when test="${ id == 'id3' }">
			관리자입니다
		</c:when>
		<c:otherwise>
			당신의 id는 ${ id } 입니다
		</c:otherwise>
	</c:choose>
	<hr>
	
	<%
		List list = new ArrayList();
	
		for(int i = 0; i < 4; i++) {
			Map map = new HashMap();
			map.put("plan1", "알바"+i);
			map.put("plan2", "뒷풀이"+i);
			map.put("plan3", "잠자기"+i);
			
			list.add(map);
		}
	%>
	
	<c:set var="list2" value="<%= list %>" scope="page"/>
	
	<c:forEach var="dinner" items="${ list2 }">
		plan1 : ${ dinner.plan1 }<br>
		plan2 : ${ dinner.plan2 }<br>
		plan3 : ${ dinner.plan3 }<br>
		<br>
	</c:forEach>
	<hr>
	<c:forEach var="i" begin="0" end="3">
		i : ${ i }<br>
	</c:forEach>
	<hr>
	step<br>
	<c:forEach var="i" begin="0" end="10" step="3">
		i : ${ i }<br>
	</c:forEach>
	<hr>
	varStatus<br>
	<c:forEach var="i" begin="0" end="10" step="3" varStatus="loop">
		i : ${ i }
		<c:if test="${ not loop.last }">
			,
		</c:if>
		<br>
		loop.index : ${ loop.index }<br>
		loop.count : ${ loop.count }<br>
		loop.first : ${ loop.first }<br>
		loop.last : ${ loop.last }<br>
	</c:forEach>
	<hr>
	end가 items의 갯수보다 크면 items 끝까지만 돌고 에러 없음 <br>
	<c:forEach var="dinner" items="${ list2 }" begin="1" end="2">
		${ dinner }<br>
	</c:forEach>
	
</body>
</html>