package com.system.user.service;

import org.springframework.stereotype.Component;

import com.system.service.ObjectService;
import com.system.user.model.User;

@Component("userService")
public interface UserService extends ObjectService<User> {

	User create(User newObject);

}
