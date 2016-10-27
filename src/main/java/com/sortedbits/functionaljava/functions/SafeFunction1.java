package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.Either;
import com.sortedbits.functionaljava.control.Try;

import static com.sortedbits.functionaljava.Either.either;
import static com.sortedbits.functionaljava.suppliers.CheckedSupplier.checkedSupplier;

@FunctionalInterface
public interface SafeFunction1<T, R> extends Function1<T, Either<Throwable, R>> {

    R applyThrows(T x1) throws Exception;

    default Either<Throwable, R> apply(T x) {
        return either(Try.of(checkedSupplier(this::applyThrows, x)));
    }
}
