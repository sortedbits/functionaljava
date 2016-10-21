package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.commons.Arity;
import com.sortedbits.functionaljava.suppliers.Supplier1;

public interface Function extends Arity {

    static <R> Function0<R> function0(Supplier1<R> s) {
        return s::get;
    }

    static <R> Function0<R> function0(java.util.function.Supplier<R> s) {
        return s::get;
    }

    static <T> Function1<T, Void> function1(java.util.function.Consumer<T> c) {
        return x -> {
            c.accept(x);
            return null;
        };
    }
    static <T, R> Function1<T, R> function1(java.util.function.Function<T, R> f) {
        return f::apply;
    }



}
