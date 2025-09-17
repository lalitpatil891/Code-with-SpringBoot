package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerOperationsController {
	
	//@RequestMapping("/home")
	@RequestMapping("/")
	public  String  showHomePage() {
		System.out.println("CustomerOperationsController.showHomePage()");
		//return LVN (Logical View Name)
		return "welcome";
	}

}
