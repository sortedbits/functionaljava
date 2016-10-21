package com.sortedbits.functionaljava.suppliers;

import com.sortedbits.functionaljava.Arity;
import com.sortedbits.functionaljava.functions.Function0;

public interface Supplier extends Arity {

    static <T> Supplier1<T> supplier1(Function0<T> f) {
        return f::apply;
    }

    static <T> Supplier1<T> supplier1(java.util.function.Supplier<T> s) {
        return s::get;
    }
}