<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/comtags.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<wu:importFile include="all" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户增加</title>
</head>
<body class="easyui-layout">
	<div class="easyui-layout" fit="true">
		<div region="center">
			<table id="test"></table>
		</div>
	</div>

	<div id="add">
		<form id="ff" method="post">
				<table>
					<tr>
						<td><label for="userName">用户名:</label> </td>
						<td><input class="easyui-validatebox"
								type="text" name="userName" id="userName" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>
							<label for="password">密码:</label>
						</td>
						<td>
							<input class="easyui-validatebox"
								type="password" name="password" id="password" data-options="validType:true" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="email">电子邮件:</label>
						</td>
						<td>
							<input class="easyui-validatebox"
								type="text" name="email" id="email" data-options="validType:email" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="phone">电话号码:</label>
						</td>
						<td>
							<input class="easyui-validatebox"
								type="text" name="phone" id="phone"  />
						</td>
					</tr>
				</table>
		</form>
	</div>


	<script>
		$(function() {
			$('#dd').css("display", "none");
			$('#add').css("display", "none");
			loadDatagrid();
		});

		function ddShow() {
			$('#dd').dialog({
				title : "查询条件",
				toolbar : [],
				buttons : [ {
					text : '查询',
					iconCls : 'icon-ok',
					handler : function() {
						loadDatagrid();
						$('#dd').dialog('close');
					}
				}, {
					text : '取消',
					handler : function() {
						$('#dd').dialog('close');
					}
				} ]
			});
		}

		function addShow() {
			$('#add').dialog({
				title : "新增",
				toolbar : [],
				buttons : [ {
					text : '确定',
					iconCls : 'icon-ok',
					handler : function() {
						/* alert("add");
						$.post("user.do?doAdd",$('#addfrom').serialize(),
							function(dataJson){
							alert("添加成功！");
							loadDatagrid();
						});
						$('#add').dialog('close'); */
						$.messager.progress(); // 显示进度条
						$('#ff').form('submit', {
							url : "user.do?doAdd",
							onSubmit : function() {
								var isValid = $(this).form('validate');
								if (!isValid) {
									$.messager.progress('close'); // 如果表单是无效的则隐藏进度条
								}
								return isValid; // 返回false终止表单提交
							},
							success : function() {
								$.messager.progress('close'); // 如果提交成功则隐藏进度条
								$.messager.alert("提示", "保存成功！", 'info');
								$('#add').dialog('close');
								loadDatagrid();
							}
						});

					}
				}, {
					text : '取消',
					handler : function() {
						$('#add').dialog('close');
					}
				} ]
			});
		}

		function upShow() {
			$('#up').dialog({
				title : "编辑",
				toolbar : [],
				buttons : [ {
					text : '确定',
					iconCls : 'icon-ok',
					handler : function() {
						var selObj = $('#test').datagrid('getSelected');
						$.post("upUser", {
							id : selObj.id,
							userName : $('#userName3').val(),
							password : $('#password3').val(),
							telphone : $('#telphone3').val(),
							email : $('#email3').val()
						}, function(upJson) {
							alert("编辑成功！");
							loadDatagrid();
						});
						$('#up').dialog('close');
					}
				}, {
					text : '取消',
					handler : function() {
						$('#up').dialog('close');
					}
				} ]
			});
		}

		function companyType(value) {
			var temp = "";

			if (value == 0) {
				temp = "正常";
			} else {
				temp = "锁定";
			}

			return temp;
		}

		function loadDatagrid() {
			//var h =$('#tabs', parent.document).height()-29;
			$('#test').datagrid({
				pageNumber : 1,//当前页码  
				pageSize : 10,
				pageList : [ 10, 20, 30 ],//每一页显示的记录数,对就后台接收的rows
				sortOrder : "desc",
				fit : true,
				fitColumns : true,
				pagination : true,
				url : 'user.do?datagrid',
				columns : [ [ {
					field : 'serial',
					title : '',
					width : 120,
					checkbox : true
				}, {
					field : 'id',
					title : '编号',
					width : 120,
					align : 'center',
					sortable : true
				}, {
					field : 'userName',
					title : '用户名',
					width : 120,
					align : 'center',
					sortable : true
				},/* 
								          {field:'realName',title:'真实姓名',width:80,align:'center'}, */
				{
					field : 'phone',
					title : '电话号码',
					width : 120,
					align : 'center'
				}, {
					field : 'email',
					title : '邮箱',
					width : 120,
					align : 'center'
				}, {
					field : 'creatorId',
					title : '创建人',
					width : 120,
					align : 'center'
				}, {
					field : 'activityStatus',
					title : '用户状态',
					width : 120,
					align : 'center',
					formatter : companyType
				}, {
					field : 'createTime',
					title : '创建时间',
					width : 120,
					align : 'center'
				} ] ],
				rownumbers : true,
				toolbar : [ {
					id : 'btnadd',
					text : '添加',
					iconCls : 'icon-add',
					handler : function() {
						$('#add').css("display", "block");
						addShow();
					}
				}, {
					id : 'btnUpdate',
					text : '编辑',
					iconCls : 'icon-edit',
					handler : function() {
						var selRows = $('#test').datagrid('getSelections');
						if (selRows.length == 0) {
							alert("请选中一行,再进行操作！");
							return;
						}
						if (selRows.length > 1) {
							alert("不支持多行操作！");
							return;
						}
						var selObj = $('#test').datagrid('getSelected');
						$('#userName3').val(selObj.userName);
						$('#password3').val(selObj.password);
						$('#telphone3').val(selObj.telphone);
						$('#email3').val(selObj.email);
						$('#add').css("display", "block");
						upShow();
					}
				}, {
					id : 'btndelete',
					text : '删除',
					iconCls : 'icon-remove',
					handler : function() {
						var selRows = $('#test').datagrid('getSelections');
						if (selRows.length == 0) {
							rightDownMsg("请选中一行,再进行操作！");
							return;
						}
						if (selRows.length > 1) {
							rightDownMsg("不支持多行操作！");
							return;
						}
						var selObj = $('#test').datagrid('getSelected');
						$.post("user.do?delUser",'ids=' + selObj.id, function() {
							rightDownMsg("提示消息","删除成功！");
							loadDatagrid();	
						});
					}
				}, {
					id : 'btnDeleteMore',
					text : '批量删除',
					iconCls : 'icon-remove',
					handler : function() {
						var selRows = $('#test').datagrid('getSelections');
						ids = "";
						for (var i = 0; i < selRows.length; i++) {
							if (i == selRows.length - 1) {
								ids += selRows[i].id
							} else {
								ids += selRows[i].id + ",";
							}
						}
						if(ids.trim()==''){
							rightDownMsg("请选择一条记录！");
							return;
						}
						$.post("user.do?delUser", 'ids=' + ids, function(v) {
							$.messager.alert("提示消息","删除成功！");
							loadDatagrid();
						});
					}
				}, {
					id : 'btnfind',
					text : '查找',
					iconCls : 'icon-search',
					handler : function() {
						$('#dd').css("display", "block");
						ddShow();
					}
				} ]
			});
			$('#test').datagrid('hideColumn', 'id');
		}

		$
				.extend(
						$.fn.datagrid.methods,
						{
							addToolbarItem : function(jq, items) {
								return jq
										.each(function() {
											var toolbar = $(this)
													.parent()
													.prev(
															"div.datagrid-toolbar");
											for (var i = 0; i < items.length; i++) {
												var item = items[i];
												if (item === "-") {
													toolbar
															.append('<div class="datagrid-btn-separator"></div>');
												} else {
													var btn = $("<a href=\"javascript:void(0)\"></a>");
													btn[0].onclick = eval(item.handler
															|| function() {
															});
													btn
															.css("float",
																	"left")
															.appendTo(toolbar)
															.linkbutton(
																	$
																			.extend(
																					{},
																					item,
																					{
																						plain : true
																					}));
												}
											}
											toolbar = null;
										});
							},
							removeToolbarItem : function(jq, param) {
								return jq
										.each(function() {
											var btns = $(this).parent().prev(
													"div.datagrid-toolbar")
													.children("a");
											var cbtn = null;
											if (typeof param == "number") {
												cbtn = btns.eq(param);
											} else if (typeof param == "string") {
												var text = null;
												btns
														.each(function() {
															text = $(this)
																	.data().linkbutton.options.text;
															if (text == param) {
																cbtn = $(this);
																text = null;
																return;
															}
														});
											}
											if (cbtn) {
												var prev = cbtn.prev()[0];
												var next = cbtn.next()[0];
												if (prev
														&& next
														&& prev.nodeName == "DIV"
														&& prev.nodeName == next.nodeName) {
													$(prev).remove();
												} else if (next
														&& next.nodeName == "DIV") {
													$(next).remove();
												} else if (prev
														&& prev.nodeName == "DIV") {
													$(prev).remove();
												}
												cbtn.remove();
												cbtn = null;
											}
										});
							}
						});
	</script>
	<script type="text/javascript" src="webpage/system/user/user.js"></script>
</body>
</html>