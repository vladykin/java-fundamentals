package ru.csc.java.testing.demo1;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class AssumeTest {

    @Test
    public void test() throws Exception {
        Assumptions.assumeTrue(System.getProperty("os.name").toLowerCase().contains("win"));
    }
}
