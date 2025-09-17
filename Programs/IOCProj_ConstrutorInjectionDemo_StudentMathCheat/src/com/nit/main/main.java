package com.nit.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nit.sbeans.Student;

public class main {

	public static void main(String[] args) {
		
		//Load the spring application context
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/nit/cfgs/aplicationContext.xml");
		
		//Retrieve the Student Bean
		Student student = ctx.getBean("student", Student.class);
		
		//Call the cheating () method
		student.cheating();
	}

}
