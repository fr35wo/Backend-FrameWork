<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<style>
table {
	border-collapse: collapse;
	width: 300px;
}
</style>
<body>
	<table border="1">
		<tr>
			<td>id</td>
			<td>학번</td>
			<td>이름</td>
			<td>이메일</td>
		</tr>
		<tr>
			<td>${ student.id }</td>
			<td>${ student.studentNumber }</td>
			<td>${ student.studentName }</td>
			<td>${ student.email }</td>
		</tr>

	</table>

</body>
</html>