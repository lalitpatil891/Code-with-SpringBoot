//PetrolEngine.java
package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("pEngg")
public final class PetrolEngine implements IEngine {

	@Override
	public void startEngine() {
		System.out.println("PetrolEngine is Started");

	}

	@Override
	public void stopEngine() {
		System.out.println("PetrolEngine is Stopped");
	}

}
