<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sse Demo</title>
</head>
<body>
	<div id="msgFrompPush">
		
	</div>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>	
<script type="text/javascript">
	//EventSource是SSE的客户端,EventSource对象只有新式的浏览器才有(Chrome、FireFox等)
	if(!!window.EventSource){
		var source=new EventSource('push');
		s='';
		//添加SSE客户端监听,在此获得服务端推送的消息
		source.addEventListener('message',function(e){
			s+=e.data+"<br/>";
			$("#msgFrompPush").html(s);
		});
		
		source.addEventListener('open',function(e){
			console.log("连接打开");
		},false);
		
		source.addEventListener('error',function(e){
			if(e.readyState==EventSource.CLOSED){
				console.log("连接关闭");
			}else{
				console.log("e.readyState");
			}
		},false);
	}
	else{
		console.log("你的浏览器不支持SSE");
	}
</script>
</body>
</html>