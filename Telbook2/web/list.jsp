<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.5.22
  Time: 08:32
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.baizhi.entity.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border-radius: 20px;
            border: solid bisque 1px;
            margin: auto;
            color: coral;
        }
        td,th{
            color: coral;
            text-align: center;
            padding:5px;
            border-radius: 20px;
            border: solid bisque 1px;
        }
    </style>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    pageContext.setAttribute("user", user);
%>
当前用户：${user.name} <a href='${pageContext.request.contextPath}/login.jsp'>退出</a><br/>
<a href="${pageContext.request.contextPath}/add.jsp">添加</a>
<table width="80%" border="1" cellspacing="0" cellpadding="0">
    <tr>
        <th>姓名</th>
        <th>手机</th>
        <th>座机</th>
        <th>邮箱</th>
        <th>分组</th>
        <th>操作</th>
    </tr>
    <c:forEach var="person" items="${people}">
        <tr>
            <td>
                <a href="${pageContext.request.contextPath}/person/getDetail.do?id=${person.id}">${person.name}</a>
            </td>
            <td>${person.mobile}</td>
            <td>${person.telphone}</td>
            <td>${person.email}</td>
            <td>${person.category.name}</td>
            <td align="center"><a href="${pageContext.request.contextPath}/person/toEdit.do?id=${person.id}">修改</a>
                <a href="${pageContext.request.contextPath}/person/removePerson.do?id=${person.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
