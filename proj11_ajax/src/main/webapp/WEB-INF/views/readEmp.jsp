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
</head>
<body>

	<c:if test="${ cmd eq 1 }">
		empno : ${ list.empno }<br>
		ename : ${ list.ename }<br>
		job : ${ list.job }<br>
		<a href="update?empno=${ list.empno }"><input type="button" value="회원수정"></a>
	</c:if>
	
	<c:if test="${ cmd eq 2 }">
			empno : <input type="text" id="empno" name="empno"><br>
			ename : <input type="text" id="ename" name="ename"><br>
			job : <input type="text" id="job" name="job"><br>
			<input type="button" id="insert" value="가입">
	</c:if>
	
	<c:if test="${ cmd eq 3 }">
			empno : <input type="hidden" id="uempno" name="empno" value="${ list.empno }">${ list.empno }<br>
			ename : <input type="text" id="uename" name="ename" value="${ list.ename }"><br>
			job : <input type="text" id="ujob" name="job" value="${ list.job }"><br>
			<input type="button" id="update" value="수정">
	</c:if>
	
	<script>
		// cb : callback 
		function ajax(url, param, cb, method) {
			// javascript에서 false는 null, undefined, 0
			// true는 false가 아닌 것으로 정의되어 있음
			if(!method) method = "get";
			
			const xhr = new XMLHttpRequest();
			xhr.open(method, url);
			xhr.setRequestHeader("Content-Type","application/json"); // json 보내줄 거임
			xhr.send(JSON.stringify(param));
			
			if(typeof cb == "function") {
				xhr.onload = function(){
					cb(xhr.responseText)
				}
			}
		}	
	
		if(document.querySelector("#insert") != null) {
			document.querySelector("#insert").addEventListener("click", function(){
				
				const empno = document.querySelector("#empno").value;
				const ename = document.querySelector("#ename").value;
				const job = document.querySelector("#job").value;
				
				const data = {
						"empno" : empno,
						"ename" : ename,
						"job" : job
				}
				
				ajax("insert", data, function(result){
					if(result >= 1) {
						location.href="emp";
					} else {
						alert("실패!!!!!!!!!!!!!!")
					}
				}, "post")
			})
		}
		
		document.querySelector("#update").addEventListener("click", function() {
			const uempno = document.querySelector("#uempno").value;
			const uename = document.querySelector("#uename").value;
			const ujob = document.querySelector("#ujob").value;
			
			const data = {
					"empno" : uempno,
					"ename" : uename,
					"job" : ujob
			}
			
			ajax("update", data, function(result){
				if(result >= 1) {
					location.href="emp";
				} else {
					alert("실패!!!!!!!!!!!!!!")
				}
			}, "put")
			
		})
	
	</script>
	
</body>
</html>