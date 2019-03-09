<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>测试自定义消息转换器的演示页面</title>
</head>
<body>
	<div>
		<input type="button" value="请求" onclick="req()">
	</div>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>	
<script>
	//contentType设置的媒体类型是我们自定义的application/x-wisely
	//注意data的数据格式:后台处理按此格式处理,用"-"隔开
	function req() {
		$.ajax({
			url:"/convert",
			data:"zhangsan-19",
			type:"POST",
			contentType:"application/x-wisely",
			success:function(data){
				alert(data);
			}
		})
	}
</script>

</body>
</html>