package com.nebulytix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nebulytix.model.User;
import com.nebulytix.service.UserService;

@RestController
@RequestMapping("/api/user")
//@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
	
		private UserService userService;

		@Autowired
		public UserController(UserService taskService) {
			this.userService = taskService;
		}

		@PostMapping
		public User createUser(@RequestBody User user) {
			return User.createUser(user);
		}
		

}
