package com.sortedbits.functionaljava.functions;

import java.util.function.BiFunction;

import com.sortedbits.functionaljava.Arity;
import com.sortedbits.functionaljava.Either;
import com.sortedbits.functionaljava.Try;
import com.sortedbits.functionaljava.suppliers.Supplier;

import static com.sortedbits.functionaljava.Either.left;
import static com.sortedbits.functionaljava.Either.right;
import static com.sortedbits.functionaljava.Try.getError;
import static com.sortedbits.functionaljava.Try.getValue;

public interface Function extends Arity {

    static <T1, R> Function1<T1, R> function1(java.util.function.Function<T1, R> f) {
        return f::apply;
    }

    static <T1, T2, R> Function2<T1, T2, R> function2(BiFunction<T1, T2, R> f) {
        return f::apply;
    }
}
