package com.example.beans;

import java.time.LocalTime;
import java.time.LocalDate;

public class WishMessageGenerator {

	private LocalTime time;  //dependency
	private LocalDate date;  //dependency
	
	//Constructor Injection
	public WishMessageGenerator(LocalTime time, LocalDate date) {
		System.out.println("WishMessageGenerator: constructor Called");
		this.time = time;
		this.date = date;
	}
	
	//setter injection
	public void setTime(LocalTime time) {
		System.out.println("WishMessageGenerator: setTime() called");
		this.time = time;
	}
	
	public void setDate(LocalDate date) {
		System.out.println("WishMessageGenerator: setDate() called");
		this.date = date;
	}
	
	//Method to generate message
	public String generateWish(String name) {
		
		int hour = time.getHour();
		String msg;
		
		if(hour<12) msg = "Good Morning...";
		else if(hour<17) msg = "Good Afternoon...";
		else if(hour<20) msg = "Good Evening...";
		else msg = "Good Night...";
		
		return msg +" , "+name+"!, Today's date: "+date;
		
	}	
}
