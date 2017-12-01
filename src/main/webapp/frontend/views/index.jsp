<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/1
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="index_head_div">
        <%@include file="head.jsp"%>
    </div>

    <div id="index_center_div">
        <%@include file="./index_center.jsp"%>
    </div>

    <div id="index_tail_div">
        <%@include file="tail.jsp"%>
    </div>
</body>
<script src="../../common/plugins/jquery-3.2.1.min.js"></script>
<script src="../js/head.js"></script>
<script src="../js/tail.js"></script>
</html>
