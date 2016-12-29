package com.springmybatis02.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

public class UserInterceptor implements MethodInterceptor{

	
	//返回执行此方法的时间
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		
		//获得当前事件
		long start=System.currentTimeMillis();
		
		//非常重要，只有通过它来对目标对象方法进行调用，返回一个Object对象
		//调用目标对象方法之前，可以添加日志，对方法进行增强，相当于MethodBeforeAdvice接口对方法进行增强
		//调用目标对象方法之后，也可以添加跟踪日志，对方法增强，相当于使用AfterReturingAdvice接口对方法进行增强
		//在执行目标对象方法的过程中，如果发生异常，可以在catch中捕获异常，相当于使用ThrowAdvice接口对方法进行
		Object result=invocation.proceed();
		
		//输出执行时间
		System.out.println("used"+String.valueOf(start-System.currentTimeMillis())+"ms");
		
		//返回时间
		return result;
	}

}
