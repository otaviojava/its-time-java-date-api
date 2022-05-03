package com.otavio.examples.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

public class DateCreation {

    public static void main(String[] args) {
        MonthDay monthDay = MonthDay.now();
        YearMonth yearMonth = YearMonth.now();
        Year year = Year.now();

    }
}
