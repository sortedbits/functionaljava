package com.sortedbits.functionaljava.suppliers;

import java.util.function.Function;

@FunctionalInterface
public interface Supplier<R> extends java.util.function.Supplier<R> {

    R get();

    static <T> Supplier<T> supplier(java.util.function.Supplier<T> s) {
        return s::get;
    }

    static <T, R> Supplier<R> supplier(Function<T, R> f, T x) {
        return () -> f.apply(x);
    }
}
