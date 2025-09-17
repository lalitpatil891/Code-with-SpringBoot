//EletricEngine.java
package com.nt.sbeans;

import org.springframework.stereotype.Component;

public final class EletricEngine implements IEngine {
	
	public EletricEngine() {
		System.out.println("EletricEngine:: 0-param constructor");
	}

	@Override
	public void startEngine() {
		System.out.println("EletricEngine::  Eletric Engine is started");
		
	}

	@Override
	public void stopEngine() {
	   System.out.println("EletricEngine:: Eletric Engine is stopped)");	
	}

}
