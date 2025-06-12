<%--
  Created by IntelliJ IDEA.
  User: tuyen
  Date: 03/06/2025
  Time: 3:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Chi tiết cặp sách</h2>
    <p>ID: ${capSach.id}</p>
    <p>Tên: ${capSach.ten}</p>
    <p>Giá: ${capSach.gia}</p>
    <p>Chống nước: ${capSach.chongNuoc ? "Có" : "Không"}</p>
    <a href="/buoi9/hien-thi">Quay lại danh sách</a>
</body>
</html>
