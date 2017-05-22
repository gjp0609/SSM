<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.5.22
  Time: 08:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/login.do" method="post">
    帐号：<input name="name"/><br/>
    密码：<input type="password" name="password"/><br/>
    <input type="submit" value="登录"/><input type="reset" value="取消"/>
</form>
</body>
</html>
