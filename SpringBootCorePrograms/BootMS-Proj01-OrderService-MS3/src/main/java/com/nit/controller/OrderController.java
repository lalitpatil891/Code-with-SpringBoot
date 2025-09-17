package com.nit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@GetMapping("/display")
	public String displayMessage() {
		return "This is OrderController..Your order is Confirmed.";
	}
}
