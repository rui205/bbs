<%@ page import="java.util.Map" %>
<%@ page import="com.rui.entity.base.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/5
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<%@ taglib prefix="form" uri="/WEB-INF/tld/spring-form.tld" %>
<html>
<head>
    <%
        String appContext = request.getContextPath();
        String basePath = request.getScheme()+"://"+
                request.getServerName()+":"+ request.getServerPort() + appContext;
    %>
    <script type="text/javascript" src="<%=basePath%>/resources/js/jquery.js">
    </script>

    <title>Title</title>
</head>
<body>
<div style="width: 100%;height: 100%" id="divTbl" >
    <iframe style="height: 10%;width: 100%;" name="yonghu" src="<c:url value='/main/head.do'/>"
            frameborder="0" marginheight="0px" marginwidth="0px"></iframe>
    <iframe src="<c:url value='/main/search.do'/>" style="width: 100%;height: 90%" name="content"
            scrolling="auto" frameborder="0" marginheight="0px" marginwidth="0px"></iframe>
</div>
</body>
</html>
