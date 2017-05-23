<%@ page import="java.util.Date" %><%--
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
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <style>
        form {
            line-height: 30px;
        }
    </style>
</head>
<body>
<form id="fm" method="post">
    <table>
        <tr>
            <td></td>
            <td id="warn"></td>
        </tr>
        <tr>
            <td>帐号：</td>
            <td><input name="name"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td></td>
            <td><img id="vcodeImg" src="${pageContext.request.contextPath}/vcode/getValidateImg.me"/>
            </td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><input type="text" name="vcode"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"/></td>
            <td><input type="reset" value="取消"/></td>
        </tr>
    </table>

</form>
<script>
    $("#vcodeImg").click(function () {
        var time = new Date().getTime();
        $(this).attr("src", "${pageContext.request.contextPath}/vcode/getValidateImg.me?t=" + time);
    });

    var frm = $("#fm");
    var msg = $("#warn");
    frm.submit(function () {
        $.post("${pageContext.request.contextPath}/user/login.me", frm.serialize(),
            function (result) {
                if (result === "") location.href = "${pageContext.request.contextPath}/index.jsp";
                else msg.html(result);
            }, "text");
        return false;
    });

</script>
</body>
</html>
