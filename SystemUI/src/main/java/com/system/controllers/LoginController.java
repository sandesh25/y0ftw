package com.system.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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
	public ModelAndView Login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
		User user = userService.login(username, password);
		response.addCookie(new Cookie("user", username));
		return user != null ? new ModelAndView("adminHome", "user", user) : new ModelAndView("Error");
	}

	@RequestMapping(value = "/addNewStudent", method = RequestMethod.GET)
	public String addStudent() {
		return "addStudent";
	}
}
