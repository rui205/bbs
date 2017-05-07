<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/5
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<%@ taglib prefix="form" uri="/WEB-INF/tld/spring-form.tld" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="tieFormBean" action="#" method="post" name="tieForm">
    <label for="">标题:</label>
    <form:input path="tie.tname"/><br>
    <label for="">内容:</label>
    <form:input path="tie.content"/><br>
    <button onclick="onClick()">提交</button>
</form:form>
<script>
    function onClick(){
        
    }
</script>
</body>
</html>
