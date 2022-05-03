package com.otavio.examples.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class LocalDateTest {

    @Test
    public void shouldCreateJanuaryNinth() {

        LocalDate myBirthday = Year.of(1988).atMonth(Month.JANUARY).atDay(9);
        Assertions.assertEquals(9, myBirthday.getDayOfMonth());
        Assertions.assertEquals(Month.JANUARY, Month.JANUARY);
        Assertions.assertEquals(1988, myBirthday.getYear());
    }
}
