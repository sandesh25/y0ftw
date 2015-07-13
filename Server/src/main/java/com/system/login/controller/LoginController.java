package com.system.login.controller;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.system.login.model.Login;
import com.system.login.service.LoginService;
import com.system.user.model.User;

@RestController
@RequestMapping("/LoginService")
public class LoginController {
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public User login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
		User user = loginService.login(username, password);
		if (user != null) {
			String userToken = UUID.randomUUID().toString().toUpperCase();
			response.setHeader("user-token", userToken);
			loginService.createSession(new Login(user.getId(), new Date(), new Date()));
			return user;
		} else {
			return null;
		}
	}
}
