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
</style>
</head>
<body>

	<table border="1">
		<thead>
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
		</thead>
		<tbody id="list">

		</tbody>
	</table>

	<script>
	
	window.addEventListener("load", function(){
		getList();
	})
	
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
	
		function getList(){
			ajax("listemp", null, drawList, "get")
		}
		
		function drawList(text) {
			try {
				const empList = JSON.parse(text);
				
				let html = "";
				let hireDate, YYYY, MM, dd;
				for (let i = 0; i < empList.length; i++) {
//						console.log(empList[i].ename)
				hireDate = new Date(empList[i].hireDate);
				YYYY = hireDate.getFullYear();
				MM = hireDate.getMonth();
				dd = hireDate.getDate();
				if(MM <= 9) {
					MM = '0' + MM;
				}
				if(dd <= 9) {
					dd = '0' + dd;
				}
				
				html += `
					<tr>
						<td>
							<input type="checkbox" name="check" value="${ list.empno }">
						</td>
						<td>\${ empList[i].empno }</td>
						<td><a href="emp0?cmd=edit&empno=${ empList[i].empno }">\${ empList[i].ename }</a></td>
						<td>\${ empList[i].job }</td>
						<td>\${ empList[i].mgr }</td>
						<td>\${YYYY}-\${MM}-\${dd}</td>
						<td>\${ empList[i].sal }</td>
						<td>\${ empList[i].comm }</td>
						<td>\${ empList[i].deptno }</td>
						<td>
							<button type="button" data-empno="\${ empList[i].empno }" class="btnDel" id="btn_\${ empList[i].empno }">삭제</button>
						</td>
					 </tr>
				 `;
				}
				
				
				document.querySelector("#list").innerHTML = html;
				
				const delBtnList = document.querySelectorAll("[id^=btn_]")
//					const delBtnList = document.querySelectorAll(".btnDel");
				for(let btn of delBtnList) {
					btn.addEventListener("click", function(){
//							console.log(this)
						console.log(event.target)
						
						const id = event.target.getAttribute("id")
						// btn_7788 : subString, split 등등 뒤에있는 번호만 가져오기
						const empno = event.target.getAttribute("data-empno")
						console.log("empno", empno)
						
						const data = {
							"empno" : empno
						}
						
						const url = "delete";

						const xhr = new XMLHttpRequest();
						xhr.open("delete", url);
						xhr.setRequestHeader("Content-Type","application/json"); // json 보내줄 거임
						const strData = JSON.stringify(data);
						xhr.send(strData);
			
						xhr.onload = function() {
							console.log(xhr.responseText)
						}		 
						
					})
				}
				bind()
			} catch (e) {
				console.log("ERROR : url : ", url, e);
			}
		}
		
		function bind() {
			const delBtnList = document.querySelectorAll("[id^=btn_]")
		for(let btn of delBtnList) {
			btn.addEventListener("click", function(){
				console.log(event.target)
				
				const id = event.target.getAttribute("id")
				const empno = event.target.getAttribute("data-empno")
				console.log("empno", empno)
				
				const data = {
					"empno" : empno
				}
				
				ajax("delete", data, function(result){
					if(result != 0) {
						// 리스트 그리기 
						getList()
					} else {
						alert("fail")
					}
				}, "delete")
				})
			}
		}
		
// 		window.addEventListener("load", function() {

// 			const url = "listemp";

// 			const xhr = new XMLHttpRequest();
// 			xhr.open("get", url);
// 			xhr.send();

// 			xhr.onload = function() {
// 				console.log(xhr.responseText)
// 				let text = xhr.responseText;
// 				try {
// 					const empList = JSON.parse(text);
					
// 					let html = "";
// 					let hireDate, YYYY, MM, dd;
// 					for (let i = 0; i < empList.length; i++) {
// // 						console.log(empList[i].ename)
// 					hireDate = new Date(empList[i].hireDate);
// 					YYYY = hireDate.getFullYear();
// 					MM = hireDate.getMonth();
// 					dd = hireDate.getDate();
// 					if(MM <= 9) {
// 						MM = '0' + MM;
// 					}
// 					if(dd <= 9) {
// 						dd = '0' + dd;
// 					}
					
// 					html += `
// 						<tr>
// 							<td>
// 								<input type="checkbox" name="check" value="${ list.empno }">
// 							</td>
// 							<td>\${ empList[i].empno }</td>
// 							<td><a href="emp0?cmd=edit&empno=${ empList[i].empno }">\${ empList[i].ename }</a></td>
// 							<td>\${ empList[i].job }</td>
// 							<td>\${ empList[i].mgr }</td>
// 							<td>\${YYYY}-\${MM}-\${dd}</td>
// 							<td>\${ empList[i].sal }</td>
// 							<td>\${ empList[i].comm }</td>
// 							<td>\${ empList[i].deptno }</td>
// 							<td>
// 								<button type="button" data-empno="\${ empList[i].empno }" class="btnDel" id="btn_\${ empList[i].empno }">삭제</button>
// 							</td>
// 						 </tr>
// 					 `;
// 					}
					
// 					document.querySelector("#list").innerHTML = html;
					
// 					const delBtnList = document.querySelectorAll("[id^=btn_]")
// // 					const delBtnList = document.querySelectorAll(".btnDel");
// 					for(let btn of delBtnList) {
// 						btn.addEventListener("click", function(){
// // 							console.log(this)
// 							console.log(event.target)
							
// 							const id = event.target.getAttribute("id")
// 							// btn_7788 : subString, split 등등 뒤에있는 번호만 가져오기
// 							const empno = event.target.getAttribute("data-empno")
// 							console.log("empno", empno)
							
// 							const data = {
// 								"empno" : empno
// 							}
							
// 							const url = "delete";

// 							const xhr = new XMLHttpRequest();
// 							xhr.open("delete", url);
// 							xhr.setRequestHeader("Content-Type","application/json"); // json 보내줄 거임
// 							const strData = JSON.stringify(data);
// 							xhr.send(strData);
				
// 							xhr.onload = function() {
// 								console.log(xhr.responseText)
// 							}		 
							
// 						})
// 					}
					
// 				} catch (e) {
// 					console.log("ERROR : url : ", url, e);
// 				}

// 			}

// 		})
	</script>
</body>
</html>