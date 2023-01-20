<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> --%>
<!--   spring form 확장 태그를 사용하기 위한 선언이다. -->
<!--   spring form 확장 태그의 이름은 form: 으로 시작한다. (prefix) -->
<!--   spring form 확장 태그를 사용하면, 입력 폼을 조금 더 간결하게 구현할 수 있다. -->
<!--   특히 select 태그 구현이 간결해진다. -->


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
		<form:form method="post" modelAttribute="student">
			<div class="title">학생 정보</div>
			<table>
				<tr>
					<td>id</td>
					<td><form:input path="id" readonly="true" disabled="true" /></td>
				</tr>
				<tr>
					<td>학번</td>
					<td><form:input path="studentNo" /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>학과</td>
					<td><form:select path="departmentId" items="${ departments }"
							itemLabel="name" itemValue="id" /></td>
				<tr>
					<td>전화</td>
					<td><form:input path="phone" /></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><form:input path="sex" /></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><form:input path="email" /></td>
				</tr>
			</table>
			<button type="submit" class="btn">저장</button>

			<c:if test="${ not empty message }">
				<div class="message">${ message }</div>
			</c:if>
		</form:form>
	</div>
</body>
</html>
