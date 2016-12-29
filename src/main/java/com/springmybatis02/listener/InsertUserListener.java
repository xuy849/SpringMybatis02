package com.springmybatis02.listener;

import java.util.List;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import com.springmybais02.service.UserService;
import com.springmybatis02.event.InsertUserEvent;
import com.springmybatis02.po.UserCustom;
import com.springmybatis02.util.Util;

public class InsertUserListener implements ApplicationListener<ApplicationEvent> {

	private List<UserCustom> list_result;
	
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		
		//如果是用户插入事件
		if(event instanceof InsertUserEvent){
			//
			InsertUserEvent insertUserEvent = (InsertUserEvent)event;
			//
			list_result = insertUserEvent.getList_result();	
			
			if(list_result!=null)
			{									
				//为每一个新创建的用户添加空的user_info记录
				insertUserInfo(list_result);				
			}
		}
		
	}
	
	private static void insertUserInfo(List<UserCustom> list){
		UserService userService = Util.getUserService();
		
		//向user_info中插入空记录
		try {
			userService.addEmptyUserInfo(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
