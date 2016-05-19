<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/comtags.jspf" %>
<html>
<head>
<wu:importFile include="easyui"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<style type="text/css">
body {
	font: 12px/20px "微软雅黑", "宋体", Arial, sans-serif, Verdana, Tahoma;
	padding: 0;
	margin: 0;
}
a:link {
 text-decoration: none;
}
a:visited {
 text-decoration: none;
}
a:hover {
 text-decoration: underline;
}
a:active {
 text-decoration: none;
}
.cs-north {
	height:85px;background:#B3DFDA;
}
.cs-north-bg {
	width: 100%;
}

.cs-west {
	width:200px;padding:0px;border-left:1px solid #99BBE8;
}
.cs-south {
	height:25px;padding:0px;text-align:center;
}
.cs-navi-tab {
	padding: 5px;
}
.cs-tab-menu {
	width:120px;
}

.spanClass {
	width:170px;
	height:25px;
	border:1px solid #E0ECFF;
	margin:5px 0px 4px 12px;
	line-height:24px;
	border-radius: 5px 5px 5px 5px;
	text-align:center;
	cursor:pointer;
	background-color:#FCFCFC;
}

.spanClass a{
	
	text-decoration:none;
	color:black;
}

.cs-home-remark{
	text-align:center;
	margin-top:100px;
	background-color:#E6E7EC;
}

</style>
<!-- <script type="text/javascript" src="js/jquery/jquery-tree/lib/jquery.cookie.js"></script>
<script type="text/javascript" src="js/jquery/jquery-tree/jquery.treeview.js"></script>
<link rel="stylesheet" href="js/jquery/jquery-tree/jquery.treeview.css" /> -->

</head>
<body class="easyui-layout">
	<div region="north" border="true" class="cs-north">
		<div class="cs-north-bg">
			<div style="float:left;color:#fff;font-size:22px;font-weight:bold;text-decoration:none;"></div>
			<div style="margin:10px 10px 0 0;float:right;color:black;color:#fff;font-size:12px;font-weight:bold;text-decoration:none;">
				&nbsp;您好,欢迎使用！&nbsp;&nbsp;<a style="color:#fff" href="javascript:void(0)" onclick="changePws()">密码修改</a>&nbsp;&nbsp;&nbsp;<a style="color:#fff" href="UbloginOut" >注销</a></p>
				时间：<span  id="DisplayTime"></span>
			</div>
		</div>
	</div>
	<div id="pwd" icon="icon-save" style="padding:5px;width:400px;height:230px;">
		<div style="float:left;width:300px;margin-left:75px;margin-top:30px;">旧密码：<input id="oldPwd"  type="password"></input></div>
		<div style="float:left;width:300px;margin-left:75px;margin-top:10px;">新密码：<input id="newPwd"  type="password" ></input></div>
		<div style="float:left;width:300px;margin-left:75px;margin-top:10px;">再次输入：<input id="newPwd2" type="password" ></input></div>
	</div>	
 	<div icon="icon-menu" region="west" border="true" split="true" title="菜单" class="cs-west" multiple="true" >
		<div id="mymenu" class="easyui-accordion" fit="true" border="false" >
			<wu:menu/>
		</div>
	</div>
	
	<div region="center"  border="true"  style="width: auto ;height: auto" split="true" multiple="true">
		 <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
                <div class="easyui-tab"  icon="icon-earth" title="欢迎页" style="background-color:#E6E7EC;">
				</div>
        </div>
	</div>
	<div data-options="region:'登录信息',collapsed:true,iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>  
	<div region="south" border="false"  class="cs-south"><a href="#">http://www.auto.com</a></div>
	  
   
	<script type="text/javascript">
	function getUrl(url){
		if(url!='null'){
			var s = $("#menuTree0").tree("getSelected");
			var value = s.text;
			value = value.replace(/[^\u4e00-\u9fa5|,]+/,'');//前后各去除一次
			value = value.replace(/[^\u4e00-\u9fa5|,]+/,'');
			addTab(value,url);
		}
	}
	function addTab(title,url){
		if(!$('#tabs').tabs('exists',title)){			
			$('#tabs').tabs('add',{  
			    title:title,    
			    href:url,    
			    closable:true
			});  
		}else{
			$('#tabs').tabs('select',title);
		}
	}
</script>

<script type="text/javascript">  
    
 </script>
<!-- 	<div id="mm" class="easyui-menu cs-tab-menu">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseother">关闭其他</div>
		<div id="mm-tabcloseall">关闭全部</div>
	</div> 
-->
</body>

</html>
