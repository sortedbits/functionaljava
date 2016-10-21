package com.sortedbits.functionaljava.functions;

@FunctionalInterface
public interface CheckedFunction2<T1, T2, R> extends Function2<T1, T2, R> {

    R applyThrows(T1 x1, T2 x2) throws Exception;

    default R apply(T1 x1, T2 x2) {
        try {
            return applyThrows(x1, x2);
        } catch (Exception e) {
            throw new FunctionException(e);
        }
    }
}