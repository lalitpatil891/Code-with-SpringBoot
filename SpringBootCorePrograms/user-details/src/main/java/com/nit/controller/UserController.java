package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.User;
import com.nit.service.IUserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	public IUserService userService;
		
	@PostMapping("/user")
	public String registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}
}
