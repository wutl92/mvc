<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/comtags.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<wu:importFile include="easyui"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员管理</title>

</head>
<body class="easyui-layout" data-options="fit:true">   
		<div id="main" class="easyui-layout" data-options="fit:true">   
          <div data-options="region:'west',collapsed:true,title:'个人信息',split:true" style="width:300px;"></div>  
          <div data-options="region:'center',href:'user.do?goAdd',border:true" ></div>   
        </div>   
        <script type="text/javascript">
			$(function(){
			
			})
		</script>
</body>
</html>