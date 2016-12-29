package com.springmybatis02.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;

import com.springmybais02.service.UserService;
import com.springmybatis02.event.InsertUserEvent;
import com.springmybatis02.po.UserCustom;
import com.springmybatis02.util.Util;

public class Main {
	private static ApplicationContext applicationContext;
	private static UserService userService;
	
	public static void main(String args[]){
		
		//
		init();
		
		//（一）1测试
		//findUserByNameTest();
		
		//（二）2测试
		//deleteUserTest();
		
		//(二)2测试
		//insertUserEventTest();
		
	}
	
	public static void init(){
		applicationContext = Util.getApplicationContext();
		
		//使用代理之后返回接口
		userService = (UserService) applicationContext.getBean("userServiceImp");
	}
	
	public static void findUserByNameTest(){
				
		String firstName="任";
		String lastName="真天";
		
		try {
			List<UserCustom> list = userService.findUserByName(firstName, lastName);
		
			System.out.println(11);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static  void deleteUserTest(){
		String firstName="任";
		String lastName="真天";
		int id = 1;
		
		try {
			int a = userService.deleteUser(firstName, lastName);
			
			int b = userService.deleteUser(id);
			
			System.out.println();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void insertUserEventTest(){
		List<UserCustom> list=new ArrayList<UserCustom>();
		
		//
		UserCustom userCustom01=new UserCustom();
		UserCustom userCustom02 = new UserCustom();
		
		userCustom01.setFirst_name("笑");
		userCustom02.setFirst_name("哈哈");
		
		list.add(userCustom01);
		list.add(userCustom02);
		
		
		InsertUserEvent insertUserEvent = new InsertUserEvent("insertUserEvent",list);
		applicationContext.publishEvent(insertUserEvent);
	}
}
