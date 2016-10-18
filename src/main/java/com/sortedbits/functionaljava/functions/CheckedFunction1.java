package com.sortedbits.functionaljava.functions;

import java.util.function.Consumer;

@FunctionalInterface
public interface CheckedFunction1<T1, R> {

    R apply(T1 x1) throws Exception;

    static <T1, R> Function1<T1, R> unchecked() {
        throw new UnsupportedOperationException();
    }

    static <T1, R> Function1<T1, R> unchecked(Consumer<Exception> handler) {
        throw new UnsupportedOperationException();
    }

}
