<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/common.css" />
<style>
form {
	width: 600px;
	margin: auto;
	box-shadow: 0 0 4px lightgray, 2px 2px 4px gray;
	overflow: auto;
}

div.title {
	font-size: 20pt;
	padding: 10px;
	background-color: #eee;
}

table {
	margin: 20px;
}

td {
	min-width: 100;
	padding: 5px;
}

td:nth-child(1) {
	text-align: right;
}

button {
	margin: 5px 0 20px 20px;
}

div.message {
	border-radius: 10px;
	padding: 12px;
	margin: 10px;
	background-color: #ffa;
	border: 1px solid #cc0;
}
</style>
</head>
<body>
	<div class="container">
		<form method="post">
			<div class="title">학생 정보</div>
			<table>
				<tr>
					<td>id</td>
					<td><input type="text" value="${ student.id }" readonly
						disabled /></td>
				</tr>
				<tr>
					<td>학번</td>
					<td><input type="text" name="studentNo"
						value="${ student.studentNo }" /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${ student.name }" /></td>
				</tr>
				<tr>
					<td>학과</td>
					<td><select name="departmentId">
							<option value="1"
								${ student.departmentId == 1 ? "selected" : "" }>소프트웨어공학과</option>
							<option value="2"
								${ student.departmentId == 2 ? "selected" : "" }>컴퓨터공학과</option>
							<option value="3"
								${ student.departmentId == 3 ? "selected" : "" }>정보통신공학과</option>
							<option value="4"
								${ student.departmentId == 4 ? "selected" : "" }>글로컬IT공학과</option>
					</select></td>
				</tr>
				<tr>
					<td>전화</td>
					<td><input type="text" name="phone" value="${ student.phone }" /></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><input type="text" name="sex" value="${ student.sex }" /></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" value="${ student.email }" /></td>
				</tr>
			</table>
			<button type="submit" class="btn">저장</button>
			<c:if test="${ not empty message }">
				<div class="message">${ message }</div>
			</c:if>
		</form>
	</div>
</body>
</html>
