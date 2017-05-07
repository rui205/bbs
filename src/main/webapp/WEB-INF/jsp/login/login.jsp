<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<%@ taglib prefix="form" uri="/WEB-INF/tld/spring-form.tld" %>
<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>用户登录</title>
    <%
        String appContext = request.getContextPath();
        String basePath = request.getScheme()+"://"+
                request.getServerName()+":"+ request.getServerPort() + appContext;
    %>
    <script type="text/javascript" src="<%=basePath%>/resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/resources/js/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="resources/css/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resources/css/themes/icon.css">
    <script type="text/javascript">
        document.onkeydown = function (e) {
            var event = e || window.event;
            var code = event.keyCode || event.which || event.charCode;
            if (code == 13) {
                login();
            }
        }
        $(function () {
            $("input[name='login']").focus();
        });
        function cleardata() {
            $('#loginForm').form('clear');
        }
        function login() {
            var url = '<c:url value="/login/isLogin.do"/>';
            document.userForm.setAttribute("action",url);
            document.userForm.submit();
        }
        function register(){
            var url = '<c:url value="/login/toRegister.do"/>'
            window.location.href = url;
        }
    </script>
</head>
<body>
<div id="loginWin" class="easyui-window" title="登录" style="width:350px;height:188px;padding:5px;"
     minimizable="false" maximizable="false" resizable="false" collapsible="false">
    <div class="easyui-layout" fit="true">
        <div region="center" border="false" style="padding:5px;background:#fff;border:1px solid #ccc;">
            <form:form modelAttribute="userFormBean" id="loginForm" method="post" action="#" name="userForm">
                <div style="padding:5px 0;">
                    <label for="user.username">帐号:</label>
                    <form:input path="user.username" style="width:260px;"/>
                </div>
                <div style="padding:5px 0;">
                    <label for="user.password">密码:</label>
                    <form:password path="user.password" style="width:260px;"/><br>
                </div>
                <div style="padding:5px 0;text-align: center;color: red;" id="showMsg"></div>
            </form:form>
        </div>
        <div region="south" border="false" style="text-align:right;padding:5px 0;">
            <a class="easyui-linkbutton" iconcls="icon-ok" href="javascript:void(0)" onclick="login()">登录</a>
            <a class="easyui-linkbutton" iconcls="icon-ok" href="javascript:void(0)" onclick="register()">注册</a>
        </div>
    </div>
</div>
</body>
</html>