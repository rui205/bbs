<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<%@ taglib prefix="form" uri="/WEB-INF/tld/spring-form.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/28
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<br>
    <form:form modelAttribute="userFormBean" action="#" method="post" name="registerForm" >
        账号：<form:input path="user.username"/><br>
        密码：<form:password path="user.password"/><br>
        真实姓名：<form:input path="user.name"/><br>
        <input type="submit" value="提交" onclick="onRegister()"/>
    </form:form>
<script>
    function onRegister(){
        document.registerForm.setAttribute('action','<c:url value="/login/register.do"/>');
        document.registerForm.submit();
    }
</script>
</body>
</html>
