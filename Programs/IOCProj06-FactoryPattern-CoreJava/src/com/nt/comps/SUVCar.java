package com.nt.comps;

public class SUVCar implements ICar {
	
	public SUVCar() {
		System.out.println("SUVCar:  0-param constructor"); 
	}

	@Override
	public void drive() {
		System.out.println("Driving  SUV Car (Fortuner car)");

	}

}
