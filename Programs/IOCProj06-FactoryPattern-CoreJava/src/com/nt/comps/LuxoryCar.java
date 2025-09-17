package com.nt.comps;

public class LuxoryCar implements ICar {
	
	public LuxoryCar() {
		System.out.println("LuxoryCar: 0-param constructor "); 
	}

	@Override
	public void drive() {
		System.out.println("Driving  Luxory Car (RollRoyace car)");

	}

}
