package com.system.user.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.system.user.model.User;
import com.system.user.service.UserService;

@RestController
@RequestMapping("/UserService")
public class UserController {
	@Autowired
	UserService userService;
	static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User addEmployee(@RequestBody User user) {
		return userService.create(user);
	}

	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getShopInJSON(@PathVariable String name) {
		User student = new User();
		student.setFirstname("aslkgh");
		student.setLastname("askg");
		student.setEmail("asgg");
		return student;
	}
}
