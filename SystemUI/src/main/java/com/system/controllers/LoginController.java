package com.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.system.model.User;
import com.system.service.LoginService;
import com.system.service.UserService;

@Controller
public class LoginController {
	private UserService userService = new UserService();
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView Login(@RequestParam String username, @RequestParam String password) {
		User user = loginService.login(username, password);
		return user != null ? new ModelAndView("adminHome", "user", user) : new ModelAndView("Error");
	}

	@RequestMapping(value = "/addNewStudent", method = RequestMethod.GET)
	public String addStudent() {
		return "addStudent";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String zzz() {
		return "update";
	}

	@RequestMapping(value = "/zzz", method = RequestMethod.GET)
	public String addNew() {
		User user = new User();
		user.setFirstname("sandesh");
		user.setLastname("kulkarni");
		user.setEmail("mw.sandesh@gmail.com");
		user.setGender("Male");
		user.setMobile("9975634128");
		user.setPassword("jhambling");
		user.setId(new Long(1));
		user.setRole("admin");
		User newu = userService.addNew(user);
		return "addStudent";
	}
}
