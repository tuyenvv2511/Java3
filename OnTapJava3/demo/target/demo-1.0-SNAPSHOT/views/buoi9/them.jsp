<%--
  Created by IntelliJ IDEA.
  User: tuyen
  Date: 03/06/2025
  Time: 2:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thêm cặp sách</h2>
<form method="post" action="/buoi9/them">
    Id : <input type="text" name="id"/><br>
    Tên: <input type="text" name="ten"/><br/>
    Giá: <input type="text" name="gia"/><br/>
    Chống nước: <input type="radio" name="chongNuoc" value="true"/>Co
                <input type="radio" name="chongNuoc" value="false"/>Khong<br/>
    <button type="submit">Thêm</button>
</form>
</body>
</html>
