package com.springmybatis02.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spingmybatis02.mapper.UserMapper;
import com.springmybais02.service.UserService;

public final class Util {
	
	//返回applicationContext
	public static ApplicationContext getApplicationContext(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(Constant.BEANS_PATH);	
		return applicationContext;
	}
	
	//返回UserMapper
	public static UserMapper getUserMapper(){
		return (UserMapper)Util.getApplicationContext().getBean("userMapper");
	}
	
	//返回UserService
	public static UserService getUserService(){		
		return (UserService) Util.getApplicationContext().getBean("userServiceImp");
	}
}
