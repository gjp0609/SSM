<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.baizhi.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.5.22
  Time: 08:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    pageContext.setAttribute("user", user);
%>
当前用户：${user.name} <a href='login.jsp'>退出</a>
<hr/>
姓名：${person.name}<br/>
手机：${person.mobile}<br/>
座机：${person.telphone}<br/>
邮箱：${person.email}<br/>
城市：${person.city}<br/>
生日：<fmt:formatDate value="${person.birthday}"/><br/>
分组：${person.category.name}<br/>
<a href="${pageContext.request.contextPath}/person/queryAll.do">返回</a>
</body>
</html>
