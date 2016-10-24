package com.sortedbits.functionaljava.suppliers;

@FunctionalInterface
public interface Supplier<R> extends java.util.function.Supplier<R> {

    R get();

    static <T> Supplier<T> supplier(java.util.function.Supplier<T> s) {
        return s::get;
    }

}
