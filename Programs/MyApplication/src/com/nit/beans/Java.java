package com.nit.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("java")
public class Java {
	
	@Autowired
	private Date date;
	
	public void getJava() {
		System.out.println("JAVA@ I am Lalit Patil");
		date.getDate();
	}
}
