<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	//页面打开就像向后台发送请求
	deferred();
	
	function deferred() {
		$.get('defer',function(data){
			//在控制台输出服务端推送的数据
			console.log(data);
			//一次请求完成后再向后台发送请求
			deferred();
		});
	}
</script>	
</body>
</html>