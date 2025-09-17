package com.nt.sbeans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("dEngine")
@Scope("prototype")
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
