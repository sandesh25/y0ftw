package com.system.login.service;

import org.springframework.stereotype.Component;

import com.system.login.model.Login;
import com.system.service.ObjectService;
import com.system.user.model.User;

@Component("loginService")
public interface LoginService extends ObjectService<Login> {
	User login(String username, String password);

	boolean createSession(Login login);
}
