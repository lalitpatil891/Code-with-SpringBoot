//HomeOperationsController.java
package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeOperationsController {

	@GetMapping("/")
	public  String showMyHomePage() {
		return "redirect:/actor-api/";
	}
	
}
