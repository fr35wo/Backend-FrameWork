<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="${R}common.css" />
</head>
<body>
<div class="container">
  <c:forEach var="category" items="${ categorys }">
    <h3>${ category.id } - ${ category.categoryName }</h3>
    
    <table class="list">
      <thead>
        <tr>
          <th>id</th>
          <th>제목</th>
          <th>작가</th>
          <th>학과</th>
          <th>가격</th>
          
        </tr>
      </thead>
      <tbody>
        <c:forEach var="book" items="${ category.books }">
          <tr>
            <td>${ book.id }</td>
            <td>${ book.title }</td>
            <td>${ book.author }</td>
            <td>${ book.category.categoryName }</td>
            <td>${ book.price }</td>
            
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </c:forEach>
</div>
</body>
</html>
