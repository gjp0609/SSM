<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.5.23
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("path", path);
%>
<html>
<head>
    <title>menu</title>
    <link rel="stylesheet" href="${path}/js/themes/metro/easyui.css">
    <link rel="stylesheet" href="${path}/js/themes/icon.css">
    <script src="${path}/js/jquery.min.js"></script>
    <script src="${path}/js/jquery.easyui.min.js"></script>
</head>
<body>
<div id="m1" class="easyui-menu">
    <div data-options="name:'123'">返回(B)</div>
    <div>前进(F)</div>
    <div>重新加载(R)</div>
    <div class="menu-sep"></div>
    <div>另存为</div>
    <div>123</div>
</div>


<script>

    m1 = $("#m1");
    $(document).contextmenu(function (e) {
        m1.menu({
            minWidth: 200,
            itemHeight: 30,
            left: e.clientX,
            top: e.clientY,
            hideOnUnhover: false,
            noline: true,
            onShow: function () {
                var item = m1.menu("findItem", "返回(B)");
                m1.menu("disableItem", item.target);
                ref = m1.menu("findItem", "重新加载(R)");
            }
        });
        m1.menu("show");
        ref.menu({
            onClick: function () {
                console.log(this)
            }
        });
        return false;
    });


</script>
</body>
</html>
