package com.system.interceptors;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.system.aop.UtilityThreadLocal;
import com.system.exceptions.ValidityException;
import com.system.login.model.Login;
import com.system.login.service.LoginService;

@Component("sessionValidator")
public class SessionValidator implements MethodInterceptor {
	@Autowired
	LoginService loginService;

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
		Login session = loginService.get(userToken, "token");
		if (userToken == null || session == null) {
			throw new ValidityException("Invalid Session!!");
		}
		if (new Date().getTime() - session.getLastUsed().getTime() > 5 * 60 * 1000) {
			throw new ValidityException("Session Timeout!!");
		}
		updateLastUsed(session);
	}

	private void updateLastUsed(Login session) {
		session.setLastUsed(new Date());
		loginService.update(session);
	}
}
