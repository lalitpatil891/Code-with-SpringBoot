package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.nt.sbeans.Student;

@SpringBootApplication
//@PropertySource("com/nt/commons/Info.properties")
public class BootIocProj08ValueAnnotationSpelApp {


	public static void main(String[] args) {
		//get IOC container
		try(ConfigurableApplicationContext ctx=SpringApplication.run(BootIocProj08ValueAnnotationSpelApp.class, args)){
		//get Spring Bean class obj ref
		Student  stud=ctx.getBean("stud",Student.class);
		System.out.println(stud);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}

}
