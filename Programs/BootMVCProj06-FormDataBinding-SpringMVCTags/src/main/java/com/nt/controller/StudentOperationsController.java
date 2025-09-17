package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentOperationsController {
	
	//Handler method for home page
	@GetMapping("/")
	public   String  showHomePage() {
		System.out.println("StudentOperationsController.showHomePage()");
		//return LVN
		return "welcome";
	}
	
	@GetMapping("/register")  //for  form lanuching
	public  String  showStudentRegistrationFormPage(@ModelAttribute("stud") Student  st) {
		System.out.println("StudentOperationsController.showStudentRegistrationFormPage()");
		System.out.println("Model class obj data::"+st);
		//return LVN
		return "student_register";
	}
	
	@PostMapping("/register")  // for  form submission
	public  String    registerStudent(@ModelAttribute Student st,
                                                                                            Map<String,Object> map) {
	/*public  String    registerStudent(@ModelAttribute("stud") Student st,
			                                                    Map<String,Object> map) {*/
		System.out.println("StudentOperationsController.registerStudent()");
		System.out.println("Model class obj data::"+st);
		//write b.logic
		String result=null;
		if(st.getAvg()<35)
			  result="Fail";
		else if(st.getAvg()<50)
			 result="Third class";
		else if(st.getAvg()<60)
			 result="Second class";
		else if(st.getAvg()<75)
			 result="First class";
		else 
			 result="First  class with Distintion";
		//keep  the result in model attribute
		map.put("resultMsg", result);
		
		//return  LVN
		return "display";
		
		
	}
	
	
	

}
