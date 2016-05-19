<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/comtags.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<wu:importFile include="bootstrap" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<style type="text/css">
* html {
	background-color: #f5f5f5;
}

body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 300px;
	_width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"], .form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}

.container {
	position: absolute;
	top: 300px;
	left: 300px;
}
</style>

</head>
<body>
	<div class="container">

		<form id="loginForm" class="form-signin">
			<h2 class="form-signin-heading">请登录。。。</h2>
			<input type="text" id="login" name="userName"
				class="input-block-level" placeholder="请输入用户名"> <input
				type="password" id="password" name="password"
				class="input-block-level" placeholder="请输入用户密码"> <label
				class="checkbox"> <input type="checkbox" value="remember-me">
				记住自己&nbsp;&nbsp;&nbsp;&nbsp;<font color="red" id="showMsg"></font>
			</label>
			<button class="btn btn-large btn-primary" type="button"
				onclick="loginSys()">登 陆</button>
		</form>

	</div>
	<!-- /container -->


	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
	<!--[if lte IE 6]>
    <script type="text/javascript" src="js/bootstrap-ie.js"></script>
    <![endif]-->
	<script type="text/javascript">
		$(function() {
			$("input[name='userName']").focus();
		});
		function cleardata() {
			$('#loginForm').form('clear');
		}
		function loginSys() {
			if ($("input[name='login']").val() == ""
					|| $("input[name='password']").val() == "") {
				$("#showMsg").html("用户名或密码为空，请输入");
				$("input[name='login']").focus();
			} else {
				//ajax异步提交  
				$.ajax({
					type : "POST", //post提交方式默认是get
					url : "login.do?check",
					data : $("#loginForm").serialize(), //序列化 
					dataType : 'text',
					error : function(request) { // 设置表单提交出错                 
						$("#showMsg").html(request); //登录错误提示信息
					},
					success : function(data) {
						if (data.trim()!='true') {	
							$("#showMsg").html(data);
						} else {
							document.location = "home.do?go";
						}
					}
				});
			}
		}
	</script>

	<!-- 
	<div id="loginWin" class="easyui-window" title="登录" style="top:200px; width:350px;height:195px;padding:5px;"
  		 minimizable="false" maximizable="false" resizable="false" collapsible="false">
    <div class="easyui-layout" fit="true" >
            <div region="center" border="false" style="padding:5px;background:#fff;border:1px solid #ccc;">
        <form id="loginForm" method="post">
            <div style="padding:5px 0;">
                <label for="login">帐号:</label>
                <input type="text" name="userName" style="width:260px;"></input>
            </div>
            <div style="padding:5px 0;">
                <label for="password">密码:</label>
                <input type="password" name="password" style="width:260px;"></input>
            </div>
             <div style="padding:5px 0;text-align: center;color: red;" id="showMsg"></div>
        </form>
            </div>
            <div region="south" border="false" style="text-align:right;padding:5px 0;">
                <a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:void(0)" onclick="login()">登录</a>
                <a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="cleardata()">重置</a>
            </div>
    </div>
</div> -->

</body>
</html>