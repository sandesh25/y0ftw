package com.system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.system.model.User;
import com.system.service.UserService;

@Controller
public class LoginController {
	private UserService userService = new UserService();

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView Login(@RequestParam String username, @RequestParam String password) {
		User user = userService.login(username, password);
		// return user != null ? new ModelAndView("user/HomePage", "user", user)
		// : new ModelAndView("Error");
		return new ModelAndView("Loggedin", "user", user);
	}
}