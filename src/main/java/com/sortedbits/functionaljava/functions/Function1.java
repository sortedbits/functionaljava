package com.sortedbits.functionaljava.functions;

import java.util.function.Function;

@FunctionalInterface
public interface Function1<T1, R> extends Function<T1, R> {

    @Override
    R apply(T1 x1);

}
