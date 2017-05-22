<%@ page import="com.baizhi.entity.User" %>
<%@ page import="com.baizhi.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
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
    <script src="${pageContext.request.contextPath}/jquery-3.2.1.js"></script>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    List<Category> categories = (List<Category>) session.getAttribute("cates");
    pageContext.setAttribute("user", user);
    pageContext.setAttribute("cates", categories);
%>
当前用户：${user.name} <a href='${pageContext.request.contextPath}/login.jsp'>退出</a>
<hr/>
<form action="${pageContext.request.contextPath}/person/editPerson.do" method="post">
    <input type="hidden" name="id" value="${person.id}">
    姓名：<input name="name" value="${person.name}"/><br/>
    手机：<input name="mobile" value="${person.mobile}"/><br/>
    座机：<input name="telphone" value="${person.telphone}"/><br/>
    邮箱：<input name="email" value="${person.email}"/><br/>
    城市：<input name="city" value="${person.city}"/><br/>
    生日：<input name="birthday" value="<fmt:formatDate value='${person.birthday}' pattern='yyyy-MM-dd'/>"/>
    <br/>
    分组：
    <select name="category.id" id="sel">
        <c:forEach items="${cates}" var="cate">
            <option value="${cate.id}">${cate.name}</option>
        </c:forEach>
    </select>
    <br/>
    <input type="submit" value="修改"/>
    <input type="reset" value="重置"/>
</form>
<a href="${pageContext.request.contextPath}/person/queryAll.do">返回</a>

<script>
    var id = "${person.category.id}";
    $("option").each(function () {
            if ($(this).val() === id) {
                $(this).attr("selected", "selected");
            }
        }
    );
</script>
</body>
</html>
