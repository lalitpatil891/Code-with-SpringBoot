package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("stud")
@Data
public class Student {
 //Hard Coded values
	@Value("1001")
	private Integer sno;
	//Injecting the values  collected from the properites file
	@Value("${stud.name}")
	private  String  sname;
	@Value("${stud.addrs}")
	private  String  addrs;
	@Value("${stud.age}")
	private   Float age;
	@Value("${stud.college}")
	private   String college;
	@Autowired
	private  MarksInfo marks;
	
	//using  SPEL
	@Value("#{marks.m1 +marks.m2+ marks.m3}")
	private   Float  total;
	@Value("#{marks.m3 >35.0}")
	private  boolean isM3Passed;
	//injecting the values  collected from  the  system properties
	@Value("${os.name}")
	private  String  os_name;
	@Value("${user.name}")
	private  String  user_name;
	//injecting the values  collected from  the  env. variables
	@Value("${Path}")
	private  String pathData;
	
	
	
	
	
	

}
