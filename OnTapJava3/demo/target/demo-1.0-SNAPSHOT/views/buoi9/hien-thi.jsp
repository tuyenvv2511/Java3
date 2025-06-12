<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tuyen
  Date: 31/05/2025
  Time: 5:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thông tin cặp sách</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Chống nước</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${danhSach}" var="capSach">
        <tr>
            <td>${capSach.id}</td>
            <td>${capSach.ten}</td>
            <td>${capSach.gia}</td>
            <td>${capSach.chongNuoc ? "Có" : "Không"}</td>
            <td>
                <a href="/views/buoi9/them.jsp">Thêm mới</a> |
                <a href="/buoi9/sua?id=${capSach.id}">Sửa</a> |
                <a href="/buoi9/xoa?id=${capSach.id}">Xóa</a> |
                <a href="/buoi9/chi-tiet?id=${capSach.id}">Chi tiết</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
