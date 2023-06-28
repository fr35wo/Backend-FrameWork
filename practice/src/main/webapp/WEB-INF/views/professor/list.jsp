<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="/common.js"></script>
  <link rel="stylesheet" type="text/css" href="/common.css" />
  <style>
    a.btn { float: right; margin: -20px 0 5px 0; }
    td:nth-child(1), td:nth-child(5) { text-align: center; }
  </style>
</head>
<body>
<div class="container">
  <h1>교수목록</h1>
  <a href="create" class="btn">교수등록</a>
  <table class="list">
    <thead>
      <tr>
        <th>id</th>
        
        <th>이름</th>
        <th>학과</th>
        <th>전화</th>
        
        <th>이메일</th>
        <th>연구실</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="professor" items="${ professors }">
        <tr data-url="edit?id=${ professor.id }">
          <td>${ professor.id }</td>
          
          <td>${ professor.name }</td>
          <td>${ professor.departmentName }</td>
          <td>${ professor.phone }</td>
          
          <td>${ professor.email }</td>
          <td>${ professor.office }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
