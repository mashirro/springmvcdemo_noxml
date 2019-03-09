package com.baidu.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

//定时任务
@Service
public class PushService {
	
	private DeferredResult<String> deferredResult;
	
	//在PushService里产生deferredResult给控制器使用
	public DeferredResult<String> getAsyncUpdate() {
		deferredResult=new DeferredResult<String>();
		return deferredResult;
	}
	
	//通过@Scheduled注解的方法定时更新deferredResult
	@Scheduled(fixedDelay=5000)
	public void refresh() {
		if(deferredResult!=null) {
			deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
		}
	}
}
