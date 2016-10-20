package com.sortedbits.functionaljava.suppliers;

import com.sortedbits.functionaljava.functions.Function0;

@FunctionalInterface
public interface Supplier1<T> extends Supplier, java.util.function.Supplier<T> {

    default int arity() {
        return 1;
    }

    default java.util.function.Function<Void, T> function() {
        return x -> get();
    }

    default Function0<T> function0() {
        return this::get;
    }

}
