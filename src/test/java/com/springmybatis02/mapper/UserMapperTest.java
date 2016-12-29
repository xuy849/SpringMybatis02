package com.springmybatis02.mapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spingmybatis02.mapper.UserMapper;
import com.springmybatis02.po.User;
import com.springmybatis02.po.UserCustom;
import com.springmybatis02.po.UserCustom02;
import com.springmybatis02.po.UserInfo;

public class UserMapperTest {

	private ApplicationContext applicationContext;
	private UserMapper userMapper;
	private SimpleDateFormat sdf ;
	
	@Before
	public void setUp() throws Exception{
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		userMapper = (UserMapper) applicationContext.getBean("userMapper");
		sdf = new SimpleDateFormat("yy-mm-dd");
	}
	
	@Test
	public void findUserByNameTest(){
		
		UserCustom userCustom= new UserCustom();
		
		userCustom.setFirst_name("王");
		userCustom.setLast_name("天");
		
		List<UserCustom> list = null;
		try {
			list = userMapper.findUserByName(userCustom);
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(list.get(0).getId());
	}
	
	@Test
	public void deleteUserByNameTest(){
		//根据(first_name,last_name)删除user及user_info
		UserCustom userCustom = new UserCustom();
		userCustom.setFirst_name("王");
		userCustom.setLast_name("小明");
		
		try {
			
			int a = userMapper.deleteUserByName(userCustom);
			
			int b = userMapper.deleteUserInfoByName(userCustom);
			
			System.out.println(a+" "+b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void insertUserTest(){
		
		UserCustom userCustom = new UserCustom();
		
		userCustom.setLast_name("红");
		userCustom.setFirst_name("徐");
		userCustom.setLast_updated_time(new Date());
		int b = 0;
		try {
			b  = userMapper.insertUser(userCustom);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(b);
	}
	
	@Test
	public void updateUserInfoByNameTest(){
		
		UserCustom02 userCustom02=  new UserCustom02();
		
		User user = new User();
		UserInfo userInfo = new UserInfo();
		
		user.setFirst_name("王");
		user.setLast_name("小天");
		
		userInfo.setTel("不告诉你");
		userInfo.setAddress("不告诉你");
		
		userCustom02.setUser(user);
		userCustom02.setUserInfo(userInfo);
		
		try {
			int a = userMapper.updateUserInfoByName(userCustom02);
			
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateUserInfoByUserIdTest(){
		
		UserInfo userInfo = new UserInfo();
		
		userInfo.setUser_id(2);
		userInfo.setTel("333333333");
		userInfo.setAddress("999999999");
		
		try {
			int b=userMapper.updateUserInfoByUserId(userInfo);
			
			System.out.println(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
