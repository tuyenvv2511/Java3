<%--
  Created by IntelliJ IDEA.
  User: tuyen
  Date: 17/05/2025
  Time: 2:33 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Nhập chiều dài và chiều rộng</h2>

    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
    <p style="color: red"><%= error %>
    </p>
    <% } %>

    <form action="<%=request.getContextPath()%>/buoi2/ket-qua" method="post">
        Chiều dài: <input type="text" name="chieuDai" required><br>
        Chiều rộng: <input type="text" name="chieuRong" required><br>
        <button type="submit">Tính</button>
    </form>
</body>
</html>
