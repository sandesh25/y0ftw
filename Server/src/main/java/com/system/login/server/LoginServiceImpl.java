package com.system.login.server;

import com.system.login.model.Login;
import com.system.login.service.LoginService;
import com.system.service.impl.ObjectServiceImpl;

public class LoginServiceImpl extends ObjectServiceImpl<Login> implements LoginService {
	@Override
	public Class<Login> getObjectClass() {
		return Login.class;
	}
}
