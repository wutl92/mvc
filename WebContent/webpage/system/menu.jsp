<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/comtags.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<wu:importFile include="all"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){                          //实现折叠菜单
   		$('dt').click(function(){                   //向DT添加一个click事件
        $('dd').css('display','none');
        $(this).next('dd').css('display','block');  //点击DT时，显示DT后第一个DD
    });
});
</script>
</head>
<body>
	
</body>
</html>