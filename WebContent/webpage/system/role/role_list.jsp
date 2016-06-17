<%--
  Created by IntelliJ IDEA.
  User: Wutl
  Date: 2016/5/19
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/comtags.jspf" %>
<html>
<head>
<wu:importFile include="easyui"/>
    <title>角色列表</title>
</head>
<body>
<div  style="width: 100%;height:100%">
    <table id="roleTab" >
    </table>
    <div id="toolbar">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">录入</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">编辑</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">删除</a>
    </div>
</div>
<script src="webpage/system/role/role.js" type="text/javascript"></script>
</body>
</html>
