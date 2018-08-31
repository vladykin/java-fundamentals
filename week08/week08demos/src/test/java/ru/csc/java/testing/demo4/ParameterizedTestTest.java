package ru.csc.java.testing.demo4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.csc.java.testing.calc.CalculatorImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedTestTest {

    @ParameterizedTest
    @MethodSource("params")
    public void calculation(String expression, double expectedResult) {
        assertEquals(expectedResult, new CalculatorImpl().calculate(expression));
    }

    private static Object[][] params() {
        return new Object[][] {
                {"1+1", 2.0},
                {"1*1", 1.0},
                {"1-1", 0.0},
        };
    }
}
