<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.baizhi.entity.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.5.22
  Time: 08:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
<%
    List<Category> categories = (List<Category>) session.getAttribute("cates");
    pageContext.setAttribute("cates", categories);
%>
<form action="${pageContext.request.contextPath}/person/addPerson.do" method="post">
    姓名：<input name="name"/><br/>
    手机：<input name="mobile"/><br/>
    座机：<input name="telphone"/><br/>
    邮箱：<input name="email"/><br/>
    城市：<input name="city"/><br/>
    生日：<input name="birthday"/><br/>
    分组：<select name="category.id">
    <c:forEach items="${cates}" var="cate">
        <option value="${cate.id}">${cate.name}</option>
    </c:forEach>
</select><br/>
    <input type="submit" value="添加"/><input type="reset" value="重置"/>
</form>
<a href="${pageContext.request.contextPath}/person/queryAll.do">返回</a>
</body>
</html>
