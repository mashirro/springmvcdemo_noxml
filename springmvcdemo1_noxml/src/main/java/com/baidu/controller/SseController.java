package com.baidu.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//本例演示每5秒向浏览器推送随机消息
@Controller
public class SseController {
	//注意,这里使用输出的媒体类型为text/event-stream,这是服务器端的sse支持
	@RequestMapping(value="/push",produces="text/event-stream")
	public @ResponseBody String push() {
		Random r=new Random();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "data:Testing 1,2,3..."+r.nextInt()+"\n\n";
	}
}
