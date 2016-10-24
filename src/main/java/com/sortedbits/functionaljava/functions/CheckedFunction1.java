package com.sortedbits.functionaljava.functions;

@FunctionalInterface
public interface CheckedFunction1<T, R> extends Function1<T, R> {

    R applyThrows(T x1) throws Exception;

    default R apply(T x) {
        try {
            return applyThrows(x);
        } catch (Exception e) {
            throw new FunctionException(e);
        }
    }
}