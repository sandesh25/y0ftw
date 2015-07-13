package com.system.login.server;

import org.springframework.stereotype.Service;

import com.system.login.model.Login;
import com.system.login.service.LoginService;
import com.system.service.impl.ObjectServiceImpl;
import com.system.user.model.User;

@Service
public class LoginServiceImpl extends ObjectServiceImpl<Login> implements LoginService {
	@Override
	public Class<Login> getObjectClass() {
		return Login.class;
	}

	@Override
	public User login(String username, String password) {
		return (User) entityManager.createQuery("from " + User.class.getName() + " where username=(:username) and password=(:password)").setParameter("username", username).setParameter("password", password).getSingleResult();
	}

	@Override
	public boolean createSession(Login login) {
		return super.add(login) != null ? true : false;
	}
}
