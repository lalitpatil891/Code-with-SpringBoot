//SeasonFinder.java
package com.nt.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class SeasonFinder {
	@Autowired  //field Injection
	private LocalDate    date;
	
	//b.method
	public  String   findSeason() {
         //use  injected date object  to get current month of the year
		int month=date.getMonthValue();
		//show the season name
		if(month>=3 && month<=6)
			return  "Summer Season";
		else if(month>=7 && month<=10)
			return "Rainy Season";
		else
			return "Winter Season";
		
	}
}
