package com.springmybatis02.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.springmybais02.service.UserService;
import com.springmybais02.service.imp.UserServiceImp;
import com.springmybatis02.po.UserCustom;
import com.springmybatis02.util.Util;

public class ServiceImp {

	private ApplicationContext applicationContext;
	
	@Before
	public void setUp() throws Exception{
		applicationContext = Util.getApplicationContext();
	}
	
	@Test
	public void findUserByNameTest() {
		UserServiceImp userServiceImp = (UserServiceImp) applicationContext.getBean("userServiceImp");
		
		String firstName = "王";
		String lastName = "小";
		try {
			List<UserCustom> list = userServiceImp.findUserByName(firstName, lastName);
		
			System.out.println(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void addUserTest(){
		UserService userServiceImp = (UserService) applicationContext.getBean("userServiceImp");
		
		List<UserCustom> list = new ArrayList();
		UserCustom userCustom01 = new UserCustom();
		userCustom01.setFirst_name("徐");
		userCustom01.setLast_name("红");
		userCustom01.setLast_updated_time(new Date());
		list.add(userCustom01);
		
		UserCustom userCustom02 = new UserCustom();
		userCustom02.setFirst_name("蒋");
		userCustom02.setLast_name("话");
		userCustom02.setLast_updated_time(new Date());
		list.add(userCustom02);
		
		try {
			List<UserCustom> li = userServiceImp.addUser(list);
			
			System.out.println("11");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
