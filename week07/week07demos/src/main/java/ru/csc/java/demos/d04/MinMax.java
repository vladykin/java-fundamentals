package ru.csc.java.demos.d04;

import ru.csc.java.demos.d01.LoremIpsum;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MinMax {

    public static void main(String[] args) {
        try (Stream<String> tokenStream = LoremIpsum.tokens()) {

            Comparator<String> order = String.CASE_INSENSITIVE_ORDER;
            Min<String> min = new Min<>(order);
            Min<String> max = new Min<>(order.reversed());
            tokenStream.forEach(min.andThen(max));

            System.out.printf("Min = %s, max = %s%n",
                    min.asOptional().orElse(null),
                    max.asOptional().orElse(null));
        }
    }
}

class Min<T> implements Consumer<T> {

    private final BinaryOperator<T> minOf;
    private T min;

    public Min(Comparator<? super T> order) {
        this.minOf = BinaryOperator.minBy(order);
    }

    @Override
    public void accept(T t) {
        this.min = min != null ? minOf.apply(min, t) : t;
    }

    public Optional<T> asOptional() {
        return Optional.ofNullable(min);
    }
}
