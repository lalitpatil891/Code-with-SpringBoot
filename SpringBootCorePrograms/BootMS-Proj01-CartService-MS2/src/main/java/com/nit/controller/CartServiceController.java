package com.nit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartServiceController {
	
	@GetMapping("/display")
	public String displayMessage() {
		return "This is cart Service Controller";
	}
}
