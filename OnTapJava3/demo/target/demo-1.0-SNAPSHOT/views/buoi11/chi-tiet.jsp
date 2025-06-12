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
<h2>Chi tiết nhân viên </h2>
<p>ID: ${nv.id}</p>
<p>Tên: ${nv.ten}</p>
<p>Giá: ${nv.luong}</p>
<p>Chống nước: ${nv.quanLy ? "Có" : "Không"}</p>
<a href="/buoi11/hien-thi">Quay lại danh sách</a>
</body>
</html>

