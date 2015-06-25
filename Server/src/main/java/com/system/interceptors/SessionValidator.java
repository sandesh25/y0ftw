package com.system.interceptors;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component("sessionValidator")
public class SessionValidator implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Before--------" + invocation.getMethod());
		Object result = invocation.proceed();
		System.out.println("After--------" + invocation.getMethod());
		return result;
	}
	
}
