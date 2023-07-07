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
  <h1>버스목록</h1>
  <a href="create" class="btn">버스등록</a>
  <table class="list">
    <thead>
      <tr>
        <th>id</th>
        <th>버스번호</th>
        <th>기점</th>
        <th>종점</th>
        <th>첫차</th>
        <th>막차</th>
        <th>유형</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="bus" items="${ buss }">
        <tr data-url="edit?id=${ bus.id }">
          <td>${ bus.id }</td>
          <td>${ bus.busNo }</td>
          <td>${ bus.firstStop }</td>
          <td>${ bus.lastStop }</td>
          <td>${ bus.firstBus }</td>
          <td>${ bus.lastBus }</td>
          <td>${ bus.categoryName }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
