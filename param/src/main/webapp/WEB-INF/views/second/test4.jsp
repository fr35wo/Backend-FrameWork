<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
table {
	border-collapse: collapse;
}

td {
	width: 100;
	padding: 5px;
	border: 1px solid gray;
}
</style>
</head>
<body>
	<table>
		<tr>
			<td>name</td>
			<td>${ person.name }</td>
		</tr>
		<tr>
			<td>weight</td>
			<td><fmt:formatNumber value="${ person.weight }" pattern="#.#" />kg
				<fmt:formatNumber value="${ person.weight * 1000 }" pattern="#,###" />g
			</td>
		</tr>
		<tr>
			<td>birthday</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd"
					value="${ person.birthday }" /></td>
		</tr>
	</table>
</body>
</html>
