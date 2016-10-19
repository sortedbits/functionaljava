package com.sortedbits.functionaljava.functions;

import java.util.function.Function;

public class Functions {

    public static <T1, R> Function1<T1, R> function1(Function<T1, R> f) {
        return f::apply;
    }

}
