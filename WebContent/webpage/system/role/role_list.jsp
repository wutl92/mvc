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
<body class="easyui-layout">
    <div class="easyui-layout" fit="true">
        <div region="center">
            <table id="role"></table>
        </div>
    </div>

    <div id="add">
        <form id="ff" method="post">
            <table>
                <tr>
                    <td><label for="roleName">角色名:</label> </td>
                    <td><input class="easyui-validatebox"
                               type="text" name="roleName" id="roleName" data-options="required:true" /></td>
                </tr>
                <tr>
                    <td>
                        <label for="roleDesc">角色描述:</label>
                    </td>
                    <td>
                        <input class="easyui-validatebox"
                               type="roleDesc" name="roleDesc" id="roleDesc" data-options="validType:true" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="isSupper">管理员:</label>
                    </td>
                    <td>
                       <label>是<input class="easyui-linkbutton"
                               type="radio" name="isSupper" value="1" data-options="validType:true,group:'ismag'" /></label>
                        <label>否<input class="easyui-linkbutton"
                               type="radio" name="isSupper"  value="0" data-options="validType:true,group:'ismag'"/></label>
                    </td>
                </tr>
            </table>
        </form>
    </div>
<script src="webpage/system/role/role.js"></script>
</body>
</html>
