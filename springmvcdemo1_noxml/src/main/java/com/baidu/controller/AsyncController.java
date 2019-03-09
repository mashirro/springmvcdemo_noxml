package com.baidu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.baidu.service.PushService;

@Controller
public class AsyncController {
	@Autowired
	private PushService pushService;
	
	@RequestMapping(value="/defer")
	@ResponseBody
	public DeferredResult<String> deferredCall(){
		return pushService.getAsyncUpdate();
	}
}
