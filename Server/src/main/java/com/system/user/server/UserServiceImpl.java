package com.system.user.server;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.system.user.model.User;
import com.system.user.service.UserService;

@WebService(endpointInterface = "com.system.user.service.UserService", serviceName = "UserService", targetNamespace = "http://server.user.test.com")
@Component("userService")
public class UserServiceImpl implements UserService {

	@Override
	public User login(String username, String password) {
		User user = new User();
		user.setFirstname("abc");
		user.setLastname("asg");
		user.setUsername("y0ftw");
		return user;
	}

	@Override
	public User addUser(User user) {
		return user;
	}
	
}
