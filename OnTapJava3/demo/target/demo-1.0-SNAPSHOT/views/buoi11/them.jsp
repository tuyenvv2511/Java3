<%--
  Created by IntelliJ IDEA.
  User: tuyen
  Date: 07/06/2025
  Time: 5:03 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thêm nhân </h2>
<form method="post" action="/buoi11/them">
    Id : <input type="text" name="id"/><br>
    Tên: <input type="text" name="ten"/><br/>
    Lương : <input type="text" name="luong"/><br/>
    Quản Lý: <input type="radio" name="quanLy" value="true"/>Co
    <input type="radio" name="" value="false"/>Khong<br/>
    <button type="submit">Thêm</button>
</form>
</body>
</html>