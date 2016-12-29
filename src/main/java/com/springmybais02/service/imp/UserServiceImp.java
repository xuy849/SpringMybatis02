package com.springmybais02.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spingmybatis02.mapper.UserMapper;
import com.springmybais02.service.UserService;
import com.springmybatis02.event.InsertUserEvent;
import com.springmybatis02.po.User;
import com.springmybatis02.po.UserCustom;
import com.springmybatis02.po.UserCustom02;
import com.springmybatis02.po.UserInfo;
import com.springmybatis02.util.Util;

@Service
public final class UserServiceImp implements UserService {

	public List<UserCustom> findUserByName(String firstName, String lastName) throws Exception {
		// TODO Auto-generated method stub

		UserCustom userCustom = new UserCustom();
		userCustom.setFirst_name(firstName);
		userCustom.setLast_name(lastName);
		
		return 	Util.getUserMapper()
				.findUserByName(userCustom);
	}

	//根据(first_name,last_name)删除user及user_info
	//发布会删除的行数
	public int deleteUser(String firstName, String lastName) throws Exception {
		// TODO Auto-generated method stub
		UserCustom userCustom = new UserCustom();
		userCustom.setFirst_name(firstName);
		userCustom.setLast_name(lastName);
		
		int b = Util.getUserMapper().deleteUserInfoByName(userCustom);		
		int a = Util.getUserMapper().deleteUserByName(userCustom);
		
		
		return a+b;
	}

	//根据id删除user及user_info
	//返回删除的行数
	public int deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		int a = Util.getUserMapper().deleteUserById(id);
		
		int b =Util.getUserMapper().deleteUserInfoById(id);
		
		return a+b;
	}
	
	//批量添加user，并显示成功insert的用户
	//返回成功添加的用户list
	//每一次对数据进行修改前都要做一次参数验证	
	public List<UserCustom> addUser(List<UserCustom> list) throws Exception {
		// TODO Auto-gen5t'y'h's'qerated method stub
		List<UserCustom> listResult = new ArrayList();
		
		for(UserCustom userCustom:list){
			
			int a = Util.getUserMapper().insertUser(userCustom);
			
			//如果插入成功
			if(a==1){
				listResult.add(userCustom);
			}
		}
			
		//发布InsertUserEvent事件
		InsertUserEvent insertUserEvent = new InsertUserEvent("InsertUserEvent",listResult);
		Util.getApplicationContext().publishEvent(insertUserEvent);
		
		//
		return listResult;
	}

	//根据(first_name.last_name)更新user_info
	//返回更新的条数
	public int updateUserInfo(String first_name, String last_name, UserInfo userInfo) throws Exception {
		// TODO Auto-generated method stub
		
		UserCustom02 userCustom02 = new UserCustom02();
		
		User user = new User();
		
		user.setFirst_name(first_name);
		user.setLast_name(last_name);
		
		userCustom02.setUserInfo(userInfo);
		userCustom02.setUser(user);
		
		
		int a =  Util.getUserMapper().updateUserInfoByName(userCustom02);
		
		return a;
	}

	//根据id更新user_info
	//返回更新的数目
	public int updateUserInfo(int id, UserInfo userInfo) throws Exception {
		// TODO Auto-generated method stub
		userInfo.setUser_id(id);
		int a = Util.getUserMapper().updateUserInfoByUserId(userInfo);
		
		return a;
	}

	//添加空的user_info记录
	//返回添加成功的记录数目
	public int addEmptyUserInfo(List<UserCustom> list) throws Exception{
		//
		int sum = 0;
		UserMapper userMapper = Util.getUserMapper();
		
		//
		for(UserCustom user:list){
			sum+=userMapper.insertEmptyUserInfo(user.getId());
		}
		
		return sum;	
	}
}
