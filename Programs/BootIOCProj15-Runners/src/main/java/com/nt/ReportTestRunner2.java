package com.nt;

import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//@Order(60)
public class ReportTestRunner2 implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("ReportTestRunner2.run()  Application Runner");
		System.out.println("NonOption Args  are::"+args.getNonOptionArgs());
		System.out.println("Option Args are::");
		Set<String> names=args.getOptionNames();
		for(String name:names) {
			System.out.println(name+"....."+args.getOptionValues(name));
		}
		
		System.out.println("==================================");
	}
	
	/*@Override
	public int getOrder() {
		return 2;
	}*/


}
