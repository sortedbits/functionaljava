package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.commons.UncheckedException;

import java.util.function.Consumer;

@FunctionalInterface
public interface CheckedFunction1<T1, R> extends Function {

    R apply(T1 x1) throws Exception;

    default int arity() {
        return 1;
    }

    default Function1<T1, R> unchecked() {
        return unchecked(error -> { throw new UncheckedException(error); });
    }

    default Function1<T1, R> unchecked(Consumer<Exception> handler) {

        return new Function1<T1, R>() {
            @Override
            public R apply(T1 x1) {
                try {
                    return apply(x1);
                } catch (Exception error) {
                    handler.accept(error);
                    return null;
                }
            }
        };
    }

}
