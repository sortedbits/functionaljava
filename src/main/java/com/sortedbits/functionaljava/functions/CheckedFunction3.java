package com.sortedbits.functionaljava.functions;

@FunctionalInterface
public interface CheckedFunction3<T1, T2, T3, R> extends Function3<T1, T2, T3, R> {

    R applyThrows(T1 x1, T2 x2, T3 x3) throws Exception;

    default R apply(T1 x1, T2 x2, T3 x3) {
        try {
            return applyThrows(x1, x2, x3);
        } catch (Exception e) {
            throw new FunctionException(e);
        }
    }
}