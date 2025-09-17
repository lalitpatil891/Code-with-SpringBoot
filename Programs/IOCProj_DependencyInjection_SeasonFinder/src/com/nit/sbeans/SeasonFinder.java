package com.nit.sbeans;

import java.time.LocalDate;

public class SeasonFinder {

    private LocalDate month;

    // Setter method for Spring to inject
    public void setMonth(LocalDate month) {
        this.month = month;
    }

    // Gets only the month number
    public int getMonth() {
        return month.getMonthValue();
    }

    public String showSeasonMessage(String user) {
        int currMonth = getMonth();

        if ((currMonth >= 11 && currMonth <= 12) || (currMonth >= 1 && currMonth <= 2)) {
            return "Hey " + user + ", Season: Winter, Month: " + currMonth;
        } else if (currMonth >= 3 && currMonth <= 6) {
            return "Hey " + user + ", Season: Summer, Month: " + currMonth;
        } else if (currMonth >= 7 && currMonth <= 10) {
            return "Hey " + user + ", Season: Rainy, Month: " + currMonth;
        } else {
            return "Hey " + user + ", Invalid Month!";
        }
    }
}
