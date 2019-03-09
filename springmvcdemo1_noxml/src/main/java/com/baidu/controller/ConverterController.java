package com.baidu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.entity.Student;

@Controller
public class ConverterController {
	//指定返回的类型为我们自定义的媒体类型application/x-wisely
	//测试路径:http://localhost:8081/toConventer
	@RequestMapping(value="/convert",produces="application/x-wisely")
	public @ResponseBody Student convert(@RequestBody Student student) {
		return student;
	}
}
