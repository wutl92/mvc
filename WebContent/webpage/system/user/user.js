/**
 * 右下角消息弹出框
 * @param message
 * @param title
 */
function rightDownMsg(message,title){
	title = title ? title : "提示消息";
	$.messager.show({
		title:title,
		msg:message,
		timeout:5000,
		showType:'slide'
	});
}