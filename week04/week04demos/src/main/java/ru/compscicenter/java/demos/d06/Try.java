package ru.compscicenter.java.demos.d06;

public class Try<T> {

    private final T value;
    private final Exception exception;

    private Try(T value) {
        this.value = value;
        this.exception = null;
    }

    private Try(Exception exception) {
        this.value = null;
        this.exception = exception;
    }

    public T getValue() {
        return value;
    }

    public Exception getException() {
        return exception;
    }

    @Override
    public String toString() {
        return "Try{" +
                "value=" + value +
                ", exception=" + exception +
                '}';
    }

    public static <T> Try<T> of(ThrowingSupplier<T, ? extends Exception> supplier) {
        try {
            return new Try<>(supplier.get());
        } catch (Exception e) {
            return new Try<>(e);
        }
    }
}
