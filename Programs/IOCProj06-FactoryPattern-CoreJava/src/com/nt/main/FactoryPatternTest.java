package com.nt.main;

import com.nt.comps.ICar;
import com.nt.factory.CarFactory;

public class FactoryPatternTest {

	public static void main(String[] args) {
		  //get object  from the factory
		   ICar  car=CarFactory.getInstance("suv");
		   car.drive();

	}

}
