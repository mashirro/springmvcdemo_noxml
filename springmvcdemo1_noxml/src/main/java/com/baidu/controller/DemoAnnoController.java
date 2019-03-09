package com.baidu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.entity.Student;

@Controller
@RequestMapping("/anno")	//映射此类的访问路径是/anno
public class DemoAnnoController {
	/**
	 * @RequestMapping支持Servlet的request和response作为参数,也支持对request和response的媒体类型进行配置
	 * produces可定制返回的response的媒体类型和字符集,或需返回值是json对象,则设置produces="application/json; charset=UTF-8"
	 * 访问路径:http://localhost:8081/anno
	 */
	@RequestMapping(produces= "text/plain; charset=UTF-8")
	public @ResponseBody String index(HttpServletRequest request) {
		return "url:"+request.getRequestURI()+" can access";
	}
	
	/**
	 * 演示常规的request参数获取
	 * @ResponseBody注解在返回值前或方法上
	 * 访问路径:http://localhost:8081/anno/requestParam?id=1
	 */
	@RequestMapping(value="/requestParam", produces= "text/plain; charset=UTF-8")
	@ResponseBody
	public String passRequestParam(Long id,HttpServletRequest request) {
		return "url:"+request.getRequestURI()+" can access, id: "+id;
	}
	
	/**
	 * 演示解释参数到对象(参数->对象)
	 * 访问路径:http://localhost:8081/anno/obj?name=zhangsan&age=19
	 */
	@RequestMapping(value="/obj", produces= "application/json; charset=UTF-8")
	@ResponseBody
	public String passObj(Student stu,HttpServletRequest request) {
		return "url:"+request.getRequestURI()+" can access, stu.name: "+stu.getName()+",stu.age: "+stu.getAge();
	}
	
	/**
	 * @PathVariable注解:接受路径参数
	 * 访问路径:http://localhost:8081/anno/pathvar/xx
	 */
	@RequestMapping(value="/pathvar/{str}",produces= "text/plain; charset=UTF-8")
	public @ResponseBody String demoPathvar(@PathVariable String str, HttpServletRequest request) {
		return "url:"+request.getRequestURI()+" can access, str: "+str;
	}
	
	/**
	 * 演示映射不同的路径到相同的方法
	 * 访问路径:http://localhost:8081/anno/name1或name2
	 */
	@RequestMapping(value={"/name1","/name2"},produces= "text/plain; charset=UTF-8")
	public @ResponseBody String remove(HttpServletRequest request) {
		return "url:"+request.getRequestURI()+" can access";
	}
}
