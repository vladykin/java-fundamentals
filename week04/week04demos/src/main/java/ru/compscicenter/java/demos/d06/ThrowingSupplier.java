package ru.compscicenter.java.demos.d06;

public interface ThrowingSupplier<T, E extends Throwable> {

    T get() throws E;
}
