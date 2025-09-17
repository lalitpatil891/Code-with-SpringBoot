//CarFactory.java
package com.nt.factory;

import com.nt.comps.ICar;
import com.nt.comps.LuxoryCar;
import com.nt.comps.SUVCar;
import com.nt.comps.SportsCar;
import com.nt.comps.StandardCar;

public class CarFactory {
	 //static factory method having factory pattern logic
	public   static  ICar   getInstance(String  type) {
		System.out.println("CarFactory.getInstance()");
		ICar car=null;
		if(type.equalsIgnoreCase("standard"))
			car=new StandardCar();
		else if(type.equalsIgnoreCase("sports"))
			car=new SportsCar();
		else if(type.equalsIgnoreCase("luxory"))
			car=new LuxoryCar();
		else if(type.equalsIgnoreCase("suv"))
			car=new SUVCar();
		else
			throw new IllegalArgumentException("invalid car type");
		
		return car;
	}

}
