package com.sortedbits.functionaljava.suppliers;

import com.sortedbits.functionaljava.commons.Arity;
import com.sortedbits.functionaljava.functions.Function0;

public interface Supplier extends Arity {

    static <T> Supplier1<T> supplier1(Function0<T> f0) {
        return f0::apply;
    }

    static <T> Supplier1<T> supplier1(java.util.function.Supplier<T> s1) {
        return s1::get;
    }

}