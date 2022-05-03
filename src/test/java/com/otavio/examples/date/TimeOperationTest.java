package com.otavio.examples.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;

public class TimeOperationTest {

    @Test
    public void shouldSumDay() {
        LocalDate myBirthday = Year.of(1988).atMonth(Month.JANUARY).atDay(9);
        LocalDate yesterday = myBirthday.minusDays(1);
        LocalDate oneYear = myBirthday.plusDays(365);
        Assertions.assertEquals(Year.of(1988).atDay(8), yesterday);
        Assertions.assertEquals(Year.of(1989).atDay(8), oneYear);
    }

    @Test
    public void shouldCreateLastDay() {
        LocalDate myBirthday = Year.of(1988).atMonth(Month.JANUARY).atDay(9);
        LocalDate newYear = myBirthday.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayOfMonth = myBirthday.with(TemporalAdjusters.lastDayOfMonth());

        Assertions.assertEquals(Year.of(1988).atMonth(Month.JANUARY).atDay(1), newYear);
        Assertions.assertEquals(Year.of(1988).atMonth(Month.JANUARY).atDay(31), lastDayOfMonth);

    }
}
