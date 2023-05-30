<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="${R}common.css">
  <style>
    .btn { margin-top: 20px; }
  </style>
</head>
<body>
<div class="container">
    <h1>에러 발생</h1>
    <div>작업 도중 에러가 발생했습니다.</div>
    <a href="${R}student/list" class="btn">학생 목록으로</a>
</div>
</body>
</html>
