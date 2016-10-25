package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.Either;

@FunctionalInterface
public interface SafeFunction1<T, R> {

    Either<Throwable, R> apply(T x);

    static <T, R> Function1<T, Either<Throwable, R>> safe(java.util.function.Function<T, R> f) {
        return (T x) -> {
            try {
                return Either.right(f.apply(x));
            } catch (Throwable error) {
                return Either.left(error);
            }
        };
    }
}
