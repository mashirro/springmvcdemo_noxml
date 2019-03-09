package com.baidu.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;


/**
 *@ControllerAdvice注解: 声明一个控制器建言, 它包含了@Component注解
 */
@ControllerAdvice
public class DemoControllerAdvice {

	/**
	 * value=Exception.class: 拦截所有的Exception
	 */
	@ExceptionHandler(value=Exception.class)
	public ModelAndView exception(Exception exception,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		modelAndView.addObject("errorMessage", exception.getMessage());
		return modelAndView;
	}
	
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("msg","welcome!");
	}
	
	//忽略request参数的age
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.setDisallowedFields("age");
	}
}
