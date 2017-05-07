<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/5
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map"%>
<%@ page import="com.rui.entity.base.User" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%=request.getSession().getId()%>
<%
    Map<String,User> map = (Map) request.getServletContext().getAttribute("userMap");
%>
    <%=map.get(request.getSession().getId()).getUsername()%>
</body>
</html>
