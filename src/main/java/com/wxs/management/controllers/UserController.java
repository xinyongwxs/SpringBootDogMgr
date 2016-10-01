package com.wxs.management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxs.management.models.User;
import com.wxs.management.services.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public @ResponseBody User findUsers(@RequestParam String userName) {
		User user = userService.findByName("Stonna Wang");
		return user;
	}
	
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
}
