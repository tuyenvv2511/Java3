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
<h2>Sửa cặp sách</h2>
<form method="post" action="/buoi9/sua">
    <input type="hidden" name="id" value="${capSach.id}"/>
    Tên: <input type="text" name="ten" value="${capSach.ten}"/><br/>
    Giá: <input type="number" name="gia" step="0.01" value="${capSach.gia}"/><br/>
    Chống nước: <input type="checkbox" name="chongNuoc" ${capSach.chongNuoc ? "checked" : ""}/><br/>
    <button type="submit">Cập nhật</button>
</form>
</body>
</html>
