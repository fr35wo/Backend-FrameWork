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
    form { width: 600px; margin: auto; box-shadow: 0 0 4px lightgray, 2px 2px 4px gray; overflow: auto; }
    div.title { font-size: 20pt; padding: 10px; background-color: #eee; }
    table { margin: 20px; }
    td { min-width: 100; padding: 5px; }
    td:nth-child(1) { text-align: right; }
    div.buttons { padding: 10px 20px 20px 20px; }
    .red { color: red; }
  </style>
</head>
<body>
<div class="container">
  <form:form method="post" modelAttribute="person">
    <div class="title">학생 ${ person.pid > 0 ? "수정" : "등록" }</div>
    <table>
      <tr>
        <td>이름:</td>
        <td><form:input path="name" /></td>
        <td><form:errors path="name" class="red" /></td>
      </tr>
      <tr>
        <td>친한정도:</td>
        <td><form:input path="title" /></td>
        <td><form:errors path="title" class="red" /></td>
      </tr>
      <tr>
        <td>학과:</td>
        <td><form:select path="categoryCode"
                itemValue="code" itemLabel="title" items="${ categorys }" /></td>
        <td><form:errors path="categoryCode" class="red" /></td>
      </tr>
      <tr>
        <td>성별:</td>
        <td><form:radiobutton path="gender" value="남" label="남자" />
            <form:radiobutton path="gender" value="여" label="여자" />
        </td>
        <td><form:errors path="gender" class="red" /></td>
      </tr>
      <tr>
        <td>전화:</td>
        <td><form:input path="phone" /></td>
        <td><form:errors path="phone" class="red" /></td>
      </tr>
      <tr>
        <td>이메일:</td>
        <td><form:input path="email" /></td>
        <td><form:errors path="email" class="red" /></td>
      </tr>
    </table>
    <hr />
    <div class="buttons">
      <button type="submit" class="btn" name="cmd" value="save">저장</button>
      <c:if test="${ person.pid > 0 }">
        <button type="submit" class="btn" name="cmd" value="delete" data-confirm-delete>삭제</button>
      </c:if>
      <a href="list?${ pagination.queryString}" class="btn">목록으로</a>
      <form:errors path="" class="red" />
    </div>
  </form:form>
</div>
</body>
</html>
