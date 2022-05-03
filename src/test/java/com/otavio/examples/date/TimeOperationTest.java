package com.otavio.examples.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetTime;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQuery;

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
        ZonedDateTime adenNow = ZonedDateTime.now(saoPaulo);
        ZoneOffset offset = adenNow.getOffset();
        Assertions.assertEquals(saoPaulo, adenNow.getZone());
        Assertions.assertEquals("-03:00", offset.getId());
    }

    @Test
    public void shouldCompareTimeZones() {
        ZoneId saoPaulo = ZoneId.of("America/Sao_Paulo");
        ZoneId portugal = ZoneId.of("Portugal");
        LocalDateTime timeSP = Year.of(2021).atMonth(Month.MAY).atDay(3)
                .atTime(12, 0, 0);

        LocalDateTime timeLisbon = Year.of(2021).atMonth(Month.MAY).atDay(3)
                .atTime(16, 0, 0);

        ZonedDateTime zoneSaoPaulo = ZonedDateTime.of(timeSP, saoPaulo);
        ZonedDateTime zoneLisbon = ZonedDateTime.of(timeLisbon, portugal);
        Assertions.assertTrue(zoneSaoPaulo.isEqual(zoneLisbon));
    }

    @Test
    public void shouldUseChronoUnit() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        Assertions.assertEquals(1, ChronoUnit.DAYS.between(today, tomorrow));
    }

    @Test
    public void shouldUsePeriod() {
        LocalDate dateA = LocalDate.of(2012, Month.APRIL, 7);
        LocalDate dateB = LocalDate.of(2015, Month.DECEMBER, 5);

        Period period = Period.between(dateA, dateB);

        Assertions.assertEquals(3, period.getYears());
        Assertions.assertEquals(7, period.getMonths());
        Assertions.assertEquals(28, period.getDays());
        Assertions.assertEquals(43, period.toTotalMonths());
    }

    @Test
    public void shouldIsWeekend() {
        TemporalQuery<Boolean> weekend = temporal -> {
            int dayOfWeek = temporal.get(ChronoField.DAY_OF_WEEK);
            return dayOfWeek == DayOfWeek.SATURDAY.getValue()
                    || dayOfWeek == DayOfWeek.SUNDAY.getValue();
        };
        LocalDate date = LocalDate.of(2018, 5, 4);
        LocalDateTime sunday = LocalDateTime.of(2018, 5, 6, 17, 0);
        Assertions.assertFalse(date.query(weekend));
        Assertions.assertTrue(sunday.query(weekend));
    }
}
