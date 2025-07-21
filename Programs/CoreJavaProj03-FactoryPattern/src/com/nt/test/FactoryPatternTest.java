package com.nt.test;

import com.nt.comps.Bike;
import com.nt.factory.BikeFactory;

// Test class for Factory Pattern
public class FactoryPatternTest {

	public static void main(String[] args) {

		// Order StandardBike
		Bike bike = BikeFactory.orderBike("standard");
		bike.drive();

		System.out.println("=============================");

		// Order SportsBike
		Bike bike1 = BikeFactory.orderBike("sports");
		bike1.drive();

		System.out.println("=============================");

		// Order ElectricBike
		Bike bike2 = BikeFactory.orderBike("electric");
		bike2.drive();

		System.out.println("=============================");

		// Order BulletBike
		Bike bike3 = BikeFactory.orderBike("bullet");
		bike3.drive();
	}
}

/*

Output
------
StandardBike.drive():: driving StandardBike (Bajaj Discover)
=============================
SportsBike.drive()::Driving SportsBike (Kawasaki - Ninja)
=============================
ElectricBike.drive():: Driving ElectricBike (Ather Bike)
=============================
BulletBike.drive():: driving BulletBike (Royal Enfield - Bullet)

*/
