package com.sortedbits.functionaljava;

import java.util.function.Supplier;

public class Lazy<T> implements Supplier<T> {

    private Supplier<T> supplier;
    private T value;

    private Lazy(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public synchronized T get() {
        return (value != null) ? value : supplier.get();
    }

    public static <T> Lazy<T> of(Supplier<T> supplier) {
        return new Lazy<>(supplier);
    }

}
