package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.commons.UncheckedException;

@FunctionalInterface
public interface CheckedFunction1<T, R> extends Function {

    R apply(T x1) throws Exception;

    default int arity() {
        return 1;
    }

    default Function1<T, R> unchecked() {
        return x -> {
            try {
                return apply(x);
            } catch (Exception e) {
                throw new UncheckedException(e);
            }
        };
    }
}
