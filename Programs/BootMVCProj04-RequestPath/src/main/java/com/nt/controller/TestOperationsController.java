//TestOperationsController.java
package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestOperationsController {
	
	@GetMapping("/report1")
	public   String  showReport2() {
		System.out.println("TestOperationsController.showReport2()");
		return "show_report2";
	}

}
