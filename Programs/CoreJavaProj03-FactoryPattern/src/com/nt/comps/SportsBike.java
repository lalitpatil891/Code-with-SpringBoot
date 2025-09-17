package com.nt.comps;

// SportsBike implementation of Bike interface
public class SportsBike implements Bike {

	@Override
	public void drive() {
		System.out.println("SportsBike.drive()::Driving SportsBike (Kawasaki - Ninja)");
	}
}
