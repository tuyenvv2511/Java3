<%--
  Created by IntelliJ IDEA.
  User: tuyen
  Date: 17/05/2025
  Time: 2:35 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Kết quả tính toán</h2>

<p>Chiều dài: <%= request.getAttribute("chieuDai") %>
</p>
<p>Chiều rộng: <%= request.getAttribute("chieuRong") %>
</p>
<p>Chu vi: <%= request.getAttribute("chuVi") %>
</p>
<p>Diện tích: <%= request.getAttribute("dienTich") %>
</p>

<br>
<a href="<%=request.getContextPath()%>/buoi2/tinh-chu-vi">Quay lại</a>
</body>
</html>
