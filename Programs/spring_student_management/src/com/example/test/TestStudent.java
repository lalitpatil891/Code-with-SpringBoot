package com.example.test;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.example.beans.Student;

public class TestStudent {

	public static void main(String[] args) {
		
		//Load String Container
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/example/cfgs/applicationContext.xml");
		
		//get Student bean
		Student student = (Student) ctx.getBean("stud");
		
		//show details
		student.showDetails();
		
		ctx.close();		
	}
}
