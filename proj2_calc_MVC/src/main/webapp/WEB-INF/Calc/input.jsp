<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	action의 기본값: 내 주소 
	method의 기본값: get
 -->

	<!-- 	<form action="calcResult.jsp"> -->
	<!-- 		<input type="number" name="num1"> -->
	<!-- 		<input type="number" name="num2"> -->
	<!-- 		<button type="submit">SEND</button> -->
	<!-- 	</form> -->

	<form method="post" action="makeResult">
		<input type="number" name="num1"> <input type="number"
			name="num2">
		<button type="submit">SEND-post</button>
	</form>
	<hr>
	<form method="get" action="makeResult">
		<input type="text" name="text1" value="text2"><br> <input
			type="button" name="btn1" value="btn2"><br>
		<button type="button" name="btn2" value="btn3">button2</button>
		<br> <input type="password" name="pw1" value="pw2"><br>
		<input type="hidden" name="hidden1" value="hidden2"><br>

		<input type="radio" name="radio1" value="radio2">radio2<br>
		<input type="radio" name="radio1" value="radio3">radio3<br>

		<input type="checkbox" name="chk1" value="chk2">check2<br>
		<input type="checkbox" name="chk1" value="chk3">check3<br>
		<input type="checkbox" name="chk1" value="chk4">check4<br>

		<input type="date" name="date1"> <input type="text"
			name="text2" value="text3" style="display: none;"><br> <select
			name="select1">
			<option value="op1">option1</option>
			<option value="op2">option2</option>
			<option value="op3">option3</option>
			<option value="op4">option4</option>
		</select>

		<textarea name="textarea1">초기값
		enter
		enter</textarea>

		<button type="submit">SEND-get</button>
	</form>

	전달받은 값 : ${param.text}

</body>
</html>