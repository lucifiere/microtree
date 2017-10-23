<%--
  Created by IntelliJ IDEA.
  User: XD.Wang
  Date: 2017/10/15
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/static/lib/jquery.min.js"></script>
<html>
<head>
    <title>演示</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
          type="text/css"/>
</head>
<body>

<div class="container">

    <div class="container">
        <h1 style="font-family: 'Comic Sans MS',serif; color: forestgreen">DEMO PAGE</h1>
        <div class="row" id="microtreeContainer">
        </div>
    </div>

</div>

</body>
<script src="${pageContext.request.contextPath}/static/js/microtree.js" type="text/javascript"></script>
</html>
