//Printer.java
package com.nt.ston;

import org.springframework.stereotype.Component;

//@Component("printer")
public class Printer {
	//private static  ref variable
	private  static   Printer INSTANCE;
  
	 //private constructor
	private Printer() {
		System.out.println("Printer:: 0-param constructor");
	}
	
	//public static factory method having singleton logic
	public   static   Printer  getInstance() {
		System.out.println("Printer.getInstance()");
		 if(INSTANCE==null)
			 INSTANCE=new Printer();
		 return  INSTANCE;
	}
	
	//b.method
	public void  printData(String msg) {
		System.out.println("Printer.printData()  (B.method)");
		System.out.println(msg);
	}
}
