//DieselEngine.java
package com.nt.sbeans;

import org.springframework.stereotype.Component;

public final class DieselEngine implements IEngine {
	
	public DieselEngine() {
		System.out.println("DieselEngine:: 0-param constructor");
	}

	@Override
	public void startEngine() {
		System.out.println("DieselEngine::  Diesel Engine is started");
		
	}

	@Override
	public void stopEngine() {
	   System.out.println("DieselEngine:: Diesel Engine is stopped)");	
	}

}
