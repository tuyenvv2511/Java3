<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Sửa nhân viên</title></head>
<body>
<h2>Sửa nhân viên</h2>
<form action="/buoi11/sua" method="post">
    ID: <input type="number" name="id" value="${nv.id}" readonly><br>
    Tên: <input type="text" name="ten" value="${nv.ten}" required><br>
    Lương: <input type="number" step="0.01" name="luong" value="${nv.luong}" required><br>
    Quản lý:
    <input type="radio" name="quanLy" value="true" ${nv.quanLy ? 'checked' : ''}> Có
    <input type="radio" name="quanLy" value="false" ${!nv.quanLy ? 'checked' : ''}> Không
    <br>
    <button type="submit">Cập nhật</button>
</form>
<a href="/buoi11/hien-thi">Quay lại</a>
</body>
</html>
