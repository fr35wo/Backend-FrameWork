<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link rel="stylesheet" type="text/css" href="${R}common.css">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="${R}common.js"></script>
  <style>
      form { margin-bottom: 5px; }
      a.btn { float: right; }
  </style>
</head>
<body>
<div class="container">
  <h1>제품 목록</h1>
  <form:form method="get" modelAttribute="pagination">
    <form:hidden path="pg" value="1" /> <!-- <input type="hidden" name="pg" value="1" /> 조회 버튼을 누르면 현재 페이지는 언제나 1번으로 변경되어야 한다. -->
    <form:hidden path="sz" /> <!-- <input type="hidden" name="sz" value="${ pagination.sz }" /> -->
    <span>제품명:</span>
    <input type="text" name="dn" class="form-control" value="${pagination.dn}" />
    <button type="submit" class="btn">검색</button>
    <a href="create?${pagination.queryString}" class="btn">제품등록</a>
  </form:form>
  
  <table class="list">
    <thead>
      <tr>
        <th>ID</th>
        <th>제품명</th>
        <th>카테고리</th>
        <th>가격</th>
        <th>수량</th>
        
      </tr>
    </thead>
    <tbody>
      <c:forEach var="product" items="${ products }">
        <tr data-url="edit?id=${product.id}&${pagination.queryString}">
          <td>${ product.id }</td>
          <td>${ product.title }</td>
          <td>${ product.category.title }</td>
          <td>${ product.price }</td>
          <td>${ product.quantity }</td>
        
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <my:pagination pageSize="${ pagination.sz }" recordCount="${ pagination.recordCount }" 
                 queryStringName="pg" />
</div>
</body>
</html>
