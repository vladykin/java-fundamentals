package ru.csc.java.testing.demo2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class HamcrestTest {

    @Test
    public void demo_test() throws Exception {
        assertThat("FooBar", containsString("fooB"));
    }

}
