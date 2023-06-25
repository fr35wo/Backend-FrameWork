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
    form { width: 600px; margin: auto;
      box-shadow: 0 0 4px lightgray, 2px 2px 4px gray; overflow: auto; }
    div.title { font-size: 20pt; padding: 10px; background-color: #eee; }
    table { margin: 20px; }
    td { min-width: 100; padding: 5px; }
    td:nth-child(1) { text-align: right; }
    div.buttons { padding: 10px 20px 20px 20px; }
  </style>
</head>
<body>
<div class="container">
  <form:form method="post" modelAttribute="student">
    <div class="title">학생 ${ student.id > 0 ? "수정" : "등록" }</div>
    <table>
      <tr>
        <td>학번:</td>
        <td><form:input path="studentNo" /></td>        
      </tr>
      <tr>
        <td>이름:</td>
        <td><form:input path="name" /></td>
      </tr>
      <tr>
        <td>학과:</td>
        <td><form:select path="department.id"
                itemValue="id" itemLabel="name" items="${ departments }" /></td>
      </tr>
      <tr>
        <td>성별:</td>
        <td><form:radiobutton path="sex" value="남" label="남자" />
            <form:radiobutton path="sex" value="여" label="여자" />        
        </td>
      </tr>
      <tr>
        <td>전화:</td>
        <td><form:input path="phone" /></td>
      </tr>
      <tr>
        <td>이메일:</td>
        <td><form:input path="email" /></td>
      </tr>
    </table>
    <hr />
    <div class="buttons">
      <button type="submit" class="btn" name="cmd" value="save">저장</button>
      <c:if test="${ student.id > 0 }">
        <button type="submit" class="btn" name="cmd" value="delete" data-confirm-delete>삭제</button>
      </c:if>
      <a href="list?${ pagination.queryString}" class="btn">목록으로</a>
    </div>
  </form:form>
</div>
</body>
</html>
