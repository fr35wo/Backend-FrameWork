<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <style>
    div.container { width: 700px; margin: 50px auto; font-size: 10pt; }
    thead th { background-color: #eee; }
    table{ border-collapse: collapse; }
    td, th { padding: 4px 6px; border: 1px solid lightgray; }
    .btn { padding: 0.1em 0.5em; border: 1px solid gray;           
       border-radius: 0.3em; background: linear-gradient(#fff, #ddd); 
       text-decoration: none; color: black; display: inline-block; }                
  </style>
</head>
<body>
<div class="container">
  <h1>학생목록</h1>
  <table class="table table-bordered mt5">
    <thead>
      <tr>
        <th>id</th>
        <th>학번</th>
        <th>이름</th>
        <th>학과</th>
        <th>전화</th>
        <th>성별</th>
        <th>이메일</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="student" items="${ students }">
        <tr>
          <td>${ student.id }</td>
          <td>${ student.studentNo }</td>
          <td>${ student.name }</td>
          <td>${ student.departmentName }</td>
          <td>${ student.phone }</td>
          <td>${ student.sex }</td>
          <td>${ student.email }</td>
          <td><a class="btn" href="delete?id=${ student.id }" 
                 onclick="confirm('삭제하시겠습니까?')">삭제</a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
