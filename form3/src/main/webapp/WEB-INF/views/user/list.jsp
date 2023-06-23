<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="${R}common.css">
  <style>
    h1 { display: inline-block; }
    a { float: right; margin-top: 30px; }
    td:nth-child(1), td:nth-child(5), td:nth-child(7) { text-align: center; }
  </style>
</head>
<body>
<div class="container">
  <h1>사용자목록</h1>
  <a class="btn" href="signUp">회원 가입</a>
  <table class="list">
    <thead>
      <tr>
        <th>id</th>
        <th>로그인네임</th>
        <th>이름</th>
        <th>이메일</th>
        <th>활성화</th>
        <th>사용자유형</th>
        <th>학과ID</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="user" items="${ users }">
        <tr>
          <td>${ user.id }</td>
          <td>${ user.loginName }</td>
          <td>${ user.name }</td>
          <td>${ user.email }</td>
          <td>${ user.enabled }</td>
          <td>${ user.userType }</td>
          <td>${ user.departmentId }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
