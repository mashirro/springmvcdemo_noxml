package com.baidu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 继承HandlerInterceptorAdapter类实现自定义拦截器
 * 业务含义:计算每一次请求的处理时间
 */
public class MyInterceptor extends HandlerInterceptorAdapter{
	//在请求发生前执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}
	//在请求完成后执行
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Long startTime = (Long) request.getAttribute("startTime");
		Long endTime=System.currentTimeMillis();
		System.out.println("本次请求处理时间为:"+new Long(endTime-startTime)+"ms");
		request.setAttribute("handlingTime", endTime-startTime);
	}
}
