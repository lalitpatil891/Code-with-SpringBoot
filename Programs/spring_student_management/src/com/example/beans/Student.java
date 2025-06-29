package com.example.beans;

import java.util.List;

public class Student {
	private String name;
	private int rollNo;
	private List<String> subjects;
	private Address address;
	
	//constructor
	public Student() {
		System.out.println("Object is Created.!");
	}
	
	//setter and getter for name
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	//setter and getter for rollno
	public int getRollNo() {
		return rollNo;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	//setter and getter for subjects
	public List<String> getSubjects() {
		return subjects;
	}
	
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	
	//Setter and getter for Address
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	// init method
	public void init() {
		System.out.println("Student been initialized!!");
	}
	
	//Destroy method
	public void destroy() {
		System.out.println("Student been destory!!!");
	}
	
	public void showDetails() {
		System.out.println("!--- Student Details ---!");   
		System.out.println("Name : "+name);   
		System.out.println("RollNo : "+rollNo);   
		System.out.println("Subjects : "+subjects);   
		System.out.println("City: "+address.getCity());    
	}
	
	
}
