<%--
  Created by IntelliJ IDEA.
  User: tuyen
  Date: 20/05/2025
  Time: 5:28 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Sua thong tin</h2>

<form action="/buoi3/sua" method="post">
    ID : <input type="text" name="id" value="${dongVat.id}"> <br>
    Ten : <input type="text" name="ten" value="${dongVat.ten}"> <br>
    Gioi tinh : <input type="radio" name="gioiTinh" value="true" ${dongVat.gioiTinh == "true" ? "checked" : ""}> Duc
    <input type="radio" name="gioiTinh" value="false" ${dongVat.gioiTinh == "true"} > Cai
    <br>
    Gia tien : <input type="text" name="giaTien" value="${dongVat.giaTien}"> <br>
    <button>Submit</button>
</form>
</body>
</html>
