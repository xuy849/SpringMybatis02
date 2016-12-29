package com.spingmybatis02.mapper;

import java.util.List;

import com.springmybatis02.po.UserCustom;
import com.springmybatis02.po.UserCustom02;
import com.springmybatis02.po.UserInfo;

public interface UserMapper {
	
	//根据(first_name,last_name)模糊查询用户信息
	public List<UserCustom> findUserByName(UserCustom userCustom) throws Exception;
	
	//根据(first_name,last_name)删除user
	public int deleteUserByName(UserCustom userCustom) throws Exception;
	
	//根据(first_name,last_name)删除user_info
	public int deleteUserInfoByName(UserCustom userCustom) throws Exception;
	
	//根据id删除user
	public int deleteUserById(int id) throws Exception;
	
	//根据user_id 删除user_info
	public int deleteUserInfoById(int user_id) throws Exception;
	
	//插入user
	//返回插入的行数
	public int insertUser(UserCustom userCustom) throws Exception;
	
	//根据(first_name,last_name)修改user_info
	//返回修改成功的行数
	public int updateUserInfoByName(UserCustom02 userCustom02) throws Exception;
	
	//根据user_id修改user_indfo
	public int updateUserInfoByUserId(UserInfo userInfo) throws Exception;

	//往user_info中添加空的user_info
	public int insertEmptyUserInfo(int id) throws Exception;
}
