<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="/common.js"></script>
  <link rel="stylesheet" href="/common.css">
  <style>
    form { width: 600px; margin: auto;
      box-shadow: 0 0 4px lightgray, 2px 2px 4px gray; overflow: auto; }
    div.title { font-size: 20pt; padding: 10px; background-color: #eee; }
    table { margin: 20px; }
    td { min-width: 100; padding: 5px; }
    td:nth-child(1) { text-align: right; }
    button { margin: 5px 0 20px 20px; }  
  </style>
</head>
<body>
<div class="container">
  <form:form method="post" modelAttribute="bus">
    <div class="title">버스 ${ bus.id > 0 ? "수정" : "등록" }</div>
    <table>
      <tr>
        <td>버스번호:</td>
        <td><form:input path="busNo" /></td>        
      </tr>
      <tr>
        <td>기점:</td>
        <td><form:input path="firstStop" /></td>
      </tr>
      <tr>
        <td>종점:</td>
        <td><form:input path="lastStop" /></td>
      </tr>
      <tr>
        <td>학과:</td>
        <td><form:select path="categoryId"
                itemValue="id" itemLabel="categoryName" items="${ categorys }" /></td>
      </tr>
      <tr>
        <td>첫차:</td>
        <td><form:input path="firstBus" /></td>
      </tr>
      <tr>
        <td>막차:</td>
        <td><form:input path="lastBus" /></td>
      </tr>
      
    </table>
    <hr />
    <div>
      <button type="submit" class="btn">저장</button>
      <c:if test="${ bus.id > 0 }">
        <a href="delete?id=${ bus.id }" class="btn" data-confirm-delete>삭제</a>
      </c:if>
      <a href="list" class="btn">목록으로</a>
    </div>
  </form:form>
</div>
</body>
</html>
