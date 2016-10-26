package com.sortedbits.functionaljava.suppliers;

@FunctionalInterface
public interface Supplier<R> extends java.util.function.Supplier<R> {

    R get();

    static <R> Supplier<R> supplier(java.util.function.Supplier<R> s) {
        return s::get;
    }

    static <T, R> Supplier<R> supplier(java.util.function.Function<T, R> f, T x) {
        return () -> f.apply(x);
    }
}
