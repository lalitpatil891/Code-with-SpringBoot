package com.nt.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nt.sbeans.DieselEngine;
import com.nt.sbeans.EletricEngine;
import com.nt.sbeans.IEngine;
import com.nt.sbeans.PetrolEngine;

@Component("engg")
public class EngineFactory implements FactoryBean<IEngine> {
	@Value("${engine.id}")
	private  String  engineId;

	public EngineFactory() {
		System.out.println("EngineFactory:: 0-param constructor");
	}
	
	@Override
	public IEngine getObject() throws Exception {
		switch(engineId) {
		case "petrol":
			   return  new  PetrolEngine();
		case "diesel":
			   return new  DieselEngine();
		case "eletric":
			   return  new EletricEngine();
		 default:
			   throw new IllegalArgumentException("Invalid id");
		}
		
	}

	@Override
	public Class<?> getObjectType() {
		return IEngine.class;
	}
	
	@Override
	public boolean isSingleton() {
		return true;
	}

}
