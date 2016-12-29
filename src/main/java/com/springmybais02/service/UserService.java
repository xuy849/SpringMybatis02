package com.springmybais02.service;

import java.util.List;

import com.springmybatis02.po.UserCustom;
import com.springmybatis02.po.UserInfo;

public interface UserService {
	//根据(firstName,lastName)查询用户信息
	public List<UserCustom> findUserByName(String firstName,String lastName) throws Exception;
	
	//根据(firstName,lastName)删除user及userInfo
	//返回删除的行数
	public int deleteUser(String firstName,String lastName) throws Exception;
	
	//根据id删除指定的user及userInfo
	//返回删除的行数
	public int  deleteUser(int id) throws Exception;
	
	//批量增加user，显示成功增加的用户
	public List<UserCustom> addUser(List<UserCustom> list) throws Exception;
	
	//根据(first_name,last_name)修改user_info
	//返回更新行数
	public int updateUserInfo(String firstName,String lastName,UserInfo UserInfo) throws Exception;
	
	//根据id修改User_info
	public int updateUserInfo(int id,UserInfo userInfo) throws Exception;

	//向user_info添加空的记录
	//返回添加成功的记录数目
	public int addEmptyUserInfo(List<UserCustom> list) throws Exception;
}
