package com.example.beans;

public class Address {
	
	private String city;
	
	public Address() {
		System.out.println("City Object is Created.");
	}
	
	//Setter And Getter for city
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
 }
