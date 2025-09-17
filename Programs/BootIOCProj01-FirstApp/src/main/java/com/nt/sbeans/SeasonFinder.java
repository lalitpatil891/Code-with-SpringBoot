//SeasonFinder.java
package com.nt.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class SeasonFinder {
	@Autowired
	private LocalDate date;
	
	 public SeasonFinder() {
		System.out.println("SeasonFinder:: 0-param constructor");
	}
	 
	 public   String  showSeason() {
		 System.out.println("SeasonFinder.showSeason()");
		 //get current month of the year
		 int month=date.getMonthValue();
		 if(month>=3 && month<=6)
			 return "Summer Season";
		 else if(month>=7 &&  month<=9)
			 return "Rainy Season";
		 else 
			 return "Winter Season";
	 }
	
	
	
	

}
