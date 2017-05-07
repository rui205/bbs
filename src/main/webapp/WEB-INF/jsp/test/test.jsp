<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/6
  Time: 14:33
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
    <link rel="stylesheet" type="text/css" href="resources/css/easyui.css"/>
    <script type="text/javascript" src="<%=basePath%>/resources/js/jquery.js">
    </script>
    <script type="text/javascript" src="<%=basePath%>/resources/js/jquery.easyui.min.js">
        </script>
    <script type="text/javascript" src="<%=basePath%>/resources/js/jquery.min.js">
        </script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resources/css/themes/icon.css">
    <title>tst</title>
</head>
<body id="cc" class="easyui-layout"style="height: 100%">
    <div data-options="region:'north'" style="height: 10%" ></div>
    <div data-options="region:'center',split:true,href:'<c:url value="/main/search.do"/>'" title="center" style="height: 90%;padding: 5px;">
        <c:url value='/function/searchTie.do'/>
    </div>
<script type="text/javascript">
    jQuery.noConflict();
    jQuery(document).ready(function(){
        //alert(1);
        $("#cc").layout('collapse','center');
    })
</script>
</body>

</html>
