package com.nit.sbeans;

public class Student {
	
	//class data members
	private int id;
	private MathCheat mathCheat;
	
	//Constructor For Dependency Injection
	public Student(int id, MathCheat mathCheat) {
		this.id = id;
		this.mathCheat = mathCheat;
	}
	
	//Method to Demonstrate functionality
	public void cheating() {
		System.out.println("My ID is: "+id);
		mathCheat.mathCheating();
	}
	
}
