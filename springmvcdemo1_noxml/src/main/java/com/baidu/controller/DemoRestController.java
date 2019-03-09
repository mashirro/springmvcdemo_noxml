package com.baidu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baidu.entity.Student;

/**
 * @RestController=@Controller+@ResponseBody
 * 访问路径:http://localhost:8081/rest/getjson?name=zhangsan&age=19
 */
@RestController
@RequestMapping("/rest")
public class DemoRestController {
	/**
	 * 直接返回对象时,对象会自动转换成json
	 */
	@RequestMapping(value="/getjson",produces="application/json; charset=UTF-8")
	public Student getJson(Student stu) {
		System.out.println(stu);
		return new Student(stu.getName()+"er", stu.getAge()+10);
	}
}
