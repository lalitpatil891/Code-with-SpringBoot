package com.nt.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nt.sbeans.DieselEngine;
import com.nt.sbeans.IEngine;
import com.nt.sbeans.PetrolEngine;

@Component
public class EngineFactory implements FactoryBean<IEngine> {
	@Value("${engine.id}")
	private String  enggId;

	@Override
	public IEngine getObject() throws Exception {
		if(enggId.equalsIgnoreCase("pEngine"))
			return new PetrolEngine();
		else if(enggId.equalsIgnoreCase("dEngine"))
			return new DieselEngine();
		else
			throw  new IllegalArgumentException("invalid id");
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
