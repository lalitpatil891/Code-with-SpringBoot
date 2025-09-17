package com.nt.main;

import java.lang.reflect.Constructor;

import com.nt.ston.Printer;

public class SingletonTest {

	public static void main(String[] args) {
		// get Instance
		Printer printer1=Printer.getInstance();
		Printer printer2=Printer.getInstance();
		System.out.println(printer1.hashCode()+"   "+printer2.hashCode());
		System.out.println("==============================");
		System.out.println("printer1==printer2?"+(printer1==printer2));
		
		System.out.println("====================");
		printer1.printData("hello");
		printer1.printData("hai");
		System.out.println("==============================");
		try {
		    //Load the class
			Class clazz=Class.forName("com.nt.ston.Printer");
		   //get all constructors of the class
			Constructor cons[]=clazz.getDeclaredConstructors();
			//get access to prive constructor
			cons[0].setAccessible(true);
			//use  the accessed constructor for creating the object
			Printer prn1=(Printer)cons[0].newInstance();
			System.out.println("prn1 obj hash Code::"+prn1.hashCode());
			prn1.printData("Raja");
		
		
		}
		catch(Exception e) {
	      e.printStackTrace();		
		}
	}

}
