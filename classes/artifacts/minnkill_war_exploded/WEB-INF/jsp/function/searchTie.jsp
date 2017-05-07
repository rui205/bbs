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
<input type="hidden" value="" id="condition">
<div style="width: 100%;height: 90%;" id="divTbl">
    <div style="width: 100%;height: 100%">
        <table width="100%" style="height: auto" id="tbl">
            <tr style="height: 10px;background: blue">
                <th width="60%">标题</th>
                <th width="10%">提问人</th>
                <th width="10%">回复数</th>
                <th width="20%">最后更新时间</th>
            </tr>
        </table>
        <div>
            <button onclick="toFirst()">首页</button>
            <button onclick="onPrevious()">上一页</button>
            当前第<input type="text" value="1" disabled="true" size="2" id="currentPageId">页(共<strong id="sum"></strong>页)
            跳转至第<input type="text" id="pageId" value="1" size="2">页 <button onclick="onGo()">GO</button>
            <button onclick="onNext()">下一页</button>
            <button onclick="toLast()">末页</button>
            按标题搜贴<input type="text" id="searchId"><button onclick="onSearch()">搜索</button>
            <button onclick="add()">新增</button>
        </div>
    </div>
</div>
<script type="text/javascript">
    window.onload = onLoad();
    function onLoad(){
        var val = document.getElementById("condition").value;
        $.ajax({
            url: '<c:url value="/main/toLast.do"/>',
            type: 'post',
            data: {"condition":""+val},
            dataType: 'text',
            success: function(data,status){
                $("#sum").text(data);
            },
        });
        postAjax("0");
    }
    function postAjax(offset){
        var val = document.getElementById("condition").value;
        $.ajax({
            url: '<c:url value="/main/postAjax.do"/>',
            type: 'post',
            data: {"offset":""+offset,"rows":"20","condition":""+val},
            dataType: 'text',
            success: function(data,status){
                if(data == 0){
                    alert("当前页数超过了查询范围");
                    return;
                }
                var tieCustom = JSON.parse(data);
                var obj = tieCustom.tie;
                var uname = tieCustom.uname;
                var tbl = document.getElementById("tbl");
                var len = tbl.rows.length;
                for(var i =len - 1;i > 0;i --){
                    tbl.deleteRow(i);
                }

                for(var i = 0;i < tieCustom.length;i ++){
                    var obj = tieCustom[i].tie;
                    var uname = tieCustom[i].uname;
                    var newTr = tbl.insertRow();
                    if(i%2==0) newTr.setAttribute("style","height: 10px;background:white");
                    else newTr.setAttribute("style","height: 10px;background:#89cff0 ");
                    newTr.setAttribute("id","tr");
                    var newTd1 = newTr.insertCell();
                    var newTd2 = newTr.insertCell();
                    var newTd3 = newTr.insertCell();
                    var newTd4 = newTr.insertCell();
                    newTd1.innerHTML = "<a href='#' onclick='onClick("+obj.tid+")'>"+obj.tname+"</a>";
                    newTd2.innerHTML = uname;
                    newTd3.innerHTML = obj.digit;
                    newTd4.innerHTML = obj.updateDate;
                }
                $("#currentPageId").val(offset/20+1);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                alert(XMLHttpRequest);
                alert(textStatus);
                alert(errorThrown);
            }
        });
    }
    function onClick(obj){
        alert(obj);
    }
    function onGo(){
        var page = document.getElementById("pageId");
        postAjax((page.value-1)*20);
    }
    function toFirst(){
        $("#currentPageId").val(1);
        postAjax("0");
    }
    function toLast(){
        postAjax(($("#sum").value-1)*20);
    }
    function onPrevious(){
        var currentPageId = document.getElementById("currentPageId");
        if(currentPageId.value == 1){
            alert("当前页数超过了查询范围");
            return ;
        }
        postAjax((currentPageId.value-1-1)*20);
    }
    function onNext(){
        var currentPageId = document.getElementById("currentPageId");
        if(currentPageId.value == $("#sum").value){
            alert("当前页数超过了查询范围");
            return ;
        }
        postAjax((currentPageId.value)*20);
    }
    function onSearch(){
        var val = document.getElementById("searchId").value;
        $("#condition").val(val);
        postAjax(0);
    }
    function add(){
        var url = '<c:url value="/function/toAdd.do"/>'
        window.location.href = url
    }
</script>
</body>
</html>
