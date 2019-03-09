package com.baidu;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * WebApplicationInitializer是Spring MVC提供的接口，可确保检测到您的实现并自动用于初始化任何Servlet3容器。
 * @author 18627
 */
public class MyWebInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// 加载Spring Web应用配置
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		ac.register(MyMvcConfig.class);
		ac.setServletContext(servletContext);	//关联servletContext

		// 创建并注册DispatcherServlet
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ac));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		servlet.setAsyncSupported(true);
	}

}
