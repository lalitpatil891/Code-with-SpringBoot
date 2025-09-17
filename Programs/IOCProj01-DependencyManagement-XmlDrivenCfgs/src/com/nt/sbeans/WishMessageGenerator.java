//WishMessageGenerator.java  (target spring bean class)
package com.nt.sbeans;

import java.time.LocalTime;

public class WishMessageGenerator {
	private   LocalTime  time;  //HAS-A property
	private   int age;

	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator:: 0-param constructor");
	}
	
	public WishMessageGenerator(LocalTime time, int age) {
		System.out.println("WishMessageGenerator:: 2-param constructor");
		this.time = time;
		this.age = age;
	}
	
	
	//parameterized constructor for constructor injection (alt+shift+s,o)
	
	
/*	//setter method for setter Injection (alt+shift+s,r)
	public void setTime(LocalTime time) {
		System.out.println("WishMessageGenerator.setTime()");
		this.time = time;
	}*/
	
	public void setAge(int age) {
		System.out.println("WishMessageGenerator.setAge()");
		 this.age=age;
	}
	
	  //b.method  having  b.logic
	public  String   showWishMessage(String user) {
		System.out.println("WishMessageGenerator.showWishMessage()::"+time +"...."+age);
		  //  get current month value
		int  hour=time.getHour(); // 24 hours format
		
		//write  logic to generate  the wish message
		if(hour<12)
			 return "Good Morning:"+user;
		else if(hour<16)
			  return "Good AfterNoon:"+user;
		else if(hour<20)
			return "Good Evening:"+user;
		else
			return  "Good Night:"+user;
	}


	
}
