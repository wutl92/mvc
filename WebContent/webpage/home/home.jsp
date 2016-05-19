<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/comtags.jspf"%>
<wu:importFile include="easyui" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function() {
		$.messager.alert("提示", "Hello World", 'info');
	})
</script>
<title>主页</title>
</head>
<body>
		<ul id='menuTree0' name='tt' class="easyui-tree">
			<li url="#">角色管理</li>
			<li url="system/user/user_list">人员管理</li>
			<li url="#">菜单管理</li>
			<li url="#">权限管理</li>
		</ul>
	
	
		<ul id='menuTree1' name='tt' class="easyui-tree">
			<li >
				<span>板块管理</span>
				<ul name=''>
					<li url="#"><span><a href="#">File</a></span> </li>
				</ul>
			</li>
			<li url="#">论坛主页</li>
		</ul>
	<ul id="tt" class="easyui-tree">   
    <li>   
        <span>Folder</span>   
        <ul>   
            <li>   
                <span>Sub Folder 1</span>   
                <ul>   
                    <li>   
                        <span><a href="#">File 11</a></span>   
                    </li>   
                    <li>   
                        <span>File 12</span>   
                    </li>   
                    <li>   
                        <span>File 13</span>   
                    </li>   
                </ul>   
            </li>   
            <li>   
                <span>File 2</span>   
            </li>   
            <li>   
                <span>File 3</span>   
            </li>   
        </ul>   
    </li>   
    <li>   
        <span>File21</span>   
    </li>   
</ul>  
		
		<script type="text/javascript">
		$('#menuTree0').tree({
			onClick: function(node){
				alert(node.text);  // 在用户点击的时候提示
			}
		});
		$('#menuTree1').tree({
			onClick: function(node){
				alert(node.text);  // 在用户点击的时候提示
			}
		});
		$('#tt').tree({
			onClick: function(node){
				alert(node.text);  // 在用户点击的时候提示
			}
		});
		</script>
</body>
</html>