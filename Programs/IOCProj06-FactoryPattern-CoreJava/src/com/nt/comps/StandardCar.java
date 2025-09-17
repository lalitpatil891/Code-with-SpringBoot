package com.nt.comps;

public class StandardCar implements ICar {
	
	public StandardCar() {
		System.out.println("StandardCar:: 0-param constructor");
	}

	@Override
	public void drive() {
		System.out.println("Driving  Standard Car (Swift car)");

	}

}
