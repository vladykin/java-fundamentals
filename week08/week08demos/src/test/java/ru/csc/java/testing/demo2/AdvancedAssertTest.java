package ru.csc.java.testing.demo2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class AdvancedAssertTest {

    @Test
    public void charAt_should_count_chars_from_0() {
        assertEquals('H', "Hello".charAt(0));
    }


    @Test
    public void substring_should_throw_exception_for_invalid_index() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            "".substring(1);
        });
    }


    @Test
    public void should_finish_in_1_second() throws Exception {
        assertTimeout(Duration.ofSeconds(1), () -> {
            Thread.sleep(2000L);
        });
    }
}
