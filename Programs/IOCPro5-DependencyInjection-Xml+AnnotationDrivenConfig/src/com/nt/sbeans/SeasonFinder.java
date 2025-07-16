package com.nt.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf") // sf is bean id
public class SeasonFinder {

	private LocalDate date; // Has-A Relation property

	public SeasonFinder() {
		System.out.println("SeasonFinder:: 0-param constructor");

	}

	// setter method for setter injection
	@Autowired
	public void setDate(LocalDate date) {
		System.out.println("SeasonFinder.setDate()");
		this.date = date;
	}

	// b.method
	public String showSeasonName() {
		System.out.println("SeasonFinder.ShowSeasonName()");

		// get Current month value
		int month = date.getMonthValue();

		if (month >= 3 && month <= 6)
			return "Summer Season";
		else if (month >= 7 && month <= 9)
			return "Rainy Season";
		else
			return "Winter Season";
	}

}
