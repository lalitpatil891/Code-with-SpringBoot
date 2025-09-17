//EngineFactory.java (FactoryBean)
package com.nt.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nt.sbeans.DieselEngine;
import com.nt.sbeans.EletricEngine;
import com.nt.sbeans.IEngine;
import com.nt.sbeans.PetrolEngine;

@Component("eFactory")
public class EngineFactory implements FactoryBean<IEngine> {
	@Value("${engg.type}")
	private  String type;

	@Override
	public IEngine getObject() throws Exception {
		System.out.println("EngineFactory.getObject()");
		switch(type) {
		case "petrol":
			   return new  PetrolEngine();
		case "diesel":
			  return  new DieselEngine();
		case  "eletric":
			   return new EletricEngine();
		 default :
			    throw new IllegalArgumentException("invalid  engine type");
		}
		
	}

	@Override
	public Class<?> getObjectType() {
		System.out.println("EngineFactory.getObjectType()");
		return IEngine.class;
	}
	@Override
	public boolean isSingleton() {
		System.out.println("EngineFactory.isSingleton()");
	 return true;   
	}

}
