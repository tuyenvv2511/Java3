<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tuyen
  Date: 17/05/2025
  Time: 5:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Them thong tin</h2>

    <form action="/buoi3/them" method="post">
        ID : <input type="text" name="id"> <br>
        Ten : <input type="text" name="ten"> <br>
        Gioi tinh : <input type="radio" name="gioiTinh" value="true"> Duc
            <input type="radio" name="gioiTinh" value="false"> Cai
        <br>
        Gia tien : <input type="text" name="giaTien"> <br>
        <button>Submit</button>
    </form>

    <h2>Thong tin</h2>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten</th>
                <th>Gioi tinh</th>
                <th>Gia</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${danhSach}" var="dongVat">
                <tr>
                    <td>${dongVat.id}</td>
                    <td>${dongVat.ten}</td>
                    <td>${dongVat.gioiTinh ? "Duc" : "Cai"}</td>
                    <td>${dongVat.giaTien}</td>
                    <td>
                        <a href="/buoi3/sua?id=${dongVat.id}">Sua</a>
                        <a href="/buoi3/xoa?id=${dongVat.id}">Xoa</a>
                        <a href="/buoi3/chi-tiet?id=${dongVat.id}">Chi tiet</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
