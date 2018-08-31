package ru.csc.java.testing.calc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.function.DoubleConsumer;
import java.util.stream.Stream;

public class CalculatorCli {

    private final Calculator calculator;

    public CalculatorCli(Calculator calculator) {
        this.calculator = calculator;
    }

    public void runInteractiveSession(Reader reader) {
        runInteractiveSession(reader, System.out::println);
    }

    public void runInteractiveSession(Reader reader, DoubleConsumer resultConsumer) {
        new BufferedReader(reader).lines()
                .flatMap(s -> Stream.of(s.split(";")))
                .filter(s -> !s.trim().isEmpty())
                .mapToDouble(calculator::calculate)
                .forEach(resultConsumer);
    }

    public static void main(String[] args) throws Exception {
        CalculatorCli calculatorCli = new CalculatorCli(new CalculatorImpl());
        try (Reader reader = new InputStreamReader(System.in)) {
            calculatorCli.runInteractiveSession(reader);
        }
    }
}
