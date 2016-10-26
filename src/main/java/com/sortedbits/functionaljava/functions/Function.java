package com.sortedbits.functionaljava.functions;

import java.util.function.BiFunction;

import com.sortedbits.functionaljava.Arity;

public interface Function extends Arity {

    static <T1, R> Function1<T1, R> function1(java.util.function.Function<T1, R> f) {
        return f::apply;
    }

    static <T1, T2, R> Function2<T1, T2, R> function2(BiFunction<T1, T2, R> f) {
        return f::apply;
    }
}
