package com.nt.core;

import java.util.Date;
import java.util.Optional;

public class OptionalAPITest {

	public   Date   showDateByMonth(int month) {
		  if(month>=1 && month<=12)
			    return  new Date(2025,month,1);
		  else
			  return null;
	}
	
	public   Optional<Date>   showDateByMonth1(int month) {
		  if(month>=1 && month<=12)
			    return  Optional.of(new Date(2025,month,1));
		  else
			  return Optional.empty();
	}
	
	
	public static void main(String[] args) {
		/*OptionalAPITest  test1=new OptionalAPITest();
		Date  d=test1.showDateByMonth(-10);
		System.out.println("mont is "+d.getMonth());*/
		
		OptionalAPITest  test2=new OptionalAPITest();
		Optional<Date>  opt=test2.showDateByMonth1(-10);
		if(opt.isEmpty()) {
			System.out.println("Invalid  month");
		}
		else {
			Date  d=opt.get();
			System.out.println("month value ::"+d.getMonth());
		}
		
	}
	
}
