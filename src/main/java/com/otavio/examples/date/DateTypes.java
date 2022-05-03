package com.otavio.examples.date;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class DateTypes {
    public static void main(String[] args) {

        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
        Month month = Month.JANUARY;
        MonthDay monthDay = MonthDay.now();
        YearMonth yearMonth = YearMonth.now();
        Year year = Year.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        Clock clock = Clock.systemUTC();
        Instant instant = Instant.now();
        TimeZone timeZone = TimeZone.getDefault();

        System.out.println("DayOfWeek: " + dayOfWeek);
        System.out.println("month: " + month);
        System.out.println("MonthDay: " + monthDay);
        System.out.println("YearMonth: " + yearMonth);
        System.out.println("Year: " + year);
        System.out.println("LocalDate: " + localDate);
        System.out.println("LocalTime: " + localTime);
        System.out.println("LocalDateTime: " + localDateTime);
        System.out.println("OffsetDateTime: " + offsetDateTime);
        System.out.println("ZonedDateTime: " + zonedDateTime);
        System.out.println("Clock: " + clock.getZone());
        System.out.println("Instant: " + instant);
        System.out.println("TimeZone: " + timeZone.getDisplayName());

    }
}
