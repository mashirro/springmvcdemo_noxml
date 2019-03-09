package com.baidu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.entity.Student;

@Controller
public class DemoControllerAdvice_Test {
	//测试路径:http://localhost:8081/advice?name=zhangsan&age=18
	@RequestMapping("/advice")
	public String getSomething(@ModelAttribute("msg") String str,Student student) {
		String stu = student.toString();
		//Student [name=zhangsan, age=0]
		throw new IllegalArgumentException("参数有误!"+"来自@ModelAttribute:"+str);
	}
}
