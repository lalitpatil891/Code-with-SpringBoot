package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.cfgs.AppConfig;
import com.nt.sbeans.Flipkart;

public class StrategyDPTest {
    public static void main(String[] args) {
    
    //Create the Container
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    
    //get Target Spring bean class obj
    Flipkart fpkt = ctx.getBean("fpkt", Flipkart.class);
    
    //invoke the B methods
    String resultMsg = fpkt.shopping(new String[] {"shirt","trouser"}, new float[] {6000.0f,70000.0f});
    
    System.out.println(resultMsg);
    
    ctx.close();
    }
}
