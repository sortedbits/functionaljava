package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.commons.Arity;
import com.sortedbits.functionaljava.suppliers.Supplier1;

public interface Function extends Arity {

    static <T> Function0<T> function0(Supplier1<T> s) {
        return s::get;
    }

    static <T> Function0<T> function0(java.util.function.Supplier<T> s) {
        return s::get;
    }

    static <T, R> Function1<T, R> function1(java.util.function.Function<T, R> f) {
        return f::apply;
    }

}
