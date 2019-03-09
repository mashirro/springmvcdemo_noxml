package com.baidu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Controller注解:注解在类上,声明spring mvc控制器bean
 * @RequestMapping注解:注解在类上或方法上,用来映射web请求(访问路径和参数)等等
 * 通过配置类MyMvcConfig中viewResolver的Bean配置,返回值为"index"
 */
//@Controller
//public class MyController {
//	@RequestMapping("/hello")
//	public String hello() {
//		return "index";
//	}
//}
