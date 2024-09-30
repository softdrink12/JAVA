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
		window.addEventListener("load", function() {

			const url = "listemp";

			const xhr = new XMLHttpRequest();
			xhr.open("get", url);
			xhr.send();

			xhr.onload = function() {
				console.log(xhr.responseText)

				try {
					const empList = JSON.parse(xhr.responseText);
					
					let html = "";
					let hireDate, YYYY, MM, dd;
					for (let i = 0; i < empList.length; i++) {
// 						console.log(empList[i].ename)
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
						 </tr>
					 `;
					}
					document.querySelector("#list").innerHTML = html;
				} catch (e) {
					console.log("ERROR : url : ", url, e);
				}

			}

		})
	</script>
</body>
</html>