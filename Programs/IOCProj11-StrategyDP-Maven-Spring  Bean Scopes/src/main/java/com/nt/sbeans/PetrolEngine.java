package com.nt.sbeans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("pEngine")
@Scope("prototype")
public final class PetrolEngine implements IEngine {
	
	public PetrolEngine() {
		System.out.println("PetrolEngine:: 0-param constructor");
	}

	@Override
	public void startEngine() {
		System.out.println("PetrolEngine::  Petrol Engine is started");
		
	}

	@Override
	public void stopEngine() {
	   System.out.println("PetrolEngine:: Petrol Engine is stopped)");	
	}

}
