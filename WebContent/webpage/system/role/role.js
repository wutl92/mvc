/**
 * Created by Wutl on 2016/5/23.
 */

$(function () {
    $('#dd').css("display", "none");
    $('#add').css("display", "none");
    loadDatagrid();
});

function ddShow() {
    $('#dd').dialog({
        title: "查询条件",
        toolbar: [],
        buttons: [{
            text: '查询',
            iconCls: 'icon-ok',
            handler: function () {
                loadDatagrid();
                $('#dd').dialog('close');
            }
        }, {
            text: '取消',
            handler: function () {
                $('#dd').dialog('close');
            }
        }]
    });
}

function addShow() {
    $('#add').dialog({
        title: "新增",
        toolbar: [],
        buttons: [{
            text: '确定',
            iconCls: 'icon-ok',
            handler: function () {
                $('#ff').form('submit', {
                    url: "role.do?doAdd",
                    onSubmit: function () {
                        var isValid = $(this).form('validate');
                        return isValid; // 返回false终止表单提交
                    },
                    success: function () {
                        $.messager.alert("提示", "保存成功！", 'info');
                        $('#add').dialog('close');
                        loadDatagrid();
                    }
                });

            }
        }, {
            text: '取消',
            handler: function () {
                $('#add').dialog('close');
            }
        }]
    });
}

function upShow() {
    $('#up').dialog({
        title: "编辑",
        toolbar: [],
        buttons: [{
            text: '确定',
            iconCls: 'icon-ok',
            handler: function () {
                var selObj = $('#role').datagrid('getSelected');
                $.post("upUser", {
                    id: selObj.id,
                    userName: $('#userName3').val(),
                    password: $('#password3').val(),
                    telphone: $('#telphone3').val(),
                    email: $('#email3').val()
                }, function (upJson) {
                    alert("编辑成功！");
                    loadDatagrid();
                });
                $('#up').dialog('close');
            }
        }, {
            text: '取消',
            handler: function () {
                $('#up').dialog('close');
            }
        }]
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
    $('#role').datagrid({
        pageNumber: 1,//当前页码
        pageSize: 10,
        pageList: [10, 20, 30],//每一页显示的记录数,对就后台接收的rows
        sortOrder: "desc",
        fit: true,
        fitColumns: true,
        pagination: true,
        url: 'role.do?datagrid',
        columns: [[{
            field: 'serial',
            title: '',
            width: 120,
            checkbox: true
        }, {
            field: 'id',
            title: '编号',
            width: 120,
            align: 'center',
            sortable: true
        }, {
            field: 'roleName',
            title: '角色名称',
            width: 120,
            align: 'center',
            sortable: true
        }, /*
         {field:'realName',title:'真实姓名',width:80,align:'center'}, */
            {
                field: 'roleDesc',
                title: '角色描述',
                width: 120,
                align: 'center'
            }, {
                field: 'isSupper',
                title: '超级管理员',
                width: 120,
                align: 'center'
            }]],
        rownumbers: true,
        toolbar: [{
            id: 'btnadd',
            text: '添加',
            iconCls: 'icon-add',
            handler: function () {
                $('#add').css("display", "block");
                addShow();
            }
        }, {
            id: 'btnUpdate',
            text: '编辑',
            iconCls: 'icon-edit',
            handler: function () {
                var selRows = $('#role').datagrid('getSelections');
                if (selRows.length == 0) {
                    rightDownMsg("请选中一行,再进行操作！");
                    return;
                }
                if (selRows.length > 1) {
                    rightDownMsg("不支持多行操作！");
                    return;
                }
                var selObj = $('#role').datagrid('getSelected');
                var parent = window.parent;
                var west = parent.document.getElementById("west");
                var main = parent.document.getElementById("main");
                west = $(west);
                $(main).layout();
                $(main).layout('expand', 'west');
                $(west).panel({
                    href: 'role.do?detail&id=' + selObj.id,
                });
            }
        }, {
            id: 'btndelete',
            text: '删除',
            iconCls: 'icon-remove',
            handler: function () {
                var selRows = $('#role').datagrid('getSelections');
                if (selRows.length == 0) {
                    rightDownMsg("请选中一行,再进行操作！");
                    return;
                }
                if (selRows.length > 1) {
                    rightDownMsg("不支持多行操作！");
                    return;
                }
                var selObj = $('#role').datagrid('getSelected');
                $.post("role.do?delRole", 'ids=' + selObj.id, function () {
                    rightDownMsg("提示消息", "删除成功！");
                    loadDatagrid();
                });
            }
        }, {
            id: 'btnDeleteMore',
            text: '批量删除',
            iconCls: 'icon-remove',
            handler: function () {
                var selRows = $('#role').datagrid('getSelections');
                ids = "";
                for (var i = 0; i < selRows.length; i++) {
                    if (i == selRows.length - 1) {
                        ids += selRows[i].id
                    } else {
                        ids += selRows[i].id + ",";
                    }
                }
                if (ids.trim() == '') {
                    rightDownMsg("请选择一条记录！");
                    return;
                }
                $.post("role.do?delUser", 'ids=' + ids, function (v) {
                    $.messager.alert("提示消息", "删除成功！");
                    loadDatagrid();
                });
            }
        }, {
            id: 'btnfind',
            text: '查找',
            iconCls: 'icon-search',
            handler: function () {
                $('#dd').css("display", "block");
                ddShow();
            }
        }]
    });
    $('#role').datagrid('hideColumn', 'id');
}

$
    .extend(
        $.fn.datagrid.methods,
        {
            addToolbarItem: function (jq, items) {
                return jq
                    .each(function () {
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
                                    || function () {
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
                                                    plain: true
                                                }));
                            }
                        }
                        toolbar = null;
                    });
            },
            removeToolbarItem: function (jq, param) {
                return jq
                    .each(function () {
                        var btns = $(this).parent().prev(
                            "div.datagrid-toolbar")
                            .children("a");
                        var cbtn = null;
                        if (typeof param == "number") {
                            cbtn = btns.eq(param);
                        } else if (typeof param == "string") {
                            var text = null;
                            btns
                                .each(function () {
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