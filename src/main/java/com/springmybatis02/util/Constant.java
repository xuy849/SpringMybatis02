package com.springmybatis02.util;

/*
 * 常量类
 */
public class Constant {
	public static final String BEANS_PATH="classpath:spring/applicationContext.xml";

	//
	public static final int COMMAND_START=4;
	public static final int COMMAND_END=5;
	
	//命令
	public static final int EXIT=0;
	public static final int QUERY_USER_BY_NAME=1;
	public static final int DELETE_USER_USERINFO_BY_NAME=2;
	public static final int DELETE_USER_USERINFO_BY_ID=3;
	public static final int ADD_USER=4;
	public static final int UPDATE_USERINFO_BY_NAME=5;
	public static final int UPDATE_USERINFO_BY_ID=6;
}
