package com.baidu;

import java.io.IOException;
import java.nio.charset.Charset;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import com.baidu.entity.Student;

//继承AbstractHttpMessageConverter接口来实现自定义的HttpMessageConverter
public class MyMessageConverter extends AbstractHttpMessageConverter<Student>{
	
	//新建一个我们自定义的媒体类型application/x-wisely
	public MyMessageConverter() {
		super(new MediaType("application","x-wisely",Charset.forName("UTF-8")));
	}

	//表明本HttpMessageConverter只处理Student这个类
	@Override
	protected boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz);
	}

	//重写readInternal方法,处理请求的数据,代码表明我们处理由"-"隔开的数据,并转成Student的对象
	@Override
	protected Student readInternal(Class<? extends Student> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		//StreamUtils是spring中用于处理流的工具类。
		//copyToString:将给定输入流的内容复制到字符串中。
		String temp = StreamUtils.copyToString(inputMessage.getBody(),Charset.forName("UTF-8"));
		String[] tempArr = temp.split("-");
		return new Student(tempArr[0],new Integer(tempArr[1]));
	}

	//重写writeInternal,处理如何输出数据到response,此例中我们在原样输出前面加上"hello: "
	@Override
	protected void writeInternal(Student stu, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		String out="hello:"+stu.getName()+"~~"+stu.getAge();
		outputMessage.getBody().write(out.getBytes());
	}
}
