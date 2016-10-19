package com.sortedbits.functionaljava.functions;

public interface Function {

    static <T1, R> Function1<T1, R> function1(java.util.function.Function<T1, R> f) {
        return f::apply;
    }

    int arity();

}
