<%@ page import="cn.gjp0609.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.5.22
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <style>
        img{
            width: 300px;
        }
    </style>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
</head>
<body>
<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/user/upload.me" method="post">
    <input type="file" name="userImg"/>
    <input type="submit" value="123"/>
</form>
<%
    User user = (User) session.getAttribute("user");
    pageContext.setAttribute("user", user);
%>
<img src="${pageContext.request.contextPath}/userImg/${user.imgPath}">

<script></script>
</body>
</html>
