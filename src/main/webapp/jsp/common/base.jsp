<%--
  Created by IntelliJ IDEA.
  User: XD.Wang
  Date: 2017/5/26
  Time: 11:19
  Desc: 全局信息
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--META-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">

    <!-- 全局变量 -->
    var BASE_PATH = "localhost:8888/";


</script>
<!-- Jquery -->
<script src="${pageContext.request.contextPath}/static/lib/jquery.min.js"></script>
<!-- Amaze UI -->
<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/static/lib/amaze_ui/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
      href="${pageContext.request.contextPath}/static/lib/amaze_ui/i/app-icon72x72@2x.png">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/lib/amaze_ui/css/amazeui.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/lib/amaze_ui/css/admin.css">
<script src="${pageContext.request.contextPath}/static/lib/amaze_ui/js/app.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>