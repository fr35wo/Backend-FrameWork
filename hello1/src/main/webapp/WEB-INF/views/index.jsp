<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
  <h1>안녕하세요</h1>
  <h3>${ message }</h3>
  <h3><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ now }" /></h3>
</body>
</html>
