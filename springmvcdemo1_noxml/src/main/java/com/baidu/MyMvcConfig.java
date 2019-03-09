package com.baidu;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @EnableWebMvc注解: @Import(DelegatingWebMvcConfiguration.class):
 * 		(1)为spring mvc应用提供默认的spring配置
 * 		(2)检测并委托WebMvcConfigurer 实现自定义配置
 * @ComponentScan注解:指定了要扫描的包,controller
 */
@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan(basePackages= {"com.baidu.controller","com.baidu.service"})
public class MyMvcConfig extends WebMvcConfigurerAdapter{
	@Bean
	public InternalResourceViewResolver viewResolver() {
		//配置一个viewResolver用来映射路径和实际页面的位置
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	//MultipartResolver配置
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
		multipartResolver.setMaxInMemorySize(1000000);
		return multipartResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//addResourceHandler:指的是对外暴露的访问路径
		//addResourceLocations:指的是文件放置的目录
		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/img/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
	}
	
	//注册自定义拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/hello").setViewName("/index");
		registry.addViewController("/toUpload").setViewName("/upload");
		registry.addViewController("/toConventer").setViewName("/conventer");
		registry.addViewController("/toSse").setViewName("/sse");
		registry.addViewController("/toAsync").setViewName("/async");
	}
	
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MyMessageConverter());
	}
}
