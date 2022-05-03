package com.otavio.examples.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;

public class TimeOperationTest {

    @Test
    public void shouldOperate() {
        LocalDate myBirthday = Year.of(1988).atMonth(Month.JANUARY).atDay(9);
        LocalDate yesterday = myBirthday.minusDays(1);
        LocalDate oneYear = myBirthday.plusDays(365);
        Assertions.assertEquals(Year.of(1988).atDay(8), yesterday);
        Assertions.assertEquals(Year.of(1989).atDay(8), oneYear);
    }

    @Test
    public void shouldCompare() {
        LocalDate myBirthday = Year.of(1988).atMonth(Month.JANUARY).atDay(9);
        LocalDate now = LocalDate.now();
        Assertions.assertTrue(now.isAfter(myBirthday));
        Assertions.assertFalse(now.isBefore(myBirthday));
    }

    @Test
    public void shouldUseTemporalAdjusters() {
        LocalDate myBirthday = Year.of(1988).atMonth(Month.JANUARY).atDay(9);
        LocalDate newYear = myBirthday.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayOfMonth = myBirthday.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate nextMonday = myBirthday.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        Assertions.assertEquals(Year.of(1988).atMonth(Month.JANUARY).atDay(1), newYear);
        Assertions.assertEquals(Year.of(1988).atMonth(Month.JANUARY).atDay(31), lastDayOfMonth);
        Assertions.assertEquals(Year.of(1988).atMonth(Month.JANUARY).atDay(11), nextMonday);
    }

    @Test
    public void shouldTimeZone() {
        ZoneId saoPaulo = ZoneId.of("America/Sao_Paulo");
        ZoneId portugal = ZoneId.of("Portugal");
        LocalDateTime timeSP = Year.of(2021).atMonth(Month.MAY).atDay(3)
                .atTime(12,0,0);

        LocalDateTime timeLisbon = Year.of(2021).atMonth(Month.MAY).atDay(3)
                .atTime(16,0,0);
        ZonedDateTime adenNow = ZonedDateTime.now(saoPaulo);
        ZoneOffset offset = adenNow.getOffset();
        Assertions.assertEquals(saoPaulo, adenNow.getZone());
        Assertions.assertEquals("-03:00", offset.getId());
    }


}
