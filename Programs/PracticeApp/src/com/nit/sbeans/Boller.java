package com.nit.sbeans;

public class Boller {
	private String bollerName;
	private int wickets;

	public Boller() {
		System.out.println("Boller is playing");
	}
	
	//Setter Injection
	public void setBollerName(String bollerName) {
		this.bollerName = bollerName;
	}
	
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	
	public void displayBoller() {
		System.out.println("BollerName: "+bollerName);
		System.out.println("Boller Wickets: "+wickets);
	}
 	
}


