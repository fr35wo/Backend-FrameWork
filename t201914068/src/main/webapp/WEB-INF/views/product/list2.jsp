<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>제품 목록</title>
</head>
<body>
    <h1>제품 목록</h1>
    <table>
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
           
            

<%-- products 변수는 컨트롤러에서 전달되는 제품 목록입니다. --%>
<c:forEach var="product" items="${products}">
    <tr data-url="edit?id=${product.id}">
        <td>${product.id}</td>
        <td>${product.title}</td>
        <td>${product.category.title}</td>
        <td>${product.price}</td>
        <td>${product.quantity}</td>
    </tr>
</c:forEach>
        </tbody>
    </table>
</body>
</html>
