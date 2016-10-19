package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.suppliers.Supplier1;

import java.util.function.Supplier;

@FunctionalInterface
public interface Function0<T> extends Function {

    T apply();

    default int arity() {
        return 0;
    }

    default Supplier<T> supplier() {
        return this::apply;
    }

    default Supplier1<T> supplier1() {
        return this::apply;
    }

}
