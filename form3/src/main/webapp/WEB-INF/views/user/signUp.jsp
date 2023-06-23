<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${R}common.css">
<style>
  label { display: block; margin-top:10px; }
  .error { color: red; display: block; }
  button { margin-top: 20px; }
</style>
</head>
<body>
<div class="container">
  <h1>회원 가입</h1>
  <form:form method="post" modelAttribute="userSignUp">
    <div>
      <label>아이디:</label>
      <form:input path="loginName" />
      <form:errors path="loginName" class="error" />
    </div>
    <div>
      <label>비밀번호:</label>
      <form:password path="passwd1" />
      <form:errors path="passwd1" class="error" />
    </div>
    <div>
      <label>비밀번호 학인:</label>
      <form:password path="passwd2" />
      <form:errors path="passwd2" class="error" />
    </div>
    <div>
      <label>이름:</label>
      <form:input path="name" />
      <form:errors path="name" class="error" />
    </div>
    <div>
      <label>이메일:</label>
      <form:input path="email" />
      <form:errors path="email" class="error" />
    </div>
    <div>
      <label>학과:</label>
      <form:select path="departmentId">
        <form:option value="0">학과를 선택하세요</form:option>
        <form:options itemValue="id" itemLabel="name" items="${ departments }" />
      </form:select>
    </div>
    <button type="submit" class="btn">회원가입</button>
      <form:errors path="" class="error" />
  </form:form>
</div>
</body>
</html>
