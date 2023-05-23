<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <link rel="stylesheet" type="text/css" href="/common.css" />
  <style>
    div.container { width: 900px; margin: 0 auto; }
    select { padding: 5px; }
    table { width: 100%; border-collapse: collapse; margin-top: 5px; }
    td, th { border: 1px solid gray; padding: 4px; }
    th { background-color: #eee; }
  </style>
</head>
<body>
<div class="container">
  <h1>학생목록</h1>
  <form>
    <select name="order">
      <option value="0" ${ order == 0 ? "selected" : "" }>학번 오름차순</option>
      <option value="1" ${ order == 1 ? "selected" : "" }>학번 내림차순</option>
      <option value="2" ${ order == 2 ? "selected" : "" }>이름 오름차순</option>
      <option value="3" ${ order == 3 ? "selected" : "" }>이름 내림차순</option>
      <option value="4" ${ order == 4 ? "selected" : "" }>학과명 오름차순</option>
    </select>
    <button type="submit">조회</button>
  </form>
  <table class="list">
    <thead>
      <tr>
        <th>id</th>
        <th>학번</th>
        <th>이름</th>
        <th>학과</th>
        <th>전화</th>
        <th>성별</th>
        <th>이메일</th>
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
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
