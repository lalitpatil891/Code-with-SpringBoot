//WeekDayFinder.java
package com.nit.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("wf")
public class WeekDayFinder {
	@Qualifier("ldate1")
	@Autowired //Field Injection
	private LocalDate date;

	public WeekDayFinder() {
		System.out.println("WeekDayFinder::0-paramConstructor");
	}

	public String showGreetMessage(String name) {
		System.out.println("WeekDayFinder.showGreetMessage()");

		// get day of the week
		int week = date.getDayOfWeek().getValue();

		// generate the wish message
		if (week != 6 && week != 7)
			return "Happy working day, Working is Worshiping::" + name;
		else
			return "Happy Weekend, Enjoy your paid Holiday" + name;
	}
}
