package com.system.login.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.system.user.model.User;

@RestController
@RequestMapping("/LoginService")
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public User login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
		String userToken = UUID.randomUUID().toString().toUpperCase();
		response.setHeader("user-token", UUID.randomUUID().toString().toUpperCase());
		User user = new User();
		user.setFirstname("sandesh");
		user.setLastname("kulkarni");
		user.setEmail("mw.sandesh@gmail.com");
		user.setGender("Male");
		user.setMobile("9975634128");
		user.setPassword("jhambling");
		user.setId(new Long(1));
		user.setRole("admin");
		return user;
	}
}
