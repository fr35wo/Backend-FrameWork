<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${R}common.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${R}common.js"></script>
<style>
a.btn {
	float: right;
	margin: -20px 0 5px 0;
}

select[name=od] {
	margin-right: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<h1>유저 목록</h1>
		<form:form method="get" modelAttribute="pagination">
			<form:hidden path="pg" value="1" />
			<form:hidden path="sz" />
			<form:select path="od">
				<form:option value="0">정렬 순서</form:option>
				<form:option value="1">학번 순서</form:option>
				<form:option value="2">이름 순서</form:option>
				<form:option value="3">학과명 순서</form:option>
			</form:select>

			<span>학과:</span>
			<form:select path="di">
				<form:option value="0">전체</form:option>
				<form:options itemValue="id" itemLabel="name"
					items="${ departments }" />
			</form:select>
			<button type="submit" class="btn">검색</button>
			<a href="create?${pagination.queryString}" class="btn">유저등록</a>
		</form:form>

		<table class="list">
			<thead>
				<tr>
					<th>ID</th>
					<th>학번</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>학과</th>
					<th>enabled</th>
					<th>유형</th>
					<th>이메일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${ users }">
					<tr data-url="edit?id=${user.id}&${pagination.queryString}">
						<td>${ user.id }</td>
						<td>${ user.loginName }</td>
						<td>${ user.password }</td>
						<td>${ user.name }</td>
						<td>${ user.departmentName }</td>
						<td>${ user.enabled }</td>
						<td>${ user.userType }</td>
						<td>${ user.email }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<my:pagination pageSize="${ pagination.sz }"
			recordCount="${ pagination.recordCount }" queryStringName="pg" />
	</div>
</body>
</html>
