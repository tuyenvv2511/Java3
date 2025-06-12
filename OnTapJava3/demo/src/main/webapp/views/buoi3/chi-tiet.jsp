<%--
  Created by IntelliJ IDEA.
  User: tuyen
  Date: 22/05/2025
  Time: 4:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Chi tiết động vật</h2>
<p><strong>ID:</strong> ${dongVat.id}</p>
<p><strong>Tên:</strong> ${dongVat.ten}</p>
<p><strong>Giới tính:</strong> ${dongVat.gioiTinh ? "Đực" : "Cái"}</p>
<p><strong>Giá tiền:</strong> ${dongVat.giaTien}</p>

<a href="/buoi3/hien-thi">Quay lại danh sách</a>

</body>
</html>
