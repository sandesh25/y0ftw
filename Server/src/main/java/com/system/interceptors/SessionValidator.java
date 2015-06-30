package com.system.interceptors;

import java.lang.reflect.Method;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import com.system.aop.UtilityThreadLocal;
import com.system.constants.ApplicationConstants;
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
		validateSession(getSessionId(request));
	}

	public void validateSession(String sessionId) {
		if (sessionId == null) {
			throw new ValidityException("Invalid Session !!!");
		}
	}

	public static String getSessionId(HttpServletRequest servletRequest) {
		if (servletRequest.getCookies() != null) {
			for (Cookie cookie : servletRequest.getCookies()) {
				if (cookie.getName().equals(ApplicationConstants.USER_TOKEN)) {
					return cookie.getValue();
				}
			}
		}
		return servletRequest.getHeader(ApplicationConstants.USER_TOKEN);
	}
}
