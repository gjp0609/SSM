<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.5.23
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("path", path);
%>
<html>
<head>
    <title>button</title>
    <link rel="stylesheet" href="${path}/js/themes/material/easyui.css">
    <link rel="stylesheet" href="${path}/js/themes/icon.css">
    <script src="${path}/js/jquery.min.js"></script>
    <script src="${path}/js/jquery.easyui.min.js"></script>
</head>
<body>
<input id="word"/>
<a id="btn1" class="easyui-linkbutton"></a>
<hr/>
<a id="btn2" class="easyui-linkbutton btnn">1</a>
<a id="btn3" class="easyui-linkbutton btnn">2</a>
<a id="btn4" class="easyui-linkbutton btnn">3</a>

<script>
    <%-- btn1 --%>
    var btn1 = $("#btn1");
    btn1.linkbutton({
        width: 80,
        height: 30,
//        disabled: true, 不可点击
//        toggle:true, 复选效果
//        selected:false
//        plain:true
        iconCls: "icon-search",
        text: "Google",
        onClick: function () {
            console.log(this);
            var word = $("#word").val();
            console.log(word);
        }
    });

    <%-- btn2 --%>
    var btnn = $(".btnn");
    btnn.linkbutton({
        height: 80,
        width: 80,
        onClick: function () {
            btnn.linkbutton("enable").linkbutton({
                height: 80,
                width: 80,
                text: "here"
            });
            $(this).linkbutton("disable").linkbutton({
                text: "ooh",
                height: 60,
                width: 60
            });
        }
    });

</script>
</body>
</html>
