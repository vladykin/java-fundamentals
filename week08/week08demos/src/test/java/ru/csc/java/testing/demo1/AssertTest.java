package ru.csc.java.testing.demo1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertTest {

    @Test
    public void substring() {
        assertEquals("llo", "Hello".substring(3));
    }

    @Test
    public void demo_test() {
        assertEquals("Hello", "Hel" + "lo");
        assertEquals(
                1.0,
                1d / 3 + 1d / 3 + 1d / 3,
                1e-10);
    }

}
