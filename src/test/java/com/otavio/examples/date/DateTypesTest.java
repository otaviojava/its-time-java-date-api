package com.otavio.examples.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class DateTypesTest {

    @Test
    public void shouldInvalidYear() {
        Assertions.assertThrows(DateTimeException.class, () -> Year.of(1_000_000_000));
    }

}