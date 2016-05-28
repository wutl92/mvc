<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/comtags.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<wu:importFile include="easyui"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>

</head>
<body class="easyui-layout" data-options="fit:true">   
		<div id="main" class="easyui-layout" data-options="fit:true">
            <div data-options="region:'center',href:'role.do?list',border:true" ></div>
            <div id = "east" data-options="region:'east',collapsed:true,title:'权限分配',split:true" style="width:300px;"></div>
        </div>
        <script type="text/javascript">
			$(function(){
			
			})
		</script>
</body>
</html>