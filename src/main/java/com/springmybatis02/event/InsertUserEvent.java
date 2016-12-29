package com.springmybatis02.event;

import java.util.List;

import org.springframework.context.ApplicationEvent;

import com.springmybais02.service.UserService;
import com.springmybatis02.po.UserCustom;
import com.springmybatis02.util.Util;

public class InsertUserEvent extends ApplicationEvent{

	private List<UserCustom> list_result;
	
	public List<UserCustom> getList_result() {
		return list_result;
	}

	public InsertUserEvent(Object source,List<UserCustom> list_result) {
		super(source);
		this.list_result=list_result;
	}
	
}
