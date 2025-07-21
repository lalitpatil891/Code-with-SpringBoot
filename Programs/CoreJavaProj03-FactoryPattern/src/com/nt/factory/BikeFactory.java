package com.nt.factory;

import com.nt.comps.*;

// Factory class to create Bike objects based on type
public class BikeFactory {

	public static Bike orderBike(String type) {
		Bike bike = null;

		// Creating bike object based on input type
		if (type.equalsIgnoreCase("standard"))
			bike = new StandardBike();
		else if (type.equalsIgnoreCase("sports"))
			bike = new SportsBike();
		else if (type.equalsIgnoreCase("electric"))
			bike = new ElectricBike();
		else if (type.equalsIgnoreCase("bullet"))
			bike = new BulletBike();
		else
			throw new IllegalArgumentException("Invalid Bike Type");

		return bike;
	}
}
