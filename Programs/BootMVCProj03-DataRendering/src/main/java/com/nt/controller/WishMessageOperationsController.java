//WishMessageOperationsController.java
package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.Student;
import com.nt.service.IWishMessageService;

@Controller
public class WishMessageOperationsController {
	@Autowired
	private IWishMessageService  service;

	@RequestMapping("/")
	public  String showHomePage() {
		System.out.println("WishMessageOperationsController.showHomePage()");
		//return LVN
		return "welcome";
	}
	
	@RequestMapping("/season")
	public  String  showWishMessage(Map<String,Object> map) {
		//use service
		String msg=service.showWishMessage();
		//add model  attributes (simple values)
		map.put("name","raja");
		map.put("age", 30);
		//add model  attributes  (arrays, collections)
		map.put("nickNames", new String[] {"bunny","chubby","sunny","twinkle","pinkle"});
		map.put("friends", List.of("raja","suresh","mahesh","rakesh"));
		map.put("phones",Set.of(999999L,888888L,777777L));
		map.put("idDetails",Map.of("aadhar",6656565,"voterid",5656565,"panNo",4665656));
		//adding model class obj as the model attribute
		Student  stud=new Student(1001,"rajesh","hyd",89.99f);
		map.put("studData", stud);
		//adding List of Model class objs as the model attributes
		Student  stud1=new Student(1001,"rajesh","hyd",99.99f);
		Student  stud2=new Student(1002,"ramesh","vizag",81.99f);
		Student  stud3=new Student(1003,"suresh","hyd",56.99f);
		map.put("studList", List.of(stud1,stud2,stud3));
		//keep the results in  shared memory  as model  attribute
		map.put("resultMsg", msg);
	
		//return LVN
		return  "display";
	}
}
