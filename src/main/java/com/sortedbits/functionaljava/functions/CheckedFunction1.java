package com.sortedbits.functionaljava.functions;

import java.util.function.Consumer;

@FunctionalInterface
public interface CheckedFunction1<T1, R> {

    R apply(T1 x1) throws Exception;

    default Function1<T1, R> unchecked() {
        return unchecked(e -> { throw new UncheckedException(e); });
    }

    default Function1<T1, R> unchecked(Consumer<Exception> handler) {

        return new Function1<T1, R>() {
            @Override
            public R apply(T1 x1) {
                try {
                    return apply(x1);
                } catch (Exception e) {
                    handler.accept(e);
                    return null;
                }
            }
        };
    }

}
