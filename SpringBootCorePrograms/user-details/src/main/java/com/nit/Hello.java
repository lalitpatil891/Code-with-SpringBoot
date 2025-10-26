package com.nit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	
	@RequestMapping("/greet")	
	public String greetMsg() {
		return "Hello I am lalit";
	}
}
