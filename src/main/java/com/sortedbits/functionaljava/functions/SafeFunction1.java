package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.Either;
import com.sortedbits.functionaljava.Try;
import com.sortedbits.functionaljava.suppliers.CheckedSupplier;

import static com.sortedbits.functionaljava.Either.either;

@FunctionalInterface
public interface SafeFunction1<T, R> extends Function1<T, Either<Throwable, R>> {

    R applyThrows(T x1) throws Exception;

    default Either<Throwable, R> apply(T x) {
        return either(Try.of(CheckedSupplier.checkedSupplier(this::applyThrows, x)));
    }
}
