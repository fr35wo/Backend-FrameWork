<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <link rel="stylesheet" href="${R}common.css">
  <script src="${R}common.js"></script>
  <style>
    form { width: 600px; margin: auto; box-shadow: 0 0 4px lightgray, 2px 2px 4px gray; overflow: auto; }
    div.title { font-size: 20pt; padding: 10px; background-color: #eee; }
    table { margin: 20px; }
    td { min-width: 100; padding: 5px; }
    td:nth-child(1) { text-align: right; }
    div.buttons { padding: 10px 20px 20px 20px; }
    .red { color: red; }
  </style>
</head>
<body>
<div class="container">
  <form:form method="post" modelAttribute="user">
    <div class="title">유저 ${ user.id > 0 ? "수정" : "등록" }</div>
    <table>
      <tr>
        <td>학번:</td>
        <td><form:input path="loginName" /></td>
        <td><form:errors path="loginName" class="red" /></td>
      </tr>
      <tr>
        <td>비밀번호:</td>
        <td><form:input path="password" /></td>
        <td><form:errors path="password" class="red" /></td>
      </tr>
      <tr>
        <td>이름:</td>
        <td><form:input path="name" /></td>
        <td><form:errors path="name" class="red" /></td>
      </tr>
      <tr>
        <td>학과:</td>
        <td><form:select path="departmentId"
                itemValue="id" itemLabel="name" items="${ departments }" /></td>
        <td><form:errors path="departmentId" class="red" /></td>
      </tr>
      <tr>
        <td>enabled:</td>
        <td><form:input path="enabled" /></td>
        <td><form:errors path="enabled" class="red" /></td>
      </tr>
      <tr>
        <td>유형:</td>
        <td><form:input path="userType" /></td>
        <td><form:errors path="userType" class="red" /></td>
      </tr>
      <tr>
        <td>이메일:</td>
        <td><form:input path="email" /></td>
        <td><form:errors path="email" class="red" /></td>
      </tr>
    </table>
    <hr />
    <div class="buttons">
      <button type="submit" class="btn" name="cmd" value="save">저장</button>
      <c:if test="${ user.id > 0 }">
        <button type="submit" class="btn" name="cmd" value="delete" data-confirm-delete>삭제</button>
      </c:if>
      <a href="list?${ pagination.queryString}" class="btn">목록으로</a>
      <form:errors path="" class="red" />
    </div>
  </form:form>
</div>
</body>
</html>
