package com.system.user.server;

import org.springframework.stereotype.Service;

import com.system.service.impl.ObjectServiceImpl;
import com.system.user.model.User;
import com.system.user.service.UserService;

@Service
public class UserServiceImpl extends ObjectServiceImpl<User> implements UserService {
	@Override
	public Class<User> getObjectClass() {
		return User.class;
	}

	@Override
	public User add(User newObject) {
		return super.add(newObject);
	}

	@Override
	public User create(User newObject) {
		return super.add(newObject);
	}
}
