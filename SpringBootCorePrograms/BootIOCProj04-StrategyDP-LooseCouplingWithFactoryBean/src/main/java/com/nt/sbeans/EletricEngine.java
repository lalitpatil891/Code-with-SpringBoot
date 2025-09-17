//DieselEngine.java
package com.nt.sbeans;

import org.springframework.stereotype.Component;

//@Component("eEngg")
public final class EletricEngine implements IEngine {

	@Override
	public void startEngine() {
		System.out.println("EletricEngine is Started");

	}

	@Override
	public void stopEngine() {
		System.out.println("EletricEngine is Stopped");
	}

}
