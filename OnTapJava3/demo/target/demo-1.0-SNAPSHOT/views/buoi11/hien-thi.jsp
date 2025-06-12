<%--
  Created by IntelliJ IDEA.
  User: tuyen
  Date: 05/06/2025
  Time: 5:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Danh sách nhân viên</title></head>
<body>
<h2>Danh sách nhân viên</h2>
<a href="/views/buoi11/them.jsp">Thêm mới</a>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Lương</th>
        <th>Quản lý</th>
        <th>Hành động</th>
    </tr>
    <c:forEach items="${danhSach}" var="nv">
        <tr>
            <td>${nv.id}</td>
            <td>${nv.ten}</td>
            <td>${nv.luong}</td>
            <td>${nv.quanLy ? "Có" : "Không"}</td>
            <td>
                <a href="/buoi11/sua?id=${nv.id}">Sửa</a> |
                <a href="/buoi11/chi-tiet?id=${nv.id}">Chi tiết</a> |
                <a href="/buoi11/xoa?id=${nv.id}">Xoá</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

