package com.system.interceptors;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import com.system.aop.UtilityThreadLocal;
import com.system.exceptions.ValidityException;

@Component("sessionValidator")
public class SessionValidator implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("In Sessionvalidator--------" + invocation.getMethod());
		Method method = invocation.getMethod();
		if (!method.getName().equals("login")) {
			validateSession(UtilityThreadLocal.getRequest());
		}
		return invocation.proceed();
	}

	public void validateSession(HttpServletRequest request) {
		String userToken = request.getHeader("user-token");
		if (userToken == null) {
			throw new ValidityException("Invalid Session!!");
		}
		// updateLastUsed(userToken, request);
	}

	private void updateLastUsed(String userToken, HttpServletRequest request) {
		Long lastUsed = Long.valueOf(userToken.substring(userToken.lastIndexOf("|")));
		if (new Date().getTime() - lastUsed > 5 * 60 * 1000) {
			throw new ValidityException("Session Timeout!!");
		} else {}
	}
}
