package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.commons.Arity;
import com.sortedbits.functionaljava.suppliers.Supplier1;

public interface Function extends Arity {

    static <T> Function0<T> function1(Supplier1<T> supplier) {
        return supplier::get;
    };

    static <T1, R> Function1<T1, R> function1(java.util.function.Function<T1, R> f) {
        return f::apply;
    }

}
