<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/6
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<%@ taglib prefix="form" uri="/WEB-INF/tld/spring-form.tld" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.rui.entity.base.User" %>
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
<div style="float: right">
    <%
        Map<String,User> userMap = (Map<String, User>) request.getServletContext().getAttribute("userMap");
        //User user = userMap.get(request.getSession().getId());
        if(!userMap.containsKey(request.getSession().getId())){
    %>
    你好，请<a href="#" onclick="onLogin()">登录</a>
    <%}else{
    %><%=userMap.get(request.getSession().getId()).getName()%>,<button onclick="onLogout()">个人中心</button>,
    <button onclick="onLogout()">注销</button><%
    }%>
</div>
<script>
    function onLogout(){
        var url = '<c:url value="/login/logout.do"/>';
        window.location.href = url;
    }
    function onLogin(){
        window.open('<c:url value="/login/init.do"/>',"登录",'width=200,height=100');
    }
</script>
</body>
</html>
