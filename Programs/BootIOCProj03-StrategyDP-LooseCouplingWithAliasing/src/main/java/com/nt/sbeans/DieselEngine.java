//DieselEngine.java
package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("dEngg")
public final class DieselEngine implements IEngine {

	@Override
	public void startEngine() {
		System.out.println("DieselEngine is Started");

	}

	@Override
	public void stopEngine() {
		System.out.println("DieselEngine is Stopped");
	}

}
